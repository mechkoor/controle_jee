package mechkour.ayoube.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mechkour.ayoube.dao.IDao;
import mechkour.ayoube.entities.Employe;
import mechkour.ayoube.repositories.EmployeRepository;


@Service
public class EmployeeService implements IDao<Employe>{

	@Autowired
	 private EmployeRepository EmployeRep;
	
	
	@Override
	public Employe create(Employe o) {
		return EmployeRep.save(o);
	}

	@Override
	public boolean delete(Employe o) {
		try {
			EmployeRep.delete(o);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public Employe update(Employe o) {
		return EmployeRep.save(o);
	}

	@Override
	public Employe findById(long id) {
		return EmployeRep.findById((long) id).orElse(null);
	}

	@Override
	public List<Employe> findAll() {
		return EmployeRep.findAll();
	}
	


}

