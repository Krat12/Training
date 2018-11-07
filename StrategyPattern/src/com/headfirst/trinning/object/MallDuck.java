package com.headfirst.trinning.object;

import com.headfirst.trinning.abstracts.Duck;


public class MallDuck extends Duck{

    @Override
    public void display() {
        System.out.println("я мал утка");
    }

    public MallDuck() {
      flyBehavior = new FlyWitcthWings();
      quackBehavior = new Quack();
    }
    
    
    

}
