package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Hotel;



public interface IHotelService {

	public boolean insertar(Hotel hotel);
	public boolean modificar(Hotel hotel);
	public void eliminar (int idHotel);
	public 	Optional<Hotel> listarId(int idHotel);
	List<Hotel> listar();
}