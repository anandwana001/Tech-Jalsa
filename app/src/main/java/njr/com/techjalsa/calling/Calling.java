package njr.com.techjalsa.calling;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import njr.com.techjalsa.R;

public class Calling extends AppCompatActivity {

    private Toolbar toolbar;
    private List<Volunteer> volunteerList = new ArrayList<>();
    private RecyclerView recyclerView;
    private VolunteerAdapter mVolunteerAdapter;
    private int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calling);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mVolunteerAdapter = new VolunteerAdapter(volunteerList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mVolunteerAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Volunteer volunteer = volunteerList.get(position);
                int permissionCheck = ContextCompat.checkSelfPermission(Calling.this, Manifest.permission.CALL_PHONE);
                if(isCallPermission()){
                    dialNumber(volunteer.getNumber());
                    return;
                }
                requestStoragePermission();
            }
            @Override
            public void onLongClick(View view, int position) {
            }
        }));
        prepareList();
    }

    private boolean isCallPermission() {
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
        if (result == PackageManager.PERMISSION_GRANTED)
            return true;
        return false;
    }
    private void requestStoragePermission(){
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)){
            Toast.makeText(this,"Calling Permission Required",Toast.LENGTH_SHORT).show();
        }
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},MY_PERMISSIONS_REQUEST_CALL_PHONE);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if(requestCode == MY_PERMISSIONS_REQUEST_CALL_PHONE){
            if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                //Displaying a toast
                Toast.makeText(this,"Permission granted now you can Call",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"Oops you just denied the permission",Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void dialNumber(String number){
        Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number.trim()));
        startActivity(callIntent);
    }

    private void prepareList() {
        Volunteer volunteer = new Volunteer(getString(R.string.vol_one_name), getString(R.string.vol_one_no));
        volunteerList.add(volunteer);

        volunteer = new Volunteer(getString(R.string.vol_two), getString(R.string.vol_two_no));
        volunteerList.add(volunteer);

        volunteer = new Volunteer(getString(R.string.vol_three), getString(R.string.vol_three_no));
        volunteerList.add(volunteer);

        volunteer = new Volunteer(getString(R.string.vol_five), getString(R.string.vol_five_no));
        volunteerList.add(volunteer);
        volunteer = new Volunteer(getString(R.string.vol_six), getString(R.string.vol_six_no));
        volunteerList.add(volunteer);
        volunteer = new Volunteer(getString(R.string.vol_sev), getString(R.string.vol_sev_no));
        volunteerList.add(volunteer);
        volunteer = new Volunteer(getString(R.string.vol_egt), getString(R.string.vol_egt_no));
        volunteerList.add(volunteer);
        volunteer = new Volunteer(getString(R.string.vol_nin), getString(R.string.vol_nin_no));
        volunteerList.add(volunteer);
        volunteer = new Volunteer(getString(R.string.vol_ten), getString(R.string.vol_ten_no));
        volunteerList.add(volunteer);

        mVolunteerAdapter.notifyDataSetChanged();
    }
}
