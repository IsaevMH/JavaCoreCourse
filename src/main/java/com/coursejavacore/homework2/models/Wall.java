package com.coursejavacore.homework2.models;

import com.coursejavacore.homework2.interfaces.IAction;
import com.coursejavacore.homework2.interfaces.IObstacle;

public class Wall implements IObstacle {
    protected int weight;

    public Wall(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean isPassed(IAction creature) {
        if(creature.Jump(weight))
        {
            System.out.format("%s преодалел стену в высоту %d метров\n", creature.toString(), weight);
            return true;
        }
        return false;
    }
}
