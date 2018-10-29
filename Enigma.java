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
        System.out.print("Number of Alphabet to exchange : ");
        int exchangeCount = scanner.nextInt();//exchange count
        char exchangeAlph1;
        char exchangeAlph2;
        for (int i = 0; i < exchangeCount; i++) {
            exchangeAlph1 = scanner.next().charAt(0);//exchange character
            exchangeAlph2 = scanner.next().charAt(0);
            Rotor.setExchange(exchangeAlph1, exchangeAlph2);
        }

        Rotor rotor1 = new Rotor();//call The First Rotor
        Rotor rotor2 = new Rotor();//call The Second Rotor
        Rotor rotor3 = new Rotor();//call The Third Rotor
        rotor1.setRotor(sNum1, top1);
        rotor2.setRotor(sNum2, top2);
        rotor3.setRotor(sNum3, top3);

        //確認用
        System.out.println(Rotor.getRotorSum());
        for(int i = 0; i < Rotor.getAlphSum(); i++){
            System.out.print(" "+Rotor.getAlphabet(i));
        }
        System.out.println();
        for(int i = 0; i < Rotor.getAlphSum(); i++){
            System.out.print(" "+Rotor.exchange(i));
        }
        System.out.println();

        System.out.println("Please type a message here.");
        while(true){
            String input = scanner.next();
            if(java.util.Objects.equals(input,"\"exit\"")){
                break;
            }
            char[] cPut = input.toCharArray();//change type to char
            for(int i = 0; i < cPut.length; i++){//change alphabet
                /* conversion processing */
                cPut[i] = Rotor.exchange(
                    rotor1.conversion(
                        rotor2.conversion(
                            rotor3.conversion(
                                Rotor.reflector(
                                    rotor3.conversion(
                                        rotor2.conversion(
                                            rotor1.conversion(
                                                Rotor.exchange(
                                                    cPut[i]
                                                )
                                            )
                                        )
                                    )
                                )
                            )
                        )
                    )
                );
                /* Rotation processing */
                rotor1.rotate();
                Rotor.plusRotateSum();
                if(Rotor.getRotateSum() % Rotor.getAlphSum() == 0){
                    rotor2.rotate();
                }
                if(Rotor.getRotateSum() % Math.pow(Rotor.getAlphSum(),Rotor.getAlphSum()) == 0){
                    rotor3.rotate();
                }
            }
            for(int i = 0; i < cPut.length; i++){//output
                System.out.print(cPut[i]);
            }
            System.out.println();
        }
    }
}