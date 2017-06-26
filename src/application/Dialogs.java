package application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class Dialogs {
	
	/** Shows an information alert.
	 * @param title the title of the pop up window
	 * @param headerText the string to show in the dialog header area
	 * @param infoText the string to show in the dialog content area
	 */
	public static void alert(String title, String headerText, String infoText) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText(infoText);
		alert.showAndWait();
		System.out.print("hej");
	}
}
