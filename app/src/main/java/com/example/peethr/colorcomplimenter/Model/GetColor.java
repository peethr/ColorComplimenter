package com.example.peethr.colorcomplimenter.Model;

import android.graphics.Color;

import java.util.Random;

public class GetColor {

    public int returnColor(String color)
    {
        switch (color){
            case "red" : return Color.RED;
            case "green" : return Color.GREEN;
            case "blue" : return Color.BLUE;
            case "black" : return Color.BLACK;
            case "white" : return Color.WHITE;
            case "gray" : return Color.GRAY;
            default: return Color.WHITE;
        }
    }

    public int returnRandomColor()
    {
        int randomNumber;

        Random random = new Random();
        randomNumber = random.nextInt(5);

        switch (randomNumber)
        {
            case 1: return Color.RED;
            case 2 : return Color.GREEN;
            case 3 : return Color.BLUE;
            case 4 : return Color.BLACK;
            case 0 : return Color.WHITE;
            default: return Color.WHITE;
        }

    }
}
