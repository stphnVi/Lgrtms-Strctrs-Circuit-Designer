package application;

/***
 * @see
 * Lista se encaga de contener los nodos y operarlos
 */
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
    public void agregarDelante(Object o) {
        if(cabeza ==null){
            cabeza = new Nodo(o);
        }else {
            Nodo temp = cabeza;
            Nodo nuevo = new Nodo(o);
            nuevo.agregar(temp);
            cabeza = nuevo;
        }
        tamaño++;
        //setTamaño(getTamaño() + 1);
    }
    public void eliminar(int index){
        if(index ==0){
            cabeza =cabeza.VerSig();
        }else{
            int contador = 0;
            Nodo temp = cabeza;
            while(contador< index-1){
                temp = temp.VerSig();
                contador++;
            }
            temp.agregar(temp.VerSig().VerSig());
        }
        tamaño--;
    }

    public Object ver(int indice) {
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

