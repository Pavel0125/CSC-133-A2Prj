package com.mycompany.a2.game.model;

import com.codename1.charts.models.Point;
import com.mycompany.a2.game.model.Color;
import com.mycompany.a2.util.Util;

/**
 * The parent class for all game objects.
 * 
 * All game objects have the attributes color, location and size.
 */
public abstract class GameObject
{
	protected static final int MAX_SIZE = 50;
	protected static final int MIN_SIZE = 10;
	protected static final float MIN_X = Util.MIN_X;
	protected static final float MIN_Y = Util.MIN_Y;
	protected static final float MAX_X = Util.MAX_X;
	protected static final float MAX_Y = Util.MAX_Y;

	/**
	 * The color of the object
	 */
	protected Color color;
	
	/**
	 * The position of the object in the game world
	 */
	protected Point location;
	
	/**
	 * The size of the object
	 */
	protected int size;
	
	/**
	 * Set the size of the object to a random value between MIN_SIZE and MAX_SIZE
	 */
	protected void setRandomSize()
	{
		size = Util.randomIntInRange(MIN_SIZE, MAX_SIZE);
	}
	
	/**
	 * @return The color of the object
	 */
	public Color getColor()
	{
		return color;
	}
	
	/**
	 * @return The position of the object in the game world
	 */
	public Point getLocation()
	{
		return location;
	}

	/**
	 * @return The size of the object
	 */
	public int getSize()
	{
		return size;
	}
	
	/**
	 * Set the color of the object.
	 * 
	 * @param color The color to set
	 */
	public void setColor(Color color)
	{
		this.color = color;
	}
	
	/**
	 * Set the position of the object in the game world.
	 * 
	 * @param location The position to set
	 */
	public void setLocation(Point location)
	{
		this.location = location;
		
		if (location.getX() < MIN_X)
		{
			location.setX(MIN_X);
		}
		if (location.getY() < MIN_Y)
		{
			location.setY(MIN_Y);
		}
		if (location.getX() > MAX_X)
		{
			location.setX(MAX_X);
		}
		if (location.getY() > MAX_Y)
		{
			location.setY(MAX_Y);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString()
	{
		return "size = " + size
				+ ", color = " + color
				+ ", location = " + Util.pointToString(location);
	}
}
