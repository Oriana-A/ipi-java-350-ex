# Specification Heading

This is an executable specification file. This file follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.

To execute this specification, run
	gauge run specs


* Vowels in English language are "aeiou".

## Calcul de la performance d'un commercial avec CA>Objectif
Tags : performanceCommercial
* Soit un commercial avec le matricule C2613, un CA de 2000€, un obectif de 1500€ et une performance actuelle de 2. La performance moyenne est de 2.5
* Lorsque je calcule sa performance
* J'obtiens une performance de "7"

##Calcul de la performance d'un commercial avec CA<Objectif
Tags : performanceCmmercial
* Soit un commercial avec le matricule C350, un CA de 3000€, un objectif de 2400€ et une performance de 2. La performance moyenne est de 2
* Lorsque sa performance est calculée
* J'obtiens une performance de "1"


##Calcul de la performance d'un commercial sans CA indiqué
Tags : performanceCmmercial
* Soit un commercial vec le matricule C3615, un CA non renseigné, un objectif de 4250€ et avec une performance actuelle de 1. La performance moyenne est de 3.25
* Lorsque je calcule sa performance
* J'obtiens un message d'erreur "Le chiffre d'affaire traité ne peut être négatif ou null !"


