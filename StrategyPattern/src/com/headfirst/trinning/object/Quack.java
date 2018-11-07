package com.headfirst.trinning.object;

import com.headfirst.trinning.interfaces.QuackBehavior;


public class Quack implements QuackBehavior{

    @Override
    public void quack() {
        System.out.println("Quack");
    }
    

}
