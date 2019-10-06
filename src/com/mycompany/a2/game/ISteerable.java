package com.mycompany.a2.game;

public interface ISteerable
{
	/**
	 * Heading is the direction the object will move in when `move()` is called.
	 * Heading is expected to be in degrees, where a heading of 0 moves straight up (or North), and
	 * 90 moves to the right (or East).
	 * 
	 * @param heading The heading of the object in degrees
	 */
	public void setHeading(int heading);
	
	/**
	 * Speed is the number of units the object will move every time `move()` is called.
	 * `move()` is intended to be called every tick, so speed should not be a huge number.
	 * 
	 * @param speed The speed of the object in distance units per tick
	 */
	public void setSpeed(int speed);
}
