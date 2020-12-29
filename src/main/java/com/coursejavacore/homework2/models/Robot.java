package com.coursejavacore.homework2.models;

import com.coursejavacore.homework2.interfaces.IAction;

public class Robot extends Creature implements IAction {
    //Height in centimeters
    private int maxJumpHeight = 20;
    //Length in kilometers
    private int maxRunDistance = 20;
    private boolean obstracleIsComplete = true;

    public Robot(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public boolean isObstracleIsComplete() {
        return obstracleIsComplete;
    }

    @Override
    public boolean Run(int distanceInKilometers) {
        if(distanceInKilometers < maxRunDistance)
        {
            System.out.format("%s пробежал %d километр(ов)\n", getName(), distanceInKilometers);
            return true;
        }

        else
        {
            System.out.format("%s превысил максимальную дистанцию %d километр(ов)\n", getName(), maxRunDistance);
            return false;
        }
    }

    @Override
    public boolean Jump(int heightInCentimeters) {
        if(heightInCentimeters < maxJumpHeight)
        {
            System.out.format("%s прыгнул на %d сантиметр(ов)\n", getName(), heightInCentimeters);
            return true;
        }
        else
        {
            System.out.format("%s превысил максимальную высоту %d сантиметр(ов)\n", getName(), maxRunDistance);
            return false;
        }

    }
}
