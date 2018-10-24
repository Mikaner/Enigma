import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Roter{
    private int num;
    private char top;
    private static int roterSum;
    private static char firstAlph = 'A';
    private static char lastAlph = 'Z';
    private static int alphSum  = lastAlph-firstAlph;
    private static char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    private static int[] exchangeRoter = new int[alphSum];
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