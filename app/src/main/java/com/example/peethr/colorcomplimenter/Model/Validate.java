package com.example.peethr.colorcomplimenter.Model;

public class Validate {

    public boolean ifValid(String color) {
        return (color.equals("red") || color.equals("green") || color.equals("blue") || color.equals("black") || color.equals("white") || color.equals("gray"));
    }

    public String toLowerCase(String color){
        return color.toLowerCase();
    }
}
