package com.mycompany.a2.game.model;

import com.codename1.charts.models.Point;
import com.mycompany.a2.util.Util;

/**
 * Represents a flag object in game.
 * 
 * Flags cannot move, and they have a sequence number.
 */
public final class Flag extends Fixed
{
	private static final int SIZE = 10;
	private static final Color DEFAULT_COLOR = Color.BLUE;
	
	private int sequenceNumber;
	
	/**
	 * Creates a new flag with the given sequence number and location.
	 * 
	 * @param sequenceNumber The flag's sequence number
	 * @param location The permanent location of the flag
	 */
	public Flag(int sequenceNumber, Point location)
	{
		this.location = Util.clampToScreen(location);
		this.color = DEFAULT_COLOR;
		this.sequenceNumber = sequenceNumber;
		this.size = SIZE;
	}
	
	/**
	 * @return The flag's sequence number
	 */
	public int getSequenceNumber()
	{
		return sequenceNumber;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * Calling `setColor()` on a Flag will do nothing.
	 */
	@Override
	public final void setColor(Color color) {}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString()
	{
		return "Flag: " + super.toString()
		+ ", sequenceNumber = " + sequenceNumber;
	}
}
