package com.mycompany.a2.game.controller.command;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Exit extends Command
{
    public Exit()
    {
        super("Exit");
    }

    @Override
    public void actionPerformed(ActionEvent evt)
    {
        System.exit(0);
    }
}