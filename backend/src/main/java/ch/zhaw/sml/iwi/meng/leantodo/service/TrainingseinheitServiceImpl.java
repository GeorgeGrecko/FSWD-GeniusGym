package ch.zhaw.sml.iwi.meng.leantodo.service;

import ch.zhaw.sml.iwi.meng.leantodo.entity.Trainingseinheit;
import ch.zhaw.sml.iwi.meng.leantodo.repositories.TrainingseinheitRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TrainingseinheitServiceImpl implements TrainingseinheitService {

    @Autowired
    private TrainingseinheitRepository trainingseinheitRepository;

    @Override
    public Trainingseinheit addTrainingseinheit(Trainingseinheit trainingseinheit) {
        // Punkte setzen
        trainingseinheit.setPunkte(berechnePunkteFuerUebung(trainingseinheit));
        return trainingseinheitRepository.save(trainingseinheit);
    }

    // Implementierung zur Punkteberechnung
    private Integer berechnePunkteFuerUebung(Trainingseinheit trainingseinheit) {
        //  Logik, um die Punkte zu berechnen
        return 10; 
    }

    @Override
    public Trainingseinheit getTrainingseinheitById(Long id) {
        @SuppressWarnings("null")
        Optional<Trainingseinheit> trainingseinheit = trainingseinheitRepository.findById(id);
        return trainingseinheit.orElse(null);
    }

    @Override
    public List<Trainingseinheit> getAllTrainingseinheiten() {
        return trainingseinheitRepository.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public void deleteTrainingseinheit(Long id) {
        trainingseinheitRepository.deleteById(id);
    }

    @SuppressWarnings("null")
    @Override
    public Trainingseinheit updateTrainingseinheit(Trainingseinheit trainingseinheit) {
        if (trainingseinheit.getId() != null && trainingseinheitRepository.existsById(trainingseinheit.getId())) {
            return trainingseinheitRepository.save(trainingseinheit);
        }
        return null;
    }

    @Override
    public Integer saveGesamtpunktzahl(Integer gesamtpunktzahl) {
        return gesamtpunktzahl;
    }

    @Override
    public Integer getGesamtpunktzahl() {
        return 0; 
    }
}