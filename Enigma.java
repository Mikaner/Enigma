import java.util.*;


public class Enigma{
    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        int sNum1;
        int sNum2;
        int sNum3;
        char top1;
        char top2;
        char top3;
        int exchangeCount;
        char exchangeAlph1;
        char exchangeAlph2;

        Rotor rotor1 = new Rotor();//call The First Rotor
        Rotor rotor2 = new Rotor();//call The Second Rotor
        Rotor rotor3 = new Rotor();//call The Third Rotor

        System.out.println("--Setting--");
        
        try{
            System.out.println("First Rotor");
            while(true){
                System.out.print(" Number  :> ");
                sNum1 = scanner.nextInt();//the Number of First Rotor
                if(sNum1 > 0 && sNum1 <= 5){
                    break;
                }else if(Objects.equals(0,sNum1)){
                    System.exit(0);
                }
                System.out.println(" Please type integer type between 1 and 5.");
            }
            while(true){
                System.out.print(" Alphabet:> ");
                top1 = scanner.next().charAt(0); //first character
                if(top1 >= Rotor.getFirstAlph() && top1 < Rotor.getLastAlph()){
                    break;
                }else if(Objects.equals('0',top1)){
                    System.exit(0);
                }
                System.out.println(" Please type character type between A and Z.");
            }

            System.out.println("Second Rotor");
            while(true){
                System.out.print(" Number  :> ");
                sNum2 = scanner.nextInt();//the Second Rotor
                if(sNum2 > 0 && sNum2 <= 5){
                    break;
                }else if(Objects.equals(0,sNum2)){
                    System.exit(0);
                }
                System.out.println(" Please type integer type between 1 and 5.");
            }
            while(true){
                System.out.print(" Alphabet:> ");
                top2 = scanner.next().charAt(0);//first
                if(top2 >= Rotor.getFirstAlph() && top2 < Rotor.getLastAlph()){
                    break;
                }else if(Objects.equals('0',top2)){
                    System.exit(0);
                }
                System.out.println(" Please type character type between A and Z.");
            }

            System.out.println("Third Rotor");
            while(true){
                System.out.print(" Number  :> ");
                sNum3 = scanner.nextInt();//the 
                if(sNum3 > 0 && sNum3 <= 5){
                    break;
                }else if(Objects.equals(0,sNum3)){
                    System.exit(0);
                }
                System.out.println(" Please type integer type between 1 and 5.");
            }
            while(true){
                System.out.print(" Alphabet:> ");
                top3 = scanner.next().charAt(0);//first
                if(top3 >= Rotor.getFirstAlph() && top3 < Rotor.getLastAlph()){
                    break;
                }else if(Objects.equals('0',top3)){
                    System.exit(0);
                }
                System.out.println(" Please type character type between A and Z.");
            }

            System.out.println("Exchange");
            System.out.print("Number of Alphabet to exchange : ");
            exchangeCount = scanner.nextInt();//exchange count
            for (int i = 0; i < exchangeCount; i++) {
                exchangeAlph1 = scanner.next().charAt(0);//exchange character
                exchangeAlph2 = scanner.next().charAt(0);
                Rotor.setExchange(exchangeAlph1, exchangeAlph2);
            }
            rotor1.setRotor(sNum1, top1);
            rotor2.setRotor(sNum2, top2);
            rotor3.setRotor(sNum3, top3);
        }catch(InputMismatchException e){
            System.out.println("Please enter a nomal value.");
            System.exit(0);
        }

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

        System.out.println("--Main--");
        System.out.println("Please type a message here.");
        while(true){
            System.out.print("Input:> ");
            String input = scanner.next();
            if(java.util.Objects.equals(input,"0")){
                break;
            }
            char[] cPut = input.toCharArray();//change type to char
            for(int i = 0; i < cPut.length; i++){//change alphabet
                /* conversion processing */
                cPut[i] = Rotor.exchange(
                    rotor1.reConversion(
                        rotor2.reConversion(
                            rotor3.reConversion(
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
                //
                if(Rotor.getRotateSum() % Rotor.getAlphSum() == rotor1.getRotateNum()){
                    rotor2.rotate();
                }
                if(Rotor.getRotateSum() % Math.pow(Rotor.getAlphSum(),Rotor.getAlphSum()) == rotor2.getRotateNum()){
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