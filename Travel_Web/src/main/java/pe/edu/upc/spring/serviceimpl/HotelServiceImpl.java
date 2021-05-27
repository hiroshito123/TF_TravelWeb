package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Hotel;
import pe.edu.upc.spring.repository.IHotelRepository;
import pe.edu.upc.spring.service.IHotelService;

@Service
public class HotelServiceImpl implements IHotelService{

	@Autowired
	private IHotelRepository dHotel;
	
	
	@Override
	@Transactional
	public boolean insertar(Hotel hotel) {
		Hotel objHotel = dHotel.save(hotel);
		if(objHotel ==null)
			return false;
		else
		return true;
	}
	
	
	@Override
	@Transactional
	public boolean modificar(Hotel hotel) {
		boolean flag = false;
		try {
			dHotel.save(hotel);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un error al modificar");
		}
		return flag;
	}
	
	@Override
	@Transactional
	public void eliminar(int idHotel) {
		dHotel.deleteById(idHotel);
		
	}
	
	
	@Override
	@Transactional(readOnly=true)
	public Optional<Hotel> listarId(int idHotel) {
		return dHotel.findById(idHotel);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Hotel> listar() {
		
		return dHotel.findAll();
	}
}
