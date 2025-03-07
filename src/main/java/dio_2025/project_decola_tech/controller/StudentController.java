package dio_2025.project_decola_tech.controller;

import dio_2025.project_decola_tech.domain.Student;
import dio_2025.project_decola_tech.service.implementation.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id){
        var student = studentService.findById(id);
        return ResponseEntity.ok(student);
    }

    @PostMapping("{id}")
    public ResponseEntity<Student> create(@RequestBody Student studentToCreate) {
        var studentCreated = studentService.create(studentToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(studentCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(studentCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student studentToUpdate) {
        var updatedStudent = studentService.update(id, studentToUpdate);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }

}



