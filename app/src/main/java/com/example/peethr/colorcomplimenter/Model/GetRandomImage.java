package com.example.peethr.colorcomplimenter.Model;

import android.graphics.drawable.Drawable;

import com.example.peethr.colorcomplimenter.R;

import java.util.Random;

public class GetRandomImage {
    private int getRandom(){
        Random random = new Random();
        return random.nextInt(3);
    }

    private int chooseImage(int random){

        switch (random){
            case 0 :
                return R.drawable.ic_autorenew_black_24dp;
            case 1 :
                return  R.drawable.ic_launcher_background;
            case 2 :
                return R.drawable.ic_launcher_foreground;
            default: return 0;
        }
    }

    public int getRandomImage(){
        return chooseImage(getRandom());
    }
}
