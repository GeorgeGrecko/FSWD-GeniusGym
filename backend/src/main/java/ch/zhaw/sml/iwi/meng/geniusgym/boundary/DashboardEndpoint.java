package ch.zhaw.sml.iwi.meng.geniusgym.boundary;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.sml.iwi.meng.geniusgym.controller.DashboardController;
import ch.zhaw.sml.iwi.meng.geniusgym.dto.DashboardDTO;

@RestController
@CrossOrigin
public class DashboardEndpoint {

    @Autowired
    private DashboardController dashboardController;

    @GetMapping("/dashboard")
    public DashboardDTO fetchDashboard(Principal principal) {
        return dashboardController.createDashBoard(principal.getName());
    }

    /*
    @PostMapping("/dashboards")
    @ResponseStatus(HttpStatus.CREATED)
    public DashboardDTO createDashboard(@RequestBody @NonNull DashboardDTO dashboard) {
        return dashboardRepository.save(dashboard);
    }

    @DeleteMapping("/dashboards/{id}")
    public ResponseEntity<Void> deleteDashboard(@PathVariable @NonNull Long id) {
        if (dashboardRepository.existsById(id)) {
            dashboardRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    */
}
