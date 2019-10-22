package com.mycompany.a2.game.controller;

import com.codename1.ui.*;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.mycompany.a2.game.controller.command.*;
import com.mycompany.a2.game.model.GameWorld;
import com.mycompany.a2.game.view.MapView;
import com.mycompany.a2.game.view.ScoreView;
import com.mycompany.a2.game.view.ui.Button;
import com.mycompany.a2.game.view.ui.MenuButton;
import com.mycompany.a2.util.Util;

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
		setLayout(new BorderLayout());
		{
			Container leftMargin = new Container();
			leftMargin.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
			{
				Button accelerateButton = new Button("Accelerate");
				accelerateButton.getAllStyles().setMarginTop(100);
				accelerateButton.addActionListener(AntAccelerate.getInstance(world));
				leftMargin.addComponent(accelerateButton);
			}
			{
				Button leftButton = new Button("Left");
				leftButton.addActionListener(AntTurnLeft.getInstance(world));
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
				brakeButton.addActionListener(AntBrake.getInstance(world));
				rightMargin.addComponent(brakeButton);
			}
			{
				Button rightButton = new Button("Right");
				rightButton.addActionListener(AntTurnRight.getInstance(world));
				rightMargin.addComponent(rightButton);
			}
			addComponent(BorderLayout.EAST, rightMargin);
		}
		{
			Container bottomMargin = new Container();
			bottomMargin.setLayout(new FlowLayout(Component.CENTER));
			{
				Button collideFlagButton = new Button("Collide with Flag");
				collideFlagButton.addActionListener(AntHitFlag.getInstance(world));
				bottomMargin.addComponent(collideFlagButton);
			}
			{
				Button collideSpiderButton = new Button("Collide with Spider");
				collideSpiderButton.addActionListener(AntHitSpider.getInstance(world));
				bottomMargin.addComponent(collideSpiderButton);
			}
			{
				Button collideFoodButton = new Button("Collide with Food");
				collideFoodButton.addActionListener(AntHitFoodStation.getInstance(world));
				bottomMargin.addComponent(collideFoodButton);
			}
			{
				Button tickButton = new Button("Tick");
				tickButton.addActionListener(ClockTick.getInstance(world));
				bottomMargin.addComponent(tickButton);
			}
			addComponent(BorderLayout.SOUTH, bottomMargin);
		}
		{
			ScoreView scoreView = new ScoreView();
			addComponent(BorderLayout.NORTH, scoreView);
			world.addObserver(scoreView);
		}
		MapView mapView = new MapView();
		addComponent(BorderLayout.CENTER, mapView);
		world.addObserver(mapView);
		{
			Toolbar toolbar = new Toolbar();
			setToolbar(toolbar);
			{
				MenuButton accelerateButton = new MenuButton("Accelerate");
				accelerateButton.addActionListener(AntAccelerate.getInstance(world));
				toolbar.addComponentToSideMenu(accelerateButton);
			}
			{
				MenuButton exitButton = new MenuButton("Exit");
				exitButton.addActionListener(ShowExitDialog.getInstance());
				toolbar.addComponentToSideMenu(exitButton);
			}
			{
				MenuButton toggleSoundButton = new MenuButton("Toggle Sound");
				toggleSoundButton.addActionListener(ToggleSound.getInstance(world));
				toolbar.addComponentToSideMenu(toggleSoundButton);
			}
			{
				MenuButton aboutButton = new MenuButton("About");
				aboutButton.addActionListener(ShowAboutDialog.getInstance());
				toolbar.addComponentToSideMenu(aboutButton);
			}
			toolbar.addCommandToRightBar(ShowHelpDialog.getInstance());
			setTitle("BugZ Game");
		}
		addKeyListener('a', AntAccelerate.getInstance(world));
		addKeyListener('b', AntBrake.getInstance(world));
		addKeyListener('l', AntTurnLeft.getInstance(world));
		addKeyListener('r', AntTurnRight.getInstance(world));
		addKeyListener('f', AntHitFlag.getInstance(world));
		addKeyListener('g', AntHitSpider.getInstance(world));
		addKeyListener('t', ClockTick.getInstance(world));
		show();
		Util.viewWidth = mapView.getWidth();
		Util.viewHeight = mapView.getHeight();
		world.loadLevel();
		world.notifyObservers();
	}
}
