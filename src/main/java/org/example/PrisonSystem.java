package org.example;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class PrisonSystem {
    private Log logger;
    private Scanner scanner = new Scanner(System.in);

    public PrisonSystem() {
        try {
            logger = new Log("logs/prison_system.log");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registerPrisoner() {
        try {
            System.out.println("Введите данные нового заключенного:");
            String input = scanner.nextLine();
            if (isValidName(input)) {
                Prisoner prisoner = new Prisoner(input);
                System.out.println("Заключенный " + prisoner.getName() + " зарегистрирован. ID: " + prisoner.getId());
            } else {
                System.out.println("Неверный ввод. Пожалуйста, введите имя заключенного.");
                registerPrisoner();
            }
            logger.logger.info("Registering prisoner...");
        } catch (Exception e) {
            logger.logger.severe("Error registering prisoner: " + e.getMessage());
        }
    }

    private static boolean isValidName(String input) {
        return input.matches("[а-яА-Я\\s]+");
    }

    public void provideMeal() {
        try {
            System.out.println("Выберите прием пищи:");
            System.out.println("1. Завтрак");
            System.out.println("2. Обед");
            System.out.println("3. Ужин");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Выдаем завтрак:");
                    provideFood(new Food("Каша"));
                    System.out.println("Завтрак выдан.");
                    break;
                case 2:
                    System.out.println("Выдаем обед...");
                    provideFood(new Food("Суп"));
                    System.out.println("Обед выдан.");
                    break;
                case 3:
                    System.out.println("Выдаем ужин...");
                    provideFood(new Food("Чай"));
                    System.out.println("Ужин выдан.");
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
            logger.logger.info("Providing meal: " + choice);
        } catch (Exception e) {
            logger.logger.severe("Error providing meal: " + e.getMessage());
        }
    }

    private void provideFood(Food food) {
        System.out.println("Выдаем: " + food.getName());
    }

    public static void assignWork() {
        System.out.println("Назначаем работу заключенному...");
        System.out.println("Работа назначена.");
    }

    public static void exitProgram() {
        System.out.println("Программа завершена.");
        System.exit(0);
    }

    public static void printCustomMessage(String message) {
        System.out.println(message);
    }

    public static void releasePrisoner() {
        System.out.println("Освобождаем заключенного...");
        System.out.println("Заключенный освобожден.");
    }

    public static void conductInterrogation() {
        System.out.println("Проводим допрос...");
        System.out.println("Допрос завершен.");
    }

    public void conductExercise() {
        System.out.println("Проводим физические упражнения для заключенных...");
        System.out.println("Упражнения завершены.");
    }

    public void visitLibrary() {
        System.out.println("Посещаем библиотеку для чтения книг...");
        System.out.println("Чтение завершено.");
    }

    public void conductCounselingSession() {
        System.out.println("Проводим консультацию для заключенных...");
        System.out.println("Консультация завершена.");
    }

    public static void conductRandomSearch() {
        Random random = new Random();
        boolean contrabandFound = random.nextBoolean();

        if (contrabandFound) {
            System.out.println("Контрабанда найдена!");
        } else {
            System.out.println("Контрабанды не найдено.");
        }
    }

    public static void calculateVariableSentenceDuration() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите длительность наказания (в днях):");
        String input = scanner.nextLine();
        if (isValidNumber(input)) {
            int baseDuration = Integer.parseInt(input);
            int variableDuration = baseDuration * 24;
            System.out.println("Длительность наказания: " + variableDuration + " часов.");
        } else {
            System.out.println("Неверный ввод. Пожалуйста, введите число.");
            calculateVariableSentenceDuration();
        }
    }

    private static boolean isValidNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void transferPrisonerToRandomCell() {
        System.out.println("Переводим заключенного в случайную камеру...");
        Random random = new Random();
        int randomCell = random.nextInt(10) + 1;
        System.out.println("Заключенный переведен в камеру " + randomCell + ".");
    }
}
