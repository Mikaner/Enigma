public class Roter{
    private int num;
    private char top;
    private static char char1,char2;
    private static int roterNum;
    private static char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    
    public Roter(int num, char top){
        this.num = num;
        this.top = top;
        roterNum++;
    }

    public static void setExchange(char c1, char c2){
        char1 = c1;
        char2 = c2;
    }

    public int getNum(){
        return num;
    }
    public char getTop(){
        return top;
    }
    public String getExchange(){
        return char1+" "+char2;
    }
    public static int getRoterNum(){
        return roterNum;
    }
}