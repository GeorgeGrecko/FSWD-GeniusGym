package ch.zhaw.sml.iwi.meng.geniusgym.boundary;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import ch.zhaw.sml.iwi.meng.geniusgym.entity.User;
import ch.zhaw.sml.iwi.meng.geniusgym.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@CrossOrigin
public class UserEndpoint {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/api/me", produces = "application/json")
    @PreAuthorize("hasRole('USER')")
    public String me(Principal principal) {
        return "{\"user\": \"" + principal.getName() + "\"} ";
    }

    @GetMapping(path = "/api/user")
    @PreAuthorize("hasRole('USER')")
    public List<User> getUsers(Principal principal) {
        return userRepository.findAll();
    }

}