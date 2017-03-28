package com.example.lzx.upfile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class BitmapUtil {
	
	private Context context;
	
	public BitmapUtil(Context context){
		this.context = context;
	}
	
	public Bitmap toRoundBitmap(Bitmap bitmap) {
	    int width = bitmap.getWidth();
	    int height = bitmap.getHeight();
	    float roundPx;
	    float left, top, right, bottom, dst_left, dst_top, dst_right, dst_bottom;
	    if (width <= height) {
	        roundPx = width / 2;
	        top = 0;
	        bottom = width;
	        left = 0;
	        right = width;
	        height = width;
	        dst_left = 0;
	        dst_top = 0;
	        dst_right = width;
	        dst_bottom = width;
	    } else {
	        roundPx = height / 2;
	        float clip = (width - height) / 2;
	        left = clip;
	        right = width - clip;
	        top = 0;
	        bottom = height;
	        width = height;
	        dst_left = 0;
	        dst_top = 0;
	        dst_right = height;
	        dst_bottom = height;
	    }
	    Bitmap output = Bitmap.createBitmap(width,
	                                        height, Config.ARGB_8888);
	    Canvas canvas = new Canvas(output);
	    final int color = 0xff424242;
	    final Paint paint = new Paint();
	    final Rect src = new Rect((int)left, (int)top, (int)right, (int)bottom);
	    final Rect dst = new Rect((int)dst_left, (int)dst_top, (int)dst_right, (int)dst_bottom);
	    final RectF rectF = new RectF(dst);
	    paint.setAntiAlias(true);
	    canvas.drawARGB(0, 0, 0, 0);
	    paint.setColor(color);
	    canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
	    paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
	    canvas.drawBitmap(bitmap, src, dst, paint);
	    return output;
	}
}
