package ch.zhaw.sml.iwi.meng.geniusgym.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ch.zhaw.sml.iwi.meng.geniusgym.entity.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo,Long> {
    public List<ToDo> findByOwner(String owner);
   
    @Query("SELECT t FROM ToDo as t WHERE t.owner = ?1 AND t.archived = false")
    public List<ToDo> findAllButArchivedByOwner(String owner);
    
}