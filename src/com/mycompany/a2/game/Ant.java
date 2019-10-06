package com.mycompany.a2.game;

import com.codename1.charts.models.Point;

public final class Ant extends Movable implements ISteerable
{
	private static final int COLLISION_PENALTY = 5;
	private static final int DEFAULT_SIZE = 15;
	private static final int STARTING_FOOD = 100;
	private static final int STARTING_HEADING = 0;
	private static final int STARTING_HEALTH = 10;
	private static final int STARTING_SPEED = 5;
	private static final Color DEFAULT_COLOR = Color.rgb(150, 0, 0);
	
	// For consistency, these should be named in all caps, but the spec says to name them as follows
	private static final int foodConsumptionRate = 2;
	private static final int maxSpeed = 10;
	
	private int foodLevel = STARTING_FOOD;
	private int healthLevel = STARTING_HEALTH;
	private int lastFlagReached;
	private int speedLimit;
	
	public Ant(Point location)
	{
		setLocation(location);
		computeSpeedLimit();
		size = DEFAULT_SIZE;
		color = DEFAULT_COLOR;
		heading = STARTING_HEADING;
		speed = STARTING_SPEED;
		lastFlagReached = 1;
	}
	
	/**
	 * Compute the ant's color based on its health
	 */
	private void computeColor()
	{
		color = Color.rgb(healthLevel * 20, 0, 0);
	}
	
	/**
	 * Reduce speed if necessary, depending on the speed limit
	 */
	private void computeSpeed()
	{
		// `setSpeed` already does the speed reduction we need, so this method is just a wrapper.
		setSpeed(speed);
	}
	
	/**
	 * Reduce the ant's speed limit if necessary, depending on its health.
	 */
	private void computeSpeedLimit()
	{
		float speedLimitModifier = ((float) 1 / STARTING_HEALTH) * healthLevel;
		
		speedLimit = Math.round(speedLimitModifier * maxSpeed);
		
		speedLimit = (speedLimit < maxSpeed) ? speedLimit : maxSpeed;
	}
	
	/**
	 * Reduce food according to the food consumption rate. Food will not reduce below 0.
	 */
	public void consumeFood()
	{
		foodLevel -= foodConsumptionRate;
		
		foodLevel = foodLevel < 0 ? 0 : foodLevel;
	}

	/**
	 * @return The ant's current food level
	 */
	public int getFood()
	{
		return foodLevel;
	}
	
	public int getHealth()
	{
		return healthLevel;
	}
	
	/**
	 * @return The last flag reached in consecutive order. (Does not include flags reached out of
	 * order, i.e. if the ant reaches flag 1, then flag 3, flag 3 will be ignored.)
	 */
	public int getLastFlagReached()
	{
		return lastFlagReached;
	}
	
	/**
	 * Event: Ant hit the next flag.
	 * 
	 * This event should only happen when the ant hits a flag with a sequence number exactly one
	 * higher than that of the previous.
	 */
	public void hitNextFlag()
	{
		lastFlagReached++;
	}
	
	/**
	 * Event: Ant hits spider.
	 * 
	 * Reduce health appropriately.
	 */
	public void hitSpider()
	{
		setHealth(healthLevel - COLLISION_PENALTY);
	}
	
	/**
	 * @param food The amount of food the ant has. If negative, will be set to zero.
	 */
	public void setFood(int food)
	{
		this.foodLevel = food < 0 ? 0 : food;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setHeading(int heading)
	{
		this.heading = heading;
	}
	
	/**
	 * Change the health of the ant. Updates the ant's speed limit and color appropriately.
	 * @param health The desired health. If negative, health will be set to 0.
	 */
	public void setHealth(int health)
	{
		this.healthLevel = health < 0 ? 0 : health;
		
		computeSpeedLimit();
		computeSpeed();
		computeColor();
	}
	
	/**
	 * Set the speed of the ant, clamped to a range. Minimum speed: 0. Maximum speed depends on the
	 * health of the ant.
	 * 
	 * @param speed Desired speed
	 */
	@Override
	public void setSpeed(int speed)
	{
		speed = (speed < 0) ? 0 : speed;
		
		this.speed = (speed < speedLimit) ? speed : speedLimit;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString()
	{
		return "Ant: "
				+ super.toString()
				+ ", speedLimit = " + speedLimit
				+ ", maxSpeed = " + maxSpeed
				+ ", health = " + healthLevel
				+ ", foodConsumptionRate = " + foodConsumptionRate;
	}
}
