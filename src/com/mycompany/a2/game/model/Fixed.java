package com.mycompany.a2.game.model;

import com.codename1.charts.models.Point;

public abstract class Fixed extends GameObject
{
	/**
	 * {@inheritDoc}
	 * 
	 * Calling `setPosition()` on Fixed will do nothing.
	 */
	@Override
	public final void setLocation(Point location) {}
}
