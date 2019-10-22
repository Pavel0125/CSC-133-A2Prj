package com.mycompany.a2.game.controller.command;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class ShowExitDialog extends Command
{
    public ShowExitDialog()
    {
        super("Show Exit Dialog");
    }

    @Override
    public void actionPerformed(ActionEvent evt)
    {
        Dialog.show("Exit", "Are you sure you want to exit?", new Cancel(), new Exit());
    }
}
