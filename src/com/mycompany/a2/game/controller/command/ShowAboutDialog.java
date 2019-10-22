package com.mycompany.a2.game.controller.command;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class ShowAboutDialog extends Command
{
    private static ShowAboutDialog instance;

    private ShowAboutDialog()
    {
        super("Show About Dialog");
    }

    public static ShowAboutDialog getInstance()
    {
        return instance == null ? instance = new ShowAboutDialog() : instance;
    }

    @Override
    public void actionPerformed(ActionEvent evt)
    {
        Dialog.show("About", "Author: Micheael Dorst\nCreated for CSC 133 at Sacramento State.", "Oll Korrect", null);
    }
}
