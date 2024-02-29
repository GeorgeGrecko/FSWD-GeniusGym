package ch.zhaw.sml.iwi.meng.geniusgym.boundary;

import ch.zhaw.sml.iwi.meng.geniusgym.entity.Trainingseinheit;
import ch.zhaw.sml.iwi.meng.geniusgym.service.TrainingseinheitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TrainingseinheitEndpoint {

    @Autowired
    private TrainingseinheitService trainingseinheitService;

    // Übung hinzufügen
    @PostMapping("/trainingseinheit")
    public String addTrainingseinheit(@RequestBody Trainingseinheit trainingseinheit) {
        trainingseinheitService.addTrainingseinheit(trainingseinheit);
        return "Exercise successfully added.";
    }

    // Übung nach ID abrufen
    @GetMapping("/trainingseinheit/{id}")
    public Trainingseinheit getTrainingseinheitById(@PathVariable("id") Long id) {
        return trainingseinheitService.getTrainingseinheitById(id);
    }

    // Alle Übungen abrufen
    @GetMapping("/trainingseinheit")
    public List<Trainingseinheit> getAllTrainingseinheiten() {
        return trainingseinheitService.getAllTrainingseinheiten();
    }

    // Übung aktualisieren
    @PutMapping("/trainingseinheit/{id}")
    public Trainingseinheit updateTrainingseinheit(@PathVariable("id") Long id, @RequestBody Trainingseinheit trainingseinheit) {
        trainingseinheit.setId(id);
        return trainingseinheitService.updateTrainingseinheit(trainingseinheit);
    }

    // Übung nach ID löschen
    @DeleteMapping("/trainingseinheit/{id}")
    public String deleteTrainingseinheit(@PathVariable("id") Long id) {
        trainingseinheitService.deleteTrainingseinheit(id);
        return "Exercise deleted.";
    }

    // Gesamtpunktzahl speichern
    @PostMapping("/gesamtpunktzahl")
    public ResponseEntity<?> saveGesamtpunktzahl(@RequestBody Integer gesamtpunktzahl) {
        // Speichern der Gesamtpunktzahl ohne Benutzerbezug
        Integer gespeichertePunktzahl = trainingseinheitService.saveGesamtpunktzahl(gesamtpunktzahl);
        return ResponseEntity.ok(gespeichertePunktzahl);
    }

    // Gesamtpunktzahl abrufen
    @GetMapping("/gesamtpunktzahl")
    public ResponseEntity<?> getGesamtpunktzahl() {
        // Abrufen der Gesamtpunktzahl ohne Benutzerbezug
        Integer punktzahl = trainingseinheitService.getGesamtpunktzahl();
        return ResponseEntity.ok(punktzahl);
    }

}
