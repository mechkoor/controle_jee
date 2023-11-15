package mechkour.ayoube.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mechkour.ayoube.dao.IDao;
import mechkour.ayoube.entities.Servicee;
import mechkour.ayoube.repositories.ServiceRepository;

@Service
public class ServiceService  implements IDao<Servicee>{

	@Autowired
	 private ServiceRepository ServiceRep;
	
	
	@Override
	public Servicee create(Servicee o) {
		return ServiceRep.save(o);
	}

	@Override
	public boolean delete(Servicee o) {
		try {
			ServiceRep.delete(o);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public Servicee update(Servicee o) {
		return ServiceRep.save(o);
	}

	@Override
	public Servicee findById(long id) {
		return ServiceRep.findById((long) id).orElse(null);
	}

	@Override
	public List<Servicee> findAll() {
		return ServiceRep.findAll();
	}
	
}



	

 
	


