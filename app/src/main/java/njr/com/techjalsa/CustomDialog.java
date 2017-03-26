package njr.com.techjalsa;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by dell on 02-03-2017.
 */

public class CustomDialog extends Dialog implements android.view.View.OnClickListener {

    private Button no;
    private TextView textView;
    private String des;

    public CustomDialog(Activity a,String des) {
        super(a);
        this.des = des;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog);
        no = (Button) findViewById(R.id.close);
        textView = (TextView) findViewById(R.id.event_des);
        textView.setText(des);
        no.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.close:
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }
}
