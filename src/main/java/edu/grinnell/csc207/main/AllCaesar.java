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
public class AllCaesar {
  /**
   * Checks if a specific message only contains lower case letters in the alphabet.
   * @param message
   * A String message being checked for validity of characters.
   * @return
   * Returns 0 if the message is valid and -1 if it isnt.
   */
  public static int checkMess(String message) {
    char[] alphabet = new char[] {'a', 'b', 'c', 'd', 'e', 'f',
                                  'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                                  's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    char[] chars = message.toCharArray();
    for (char letter : chars) {
      int check = 0;
      for (char valid : alphabet) {
        if (letter == valid) {
          check = 1;
          break;
        } // if
      } // for
      if (check == 0) {
        System.err.println("Error: String contains characters other than lowercase letters.");
        return -1;
      } // if
    } // for
    return 0;
  } // checkMess
  /**
   * Returns a encrypted or decrypted message using the Caesar cipher.
   * @param args
   * A set of command-line arguments with information of whether the user should
   * encode or decode a specified message.
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    if (args.length != 2) {
      System.err.println("Error: Incorrect Number of Parameters.");
    } else if (!args[0].equals("decode") && !args[0].equals("encode")) {
      System.err.println("Error: Invalid option: " + args[0]
                          + ". Valid options are \"encode\" or \"decode\".");
    } else {
      int messVal = checkMess(args[1]);
      if (messVal != -1) {
        if (args[0].equals("encode")) {
          for (char ch = 'a'; ch <= 'z'; ch++) {
            pen.printf("n = %c: %s\n", ch, CipherUtils.caesarEncrypt(args[1], ch));
          } // for
        } else if (args[0].equals("decode")) {
          for (char ch = 'a'; ch <= 'z'; ch++) {
            pen.printf("n = %c: %s\n", ch, CipherUtils.caesarDecrypt(args[1], ch));
          } // for
        } // else if
      } else {
        System.err.println("Error: Incorrect Message Values");
      } // else
    } // else
    pen.close();
  } // main
} // AllCaesar
