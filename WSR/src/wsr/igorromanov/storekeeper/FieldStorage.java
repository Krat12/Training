package wsr.igorromanov.storekeeper;

import java.awt.Image;
import javax.swing.ImageIcon;


public class FieldStorage {
    private  String nameFabric;
    private  String vendor_cod;
    private  String colour;
    private  String consist;
    private  int roll;
    private  String widthFabric;
    private  int lengthFabric;
    private  float costFabric;
    private  byte[] imageFabric;
    private  String type;
    private  float heft;
    private  int party;
    private  int amount;
    private  String nameFittings;
    private  byte[] imageFittings;
    private int fittingsID;
    private int fabricID;
    private float lengthFittings;
    private float costFittings;
    private float widthFittings;
    
    
    public FieldStorage() {
    }

    public FieldStorage(String type, float heft, int party, int amount, String nameFittings, byte[] imageFittings, int FittingsID, float lengthFittings, float costFittings, float widthFittings) {
        this.type = type;
        this.heft = heft;
        this.party = party;
        this.amount = amount;
        this.nameFittings = nameFittings;
        this.imageFittings = imageFittings;
        this.fittingsID = FittingsID;
        this.lengthFittings = lengthFittings;
        this.costFittings = costFittings;
        this.widthFittings = widthFittings;
    }


    
   

    public FieldStorage(String name, String vendor_cod, String colour, String consist, int roll, String width, int length, float cost, byte[] image, int ID) {
        this.nameFabric = name;
        this.vendor_cod = vendor_cod;
        this.colour = colour;
        this.consist = consist;
        this.roll = roll;
        this.widthFabric = width;
        this.lengthFabric = length;
        this.costFabric = cost;
        this.imageFabric = image;
        fabricID = ID;
    }
    
    

    public String getNameFabric() {
        return nameFabric;
    }

    public String getVendor_cod() {
        return vendor_cod;
    }

    public String getColour() {
        return colour;
    }

    public String getConsist() {
        return consist;
    }

    public int getRoll() {
        return roll;
    }

    public String getWidth() {
        return widthFabric;
    }

    public int getLength() {
        return lengthFabric;
    }

    public float getCost() {
        return costFabric;
    }
    
    public Object[] getRowFabric(){
      Object[] Row = {getNameFabric(),getColour(),getConsist(),getLength(),getRoll(),getImageFabric()};
       return Row;
    }
    
   public Object[] getRowFittings(){
      Object[] Row = {getNameFittings(),getType(),getHeft(),getAmount(),getParty(),getImageFittings()};
       return Row;
    }
    
    private ImageIcon getImageFabric(){
        return new ImageIcon(new ImageIcon(imageFabric).getImage().getScaledInstance(150,50,Image.SCALE_SMOOTH));
    }
      private ImageIcon getImageFittings(){
        return new ImageIcon(new ImageIcon(imageFittings).getImage().getScaledInstance(150,50,Image.SCALE_SMOOTH));
    }

    public byte[] getPicture() {
        return imageFabric;
    }

    public String getType() {
        return type;
    }

    public float getHeft() {
        return heft;
    }

    public int getParty() {
        return party;
    }

    public int getAmount() {
        return amount;
    }

    public String getNameFittings() {
        return nameFittings;
    }

    public byte[] getImage() {
        return imageFittings;
    }

    public int getFittingsID() {
        return fittingsID;
    }

    public float getLengthFittings() {
        return lengthFittings;
    }

    public float getCostFittings() {
        return costFittings;
    }

    public float getWidthFittings() {
        return widthFittings;
    }

    public int getFabricID() {
        return fabricID;
    }

    
    
    

}
