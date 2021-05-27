package pe.edu.upc.spring.controller;

import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.Transporte;
import pe.edu.upc.spring.service.ITransporteService;



@Controller
@RequestMapping("/transporte")
public class TransporteController {

	@Autowired
	private ITransporteService tService;
	
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";

	}
	
	@RequestMapping("/")
	public String irPaginaListadoTransportes(Map<String, Object> model) {
		model.put("listaTransportes", tService.listar());
		return "listTransporte";

	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("transporte", new Transporte());
		return "transporte";
		
	}
	
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Transporte objTransporte, BindingResult binRes, Model model) 
			throws ParseException 
	{
		if (binRes.hasErrors())
			return "transporte";
		else {
			boolean flag = tService.insertar(objTransporte);
			if (flag) 
				return "redirect:/transporte/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/transporte/irRegistrar";
			}
		}
	}
	
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
			throws ParseException 
	{
		Optional<Transporte> objTransporte = tService.listarId(id);
		if (objTransporte == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/transporte/listar";
		}
		else {
			model.addAttribute("transporte", objTransporte);
			return "transporte";
		}
	}
	
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				tService.eliminar(id);
				model.put("listaTransportes", tService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaTransportes", tService.listar());
		}
		return "listTransporte";
	}
	
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object>model) {
		model.put("listaTransportes", tService.listar());
		return "listTransporte";
	}
	
	
}


