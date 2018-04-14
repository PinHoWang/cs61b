
package editor;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;



public class DrawCursorInTheMiddleOfTheScreen extends Application {
	
	private final Rectangle textBoundingBox;


	public DrawCursorInTheMiddleOfTheScreen() {
		/* Rectangle(double x, double y, double width, double height) */
		textBoundingBox = new Rectangle(250, 250, 1, 12);
	}



	private class RectangleBlinkEventHandler implements EventHandler<ActionEvent> {

		private int currCursorIndex = 0;
		private Color[] cursorColor = {Color.BLACK, Color.WHITE};

		public RectangleBlinkEventHandler() {
			changeColor();
		}

		private void changeColor() {
			textBoundingBox.setFill(cursorColor[currCursorIndex]);
            currCursorIndex = (currCursorIndex + 1) % cursorColor.length;
		}

		@Override
		public void handle(ActionEvent event) {
			changeColor();
		}
	}


	public void showCursor() {
		final Timeline timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);
		RectangleBlinkEventHandler cursorChange = new RectangleBlinkEventHandler();
		KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), cursorChange);
		timeline.getKeyFrames().add(keyFrame);
        timeline.play();
	}

	@Override
	public void start(Stage primaryStage) {

		Group root = new Group();

		Scene scene = new Scene(root, 500, 500, Color.WHITE);

		// EventHandler<KeyEvent> keyEventHandler = new EventHandler();
  		// scene.setOnKeyTyped(keyEventHandler);
  		// scene.setOnKeyPressed(keyEventHandler);

		root.getChildren().add(textBoundingBox);
		showCursor();

		primaryStage.setTitle("Editor");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}