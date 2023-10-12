package vsb_cs_java.pong;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Score extends GameEntity{

    public Score(Game game) {
        super(game);
    }

    @Override
    public void simulate(double deltaT) {

    }

    @Override
    protected void drawInternal(GraphicsContext gc)
    {
        gc.setFill(Color.WHITE);
        gc.setFont(Font.font("Arial", 50)); // Font and font size

        gc.fillText("4", 325, 100);
        gc.fillText("0", 450, 100);

        gc.save();
        gc.scale(1, -1);
        gc.translate(0, -getGame().getHeight());
    }
}
