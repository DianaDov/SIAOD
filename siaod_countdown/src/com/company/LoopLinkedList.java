package com.company;

public class LoopLinkedList {
    Node head;

    class Node{
        int number;
        Node prev;
        Node next;
        Node(int num){
            number = num;
        }
    }

    void fillList(int amount){
        for (int i = 0; i < amount; i++) {
            this.add(i + 1);
        }
    }

    // добавление эл-та в список
    void add(int number){
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

    // удаление каждого к-ого эл-та
    void remove(int k){
        Node currNode = this.head;
        while(this.size() > 1){
            for(int i = 1; i < k; i++){
                currNode = currNode.next;
            }
            if(currNode == this.head){
                this.head = currNode.next;
            }
            currNode.prev.next = currNode.next;
            currNode.next.prev = currNode.prev;
            currNode = currNode.next;
        }
        System.out.print(this.head.number + " ");
    }

    int size(){
        if(this.head == null)
            return  0;
        Node currNode = this.head;
        int pos = 0;
        do{
            pos++;
            currNode = currNode.next;
        }while (currNode != this.head);
        return pos;
    }

    // удаление каждого к-ого из круга и вывод на экран
    void demonstrate(int k){
        System.out.println("Демонстрация порядка удаления ребят из круга:");
        this.print();
        Node currNode = this.head;
        while(this.size() > 1){
            for(int i = 1; i < k; i++){
                currNode = currNode.next;
            }
            if(currNode == this.head){
                this.head = currNode.next;
            }
            currNode.prev.next = currNode.next;
            currNode.next.prev = currNode.prev;
            currNode = currNode.next;
            this.print();
        }
    }

    void print(){
        if(this.head != null) {
            Node currNode = this.head;
            do {
                System.out.print(currNode.number + " ");
                currNode = currNode.next;
            } while (!currNode.equals(this.head));
        }
        System.out.println();
    }
}

