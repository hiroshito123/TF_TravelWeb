package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Transporte;



public interface ITransporteService {

	public boolean insertar(Transporte transporte);
	public boolean modificar(Transporte transporte);
	public void eliminar (int idTransporte);
	public 	Optional<Transporte> listarId(int idTransporte);
	List<Transporte> listar();
}