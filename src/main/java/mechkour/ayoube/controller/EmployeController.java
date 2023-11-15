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

import mechkour.ayoube.entities.Employe;
import mechkour.ayoube.services.EmployeeService;



@RestController
@RequestMapping("/api/employe")
public class EmployeController {
	@Autowired
	private EmployeeService EmployeSer;
	
	@PostMapping("/save")
	public Employe ajouterEmploye(@RequestBody Employe Employe) {
		Employe.setId(0);
		return EmployeSer.create(Employe);	
	}
	
	
	@GetMapping("/all")
	public List<Employe> getAllEmploye(){
		return EmployeSer.findAll();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findEmployeById(@PathVariable int id){
		Employe Employe=EmployeSer.findById(id);
		if(Employe==null) {
			return new ResponseEntity<Object>("la Employe avec id "+id+" n'esxiste pas",HttpStatus.BAD_REQUEST);
			
		}
		else {
			return  ResponseEntity.ok(Employe);
		}
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateEmploye(@PathVariable int id,@RequestBody Employe Employe){
		Employe oldEmploye=EmployeSer.findById(id);
		if(oldEmploye==null) {
			return new ResponseEntity<Object>("Employe avec id "+id+" n'exsiste pas",HttpStatus.BAD_REQUEST);
		}
		else {
			Employe.setId(id);
			return ResponseEntity.ok(EmployeSer.update(Employe));
		}
		
	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteEmploye(@PathVariable int id ) {
		Employe Employe=EmployeSer.findById(id);
		if (Employe==null) {
			return new ResponseEntity<Object>("Employe avec id "+id+" n'exsiste pas ", HttpStatus.BAD_REQUEST);
		}
		else {
			EmployeSer.delete( Employe);
			return  ResponseEntity.ok("Employe supprimé");
			
		}
		
	
		
	}

}
