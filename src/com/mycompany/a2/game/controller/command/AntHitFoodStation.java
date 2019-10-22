package com.mycompany.a2.game.controller.command;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.game.model.GameWorld;

public class AntHitFoodStation extends Command
{
    private GameWorld world;
    private static AntHitFoodStation instance;

    private AntHitFoodStation(GameWorld world)
    {
        super("Hit Food Station");
        this.world = world;
    }

    public static AntHitFoodStation getInstance(GameWorld world)
    {
        return instance == null ? instance = new AntHitFoodStation(world) : instance;
    }

    @Override
    public void actionPerformed(ActionEvent evt)
    {
        world.antHitFoodStation();
    }
}
