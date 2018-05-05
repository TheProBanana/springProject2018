package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;

/**
 * **************************************************
 * This is the main class for Trading Amongst Stars.
 *
 * @author Skylor Criqui
 * @date 3/21/2018
 *
 ****************************************************
 */
public class Main extends Application {

    Stage stage = new Stage();
    TradeUI tradeui = new TradeUI();
    Random rnd = new Random();
    int k = 0, i = 0;
    Pane playfieldLayer;
    Pane scoreLayer;
    Image playerImage;
    Image planetImage;
    List<Player> players = new ArrayList<>();
    List<Planet> planets = new ArrayList<>();
    Text collisionText = new Text();
    boolean collision = false;
    Scene scene;

    @Override
        public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        playfieldLayer = new Pane();
        scoreLayer = new Pane();
        root.getChildren().add(playfieldLayer);
        root.getChildren().add(scoreLayer);
        scene = new Scene(root, Settings.W, Settings.H, Color.BLACK);
        primaryStage.setTitle("Trading Amongst Stars");
        primaryStage.setScene(scene);
        primaryStage.show();

        loadGame();

        createScoreLayer();
        createPlayer();
        AnimationTimer gameLoop = new AnimationTimer() {
        LongValue time = new LongValue( System.nanoTime() );
        longValue maxTime = new LongValue(time + 300,000,000,000);

            @Override
           
            public void handle(long now) {
                if(time < maxTime){
                // player input
                players.forEach(player -> player.processInput());

                // add random enemies
                spawnPlanets(true);

                // movement
                players.forEach(player -> player.move());
                planets.forEach(player -> player.move());

                // check collisions
                checkCollisions();

                // update sprites in scene
                players.forEach(player -> player.updateUI());
                planets.forEach(player -> player.updateUI());

                Button btTrade = new Button("Trade?");
                if (collision) {
                    root.getChildren().add(btTrade);
                    btTrade.requestFocus();
                    btTrade.setOnMousePressed(e -> {
                        try {
                            openTradeUI(stage);
                        } catch (Exception ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });
                }
            }
        };
        gameLoop.start();
        
    };
   }

    private void loadGame() {
        playerImage = new Image(getClass().getResource("player.bmp").toExternalForm());
        planetImage = new Image(getClass().getResource("Planet.bmp").toExternalForm());
    }

    private void createScoreLayer() {
        collisionText.setFont(Font.font(null, FontWeight.BOLD, 64));
        collisionText.setStroke(Color.BLACK);
        collisionText.setFill(Color.RED);

        scoreLayer.getChildren().add(collisionText);

        // TODO: quick-hack to ensure the text is centered; usually you don't have that; instead you have a health bar on top
        collisionText.setText("Collision");
        double x = (Settings.W - collisionText.getBoundsInLocal().getWidth()) / 2;
        double y = (Settings.H - collisionText.getBoundsInLocal().getHeight()) / 2;
        collisionText.relocate(x, y);
        collisionText.setText("");

        collisionText.setBoundsType(TextBoundsType.VISUAL);
    }

    private void createPlayer() {
        // player input
        Input input = new Input(scene);

        // register input listeners
        input.addListeners(); // TODO: remove listeners on game over

        Image image = playerImage;

        // center horizontally, position at 70% vertically
        double x = Settings.W - image.getWidth();
        double y = Settings.H - image.getHeight();

        // create player
        Player player = new Player(playfieldLayer, image, x, y, 0, 0, 0, 0, 2, input);

        // register player
        players.add(player);
    }

    private void spawnPlanets(boolean random) {
        if (k > 8) {
            return;
        }

        // image
        Image image = planetImage;

        // x position range: enemy is always fully inside the screen, no part of it is outside
        // y position: right on top of the view, so that it becomes visible with the next game iteration
        double x = rnd.nextDouble() * (Settings.W - image.getWidth());
        double y = i;

        // create a sprite
        if ((x > (Settings.W - image.getWidth()) || x < (Settings.W - image.getWidth()))
                && (y > (Settings.H - image.getHeight()) || y < (Settings.H - image.getHeight()))) {
            Planet planet = new Planet(playfieldLayer, image, x, y, 0, 0, 0, 0);
            planets.add(planet);
        }
        // manage sprite
        k++;
        i += 75;
    }

    private void checkCollisions() {

        collision = false;

        for (Player player : players) {
            for (Planet planet : planets) {
                if (player.collidesWith(planet)) {
                    collision = true;
                }
            }
        }
    }

    private void openTradeUI(Stage stage) throws Exception {
        tradeui.start(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
