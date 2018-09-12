package jtableimage;

import java.awt.Image;
import javax.swing.ImageIcon;


public class Film {
    private final String datafilm;
    private final int budget;
    private final String nameFilm;
    private final byte[] picture;
    private final String NameStud;

    public Film(String datafilm, int budget, String nameFilm, byte[] picture, String NameStud) {
        this.datafilm = datafilm;
        this.budget = budget;
        this.nameFilm = nameFilm;
        this.picture = picture;
        this.NameStud = NameStud;
    }
    

    public String getDatafilm() {
        return datafilm;
    }

    public int getBudget() {
        return budget;
    }

    public String getNameFilm() {
        return nameFilm;
    }

    public byte[] getPicture() {
       
        return picture;
    }

    public String getNameStud() {
        return NameStud;
    }
    
    public ImageIcon Image(){
        return new ImageIcon(new ImageIcon (picture).getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH));
    }
    
    
    public Object getRow(){
      
  Object [] row = {getNameFilm(),getNameStud(),getBudget(),Image()};
        return row;
    }
}
