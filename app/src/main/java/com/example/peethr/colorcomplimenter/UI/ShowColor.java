package com.example.peethr.colorcomplimenter.UI;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.peethr.colorcomplimenter.Model.GetColor;
import com.example.peethr.colorcomplimenter.R;

import java.util.Stack;

public class ShowColor extends AppCompatActivity {

    private ConstraintLayout colorComplimenter;
    private Button newColorButton;
    private Button losowyObraz;

    private int backPressedCount = 0;
    private String color;
    private Stack<Integer> stack = new Stack<>();
    private boolean ifColor = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_color);

        colorComplimenter = findViewById(R.id.colorComplimenter);
        newColorButton = findViewById(R.id.newColorButton);
        losowyObraz = findViewById(R.id.losowyObraz);

        Intent intent = getIntent();
        color = intent.getStringExtra("Color");

        final GetColor getColor = new GetColor();
        setColor(getColor.returnColor(color));

        newColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int randomColor = getColor.returnRandomColor();
                setColor(randomColor);
                stack.push(randomColor);
            }
        });

        losowyObraz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowColor.this, LosowyObraz.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);

        Drawable changeColorDrawable = menu.findItem(R.id.changeColor).getIcon();
        changeColorDrawable.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);

        if(ifColor == true)
        {
            menu.setGroupVisible(R.id.changeColorGroup, false);
        } else  menu.setGroupVisible(R.id.changeColorGroup, true);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.red : setColor(Color.RED);
            item.setChecked(true);
            break;
            case R.id.green : setColor(Color.GREEN);
            item.setChecked(true);
            break;
            case R.id.blue : setColor(Color.BLUE);
            item.setChecked(true);
            break;
            case R.id.color : ifColor = !ifColor;
            invalidateOptionsMenu();
            break;
            case R.id.changeColor :
                final GetColor getColor = new GetColor();
                setColor(getColor.returnColor(color));

                int randomColor = getColor.returnRandomColor();
                setColor(randomColor);
                stack.push(randomColor);
                break;
            case R.id.back :
                final GetColor getNewColor = new GetColor();

                if(stack.isEmpty() == false) setColor(stack.pop());
                else setColor(getNewColor.returnColor(color));
               break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        final GetColor getColor = new GetColor();

        if(stack.isEmpty() == false) setColor(stack.pop());
        else setColor(getColor.returnColor(color));

    }

    private void setColor(int color) {
        colorComplimenter.setBackgroundColor(color);
    }
}
