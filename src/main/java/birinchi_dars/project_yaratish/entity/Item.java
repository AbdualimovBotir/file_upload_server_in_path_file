package birinchi_dars.project_yaratish.entity;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name")
    private String name;

}
