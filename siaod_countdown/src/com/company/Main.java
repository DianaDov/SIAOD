package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("\nПрограмма удаляет каждого к-ого. Введите k: ");
        int k = scan.nextInt();
        LoopLinkedList demoList = new LoopLinkedList();
        System.out.print("\nВведите количество ребят: ");
        demoList.fillList(scan.nextInt());
        // удаление каждого к-ого из круга
        demoList.demonstrate(k);

        System.out.println("Таблица оставшихся ребят (для значений N от 1 до 64):");
        for(int n = 1; n <= 64; n++){
            System.out.print("N=" + n + "  ");
            LoopLinkedList list =new LoopLinkedList();
            list.fillList(n);
            list.remove(k);
            System.out.print("\n");
        }
    }
}
