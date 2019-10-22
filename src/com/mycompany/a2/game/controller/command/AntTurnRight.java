package com.mycompany.a2.game.controller.command;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.game.model.GameWorld;

public class AntTurnRight extends Command
{
    private GameWorld world;
    private static AntTurnRight instance;

    private AntTurnRight(GameWorld world)
    {
        super("Turn Right");
        this.world = world;
    }

    public static AntTurnRight getInstance(GameWorld world)
    {
        return instance == null ? instance = new AntTurnRight(world) : instance;
    }

    @Override
    public void actionPerformed(ActionEvent evt)
    {
        world.antTurnRight();
    }
}
