package com.mycompany.a2.game.controller;

import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.mycompany.a2.game.controller.command.*;
import com.mycompany.a2.game.model.GameWorld;
import com.mycompany.a2.game.view.MapView;
import com.mycompany.a2.game.view.ScoreView;
import com.mycompany.a2.game.view.ui.Button;

/**
 * The game controller.
 * 
 * Manages the game world state, and interprets user input.
 */
public final class Game extends Form
{
	/**
	 * Create a game controller.
	 * 
	 * Starts the game immediately, and registers listeners for keyboard input.
	 */
	public Game()
	{
		GameWorld world = new GameWorld();
		setTitle("BugZ Game");
		setLayout(new BorderLayout());
		{
			Container leftMargin = new Container();
			leftMargin.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
			{
				Button accelerateButton = new Button("Accelerate");
				accelerateButton.getAllStyles().setMarginTop(100);
				accelerateButton.addActionListener(new AntAccelerate(world));
				leftMargin.addComponent(accelerateButton);
			}
			{
				Button leftButton = new Button("Left");
				leftButton.addActionListener(new AntTurnLeft(world));
				leftMargin.addComponent(leftButton);
			}
			addComponent(BorderLayout.WEST, leftMargin);
		}
		{
			Container rightMargin = new Container();
			rightMargin.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
			{
				Button brakeButton = new Button("Brake");
				brakeButton.getAllStyles().setMarginTop(100);
				brakeButton.addActionListener(new AntBrake(world));
				rightMargin.addComponent(brakeButton);
			}
			{
				Button rightButton = new Button("Right");
				rightButton.addActionListener(new AntTurnRight(world));
				rightMargin.addComponent(rightButton);
			}
			addComponent(BorderLayout.EAST, rightMargin);
		}
		{
			Container bottomMargin = new Container();
			bottomMargin.setLayout(new FlowLayout(Component.CENTER));
			{
				Button collideFlagButton = new Button("Collide with Flag");
				collideFlagButton.addActionListener(new AntHitFlag(world));
				bottomMargin.addComponent(collideFlagButton);
			}
			{
				Button collideSpiderButton = new Button("Collide with Spider");
				collideSpiderButton.addActionListener(new AntHitSpider(world));
				bottomMargin.addComponent(collideSpiderButton);
			}
			{
				Button collideFoodButton = new Button("Collide with Food");
				collideFoodButton.addActionListener(new AntHitFoodStation(world));
				bottomMargin.addComponent(collideFoodButton);
			}
			{
				Button tickButton = new Button("Tick");
				tickButton.addActionListener(new ClockTick(world));
				bottomMargin.addComponent(tickButton);
			}
			addComponent(BorderLayout.SOUTH, bottomMargin);
		}
		{
			ScoreView scoreView = new ScoreView();
			addComponent(BorderLayout.NORTH, scoreView);
			world.addObserver(scoreView);
		}
		{
			MapView mapView = new MapView();
			addComponent(BorderLayout.CENTER, mapView);
			world.addObserver(mapView);
		}
		addKeyListener('a', new AntAccelerate(world));
		addKeyListener('b', new AntBrake(world));
		addKeyListener('l', new AntTurnLeft(world));
		addKeyListener('r', new AntTurnRight(world));
		addKeyListener('f', new AntHitFlag(world));
		addKeyListener('g', new AntHitSpider(world));
		addKeyListener('t', new ClockTick(world));
		world.notifyObservers();
		show();
	}
}
