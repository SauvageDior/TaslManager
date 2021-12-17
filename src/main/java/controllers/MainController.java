package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//import controllers.*;
import model.Task;

public class MainController { //консоль (можно удалить этот класс вообще)

    private static boolean check_time(String str)
    {
        int count = 0;
        for (int i=0;i<str.length();i++)
            if (str.charAt(i)==':') count++;
        if (count!=1)	return false;

        String[] tokens=str.split(":");
        int hour = Integer.parseInt(tokens[0]);
        int min = Integer.parseInt(tokens[1]);

        if (hour<0 || hour>23) return false;
        if (min<0 || min>59) return false;

        return true;
    }

    public static void main(String[] args) {

        List<Task> taskList = new ArrayList<>();

        boolean changed = false;

        int menu = 0;

        while (menu!=4)
        {

            System.out.println("Task manager");
            System.out.println("Меню:");
            System.out.println("1. Создать задание");
            System.out.println("2. Удалить задание");
            System.out.println("3. Показать все задания");
            System.out.println("4. Выйти");
            System.out.print("Выберите пункт: ");
            Scanner scanner = new Scanner(System.in);
            menu = scanner.nextInt();
            scanner.nextLine();
            switch (menu) {
                case 1:
                    System.out.println("Введите название: ");
                    String name = scanner.nextLine();
                    System.out.println("Введите описание");
                    String desc = scanner.nextLine();
                    System.out.println("Введите время задания в формате 10:00");
                    String time = scanner.nextLine();

                    // DO

                    break;
                case 2:
                    System.out.println("Введите номер удаляемого задания (0 для возврата в меню: ");
                    int idx_obj = scanner.nextInt();
                    scanner.nextLine();

                    // DO

                    if (idx_obj==0) break;

                    // DO

                    break;
                case 3:
                    System.out.println("Список ваших заданий: ");

                    // DO

                    break;

                default:
                    break;
            }
        }

       /* if (changed)
        {
            System.out.println("");
            new java.util.Scanner(System.in).nextLine();
        }*/
    }

    }


