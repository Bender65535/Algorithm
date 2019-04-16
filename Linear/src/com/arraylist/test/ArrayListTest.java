package com.arraylist.test;

import com.arraylist.ObjectArray;

public class ArrayListTest {
    public static void main(String[] args) {
        ObjectArray objectArray=new ObjectArray();
//        int length =objectArray.size();
        objectArray.add(30);
        objectArray.add(40);
        objectArray.add(323);
        objectArray.add(34);
        objectArray.add(23);
        objectArray.add(351);
        objectArray.show();


        System.out.println();

        objectArray.delete(4);
        objectArray.show();

        System.out.println();
        objectArray.insert(3,111);
        objectArray.show();

    }
}
