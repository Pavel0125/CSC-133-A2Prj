package com.mycompany.a2.game.controller.command;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.game.model.GameWorld;

public class AntTurnLeft extends Command
{
    private GameWorld world;
    private static AntTurnLeft instance;

    private AntTurnLeft(GameWorld world)
    {
        super("Turn Left");
        this.world = world;
    }

    public static AntTurnLeft getInstance(GameWorld world)
    {
        return instance == null ? instance = new AntTurnLeft(world) : instance;
    }

    @Override
    public void actionPerformed(ActionEvent evt)
    {
        world.antTurnLeft();
    }
}
