package com.mycompany.a2.game.controller.command;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class GameExit extends Command
{
    private static GameExit instance;

    private GameExit()
    {
        super("Exit");
    }

    public static GameExit getInstance()
    {
        return instance == null ? instance = new GameExit() : instance;
    }

    @Override
    public void actionPerformed(ActionEvent evt)
    {
        System.exit(0);
    }
}
