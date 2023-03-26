package packages.name.application_name.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @Column(name = "author")
    private String author;
    @Column(name = "pages")
    private Integer pages;
    @Column(name = "part")
    private Integer part;
    @Column(name = "parts")
    private Integer parts;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
}
