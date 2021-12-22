package com.ipiecoles.java.java350.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.time.LocalDate;

class EmployeTest {

    @Test
    void getNombreAnneeAncienneteWithDateEmbaucheNow() {
        //Given
        Employe employe = new Employe("Agniel", "Oriana", "T123456", LocalDate.now(), 2500.0,1, 1.0);

        //When
        Integer nbAnnees = employe.getNombreAnneeAnciennete();

        //Then
        Assertions.assertThat(nbAnnees).isEqualTo(0);
    }

    @Test
    void getNombreAnneAncienneteWithDateEmbaucheInThePast(){
        //Given
        Employe employe = new Employe("Zero", "Toto", "T000000",LocalDate.now().minusYears(2),1550.50,2,1.2);
        //When
        Integer nbAnnees = employe.getNombreAnneeAnciennete();
        //Then
        Assertions.assertThat(nbAnnees).isEqualTo(2);
    }

    @Test
    void getNombreAnneeAncieneteWithDateEmbaucheInTheFuture(){
        //Given
        Employe employe = new Employe("D'Arc", "Jeanne", "N2000",LocalDate.now().plusYears(3),1550.50,2,1.2);
        //When
        Integer nbAnnees = employe.getNombreAnneeAnciennete();
        //Then
        Assertions.assertThat(nbAnnees).isEqualTo(0);
    }

    @Test
    void getNombreAnneeAncieneteWithDateNull(){
        //Given
        Employe employe = new Employe("D'Arc", "Jeanne", "N2000",null,1550.50,2,1.2);
        //When
        Integer nbAnnees = employe.getNombreAnneeAnciennete();
        //Then
        Assertions.assertThat(nbAnnees).isNull();
    }

    @ParameterizedTest(name = "Prime pour un employé de matricule {0}, ancienneté {1}, performance {2}, tempspartiel {3} : {4}")
    @CsvSource({
            "'T12346', 0,0,1.0, 300.0",
            "'T12346', 0,1,1.0, 1000.0",
            "'T12346', 0, ,1.0, 1000.0",
            "'T12346', 3,1, 1.0, 1300.0",
            "'T12346', 1,0, 1.0, 400.0",
            "'T12346', 1,0, 1.0, 400.0",
            "'T12346', 2,1, 0.5, 600.0",
            "'M12347', 0,1, 0.5, 850.0",
            "'M12347', 1,1, 0.5, 900.0",
            "'M12347', 0,1, 0.5, 850.0",
            "'M12347', 6,0, 1.0, 2300.0",
            "'M12347', 2,1, 1.0, 1900.0"
    })
    void getPrimeAnnuelle(String matricule, Integer nbAnneeAnciennete, Integer performance, Double tempsPartiel, Double primeCalculee) {
        //Given
        Employe employe = new Employe("Doe", "John", matricule, LocalDate.now().minusYears(nbAnneeAnciennete), Entreprise.SALAIRE_BASE, performance, tempsPartiel);

        //When
        Double prime = employe.getPrimeAnnuelle();

        //Then
        Assertions.assertThat(prime).isEqualTo(primeCalculee);
    }


    @ParameterizedTest(name = "Employé avec un salaire {0}, un pourcentage {1}, salaireAugmenté {2}")
    @CsvSource({
            "1550.50,2,1581.51",
            "0.0,30,0.0",
            "3000,-1.5,0.0",
            "-1200.0, 5,0.0"
    })
    void augmenterSalaire(Double salaire, Double pourcentage, Double salaireAugmente) {
        //Given
        Employe employe = new Employe("Doe", "John", "C3615", LocalDate.now().minusYears(3), salaire, 1, 1.2);

        //When
        Double salaireWithAugmentation = employe.augmenterSalaire(pourcentage);

        //Then
        Assertions.assertThat(salaireWithAugmentation).isEqualTo(salaireAugmente);
    }
}