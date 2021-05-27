package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Transporte;
import pe.edu.upc.spring.repository.ITransporteRepository;
import pe.edu.upc.spring.service.ITransporteService;

@Service
public class TransporteServiceImpl implements ITransporteService{

	@Autowired
	private ITransporteRepository dTransporte;
	
	
	@Override
	@Transactional
	public boolean insertar(Transporte transporte) {
		Transporte objTransporte = dTransporte.save(transporte);
		if(objTransporte ==null)
			return false;
		else
		return true;
	}
	
	
	@Override
	@Transactional
	public boolean modificar(Transporte transporte) {
		boolean flag = false;
		try {
			dTransporte.save(transporte);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un error al modificar");
		}
		return flag;
	}
	
	@Override
	@Transactional
	public void eliminar(int idTransporte) {
		dTransporte.deleteById(idTransporte);
		
	}
	
	
	@Override
	@Transactional(readOnly=true)
	public Optional<Transporte> listarId(int idTransporte) {
		return dTransporte.findById(idTransporte);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Transporte> listar() {
		
		return dTransporte.findAll();
	}
}

