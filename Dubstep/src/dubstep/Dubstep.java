/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dubstep;

/**
 *
 * @author Admin
 */
public class Dubstep {
    
   private static final String ONE_SPACE = " ";
   private static final String TWO_SPACE = "  ";

    public static void main(String[] args) {
        
        System.out.println(SongDecoder("WUBfdWUB"));
    }
    


 public static String SongDecoder (String song) {
      
      String newString = song.replace("WUB", ONE_SPACE);
      
      while (newString.contains(TWO_SPACE)) {

          String rendeString  = newString.replace(TWO_SPACE, ONE_SPACE);
          newString = rendeString;
      }
      
      return newString.trim();
  }
    
}
