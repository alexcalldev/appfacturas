package org.alexcall.appfacturas.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Facturas {
    private int folio;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private ItemFacturas[] items;
    private int indiceItems;

    public static final int MAX_ITEMS = 10;
    public static int ultimoFolio;



    public Facturas(String descripcion, Cliente cliente) {
        this.cliente = cliente;
        this.descripcion = descripcion;
        this.items = new ItemFacturas[MAX_ITEMS];
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
        return items;
    }

    public void addItemFacturas(ItemFacturas item) {
        if (indiceItems < MAX_ITEMS) {
            this.items[indiceItems++] = item;
        }
    }

    public float calcularTotal() {
        float total = 0.0f;
        for (int i=0; i < indiceItems; i++) {
            total += this.items[i].calcularImporte();
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
        for (int i=0; i < indiceItems; i++) {
            sb.append(this.items[i].toString())
                    .append("\n");
        }
        sb.append("Gran Total: ")
                .append(calcularTotal());
        return sb.toString();
    }

    @Override
    public String toString() {
        return generarDetalle();
    }
}
