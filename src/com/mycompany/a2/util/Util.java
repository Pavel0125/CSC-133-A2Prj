package com.mycompany.a2.util;

import java.util.Random;

import com.codename1.charts.models.Point;

/**
 * Provides useful, general purpose static methods, because this is Java and we're not allowed to
 * have nice things (i.e. free functions).
 * 
 * Also provides some static constants, wich are essentially global constants.
 */
public final class Util
{
	public static float viewWidth;
	public static float viewHeight;

	public static Point viewCenter()
	{
		return new Point(viewWidth / 2, viewHeight / 2);
	}

	/**
	 * Ensure that a number falls within a specific range. If not, bring it in range.
	 * 
	 * If `num < min`, returns `min`. If `num > max`, returns `max`.
	 * 
	 * @param num The number to clamp to the specified range
	 * @param min The maximum value of the range
	 * @param max The minimim value of the range
	 * @return Either `num`, `min` or `max`, depending on their values, as specified above.
	 */
	public static float clampToRange(float num, float min, float max)
	{
		num = Math.max(num, min);
		return Math.min(num, max);
	}
	
	/**
	 * Ensure that a Point falls within on-screen coordinates. If not, bring it onto the screen.
	 * 
	 * @param point The point to clamp to on-screen coordinates
	 * @return `point`, or a modified version of `point` that lies on screen
	 */
	public static Point clampToScreen(Point point)
	{
		float x = Util.clampToRange(point.getX(), 0, viewWidth);
		float y = Util.clampToRange(point.getY(), 0, viewHeight);
		return new Point(x, y);
	}
	
	/**
	 * Convert an integer into a two digit hex value, i.e. 10 ⟶ 0A, 255 ⟶ FF
	 * 
	 * Warning! This will break and print totally the wrong number for any value over 255!
	 * 
	 * @param num A number in the range `[0, 255]`
	 * @return The hex representation of `num` as a two digit string
	 * @throws IllegalArgumentException if `num` is not in the range `[0, 255]`
	 */
	public static String hexByteFormat(int num)
	{
		if (num < 0 || num > 255)
		{
			throw new IllegalArgumentException();
		}
		
		// This works by adding 256 to the value, thereby guaranteeing that the value is at least 3
		// digits, and then returning only the last two.
		// We have to do this because there is no `String.format()` in CN1, and we need to always
		// output two characters.
		return Integer.toHexString(0x100 | num).substring(1).toUpperCase();
	}
	
	/**
	 * Check if a point is on-screen.
	 * 
	 * @param point The point to check
	 * @return true if `point` is on-screen; otherwise false
	 */
	public static boolean isOnScreen(Point point)
	{
		return point.getX() >= 0 && point.getX() <= viewWidth &&
			   point.getY() >= 0 && point.getY() <= viewHeight;
	}
	
	/**
	 * Convert a Point to a string representation.
	 * 
	 * @param point The Point to be converted
	 * @return The string representation of `point`
	 */
	public static String pointToString(Point point)
	{
		return "(" + point.getX() + ", " + point.getY() + ")";
	}
	
	/**
	 * Generates a random real number within a given range.
	 * 
	 * @param lowerBound The lowest value that may be generated.
	 * @param upperBound The highest value that may be generated.
	 * @return A random real number within the range [lowerBound, upperBound]
	 */
	public static float randomFloatInRange(float lowerBound, float upperBound)
	{
		return (float) new Random().nextDouble() * (upperBound - lowerBound) + lowerBound;
	}
	
	/**
	 * Generates a random integer within a given range.
	 * 
	 * @param lowerBound The lowest value that may be generated
	 * @param upperBound The highest value that may be generated
	 * @return A random whole number within the range [lowerBound, upperBound]
	 */
	public static int randomIntInRange(int lowerBound, int upperBound)
	{
		return new Random().nextInt(upperBound - lowerBound) + lowerBound;
	}
	
	/**
	 * Generates a Point at a random location on the screen.
	 * 
	 * The x value of the point will be within the range [MIN_X, MAX_X].
	 * The y value of the point will be within the range [MIN_Y, MAX_Y].
	 * 
	 * @return A Point at a random location on the screen.
	 */
	public static Point randomLocation()
	{
		return new Point(randomFloatInRange(0, viewWidth), randomFloatInRange(0, viewHeight));
	}
}
