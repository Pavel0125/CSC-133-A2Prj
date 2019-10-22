package com.mycompany.a2.game.controller.command;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.game.model.GameWorld;

public class ClockTick extends Command
{
    private GameWorld world;
    private static ClockTick instance;

    private ClockTick(GameWorld world)
    {
        super("Clock Tick");
        this.world = world;
    }

    public static ClockTick getInstance(GameWorld world)
    {
        return instance == null ? instance = new ClockTick(world) : instance;
    }

    @Override
    public void actionPerformed(ActionEvent evt)
    {
        world.clockTick();
    }
}
