package com.mycompany.a2.game.model;

import com.mycompany.a2.game.model.Color;
import com.mycompany.a2.game.model.Fixed;
import com.mycompany.a2.util.Util;

/**
 * Represents a food station object in game.
 * 
 * Food stations cannot move. They provide a static amount of food to the player upon collision.
 */
public final class FoodStation extends Fixed
{
	private static final Color DEFAULT_COLOR = Color.GREEN;
	private static final int MIN_CAPACITY = 10;
	private static final int MAX_CAPACITY = 50;
	
	private int capacity;
	
	/**
	 * Constructs a new food station at a random location, with a random food capacity.
	 */
	public FoodStation()
	{
		location = Util.randomLocation();
		size = capacity = Util.randomIntInRange(MIN_CAPACITY, MAX_CAPACITY);
		this.color = DEFAULT_COLOR;
	}
	
	/**
	 * @return The amount of food stored in the food station.
	 */
	public int getCapacity()
	{
		return capacity;
	}
	
	/**
	 * Sets the amount of food the food station stores.
	 * 
	 * @param capacity The amount of food to be stored. If negative, capacity will be set to 0.
	 */
	public void setCapacity(int capacity)
	{
		this.capacity = Math.max(capacity, 0);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString()
	{
		return "Food Station: " + super.toString() + ", capacity = " + capacity;
	}
}
