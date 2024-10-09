package edu.grinnell.csc207.main;

import java.io.PrintWriter;

import edu.grinnell.csc207.util.CipherUtils;

/**
 * Author: Myles Bohrer-Purnell.
 * Course: CSC207 - Object Oriented Programming.
 * Mini-Project 1.
 * Instructor: Sam Rebelsky.
 * 9/12/2024.
 */
public class Cipher {
  /**
   * Expected input length.
   */
  public static final int EXPECTED_LEN = 4;

  /**
   * Returns whether the user specified that their message be encoded or decoded.
   * Returns invalid if no specification exists.
   * @param args
   * command-line user input, should be of length 4.
   * @return
   * returns the String encode, decode or Invalid.
   */
  public static String getED(String[] args) {
    for (int i = 0; i < args.length; i++) {
      if (args[i].charAt(0) == '-') {
        if (args[i].equals("-encode")) {
          return "encode";
        } else if (args[i].equals("-decode")) {
          return "decode";
        } // else if
      } // if
    } // for
    return "Invalid";
  } // getED
  /**
   * Returns the key used to encode/decode the specified message.
   * @param args
   * command-line user input, should be of length 4.
   * @return
   * returns the String of the key or Invalid.
   */
  public static String getKey(String[] args) {
    int count = 0;
    for (int i = 0; i < args.length; i++) {
      if (args[i].length() == 0) {
        return "Invalid";
      } // if
      if (args[i].charAt(0) != '-') {
        if (count == 1) {
          return args[i];
        } else {
          count += 1;
        } // else
      } // if
    } // for
    return "Invalid";
  } // getKey
  /**
   * Returns the message to be encoded/decoded.
   * @param args
   * command-line user input, should be of length 4.
   * @return
   * returns the String of message or Invalid.
   */
  public static String getMess(String[] args) {
    for (int i = 0; i < args.length; i++) {
      if (args[i].charAt(0) != '-') {
        return args[i];
      } // if
    } // for
    return "Invalid";
  } // getMess
  /**
   * Returns the type of cipher specified to be used for encoding/decoding.
   * @param args
   * command-line user input, should be of length 4.
   * @return
   * returns the String of the type of Cipher or Invalid.
   */
  public static String getType(String[] args) {
    for (int i = 0; i < args.length; i++) {
      if (args[i].charAt(0) == '-') {
        if (args[i].equals("-caesar")) {
          return "caesar";
        } else if (args[i].equals("-vigenere")) {
          return "vigenere";
        } // else if
      } // if
    } // for
    return "Invalid";
  } // getType
  /**
   * Uses specified parameters to encode or decode using the Vigenere cipher.
   * @param eOrD
   * String, whether the message should be encoded or decoded
   * @param key
   * String, the key that should be used to encrypt/decrypt the message
   * @param message
   * String, the message for encoding/decoding.
   */
  public static void vigenere(String eOrD, String key, String message) {
    PrintWriter pen = new PrintWriter(System.out, true);
    if (eOrD.equals("encode")) {
      String encrypted = CipherUtils.vigenereEncrypt(message, key);
      if (!encrypted.equals("Invalid")) {
        pen.printf(CipherUtils.vigenereEncrypt(message, key));
      } // if
    } else {
      String decrypted = CipherUtils.vigenereDecrypt(message, key);
      if (!decrypted.equals("Invalid")) {
        pen.printf(CipherUtils.vigenereDecrypt(message, key));
      } // if
    } // else
    pen.close();
  } // Vigenere
  /**
   * Uses specified parameters to encode or decode using the Caesar cipher.
   * @param eOrD
   * String, whether the message should be encoded or decoded
   * @param key
   * String, the key that should be used to encrypt/decrypt the message
   * @param message
   * String, the message for encoding/decoding.
   */
  public static void caesar(String eOrD, char key, String message) {
    PrintWriter pen = new PrintWriter(System.out, true);
    if (eOrD.equals("encode")) {
      String encrypted = CipherUtils.caesarEncrypt(message, key);
      if (!encrypted.equals("Invalid")) {
        pen.printf(CipherUtils.caesarEncrypt(message, key));
      } // if
    } else {
      String decrypted = CipherUtils.caesarDecrypt(message, key);
      if (!decrypted.equals("Invalid")) {
        pen.printf(CipherUtils.caesarDecrypt(message, key));
      } // if
    } // else
    pen.close();
  } // Caesar
  /**
   * Takes in command-line input and generates the Caesar or Vigenere cipher equivalent
   * output based on user specifications.
   * @param args
   * command-line user input, should be of length 4.
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    char keyC;
    String eOrd;
    String message;
    String key;
    String type;
    if (args.length != EXPECTED_LEN) {
      System.err.println("Error: Incorrect Number of Parameters");
    } else {
      eOrd = getED(args);
      message = getMess(args);
      key = getKey(args);
      type = getType(args);

      if (eOrd.equals("Invalid") || message.equals("Invalid")
          || key.equals("Invalid") || type.equals("Invalid")
          || AllCaesar.checkMess(message) == -1 || AllCaesar.checkMess(key) == -1) {
        System.err.println("Error: Invalid Input");
      } else if (type.equals("vigenere")) {
        vigenere(eOrd, key, message);
      } else {
        if (key.length() > 1) {
          System.err.println("Error: Key Must be 1 Character");
        } else {
          keyC = key.charAt(0);
          caesar(eOrd, keyC, message);
        } // else
      } // if
    } // else
    pen.close();
  } // main
} // cipher
