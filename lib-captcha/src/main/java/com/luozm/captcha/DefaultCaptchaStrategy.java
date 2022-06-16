package com.luozm.captcha;

import android.content.Context;
import android.graphics.Paint;

/**
 * 默认CaptchaStrategy
 * Created by luozhanming on 2018/1/19.
 */

public class DefaultCaptchaStrategy extends CaptchaStrategy {

    public DefaultCaptchaStrategy(Context ctx) {
        super(ctx);
    }


    @Override
    public Paint getBlockBitmapPaint() {
        return new Paint();
    }
}
