package com.mycompany.a2.game.view.ui;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;

public class Button extends com.codename1.ui.Button
{
    public Button(String text)
    {
        super(text);
        Style allStyles = getAllStyles();
        allStyles.setBgTransparency(255);
        allStyles.setBgColor(ColorUtil.rgb(196, 196, 200));
        allStyles.setFgColor(ColorUtil.rgb(74, 74, 75));
        allStyles.setPaddingTop(5);
        allStyles.setPaddingBottom(5);
        allStyles.setMargin(5, 5, 5, 5);
        allStyles.setBorder(Border.createLineBorder(3, ColorUtil.rgb(146, 146, 150)));
    }
}
