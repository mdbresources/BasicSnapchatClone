package org.mobiledevsberkeley.basicsnapchatclone;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        String text = getIntent().getStringExtra("text");

        // a bitmap extends the parcelable class, and java 8 will auto cast to bitmap in this line
        Bitmap bitmap = getIntent().getParcelableExtra("image");

        TextView caption = findViewById(R.id.caption);
        ImageView imageView = findViewById(R.id.imageView);

        imageView.setImageBitmap(bitmap);
        caption.setText(text);
    }
}
