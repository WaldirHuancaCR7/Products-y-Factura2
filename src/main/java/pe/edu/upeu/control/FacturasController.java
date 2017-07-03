/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.control;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import pe.edu.upeu.model.Facturas;
import pe.edu.upeu.service.FacturasService;

/**
 *
 * @author server-itecs
 */
@Controller
@RequestMapping("/facturas")
public class FacturasController {

    @Autowired
    FacturasService service;
    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public ModelAndView listFacturas(ModelMap model) {
        List<Facturas> lista = service.listFacturas();
        Map<String, Object> modelo = new HashMap<String, Object>();
        modelo.put("ListaFacturas", lista);
        modelo.put("saludo", "Hola amigos");

        return new ModelAndView("factura/mainFacturas", modelo);
    }

    @RequestMapping(value = "formFactura", method = RequestMethod.GET)
    public ModelAndView irFormulario(@ModelAttribute("modeloFacturas") Facturas entidad, BindingResult result) {
        Map<String, Object> modelo = new HashMap<String, Object>();
        return new ModelAndView("factura/formFacturas", modelo);
    }

    @RequestMapping(value = "guardarFacturas", method = RequestMethod.POST)
    public ModelAndView guardarFacturas(@ModelAttribute("modeloFacturas") Facturas entidad,
            BindingResult result) {

        service.guardarFacturas(entidad);
        return new ModelAndView(new RedirectView("list"));
    }

    @RequestMapping(value = "buscarFacturas", method = RequestMethod.GET)
    public String buscarFacturas(HttpServletRequest r, Model model) {
        int id = Integer.parseInt(r.getParameter("id"));
        Facturas facturas = null;
        facturas = service.buscarFacturasId(id);
        model.addAttribute("modeloFacturas", facturas);
        return "Facturas/formUFacturas";
    }

    @RequestMapping(value = "actualizarFacturas", method = RequestMethod.POST)
    public ModelAndView actualizarFacturas(@ModelAttribute("modeloFacturas") Facturas entidad,
            BindingResult result) {
        service.modificarFacturasId(entidad);
        return new ModelAndView(new RedirectView("list"));
    }

    @RequestMapping(value = "buscarFacturasNombre", method = RequestMethod.POST)
    public ModelAndView buscarFacturasNombre(HttpServletRequest r) {
        String dato = r.getParameter("dato") == null ? "" : r.getParameter("dato");
        List<Facturas> lista = service.listarPorNombre(dato);
        Map<String, Object> modelo = new HashMap<String, Object>();
        modelo.put("ListaFacturas", lista);
        return new ModelAndView("facturas/mainFacturas", modelo);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
        // You can register other Custom Editors with the WebDataBinder, like CustomNumberEditor for Integers and Longs, or StringTrimmerEditor for Strings
    }

}
