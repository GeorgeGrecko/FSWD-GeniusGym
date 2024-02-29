package ch.zhaw.sml.iwi.meng.geniusgym.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.zhaw.sml.iwi.meng.geniusgym.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>
{
    public List<Project> findByOwner(String owner);
}