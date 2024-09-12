package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

public class AllCaesar {

  /**
   * Run the program.
   *
   * @param args
   *   The command-line arguments. Each should be a string that represents
   *   a fraction.
   *
   * @throws Exception
   *   When something goes seriously wrong, such as creating an invalid
   *   fraction or failing to set up a printwriter.
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    int count = 0, validity = 1;
    char[] alphabet = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    if(args.length != 2){
      // change to System.err
      System.err.println("Error: Incorrect number of parameters.");
    }
    else{
      for(String arg : args){
        if(count == 0){
          if(!arg.equals("decode") && !arg.equals("encode")) {
            // change to system.err
            System.err.println("Error: Invalid option: \"" + arg + "\". Valid options are \"encode\" or \"decode\".\n");
            validity = 0;
            break;
          }
        }
        else if(count == 1){
          char[] chars = arg.toCharArray();

          for(char letter : chars){
            int check = 0;
            for(char valid : alphabet){
              if(letter == valid){
                check = 1;
                break;
              }
            }
            if(check == 0){
              System.err.println("Error: String contains characters other than lowercase letters.");
              validity = 0;
            }
          }         
        }
        count += 1;
      }
      if(validity == 1 && args[0].equals("encode")){
        for (char ch = 'a'; ch <= 'z'; ch++) {
          pen.printf("n = %c: %s\n", ch, CipherUtils.caesarEncrypt(args[1], ch));
        }
      }
      else if(validity == 1 && args[0].equals("decode")){
        for (char ch = 'a'; ch <= 'z'; ch++) {
          pen.printf("n = %c: %s\n", ch, CipherUtils.caesarDecrypt(args[1], ch));
        }
      }
      pen.close();
    }
  }
}
