package ch.zhaw.sml.iwi.meng.geniusgym.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter

// Benutzerdaten kapseln und übertragen
public class StatusDTO {
   
    private String name;
    private Integer groesse;
    private Integer gewicht;

    public StatusDTO(String name, Integer groesse, Integer gewicht) {
        this.name = name;
        this.groesse = groesse;
        this.gewicht = gewicht;
    } 
}
