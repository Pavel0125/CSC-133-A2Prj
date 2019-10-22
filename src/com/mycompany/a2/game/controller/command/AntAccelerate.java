package com.mycompany.a2.game.controller.command;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.game.model.GameWorld;

public class AntAccelerate extends Command
{
    private GameWorld world;
    private static AntAccelerate instance;

    private AntAccelerate(GameWorld world)
    {
        super("Accelerate");
        this.world = world;
    }

    public static AntAccelerate getInstance(GameWorld world)
    {
        return instance == null ? instance = new AntAccelerate(world) : instance;
    }

    @Override
    public void actionPerformed(ActionEvent evt)
    {
        world.antAccelerate();
    }
}
