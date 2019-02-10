package org.mobiledevsberkeley.basicsnapchatclone;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final int CAMERA_REQUEST_ID = 42;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takePhotoIntent, CAMERA_REQUEST_ID);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "activity paused!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "activity resumed!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == CAMERA_REQUEST_ID && resultCode == RESULT_OK) {
            Intent intent = new Intent(MainActivity.this, ViewActivity.class);
            EditText editText = findViewById(R.id.editText);
            intent.putExtra("text", editText.getText().toString());
            intent.putExtra("image", (Bitmap) data.getExtras().get("data"));
            startActivity(intent);
        }
    }
}
