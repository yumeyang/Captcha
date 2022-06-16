package com.solot.hktest;

import android.app.Dialog;
import android.content.Context;

import androidx.annotation.NonNull;

import com.luozm.captcha.Captcha;

public class HKVerifyDialog extends Dialog {

    private Captcha captcha;

    public HKVerifyDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.dialog_hk_verify);
        captcha = (Captcha) findViewById(R.id.captCha);
        captcha.setCaptchaListener(new Captcha.CaptchaListener() {
            @Override
            public String onAccess(long time) {
                return "验证通过";
            }

            @Override
            public String onFailed(int count) {
                return "验证失败";
            }

            @Override
            public String onMaxFailed() {
                return "可以走了";
            }

        });
    }
}
