/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

/**
 *
 * @author skycr
 */
public class Player extends Entity {

        double playerShipMinX;
        double playerShipMaxX;
        double playerShipMinY;
        double playerShipMaxY;

        Input input;

        double speed;

        public Player(Pane layer, Image image, double x, double y, double r, double dx, double dy, double dr, double speed, Input input) {

            super(layer, image, x, y, r, dx, dy, dr);

            this.speed = speed;
            this.input = input;

            init();
        }
        
        public void setSpeed(double speed){
            this.speed = speed;
        }

        private void init() {

            // calculate movement bounds of the player ship
            // allow half of the ship to be outside of the screen 
            playerShipMinX = 0 - image.getWidth() / 2.0;
            playerShipMaxX = Settings.W - image.getWidth() / 2.0;
            playerShipMinY = 0 - image.getHeight() / 2.0;
            playerShipMaxY = Settings.H - image.getHeight() / 2.0;

        }

        public void processInput() {

            // ------------------------------------
            // movement
            // ------------------------------------
            // vertical direction
            if (input.isMoveUp()) {
                dy = -speed;
            } else if (input.isMoveDown()) {
                dy = speed;
            } else {
                dy = 0d;
            }

            // horizontal direction
            if (input.isMoveLeft()) {
                dx = -speed;
            } else if (input.isMoveRight()) {
                dx = speed;
            } else {
                dx = 0d;
            }

        }

        @Override
        public void move() {

            super.move();

            // ensure the ship can't move outside of the screen
            checkBounds();

        }

        private void checkBounds() {

            // vertical
            if (Double.compare(y, playerShipMinY) < 0) {
                y = playerShipMinY;
            } else if (Double.compare(y, playerShipMaxY) > 0) {
                y = playerShipMaxY;
            }

            // horizontal
            if (Double.compare(x, playerShipMinX) < 0) {
                x = playerShipMinX;
            } else if (Double.compare(x, playerShipMaxX) > 0) {
                x = playerShipMaxX;
            }

        }

    }
