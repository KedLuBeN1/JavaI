package vsb_cs_java.pong;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Bat extends GameEntity
{
	private Point2D position;
	private  Point2D velocity;
	private int direction = 1;
	private Game game;
	private int width = 10;
	private int height = 100;
	boolean batIn = false;
	
	public Bat(Game game ,Point2D posititon, Point2D velocity)
	{
		super(game);
		this.game = game;
		this.position = posititon;
		this.velocity = velocity;
	}
	
	@Override
	public void drawInternal(GraphicsContext gc) 
	{
		gc.setFill(Color.WHITE);
		gc.fillRect(position.getX(), position.getY(), width, height);
	}
	
	@Override
	public void simulate(double deltaT) 
	{
		if(position.getY() >= 0  && (position.getY() + height) <= game.getHeight()) 
		{
			batIn = true;
		}	
		
		if((position.getY() < 0  || (position.getY() + height) > game.getHeight()) && batIn) 
		{
			direction *= -1;
			batIn = false;
		}

		position = position.add(velocity.multiply(deltaT*direction));
	}
	
	public Rectangle2D getBoundingBox() 
	{
		return new Rectangle2D(position.getX(), position.getY(), width, height);
	}

}