public class Producto {
private String nombre;
private double precio;
private int stock;


public Producto(String nombre, double precio, int stock) {
setNombre(nombre);
setPrecio(precio);
setStock(stock);
}


public String getNombre() {
return nombre;
}


public void setNombre(String nombre) {
this.nombre = nombre;
}


public double getPrecio() {
return precio;
}


public void setPrecio(double precio) {
if (precio >= 0) {
this.precio = precio;
}
}


public int getStock() {
return stock;
}


public void setStock(int stock) {
if (stock >= 0) {
this.stock = stock;
}
}


public void vender(int cantidad) {
if (cantidad > 0 && cantidad <= stock) {
stock -= cantidad;
}
}


public double valorTotal() {
return precio * stock;
}
}

