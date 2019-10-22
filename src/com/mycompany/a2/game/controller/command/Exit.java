package com.mycompany.a2.game.controller.command;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Exit extends Command
{
    private static Exit instance;

    private Exit()
    {
        super("Exit");
    }

    public static Exit getInstance()
    {
        return instance == null ? instance = new Exit() : instance;
    }

    @Override
    public void actionPerformed(ActionEvent evt)
    {
        System.exit(0);
    }
}
