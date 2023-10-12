package vsb_cs_java.pong;


import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.text.Font;


import java.util.Random;

public class Game 
{
	private final double width;
	private final double height;
	private final Ball ball;
	private final Bat BatLeft;
	private final Bat BatRight;
	private final CenterNet CenterNet;
	boolean ballIn = false;
	
	private DrawableSimulable[] entities;
	
	public Game(double width, double height) 
	{
		this.width = width;
		this.height = height;
		
		this.ball = new Ball(this, new Point2D(400, 300), new Point2D(200, 200));
		this.BatLeft = new Bat(this, new Point2D(50, 100), new Point2D(0, -50));
		this.BatRight = new Bat(this, new Point2D(740, 400), new Point2D(0, 50));
		this.CenterNet = new CenterNet(this);
	}
	
	public void draw(GraphicsContext gc) 
	{
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, width, height);
	    
		
        
        gc.setFill(Color.WHITE);
        gc.setFont(Font.font("Arial", 50)); // Font and font size


        gc.fillText("4", 325, 100); 
        gc.fillText("0", 450, 100); 

        
		gc.save();
		gc.scale(1, -1);
		gc.translate(0, -height);
		
		this.ball.draw(gc);
		this.BatLeft.draw(gc);
		this.BatRight.draw(gc);
		this.CenterNet.draw(gc);
		gc.restore();
	}
	
	public void simulate(double deltaT) 
	{
		this.ball.simulate(deltaT);
		this.BatLeft.simulate(deltaT);
		this.BatRight.simulate(deltaT);
		Random rand = new Random();
						
		if(ball.position.getY() >= 0  && (ball.position.getY() + ball.size) <= getHeight() && ball.position.getX() >= 0  && (ball.position.getX() + ball.size) <= getWidth()) 
		{
			ballIn = true;
		}	
		
		if((ball.position.getY() < 0  || (ball.position.getY() + ball.size) > getHeight()) && ballIn) 
		{
			ball.yDirection *= -1;
			if(rand.nextBoolean()) 
			{
				ball.xDirection *= -1;		
			}			
			ballIn = false;
		}
		
		if((ball.position.getX() < 0  || (ball.position.getX() + ball.size) > getWidth()) && ballIn) 
		{
			ball.xDirection *= -1;
			if(rand.nextBoolean()) 
			{
				ball.yDirection *= -1;		
			}	
			ballIn = false;
		}
		
		if (ball.getBoundingBox().intersects(BatLeft.getBoundingBox()) ||  ball.getBoundingBox().intersects(BatRight.getBoundingBox()) ) 
		{
			ball.xDirection *= -1;
			ball.yDirection *= -1;	
		}
			
	}
	
	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

}
