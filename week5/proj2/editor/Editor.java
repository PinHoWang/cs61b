package editor;

import javafx.application.Application;
import javafx.stage.Stage;

import javafx.scene.shape.Rectangle;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
/* KeyEventHandler */
import javafx.scene.text.Text;
import javafx.geometry.VPos;
import javafx.scene.text.Font;
import javafx.scene.input.KeyCode;
/* RectangleBlinkEventHandler */
import javafx.event.ActionEvent;
/* makeRectangleColorChange */
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.LinkedList;




public class Editor extends Application {

	private final Rectangle textBoundingBox;

    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 500;

    public Editor() {
    	textBoundingBox = new Rectangle(0, 0);
    }


    /** An EventHandler to handle keys that get pressed. */
    private class KeyEventHandler implements EventHandler<KeyEvent> {
        int textCenterX;
        int textCenterY;

        private static final int STARTING_TEXT_POSITION_X = 250;
        private static final int STARTING_TEXT_POSITION_Y = 250;
        private static final int STARTING_FONT_SIZE = 20;

        /** The Text to display on the screen. */
        private Text displayText = new Text(STARTING_TEXT_POSITION_X, STARTING_TEXT_POSITION_Y, "");
        private int fontSize = STARTING_FONT_SIZE;

        private String fontName = "Verdana";

        /* Store keyEvent in the LinkedList */
        LinkedList<String> eventList;

        KeyEventHandler(final Group root, int windowWidth, int windowHeight) {
            textCenterX = STARTING_FONT_SIZE / 2;
            textCenterY = STARTING_FONT_SIZE / 2;

            // Initialize some empty text and add it to root so that it will be displayed.
            displayText = new Text(textCenterX, textCenterY, "");
            // Always set the text origin to be VPos.TOP! Setting the origin to be VPos.TOP means
            // that when the text is assigned a y-position, that position corresponds to the
            // highest position across all letters (for example, the top of a letter like "I", as
            // opposed to the top of a letter like "e"), which makes calculating positions much
            // simpler!
            displayText.setTextOrigin(VPos.TOP);
            displayText.setFont(Font.font(fontName, fontSize));
            root.getChildren().add(displayText);

            /* Construct keyEvnet List */
            eventList = new LinkedList<String>();
        }

        @Override
        public void handle(KeyEvent keyEvent) {
            if (keyEvent.getEventType() == KeyEvent.KEY_TYPED) {
                // Use the KEY_TYPED event rather than KEY_PRESSED for letter keys, because with
                // the KEY_TYPED event, javafx handles the "Shift" key and associated
                // capitalization.
                //System.out.println("KeyTyped");
                String characterTyped = keyEvent.getCharacter();
                if (characterTyped.length() > 0 && characterTyped.charAt(0) != 8) {
                	//System.out.println("Ignore ctrl, delete");
                    // Ignore control keys, which have zero length, as well as the backspace
                    // key, which is represented as a character of value = 8 on Windows.
                    eventList.add(characterTyped);
                    String currentText = "";
                    for(int i = 0; i < eventList.size(); i++) {
                    	currentText += eventList.get(i);
                    }
                    displayText.setText(currentText);
                    //System.out.println(displayText.getText());  
                    keyEvent.consume();
                } else if(characterTyped.charAt(0) == 8 && eventList.size() != 0) { // Type "backspace" (Strange in macOS???)
                	//System.out.println("Key backspace");
                	eventList.removeLast();
                	String currentText = "";
                    for(int i = 0; i < eventList.size(); i++) {
                    	currentText += eventList.get(i);
                    }
                    displayText.setText(currentText);
                    //System.out.println(displayText.getText());  
                    keyEvent.consume();
                } else if(characterTyped.charAt(0) == 13) { // Type "Enter" to next line
                	eventList.add("\n");
                }
                centerTextAndUpdateBoundingBox();

            } else if (keyEvent.getEventType() == KeyEvent.KEY_PRESSED) {
            	//System.out.println("KeyPressed");
                // Arrow keys should be processed using the KEY_PRESSED event, because KEY_PRESSED
                // events have a code that we can check (KEY_TYPED events don't have an associated
                // KeyCode).
                KeyCode code = keyEvent.getCode();
                if (code == KeyCode.UP) {
                    fontSize += 5;
                    displayText.setFont(Font.font(fontName, fontSize));
                    centerTextAndUpdateBoundingBox();
                } else if (code == KeyCode.DOWN) {
                    fontSize = Math.max(0, fontSize - 5);
                    displayText.setFont(Font.font(fontName, fontSize));
                    centerTextAndUpdateBoundingBox();
                }
            }
        }

