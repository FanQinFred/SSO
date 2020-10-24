package Utils;

public class XorEncryption {
    public static String stringEncryption(String para, int key){
        char[] charArray = para.toCharArray();
        for(int i =0;i<charArray.length;i++){
            charArray[i]=(char)(charArray[i]^key);
        }
        return String.valueOf(charArray);
    }
    public String stringDecryption(String para, int key){
        char[] charArray = para.toCharArray();
        for(int i =0;i<charArray.length;i++){
            charArray[i]=(char)(charArray[i]^key);
        }
        return String.valueOf(charArray);
    }
}
