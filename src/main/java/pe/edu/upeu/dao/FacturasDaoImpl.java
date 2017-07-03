/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.configuration.SysDataAccess;
import pe.edu.upeu.model.Facturas;

/**
 *
 * @author server-itecs
 */
@Repository("facturasDao")
public class FacturasDaoImpl extends SysDataAccess<Integer, Facturas> implements FacturasDao {

    @Override
    public List<Facturas> listFacturas() {
        return getListAll();
    }

    @Override
    public void guardarFacturas(Facturas facturas) {
        savev(facturas);
    }

    @Override
    public void eliminarFacturasId(int id) {
        delete(id);
    }

    @Override
    public void modificarFacturasId(Facturas factura) {
        update(factura);
    }

    @Override
    public List<Facturas> listarPorNombre(String nombre) {
        return (List<Facturas>) sessionFactory.getCurrentSession()
                .createQuery("select a from Facturas a where a.nombreFacturas like ? ")
                .setString(0, "%" + nombre + "%")
                .list();
    }

    @Override
    public Facturas buscarFacturasId(int id) {
        return getByKey(id);
    }

}