        private void centerTextAndUpdateBoundingBox() {
            // Figure out the size of the current text.
            double textHeight = displayText.getLayoutBounds().getHeight();
            double textWidth = displayText.getLayoutBounds().getWidth();

            // Calculate the position so that the text will be Left-Top of the screen.
            // double textTop = textCenterY;
            // double textLeft = textCenterX;

            // Re-position the text.
            displayText.setX(textCenterX);
            displayText.setY(textCenterY);

            // Re-size and re-position the bounding box.
            textBoundingBox.setHeight(STARTING_FONT_SIZE);
            textBoundingBox.setWidth(STARTING_FONT_SIZE / 2);

            // For rectangles, the position is the upper left hand corner.
            textBoundingBox.setX(textWidth);
            textBoundingBox.setY(textCenterY);
            // Many of the JavaFX classes have implemented the toString() function, so that
            // they print nicely by default.
            System.out.println("Bounding box: " + textBoundingBox);

            // Make sure the text appears in front of the rectangle.
            displayText.toFront();
        }
    }

    /** An EventHandler to handle changing the color of the rectangle. */
    private class RectangleBlinkEventHandler implements EventHandler<ActionEvent> {
        private int currentColorIndex = 0;
        private Color[] boxColors =
                {Color.LIGHTPINK, Color.ORANGE, Color.YELLOW,
                        Color.GREEN, Color.LIGHTBLUE, Color.PURPLE};

        RectangleBlinkEventHandler() {
            // Set the color to be the first color in the list.
            changeColor();
        }

        private void changeColor() {
            textBoundingBox.setFill(boxColors[currentColorIndex]);
            currentColorIndex = (currentColorIndex + 1) % boxColors.length;
        }

        @Override
        public void handle(ActionEvent event) {
            changeColor();
        }
    }

    /** Makes the text bounding box change color periodically. */
    public void makeRectangleColorChange() {
        // Create a Timeline that will call the "handle" function of RectangleBlinkEventHandler
        // every 1 second.
        final Timeline timeline = new Timeline();
        // The rectangle should continue blinking forever.
        timeline.setCycleCount(Timeline.INDEFINITE);
        RectangleBlinkEventHandler cursorChange = new RectangleBlinkEventHandler();
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), cursorChange);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }

    @Override
    public void start(Stage primaryStage) {
    	// Create a Node that will be the parent of all things displayed on the screen.
        Group root = new Group();
        // The Scene represents the window: its height and width will be the height and width
        // of the window displayed.
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT, Color.WHITE);

        // To get information about what keys the user is pressing, create an EventHandler.
        // EventHandler subclasses must override the "handle" function, which will be called
        // by javafx.
        EventHandler<KeyEvent> keyEventHandler =
                new KeyEventHandler(root, WINDOW_WIDTH, WINDOW_HEIGHT);

        // Register the event handler to be called for all KEY_PRESSED and KEY_TYPED events.
        scene.setOnKeyTyped(keyEventHandler);
        scene.setOnKeyPressed(keyEventHandler);

        // All new Nodes need to be added to the root in order to be displayed.
        //root.getChildren().add(textBoundingBox);
        makeRectangleColorChange();

        //System.out.println("YOOOOOOOOOOOÔPPPPP!");
        primaryStage.setTitle("Editor");

        // This is boilerplate, necessary to setup the window where things are displayed.
        primaryStage.setScene(scene);
        primaryStage.show();
        //System.out.println("YOOOOOOOOOOOÔPPPPP");
    }

    public static void main(String[] args) {
        launch(args);
    }
}