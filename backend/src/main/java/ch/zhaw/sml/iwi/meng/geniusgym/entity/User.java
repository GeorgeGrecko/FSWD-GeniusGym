package ch.zhaw.sml.iwi.meng.geniusgym.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="USERTABLE")
public class User {

    @Id
    private String loginName;

    private String name;

    private Long level;

    private Long points;

    @JsonIgnore
    private String passwordHash;

    @ManyToMany
    private List<Role> roles = new ArrayList<>();

    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Status> history = new ArrayList<>();

    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Trainingseinheit> trainingseinheits = new ArrayList<>();

    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Map> maps = new ArrayList<>();

}