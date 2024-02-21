package com.yangcq.lovedsa.class02_arraylist;

public class TestArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();


        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println("list = " + list);

        list.add(1, 11);
        System.out.println("list = " + list);
        list.add(1, 111);
        System.out.println("list = " + list);
        list.add(1, 1111);
        System.out.println("list = " + list);


        System.out.println("list.remove(0) = " + list.remove(0));
        System.out.println("list = " + list);
        System.out.println("list.remove(list.size() - 1) = " + list.remove(list.size() - 1));
        System.out.println("list = " + list);

        System.out.println("list.set(1,123) = " + list.set(1, 123));
        System.out.println("list = " + list);

        System.out.println("list.contains(12) = " + list.contains(12));

        System.out.println("list.indexOf(1111) = " + list.indexOf(1111));


        list.clear();
        System.out.println("-----");

        for (int i = 0; i < 20; i++) {
            list.add(i);
            System.out.println("list = " + list);
        }

    }
}
