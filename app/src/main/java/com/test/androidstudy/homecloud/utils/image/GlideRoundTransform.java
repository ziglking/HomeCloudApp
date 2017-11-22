package com.test.androidstudy.homecloud.utils.image;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

/**
 * Created by zyl06 on 9/4/16.
 */

public class GlideRoundTransform extends BitmapTransformation {

    private float mRadius = 0.f;

    public GlideRoundTransform(Context context, float radiusDp) {
        super(context);
        mRadius = Resources.getSystem().getDisplayMetrics().density * radiusDp;
    }

    @Override
    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        if (toTransform == null) {
            return null;
        }

        Bitmap result = pool.get(toTransform.getWidth(), toTransform.getHeight(), Bitmap.Config.ARGB_8888);
        if (result == null) {
            result = Bitmap.createBitmap(toTransform.getWidth(), toTransform.getHeight(), Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(new BitmapShader(toTransform, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
        RectF rect = new RectF(0, 0, toTransform.getWidth(), toTransform.getHeight());
        canvas.drawRoundRect(rect, mRadius, mRadius, paint);
        return result;
    }

    @Override
    public String getId() {
        return "GlideRoundTransform: " + mRadius;
    }
}
