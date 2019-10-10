package com.mycompany.a2.game.model;

public class GameWorldUpdateNotification
{
    private Ant ant;
    private int antLives;
    private Clock clock;
    private boolean sound;

    public GameWorldUpdateNotification(Ant ant, int antLives, Clock clock, boolean sound)
    {
        this.ant = ant;
        this.antLives = antLives;
        this.clock = clock;
        this.sound = sound;
    }

    public Ant getAnt()
    {
        return ant;
    }

     public int getAntLives()
     {
         return antLives;
     }

     public Clock getClock()
     {
         return clock;
     }

     public boolean getSound()
     {
         return sound;
     }
}
