package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class IPrincipal extends AnchorPane {
	public IPrincipal() {
	FXMLLoader fxmlLoader = new FXMLLoader(
			getClass().getResource("/Sample.fxml"));
	
	fxmlLoader.setRoot(this); 
	fxmlLoader.setController(this);
	
	try { 
		fxmlLoader.load();
    
	} catch (IOException exception) {
	    throw new RuntimeException(exception);
	}
}

}
