package application;

public class Nodo {
    //Valor que contiene el noto
    Object valor;
    //enlace de nodos
    Nodo siguiente;

    public Nodo(Object valor) {
        this.valor = valor;
    }

    //apuntar nodos
    public void enlazarSiguiente(Nodo n) {
        siguiente = n;
    }

    public Nodo obtenerSiguiente() {
        return siguiente;
    }

    public Object obtenerValor() {
        return valor;

    }

    /*
    siguiente puede ser nulo, cuando se retorne el valor nulo
    significa que no hay punteros
     */
}
