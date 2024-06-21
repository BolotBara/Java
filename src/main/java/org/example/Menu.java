package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private Log logger;
    private Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
        try {
            logger = new Log("logs/menu.log");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayMainMenu() {
        System.out.println("Программа управления тюрьмой");
        System.out.println("Выберите действие:");
        System.out.println("1. Зарегистрировать нового заключенного");
        System.out.println("2. Провести обыск");
        System.out.println("3. Выдать прием пищи");
        System.out.println("4. Рассчитать длительность наказания");
        System.out.println("5. Назначить работу заключенному");
        System.out.println("6. Перевести заключенного в другую камеру");
        System.out.println("7. Освободить заключенного");
        System.out.println("8. Провести допрос");
        System.out.println("9. Провести физические упражнения для заключенных");
        System.out.println("10. Посетить библиотеку для чтения книг");
        System.out.println("11. Провести консультацию для заключенных");
        System.out.println("12. Завершить программу");
    }

    public int getChoice() {
        return Integer.parseInt(scanner.nextLine());
    }

    public String getContinueChoice() {
        return scanner.nextLine();
    }

    public void handleInput(int choice, PrisonSystem prisonSystem, Scanner scanner) {
        switch (choice) {
            case 1:
                prisonSystem.registerPrisoner();
                break;
            case 2:
                PrisonSystem.conductRandomSearch();
                break;
            case 3:
                prisonSystem.provideMeal();
                break;
            case 4:
                PrisonSystem.calculateVariableSentenceDuration();
                break;
            case 5:
                PrisonSystem.assignWork();
                break;
            case 6:
                PrisonSystem.transferPrisonerToRandomCell();
                break;
            case 7:
                PrisonSystem.releasePrisoner();
                break;
            case 8:
                PrisonSystem.conductInterrogation();
                break;
            case 9:
                prisonSystem.conductExercise();
                break;
            case 10:
                prisonSystem.visitLibrary();
                break;
            case 11:
                prisonSystem.conductCounselingSession();
                break;
            case 12:
                PrisonSystem.exitProgram();
                break;
            default:
                PrisonSystem.printCustomMessage("Некорректный выбор.");
        }
        logger.logger.info("User chose option: " + choice);
    }
}
