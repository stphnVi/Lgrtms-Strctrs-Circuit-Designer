package application;

public class Lista {
	//Lista para el valor de las patillas
	//debe tener el nombre de las pat�llas
	
	
	//primer nodo
	private Nodo cabeza;
	private int tama�o;
	//contsructor
	Lista(){
		cabeza = null;
		//tama�o guarda la cantidad de elementos
		tama�o = 0;	
	}
	void agregarDelante(Object o) {
		if(cabeza ==null){
			cabeza = new Nodo(o);	
		}else {
			Nodo temp = cabeza;
			Nodo nuevo = new Nodo(o);
			nuevo.agregar(temp);
			cabeza = nuevo;
		}
		tama�o++;
	}
	
	Object ver(int indice) {
		Nodo temp = cabeza;
		for(int i=0; i<indice; i++) {
			temp = temp.VerSig();
		}
		return temp.VerDato();
		}
	}

