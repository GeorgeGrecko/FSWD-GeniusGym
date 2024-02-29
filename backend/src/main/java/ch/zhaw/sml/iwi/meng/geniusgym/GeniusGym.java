package ch.zhaw.sml.iwi.meng.geniusgym;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ch.zhaw.sml.iwi.meng.geniusgym.entity.Role;
import ch.zhaw.sml.iwi.meng.geniusgym.entity.User;
import ch.zhaw.sml.iwi.meng.geniusgym.repositories.RoleRepository;
import ch.zhaw.sml.iwi.meng.geniusgym.repositories.UserRepository;

@SpringBootApplication
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class GeniusGym implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(GeniusGym.class, args);
        
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

   
    // Methode wird beim Start der Anwendung asugeführt - Ein neuer User mit Benutzername und PW wird erstellt
    @Override
    public void run(String... args) throws Exception {
        User u = new User();
        u.setLoginName("user");
        u.setPasswordHash(new BCryptPasswordEncoder().encode("user"));
        Role r = new Role();
        r.setRoleName("ROLE_USER");
        roleRepository.save(r);
        u.getRoles().add(r);
        userRepository.save(u);
    }
}
