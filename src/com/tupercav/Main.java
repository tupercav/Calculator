package com.tupercav;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Пожалуйста, введите выражение");
        String input = myObj.nextLine();
        calc(input);
    }

    public static String calc(String input) {
        input = input.toLowerCase();
        String[] strings = input.split(" "); //создали массив из строк, разделитель "пробел"
//        for (String element : strings) {  //печатаю то, что попало в массив для проверки
//            System.out.println(element);
//        }
        if (strings.length == 1) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("т.к. строка не является математической операцией");
                System.exit(0);
            }
        }
        if (strings.length > 3) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                System.exit(0);
            }
        }

        String firstDigit = strings[0];
        String action = strings[1];
        String secondDigit = strings[2];

        boolean firstDigitIsArabic = isArabic(firstDigit);
        boolean secondDigitIsArabic = isArabic(secondDigit);

        if (firstDigitIsArabic != secondDigitIsArabic) { //Проверяем на совпадение систем счисления
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
                System.exit(0);
            }
        }

        if (firstDigitIsArabic) {
            int firstIntDigit = Integer.valueOf(firstDigit);
            int secondIntDigit = Integer.valueOf(secondDigit);
            if (firstIntDigit < 1 || firstIntDigit > 10 || secondIntDigit < 1 || secondIntDigit > 10) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("throws Exception //т.к. одно из чисел меньше 0 или больше 10");
                    System.exit(0);
                }
            }
            System.out.println(doTheMath(firstIntDigit, secondIntDigit, action));
        } else {
            int firstIntDigit = toArabic(firstDigit);
            int secondIntDigit = toArabic(secondDigit);
            if (firstIntDigit < 1 || firstIntDigit > 10 || secondIntDigit < 1 || secondIntDigit > 10) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("throws Exception //т.к. одно из чисел меньше 0 или больше 10");
                    System.exit(0);
                }
            }
            if (doTheMath(firstIntDigit, secondIntDigit, action) < 1) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("throws Exception //т.к. в римской системе нет отрицательных чисел");
                    System.exit(0);
                }
            }
            int result = doTheMath(firstIntDigit, secondIntDigit, action);
            System.out.println(toGreece(result));
        }
        return input;
    }

    public static boolean isArabic(String digit) {
        boolean arabic = true;
        if (digit.contains("v") || digit.contains("i") || digit.contains("x")) {
            arabic = false;
        } else {
            arabic = true;
        }
        return arabic;
    }

    public static int toArabic(String digit) {
        int arabicDigit = 0;
        switch (digit) {
            case ("i"):
                arabicDigit = 1;
                break;
            case ("ii"):
                arabicDigit = 2;
                break;
            case ("iii"):
                arabicDigit = 3;
                break;
            case ("iv"):
                arabicDigit = 4;
                break;
            case ("v"):
                arabicDigit = 5;
                break;
            case ("vi"):
                arabicDigit = 6;
                break;
            case ("vii"):
                arabicDigit = 7;
                break;
            case ("viii"):
                arabicDigit = 8;
                break;
            case ("ix"):
                arabicDigit = 9;
                break;
            case ("x"):
                arabicDigit = 10;
                break;
        }
        return arabicDigit;
    }



    public static int doTheMath(int firstDigit, int secondDigit, String action) {
        int result = 0;
        if (action.contains("+")) {
            result = firstDigit + secondDigit;
        } else if (action.contains("-")) {
            result = firstDigit - secondDigit;
        } else if (action.contains("/")) {
            result = firstDigit / secondDigit;
        } else if (action.contains("*")) {
            result = firstDigit * secondDigit;
        } else {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("throws Exception //т.к. операция не из списка разрешенных");
            }
        }
        return result;
    }

    public static String toGreece (int result) {
        String resultGreece = new String();
        switch (result) {
            case 1:
                resultGreece = "I";
                break;
            case 2:
                resultGreece = "II";
                break;
            case 3:
                resultGreece = "III";
                break;
            case 4:
                resultGreece = "IV";
                break;
            case 5:
                resultGreece = "V";
                break;
            case 6:
                resultGreece = "VI";
                break;
            case 7:
                resultGreece = "VII";
                break;
            case 8:
                resultGreece = "VIII";
                break;
            case 9:
                resultGreece = "IX";
                break;
            case 10:
                resultGreece = "X";
                break;
            case 11:
                resultGreece = "XI";
                break;
            case 12:
                resultGreece = "XII";
                break;
            case 13:
                resultGreece = "XIII";
                break;
            case 14:
                resultGreece = "XIV";
                break;
            case 15:
                resultGreece = "XV";
                break;
            case 16:
                resultGreece = "XVI";
                break;
            case 17:
                resultGreece = "XVII";
                break;
            case 18:
                resultGreece = "XVIII";
                break;
            case 19:
                resultGreece = "XIX";
                break;
            case 20:
                resultGreece = "XX";
                break;
        }
        return resultGreece;

    }


}
