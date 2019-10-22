package com.mycompany.a2.game.controller.command;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class ShowHelpDialog extends Command
{
    public ShowHelpDialog()
    {
        super("Help");
    }

    @Override
    public void actionPerformed(ActionEvent evt)
    {
        String text =
                "A: Accelerate\n" +
                "B: Brake\n" +
                "L: Turn Left\n" +
                "R: Turn Right\n" +
                "F: Collide with Food Station\n" +
                "G: Collide with Spider\n" +
                "T: Clock Tick";
        Dialog.show("Help", text, "Oll Korrect", null);
    }
}
