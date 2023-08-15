package birinchi_dars.project_yaratish.service;

import birinchi_dars.project_yaratish.Repository.EmployeRepository;
import birinchi_dars.project_yaratish.entity.Employe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeService {
    private final EmployeRepository employeRepository;
    public EmployeService(EmployeRepository employeRepository){
        this.employeRepository=employeRepository;
    }
    public Employe save(Employe employe){
        return employeRepository.save(employe);
    }

    public void delete(Long id){
        employeRepository.deleteById(id);
    }

    public Employe findByID(Long id){
        Employe employe=employeRepository.findById(id).get();
        return employe;
    }
    public List<Employe> findAll(String name,String last_name){
        List<Employe> employe=employeRepository.findAll(name,last_name);
        return employe;
    }


}

