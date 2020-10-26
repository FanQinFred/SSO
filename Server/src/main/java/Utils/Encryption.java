package Utils;
/**
 * @className: Encryption
 * @packageName: Utils
 * @description: 用于code的加密解密
 **/
public class Encryption {
    public static String stringEncryption(String para, int key){
//        char[] charArray = para.toCharArray();
//        for(int i =0;i<charArray.length;i++){
//            charArray[i]=(char)(charArray[i]^key);
//        }
//        return String.valueOf(charArray);
        return new StringBuilder(para).reverse().toString();
    }
    public static String stringDecryption(String para, int key){
//        char[] charArray = para.toCharArray();
//        for(int i =0;i<charArray.length;i++){
//            charArray[i]=(char)(charArray[i]^key);
//        }
//        return String.valueOf(charArray);
        return new StringBuilder(para).reverse().toString();
    }
}
