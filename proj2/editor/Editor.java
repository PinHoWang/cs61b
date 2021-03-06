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
import java.util.HashMap;


public class Editor extends Application {

	private final Rectangle textBoundingBox;

    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 500;

    public Editor() {
    	textBoundingBox = new Rectangle(0, 0);
    }

    private class KeyEventHandler implements EventHandler<KeyEvent> {
       
        private static final int STARTING_FONT_SIZE = 20;
        private static final int STARTING_TEXT_POSITION_X = STARTING_FONT_SIZE / 2;
        private static final int STARTING_TEXT_POSITION_Y = STARTING_FONT_SIZE / 2;

        /** The Text to display on the screen. */
        private Text displayText;
        private int fontSize = STARTING_FONT_SIZE;

        private String fontName = "Verdana";

        /* Store each Text object into a linkedlist for each line */
        private LinkedList<Text> rowList;
        /* Record each line of the eventList */
        private HashMap<Integer, LinkedList<Text>> lineMap;
        /* Record the current line */
        private int currLine;

        KeyEventHandler(final Group root) {
            /* Initialize the Text displayText */
            displayText = new Text(STARTING_TEXT_POSITION_X, STARTING_TEXT_POSITION_Y, "");

            /* Initialize the current line to 1 */
            currLine = 1;

            /* Initialize the container of the texts */
            rowList = new LinkedList<Text>();
            lineMap = new HashMap<Integer, LinkedList<Text>>();
            lineMap.put(currLine, rowList);

            // Always set the text origin to be VPos.TOP! Setting the origin to be VPos.TOP means
            // that when the text is assigned a y-position, that position corresponds to the
            // highest position across all letters (for example, the top of a letter like "I", as
            // opposed to the top of a letter like "e"), which makes calculating positions much
            // simpler!
            displayText.setTextOrigin(VPos.TOP);
            displayText.setFont(Font.font(fontName, fontSize));
            root.getChildren().add(displayText);
        }


        @Override
        public void handle(KeyEvent keyEvent) {
           if (keyEvent.getEventType() == KeyEvent.KEY_TYPED) {
                // Use the KEY_TYPED event rather than KEY_PRESSED for letter keys, because with
                // the KEY_TYPED event, javafx handles the "Shift" key and associated
                // capitalization.
                String characterTyped = keyEvent.getCharacter();
                if (characterTyped.length() > 0 && characterTyped.charAt(0) != 8) {
                    // Ignore control keys, which have zero length, as well as the backspace
                    // key, which is represented as a character of value = 8 on Windows.
                    displayText.setText(characterTyped);
                    keyEvent.consume();
                }
                positionTextAndUpdateBoundingBox();
                // Add the text into container when KeyEvent happened
                lineMap.get(currLine).add(displayText);
            }
        }


        /* position the Text to the right place (corresponding to others Text) and 
        ** update the boundingbox */
        private void positionTextAndUpdateBoundingBox() {
            // Figure out the size of the current text.
            double textHeight = displayText.getLayoutBounds().getHeight();
            double textWidth = displayText.getLayoutBounds().getWidth();

            
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
        EventHandler<KeyEvent> keyEventHandler = new KeyEventHandler(root);

        // Register the event handler to be called for all KEY_PRESSED and KEY_TYPED events.
        scene.setOnKeyTyped(keyEventHandler);
        scene.setOnKeyPressed(keyEventHandler);

        // All new Nodes need to be added to the root in order to be displayed.
       	// root.getChildren().add(textBoundingBox);
        // makeRectangleColorChange();

        primaryStage.setTitle("Editor");

        // This is boilerplate, necessary to setup the window where things are displayed.
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}