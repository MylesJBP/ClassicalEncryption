package edu.grinnell.csc207.util;

public class CipherUtils {
  private static int letter2int(char letter) {
    int[] alphabet = new alphabet[26] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    for(int i = 0; i <= 25, i++){
      if(letter == alphabet[i]){
        return i;
      }
    }
    return -1; // STUB
  }

  private static char int2letter(int i) {
    int[] alphabet = new alphabet[26] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    return alphabet[i];
  }

  public static String caesarEncrypt(String str, char letter) {
    int key;
    key = letter2int(letter);
    for(int i = 0; i < str.length(); i++){
      str[i] = int2letter((letter2int(str[i]) + key) % 26);
    }
    return str; // STUB
  }

  public static String caesarDecrypt(String str, char letter) {
    int key;
    key = letter2int(letter);
    for(int i = 0; i < str.length(); i++) {
      str[i] = int2letter((letter2int(str[i]) - key) % 26);
    }
    return str; // STUB
  }

  public static String vigenereEncrypt(String str, String key) {
    for(int i = 0; i < str.length(); i++){
      str[i] = int2letter((letter2int(str[i]) + letter2int(key[i%key.length()])) % 26);
    }
    return str; // STUB
  }

  public static String vigenereDecrypt(String str, String key) {
    for(int i = 0; i < str.length(); i++){
      str[i] = int2letter((letter2int(str[i]) - letter2int(key[i%key.length()])) % 26);
    }
    return str; // STUB
  }
}
