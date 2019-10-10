package com.mycompany.a2.game.controller.command;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.game.model.GameWorld;

public class ClockTick extends Command
{
    GameWorld world;

    public ClockTick(GameWorld world)
    {
        super("ClockTick");
        this.world = world;
    }

    @Override
    public void actionPerformed(ActionEvent evt)
    {
        world.clockTick();
    }
}
