package com.company;
import java.util.Random;

// класс двунаправленного списка всех номеров
public class SecondLinkedList {
    Node head;

    class Node{
        String number;
        Node prev;
        Node next;
        Node(String num){
            number = num;
        }
    }

    // заполняем список случайными номерами
    void fillList(int amount){
        for (int i = 0; i < amount; i++) {
            String number = "";
            Random rnd = new Random();
            if(rnd.nextInt(2) == 0){
                for(int j = 0; j < 7; j++){
                    number += Integer.toString(rnd.nextInt(10));
                }
            }else{
                for(int j = 0; j < 3; j++){
                    number += Integer.toString(rnd.nextInt(10));
                }
            }
            this.add(number);
        }
    }

    // добавляем номер в двунаправленный список
    void add(String number){
        Node new_node = new Node(number);
        if(this.head == null){
            this.head = new_node;
            this.head.next = this.head;
            this.head.prev = this.head;
        }else{
            new_node.prev = this.head.prev;
            this.head.prev.next = new_node;
            this.head.prev = new_node;
            new_node.next = this.head;
        }
    }

    // выводим на экран общий двунаправленный список
    void print(){
        System.out.println("Общий список номеров телефонов: "+
                "\n(семизначные--абонентов,трёхзначные--спецслужб)");
        if(this.head != null) {
            Node currNode = this.head;
            do {
                System.out.println(currNode.number);
                currNode = currNode.next;
            } while (!currNode.equals(this.head));
        }
    }

    // просматривая список справа налево и строим упорядоченный однонаправленный список
    FirstLinkedList buildList(){
        FirstLinkedList list = new FirstLinkedList();
        if(this.head != null){
            Node currNode = this.head.prev;
            do{
                if(currNode.number.length() == 7){
                    list.add(currNode.number);
                }
                currNode = currNode.prev;
            }while (currNode != this.head.prev);
        }
        return  list;
    }
}