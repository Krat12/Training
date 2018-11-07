/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.headfirst.trinning.abstracts.Duck;
import com.headfirst.trinning.object.MallDuck;

/**
 *
 * @author Admin
 */
public class MiniDuckSimulator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Duck duck = new MallDuck();
        duck.perfomFly();
        duck.perfomQuack();
    }
    
}
