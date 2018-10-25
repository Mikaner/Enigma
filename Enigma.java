import java.util.Scanner;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Enigma{
    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Setting");
        System.out.println("First Rotor");
        int sNum1 = scanner.nextInt();//the Number of First Rotor
        char top1 = scanner.next().charAt(0); //first character

        System.out.println("Second Rotor");
        int sNum2 = scanner.nextInt();//the Second Rotor
        char top2 = scanner.next().charAt(0);//first

        System.out.println("Third Rotor");
        int sNum3 = scanner.nextInt();//the Third
        char top3 = scanner.next().charAt(0);//first

        System.out.println("Exchange");
        char exchangeAlph1 = scanner.next().charAt(0);//exchange character
        char exchangeAlph2 = scanner.next().charAt(0);

        Rotor rotor1 = new Rotor(sNum1,top1);//call Rotor1
        Rotor rotor2 = new Rotor(sNum2,top2);//call Rotor2
        Rotor rotor3 = new Rotor(sNum3,top3);//call Rotor3
        Rotor.setExchange(exchangeAlph1, exchangeAlph2);

        //確認用
        System.out.println(Rotor.getRotorSum());
        for(int i = 0; i < Rotor.getAlphSum(); i++){
            System.out.print(Rotor.getAlphabet(i));
        }
        System.out.println();
        for(int i = 0; i < Rotor.getAlphSum(); i++){
            System.out.print(" "+Rotor.getAlphabetToNum((char)('A'+i)));
        }
        System.out.println();
        for(int i = 0; i< Rotor.getAlphSum(); i++){
            System.out.print(" "+Rotor.getExchangeRotor(i));
        }
        System.out.println();

        System.out.println("Please type a message here.");
        while(true){
            String input = scanner.next();
            /*if(input == ""){ I don't know why this don't move.
                break;
            }*/
            char[] cPut = input.toCharArray();//change type to char
            for(int i = 0; i < cPut.length; i++){
                System.out.print(cPut[i]);
            }
            System.out.println();
        }

    }
}