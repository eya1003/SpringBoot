package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.entity.Professeur;
import tn.esprit.spring.repositories.DepartementRepository;
import tn.esprit.spring.repositories.ProfesseurRepository;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProfesseurServiceImp implements IProfesseurService {

    @Autowired
    ProfesseurRepository professeurRepository;
    @Autowired
    DepartementRepository departementRepository;
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public Long ajouter_professeur(Professeur p) {
        professeurRepository.save(p);
        log.info("Ajouter Professeur");
        sendSimpleEmail(p.getEmailProf());
        return p.getIdProfesseur();
    }

    @Override
    public Iterable<Professeur> getAllProfesseurs() {
        return professeurRepository.findAll();
    }

    @Override
    public Professeur updateProfesseur(Professeur professeur) {
        return professeurRepository.save(professeur);
    }

    @Override
    public void deleteProfesseur(long id) {
        professeurRepository.deleteById(id);
    }


    public Optional<Professeur> findProfesseurById(Long id) {
        return professeurRepository.findById(id);
    }

    @Override
    public float calculSalaire(float prixHeure, Long id) {
        float s = 0;
        return s = prixHeure * getnbHeureById(id);
    }

    public int getnbHeureById(Long id) {

        return professeurRepository.findById(id).get().getNbrheure();
    }
/*
    public LocalDate getCurrentTimeUsingCalendar() {
        LocalDate date = LocalDate.now();
        System.out.println("Current Date: " + date);
        return date;
    }

    public float CalculSalaireWithDate(float prixHeure, Long id)
    {

        Date dateDebut = professeurRepository.findById(id).get().getAnneeAmb();
        LocalDate Today = getCurrentTimeUsingCalendar();
        float a = dateDebut.getMonth();
        int monthes = Months
       // b=  Today.getMonth();
        float s =0;
        return  s= a*prixHeure;

    }

 */

    public void sendSimpleEmail(String to) {

        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(to);
        message.setSubject("Bienvenue ");
        message.setText("Bonjour Mr/M  A notre universite ");

        // Send Message!
        this.javaMailSender.send(message);

    }


    @Override
    public void assignProfesseurToDepartement(Long ProfID, Long departeId) {

        Professeur professeur = professeurRepository.findById(ProfID).orElse(null);
        Departement departement = departementRepository.findById(departeId).orElse(null);
        professeur.setDepartementsProf(departement);
        professeurRepository.save(professeur);
    }

    @Override
    public Professeur addProfesseurandAffectDepartement(Professeur p, Long departeId) {
        Departement pro = departementRepository.findById(departeId).orElse(null);
        p.setDepartementsProf(pro);
        professeurRepository.save(p);
        return professeurRepository.save(p);
    }

    public List<Professeur> search(String keyword) {
        if (keyword != null) {
            return professeurRepository.search(keyword);
        }
        return professeurRepository.findAll();
    }
}