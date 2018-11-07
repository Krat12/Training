package com.headfirst.trinning.object;

import com.headfirst.trinning.interfaces.FlyBehavior;


public class FlyWitcthWings implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("Умеет летать");
    }

}
