package com.mycompany.a2.game;

import com.codename1.charts.models.Point;

/**
 * Represents a game object that is movable - that is, its position in the game world may change.
 */
public abstract class Movable extends GameObject
{
	protected int heading;
	protected int speed;
	
	/**
	 * Heading is the direction the object will move in when `move()` is called.
	 * Heading is expected to be in degrees, where a heading of 0 moves straight up (or North), and
	 * 90 moves to the right (or East).
	 * 
	 * @return The heading of the object in degrees
	 */
	public int getHeading()
	{
		return heading;
	}
	
	/**
	 * Speed is the number of units the object will move every time `move()` is called.
	 * `move()` is intended to be called every tick, so speed should not be a huge number.
	 * 
	 * @return The speed of the object in distance units per tick
	 */
	public int getSpeed()
	{
		return speed;
	}
	
	/**
	 * Update the location of the object
	 * 
	 * Performs a single "tick" worth of movement, so the amount of movement that should happen at
	 * each game-time quantum.
	 * Movement will be "clipped" to prevent the object from leaving the game area.
	 * The direction and speed are based on the `heading` and `speed` properties. If these are not
	 * modified, the object will continue in a straight line at a fixed speed.
	 */
	public void move()
	{
		double angle = Math.toRadians(90 - heading);
		
		float deltaX = (float) Math.cos(angle) * speed;
		float deltaY = (float) Math.sin(angle) * speed;
		
		setLocation(new Point(location.getX() + deltaX, location.getY() + deltaY));
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString()
	{
		return super.toString() + ", speed = " + speed + ", heading = " + heading;
	}
}
