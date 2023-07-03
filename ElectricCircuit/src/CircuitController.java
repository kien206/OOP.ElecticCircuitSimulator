import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class CircuitController {
    // Parallel [Resistor, Capacitor, Inductor]
    // Serial   [Resistor, Capacitor, Inductor]
    private int[][] count = new int[2][3]; 

    private ObservableList<Float> parallelResistorValues = FXCollections.observableArrayList();
    private ObservableList<Float> parallelCapacitorValues = FXCollections.observableArrayList();
    private ObservableList<Float> parallelInductorValues = FXCollections.observableArrayList();
    private ObservableList<Float> serialResistorValues = FXCollections.observableArrayList();
    private ObservableList<Float> serialCapacitorValues = FXCollections.observableArrayList();
    private ObservableList<Float> serialInductorValues = FXCollections.observableArrayList();

    @FXML
    private Button btnAddCapacitorParallel;

    @FXML
    private Button btnAddCapacitorSerial;

    @FXML
    private Button btnAddInductorParallel;

    @FXML
    private Button btnAddInductorSerial;

    @FXML
    private Button btnAddResistorParallel;

    @FXML
    private Button btnAddResistorSerial;

    @FXML
    private Button btnRemoveCapacitorParallel;

    @FXML
    private Button btnRemoveCapacitorSerial;

    @FXML
    private Button btnRemoveInductorParallel;

    @FXML
    private Button btnRemoveInductorSerial;

    @FXML
    private Button btnRemoveResistorParallel;

    @FXML
    private Button btnRemoveResistorSerial;

    @FXML
    private Tab tabParallel;

    @FXML
    private Tab tabSerial;

    @FXML
    private TextField tfCapacitor;

    @FXML
    private TextField tfInductor;

    @FXML
    private TextField tfResistor;

    @FXML
    private ColumnConstraints colParallelCapacitor;

    @FXML
    private ColumnConstraints colParallelInductor;

    @FXML
    private ColumnConstraints colParallelResistor;

    @FXML
    private ColumnConstraints colSerialCapacitor;

    @FXML
    private ColumnConstraints colSerialInductor;

    @FXML
    private ColumnConstraints colSerialResistor;

    @FXML
    private GridPane gridParallel;

    @FXML
    private GridPane gridSerial;

    @FXML
    void btnAddCapacitorParallelPressed(ActionEvent event) {
        count[0][1]++;
        HBox hbox = new HBox();
        Label label = new Label("C" + Integer.toString(count[0][1]));
        Label ohm = new Label("\u03A9");
        TextField tf = new TextField();
        modify(label, tf, ohm, hbox);
        tf.setOnAction(e -> parallelCapacitorTfChanged(tf));
        VBox vbox = (VBox) gridParallel.getChildren().get(1);
        // Find the index of the button in the VBox
        int buttonIndex = vbox.getChildren().indexOf(btnAddCapacitorParallel);

        // Insert the new HBox before the button
        vbox.getChildren().add(buttonIndex, hbox);
        parallelCapacitorValues.add(0.0f);
    }

    @FXML
    void btnAddCapacitorSerialPressed(ActionEvent event) {
        count[1][1]++;
        HBox hbox = new HBox();
        Label label = new Label("C" + Integer.toString(count[1][1]));
        Label ohm = new Label("\u03A9");
        TextField tf = new TextField();
        modify(label, tf, ohm, hbox);
        tf.setOnAction(e -> serialCapacitorTfChanged(tf));
        
        VBox vbox = (VBox) gridSerial.getChildren().get(1);
        // Find the index of the button in the VBox
        int buttonIndex = vbox.getChildren().indexOf(btnAddCapacitorSerial);

        // Insert the new HBox before the button
        vbox.getChildren().add(buttonIndex, hbox);
    }

    @FXML
    void btnAddInductorParallelPressed(ActionEvent event) {
        count[0][2]++;
        HBox hbox = new HBox();
        Label label = new Label("L" + Integer.toString(count[0][2]));
        Label ohm = new Label("\u03A9");
        TextField tf = new TextField();
        modify(label, tf, ohm, hbox);
        tf.setOnAction(e -> parallelInductorTfChanged(tf));
        
        VBox vbox = (VBox) gridParallel.getChildren().get(2);
        // Find the index of the button in the VBox
        int buttonIndex = vbox.getChildren().indexOf(btnAddInductorParallel);

        // Insert the new HBox before the button
        vbox.getChildren().add(buttonIndex, hbox);
        
    }

    @FXML
    void btnAddInductorSerialPressed(ActionEvent event) {
        count[1][2]++;
        HBox hbox = new HBox();
        Label label = new Label("C" + Integer.toString(count[1][2]));
        Label ohm = new Label("\u03A9");
        TextField tf = new TextField();
        modify(label, tf, ohm, hbox);
        tf.setOnAction(e->serialInductorTfChanged(tf));

        VBox vbox = (VBox) gridSerial.getChildren().get(2);
        // Find the index of the button in the VBox
        int buttonIndex = vbox.getChildren().indexOf(btnAddInductorSerial);

        // Insert the new HBox before the button
        vbox.getChildren().add(buttonIndex, hbox);
    }

    @FXML
    void btnAddResistorParallelPressed(ActionEvent event) {
        count[0][0]++;
        HBox hbox = new HBox();
        Label label = new Label("R" + Integer.toString(count[0][0]));
        Label ohm = new Label("\u03A9");
        TextField tf = new TextField();
        modify(label, tf, ohm, hbox);
        tf.setOnAction(e -> parallelResistorTfChanged(tf));
        
        VBox vbox = (VBox) gridParallel.getChildren().get(0);
        // Find the index of the button in the VBox
        int buttonIndex = vbox.getChildren().indexOf(btnAddResistorParallel);

        // Insert the new HBox before the button
        vbox.getChildren().add(buttonIndex, hbox);
    }

    @FXML
    void btnAddResistorSerialPressed(ActionEvent event) {
        count[1][0]++;
        HBox hbox = new HBox();
        Label label = new Label("R" + Integer.toString(count[1][0]));
        Label ohm = new Label("\u03A9");
        TextField tf = new TextField();
        modify(label, tf, ohm, hbox);
        tf.setOnAction(e -> serialResistorTfChanged(tf));
        VBox vbox = (VBox) gridSerial.getChildren().get(0);
        // Find the index of the button in the VBox
        int buttonIndex = vbox.getChildren().indexOf(btnAddResistorSerial);

        // Insert the new HBox before the button
        vbox.getChildren().add(buttonIndex, hbox);  
    }

    // Remove buttons
    @FXML
    void btnRemoveCapacitorParallelPressed(ActionEvent event) {
        VBox vbox = (VBox) gridParallel.getChildren().get(1);
        int buttonIndex = vbox.getChildren().indexOf(btnAddCapacitorParallel);
        if (vbox.getChildren().get(buttonIndex - 1) instanceof HBox && count[0][1] > 1) {
            count[0][1]--;
            vbox.getChildren().remove(buttonIndex - 1);
        }
    }

    @FXML
    void btnRemoveCapacitorSerialPressed(ActionEvent event) {
        VBox vbox = (VBox) gridSerial.getChildren().get(1);
        int buttonIndex = vbox.getChildren().indexOf(btnAddCapacitorSerial);
        if (vbox.getChildren().get(buttonIndex - 1) instanceof HBox && count[1][1] > 1) {
            count[1][1]--;
            vbox.getChildren().remove(buttonIndex - 1);
        }
    }

    @FXML
    void btnRemoveInductorParallelPressed(ActionEvent event) {
        VBox vbox = (VBox) gridParallel.getChildren().get(2);
        int buttonIndex = vbox.getChildren().indexOf(btnAddInductorParallel);
        if (vbox.getChildren().get(buttonIndex - 1) instanceof HBox && count[0][2] > 1) {
            count[0][2]--;
            vbox.getChildren().remove(buttonIndex - 1);
        }
    }

    @FXML
    void btnRemoveInductorSerialPressed(ActionEvent event) {
        VBox vbox = (VBox) gridSerial.getChildren().get(2);
        int buttonIndex = vbox.getChildren().indexOf(btnAddInductorSerial);
        if (vbox.getChildren().get(buttonIndex - 1) instanceof HBox && count[1][2] > 1) {
            count[1][2]--;
            vbox.getChildren().remove(buttonIndex - 1);
        }
    }

    @FXML
    void btnRemoveResistorParallelPressed(ActionEvent event) {
        VBox vbox = (VBox) gridParallel.getChildren().get(0);
        int buttonIndex = vbox.getChildren().indexOf(btnAddResistorParallel);
        if (vbox.getChildren().get(buttonIndex - 1) instanceof HBox && count[0][0] > 1) {
            count[0][0]--;
            vbox.getChildren().remove(buttonIndex - 1);
        }
    }

    @FXML
    void btnRemoveResistorSerialPressed(ActionEvent event) {
        VBox vbox = (VBox) gridSerial.getChildren().get(0);
        int buttonIndex = vbox.getChildren().indexOf(btnAddResistorSerial);
        if (vbox.getChildren().get(buttonIndex - 1) instanceof HBox && count[1][0] > 1) {
            count[1][0]--;
            vbox.getChildren().remove(buttonIndex - 1);
        }
    }

    @FXML
    void initialize() {
        count[0] = new int[]{1,1,1};
        count[1] = new int[]{1,1,1};
        
        tfResistor.setOnAction(event -> parallelResistorTfChanged(tfResistor));

    }

    void serialInductorTfChanged(TextField tf) {
        String newValue = tf.getText();
        int index = getTextFieldIndex(tf);
        if (index > -1) {
            try {
                float floatValue = Float.parseFloat(newValue);
                if (serialInductorValues.size() > index) {
                    serialInductorValues.set(index, floatValue);
                } else {
                    serialInductorValues.add(floatValue);
                }
            } catch (NumberFormatException e) {
                // TODO: handle exception
            }
        }
    }

    void serialResistorTfChanged(TextField tf) {
        String newValue = tf.getText();
        int index = getTextFieldIndex(tf);
        if (index > -1) {
            try {
                float floatValue = Float.parseFloat(newValue);
                if (serialResistorValues.size() > index) {
                    serialResistorValues.set(index, floatValue);
                } else {
                    serialResistorValues.add(floatValue);
                }
            } catch (NumberFormatException e) {
                // TODO: handle exception
            }
        }
    }

    void parallelCapacitorTfChanged(TextField tf) {
        String newValue = tf.getText();
        int index = getTextFieldIndex(tf);
        if (index > -1) {
            try {
                float floatValue = Float.parseFloat(newValue);
                if (parallelCapacitorValues.size() > index) {
                    parallelCapacitorValues.set(index, floatValue);
                } else {
                    parallelCapacitorValues.add(floatValue);
                }
            } catch (NumberFormatException e) {
                // TODO: handle exception
            }
        }
    }
    
    void serialCapacitorTfChanged(TextField tf) {
        String newValue = tf.getText();
        int index = getTextFieldIndex(tf);
        if (index > -1) {
            try {
                float floatValue = Float.parseFloat(newValue);
                    if (serialCapacitorValues.size() > index) {
                        serialCapacitorValues.set(index, floatValue);
                    } else {
                        serialCapacitorValues.add(floatValue);
                    }
            } catch (NumberFormatException e) {
                // TODO: handle exception
            }
        }
    }

    void parallelInductorTfChanged(TextField tf) {
        String newValue = tf.getText();
        int index = getTextFieldIndex(tf);
        if (index > -1) {
            try {
                float floatValue = Float.parseFloat(newValue);
                if (parallelInductorValues.size() > index) {
                        parallelInductorValues.set(index, floatValue);
                } else {
                        parallelInductorValues.add(floatValue);
                }
            } catch (NumberFormatException e) {
                // TODO: handle exception
            }
        }
    }

    void parallelResistorTfChanged(TextField tf) {
        String newValue = tf.getText();
        int index = getTextFieldIndex(tf);
        if (index > -1) {
            try {
                float floatValue = Float.parseFloat(newValue);
                if (parallelResistorValues.size() > index) {
                    parallelResistorValues.set(index, floatValue);
                } else {
                    parallelResistorValues.add(floatValue);
                }
            } catch (NumberFormatException e) {
                // Handle invalid input
            }
        }
    }


    private int getTextFieldIndex(TextField textField) {
        HBox hbox = (HBox) textField.getParent();
        VBox parentContainer = (VBox) hbox.getParent();
        return parentContainer.getChildren().indexOf(hbox);
    }

   /* private HBox createHBox(String labelText) {
        HBox hbox = new HBox();
        Label label = new Label(labelText);
        Label ohm = new Label("\u03A9");
        ohm.setFont(new Font(16));
        label.setFont(new Font(15));
        TextField tf = new TextField();
        tf.setPrefWidth(Region.USE_COMPUTED_SIZE);
        tf.setPrefHeight(Region.USE_COMPUTED_SIZE);

        hbox.getChildren().addAll(label, tf, ohm);
        HBox.setMargin(tf, new Insets(0, 0, 0, 5));
        HBox.setMargin(ohm, new Insets(0, 0, 0, 5));

        return hbox;
    } */
    
    void modify(Label label, TextField tf, Label ohm, HBox hbox) {
        ohm.setFont(new Font(16));
        label.setFont(new Font(15));
        
        tf.setPrefWidth(Region.USE_COMPUTED_SIZE);
        tf.setPrefHeight(Region.USE_COMPUTED_SIZE);
        hbox.getChildren().addAll(label, tf, ohm);
        HBox.setMargin(tf, new Insets(0, 0, 0, 5));
        HBox.setMargin(ohm, new Insets(0, 0, 0, 5));
    }

/*   public int count(GridPane gridPane, int column) {
        int count = 0;

        for (Node node : gridPane.getChildren()) {
            if (node instanceof VBox) {
                VBox vbox = (VBox) node;
                if (GridPane.getColumnIndex(vbox) == column && GridPane.getColumnIndex(vbox) != null) {
                    for (Node vboxChild : vbox.getChildren()) {
                        if (vboxChild instanceof HBox) {
                            HBox hbox = (HBox) vboxChild;
                            Node textFieldNode = hbox.getChildren().get(1); // Assuming the text field is at index 1
                            if (textFieldNode instanceof TextField) {
                                count++;
                            }
                        }
                    }
                }
            }
        }

        return count;
    }*/


}

