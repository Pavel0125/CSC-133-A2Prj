package com.mycompany.a2.game.view;

import com.mycompany.a2.collection.IIterator;

import java.util.Observable;
import java.util.Observer;

public class MapView implements Observer
{
    @Override
    public void update(Observable o, Object arg)
    {
        if (!(arg instanceof Object[])) throw new IllegalArgumentException();
        Object[] objs = (Object[]) arg;
        if (objs.length != 2 || objs[0] != "MapView") return;
        if (!(objs[1] instanceof IIterator)) throw new IllegalArgumentException();
        IIterator it = (IIterator) objs[1];
        while (it.hasNext())
        {
            System.out.println(it.getNext());
        }
    }
}
