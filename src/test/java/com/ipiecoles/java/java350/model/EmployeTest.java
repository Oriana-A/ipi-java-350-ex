package com.ipiecoles.java.java350.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

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
}