package com.coursejavacore.homework2.models;

import com.coursejavacore.homework2.interfaces.IAction;
import com.coursejavacore.homework2.interfaces.IObstacle;

public class RunningTrack implements IObstacle {
    protected int length;

    public RunningTrack(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public boolean isPassed(IAction creature) {
        if(creature.Jump(length))
        {
            System.out.format("%s преодалел дистанцию в %d километров\n", creature.toString(), length);
            return true;
        }
        return false;
    }
}
