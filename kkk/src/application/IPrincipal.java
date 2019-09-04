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
		ListaPatillas();
    
	} catch (IOException exception) {
	    throw new RuntimeException(exception);
	}
}
	
	public void Crear() {
		FabCompuertas Fab = new FabCompuertas();
		Compuerta a2 = Fab.getConexion("And");
		a2.icono();
	}
	
	public void ListaPatillas() {
		Lista L = new Lista();
		L.agregarDelante(6);
		L.agregarDelante(7);
		System.out.print(L.ver(1));
		
	}

}











