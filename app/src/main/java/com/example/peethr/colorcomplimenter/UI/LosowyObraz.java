package com.example.peethr.colorcomplimenter.UI;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.peethr.colorcomplimenter.Model.GetRandomImage;
import com.example.peethr.colorcomplimenter.R;

public class LosowyObraz extends AppCompatActivity {

    private Button losujObraz;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_losowy_obraz);

        losujObraz = findViewById(R.id.losujObraz);
        imageView = findViewById(R.id.imageView);

        losujObraz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetRandomImage getRandomImage = new GetRandomImage();
                imageView.setImageResource(getRandomImage.getRandomImage());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.losowy_obraz_menu, menu);

        Drawable drawable = menu.findItem(R.id.newImage).getIcon();
        drawable.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);



        return super.onCreateOptionsMenu(menu);
    }
}
