package com.itfactory.project.user_service.console_ui;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MenuUtil {
    static char readChoice(String menu, Character... options) {
        Set<Character> optionsPermitted = new HashSet<>(Arrays.asList(options));
        char choice = '?';
        Scanner scanner = new Scanner(System.in);
        while (choice == '?') {
            System.out.println("\n" + menu + "\nAlegeti? :");
            String input = scanner.next().trim().toUpperCase();
            char first = input.length() >= 1 ? input.charAt(0) : '?';
            if (optionsPermitted.contains(first)) {
                choice = first;
            } else {
                System.out.println(" Comanda '" + input + "' nu este valida! Incercati din nou!");

            }
        }
        System.out.println();
        return choice;
    }

    static String readString(String label, boolean allowEmpty) {
        System.out.println(label);
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            input = scanner.nextLine().trim();
        } while (!allowEmpty && input.isEmpty());
        return input;
    }

    static int readInt (String label, boolean allowEmpty){
        while (true){
            String numberInput = readString (label, allowEmpty);
            try{
                if("".equals(numberInput)){
                    return 0;
                }
                else{
                return Integer.parseInt(numberInput);
                }
            }catch (NumberFormatException e ){
                System.err.println(" Trebuie sa introduceti un numar! Incercati din nou!(eroare: " + e.getMessage()+")");
            }
        }
    }

}
