package com.mycompany.a2.game.controller.command;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.game.model.GameWorld;

public class AntBrake extends Command
{
    GameWorld world;

    public AntBrake(GameWorld world)
    {
        super("Brake");
        this.world = world;
    }

    @Override
    public void actionPerformed(ActionEvent evt)
    {
        world.antBrake();
    }
}
