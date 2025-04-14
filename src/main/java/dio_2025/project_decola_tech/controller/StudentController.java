package dio_2025.project_decola_tech.controller;

import dio_2025.project_decola_tech.domain.Student;
import dio_2025.project_decola_tech.service.implementation.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.util.List;

import java.net.URI;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @Operation(summary = "Get a user by ID")
    @GetMapping("{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id){
        var student = studentService.findById(id);
        return ResponseEntity.ok(student);
    }

    @Operation(summary = "Get all students")
    @GetMapping
    public ResponseEntity<List<Student>> findAll() {
        var students = studentService.findAll();
        return ResponseEntity.ok(students);
    }

    @Operation(summary = "Create a new student")
    @PostMapping
    public ResponseEntity<Student> create (@RequestBody Student studentToCreate){
        var studentCreated = studentService.create(studentToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(studentCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(studentCreated);
    }

    @Operation(summary = "Update an existing student")
    @PutMapping("/{id}")
    public ResponseEntity<Student> update (@PathVariable Long id, @RequestBody Student studentToUpdate){
            var updatedStudent = studentService.update(id, studentToUpdate);
            return ResponseEntity.ok(updatedStudent);
    }

    @Operation(summary = "Delete a student by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
            studentService.delete(id);
            return ResponseEntity.noContent().build();
    }
}