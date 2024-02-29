package ch.zhaw.sml.iwi.meng.geniusgym.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate; // oder LocalDateTime für Datum und Uhrzeit
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor 
@RequiredArgsConstructor
@Entity
@Data
public class Map {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String origin;
    @NonNull
    private String destination;
    @NonNull
    private String distance;
    @NonNull
    private String duration;
    @NonNull
    private LocalDate created;
}
