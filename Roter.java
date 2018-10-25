import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Roter{
    private int num;
    private char top;
    private int[] roter;
    private static int roterSum;
    private static char firstAlph = 'A';
    private static char lastAlph = 'Z';
    private static int alphSum  = lastAlph-firstAlph+1;
    private static char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    private static int[] exchangeRoter = new int[alphSum];
                                //{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25}
    private static int[] roter1 = {13,23,15,22, 6,25, 4, 9,21, 7,24,19,20, 0,17, 2,18,14,16,11,12, 8, 3, 1,10, 5};//
    private static int[] roter2 = {12,20,10,19,14, 6, 5,16,25,24, 2,13, 0,11, 4,17, 7,15,23, 3, 1,22,21,18, 9, 8};//
    private static int[] roter3 = {14,21, 6,25,22,17, 2,23,15,20,24,19,13,12, 0, 8,18, 5,16,11, 9, 1, 4, 7,10, 3};//
    private static final Map<Character, Integer> alphabetToNum;
    static {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < alphSum; i++){
            map.put((char)(firstAlph+i), i);
        }
        alphabetToNum = Collections.unmodifiableMap(map);
    }
    
    public Roter(int num, char top){
        this.num = num;
        this.top = top;
        roterSum++;
    }

    public void setRoter(int number, char topAlph){
        num = number;
        top = topAlph;
    }

    public static void setExchange(char c1, char c2){
        for(int i = 0; i < alphSum; i++){
            if(alphabet[i] == c1){
                exchangeRoter[i] = alphabetToNum.get(c2);
            }else if (alphabet[i] == c2){
                exchangeRoter[i] = alphabetToNum.get(c1);
            }else{
                exchangeRoter[i] = i;
            }
        }
    }

    public int getNum(){
        return num;
    }
    public char getTop(){
        return top;
    }
    public static int getRoterSum(){
        return roterSum;
    }
    public static int getAlphSum(){
        return alphSum;
    }
    public static int getAlphabetToNum(char a){
        return alphabetToNum.get(a);
    }
    public static int getExchangeRoter(int i){
        return exchangeRoter[i];
    }
}