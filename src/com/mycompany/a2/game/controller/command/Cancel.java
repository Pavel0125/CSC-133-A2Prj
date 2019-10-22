package com.mycompany.a2.game.controller.command;

import com.codename1.ui.Command;

public class Cancel extends Command
{
    private static Cancel instance;

    private Cancel()
    {
        super("Cancel");
    }

    public static Cancel getInstance()
    {
        return instance == null ? instance = new Cancel() : instance;
    }
}
