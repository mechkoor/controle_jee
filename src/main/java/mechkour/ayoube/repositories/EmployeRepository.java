package mechkour.ayoube.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mechkour.ayoube.entities.Employe;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {
	
	

}
