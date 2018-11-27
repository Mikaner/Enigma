import java.util.*;


public class NewEnigma{
    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        int[] sNum = new int[3];
        char[] top = new char[3];
        char[] callyAlph = new char[3];
        int exchangeCount;
        char exchangeAlph1;
        char exchangeAlph2;
        int cAlph;

        Rotor[] rotor = new Rotor[3];


        System.out.println("--Setting--");
        
        try{
            for (int i = 0; i < 3; i++) {
                rotor[i] = new Rotor();
                switch(i){
                    case 0:
                        System.out.println("First Rotor");
                        break;
                    case 1:
                        System.out.println("Medium Rotor");
                        break;
                    case 2:
                        System.out.println("Slow Rotor");
                        break;
                    default:
                        break;
                }
                while(true){
                    System.out.print(" Number  :>");
                    sNum[i] = scanner.nextInt();//the Number of First Rotor
                    if(sNum[i] > 0 && sNum[i] <= 5){
                        break;
                    }else if(Objects.equals(0,sNum[i])){
                        System.exit(0);
                    }
                    System.out.println(" Please type integer type between 1 and 5.");
                }
                while(true){
                    System.out.print(" Alphabet:>");
                    top[i] = scanner.next().charAt(0); //first character
                    if(top[i] >= Rotor.getFirstAlph() && top[i] < Rotor.getLastAlph()){
                        break;
                    }else if(Objects.equals('0',top[i])){
                        System.exit(0);
                    }
                    System.out.println(" Please type character type between A and Z.");
                }
                while(true){
                    System.out.print(" CallyDigit:>");
                    callyAlph[i] = scanner.next().charAt(0);
                    if(callyAlph[i] >= Rotor.getFirstAlph() && callyAlph[i] < Rotor.getLastAlph()){
                        break;
                    }else if(Objects.equals('0',callyAlph[i])){
                        System.exit(0);
                    }
                    System.out.println(" Please type character type between A and Z.");
                }
                rotor[i].setRotor(sNum[i], top[i], callyAlph[i]);
            }

            System.out.println("Reflecter");
            System.out.print("Number of plugs:>");
            exchangeCount = scanner.nextInt();//exchange count
            for (int i = 0; i < exchangeCount; i++) {
                exchangeAlph1 = scanner.next().charAt(0);//exchange character
                exchangeAlph2 = scanner.next().charAt(0);
                Rotor.setExchange(exchangeAlph1, exchangeAlph2);
            }
        }catch(Exception e){
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
            System.out.println("<Input>");
            String input = scanner.next();
            if(Objects.equals(input,"0")){
                break;
            }
            char[] cPut = input.toCharArray();//change type to char
            for(int i = 0; i < cPut.length; i++){//change alphabet
                /* conversion processing */
                cAlph = Rotor.exchange(cPut[i]);
                for (int j = 0; j < 3; j++) {
                    cAlph = rotor[j].conversion(cAlph);
                }
                cAlph = Rotor.reflector(cAlph);
                for (int j = 2; j >= 0; j--) {
                    cAlph = rotor[j].reConversion(cAlph);
                }
                cPut[i] = Rotor.exchange(cAlph);
                
                /* Rotation processing */
                rotor[0].rotate();
                Rotor.plusRotateSum();
                //
                if(Rotor.getRotateSum() % Rotor.getAlphSum() == rotor[0].getRotateNum()){
                    rotor[1].rotate();
                }
                if(Rotor.getRotateSum() % Math.pow(Rotor.getAlphSum(),Rotor.getAlphSum()) == rotor[1].getRotateNum()){
                    rotor[2].rotate();
                }
            }
            System.out.println("<output>");
            for(int i = 0; i < cPut.length; i++){//output
                System.out.print(cPut[i]);
            }
            System.out.println();
        }
    }
}