package com.example;

/**
 * Created by LXChild on 17/10/2016.
 */

public final class CustomHashMap {
    private Item[] arr;
    public CustomHashMap(int size) {
        arr = new Item[size];
    }

    private int hash(int key) {
        return key % arr.length;
    }

    public boolean insert(Item item) {
        int key = item.getKey();
        int hashCode = hash(key);
        int current = hashCode;
        //若已存在同样的数据，则向下进一位，直到找到空的位置
        //为了简单，也可要求不准有重复数据
        while (arr[hashCode] != null) {
            hashCode++;
            if (hashCode == current) {
                return false;
            }
            if (hashCode == arr.length) {
                hashCode = 0;
            }
        }
        arr[hashCode] = item;
        return true;
    }

    public Item delete(int key) {
        int hashCode = hash(key);
        while (arr[hashCode] != null) {
            if (arr[hashCode].getKey() == key) {
                Item item = arr[hashCode];
                arr[hashCode] = null;
                return item;
            }
            hashCode++;
            if (hashCode == arr.length) {
                hashCode = 0;
            }
        }
        return null;
    }

    public Item find(int key) {
        int hashCode = hash(key);
        while (arr[hashCode] != null) {
            if (arr[hashCode].getKey() == key) {
                return arr[hashCode];
            }
            hashCode++;
            if (hashCode == arr.length) {
                hashCode = 0;
            }
        }
        return null;
    }

    public void show() {
        for (Item i :
                arr) {
            System.out.println(i.getKey());
        }
    }
}
