package com.coursejavacore.homework2.models;

public class Creature {
    private int maxJumpHeight;
    private int maxRunDistance;

    private String Name;

    public String getName() {
        return Name;
    }

    public Creature(String name) {
        Name = name;
    }
}
