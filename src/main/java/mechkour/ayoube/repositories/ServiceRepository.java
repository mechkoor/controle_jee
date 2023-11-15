package mechkour.ayoube.repositories;

import java.security.Provider.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mechkour.ayoube.entities.Servicee;


@Repository
public interface ServiceRepository extends JpaRepository<Servicee, Long> {

	

	

}
