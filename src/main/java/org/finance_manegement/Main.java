package org.finance_manegement;

import org.finance_manegement.MyHashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MyHashMap<String, String> map = new MyHashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Добро пожаловать в консольное приложение MyHashMap ===");
        System.out.println("Доступные команды:");
        System.out.println("- put <ключ> <значение> - добавить или обновить пару ключ-значение");
        System.out.println("- get <ключ> - получить значение по ключу");
        System.out.println("- remove <ключ> - удалить пару по ключу");
        System.out.println("- size - узнать текущий размер карты");
        System.out.println("- exit - выйти из приложения");

        while (true) {
            System.out.print("\nВведите команду: ");
            String input = scanner.nextLine();
            String[] tokens = input.split(" ");

            if (tokens[0].equalsIgnoreCase("exit")) {
                System.out.println("Выход...");
                break;
            } else if (tokens[0].equalsIgnoreCase("put") && tokens.length == 3) {
                String key = tokens[1];
                String value = tokens[2];
                map.put(key, value);
                System.out.println("Добавлено/Обновлено: " + key + " -> " + value);
            } else if (tokens[0].equalsIgnoreCase("get") && tokens.length == 2) {
                String key = tokens[1];
                String value = map.get(key);
                if (value != null) {
                    System.out.println("Значение для ключа '" + key + "': " + value);
                } else {
                    System.out.println("Ключ '" + key + "' не найден.");
                }
            } else if (tokens[0].equalsIgnoreCase("remove") && tokens.length == 2) {
                String key = tokens[1];
                String removedValue = map.remove(key);
                if (removedValue != null) {
                    System.out.println("Удалено: " + key + " -> " + removedValue);
                } else {
                    System.out.println("Ключ '" + key + "' не найден.");
                }
            } else if (tokens[0].equalsIgnoreCase("size")) {
                System.out.println("Текущий размер HashMap: " + map.size());
            } else {
                System.out.println("Неверная команда. Попробуйте снова.");
            }
        }

        scanner.close();
    }
}