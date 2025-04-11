package dio_2025.project_decola_tech.repository;

import dio_2025.project_decola_tech.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

  boolean existsByRegistrationNumber(String number);
}
