package org.example;

import java.util.*;
import java.lang.*;

import static org.example.NoteCatalog.totalNotebook;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n*  Добро пожаловать в магазин ноутбуков  *\n");
        System.out.println("Введите 1, чтобы посмотреть весь ассортимент");
        System.out.println("Введите 2, чтобы задать критерии поиска");
        System.out.println("Введите 0, чтобы выйти и подумать еще");

        Set<Notebook> notebooks = NoteCatalog.fill();

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        switch (choice) {
            case ("0"):
                System.out.println("\n*  Досвидосики :)  *\n");
                break;
            case ("1"):
                System.out.println("\n*  Ноутбуки в наличии:  *\n");
                notebookPrint(notebooks);
                System.out.printf("\n*  Найдено %d из %d ноутбуков  *\n", totalNotebook, totalNotebook);
                break;
            case ("2"):
                Set<Notebook> notebookFromFilter = NoteCustomer.filter(notebooks);
                int counter = notebookFromFilter.size();
                if (counter == 0) {
                    System.out.println("\n*  Не найдено ни одного ноутбука  *\n");
                } else {
                    notebookPrint(notebookFromFilter);
                    System.out.printf("\n*  Найдено %d из %d ноутбуков  *\n", counter, totalNotebook);
                 }
                break;
            default:
                System.out.println("\n*  Некорректный ввод  *\n");
                break;
        }
    }

    /**
     * @apiNote печатает список ноутбуков с параметрами
     * @param notebooks список ноутбуков
     */
    private static void notebookPrint(Set<Notebook> notebooks) {
        for (Notebook notebook : notebooks) {
            System.out.println(notebook);
        }
    }
}