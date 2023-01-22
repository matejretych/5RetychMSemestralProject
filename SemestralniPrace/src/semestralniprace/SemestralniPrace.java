/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package semestralniprace;

import java.util.Scanner;

/**
 * 5. Program gets new values and inserts them to Array in ascending order and then prints the Array
 * @author matej
 */
public class SemestralniPrace {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean endProgram = false;
        while (endProgram == false) {
            System.out.println("Pokracovat ve zpracovani (a/n):");
            String inRozhodnuti = sc.nextLine();
            if(inRozhodnuti.equals("a") || inRozhodnuti.equals("A")) { 
                    int pocetBodu = Tools.inputPoctu();
                    int[] posloupnost = Tools.inputPosl(pocetBodu);
                    posloupnost = Tools.inputDalsichBodu(posloupnost);
//                    posloupnost = Tools.sortPosloupnosti(posloupnost);
                    Tools.vypis(posloupnost);
                }
            else if(inRozhodnuti.equals("n") || inRozhodnuti.equals("N")) {                     
                    endProgram = true;
                }
        }
    }

}
