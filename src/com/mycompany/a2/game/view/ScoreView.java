package com.mycompany.a2.game.view;

import com.mycompany.a2.game.model.Ant;
import com.mycompany.a2.game.model.Clock;

import java.util.Observable;
import java.util.Observer;

public class ScoreView implements Observer
{
    @Override
    public void update(Observable o, Object arg)
    {
        if (!(arg instanceof Object[])) throw new IllegalArgumentException();
        Object[] objs = (Object[]) arg;
        if (objs.length != 4 || objs[0] != "ScoreView") return;
        if (!(objs[1] instanceof Ant)) throw new IllegalArgumentException();
        if (!(objs[2] instanceof Integer)) throw new IllegalArgumentException();
        if (!(objs[3] instanceof Clock)) throw new IllegalArgumentException();

        Ant ant = (Ant) objs[1];
        Integer antLives = (Integer) objs[2];
        Clock clock = (Clock) objs[3];

        System.out.println("Lives left: " + antLives +
                ", Elapsed time: " + clock.getTime() +
                ", Last flag reached: " + ant.getLastFlagReached() +
                ", Food level: " + ant.getFood() +
                ", Health: " + ant.getHealth());
    }
}
