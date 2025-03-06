package dio_2025.project_decola_tech.domain;

import jakarta.persistence.*;

@Entity(name = "tb_registration")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (unique = true)
    private String number;

    @Column (unique = true)
    private String birth;

    @Column (unique = true)
    private String email;

    private String courseName;

    public Long getId(){ return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumber() { return number; }
    public void getNumber(String number) { this.number = number; }

    public String getBirth() { return birth; }
    public void getBirth(String birth) { this.birth = birth; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
}
