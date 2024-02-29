package ch.zhaw.sml.iwi.meng.geniusgym.controller;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.zhaw.sml.iwi.meng.geniusgym.dto.DashboardDTO;
import ch.zhaw.sml.iwi.meng.geniusgym.repositories.UserRepository;

@Component
public class DashboardController {

    
    @Autowired
    private UserRepository userRepository;
    

    public DashboardDTO createDashBoard(String loginName) {
        

        /* ToDo: Calculate ashboard information from user object */

        DashboardDTO dto = new DashboardDTO(1,Duration.ofMinutes(45), 47.481, 8.544, 47.477, 8.524, 10);

        return dto;
    }

}
