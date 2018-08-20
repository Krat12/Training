package book.laforerobert.stack.convert;


public class Reverser {
    private String input;
    private String output;

    public Reverser(String in) {
        input = in;
        doRev();
    }
    
    public String doRev(){
        int stackSize = input.length();
        StackX theStack = new StackX(stackSize);
        for (int i = 0; i < input.length(); i++) {
            char sign = input.charAt(i);
            theStack.push(sign);
        }
        output ="";
        while(!theStack.isEmpty()){
            char ch = theStack.pop();
            output = output + ch;
        }
        return output;
    }

    @Override
    public String toString() {
        return output ; //To change body of generated methods, choose Tools | Templates.
    }

    
    
    

}
