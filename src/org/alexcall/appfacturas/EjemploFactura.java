package org.alexcall.appfacturas;

import org.alexcall.appfacturas.modelo.*;

import java.util.Scanner;

public class EjemploFactura {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setRuc("1075178");
        cliente.setNombre("Alexander");

        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingresa una descripcion para la factura: ");
        Facturas facturas = new Facturas(entrada.nextLine(), cliente);

        Producto producto;
        System.out.println();
        for(int i=0; i < 2; i++){
           producto = new Producto();
            System.out.print("Ingresa producto n° " + producto.getCodigo()+ ": ");
            producto.setNombre(entrada.nextLine());

            System.out.print("Ingrese el precio: ");
            producto.setPrecio(entrada.nextFloat());

            System.out.print("Ingrese la cantidad: ");
            facturas.addItemFacturas(new ItemFacturas(entrada.nextInt(), producto));

            System.out.println();
            entrada.nextLine();
        }
        System.out.println(facturas);
    }
}
