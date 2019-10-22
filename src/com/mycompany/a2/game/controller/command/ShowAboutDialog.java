package com.mycompany.a2.game.controller.command;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class ShowAboutDialog extends Command
{
    public ShowAboutDialog()
    {
        super("Show About Dialog");
    }

    @Override
    public void actionPerformed(ActionEvent evt)
    {
        Dialog.show("About", "Author: Micheael Dorst\nCreated for CSC 133 at Sacramento State.", "Oll Korrect", null);
    }
}
