import java.util.Scanner;

public class Enigma{
    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Setting");
        System.out.println("First Roter");
        int sNum1 = scanner.nextInt();//the Number of First roter
        char top1 = scanner.next().charAt(0); //first character

        System.out.println("Second Roter");
        int sNum2 = scanner.nextInt();//the Second roter
        char top2 = scanner.next().charAt(0);//first

        System.out.println("Third Roter");
        int sNum3 = scanner.nextInt();//the Third
        char top3 = scanner.next().charAt(0);//first

        System.out.println("Exchange");
        char char1 = scanner.next().charAt(0);//exchange character
        char char2 = scanner.next().charAt(0);

        Roter roter1 = new Roter(sNum1,top1);//call roter1
        Roter roter2 = new Roter(sNum2,top2);//call roter2
        Roter roter3 = new Roter(sNum3,top3);//call roter3
        Roter.setExchange(char1, char2);
        System.out.println(Roter.getRoterNum());

        System.out.println("Please type a message here.");
        while(true){
            String input = scanner.next();
            /*if(input == ""){ I don't know why this don't move.
                break;
            }*/
            char[] cPut = input.toCharArray();//change type to char
            for(int i = 0; i < cPut.length; i++){
                System.out.println(cPut[i]);
            }
        }

    }
}