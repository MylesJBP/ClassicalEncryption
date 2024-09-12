package edu.grinnell.csc207.util;

public class CipherUtils {
  private static int letter2int(char letter) {
    char[] alphabet = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    for(int i = 0; i <= 25; i++){
      if(letter == alphabet[i]){
        return i;
      }
    }
    return -1; // STUB
  }

  private static char int2letter(int i) {
    char[] alphabet = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    return alphabet[i];
  }

  public static String caesarEncrypt(String str, char letter) {
    int key;
    char[] chars = str.toCharArray();
    key = letter2int(letter);
    for(int i = 0; i < str.length(); i++){
      chars[i] = int2letter((letter2int(chars[i]) + key) % 26);
    }
    str = new String(chars);
    return str; // STUB
  }

  public static String caesarDecrypt(String str, char letter) {
    int key;
    char[] chars = str.toCharArray();
    key = letter2int(letter);
    for(int i = 0; i < str.length(); i++){
      int letDiff;
      letDiff = (letter2int(chars[i]) - key) % 26;
      if(letDiff >= 0){
        chars[i] = int2letter(letDiff);
      }
      else{
        chars[i] = int2letter(-letDiff);
      }
    }
    str = new String(chars);
    return str; // STUB
  }

  public static String vigenereEncrypt(String str, String key) {
    char[] keyCh = key.toCharArray();
    char[] chars = str.toCharArray();
    for(int i = 0; i < str.length(); i++){
      chars[i] = int2letter((letter2int(chars[i]) + letter2int(keyCh[i%key.length()])) % 26);
    }
    str = new String(chars);
    return str; // STUB
  }

  public static String vigenereDecrypt(String str, String key) {
    char[] keyCh = key.toCharArray();
    char[] chars = str.toCharArray();
    for(int i = 0; i < str.length(); i++){
      chars[i] = int2letter((letter2int(chars[i]) - letter2int(keyCh[i%key.length()])) % 26);
    }
    str = new String(chars);
    return str; // STUB
  }
}
