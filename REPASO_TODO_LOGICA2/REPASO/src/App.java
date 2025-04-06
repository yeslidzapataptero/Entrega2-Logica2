import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        Inventario inventario = new Inventario();
        ListaPedidos listaSimple = new ListaPedidos();
        ListaCircularPedidos listaCircular = new ListaCircularPedidos();
        ListaDoblePedidos listaDoble = new ListaDoblePedidos();

        System.out.println("Sistema de Inventario de mi almacen de  ropa");
        System.out.println("Productos disponibles: ");
        inventario.mostrarInventario();

        while(true){
            System.out.println("1. Agregar pedido");
            System.out.println("2. Mostrar pedidos en una lista simple");
            System.out.println("3. Mostrar pedidos en una lista circular");
            System.out.println("4. Mostrar pedidos en una lista doble (adelante)");
            System.out.println("5. Mostrar pedidos en una lista doble (atras)");
            System.out.println("6. Salir");
            System.out.println("Ingrese una opción: ");
            int opcion = teclado.nextInt();
            teclado.nextLine();

            if (opcion == 6){
                System.out.println("Gracias por utilizar mi inventario de la ropa mas top");
                break;
            }

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del producto: ");
                    String producto = teclado.nextLine();
                    System.out.println("Ingrese la cantidad: ");
                    int cantidad = teclado.nextInt();

                    int indiceProducto = inventario.buscarProducto(producto);
                    if (indiceProducto == -1){
                        System.out.println("Producto no encontrado");
                        continue;
                    }
                    if (!inventario.verificarStock(indiceProducto, cantidad)){
                        System.out.println("lo sentimos ,no hay stock");
                        continue;
                    }

                    inventario.actualizarStock(indiceProducto, cantidad);
                    System.out.println("Seleccione la lista donde va a agregar el pedido: ");
                    System.out.println("1. Lista simple");
                    System.out.println("2. Lista circular");
                    System.out.println("3. Lista doble");
                    int listaSeleccionada = teclado.nextInt();
                    teclado.nextLine();

                    switch (listaSeleccionada) {
                        case 1:
                            listaSimple.agregarPedido(producto, cantidad);
                            break;
                        case 2:
                            listaCircular.agregarPedido(producto, cantidad);
                            break;
                        case 3:
                            listaDoble.agregarPedido(producto, cantidad);
                            break;
                    
                        default:
                            System.out.println("Opción inválida");
                    }
            }

        }
    }
}
