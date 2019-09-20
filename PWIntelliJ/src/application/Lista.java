package application;

public class Lista {
    //Lista para el valor de las patillas
    //debe tener el nombre de las patillas
    //primer nodo
    private Nodo cabeza;
    private int tamaño;
    //contsructor
    //AGREGUÉ SETTERS AND GETTERS PARA TAMAÑO, AUNQUE NO ERA NECESARIO


    public Lista(){
        cabeza = null;
        //tamaño guarda la cantidad de elementos
        setTamaño(0);
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
        setTamaño(getTamaño() + 1);
    }

    Object ver(int indice) {
        Nodo temp = cabeza;
        for(int i=0; i<indice; i++) {
            temp = temp.VerSig();
        }
        return temp.VerDato();
    }
    public int getTamaño() {
        return tamaño;
    }
    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }
}

