package vsb_cs_java.pong;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ball extends GameEntity
{
	public  Point2D position;
	private  Point2D velocity;
	private Game game;
	public int size = 20;
	public int xDirection = 1;
	public int yDirection = 1;
    
	public Ball(Game game, Point2D position, Point2D velocity)
	{
		super(game);
		this.position = position;
		this.velocity = velocity;
    }
	
	@Override
	public void drawInternal(GraphicsContext gc) 
	{
		gc.setFill(Color.WHITE);
		gc.fillOval(position.getX(), position.getY(), size, size);
	}
	
	@Override
	public void simulate(double deltaT)
	{		
		position = position.add(velocity.getX() * deltaT * xDirection, velocity.getY() * deltaT * yDirection);
	}
	
	protected Point2D getPosition() 
	{
		return position;
	}
	
	public Rectangle2D getBoundingBox() 
	{
		return new Rectangle2D(position.getX(), position.getY(), size, size);
	}
}
