package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;
/** 
 * Author: Myles Bohrer-Purnell
 * Course: CSC207 - Object Oriented Programming
 * Mini-Project 1
 * Instructor: Sam Rebelsky
 * 9/12/2024
 */

public class Cipher {
  public static String getED(String[] args){
    for(int i = 0; i < args.length; i++){
      if(args[i].charAt(0) == '-'){
        if(args[i].equals("-encode")){
          return "encode";
        } else if (args[i].equals("-decode")){
          return "decode";
        } // else if
      } // if
    } // for
    return "Invalid";
  } // getED

  public static String getKey(String[] args){
    int count = 0;
    for(int i = 0; i < args.length; i++){
      if(args[i].charAt(0) != '-'){
        if(count == 1){
          return args[i];
        } else{
          count += 1;
        } // else
      } // if
    } // for
    return "Invalid";
  } // getKey

  public static String getMess(String[] args){
    for(int i = 0; i < args.length; i++){
      if(args[i].charAt(0) != '-'){
        return args[i];
      } // if
    } // for
    return "Invalid";
  } // getMess

  public static String getType(String[] args){
    for(int i = 0; i < args.length; i++){
      if(args[i].charAt(0) == '-'){
        if(args[i].equals("-caesar")){
          return "caesar";
        } else if (args[i].equals("-vigenere")){
          return "vigenere";
        } // else if
      } // if
    } // for
    return "Invalid";
  } // getType

  public static void Vigenere(String eOrD, String key, String message){
    PrintWriter pen = new PrintWriter(System.out, true);
    if(eOrD.equals("encode")){
      pen.printf("Key = %s \nEncrypted: %s\n", key, CipherUtils.vigenereEncrypt(message, key));
    } else{
      pen.printf("Key = %s \nDecrypted: %s\n", key, CipherUtils.vigenereDecrypt(message, key));
    } // else
    pen.close();
  } // Vigenere

  public static void Caesar(String eOrD, char key, String message){
    PrintWriter pen = new PrintWriter(System.out, true);
    if(eOrD.equals("encode")){
      pen.printf("Key = %c \nEncrpyted: %s\n", key, CipherUtils.caesarEncrypt(message, key));
    } else{
      pen.printf("Key = %c \nDecrypted: %s\n", key, CipherUtils.caesarDecrypt(message, key));
    } // else
    pen.close();
  } // Caesar

  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    char keyC;
    String eOrd, message, key, type;
    if(args.length != 4){
      System.err.println("Error: Incorrect Number of Parameters");
    } else {
      eOrd = getED(args);
      message = getMess(args);
      key = getKey(args);
      type = getType(args);

      if(eOrd.equals("Invalid") || message.equals("Invalid") || key.equals("Invalid") || type.equals("Invalid")){
        System.err.println("Error: Invalid Input");
      } else if(type.equals("vigenere")){
        Vigenere(eOrd, key, message);
      } else {
        if(key.length() > 1){
          System.err.println("Error: Key Must be 1 Character");
        } else{
          keyC = key.charAt(0);
          Caesar(eOrd, keyC, message);
        }
      } // if
    } // else
    pen.close();
  } // main
} // cipher
