package com.coursejavacore;

import com.coursejavacore.homework2.interfaces.IAction;
import com.coursejavacore.homework2.interfaces.IObstacle;
import com.coursejavacore.homework2.models.*;

import java.util.Random;

public class MainApp {


    public static IAction[] creaturesInitialization()
    {
        return new IAction[]
                {
                        new Human("Jack"),
                        new Robot("R2D2"),
                        new Cat("Barsik")
                };
    }

    public static IObstacle[] obstraclesInitialization(int count)
    {
        Random random = new Random();
        IObstacle[] obstacles = new IObstacle[count];
        for (int i = 0; i < obstacles.length; i++)
            if (i % 2 == 0)
                obstacles[i] = new Wall(random.nextInt(25));
            else
                obstacles[i] = new RunningTrack(random.nextInt(25));
        return obstacles;
    }

    public static IAction[] creaturesPassObstacles(IAction[] creatures, IObstacle[] obstacles)
    {
        for (int i = 0; i < obstacles.length; i++)
            for (int j = 0; j < creatures.length; j++)
                if (creatures[j] != null)
                        if(!obstacles[i].isPassed(creatures[j]))
                            creatures[j] = null;
        return creatures;
    }

    public static int countCreaturesCompletedObstracles(IAction[] creatures)
    {
        int count = 0;
        for(int i = 0; i < creatures.length; i++)
            if(creatures[i] != null)
                count++;
            return count;
    }

    public static IAction[] creaturesCompleteObstacles(int count, IAction[] creatures)
    {
        var names = new IAction[count];
        var j = 0;
        for(int i = 0; i < creatures.length; i++)
            if(creatures[i] != null)
            {
                names[j] = creatures[i];
                j++;
            }
        return names;
    }

    public static void Display(IAction[] creatures)
    {
        for(int i = 0; i < creatures.length; i++)
            if(creatures.length > 0)
                System.out.format("%s прошел(а) все испытания\n", creatures[i].toString());
            else
                System.out.println("Победители отсутствуют");
    }

    public static void main(String[] args) {

        //Homework 2
        //initialize objects
        var creatures = creaturesInitialization();
        //Initialize array objects
        var obstacles = obstraclesInitialization(3);
        //Passed obstacles
        var creaturesAfterObstacles = creaturesPassObstacles(creatures, obstacles);
        var countCreatures = countCreaturesCompletedObstracles(creaturesAfterObstacles);
        var nameCreatures = creaturesCompleteObstacles(countCreatures, creaturesAfterObstacles);

        Display(nameCreatures);  System.out.println();
    }
}
