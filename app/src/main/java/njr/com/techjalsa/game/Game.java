package njr.com.techjalsa.game;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import njr.com.techjalsa.R;

/**
 * Created by dell on 19-02-2017.
 */

public class Game extends AppCompatActivity {

    private TextView scoreLabel;
    private TextView startLabel;
    private ImageView box;
    private ImageView orange;
    private ImageView pink;
    private ImageView black;

    private int frameHeight;
    private int boxSize;
    private int screenWidth;
    private int screenHeight;

    private int boxY;
    private int orangeX;
    private int orangeY;
    private int pinkX;
    private int pinkY;
    private int blackX;
    private int blackY;

    private int boxSpeed;
    private int orangeSpeed;
    private int pinkSpeed;
    private int blackSpeed;

    private int score = 0;

    private Handler handler = new Handler();
    private Timer timer = new Timer();
    private SoundPlayer sound;

    private boolean action_flg = false;
    private boolean start_flg = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);
        sound = new SoundPlayer(this);
        init();
        initGame();
    }

    private void initGame() {
        WindowManager wm = getWindowManager();
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;
        // Now
        // Nexus4 Width: 768 Height:1280
        // Speed Box:20 Orange:12 Pink:20 Black:16
        boxSpeed = Math.round(screenHeight / 60);  // 1280 / 60 = 21.333... => 21
        orangeSpeed = Math.round(screenWidth / 60); // 768 / 60 = 12.8 => 13
        pinkSpeed = Math.round(screenWidth / 36);   // 768 / 36 = 21.333... => 21
        blackSpeed = Math.round(screenWidth / 45); // 768 / 45 = 17.06... => 17
        // Move to out of screen.
        orange.setX(-80);
        orange.setY(-80);
        pink.setX(-80);
        pink.setY(-80);
        black.setX(-80);
        black.setY(-80);
        scoreLabel.setText(getString(R.string.score)+score);
    }

    private void init() {
        scoreLabel = (TextView) findViewById(R.id.scoreLabel);
        startLabel = (TextView) findViewById(R.id.startLabel);
        box = (ImageView) findViewById(R.id.box);
        orange = (ImageView) findViewById(R.id.orange);
        pink = (ImageView) findViewById(R.id.pink);
        black = (ImageView) findViewById(R.id.black);
    }

    public void changePos() {
        hitCheck();

        orangeX -= orangeSpeed;
        if (orangeX < 0) {
            orangeX = screenWidth + 20;
            orangeY = (int) Math.floor(Math.random() * (frameHeight - orange.getHeight()));
        }
        orange.setX(orangeX);
        orange.setY(orangeY);
        blackX -= blackSpeed;
        if (blackX < 0) {
            blackX = screenWidth + 10;
            blackY = (int) Math.floor(Math.random() * (frameHeight - black.getHeight()));
        }
        black.setX(blackX);
        black.setY(blackY);
        pinkX -= pinkSpeed;
        if (pinkX < 0) {
            pinkX = screenWidth + 5000;
            pinkY = (int) Math.floor(Math.random() * (frameHeight - pink.getHeight()));
        }
        pink.setX(pinkX);
        pink.setY(pinkY);
        // Move Box
        if (action_flg == true) {
            // Touching
            boxY -= boxSpeed;
        } else {
            // Releasing
            boxY += boxSpeed;
        }
        // Check box position.
        if (boxY < 0) boxY = 0;
        if (boxY > frameHeight - boxSize) boxY = frameHeight - boxSize;
        box.setY(boxY);
        scoreLabel.setText(getString(R.string.score) + score);
    }

    public void hitCheck() {
        // If the center of the ball is in the box, it counts as a hit.
        int orangeCenterX = orangeX + orange.getWidth() / 2;
        int orangeCenterY = orangeY + orange.getHeight() / 2;
        // 0 <= orangeCenterX <= boxWidth
        // boxY <= orangeCenterY <= boxY + boxHeight
        if (0 <= orangeCenterX && orangeCenterX <= boxSize &&
                boxY <= orangeCenterY && orangeCenterY <= boxY + boxSize) {
            score += 5;
            orangeX = -10;
            sound.playHitSound();
        }
        int pinkCenterX = pinkX + pink.getWidth() / 2;
        int pinkCenterY = pinkY + pink.getHeight() / 2;
        if (0 <= pinkCenterX && pinkCenterX <= boxSize &&
                boxY <= pinkCenterY && pinkCenterY <= boxY + boxSize) {
            score += 10;
            pinkX = -10;
            sound.playHitSound();
        }
        int blackCenterX = blackX + black.getWidth() / 2;
        int blackCenterY = blackY + black.getHeight() / 2;
        if (0 <= blackCenterX && blackCenterX <= boxSize &&
                boxY <= blackCenterY && blackCenterY <= boxY + boxSize) {
            // Stop Timer!!
            timer.cancel();
            timer = null;
            sound.playOverSound();
            // Show Result
            Intent intent = new Intent(getApplicationContext(), result.class);
            intent.putExtra(getString(R.string.score), score);
            startActivity(intent);
            finish();
        }
    }

    public boolean onTouchEvent(MotionEvent me) {
        if (start_flg == false) {
            start_flg = true;
            // Why get frame height and box height here?
            // Because the UI has not been set on the screen in OnCreate()!!
            FrameLayout frame = (FrameLayout) findViewById(R.id.frame);
            frameHeight = frame.getHeight();
            boxY = (int)box.getY();
            // The box is a square.(height and width are the same.)
            boxSize = box.getHeight();
            startLabel.setVisibility(View.GONE);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            changePos();
                        }
                    });
                }
            }, 0, 20);
        } else {
            if (me.getAction() == MotionEvent.ACTION_DOWN) {
                action_flg = true;
            } else if (me.getAction() == MotionEvent.ACTION_UP) {
                action_flg = false;
            }
        }
        return true;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if(event.getAction() == KeyEvent.ACTION_DOWN){
            switch (event.getKeyCode()){
                case KeyEvent.KEYCODE_BACK:
                    timer.cancel();
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setCancelable(false);
                    builder.setMessage("Do you want to End Game?");
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            timer = null;
                            sound.playOverSound();
                            Intent intent = new Intent(getApplicationContext(), result.class);
                            intent.putExtra(getString(R.string.score), score);
                            startActivity(intent);
                            finish();
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                            timer = new Timer();
                            if(startLabel.getVisibility() == View.VISIBLE){

                            }else{
                                timer.schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        handler.post(new Runnable() {
                                            @Override
                                            public void run() {
                                                changePos();
                                            }
                                        });
                                    }
                                }, 0, 20);
                            }
                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.show();
                    return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }
}

