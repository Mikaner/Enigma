import java.util.*;


public class NewEnigma{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalRotor = 3;
        int[] sNum = new int[totalRotor];
        char[] top = new char[totalRotor];
        char[] callyAlph = new char[totalRotor];
        int exchangeCount;
        char exchangeAlph1;
        char exchangeAlph2;
        int cAlph;

        NewRotor[] rotor = new NewRotor[totalRotor];

        //input
        System.out.println("--Setting--");
        try{
            for (int i = 0; i < totalRotor; i++) {
                rotor[i] = new NewRotor();
                if(i == 0){
                    System.out.println("First Rotor");
                }else if(i == totalRotor-1){
                    System.out.println("Slow Rotor");
                }else{
                    System.out.println("Medium Rotor" + i);
                }
                while(true){
                    System.out.print(" Number  :> ");
                    sNum[i] = scanner.nextInt();//the Number of First Rotor
                    if(sNum[i] > 0 && sNum[i] <= 5){
                        break;
                    }else if(Objects.equals(0,sNum[i])){
                        System.exit(0);
                    }
                    System.out.println(" Please type integer type between 1 and 5.");
                }
                while(true){
                    System.out.print(" Alphabet:> ");
                    top[i] = scanner.next().charAt(0); //first character
                    if(top[i] >= NewRotor.getFirstAlph() && top[i] < NewRotor.getLastAlph()){
                        break;
                    }else if(Objects.equals('0',top[i])){
                        System.exit(0);
                    }
                    System.out.println(" Please type character type between A and Z.");
                }
                while(true){
                    System.out.print(" CallyDigit:> ");
                    callyAlph[i] = scanner.next().charAt(0);
                    if(callyAlph[i] >= NewRotor.getFirstAlph() && callyAlph[i] < NewRotor.getLastAlph()){
                        break;
                    }else if(Objects.equals('0',callyAlph[i])){
                        System.exit(0);
                    }
                    System.out.println(" Please type character type between A and Z.");
                }
                rotor[i].setRotor(sNum[i], top[i], callyAlph[i]);
            }
            System.out.println("Reflecter");
            System.out.print("Number of plugs:> ");
            exchangeCount = scanner.nextInt();//exchange count
            for (int i = 0; i < exchangeCount; i++) {
                exchangeAlph1 = scanner.next().charAt(0);//exchange character
                exchangeAlph2 = scanner.next().charAt(0);
                NewRotor.setExchange(exchangeAlph1, exchangeAlph2);
            }
        }catch(Exception e){
            System.out.println("Please enter a nomal value.");
            System.exit(0);
        }

        //確認用
        System.out.println(NewRotor.getRotorSum());
        for(int i = 0; i < NewRotor.getAlphSum(); i++){
            System.out.print(" "+NewRotor.getAlphabet(i));
        }
        System.out.println();
        for(int i = 0; i < NewRotor.getAlphSum(); i++){
            System.out.print(" "+NewRotor.exchange(i));
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
                cAlph = NewRotor.exchange(cPut[i]);
                for (int j = 0; j < totalRotor; j++) {
                    cAlph = rotor[j].conversion(cAlph);
                }
                cAlph = NewRotor.reflector(cAlph);
                for (int j = totalRotor-1; j >= 0; j--) {
                    cAlph = rotor[j].reConversion(cAlph);
                }
                cPut[i] = NewRotor.exchange(cAlph);

                /* Rotation processing */
                rotor[0].rotate();
                NewRotor.plusRotateSum();
                //
                if(NewRotor.getRotateSum() % NewRotor.getAlphSum() == rotor[0].getRotateNum()){
                    rotor[1].rotate();
                }
                if(NewRotor.getRotateSum() % Math.pow(NewRotor.getAlphSum(),NewRotor.getAlphSum()) == rotor[1].getRotateNum()){
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