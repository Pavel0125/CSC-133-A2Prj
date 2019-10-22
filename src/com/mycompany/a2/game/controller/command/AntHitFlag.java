package com.mycompany.a2.game.controller.command;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.game.model.GameWorld;

public class AntHitFlag extends Command
{
    private GameWorld world;
    private static AntHitFlag instance;

    private AntHitFlag(GameWorld world)
    {
        super("Hit Flag");
        this.world = world;
    }

    public static AntHitFlag getInstance(GameWorld world)
    {
        return instance == null ? instance = new AntHitFlag(world) : instance;
    }

    @Override
    public void actionPerformed(ActionEvent evt)
    {
        world.antHitFlag();
    }
}
