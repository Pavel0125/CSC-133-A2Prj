package com.mycompany.a2.game.view;

import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.FlowLayout;
import com.mycompany.a2.game.model.Ant;
import com.mycompany.a2.game.model.Clock;
import com.mycompany.a2.game.model.GameWorldUpdateNotification;

import java.util.Observable;
import java.util.Observer;

public class ScoreView extends Container implements Observer
{
    private Label timeLabel = new Label("Time: 0");
    private Label livesLabel = new Label("Lives left: 0");
    private Label foodLabel = new Label("Food left: 0");
    private Label healthLabel = new Label("Health level: 0");
    private Label soundLabel = new Label("Sound: OFF");

    public ScoreView()
    {
        setLayout(new FlowLayout(Component.CENTER));
        addComponent(timeLabel);
        addComponent(livesLabel);
        addComponent(foodLabel);
        addComponent(healthLabel);
        addComponent(soundLabel);
    }

    @Override
    public void update(Observable o, Object arg)
    {
        if (!(arg instanceof GameWorldUpdateNotification)) throw new IllegalArgumentException();
        GameWorldUpdateNotification notification = (GameWorldUpdateNotification) arg;
        Clock clock = notification.getClock();
        int antLives = notification.getAntLives();
        Ant ant = notification.getAnt();
        boolean sound = notification.getSound();
        timeLabel.setText("Time: " + clock.getTime());
        livesLabel.setText("Lives left: " + antLives);
        foodLabel.setText("Food level: " + ant.getFood());
        healthLabel.setText("Health level: " + ant.getHealth());
        soundLabel.setText("Sound: " + (sound ? "ON" : "OFF"));
        repaint();
    }
}
