package com.mycompany.a2.game.controller.command;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class ShowExitDialog extends Command
{
    private static ShowExitDialog instance;

    private ShowExitDialog()
    {
        super("Show Exit Dialog");
    }

    public static ShowExitDialog getInstance()
    {
        return instance == null ? instance = new ShowExitDialog() : instance;
    }

    @Override
    public void actionPerformed(ActionEvent evt)
    {
        Dialog.show("Exit", "Are you sure you want to exit?", Cancel.getInstance(), Exit.getInstance());
    }
}
