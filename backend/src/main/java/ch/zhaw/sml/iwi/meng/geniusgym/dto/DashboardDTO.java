package ch.zhaw.sml.iwi.meng.geniusgym.dto;

import java.time.Duration;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class DashboardDTO {

    private final int levelanzeige;
    private final Duration mappergebnis;
    private final Double coordLatStart;
    private final Double coordLongStart;
    private final Double coordLatEnd;
    private final Double coordLongEnd;
    private final int uebungsergebnis;

    // Parametrisierter Konstruktor
    public DashboardDTO(int levelanzeige, Duration mappergebnis, double coordLatStart, double coordLongStart , double coordLatEnd, double coordLongEnd, int uebungsergebnis) {
        this.levelanzeige = levelanzeige;
        this.mappergebnis = mappergebnis;
        this.coordLatStart = coordLatStart;
        this.coordLongStart = coordLongStart;
        this.coordLatEnd = coordLatEnd;
        this.coordLongEnd = coordLongEnd;
        this.uebungsergebnis = uebungsergebnis;
    }
}
