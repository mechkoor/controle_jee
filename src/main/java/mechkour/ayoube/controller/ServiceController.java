package mechkour.ayoube.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mechkour.ayoube.entities.Servicee;
import mechkour.ayoube.services.ServiceService;

@RestController
@RequestMapping("/api/service")
public class ServiceController {
	@Autowired
	private ServiceService ServiceeSer;
	
	@PostMapping("/save")
	public Servicee ajouterServicee(@RequestBody Servicee Servicee) {
		Servicee.setId(0);
		return ServiceeSer.create(Servicee);	
	}
	
	
	@GetMapping("/all")
	public List<Servicee> getAllServicee(){
		return ServiceeSer.findAll();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findServiceeById(@PathVariable int id){
		Servicee Servicee=ServiceeSer.findById(id);
		if(Servicee==null) {
			return new ResponseEntity<Object>("la Servicee avec id "+id+" n'esxiste pas",HttpStatus.BAD_REQUEST);
			
		}
		else {
			return  ResponseEntity.ok(Servicee);
		}
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateServicee(@PathVariable int id,@RequestBody Servicee Servicee){
		Servicee oldServicee=ServiceeSer.findById(id);
		if(oldServicee==null) {
			return new ResponseEntity<Object>("Servicee avec id "+id+" n'exsiste pas",HttpStatus.BAD_REQUEST);
		}
		else {
			Servicee.setId(id);
			return ResponseEntity.ok(ServiceeSer.update(Servicee));
		}
		
	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteServicee(@PathVariable int id ) {
		Servicee Servicee=ServiceeSer.findById(id);
		if (Servicee==null) {
			return new ResponseEntity<Object>("Servicee avec id "+id+" n'exsiste pas ", HttpStatus.BAD_REQUEST);
		}
		else {
			ServiceeSer.delete( Servicee);
			return  ResponseEntity.ok("Servicee supprimé");
			
		}
		
	
		
	}


}
