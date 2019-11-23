package com.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.app.models.dao.IClienteDao;
import com.springboot.app.models.dao.IProyectoDao;
import com.springboot.app.models.dao.IVersionProductoDao;


@Controller
public class ClienteController {
	
	@Autowired
	private IClienteDao clienteDao;
	
	@Autowired 
	private IProyectoDao proyectoDao;
	
	@Autowired 
	private IVersionProductoDao productoDao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String clientes( Model model) {
		
		model.addAttribute("titulo", "Datos de clientes");
		model.addAttribute("clientes", clienteDao.findAll());
		model.addAttribute("titulo_proyectos","Proyectos asociados");
		model.addAttribute("titulo_productos","Versiones de productos asociados");
		model.addAttribute("productos",productoDao.findAll());
		model.addAttribute("proyectos", proyectoDao.findAll());
		
		return "listado";
	}
}
