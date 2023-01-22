/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semestralniprace;

/**
 * 5. Program gets new values and inserts them to Array in ascending order
 * @author matej
 */

import java.util.Scanner;

public class Tools {
    static Scanner sc = new Scanner(System.in);

    public static int inputPoctu() {
        System.out.println("Zadejte pocet prvku pocatecni posloupnosti(vetsi nez 0):");
        int pocetBodu = sc.nextInt();
        return pocetBodu;
    }

    public static int[] inputPosl(int pocetBodu) {
        System.out.println("Zadej pocatecni vzestupne setridenou posloupnost:");
        int[] posloupnost = new int[pocetBodu];
        for (int i = 0; i < pocetBodu; i++) {
            posloupnost[i] = sc.nextInt();
        }
        return posloupnost;
    }
    
    
    public static void vypis(int[] posloupnost) {
        
        System.out.println("Vysledna posloupnost:");
        for (int i = 0; i < posloupnost.length; i++) {
            System.out.print(posloupnost[i] + ", ");
        }
        System.out.println("\b\b");
    }
    
    public static int[] inputDalsichBodu(int[] posloupnost) {
        System.out.println("Zadavej dalsi hodnoty:");
        boolean pokracuj = true;
        int i = posloupnost.length;
        while (pokracuj) {
            int temp = sc.nextInt();
            if (temp < 0) {
                pokracuj = false;
                break;
            }
            if(binarySearchItem(posloupnost, 0, (i - 1), temp ) == -1){
                posloupnost = insertValue(posloupnost,temp);
            }
        }
        return posloupnost;
    }
    
    public static int binarySearchItem(int posloupnost[], int mensiIndex, int maxIndex, int prvek)
    {
        if (maxIndex >= mensiIndex) { 
            int mid = mensiIndex + (maxIndex - mensiIndex) / 2;

            if (posloupnost[mid] == prvek)//prvek je uprostred
                return mid;

            if (posloupnost[mid] > prvek)//prvek je mensi jak mid => prvek je v leve casti
                return binarySearchItem(posloupnost, mensiIndex, mid - 1, prvek);
            // jinak musi byt v prave
            return binarySearchItem(posloupnost, mid + 1, maxIndex, prvek);
            }
        //prvek neni v posloupnosti
        return -1;
    }
    
    public static int[] insertValue(int[] Posloupnost, int Value){
        int [] novaPosloupnost = new int[Posloupnost.length +1];
        if(Value < Posloupnost[0]){
            novaPosloupnost[0] = Value;
            for (int i = 0; i < Posloupnost.length; i++) {
                novaPosloupnost[i+1] = Posloupnost[i];
            }
        }else if(Value > Posloupnost[Posloupnost.length - 1]){
            novaPosloupnost[Posloupnost.length] = Value;
            for (int i = 0; i < Posloupnost.length; i++) {
                novaPosloupnost[i] = Posloupnost[i];
            }
        }
        else if(binarySearchItem(Posloupnost, 0, (Posloupnost.length - 1), Value ) == -1){
            int insertIndex = binarySearchPosition(Posloupnost, Value);
            for (int i = 0; i < insertIndex; i++) {
                novaPosloupnost[i] = Posloupnost[i];
            }
            novaPosloupnost[insertIndex] = Value;
            for (int i = insertIndex + 1; i < novaPosloupnost.length; i++) {
                novaPosloupnost[i] = Posloupnost[i-1];
            }
        }else{
            return Posloupnost;
        }
        return novaPosloupnost;
    }
    
    private static int binarySearchPosition(int[] posloupnost, int hledaneCislo) {
        int max = posloupnost.length - 1;
        int min = 0;
        int position;
        if (hledaneCislo > posloupnost[posloupnost.length - 1]) {
            return posloupnost.length;
        }else if (hledaneCislo < posloupnost[0]) {
            return 0;
        }
        while (true){
            position = (min + max) / 2;
            if (hledaneCislo > posloupnost[position] && hledaneCislo < posloupnost[position + 1]) {
                return position + 1;
            } else {
                if (posloupnost[position] < hledaneCislo) {
                    min = position + 1;
                } else if (posloupnost[position] > hledaneCislo) {
                    max = position - 1;
                }
            }
        }
    }
}    
//    public static int[] sortPosloupnosti(int[] posloupnost) {
//        int temp = 0;
//        for (int i = 0; i < posloupnost.length; i++) {
//            for (int j = 1; j < (posloupnost.length - i); j++) {
//                if (posloupnost[j - 1] > posloupnost[j]) {
//                    temp = posloupnost[j - 1];
//                    posloupnost[j - 1] = posloupnost[j];
//                    posloupnost[j] = temp;
//                }
//            }
//        }
//        return posloupnost;
//    }



