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

public class AllCaesar {
  /**
   *
   * @param args
   *   The command-line arguments. Each should be a string that represents
   *   a fraction.
   *
   * @throws Exception
   *   When something goes seriously wrong, such as creating an invalid
   *   fraction or failing to set up a printwriter.
   */

   public static String getED{

   }
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    int count = 0, validity = 1;
    char[] alphabet = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    if(args.length != 2){
      System.err.println("Error: Incorrect Number of Parameters.");
    } // if
    else{
      for(String arg : args){
        if(count == 0){
          if(!arg.equals("decode") && !arg.equals("encode")) {
            System.err.println("Error: Invalid option: \"" + arg + "\". Valid options are \"encode\" or \"decode\".\n");
            validity = 0;
            break;
          } // if
        } // if
        else if(count == 1) {
          char[] chars = arg.toCharArray();
          for(char letter : chars){
            int check = 0;
            for(char valid : alphabet){
              if(letter == valid){
                check = 1;
                break;
              } // if
            } // for
            if(check == 0){
              System.err.println("Error: String contains characters other than lowercase letters.");
              validity = 0;
            } // if
          } // for       
        } // else if
        count += 1;
      } // for
      if(validity == 1 && args[0].equals("encode")){
        for(char ch = 'a'; ch <= 'z'; ch++) {
          pen.printf("n = %c: %s\n", ch, CipherUtils.caesarEncrypt(args[1], ch));
        } // for
      } // if
      else if(validity == 1 && args[0].equals("decode")){
        for (char ch = 'a'; ch <= 'z'; ch++) {
          pen.printf("n = %c: %s\n", ch, CipherUtils.caesarDecrypt(args[1], ch));
        } // for
      } // else if
      pen.close();
    } // else
  } // main
} // AllCaesar
