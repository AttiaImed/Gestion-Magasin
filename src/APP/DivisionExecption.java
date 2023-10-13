package APP;

import java.util.Scanner;

public class DivisionExecption {


     static  int x =20;
     static int y ;
          public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
            System.out.println(" Enter un entier");
             y = scanner.nextInt();
            try {
                System.out.println(x/y);
            }catch (ArithmeticException e){
                System.out.println("tu peut pas diviser par 0");
            }
    }


}
