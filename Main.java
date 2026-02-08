package TareasP3;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("\n    Menu principal   ");
            System.out.println("5. Figuras geometricas");
            System.out.println("6. Gestion de productos");
            System.out.println("7. Inventario con arrays");
            System.out.println("8. Copia de arrays");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 5 -> ejercicio5();
                case 6 -> ejercicio6();
                case 7 -> ejercicio7();
                case 8 -> ejercicio8();
            }
        } while (opcion != 0);
    }

    private static void ejercicio5() {
        System.out.print("Cuantas figuras quiere ingresar?: ");
        int n = sc.nextInt();

        Figura[] figuras = new Figura[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Figura " + (i + 1));
            System.out.println("1. Cuadrado");
            System.out.println("2. Rectangulo");
            System.out.println("3. Circulo");
            System.out.print("Seleccione el tipo: ");
            int tipo = sc.nextInt();

            switch (tipo) {
                case 1:
                    System.out.print("Ingrese el lado: ");
                    figuras[i] = new Cuadrado(sc.nextDouble());
                    break;
                case 2:
                    System.out.print("Ingrese la base: ");
                    double base = sc.nextDouble();
                    System.out.print("Ingrese la altura: ");
                    double altura = sc.nextDouble();
                    figuras[i] = new Rectangulo(base, altura);
                    break;
                case 3:
                    System.out.print("Ingrese el radio: ");
                    figuras[i] = new Circulo(sc.nextDouble());
                    break;
                default:
                    System.out.println("Tipo invalido");
                    figuras[i] = new Cuadrado(1);
            }
        }

        System.out.println("areas:");
        for (Figura f : figuras) {
            System.out.println("area: " + f.area());
        }
    }

    private static void ejercicio6() {
        System.out.print("Nombre del producto: ");
        sc.nextLine();
        String nombre = sc.nextLine();

        System.out.print("Precio: ");
        double precio = sc.nextDouble();

        System.out.print("Stock inicial: ");
        int stock = sc.nextInt();

        Producto p = new Producto(nombre, precio, stock);

        System.out.print("Cuantas unidades quiere vender?: ");
        int cantidad = sc.nextInt();
        p.vender(cantidad);

        System.out.println("Stock restante: " + p.getStock());
    }

    private static void ejercicio7() {
        Producto p = new Producto("Laptop", 45000, 10);
        System.out.println("Stock inicial: " + p.getStock());
        p.vender(3);
        System.out.println("Stock luego de vender: " + p.getStock());
    }

    private static void ejercicio71() {
        Producto[] inventario = new Producto[3];
        inventario[0] = new Producto("Mouse", 500, 5);
        inventario[1] = new Producto("Teclado", 1500, 0);
        inventario[2] = new Producto("Monitor", 12000, 2);

        double total = 0;
        for (Producto p : inventario) {
            total += p.valorTotal();
        }

        System.out.println("Valor total del inventario: " + total);
        System.out.println("Productos con stock disponible:");

        for (Producto p : inventario) {
            if (p.getStock() > 0) {
                System.out.println(p.getNombre() + " - Stock: " + p.getStock());
            }
        }
    }

    private static void ejercicio8() {
        int[] original = {1, 2, 3, 4};
        int[] copia = original.clone();
        copia[0] = 99;

        System.out.print("Original: ");
        for (int n : original) System.out.print(n + " ");

        System.out.print("\nCopia: ");
        for (int n : copia) System.out.print(n + " ");

        /*Cuando usas 'clone()' en un array de tipos primitivos (como int), Java realiza 
          una "Copia Superficial en este caso, al ser enteros, 
         funciona como una copia completa e independiente.*/





    }
}
