/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semestralniprace;

import java.util.Scanner;

/**
 *
 * @author matej
 */
public class UI {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean pokracuj = true;
        while (pokracuj) {
            System.out.println("Zadejte jaky program chcete pustit program.");
            System.out.println("1 pro spusteni vanocni ulohy");
            System.out.println("2 pro spusteni semestralni prace");
            System.out.println("0 pro ukonceni programu.");
            int vyber = sc.nextInt(); 
            switch (vyber) {
                case 1 : {
                    System.out.println("Spoustim vanocni ulohu");
                    VanocniUloha.main(args);
                    break;
                }
                case 2 : {
                    System.out.println("Spoustim semestralni praci");
                    SemestralniPrace.main(args);
                    break;
                }
                case 0 : {
                    System.out.println("Ukoncuji program");
                    pokracuj = false;
                    break;
                }
                default : {
                    System.out.println("Nezadal si spravny parametr");
                    System.out.println("Znovu a lepe...");
                    break;
                }
            }
        }
        System.out.println("UI ukonceno");
    }
}