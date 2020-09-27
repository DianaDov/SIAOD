package com.company;

import java.util.Random;
import java.util.Scanner;

public class LinkedListS {
    Node head;

    public class Node {
        String name;
        String number;
        Node next;

        Node(String n, String ph) {
            name = n;
            number = ph;
        }
    }

    void fillListAuto() {
        Random rnd = new Random();
        String[] names = {"Шарова Юзефа Игнатьевна", "Иванова Доля Богуславовна", "Гаврилова Рамина Митрофановна",
                "Блинова Вера Филатовна", "Авдеева Эльга Алексеевна", "Бурова Герда Львовна",
                "Воронова Марфа Всеволодовна", "Рябова Элла Тимуровна", "Быкова Олеся Авксентьевна",
                "Абрамова Зара Артёмовна", "Жданов Панкрат Тарасович", "Александров Зиновий Куприянович",
                "Давыдов Артур Лаврентьевич", "Ковалёв Роман Протасьевич", "Федотов Альфред Михаилович",
                "Романов Гордей Ефимович", "Михайлов Лукьян Митрофанович",
                "Лаврентьев Рудольф Еремеевич", "Одинцов Илларион Матвеевич", "Мясников Гавриил Тарасович"};
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 20; i++) {
            String name = names[i];
            String number = "";
            for(int k = 0; k < 7; k++){
                number += Integer.toString(rnd.nextInt(10));
            }
            // добавляем абонента с номером в список
            this.add(name, number);
        }
    }

    //  добавление эл-та в список
    void add(String name, String number) {
        Node new_node = new Node(name, number);
        if(this.head == null){
            new_node.next = null;
            this.head = new_node;
            return;
        }
        Node currNode = this.head;
        Node prevNode = null;
        while (currNode != null) {
            if(compareStrings(currNode.name, name)){
                break;
            }
            prevNode = currNode;
            currNode = currNode.next;
        }
        if(prevNode == null){
            new_node.next = currNode;
            this.head = new_node;
            return;
        }
        prevNode.next = new_node;
        new_node.next = currNode;
    }

    // вывод абонентов с их номерами на экран
    void print() {
        Node currNode = this.head;
        while (currNode != null) {
            System.out.print("\nФИО: " + currNode.name + " ; Номер: " + currNode.number);
            currNode = currNode.next;
        }
        System.out.println();
    }

    // определение длины списка
    int size(){
        Node currNode = this.head;
        int pos = 0;
        while (currNode != null) {
            pos++;
            currNode = currNode.next;
        }
        return pos;
    }

    // поиск абонента по индексу
    Node getByIndex(int index){
        Node currNode = this.head;
        int pos = 0;
        while ((pos != index)&&(currNode != null)) {
            pos++;
            currNode = currNode.next;
        }
        if(currNode!=null){return currNode;}
        throw new IndexOutOfBoundsException();
    }

    // метод сравнения 2-ух строк
    boolean compareStrings(String str1, String str2){
        int min = Math.min(str1.length(), str2.length());
        for(int i = 0; i < min; i++){
            if(str1.charAt(i) > str2.charAt(i)){
                return true;
            }
            if(str1.charAt(i) < str2.charAt(i)){
                return false;
            }
        }
        return true;
    }

    // поиск по нужному фио
    PhonesList searchByName(String name){
        boolean found = false;
        PhonesList phList = new PhonesList();
        for (int i = 0; i < this.size(); i++) {
            if (this.getByIndex(i).name.equals(name.strip())) {
                phList.add(this.getByIndex(i).number);
                found = true;
            }
        }
        if(!found){
            System.out.println("Данного имени в списке не существует");
        }
        return phList;
    }

    // поиск абонента по номеру телефона
    String searchByNumber(String number) {
        for (int i = 0; i < this.size(); i++) {
            if (this.getByIndex(i).number.equals(number.strip())) {
                return this.getByIndex(i).name;
            }
        }
        return null;
    }
}
