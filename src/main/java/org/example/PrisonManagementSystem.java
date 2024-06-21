package org.example;

import java.util.Scanner;

public class PrisonManagementSystem {
    public static void main(String[] args) {
        PrisonSystem prisonSystem = new PrisonSystem();
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);

        boolean continueProgram = true;
        while (continueProgram) {
            menu.displayMainMenu();
            int choice = menu.getChoice();
            menu.handleInput(choice, prisonSystem, scanner);

            System.out.println("Желаете продолжить? (да/нет)");
            String continueChoice = menu.getContinueChoice();
            if (!continueChoice.equalsIgnoreCase("да")) {
                continueProgram = false;
                prisonSystem.exitProgram();
            }
        }
    }
}
