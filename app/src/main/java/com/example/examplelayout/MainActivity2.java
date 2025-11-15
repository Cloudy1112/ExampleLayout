package com.example.examplelayout;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        // 1. Tìm ImageView của bạn
        ImageView avatarImageView = findViewById(R.id.image_avatar);

        // 2. Lấy ảnh gốc (hình chữ nhật) từ drawable
        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pro_trung);

        // 3. Gọi hàm ImageConverter để tạo ảnh tròn
        // Vì ảnh của bạn 60dp, bán kính 30 (một nửa) sẽ làm nó tròn
        Bitmap roundedBitmap = ImageConverter.getRoundedCornerBitmap(originalBitmap, 60);

        // 4. Đặt ảnh ĐÃ BO TRÒN vào ImageView
        avatarImageView.setImageBitmap(roundedBitmap);

    }
}

