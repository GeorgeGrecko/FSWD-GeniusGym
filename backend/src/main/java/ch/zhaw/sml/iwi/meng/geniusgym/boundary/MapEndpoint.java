package ch.zhaw.sml.iwi.meng.geniusgym.boundary;

import java.time.LocalDate;
import java.util.List;
import org.springframework.lang.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ch.zhaw.sml.iwi.meng.geniusgym.entity.Map;
import ch.zhaw.sml.iwi.meng.geniusgym.repositories.MapRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@CrossOrigin
public class MapEndpoint {

    private static final Logger log = LoggerFactory.getLogger(MapEndpoint.class);

    @Autowired
    private MapRepository mapRepository;

    @GetMapping("/api/routes")
    public ResponseEntity<List<Map>> getAllMaps() {
        log.info("Abrufen aller Maps gestartet.");
        try {
            List<Map> maps = mapRepository.findAll();
            log.info("Abrufen aller Maps erfolgreich beendet.");
            return new ResponseEntity<>(maps, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Fehler beim Abrufen der Maps", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/api/route")
    public ResponseEntity<Map> saveMap(@RequestBody Map map) {
        map.setCreated(LocalDate.now());
        Map savedRoute = mapRepository.save(map);
        return new ResponseEntity<>(savedRoute, HttpStatus.CREATED);
    }

    @PostMapping("/api/maps")
    public ResponseEntity<Map> createMap(@RequestBody @NonNull Map newMap) {
        Map savedMap = mapRepository.save(newMap);
        return new ResponseEntity<>(savedMap, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMap(@PathVariable @NonNull Long id) {
        return mapRepository.findById(id)
                .map(map -> {
                    mapRepository.deleteById(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}