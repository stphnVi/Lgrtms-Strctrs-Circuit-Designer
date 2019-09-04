package application;

import java.io.IOException;

import InterFac.Compuerta;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class IPrincipal extends AnchorPane {

	@FXML VBox left_pane;



	//Llamada a la ventaa principal 

	public IPrincipal() {
		FXMLLoader fxmlLoader = new FXMLLoader(
				getClass().getResource("/Sample.fxml"));

		fxmlLoader.setRoot(this); 
		fxmlLoader.setController(this);

		try { 
			//Cargar la ventana principal
			fxmlLoader.load();
			//Crear compuertas
			Crear();
			//Lista
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











