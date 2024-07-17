package org.alexcall.appfacturas.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Facturas {
    private int folio;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private ItemFacturas[] itemFacturas;
    private int indiceFacturas;

    public static final int MAX_ITEMS = 10;
    public static int ultimoFolio;



    public Facturas(String descripcion, Cliente cliente) {
        this.cliente = cliente;
        this.descripcion = descripcion;
        this.itemFacturas = new ItemFacturas[MAX_ITEMS];
        this.folio = ++ultimoFolio;
        this.fecha = new Date();
    }

    public int getFolio() {
        return folio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ItemFacturas[] getItemFacturas() {
        return itemFacturas;
    }

    public void addItemFacturas(ItemFacturas item) {
        if (indiceFacturas < MAX_ITEMS) {
            this.itemFacturas[indiceFacturas++] = item;
        }
    }

    public float calcularTotal() {
        float total = 0.0f;
        for (ItemFacturas item : this.itemFacturas) {
            if (item == null) {
                continue;
            }
            total += item.calcularImporte();
        }
        return total;
    }

    public String generarDetalle() {
        StringBuilder sb = new StringBuilder("Factura N°: ");
        sb.append(folio)
                .append("\nCliente: ")
                .append(this.cliente.getNombre())
                .append("\t RUC:")
                .append(cliente.getRuc())
                .append("\nDescripcion: ")
                .append(this.descripcion)
                .append("\n");

        SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM,yyyy");
        sb.append("Fecha de emision: ")
                .append(df.format(this.fecha))
                .append("\n")
                .append("\n#\tNombre\t$\tCant.\tTotal\n");
        for (ItemFacturas item : this.itemFacturas) {
            if(item == null){
                continue;
            }
            sb.append(item.getProducto().getCodigo())
                    .append("\t")
                    .append(item.getProducto().getNombre())
                    .append("\t")
                    .append(item.getProducto().getPrecio())
                    .append("\t")
                    .append(item.getCantidad())
                    .append("\t")
                    .append(item.calcularImporte())
                    .append("\n");
        }
        sb.append("Gran Total: ")
                .append(calcularTotal());

        return sb.toString();
    }

}
