package birinchi_dars.project_yaratish.web.rest;

import birinchi_dars.project_yaratish.entity.Employe;
import birinchi_dars.project_yaratish.service.EmployeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api")
public class EmployeResurce {
    private final EmployeService employeService;
    public EmployeResurce(EmployeService employeService){
        this.employeService=employeService;
    }
    @PostMapping("/employees")
    public ResponseEntity create(@RequestBody Employe employe){
        Employe result=employeService.save(employe);
        return ResponseEntity.ok(result);
    }
    @PutMapping("/employees")
    public ResponseEntity update(@RequestBody Employe employe){
        if(employe.getId()==null){
            return ResponseEntity.ok("Error");
        }
        Employe result=employeService.save(employe);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("/employees/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        employeService.delete(id);
        return ResponseEntity.ok("Qator o'chdi!..");
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        Employe result=employeService.findByID(id);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/employees")
    public ResponseEntity getAll(@RequestParam String name){
        List<Employe> employe=employeService.findAll(name);
        return ResponseEntity.ok(employe);
    }
}
