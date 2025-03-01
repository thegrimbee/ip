package kyrie;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Kyrie kyrie;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/nerd.jfif"));
    private Image dukeImage = new Image(this.getClass().getResourceAsStream("/images/DaKyrie.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    /** Injects the Kyrie program into the GUI.
     * 
     * @param k The Kyrie program to be injected.
     */
    public void setKyrie(Kyrie kyrie) {
        this.kyrie = kyrie;
        dialogContainer.getChildren().addAll(
            DialogBox.getKyrieDialog(kyrie.getWelcomeMessage(), dukeImage)
        );
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = kyrie.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getKyrieDialog(response, dukeImage)
        );
        userInput.clear();
    }
}