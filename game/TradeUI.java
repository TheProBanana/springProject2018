package game;


import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Skylor Criqui
 */
public class TradeUI extends Application {

    private Label lbYourBalance = new Label("Your Balance:");
    private TextField tfYourBalance = new TextField("12.00");
    private Label lbPrice = new Label("Price:");
    private Label lbPrice1 = new Label("3.00");
    private Label lbTheirBalance = new Label("Their Balance:");
    private TextField tfTheirBalance = new TextField("12.00");
    private Button btBuy = new Button("Buy");
    private Button btSell = new Button("Sell");

    @Override
    public void start(Stage primaryStage) throws Exception {
        // UI
        GridPane pane = new GridPane();
        pane.setHgap(5);
        pane.setVgap(5);
        pane.add(lbYourBalance, 0, 0);
        pane.add(tfYourBalance, 1, 0);
        pane.add(new Label("Item: "), 0, 1);
        pane.add(new Label("Iron"), 1, 1);
        pane.add(lbPrice, 0, 2);
        pane.add(lbPrice1, 1, 2);
        pane.add(lbTheirBalance, 0, 3);
        pane.add(tfTheirBalance, 1, 3);
        pane.add(btBuy, 0, 4);
        pane.add(btSell, 1, 4);

        pane.setAlignment(Pos.CENTER);
        pane.setHalignment(btBuy, HPos.CENTER);
        pane.setHalignment(btSell, HPos.CENTER);
        tfYourBalance.setEditable(false);

        btBuy.setOnAction(e -> buy());
        btSell.setOnAction(e -> sell());

        primaryStage.setTitle("TradeUI");
        primaryStage.setScene(new Scene(pane, 640, 480));
        primaryStage.show();
    }

    private void buy() {
        try {
            tfYourBalance.requestFocus();
            double yourBalance = Double.parseDouble(tfYourBalance.getText());
            lbPrice1.requestFocus();
            double price = Double.parseDouble(lbPrice1.getText());
            tfTheirBalance.requestFocus();
            double theirBalance = Double.parseDouble(tfTheirBalance.getText());
            yourBalance = yourBalance - price;
            theirBalance = theirBalance + price;
            if (yourBalance >= 0) {
                tfYourBalance.setText(Double.toString(yourBalance));
                tfTheirBalance.setText(Double.toString(theirBalance));
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("TradeUI");
                alert.setHeaderText("Error Alert");
                String s = "You do not have enough money to buy this item.";
                alert.setContentText(s);
                alert.show();
            }
        } catch (IllegalArgumentException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("TradeUI");
            alert.setHeaderText("Error Alert");
            String s = "Your input is invalid. Correct and resubmit.";
            alert.setContentText(s);
            alert.show();
        }
    }
    
    private void sell(){
        try{
            tfYourBalance.requestFocus();
            double yourBalance = Double.parseDouble(tfYourBalance.getText());
            lbPrice1.requestFocus();
            double price = Double.parseDouble(lbPrice1.getText());
            tfTheirBalance.requestFocus();
            double theirBalance = Double.parseDouble(tfTheirBalance.getText());
            yourBalance = yourBalance + price;
            theirBalance = theirBalance - price;
            if (theirBalance >= 0) {
                tfYourBalance.setText(Double.toString(yourBalance));
                tfTheirBalance.setText(Double.toString(theirBalance));
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("TradeUI");
                alert.setHeaderText("Error Alert");
                String s = "The trader does not have enough money to buy this item.";
                alert.setContentText(s);
                alert.show();
            }
        }catch(IllegalArgumentException ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("TradeUI");
            alert.setHeaderText("Error Alert");
            String s = "Your input is invalid. Correct and resubmit.";
            alert.setContentText(s);
            alert.show();
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
