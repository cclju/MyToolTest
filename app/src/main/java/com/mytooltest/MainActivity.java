package com.mytooltest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.mytooltest.anim.AnimActivity;
import com.mytooltest.banner.BannerActivity;
import com.mytooltest.canvas.CanvasXfermodeActivity;
import com.mytooltest.circleprogress.CircleProgressActivity;
import com.mytooltest.encryption.DTUploadCreditCardPhotoCmd;
import com.mytooltest.encryption.UploadCreditCardPhotoTask;
import com.mytooltest.gausblur.GausBlurActivity;
import com.mytooltest.guide.GuideActivity;
import com.mytooltest.marquee.UPMarqueeActivity;
import com.mytooltest.marquee.recycler.AutoPollActivity;
import com.mytooltest.screenshot.ScreenShotActivity;
import com.mytooltest.tab.TabActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.btn_banner).setOnClickListener(this);

        findViewById(R.id.btn_tab).setOnClickListener(this);

        findViewById(R.id.btn_upmarquee).setOnClickListener(this);

        findViewById(R.id.btn_upmarquee_recycler).setOnClickListener(this);


        findViewById(R.id.btn_circle_progress).setOnClickListener(this);

        findViewById(R.id.btn_gaus_blur).setOnClickListener(this);

        findViewById(R.id.btn_anim).setOnClickListener(this);

        findViewById(R.id.btn_screenshot).setOnClickListener(this);

        findViewById(R.id.btn_xfermode).setOnClickListener(this);

        findViewById(R.id.btn_guide).setOnClickListener(this);



//        findViewById(R.id.btn_submit).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                uploadCreditCardPhoto();
//            }
//        });
//
//        SDCardUtil.createFile2SDCard();


//        String dtStart = "2018-04-20 10:00:30";
//
//        String dtEnd   = "2018-04-19 09:00:40";
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        try {
//            Date dateStart = format.parse(dtStart);
//            Date dateEnd = format.parse(dtEnd);
//
//            int gapDay = ToolsForTime.getGapCount(dateStart.getTime(), dateEnd.getTime());
//            System.out.println("gap day: " + gapDay);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }



    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        switch (id) {

            case R.id.btn_banner:

                this.startActivity(new Intent(MainActivity.this, BannerActivity.class));
                break;
            case R.id.btn_tab:

                this.startActivity(new Intent(MainActivity.this, TabActivity.class));
                break;
            case R.id.btn_upmarquee:

                this.startActivity(new Intent(MainActivity.this, UPMarqueeActivity.class));
                break;
            case R.id.btn_upmarquee_recycler:

                this.startActivity(new Intent(MainActivity.this, AutoPollActivity.class));
                break;
            case R.id.btn_circle_progress:

                this.startActivity(new Intent(MainActivity.this, CircleProgressActivity.class));
                break;
            case R.id.btn_gaus_blur:

                this.startActivity(new Intent(MainActivity.this, GausBlurActivity.class));
                break;
            case R.id.btn_anim:

                this.startActivity(new Intent(MainActivity.this, AnimActivity.class));
                break;
            case R.id.btn_screenshot:

                this.startActivity(new Intent(MainActivity.this, ScreenShotActivity.class));
                break;
            case R.id.btn_xfermode:

                this.startActivity(new Intent(MainActivity.this, CanvasXfermodeActivity.class));
                break;
            case R.id.btn_guide:

                this.startActivity(new Intent(MainActivity.this, GuideActivity.class));
                break;

        }
    }

    private void compressImage() {

        byte[] mPhoto = null;

    }

    public void uploadCreditCardPhoto() {
        Log.i(TAG, "Credit Card Optimize, uploadCreditCardPhoto");


        DTUploadCreditCardPhotoCmd cmd = new DTUploadCreditCardPhotoCmd();

//        cmd.time = "" + System.currentTimeMillis();
        cmd.time = "1514298066966";
        String creditCardInfo = "411111XXXXXX1111" + "_" + cmd.time;
        String backInfo = creditCardInfo; // TODO jarvis base64

        cmd.appName = "TalkU";
        cmd.deviceId = "And.0e20f3310ada38cd9b6ece7d04f151ca.dttalk";
        cmd.userId = "7182012637234297";


        cmd.pstage = 2;
        cmd.numPart = "411111XXXXXX1111";
        cmd.backInfo = backInfo;
        cmd.fileUrl = "";

        // default
        cmd.fileType = "jpg";
        cmd.keyId = 0;

        String creditCardKey = String.format("%s_%s_%s_%s_%s.%s",
                cmd.userId, cmd.deviceId, cmd.keyId, cmd.time, "411111", cmd.fileType);
        cmd.creditCardKey = creditCardKey;

        UploadCreditCardPhotoTask task = new UploadCreditCardPhotoTask(cmd);
        task.execute();
    }



}
