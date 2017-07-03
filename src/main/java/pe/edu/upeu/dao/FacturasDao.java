/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.dao;

import java.util.List;
import pe.edu.upeu.model.Facturas;

/**
 *
 * @author server-itecs
 */
public interface FacturasDao {

    List<Facturas> listFacturas();

    void guardarFacturas(Facturas factura);

    void eliminarFacturasId(int id);

    void modificarFacturasId(Facturas factura);

    List<Facturas> listarPorNombre(String nombre);

    Facturas buscarFacturasId(int id);

}
