package com.mycompany.a2.game.view.ui;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;

public class MenuButton extends Button
{
    public MenuButton(String text)
    {
        super(text);
        Style allStyles = getAllStyles();
        allStyles.setBgTransparency(255);
        allStyles.setBgColor(ColorUtil.WHITE);
        allStyles.setFgColor(ColorUtil.rgb(74, 74, 75));
        allStyles.setBorder(Border.createLineBorder(1, ColorUtil.rgb(146, 146, 150)));
    }
}
