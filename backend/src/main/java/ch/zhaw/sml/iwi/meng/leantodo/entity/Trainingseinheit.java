package ch.zhaw.sml.iwi.meng.leantodo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Trainingseinheit {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer erfolgsquote;
    private String name;

    // private boolean archived = false;
    private boolean done = false;

    @JsonIgnore
    private String owner;
}