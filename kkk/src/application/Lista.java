package application;

public class Lista {
	//Lista para el valor de las patillas
	//debe tener el nombre de las patíllas
	
	
	//primer nodo
	private Nodo cabeza;
	private int tamaño;
	//contsructor
	Lista(){
		cabeza = null;
		//tamaño guarda la cantidad de elementos
		tamaño = 0;	
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
		tamaño++;
	}
	
	Object ver(int indice) {
		Nodo temp = cabeza;
		for(int i=0; i<indice; i++) {
			temp = temp.VerSig();
		}
		return temp.VerDato();
		}
	}

