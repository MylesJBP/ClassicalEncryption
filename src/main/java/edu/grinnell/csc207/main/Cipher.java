package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

public class Cipher {
  public static void Vigenere(String eOrD, String key, String message){
    PrintWriter pen = new PrintWriter(System.out, true);
    if(eOrD.equals("encode")){
      pen.printf("Key = %s: %s\n", key, CipherUtils.vigenereEncrypt(message, key));
    }
    else{
      pen.printf("Key = %s: %s\n", key, CipherUtils.vigenereDecrypt(message, key));
    }
    pen.close();
  }

  public static void Caesar(String eOrD, char key, String message){
    PrintWriter pen = new PrintWriter(System.out, true);
    if(eOrD.equals("encode")){
      pen.printf("Key = %c: %s\n", key, CipherUtils.caesarEncrypt(message, key));
    }
    else{
      pen.printf("Key = %c: %s\n", key, CipherUtils.caesarDecrypt(message, key));
    }
    pen.close();
  }

  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);

    if(args.length != 4){
      System.err.println("Error: Incorrect Number of Parameters");
    }
    else{
      String type = "", key = "", eOrd = "", message = "";
      int dashed = 0, solid = 0;
      char keyC;

      for(int i = 0; i < args.length; i++){
        if(args[i].charAt(0) == '-'){
          if(dashed > 2){
            System.err.println("ERROR: Invalid Parameters A");
            break;
          }
          else{
            if(args[i].equals("-encode")){
              eOrd = "encode";
            }
            else if (args[i].equals("-decode")){
              eOrd = "decode";
            }
            else if(args[i].equals("-caesar")){
              if(key.length() > 1){
                System.err.println("ERROR: Invalid Parameters B");
                break;
              }
              else{
                type = "ceasar";
              }
            }
            else if(args[i].equals("-vigenere")){
              type = "vigenere";
            }
            else{
              System.err.println("Error: Invalid Parameters C");
            }
            dashed += 1;
          }
        }
        else{
          if(solid > 2){
            System.err.println("ERROR: Invalid Parameters D");
          }
          else if(solid == 1){
            if(type == "caesar" && args[i].length() > 1){
              System.err.println("Error: Attempting Ceasar Cipher With Multi-Character Key");
            }
            else{
              key = args[i];
            }
          }
          else if(solid == 0){
            message = args[i];
          }
          solid += 1;
        }     
      }
      if(type.equals("vigenere")){
        Vigenere(eOrd, key, message);
      }
      else{
        keyC = key.charAt(0);
        Caesar(eOrd, keyC, message);
      }
    }
    pen.close();
  }
}
