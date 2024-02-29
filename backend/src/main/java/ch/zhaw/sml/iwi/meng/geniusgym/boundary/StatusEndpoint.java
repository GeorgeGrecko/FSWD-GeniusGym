package ch.zhaw.sml.iwi.meng.geniusgym.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ch.zhaw.sml.iwi.meng.geniusgym.entity.Status;
import ch.zhaw.sml.iwi.meng.geniusgym.repositories.StatusRepository;
import ch.zhaw.sml.iwi.meng.geniusgym.entity.Level;

@RestController
@RequestMapping("/api/status")
@CrossOrigin
public class StatusEndpoint {

    @Autowired
    private StatusRepository statusRepository;

    // Speichert Status-Objekt - zuerst wird Level von Bneutzers berechnet
    @PostMapping
    public Status saveOrUpdateStatus(@RequestBody Status status) {
        if (status.getPunkte() != null) {
            // Verwenden der calculateLevel Methode des Enums zur Bestimmung des Levels
            status.setLevel(Level.calculateLevel(status.getPunkte()));
        }
        return statusRepository.save(status);
    }
    
    // Status-Objekt nach ID aufrufen
    @SuppressWarnings("null")
    @GetMapping("/{id}")
    public Status getStatus(@PathVariable Long id) {
        return statusRepository.findById(id).orElse(null);
    }
}
