package dio_2025.project_decola_tech.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "tb_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Registration registration;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Course> course;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<News> news;


    public Long getId(){ return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name;}

    public Registration getRegistration() { return registration; }
    public void setRegistration(Registration registration) { this.registration = registration; }

    public List<Course> getCourse() { return course; }
    public void setCourse(List<Course> course) { this.course = course; }

    public List<News> getNews() { return news; }
    public void setNews(List<News> news) { this.news = news; }
}
