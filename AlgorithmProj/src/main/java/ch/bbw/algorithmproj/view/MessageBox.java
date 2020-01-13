package ch.bbw.algorithmproj.view;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MessageBox {
	public static Optional<ButtonType> show(String sHeader, String sBody) {
		return show(sHeader, sBody, AlertType.NONE);
	}

	public static Optional<ButtonType> show(String message) {
		return show(message, "no Details", AlertType.NONE);
	}

	public static Optional<ButtonType> show(String message, String sDetail, AlertType type) {
		Alert alertDlg = new Alert(type);

		switch (type) {
		case NONE:
			alertDlg.setTitle("Meldung");
			break;
		case INFORMATION:
			alertDlg.setTitle("Information");
			break;
		case ERROR:
			alertDlg.setTitle("Fehler");
			break;
		case WARNING:
			alertDlg.setTitle("Warnung");
			break;
		case CONFIRMATION:
			alertDlg.setTitle("Bestaetigung");
			break;
		default:
			break;
		}
		alertDlg.setContentText("");
		alertDlg.setHeaderText(message);
		alertDlg.setContentText(sDetail);
		((Stage)alertDlg.getDialogPane().getScene().getWindow()).getIcons().add(new Image(MessageBox.class.getResourceAsStream("Images/icon.png")));

		return alertDlg.showAndWait();
	}
}
