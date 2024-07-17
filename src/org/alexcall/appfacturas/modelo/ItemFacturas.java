package org.alexcall.appfacturas.modelo;

public class ItemFacturas {
    private int cantidad;
    private Producto producto;

    public ItemFacturas(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public float calcularImporte () {
        return this.cantidad * this.producto.getPrecio();
    }
}
