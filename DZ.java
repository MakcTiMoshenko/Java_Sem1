package ru.geekbrains.api.seminar1.DZ1;

import java.util.Arrays;
import java.util.Scanner;

public class DZ {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("**********************************");
        System.out.println("Здравствуйте!\nВы открыли Домашнее задание студента GeekBrains\nТимошенко Максима\n Давайте начнем!)");
        System.out.println("**********************************");
        boolean f = true;
        while(f){
            System.out.println(" ");
            System.out.println("Выберите номер задачи для проверки:");
            System.out.println("1 - Задача 1");
            System.out.println("2 - Задача 2");
            System.out.println("3 - Задача 3");
            System.out.println("4 - Задача 4");
            System.out.println("0 - Завершение работы приложения");
            System.out.println("================================");
            int no = Integer.parseInt(scanner.nextLine());
            System.out.println(" ");

            switch(no){
                case 1:
                    System.out.print("Условие задачи:\n");
                    System.out.print("Вычислить n-ое треугольного число\n (сумма чисел от 1 до n), n!\n (произведение чисел от 1 до n) ");
                    System.out.println("\n");
                    System.out.print("Введите число n: ");
                    int n = Integer.parseInt(scanner.nextLine());
                    System.out.println("Ответ: ");
                    Exemple1(n);
                    break;

                case 2:
                    System.out.print("Условие задачи:\n");
                    System.out.print("Вывести все простые числа от 1 до 1000 ");
                    System.out.println("\n");
                    System.out.println("Ответ: ");
                    Exemple2();
                    break;

                case 3:

                    System.out.print("Условие задачи:\n");
                    System.out.print("Реализовать простой калькулятор ");
                    System.out.println("\n");
                    System.out.print("Введите число 1: ");
                    double num1 = Double.parseDouble(scanner.nextLine());
                    System.out.print("Введите число 2: ");
                    double num2 = Double.parseDouble(scanner.nextLine());
                    double res = 0;
                    Exemple3(num1,num2,res);
                    break;

                case 4:

                    System.out.print("Условие задачи:\n");
                    System.out.print("Задано уравнение вида q + w = e, q, w, e >= 0. \nНекоторые цифры могут быть заменены знаком вопроса, например, \n2? + ?5 = 69. Требуется восстановить выражение до верного равенства.\n Предложить хотя бы одно решение или сообщить, что его нет.");
                    System.out.println("\n");
                    Exemple4();
                    break;
                case 0:
                    System.out.println("Завершение работы. \nСпасибо за то что пользовались моим приложением. \nДо новых встреч!!!");
                    f = false;
                    break;
                
                default:
                    System.out.println("Вы указали некорректный номер задачи.\nПовторите попытку ввода.");
                break;

            }
        }

    }

     /*
     * Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
     */
    static void Exemple1(int num){

        int sum1 = 0;
        int sum2 = 1;
        for(int i=1; i<num+1; i++){
            sum1 = sum1 + i;
        }
        for(int i=1; i<num+1; i++){
            sum2 = sum2 * i;
        }
        System.out.printf("Сумма чисел n = %d\nПроизведение чисел n = %d\n", sum1,sum2);

    }


    /*
     * Вывести все простые числа от 1 до 1000 
     */
    static void Exemple2(){
        for (int j = 2; j <= 1000; j++) {
            boolean flag = false;

            for (int i = 2; i * i <= j; i++) {
                flag = (j % i == 0);
                if (flag) {
                    break;
                }
            }
            if (!flag) {
                System.out.print(j + " ");
            }
        }
        System.out.print("\n");
    }

     /*
     Реализовать простой калькулятор
     */
    static void Exemple3(double num1,double num2,double res){
        System.out.print("\nВведите производимую операцию (+, -, *, /): ");
        String sim = scanner.nextLine();
        switch(sim) {
            case "+": 
                res = num1 + num2;
                System.out.println("Результат сложения: " + res);
               break;
            case "-": 
                res = num1 - num2;
                System.out.printf("Результат вычетания: %f\n", res);
               break;
            case "*": 
                res = num1 * num2;
                System.out.printf("Результат умножения: %f\n", res);
               break;
            case "/": 
                res = num1 / num2;
                System.out.printf("Результат деления: %f\n", res);
               break;
            default:  System.out.print("Ошибка!!!");
               return;
        }

    }
    //Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69. Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.
    static void Exemple4(){
        System.out.print("Введите уравнение: ");
        String equation = scanner.nextLine();
        String[] parts = equation.split("\s*[+=]\s*");
        // System.out.print(Arrays.asList(parts)); // Проверка что выражение разбивает на массив
        int q = -1, w = -1, e = -1;
        for(int i = 0; i<10; i++){
            if(q == -1 && !parts[0].contains("?")){
                q = Integer.parseInt(parts[0]);
            }
            if(w == -1 && !parts[1].contains("?")){
                w = Integer.parseInt(parts[1]);
            }
            if(e == -1 && !parts[2].contains("?")){
                e = Integer.parseInt(parts[2]);
            }
            if(parts[0].charAt(i) == '?'){
                q = i;
            }
            if(parts[1].charAt(i) == '?'){
                w = i;
            }
            if(parts[2].charAt(i) == '?'){
                e = i;
            }
        }
        if(q + w == e && q != -1 && w != -1 && e != -1){
            System.out.printf("%d + %d = %d", q, w, e);

        }
        else {
            System.out.print("Решений нет!(");
        }
    }
    

}