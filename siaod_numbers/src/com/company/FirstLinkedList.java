package com.company;

// класс однонаправленного списка абонентов
public class FirstLinkedList {
    Node head;

    public class Node {
        String number;
        Node next;
        Node(String n) {
            number = n;
        }
    }

    // добавляем номер абонента в список
    void add(String number) {
        Node new_node = new Node(number);
        if(this.head == null){
            new_node.next = null;
            this.head = new_node;
            return;
        }
        Node currNode = this.head;
        Node prevNode = null;
        while (currNode != null) {
            if(Integer.parseInt (currNode.number) > Integer.parseInt (new_node.number)){
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

    // выводим список номеров абонентов
    void print() {
        System.out.println("Список номеров абонентов: ");
        Node currNode = this.head;
        while (currNode != null) {
            System.out.println(currNode.number);
            currNode = currNode.next;
        }
        System.out.println();
    }

}
