import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Rotor{
    private static char firstAlph = 'A';
    private static char lastAlph = 'Z';
    private static int alphSum  = lastAlph-firstAlph+1;
    private int num;
    private int top;
    private int[] rotor = new int[alphSum];
    private static int rotorSum;
    private static int rotateSum;
    private static int[] exchangeRotor = new int[alphSum];
                                    //{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25}
    private static int[] rotor1 =     {13,23,15,22, 6,25, 4, 9,21, 7,24,19,20, 0,17, 2,18,14,16,11,12, 8, 3, 1,10, 5};//
    private static int[] rotor2 =     {12,20,10,19,14, 6, 5,16,25,24, 2,13, 0,11, 4,17, 7,15,23, 3, 1,22,21,18, 9, 8};//
    private static int[] rotor3 =     {14,21, 6,25,22,17, 2,23,15,20,24,13,19,11, 0, 8,18, 5,16,12, 9, 1, 4, 7,10, 3};//
    private static int[] rotor4 =     {15, 8, 4,22, 2,12,17,21, 1,11,18, 9, 5,23,16, 0,14, 6,10,20,19, 7, 3,13,25,24};//
    private static int[] returnRotor= {25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    private static char[] alphabet = new char[alphSum];
    private static char[] alphabetExchange = new char[alphSum];
    private static final Map<Character, Integer> alphabetToNum;
    static {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < alphSum; i++){
            map.put((char)(firstAlph+i), i);
            alphabet[i] = (char)(firstAlph+i);
        }
        alphabetToNum = Collections.unmodifiableMap(map);
    }
    
    public Rotor(){
        rotorSum++;
    }

    public void setRotor(int number, char topAlph){
        num = number;//do not need
        top = topAlph-firstAlph;
        if(java.util.Objects.equals(1,num)){
            for(int i = 0; i < alphSum; i++){
                rotor[i] = (alphSum+rotor1[(top+i)%alphSum]-top)%alphSum;
            }
        }else if(java.util.Objects.equals(2,num)){
            for(int i = 0; i < alphSum; i++){
                rotor[i] = (alphSum+rotor2[(top+i)%alphSum]-top)%alphSum;
            }
        }else if(java.util.Objects.equals(3,num)){
            for(int i = 0; i < alphSum; i++){
                rotor[i] = (alphSum+rotor3[(top+i)%alphSum]-top)%alphSum;
            }
        }else if(java.util.Objects.equals(4,num)){
            for (int i = 0; i < alphSum; i++) {
                rotor[i] = (alphSum+rotor4[(top+i)%alphSum]-top)%alphSum;
            }
        }else{
            System.out.println("Please set the number of rotor between 1 and 4.");
        }
    }

    public static void setExchange(char c1, char c2){
        for(int i = 0; i < alphSum; i++){
            if(alphabet[i] == c1){
                exchangeRotor[i] = alphabetToNum.get(c2);
                alphabetExchange[i] = alphabet[alphabetToNum.get(c2)];
            }else if (alphabet[i] == c2){
                exchangeRotor[i] = alphabetToNum.get(c1);
                alphabetExchange[i] = alphabet[alphabetToNum.get(c1)];
            }else{
                exchangeRotor[i] = i;
                alphabetExchange[i] = alphabet[i];
            }
        }
    }

    public char changeAlphabet(char a){
        return alphabet[alphabetToNum.get(a)];
    }

    public void rotate(){
        int save = rotor[0]-1 >= 0 ? rotor[0]-1 : 25;
        for(int i = 0; i < alphSum; i++){
            rotor[i] = rotor[(i+1)%alphSum]-1 >= 0 ? rotor[(i+1)%alphSum]-1 : 25;
            //System.out.print(","+rotor[i]);
        }
        rotor[alphSum-1] = save;
    }

    public int conversion(int n){
        return rotor[n];
    }

    public static int exchange(char a){
        return exchangeRotor[alphabetToNum.get(a)];
    }

    public static char exchange(int n){
        return alphabetExchange[n];
    }

    public static int returnNum(int n){
        return returnRotor[n];
    }

    public static void plusRotateSum(){
        rotateSum++;
    }

    public int getNum(){
        return num;
    }
    public int getTop(){
        return top;
    }
    public static int getRotorSum(){
        return rotorSum;
    }
    public static int getRotateSum(){
        return rotateSum;
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