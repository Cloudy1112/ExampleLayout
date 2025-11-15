package com.example.examplelayout;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

public class ImageConverter {

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int pixels) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        // Màu 0xff424242 chỉ là màu tạm, nó sẽ bị ảnh trong suốt đè lên
        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        final float roundPx = pixels;

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0); // Vẽ nền trong suốt
        paint.setColor(color);

        // Vẽ "khuôn" bo tròn
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

        // Đặt chế độ "chỉ vẽ bên trong khuôn"
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        // Vẽ ảnh gốc vào khuôn
        canvas.drawBitmap(bitmap, rect, rect, paint);

        return output;
    }
}
