package com.mycompany.a2.game.model;

import com.mycompany.a2.util.Util;

/**
 * Represents a Spider in the game world
 */
public final class Spider extends Movable
{
	/**
	 * Constructs a spider in a random location with a random heading and a random speed
	 */
	public Spider()
	{
		color = Color.BLACK;
		
		setLocation(Util.randomLocation());
		
		heading = Util.randomIntInRange(0, 359);
		
		speed = Util.randomIntInRange(5, 10);
		
		setRandomSize();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * The spider's `move()` method updates the heading by a random value between 5 degrees and -5
	 * degrees each time the method is called. This causes the spider to "meander", rather than
	 * moving on a straight, predetermined path.
	 */
	@Override
	public void move()
	{
		heading = heading + Util.randomIntInRange(-5, 5);
		
		super.move();
		
		// Do not allow the spider to walk out of bounds
		if (!Util.isOnScreen(location))
		{
			// Get back on screen
			location = Util.clampToScreen(location);
			
			// Reverse heading
			heading -= 180;
		}
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * Calling `setColor()` on Spider will do nothing.
	 */
	@Override
	public final void setColor(Color color) {}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString()
	{
		return "Spider: " + super.toString();
	}
}
