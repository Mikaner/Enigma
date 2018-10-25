import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Rotor{
    private int num;
    private char top;
    private int[] rotor;
    private static int rotorSum;
    private static char firstAlph = 'A';
    private static char lastAlph = 'Z';
    private static int alphSum  = lastAlph-firstAlph+1;
    private static char[] alphabet = new char[alphSum];
    private static int[] exchangeRotor = new int[alphSum];
                                //{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25}
    private static int[] rotor1 = {13,23,15,22, 6,25, 4, 9,21, 7,24,19,20, 0,17, 2,18,14,16,11,12, 8, 3, 1,10, 5};//
    private static int[] rotor2 = {12,20,10,19,14, 6, 5,16,25,24, 2,13, 0,11, 4,17, 7,15,23, 3, 1,22,21,18, 9, 8};//
    private static int[] rotor3 = {14,21, 6,25,22,17, 2,23,15,20,24,19,13,12, 0, 8,18, 5,16,11, 9, 1, 4, 7,10, 3};//
    private static final Map<Character, Integer> alphabetToNum;
    static {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < alphSum; i++){
            map.put((char)(firstAlph+i), i);
            alphabet[i] = (char)(firstAlph+i);
        }
        alphabetToNum = Collections.unmodifiableMap(map);
    }
    
    public Rotor(int num, char top){
        this.num = num;
        this.top = top;
        setRotor(num, top);
        rotorSum++;
    }

    public void setRotor(int number, char topAlph){
        num = number;
        top = topAlph;
        switch (number){
            case 1:
                rotor = rotor1;
                break;
            case 2:
                rotor = rotor2;
                break;
            case 3:
                rotor = rotor3;
                break;
            default:
                System.out.println("Please set the number of the rotor between 1 and 3.");
                break;
        }
    }

    public static void setExchange(char c1, char c2){
        for(int i = 0; i < alphSum; i++){
            if(alphabet[i] == c1){
                exchangeRotor[i] = alphabetToNum.get(c2);
            }else if (alphabet[i] == c2){
                exchangeRotor[i] = alphabetToNum.get(c1);
            }else{
                exchangeRotor[i] = i;
            }
        }
    }

    public int getNum(){
        return num;
    }
    public char getTop(){
        return top;
    }
    public static int getRotorSum(){
        return rotorSum;
    }
    public static int getAlphSum(){
        return alphSum;
    }
    public static char getAlphabet(int i){
        return alphabet[i];
    }
    public static int getAlphabetToNum(char a){
        return alphabetToNum.get(a);
    }
    public static int getExchangeRotor(int i){
        return exchangeRotor[i];
    }
}