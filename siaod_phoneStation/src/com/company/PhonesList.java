package com.company;

public class PhonesList {
    Node head;

    class Node {
        String number;
        Node next;

        Node(String n) {
            number = n;
        }
    }

    // добавляем номер телефона
    public void add(String number) {
        Node new_node = new Node(number);
        new_node.next = null;
        if (this.head == null) {
            this.head = new_node;
        } else {
            Node last = this.head;
            while (last.next != null) {
                last = last.next;
            }

            last.next = new_node;
        }
    }

    public void print() {
        Node currNode = this.head;
        while (currNode != null) {
            System.out.print("Номер: ");
            System.out.print(currNode.number + "\n");
            currNode = currNode.next;
        }
    }
}

