/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.laforerobert.stack.convert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author Admin
 */
public class ReverserApp {


    public static void main(String[] args) throws IOException {
        String input,output;
        while (true){
            System.out.println("Enter a string: ");
            System.out.flush();
            input = getString();
            if (input.equals("")){
                break;
            }
            Reverser theReverser = new Reverser(input);
            //output = theReverser.doRev();
            System.out.println("Reverser: "+ theReverser.toString());
        }
    }
    
    public static String getString() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
    
}
