import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("Калькулятор для тестовой задачи\n" +
                "Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя целыми числами от 1 до 10\n" +
                "Калькулятор умеет работать с арабскими и с римскими числами\n" +
                "Введите выражение: ");

        Scanner Scan = new Scanner(System.in);
        System.out.println(Main.calc(Scan.nextLine()));
    }

    public static String calc(String input) {
        input = input.replaceAll(" ", "");
        ArrayList<String> Scan1 = new ArrayList();
        for (int i = 0; i < input.length(); i++) {

            if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/'){

                if(!(input.substring(0,i).isEmpty())) {Scan1.add( input.substring(0, i));}
                else { System.out.println("ERROR! - строка не является математической операцией"); System.exit(1);}
                if(!(input.substring(i,i+1).isEmpty())) {Scan1.add( input.substring(i,i+1));}
                else { System.out.println("ERROR! - строка не является математической операцией"); System.exit(1);}
                if(!(input.substring(i+1).isEmpty())) {Scan1.add( input.substring(i+1));}
                else { System.out.println("ERROR! - строка не является математической операцией"); System.exit(1);}
                break;
            }
        }
        if(Scan1.isEmpty()){System.out.println("ERROR! строка не является математической операцией или формат математической операции не удовлетворяет заданию"); System.exit(1);} else{

            String[] Rom  = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
            int[] RomIndex = new int[2];

            boolean NumIsRom = false;
            boolean Rom1 = false;
            boolean Rom2 = false;
            for(int i = 0; i<Rom.length; ++i ){
                if(Rom[i].equals(Scan1.get(0))) { RomIndex[0]=i+1; Rom1 = true;}
                if(Rom[i].equals(Scan1.get(2))) { RomIndex[1]=i+1; Rom2 = true;}
                }
            if(Rom1 && Rom2){ NumIsRom = true;}



            if(NumIsRom) {
            int summa = 0;
            if(RomIndex[0]>=1 && RomIndex[0]<=10 && RomIndex[1]>=1 && RomIndex[1]<=10){
                switch (Scan1.get(1).charAt(0)){
                    case '+' : summa = RomIndex[0]+RomIndex[1]; if(summa>0) {System.out.println(Rom[summa-1]);} else{System.out.println("ERROR! в римской системе нет 0 и отрицательных чисел");} break;
                    case '-' : summa = RomIndex[0]-RomIndex[1]; if(summa>0) {System.out.println(Rom[summa-1]);} else{System.out.println("ERROR! в римской системе нет 0 и отрицательных чисел");} break;
                    case '*' : summa = RomIndex[0]*RomIndex[1]; if(summa>0) {System.out.println(Rom[summa-1]);} else{System.out.println("ERROR! в римской системе нет 0 и отрицательных чисел");} break;
                    case '/' : summa = RomIndex[0]/RomIndex[1]; if(summa>0) {System.out.println(Rom[summa-1]);} else{System.out.println("ERROR! в римской системе нет 0 и отрицательных чисел");} break;
                }
                } else {System.out.println("ERROR! Введенные значения должны быть в диапазоне от I до X");}
            } else{

            int n1 = 0;
            int n2 = 0;

            try{
                n1 = Integer.parseInt(Scan1.get(0));
                n2 = Integer.parseInt(Scan1.get(2));
            } catch (NumberFormatException e){
                System.out.println("ERROR! Введенные значения не являются целыми числами"); System.exit(1);
            }

            int otvet = 0;

            if(n1>=1 && n1<=10 && n2>=1 && n2<=10){
                switch (Scan1.get(1).charAt(0)){
                    case '+' : otvet = n1+n2; System.out.println(otvet); break;
                    case '-' : otvet = n1-n2; System.out.println(otvet); break;
                    case '*' : otvet = n1*n2; System.out.println(otvet); break;
                    case '/' : otvet = n1/n2; System.out.println(otvet); break;
                }
            } else {
                System.out.println("ERROR! Введенные значения должны быть в диапазоне от 1 до 10"); System.exit(1);
            }}}




        return "";
    }
}
