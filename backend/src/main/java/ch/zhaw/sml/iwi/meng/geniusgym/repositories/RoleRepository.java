package ch.zhaw.sml.iwi.meng.geniusgym.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.zhaw.sml.iwi.meng.geniusgym.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,String>{

    
}