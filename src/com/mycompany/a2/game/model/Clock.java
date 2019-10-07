package com.mycompany.a2.game.model;

/**
 * Represents in game time, i.e. the number of "clicks" that have occured.
 * 
 * This is not related to actual time - in fact, there is no concept of minutes or seconds, only the
 * number of "clicked" that have occurred so far in game.
 */
public final class Clock
{
	private int time = 0;
	
	/**
	 * @return The number of clicks that have occurred so far in game
	 */
	public int getTime()
	{
		return time;
	}
	
	/**
	 * Tick forward the game clock, incrementing the time value.
	 */
	public void tick()
	{
		time += 1;
	}
}
