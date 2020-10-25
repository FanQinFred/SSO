package Utils;
/**
 * @className: XorEncryption
 * @packageName: Utils
 * @description: 用于code的加密解密
 **/
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
