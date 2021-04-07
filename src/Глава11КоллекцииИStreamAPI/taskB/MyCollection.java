package Глава11КоллекцииИStreamAPI.taskB;

import java.util.ArrayList;

/**
 * На базе коллекций реализовать структуру хранения чисел с поддержкой
 * следующих операций:
 * добавление/удаление числа
 * поиск числа, наиболее близкого к заданному (т.е. модуль разницы минимален)
 */
public class MyCollection {
    private static final int MIN_COPACITY = 10;
    private ArrayList<Integer> list = new ArrayList<>(MIN_COPACITY);

    public MyCollection(int copacity) {
        list = new ArrayList<>(copacity);
    }

    public void add(int number) {
        list.add(number);
    }

    public int get(int index) {
        if (index < 0 || index >= list.size()) {
            throw new IllegalArgumentException("index out of bounds");
        }
        return list.get(index);
    }

    public int getSize() {
        return list.size();
    }

    public int remove(int index) {
        if(index < 0 || index >= list.size()) {
            throw new IllegalArgumentException("index out of bounds");
        }
        return list.remove(index);
    }

    public int getCloseNumber(int number) {
        int closeNumber = list.get(0);
        int closeDistance = Math.abs( number - closeNumber);

        for (int i = 1; i < list.size(); i++) {
            if(Math.abs(number - list.get(i)) < closeDistance) {
                closeNumber = get(i);
                closeDistance = Math.abs(number - list.get(i));
            }
        }
        return closeNumber;
    }

    public static void main(String[] args) {
        MyCollection coll = new MyCollection(10);
        coll.add(32);
        coll.add(2);
        coll.add(100);
        coll.add(67);
        coll.add(23);
        System.out.println(coll.getCloseNumber(70));
    }
}
