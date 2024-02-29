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
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer groesse; // in cm
    private Integer gewicht; // in kg
    private String name;
    private Integer punkte; // Punktestand
    private Level level; // Berechnetes Feld, nicht direkt gespeichert

    @Temporal(TemporalType.DATE)
    private Date datum;

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
    
}