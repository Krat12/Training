/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.laforerobert.stack.stackimplementation;

/**
 *
 * @author Admin
 */
public class AppStack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long[] stackArray = {1, 2, 3, 4, 5, 6};
        StackX theStack = new StackX(stackArray); // create new stack
        while (!theStack.isEmpty()) {//Пока стек не станет пустым
            long value = theStack.pop();
            System.out.println(value);
            System.out.println(" ");
        }

    }

}
