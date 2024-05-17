import java.util.Scanner;

public class calcArabRoman{

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        Main result = new Main();
        System.out.println("Введите выражение [2 + 2] или два римских числа от I до X:[V + V] + Enter");
        String vvod = input.nextLine();           // Ввод выражения
        String answer = result.calc(vvod);        // Метод calc для объекта vvod
        System.out.println(answer);               // Выводим ответ
    }
}

class Main{

    public static String calc(String input){
        boolean romanOrArab = false;                      // Для понимания какое число на выходе (рим или араб)
        String exception = "throws Exception";            // Исключение
        Main romanExamination = new Main();               // Вводим для проверки и перевода из рим в араб
        Main arabToRoman = new Main();                    // Для перевода ответа в римские
        int result = 0;                                   // Считает выражение
        String output;

        String[] inputSplit = input.split(" ");
        if (inputSplit.length != 3){
            return exception;                             // Если не 3 элемента
        }

        int num1 = 0;
        int num2 = 0;

        try {
            num1 = Integer.valueOf(inputSplit[0]);
            num2 = Integer.valueOf(inputSplit[2]);
        } catch (NumberFormatException a) {                          // Проверка, если не арабское
            try {
                num1 = romanExamination.romanToArab(inputSplit[0]);
                num2 = romanExamination.romanToArab(inputSplit[2]);
                romanOrArab = true;
            } catch (NumberFormatException b) {                     // Проверка, если не римское
                return exception;
            }
        }

        if ((num1 < 1) || (num1 > 10) || (num2 < 1) || (num2 > 10)){
            return exception;                                       // Указываем диапазон значений
        }

        String oper = inputSplit[1];
        if (oper.equals("+")){
            result = num1 + num2;
        } else if (oper.equals("-")){
            result = num1 - num2;
        } else if (oper.equals("*")){
            result = num1 * num2;
        } else if (oper.equals("/")){
            result = num1 / num2;
        } else {
            return exception;
        }

        if (romanOrArab){
            if(result < 1){
                return exception;
            } else {
                output = arabToRoman.arabToRome(result);
            }
        } else {
            output = Integer.toString(result);
        }

        return output;
    }

    private static int romanToArab(String romanInput) {

        int result = 0;

            if (romanInput.equals("I")) {
                result = 1;
            } else if (romanInput.equals("II")) {
                result = 2;
            } else if (romanInput.equals("III")) {
                result = 3;
            } else if (romanInput.equals("IV")) {
                result = 4;
            } else if (romanInput.equals("V")) {
                result = 5;
            } else if (romanInput.equals("VI")) {
                result = 6;
            } else if (romanInput.equals("VII")) {
                result = 7;
            } else if (romanInput.equals("VIII")) {
                result = 8;
            } else if (romanInput.equals("IX")) {
                result = 9;
            } else if (romanInput.equals("X")) {
                result = 10;
            }

            return result;

    } // Перевод из римских в арабские

    private static String arabToRome (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"

        };
        final String s = roman[numArabian];
        return s;
    } // Перевод из арабских в римские
}