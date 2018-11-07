package com.headfirst.trinning.object;

import com.headfirst.trinning.abstracts.Duck;


public class ReactDuck extends Duck{

    @Override
    public void display() {
        
    }

    public ReactDuck() {
        flyBehavior = new FlyWitcthWings();
        quackBehavior = new Quack();
    }
    
    
    
    

}
