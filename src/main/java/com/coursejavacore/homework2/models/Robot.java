package com.coursejavacore.homework2.models;

import com.coursejavacore.homework2.interfaces.IAction;

public class Robot implements IAction {
    //Height in centimeters
    private int maxJumpHeight = 20;
    //Length in kilometers
    private int maxRunDistance = 20;
    private String Name;
    public Robot(String name) {
        Name = name;
    }

    public String toString(){
        return Name;
    }
    @Override
    public boolean Run(int distanceInKilometers) {
        if(distanceInKilometers < maxRunDistance)
            return true;
        System.out.format("%s превысил максимальную дистанцию %d километр(ов)\n", Name, maxRunDistance);
        return false;
    }

    @Override
    public boolean Jump(int heightInCentimeters) {
        if(heightInCentimeters < maxJumpHeight)
            return true;
        System.out.format("%s превысил максимальную высоту %d сантиметр(ов)\n", Name, maxRunDistance);
        return false;
    }
}
