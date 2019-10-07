package com.mycompany.a2.game.model;

import com.codename1.charts.util.ColorUtil;
import com.mycompany.a2.util.Util;

/**
 * This class wraps a Codename One color identifier.
 */
public final class Color
{
	private int color;
	
	private Color(int color)
	{
		this.color = color;
	}
	
	public static final Color BLACK = new Color(ColorUtil.BLACK);
	public static final Color BLUE = new Color(ColorUtil.BLUE);
	public static final Color CYAN = new Color(ColorUtil.CYAN);
	public static final Color GRAY = new Color(ColorUtil.GRAY);
	public static final Color GREEN = new Color(ColorUtil.GREEN);
	public static final Color LTGRAY = new Color(ColorUtil.LTGRAY);
	public static final Color MAGENTA = new Color(ColorUtil.MAGENTA);
	public static final Color WHITE = new Color(ColorUtil.WHITE);
	public static final Color YELLOW = new Color(ColorUtil.YELLOW);
	
	/**
	 * Constructs a color from red green and blue components
	 * 
	 * @param r The red component
	 * @param g The green component
	 * @param b The blue component
	 * @return A color constructed from the rgb components
	 */
	public static Color rgb(int r, int g, int b)
	{
		return new Color(ColorUtil.rgb(r, g, b));
	}
	
	/**
	 * @return The red color component
	 */
	public int red()
	{
		return ColorUtil.red(color);
	}
	
	/**
	 * @return The green color component
	 */
	public int green()
	{
		return ColorUtil.green(color);
	}
	
	/**
	 * @return The blue color component
	 */
	public int blue()
	{
		return ColorUtil.blue(color);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString()
	{
		return "#" + Util.hexByteFormat(red())
				   + Util.hexByteFormat(green())
				   + Util.hexByteFormat(blue());
	}
}
