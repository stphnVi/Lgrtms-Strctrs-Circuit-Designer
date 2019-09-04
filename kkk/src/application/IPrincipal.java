package application;

import java.io.IOException;

import com.sun.xml.internal.ws.org.objectweb.asm.Label;

import InterFac.Compuerta;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class IPrincipal extends AnchorPane {

	@FXML VBox left_pane;
	// Nueva compuerta
	Image labelImage = new Image(getClass().getResourceAsStream("and.jpg"));
	private Label label1 = new Label();
	private Label label2 = new Label();
	
	

	//Llamada a la ventana principal 

	public IPrincipal() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Sample.fxml"));
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
		
		
		//creación del Icono de compuerta
		label1.relocate(524, 280);
	    label1.setGraphic(new ImageView(labelImage));
	    this.getChildren().add(label1);

	    label2.relocate(250, 200);
	    label2.setGraphic(new ImageView(labelImage));
	    this.getChildren().add(label2);
	    
	    
	    left_pane.getChildren().add(labelImage);
	    
		
		
	}

	public void ListaPatillas() {
		Lista L = new Lista();
		L.agregarDelante(6);
		L.agregarDelante(7);
		System.out.print(L.ver(1));

	}

}











