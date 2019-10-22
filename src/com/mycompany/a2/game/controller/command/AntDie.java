package com.mycompany.a2.game.controller.command;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.game.model.GameWorld;

public class AntDie extends Command
{
    private GameWorld world;
    private static AntDie instance;

    private AntDie(GameWorld world)
    {
        super("Die");
        this.world = world;
    }

    public static AntDie getInstance(GameWorld world)
    {
        return instance == null ? instance = new AntDie(world) : instance;
    }

    @Override
    public void actionPerformed(ActionEvent evt)
    {
        world.antDies();
    }
}
