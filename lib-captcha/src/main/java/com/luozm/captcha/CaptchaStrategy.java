package com.luozm.captcha;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

/**
 * Captcha的拼图区域策咯
 * Created by luozhanming on 2018/1/19.
 */

public abstract class CaptchaStrategy {

    protected Context mContext;

    public CaptchaStrategy(Context ctx) {
        this.mContext = ctx;
    }

    protected Context getContext() {
        return mContext;
    }

    /**
     * 获得滑块图片的Paint
     */
    public abstract Paint getBlockBitmapPaint();
}
