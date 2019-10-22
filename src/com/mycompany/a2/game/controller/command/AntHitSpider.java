package com.mycompany.a2.game.controller.command;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.game.model.GameWorld;

public class AntHitSpider extends Command
{
    private GameWorld world;
    private static AntHitSpider instance;

    private AntHitSpider(GameWorld world)
    {
        super("Hit Spider");
        this.world = world;
    }

    public static AntHitSpider getInstance(GameWorld world)
    {
        return instance == null ? instance = new AntHitSpider(world) : instance;
    }

    @Override
    public void actionPerformed(ActionEvent evt)
    {
        world.antHitSpider();
    }
}
