package dio_2025.project_decola_tech.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "tb_news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String icon;
    private String description;

    public Long getId(){ return id; }
    public void setId(Long id) { this.id = id; }

    private String getIcon() { return icon; }
    private void setIcon(String icon) { this.icon = icon;}

    private String getDescription() { return description; }
    private void setDescription(String description) { this.description = description;}
}
