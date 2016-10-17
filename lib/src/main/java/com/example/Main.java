package com.example;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random ra =new Random();
        CustomHashMap map = new CustomHashMap(27);
        for (int i = 0; i < 28; i++) {
            int a = ra.nextInt(100) + 24;
            Item item = new Item();
            item.setKey(a);
            item.setValue(i);
            if (!map.insert(item)) {
                System.out.println("error!");
            }
        }
        map.show();
    }
}
