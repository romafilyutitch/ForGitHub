package Глава11КоллекцииИStreamAPI.taskB;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * В кругу стоят N человек, пронумерованных от 1 до N.
 * При ведении счета по кругу вычеркивается каждый второй человек, пока
 * не останется один.
 * Составить два программы, модерлирующие процесс.
 * Одна из программ должна использовать класс ArrayList, а вторая - LinkedList.
 * Какая из двух программ работает быстрее? Почему?
 */
public class CircleArrayListMain {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        long start = new Date().getTime();
        System.out.println(list);
        while (!list.isEmpty()) {
            int count = 0;
            Iterator<Integer> iter = list.iterator();
            while (iter.hasNext()) {
                iter.next();
                count++;
                if(count == 2) {
                    iter.remove();
                    count = 0;
                }
            }
            System.out.println(list);
            if(list.size() == 1) {
                break;
            }
        }
        long end = new Date().getTime();
        System.out.println("time : " + (end - start));
    }
}
