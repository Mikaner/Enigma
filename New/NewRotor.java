import java.util.*;

public class NewRotor{
    private static char firstAlph = 'A';
    private static char lastAlph = 'Z';
    private static int alphSum  = lastAlph-firstAlph+1;
    private int num;
    private int top;
    private int[] rotor = new int[alphSum+1];
    private int[] reRotor = new int[alphSum];
    private static int rotorSum;
    private static int rotateSum;
    private static int[] exchangeRotor = new int[alphSum];
                                   //{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25}
    private static int[] rotor1 =    { 6, 9,18,25,13, 7,24,21,19,16,20,23, 8, 3,12, 1,22,10,14,15, 2, 0, 4,17,11, 5};
    private static int[] rotor2 =    { 3, 1,10,13, 6,22, 5,18,17,14,23, 9, 7,24,21,15, 8,16,12,19,25, 4,20, 0, 2,11};
    private static int[] rotor3 =    {20, 9, 4,13,19, 5, 8,15,18,21,12, 0,11, 6,22, 7,23,24,10, 3,25,14,16, 1,17, 2};
    private static int[] rotor4 =    {15, 8, 5,22, 2,17,16,21,10,11,18, 1,13,23,24,12,14, 6, 7, 0,19, 4, 3, 9,25,20};
    private static int[] rotor5 =    { 1,16,23,18,15,20,22, 4, 7,21, 6,17, 3, 9,25, 2,24, 8,14,13,12, 5,11, 0,19,10};
    private static int[] reflector = {25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    private static int[] reRotor1 =  new int[alphSum];//{21,15,20,13,22,25, 0, 5,12, 1,17,24,14, 4,18,19, 9,23, 2, 8,10, 7,16,11, 6, 3};
    private static int[] reRotor2 =  new int[alphSum];//{23, 1,24, 0,21, 6, 4,12,16,11, 2,25,18, 3, 9,15,17, 8, 7,19,22,14, 5,10,13,20};
    private static int[] reRotor3 =  new int[alphSum];//{11,23,25,19, 2, 5,13,15, 6, 1,18,12,10, 3,21, 7,22,24, 8, 4, 0, 9,14,16,17,20};
    private static int[] reRotor4 =  new int[alphSum];//{19,11, 4,22,21, 2,17,18, 1,23, 8, 9,15,12,16, 0, 6, 5,10,20,25, 7, 3,13,14,24};
    private static int[] reRotor5 =  new int[alphSum];//{23, 0,15,12, 7,21,10, 8,17,13,25,22,20,19,18, 4, 1,11, 3,24, 5, 9, 6, 2,16,14};
    private static char[] alphabet = new char[alphSum];
    private static char[] alphabetExchange = new char[alphSum];
    static {
        for(int i = 0; i < alphSum; i++){
            alphabet[i] = (char)(firstAlph+i);
            exchangeRotor[i] = i;
            alphabetExchange[i] = alphabet[i];
            reRotor1[rotor1[i]] = i;
            reRotor2[rotor2[i]] = i;
            reRotor3[rotor3[i]] = i;
            reRotor4[rotor4[i]] = i;
            reRotor5[rotor5[i]] = i;
        }
    }
    
    public NewRotor(){
        rotorSum++;
    }

    private void set(int[] roNum, int[] reNum, char cally){
        for (int i = 0; i < alphSum; i++) {
            rotor[i] = (alphSum+roNum[(top+i)%alphSum]-top)%alphSum;
            reRotor[i] = (alphSum+reNum[(top+i)%alphSum]-top)%alphSum;
        }
        rotor[alphSum] = (int)cally-firstAlph;
    }

    public void setRotor(int num, char topAlph, char callyAlph){
        this.num = num;//do not need
        top = topAlph-firstAlph;
        if(Objects.equals(1,num)){
            set(rotor1,reRotor1,callyAlph);
        }else if(Objects.equals(2,num)){
            set(rotor2,reRotor2,callyAlph);
        }else if(Objects.equals(3,num)){
            set(rotor3,reRotor3,callyAlph);
        }else if(Objects.equals(4,num)){
            set(rotor4,reRotor4,callyAlph);
        }else if(Objects.equals(5,num)){
            set(rotor5,reRotor5,callyAlph);
        }else{
            System.out.println("Please set the number of rotor between 1 and 5.");
        }
    }

    public static void setExchange(char c1, char c2){
        int ca = c1-firstAlph, cb = c2-firstAlph;
        exchangeRotor[ca] = cb;
        exchangeRotor[cb] = ca;
        alphabetExchange[ca] = alphabet[cb];
        alphabetExchange[cb] = alphabet[ca];
    }

    public char changeAlphabet(char a){
        return alphabet[a-firstAlph];
    }

    public void rotate(){
        int save = rotor[0]-1 >= 0 ? rotor[0]-1 : alphSum-1;
        int reSave = reRotor[0]-1 >= 0 ? reRotor[0]-1 : alphSum-1;
        for(int i = 0; i < alphSum; i++){
            rotor[i] = rotor[(i+1)%alphSum]-1 >= 0 ? rotor[(i+1)%alphSum]-1 : alphSum-1;
            reRotor[i] = reRotor[(i+1)%alphSum]-1 >= 0 ? reRotor[(i+1)%alphSum]-1 : alphSum-1;
        }
        rotor[alphSum-1] = save;
        reRotor[alphSum-1] = reSave;
    }

    public int getRotateNum(){
        return rotor[alphSum];
    }
    public int conversion(int n){
        return rotor[n];
    }

    public int reConversion(int n){
        return reRotor[n];
    }

    public static int exchange(char a){
        return exchangeRotor[a-firstAlph];
    }

    public static char exchange(int n){
        return alphabetExchange[n];
    }

    public static int reflector(int n){
        return reflector[n];
    }

    public static void plusRotateSum(){
        rotateSum++;
    }

    public static char getFirstAlph(){
        return firstAlph;
    }

    public static char getLastAlph(){
        return lastAlph;
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
        return a-firstAlph;
    }
    public static int getExchangeRotor(int i){
        return exchangeRotor[i];
    }
}