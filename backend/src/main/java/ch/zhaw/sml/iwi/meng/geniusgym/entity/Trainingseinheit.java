package ch.zhaw.sml.iwi.meng.geniusgym.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class Trainingseinheit {
    
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer erfolgsquote;
    private String name;
    private boolean done = false;

    @Temporal(TemporalType.DATE)
    private Date durchfuhrungsdatum;

    private String typ;
    private String beschreibung;
    private Integer dauer; // Dauer in Minuten
    private Integer punkte; // Punkte für die Übung

}