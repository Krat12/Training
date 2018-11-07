package com.headfirst.trinning.abstracts;

import com.headfirst.trinning.interfaces.FlyBehavior;
import com.headfirst.trinning.interfaces.QuackBehavior;


 public abstract class Duck {
    
    public FlyBehavior flyBehavior;
    public QuackBehavior quackBehavior;
    
    

    public Duck() {
    }
    
    public  abstract void display();
    
    public void perfomFly(){
        flyBehavior.fly();
    }
    
    public void perfomQuack(){
        quackBehavior.quack();
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
    
    
}
