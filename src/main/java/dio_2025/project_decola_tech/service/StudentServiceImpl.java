package dio_2025.project_decola_tech.service;

import dio_2025.project_decola_tech.domain.Student;
import dio_2025.project_decola_tech.repository.StudentRepository;
import dio_2025.project_decola_tech.service.implementation.StudentService;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.NoSuchElementException;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public Student findById(Long id){
        return studentRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student create(Student studentToCreate){
        if(studentRepository.existsByRegistrationNumber(studentToCreate.getRegistration().getNumber())){
            throw new IllegalArgumentException("O estudante com esse Id já existe");
        }
        return studentRepository.save(studentToCreate);
    }

    @Override
    public Student update(Long id, Student studentToUpdate) {
        Student existingStudent = findById(id);
        existingStudent.setName(studentToUpdate.getName());
        existingStudent.setRegistration(studentToUpdate.getRegistration());
        return studentRepository.save(existingStudent);
    }

    @Override
    public void delete(Long id) {
        Student student = findById(id);
        studentRepository.delete(student);
    }





}


