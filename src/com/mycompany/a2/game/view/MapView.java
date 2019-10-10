package com.mycompany.a2.game.view;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.plaf.Border;
import com.mycompany.a2.game.model.GameWorld;

import java.awt.*;
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
        repaint();
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(ColorUtil.BLACK);
        Point p = new Point(100, 100);
        int size = 300;
        g.drawRect(getX() + p.x, getY() + p.y, size, size);
    }
}
