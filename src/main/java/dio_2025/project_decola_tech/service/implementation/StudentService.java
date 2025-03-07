package dio_2025.project_decola_tech.service.implementation;

import java.util.List;
import dio_2025.project_decola_tech.domain.Student;

public interface StudentService {

    Student findById(Long id);

    Student create(Student studentToCreate);

}
