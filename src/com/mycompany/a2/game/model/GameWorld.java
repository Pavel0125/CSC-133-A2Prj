package com.mycompany.a2.game.model;

import com.codename1.charts.models.Point;
import com.mycompany.a2.collection.IIterator;
import com.mycompany.a2.util.Util;

import java.util.Observable;

/**
 * The game world model. This one class is in charge of basically everything. Because YAY OOP!
 * 
 * Maintains the entire state of the game world, and manages all user events.
 */
public class GameWorld extends Observable
{
	private static final int ANT_SPEED_INCREMENT = 1;
	private static final int ANT_HEADING_INCREMENT = 5;
	private static final int ANT_STARTING_LIVES = 3;

	private Clock clock = new Clock();
	private int antLives = ANT_STARTING_LIVES;
	private GameObjectCollection gameObjects;
	private Ant ant;
	private boolean sound;
	
	/**
	 * Starts or restarts the game.
	 * 
	 * All game objects are deleted (if they exist) and recreated. This does not include the clock,
	 * which is not considered a game object, and is not reset betwen games.
	 */
	public void loadLevel()
	{
		ant = Ant.getInstance();
		gameObjects = new GameObjectCollection();
		gameObjects.add(ant);
		gameObjects.add(new Flag(1, Util.viewCenter()));
		gameObjects.add(new Flag(2, new Point(350, 25)));
		gameObjects.add(new Flag(3, new Point(850, 120)));
		gameObjects.add(new Flag(4, new Point(700, 600)));
		gameObjects.add(new Flag(5, new Point(250, 350)));
		gameObjects.add(new Spider());
		gameObjects.add(new Spider());
		gameObjects.add(new FoodStation());
		gameObjects.add(new FoodStation());
		gameObjects.add(new FoodStation());
		gameObjects.add(new FoodStation());
		gameObjects.add(new FoodStation());
	}

	@Override
	public void notifyObservers()
	{
		setChanged();
		super.notifyObservers(new GameWorldUpdateNotification(ant, antLives, clock, sound));
	}

	/**
	 * Event: User requests that the ant go faster.
	 * 
	 * Increases the ant's speed, so long as the ant's speed is less than the ant's speed limit.
	 */
	public void antAccelerate()
	{
		ant.setSpeed(ant.getSpeed() + ANT_SPEED_INCREMENT);
		notifyObservers();
	}
	
	/**
	 * Event: User requests that the ant slow down.
	 * 
	 * Reduces the ant's speed, so long as the ant's speed is greater than zero.
	 */
	public void antBrake()
	{
		ant.setSpeed(ant.getSpeed() - ANT_SPEED_INCREMENT);
		notifyObservers();
	}
	
	/**
	 * Event: Ant dies.
	 * 
	 * Happens when either the ant runs out of food, or runs out of health.
	 * The player loses a life, and if the player runs out of lives (if the player dies with zero
	 * lives remaining), the game ends.
	 */
	public void antDies()
	{
		antLives--;
		
		if (antLives < 0)
		{
			System.out.println("Game over, you failed!");
			System.exit(0);
		}
		// Restart the level
		loadLevel();
		notifyObservers();
	}
	
	/**
	 * Event: Ant hits a flag.
	 * 
	 * Ends the game if the last flag is reached.
	 */
	public void antHitFlag()
	{
		ant.hitNextFlag();

		if (ant.getLastFlagReached() == 5)
		{
			System.out.println("Game over, you win! Total time: " + clock.getTime());
			System.exit(0);
		}
		notifyObservers();
	}
	
	/**
	 * Event: Ant runs into a food station.
	 * 
	 * The ant will consume the food station, which will be despawned, and a new food station will
	 * be spawned at a random location in its place.
	 */
	public void antHitFoodStation()
	{
		IIterator<GameObject> it = gameObjects.getIterator();

		while (it.hasNext())
		{
			GameObject obj = it.getNext();

			if (obj instanceof FoodStation && ((FoodStation) obj).getCapacity() > 0)
			{
				ant.setFood(ant.getFood() + ((FoodStation) obj).getCapacity());
				((FoodStation) obj).setCapacity(0);
				gameObjects.add(new FoodStation());
				notifyObservers();
				return;
			}
		}
	}
	
	/**
	 * Event: Ant runs into a spider.
	 * 
	 * The ant's health is reduced. If the ant's health is reduced to 0, the `antDies()` event
	 * occurs.
	 */
	public void antHitSpider()
	{
		ant.hitSpider();
		
		if (ant.getHealth() == 0)
		{
			System.out.println("The ant was beaten to death by the spider.");
			antDies();
		}
		notifyObservers();
	}
	
	/**
	 * Event: User requests that the ant turn left.
	 * 
	 * Turns the ant to the left.
	 */
	public void antTurnLeft()
	{
		ant.setHeading(ant.getHeading() - ANT_HEADING_INCREMENT);
		notifyObservers();
	}
	
	/**
	 * Event: User requests that the ant turn right.
	 * 
	 * Turns the ant to the right.
	 */
	public void antTurnRight()
	{
		ant.setHeading(ant.getHeading() + ANT_HEADING_INCREMENT);
		notifyObservers();
	}
	
	/**
	 * Event: The game moves forward in time by one time quantum.
	 * 
	 * Causes all moveable objects in the game world to move.
	 */
	public void clockTick()
	{
		clock.tick();
		
		ant.consumeFood();
		
		if (ant.getFood() == 0)
		{
			System.out.println("The ant starved to death.");
			
			antDies();
		}

		IIterator<GameObject> it = gameObjects.getIterator();

		while (it.hasNext())
		{
			GameObject obj = it.getNext();

			if (obj instanceof Movable)
			{
				((Movable) obj).move();
			}
		}
		notifyObservers();
	}
	
	/**
	 * Event: User requests to see the map.
	 * 
	 * Prints information about all game objects in the game world to the console.
	 */
	public void showMap()
	{
		IIterator<GameObject> it = gameObjects.getIterator();

		while (it.hasNext())
		{
			GameObject obj = it.getNext();

			System.out.println(obj);
		}
	}

	/**
	 * Event: User requests to toggle sound ON or OFF.
	 *
	 * Toggles sound ON or OFF.
	 */
	public void toggleSound()
	{
		sound = !sound;
		notifyObservers();
	}
}
