package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        dictionary.fill();
        Scanner scan = new Scanner(System.in);
        // переменная для выхода из программы
        boolean escape = false;

        while(!escape){
            System.out.println("\nМеню:\nПоказать словарь - 1\nПоиск - 2\nВставить - 3\n" +
                    "Удалить - 4\nЗавершить работу - 5\n");
            switch (scan.nextInt()){
                case 1:
                    dictionary.print();
                    break;
                case 2:
                    dictionary.search();
                    break;
                case 3:
                    dictionary.add();
                    break;
                case 4:
                    dictionary.remove();
                    break;
                case 5:
                    escape = true;
            }
        }
    }
}
