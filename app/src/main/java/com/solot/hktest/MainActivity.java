package com.solot.hktest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.luozm.captcha.Captcha;

public class MainActivity extends AppCompatActivity {

    private Captcha captcha;
    private Button btnMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        captcha = (Captcha) findViewById(R.id.captCha);
        btnMode = (Button) findViewById(R.id.btn_mode);
        btnMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HKVerifyDialog dialog=new HKVerifyDialog(MainActivity.this);
                dialog.show();

                if (captcha.getMode() == Captcha.MODE_BAR) {
                    captcha.setMode(Captcha.MODE_NONBAR);
                    btnMode.setText("滑动条模式");
                } else {
                    captcha.setMode(Captcha.MODE_BAR);
                    btnMode.setText("无滑动条模式");
                }
            }
        });
        captcha.setCaptchaListener(new Captcha.CaptchaListener() {
            @Override
            public String onAccess(long time) {
                Toast.makeText(MainActivity.this, "验证成功", Toast.LENGTH_SHORT).show();
                return "验证通过";
            }

            @Override
            public String onFailed(int count) {
                Toast.makeText(MainActivity.this, "验证失败,失败次数" + count, Toast.LENGTH_SHORT).show();
                return "验证失败";
            }

            @Override
            public String onMaxFailed() {
                Toast.makeText(MainActivity.this, "验证超过次数，你的帐号被封锁", Toast.LENGTH_SHORT).show();
                return "可以走了";
            }

        });
    }


    boolean isCat = true;
    public void changePicture(View view){
        if(isCat){
            captcha.setBitmap("http://img4.imgtn.bdimg.com/it/u=2091068830,1003707060&fm=200&gp=0.jpg");
        }else{
            captcha.setBitmap(com.luozm.captcha.R.mipmap.cat);
        }
        isCat=!isCat;
    }

    boolean isSeekbar1 = false;
    public void changeProgressDrawable(View view){
        if(isSeekbar1){
            captcha.setSeekBarStyle(com.luozm.captcha.R.drawable.po_seekbar,com.luozm.captcha.R.drawable.thumb);
        }else{
            captcha.setSeekBarStyle(R.drawable.po_seekbar1,R.drawable.thumb1);
        }
        isSeekbar1=!isSeekbar1;
    }
}
