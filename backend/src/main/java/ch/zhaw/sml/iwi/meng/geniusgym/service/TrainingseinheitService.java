package ch.zhaw.sml.iwi.meng.geniusgym.service;

import ch.zhaw.sml.iwi.meng.geniusgym.entity.Trainingseinheit;
import org.springframework.stereotype.Service;

import java.util.List;

// Interface, das Operationen mit Trainingseinheiten handhabt
// dient als Abstraktionsebene
@Service
public interface TrainingseinheitService {
    Trainingseinheit addTrainingseinheit(Trainingseinheit trainingseinheit);

    Trainingseinheit getTrainingseinheitById(Long id);

    List<Trainingseinheit> getAllTrainingseinheiten();

    void deleteTrainingseinheit(Long id);

    Trainingseinheit updateTrainingseinheit(Trainingseinheit trainingseinheit);

    Integer saveGesamtpunktzahl(Integer gesamtpunktzahl);

    Integer getGesamtpunktzahl();
}
