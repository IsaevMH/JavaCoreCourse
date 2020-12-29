package com.coursejavacore;

import com.coursejavacore.homework2.interfaces.IAction;
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

    public static Object[] obstraclesInitialization(int count)
    {
        Random random = new Random();
        Object[] obstacles = new Object[count];
        for (int i = 0; i < obstacles.length; i++)
            if (i % 2 == 0)
                obstacles[i] = new Wall(random.nextInt(25));
            else
                obstacles[i] = new RunningTrack(random.nextInt(25));
        return obstacles;
    }

    public static IAction[] creaturesPassObstacles(IAction[] creatures, Object[] obstacles)
    {
        for (int i = 0; i < obstacles.length; i++)
            for (int j = 0; j < creatures.length; j++) {
                if (creatures[j] != null) {
                    if (obstacles[i] instanceof Wall) {
                        var obstacleWeight = (Wall) obstacles[i];
                        if (creatures[j].Jump(obstacleWeight.getWeight()) == false)
                            creatures[j] = null;
                    } else {
                        var distanceObstacle = (RunningTrack) obstacles[i];
                        if (creatures[j].Run(distanceObstacle.getLength()) == false)
                            creatures[j] = null;
                    }
                }
            }
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
        for(int i = 0; i < creatures.length; i++)
            if(creatures[i] != null)
            {
                var j = 0;
                names[j] = creatures[i];
                j++;
            }
        return names;
    }

    public static void Display(IAction[] creatures)
    {
        for(int i = 0; i < creatures.length; i++)
            if(creatures.length > 0)
                System.out.format("%s прошел(а) все испытания", ((Creature) creatures[i]).getName());
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
        Display(nameCreatures);
    }
}
