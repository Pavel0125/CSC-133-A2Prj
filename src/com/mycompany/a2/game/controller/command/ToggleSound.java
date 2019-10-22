package com.mycompany.a2.game.controller.command;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.game.model.GameWorld;

public class ToggleSound extends Command
{
    private GameWorld world;

    public ToggleSound(GameWorld world)
    {
        super("Toggle Sound");
        this.world = world;
    }

    @Override
    public void actionPerformed(ActionEvent evt)
    {
        world.toggleSound();
    }
}
