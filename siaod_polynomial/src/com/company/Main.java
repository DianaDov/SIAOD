package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LinkedListP listP = new LinkedListP();
        // составление первого многочлена
        listP.fillList();
        // вывод данного многочлена целиком на экран
        listP.print();

        LinkedListP listQ = new LinkedListP();
        listQ.fillList();
        listQ.print();

        System.out.println(equality(listP,listQ) ? "Многочлены равны" : "Многочлены не равны");

        Scanner scan = new Scanner(System.in);
        System.out.print("Введите X: ");
        int x = scan.nextInt();
        System.out.println("При X=" + x + " мнгочлен равен " + meaning(listP, x));

        System.out.println("Сумма двух многочленов: ");
        add(listP, listQ).print();
    }

    // проверка равенства многочленов p и q
    static boolean equality(LinkedListP p, LinkedListP q){
        if(p.size() == q.size()){
            for(int i = 0; i < p.size(); i++){
                if((p.getByIndex(i).a != q.getByIndex(i).a)||(p.getByIndex(i).n != q.getByIndex(i).n)){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    // вычисление значения многочлена в заданной точке x
    static int meaning(LinkedListP p, int x){
        int meaning = 0;
        for (int i = 0; i < p.size(); i++){
            meaning += p.getByIndex(i).a * Math.pow(x, p.getByIndex(i).n);
        }
        return meaning;
    }

    // вычисление суммы многочленов q и r, результат -- многочлен p
    static LinkedListP add(LinkedListP p, LinkedListP q){
        LinkedListP rez = new LinkedListP();
        int maxN = Math.max(p.maxN(), q.maxN());
        for(int n = maxN; n >= 0; n--){
            int rez_a = p.getByN(n) + q.getByN(n);
            rez.add(n, rez_a);
        }
        return rez;
    }
}

