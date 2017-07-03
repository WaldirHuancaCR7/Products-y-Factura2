/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.dao.FacturasDao;
import pe.edu.upeu.model.Facturas;

/**
 *
 * @author server-itecs
 */
@Service("facturasService")
@Transactional
public class FacturasServiceImpl implements FacturasService {

    @Autowired
    public FacturasDao dao;

    @Override
    public List<Facturas> listFacturas() {
        return dao.listFacturas();
    }

    @Override
    public void guardarFacturas(Facturas facturas) {
        dao.guardarFacturas(facturas);
    }

    @Override
    public void eliminarFacturasId(int id) {
        dao.eliminarFacturasId(id);
    }

    @Override
    public void modificarFacturasId(Facturas facturas) {
        dao.modificarFacturasId(facturas);
    }

    @Override
    public List<Facturas> listarPorNombre(String nombre) {
        return dao.listarPorNombre(nombre);
    }

    @Override
    public Facturas buscarFacturasId(int id) {
        return dao.buscarFacturasId(id);
    }

}
