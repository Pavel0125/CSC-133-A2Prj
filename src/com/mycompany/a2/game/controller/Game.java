package com.mycompany.a2.game.controller;

import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.mycompany.a2.game.model.GameWorld;

/**
 * The game controller.
 * 
 * Manages the game world state, and interprets user input.
 */
public final class Game extends Form
{
	private GameWorld world = new GameWorld();
	
	/**
	 * Create a game controller.
	 * 
	 * Starts the game immediately, and registers listeners for keyboard input.
	 */
	public Game()
	{	
		play();
	}
	
	/**
	 * Register listeners for keyboard input.
	 */
	private void play()
	{
		final TextField textField = new TextField();
		
		addComponent(new Label("Enter a command: "));
		addComponent(textField);
		
		textField.addActionListener((event) ->
		{
			if (textField.getText().isEmpty()) return;
			
			char[] commands = textField.getText().toCharArray();
			textField.clear();
			
			for (char command : commands)
			{
				switch (command)
				{
				case 'x':
					world.requestExit();
					continue;
				case 'y':
					world.confirmExit();
					continue;
				case 'n':
					world.cancelExit();
					continue;
				case 'a':
					world.antAccelerate();
					continue;
				case 'b':
					world.antBrake();
					continue;
				case 'l':
					world.antTurnLeft();
					continue;
				case 'r':
					world.antTurnRight();
					continue;
				case 'f':
					world.antHitFoodStation();
					continue;
				case 'g':
					world.antHitSpider();
					continue;
				case 't':
					world.clockTick();
					continue;
				case 'd':
					world.display();
					continue;
				case 'm':
					world.showMap();
					continue;
				}
				if (command >= '0' && command <= '9')
				{
					// Character.getNumericValue() is unavailable,
					// so we subtract 48 to convert ascii to integer
					world.antHitFlag(command - 48);
					continue;
				}
				
				// If we fall through to here, the user entered something else.
				System.out.println("Invalid command '" + command + "'");
			}
		});
		
		show();
	}
}
