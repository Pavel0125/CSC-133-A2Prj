package com.mycompany.a2.game.controller.command;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.game.model.GameWorld;

public class AntBrake extends Command
{
    private GameWorld world;
    private static AntBrake instance;

    private AntBrake(GameWorld world)
    {
        super("Brake");
        this.world = world;
    }

    public static AntBrake getInstance(GameWorld world)
    {
        return instance == null ? instance = new AntBrake(world) : instance;
    }

    @Override
    public void actionPerformed(ActionEvent evt)
    {
        world.antBrake();
    }
}
