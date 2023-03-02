package com.example.kartkowka_grupa1_recyclerview;

import java.util.ArrayList;

public class Product {
    private String name;
    private boolean isTextFlag;

    public static ArrayList<Product> products = new ArrayList<Product>()
    {{
        add(new Product("yyy"));
        add(new Product("aaa"));
        add(new Product("xxx"));
        add(new Product("bbb"));
        add(new Product("ppp"));
        add(new Product("yyy"));
        add(new Product("qqqq"));
        add(new Product("uuuuu"));
    }};

    public Product(String name) {
        this.name = name;
        this.isTextFlag = false;
    }

    public String getName() {
        return name;
    }

    public boolean isTextFlag() {
        return isTextFlag;
    }

    public void setTextFlag(boolean textFlag) {
        isTextFlag = textFlag;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
