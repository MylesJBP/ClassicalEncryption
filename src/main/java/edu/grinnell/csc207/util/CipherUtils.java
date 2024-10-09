package edu.grinnell.csc207.util;
/**
 * Author: Myles Bohrer-Purnell.
 * Course: CSC207 - Object Oriented Programming.
 * Mini-Project 1.
 * Instructor: Sam Rebelsky.
 * 9/12/2024.
 */

public class CipherUtils {
  /**
   * Essential number used for encrypt/decrypt formulas.
   */
  public static final int TWENTY_SIX = 26;
  /**
   * Used to go through the elements in the alphabet.
   */
  public static final int TWENTY_FIVE = 25;

  /**
   * Returns the index equivalent a letter of the alphabet.
   * @param letter
   * A lowercase letter of the alphabet.
   * @return
   * returns the integer index of the letter or -1 if the letter is invalid.
   */
  private static int letter2int(char letter) {
    char[] alphabet = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                                  'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                                  's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    for (int i = 0; i <= TWENTY_FIVE; i++) {
      if (letter == alphabet[i]) {
        return i;
      } // if
    } // for
    return -1;
  } // letter2int
  /**
   * Returns the letter equivalent of the index of an inputed
   * integer in the alphabet.
   * @param i
   * The integer index of some letter in the alphabet.
   * @return
   * returns a letter of the alphabet.
   */
  private static char int2letter(int i) {
    char[] alphabet = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                                  'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                                  's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    return alphabet[i];
  } // int2letter
  /**
   * Returns the encrypted message of the inputed string using the key "letter"
   * with the Caesar cipher.
   * @param str
   * A string to be encrypted.
   * @param letter
   * A letter of the alphabet used as a key.
   * @return
   * The encrypted message as a String.
   */
  public static String caesarEncrypt(String str, char letter) {
    int key;
    char[] chars = str.toCharArray();
    key = letter2int(letter);
    for (int i = 0; i < str.length(); i++) {
      int index = (letter2int(chars[i]) + key) % TWENTY_SIX;
      if (index >= 0 && index <= TWENTY_FIVE) {
        chars[i] = int2letter(index);
      } else {
        return "Invalid";
      } // else
    } // for
    str = new String(chars);
    return str;
  } // caesarEncrypt
  /**
   * Returns the descryped message of the inputed string using the key "letter"
   * with the Caesar cipher.
   * @param str
   * A string to be encrypted.
   * @param letter
   * A letter of the alphabet used as a key.
   * @return
   * The decrypted message as a String.
   */
  public static String caesarDecrypt(String str, char letter) {
    int key;
    char[] chars = str.toCharArray();
    key = letter2int(letter);
    for (int i = 0; i < str.length(); i++) {
      int letDiff;
      letDiff = (letter2int(chars[i]) - key) % TWENTY_SIX;
      if (letDiff >= 0) {
        chars[i] = int2letter(letDiff);
      } else {
        chars[i] = int2letter(TWENTY_SIX + (letter2int(chars[i]) - key));
      } // else
    } // for
    str = new String(chars);
    return str;
  } // caesarDecrypt
  /**
   * Returns the encrypted message of the inputed string using the key "letter"
   * with the Vigenere cipher.
   * @param str
   * A string to be encrypted.
   * @param key
   * A letter of the alphabet used as a key.
   * @return
   * The encrypted message as a String.
   */
  public static String vigenereEncrypt(String str, String key) {
    char[] keyCh = key.toCharArray();
    char[] chars = str.toCharArray();
    for (int i = 0; i < str.length(); i++) {
      int index = (letter2int(chars[i]) + letter2int(keyCh[i % key.length()]))
                            % TWENTY_SIX;
      if (index >= 0 && index <= TWENTY_FIVE) {
        chars[i] = int2letter(index);
      } else {
        return "Invalid";
      } // else
    } // for
    str = new String(chars);
    return str;
  } // vigenereEncrypt
  /**
   * Returns the decryped message of the inputed string using the key "letter"
   * with the Viginere cipher.
   * @param str
   * A string to be encrypted.
   * @param key
   * A letter of the alphabet used as a key.
   * @return
   * The decrypted message as a String.
   */
  public static String vigenereDecrypt(String str, String key) {
    char[] keyCh = key.toCharArray();
    char[] chars = str.toCharArray();
    for (int i = 0; i < str.length(); i++) {
      int letDiff;
      letDiff = (letter2int(chars[i]) - letter2int(keyCh[i % key.length()])) % TWENTY_SIX;
      if (letDiff >= 0) {
        chars[i] = int2letter(letDiff);
      } else {
        chars[i] = int2letter(TWENTY_SIX + (letter2int(chars[i])
                              - letter2int(keyCh[i % key.length()])));
      } // else
    } // for
    str = new String(chars);
    return str;
  } // vigenereDecrpyt
} // CipherUtils
