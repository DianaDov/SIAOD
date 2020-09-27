package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("\nВведите размер списка номеров: ");
        SecondLinkedList generalList = new SecondLinkedList();
        // заполняем список случайными номерами (либо 7-ми, либо 3-ех значными)
        generalList.fillList(scan.nextInt());
        //  выводим этот список на экран
        generalList.print();
        // строим список,не включая в него номера телефонов спецлужб
        FirstLinkedList subscriberList = generalList.buildList();
        // выводим этот список на экран
        subscriberList.print();
    }
}
