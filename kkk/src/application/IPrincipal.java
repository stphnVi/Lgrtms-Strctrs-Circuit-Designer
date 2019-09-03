package application;

import java.io.IOException;

import InterFac.Compuerta;
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
		Crear();
    
	} catch (IOException exception) {
	    throw new RuntimeException(exception);
	}
}
	
	public void Crear() {
		FabCompuertas Fab = new FabCompuertas();
		Compuerta a2 = Fab.getConexion("And");
		a2.icono();
	}

}











