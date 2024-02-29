package ch.zhaw.sml.iwi.meng.geniusgym.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ch.zhaw.sml.iwi.meng.geniusgym.dto.StatusDTO;
import ch.zhaw.sml.iwi.meng.geniusgym.repositories.StatusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@CrossOrigin // Erlaubt CORS-Anfragen von allen Quellen
@Component
public class StatusController {


    @Autowired
    private StatusRepository statusRepository;

    // Status anhand von ID finden
    @SuppressWarnings("null")
    @GetMapping("/{id}")
    public ResponseEntity<StatusDTO> getStatus(@PathVariable Long id) {
        return statusRepository.findById(id) // Verwenden Sie die injizierte Instanz, nicht den Klassennamen
            .map(status -> new StatusDTO(status.getName(), status.getGroesse(), status.getGewicht()))
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    
}
