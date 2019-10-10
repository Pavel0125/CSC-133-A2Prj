package com.mycompany.a2.game.view;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.plaf.Border;
import com.mycompany.a2.game.model.GameWorld;

import java.util.Observable;
import java.util.Observer;

public class MapView extends Container implements Observer
{
    public MapView()
    {
        getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.rgb(146, 0, 0)));
    }

    @Override
    public void update(Observable o, Object arg)
    {
        if (!(o instanceof GameWorld)) throw new IllegalArgumentException();
        ((GameWorld) o).showMap();
    }
}
