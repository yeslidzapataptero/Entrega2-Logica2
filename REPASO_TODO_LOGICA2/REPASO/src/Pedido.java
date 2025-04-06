    public class Pedido {
    String producto;
    int cantidad;

    Pedido siguiente;
    Pedido anterior;
    
    // Constructor
    public Pedido(String producto, int cantidad, Pedido siguiente, Pedido anterior) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }
}


