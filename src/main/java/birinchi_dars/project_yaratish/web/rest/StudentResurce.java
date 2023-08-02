package birinchi_dars.project_yaratish.web.rest;

import birinchi_dars.project_yaratish.model.Cource;
import birinchi_dars.project_yaratish.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public final class StudentResurce {
//     @GetMapping("/students")
//         public ResponseEntity hello(){
//             return ResponseEntity.ok("Hello World!.");
//         }
    @RequestMapping(value = "/students",method= RequestMethod.GET)
    public ResponseEntity  hello(){
            return ResponseEntity.ok("Hello World!."); 
    }

    @PostMapping("/students")
    public  ResponseEntity create(@RequestBody Student student){
     return ResponseEntity.ok(student);
    }

    @PutMapping("/students")
    public  ResponseEntity update(@RequestBody Student student){
        student.setLastName("test uchun");
        return ResponseEntity.ok(student);

    }

    @PutMapping("/students/{id}")
    public  ResponseEntity updateSecond(@PathVariable Long id,
                                        @RequestBody Student student){
        student.setLastName("test uchun");
        student.setId(id);
        return ResponseEntity.ok(student);

    }

    @GetMapping("/students/{id}")
    public  ResponseEntity<Student> getOne(@PathVariable Long id){
        Student student=new Student();
        student.setId(id);
        return ResponseEntity.ok(student);

    }
    @GetMapping("/students1")
    public  ResponseEntity<Student> getAll(@RequestParam Long id,
                                           @RequestParam String name,
                                           @RequestParam String lastName,
                                           @RequestParam Integer age){
        List<Student>students=new ArrayList<>();
        Cource cource=new Cource();
        cource.setId(2L);
        cource.setName("Test-Uchun");
        students.add(new Student(3L,"name","lastName",22));
        return ResponseEntity.ok(null);

    }

    @DeleteMapping("/students/{id}")
    public  ResponseEntity delete(@PathVariable Long id){
        return ResponseEntity.ok(id+"o'chirildi");
    }

    @PatchMapping("/students/{id}")
    public  ResponseEntity patchUpdate(@PathVariable Long id,
                                       @RequestBody Student student){
        return ResponseEntity.ok(student);
    }

}
