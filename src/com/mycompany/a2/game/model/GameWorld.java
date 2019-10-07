package com.mycompany.a2.game.model;

import com.codename1.charts.models.Point;
import com.mycompany.a2.collection.IIterator;
import com.mycompany.a2.util.Util;

/**
 * The game world model. This one class is in charge of basically everything. Because YAY OOP!
 * 
 * Maintains the entire state of the game world, and manages all user events.
 */
public class GameWorld
{
	private static final int ANT_SPEED_INCREMENT = 1;
	private static final int ANT_HEADING_INCREMENT = 5;
	private static final int ANT_STARTING_LIVES = 3;
	
	private boolean exitRequested = false;
	private Clock clock = new Clock();
	private int antLives = ANT_STARTING_LIVES;
	private GameObjectCollection gameObjects;
	private Ant ant;
	
	/**
	 * Constructs a game world, and starts the game.
	 */
	public GameWorld()
	{
		init();
	}
	
	/**
	 * Starts or restarts the game.
	 * 
	 * All game objects are deleted (if they exist) and recreated. This does not include the clock,
	 * which is not considered a game object, and is not reset betwen games.
	 */
	public void init()
	{
		ant = Ant.getInstance();
		gameObjects = new GameObjectCollection();
		gameObjects.add(ant);
		gameObjects.add(new Flag(1, Util.CENTER_SCREEN));
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
	
	/**
	 * Event: User requests that the ant go faster.
	 * 
	 * Increases the ant's speed, so long as the ant's speed is less than the ant's speed limit.
	 */
	public void antAccelerate()
	{
		ant.setSpeed(ant.getSpeed() + ANT_SPEED_INCREMENT);
	}
	
	/**
	 * Event: User requests that the ant slow down.
	 * 
	 * Reduces the ant's speed, so long as the ant's speed is greater than zero.
	 */
	public void antBrake()
	{
		ant.setSpeed(ant.getSpeed() - ANT_SPEED_INCREMENT);
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
		init();
	}
	
	/**
	 * Event: Ant hits a flag.
	 * 
	 * If the flag index is exactly one greater than the last flag reached, increments last flag
	 * reached.
	 * 
	 * @param flagIndex The index of the flag the ant hit
	 */
	public void antHitFlag(int flagIndex)
	{
		if (flagIndex == ant.getLastFlagReached() + 1)
		{
			ant.hitNextFlag();
			
			if (ant.getLastFlagReached() == 5)
			{
				System.out.println("Game over, you win! Total time: " + clock.getTime());
				System.exit(0);
			}
		}
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
	}
	
	/**
	 * Event: User requests that the ant turn left.
	 * 
	 * Turns the ant to the left.
	 */
	public void antTurnLeft()
	{
		ant.setHeading(ant.getHeading() - ANT_HEADING_INCREMENT);
	}
	
	/**
	 * Event: User requests that the ant turn right.
	 * 
	 * Turns the ant to the right.
	 */
	public void antTurnRight()
	{
		ant.setHeading(ant.getHeading() + ANT_HEADING_INCREMENT);
	}
	
	/**
	 * Event: User denies that they want to close the game.
	 * 
	 * If the game is in an "exit requested" state, changes to "exit not requested" state; if not,
	 * prints an "invalid command" message.
	 */
	public void cancelExit()
	{
		if (exitRequested)
		{
			exitRequested = false;
			System.out.println("Exit cancelled.");
		}
		else
		{
			System.out.println("Invalid command 'n'");
		}
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
	}
	
	/**
	 * Event: User confirms that they want to close the game.
	 * 
	 * If the game is in an "exit requested" state, quits the game; if not, prints an
	 * "invalid command" message.
	 */
	public void confirmExit()
	{
		if (exitRequested)
		{
			System.out.println("Exit confirmed. Quitting...");
			System.exit(0);
		}
		System.out.println("Invalid command 'y'");
	}
	
	/**
	 * Event: User requests to see game information about the current game state.
	 * 
	 * Shows the number of lives left, elapsed time, the last flag reached, the ant's food level,
	 * and the ant's health.
	 */
	public void display()
	{
		System.out.println("Lives left: " + antLives +
						   ", Elapsed time: " + clock.getTime() +
						   ", Last flag reached: " + ant.getLastFlagReached() +
						   ", Food level: " + ant.getFood() +
						   ", Health: " + ant.getHealth());
	}
	
	/**
	 * Event: User requests to close the game.
	 * 
	 * Does not cause a game exit, but puts the game in an "exit requested" state.
	 */
	public void requestExit()
	{
		exitRequested = true;
		System.out.println("Are you sure you want to quit? [y | n]");
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
}
