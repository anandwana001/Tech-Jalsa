package njr.com.techjalsa.game;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import njr.com.techjalsa.R;

/**
 * Created by dell on 19-02-2017.
 */

public class result extends AppCompatActivity {

    private TextView scoreLabel;
    private TextView highScoreLabel;
    private int score;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        scoreLabel = (TextView) findViewById(R.id.scoreLabel);
        highScoreLabel = (TextView) findViewById(R.id.highScoreLabel);

        score = getIntent().getIntExtra(getString(R.string.score), 0);
        scoreLabel.setText(score + "");

        SharedPreferences settings = getSharedPreferences(getString(R.string.high_score), Context.MODE_PRIVATE);
        int highScore = settings.getInt(getString(R.string.high_score), 0);

        if (score > highScore) {
            highScoreLabel.setText(getString(R.string.high_score) + score);
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt(getString(R.string.high_score), score);
            editor.commit();
        } else {
            highScoreLabel.setText(getString(R.string.high_score) + highScore);
        }
    }
    public void tryAgain(View view) {
        startActivity(new Intent(getApplicationContext(), start.class));
        finish();
    }
}
