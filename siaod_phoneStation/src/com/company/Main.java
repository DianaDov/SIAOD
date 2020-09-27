package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LinkedListS list = new LinkedListS();
        //заполняет список 20-ю абонентами и случайными номерами для каждого абонента
        list.fillListAuto();
        // выводим список на экран
        list.print();
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите ФИО для поиска: ");
        String name = scan.nextLine();
        // выполняем поиск фио в нашем списке
        PhonesList phList = list.searchByName(name);
        phList.print();
        System.out.println("Введите номер для поиска: ");
        String number = scan.nextLine();
        System.out.println(list.searchByNumber(number) == null ? "Данного номера в списке не существует" : list.searchByNumber(number));
    }
}
