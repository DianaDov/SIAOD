package com.company;

import java.util.Scanner;

public class LinkedListP {
    Node head;

    // класс звена списка многочленов
    public class Node {
        int n;
        int a;
        Node next;

        Node(int N, int A) {
            n = N;
            a = A;
        }
    }

    // составление многочлена (считывание кол-ва членов и коэффициентов)
    void fillList() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите кол-во членов: ");
        for (int n = scan.nextInt() - 1; n >= 0; n--) {
            System.out.print("Введите коэффициент при X^" + n + ": ");
            this.add(n, scan.nextInt());
        }
    }

    // добавление нового члена к списку многочлена
    void add(int n, int a) {
        if (a != 0) {
            Node new_node = new Node(n, a);
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
    }

    // определение размера многочлена
    int size(){
        Node currNode = this.head;
        int pos = 0;
        while (currNode != null) {
            pos++;
            currNode = currNode.next;
        }
        return pos;
    }

    // вывод многочлена целиком
    void print() {
        System.out.print("P(x)= ");
        Node currNode = this.head;
        while (currNode != null) {
            System.out.print(currNode.next == null ? currNode.a + "X^" + currNode.n : currNode.a + "X^" + currNode.n + " + ");
            currNode = currNode.next;
        }
        System.out.println();
    }

    // поиск максимальной степни
    int maxN(){
        if(this.head != null)
            return this.head.n;
        return -1;
    }

    // поиск члена по его порядку(степени)
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

    // поиск коэффициента по его порядку(степени)
    int getByN(int n){
        for(int i=0; i<this.size();i++){
            if(this.getByIndex(i).n == n){
                return this.getByIndex(i).a;
            }
        }
        return 0;
    }

}

