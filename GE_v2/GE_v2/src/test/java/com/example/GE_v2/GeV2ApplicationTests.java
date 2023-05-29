package com.example.GE_v2;

import com.example.GE_v2.models.matiere;
import com.example.GE_v2.models.professeur;
import com.example.GE_v2.repositories.IMatiereRepository;
import com.example.GE_v2.repositories.IProfesseurtRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class GeV2ApplicationTests {

	@Autowired
	IProfesseurtRepository professeurRepository;
	@Autowired
	IMatiereRepository matiereRepository;

	@Test
	public void testAddProfesseur(){
		matiere mathematiques = new matiere("Mathématiques");
		matiereRepository.save(mathematiques);

		// Création d'un professeur
		//Professeur(String nom, String prenom, String filiere, double salaire, Matiere matiere)
		professeur prof = new professeur("Doe", "John", "IIR", 5000.0,mathematiques);
		professeurRepository.save(prof);
	}
	/*
	@Test
	public void TestUpdateProfesseur(){
		professeur professeur=professeurRepository.findById(2L).get();
		professeur.setNom("Hajar");
		professeurRepository.save(professeur);
	}
 */
	@Test
	public void testFindProfesseurByMatiere() {
		List<professeur> professeurs = professeurRepository.findByMatiereNom("GL");
		for (professeur professeur : professeurs) {
			System.out.println("///////////////////////////////////////////////////////////"+professeur.toString());
		}
	}

	@Test
	public void TestFindAllProfesseur(){
		List<professeur> professeurs=professeurRepository.findAll();
		for(professeur p:professeurs){
			System.out.println("/////////////////////////////////////////////////////////////////////////////////////"+p);
		}
	}

	@Test
	public void TestDeleteById(){
		professeurRepository.deleteById(2L);
	}


















	// Test de MATIERE :
	@Test
	public void testAddMATIERE(){
		matiere matiere = new matiere("GL");
		matiereRepository.save(matiere);
		professeur prof4 = new professeur("Hajar1", "John", "IIR", 5000.0,matiere);
		professeur prof3 = new professeur("hajar2", "John", "IIR", 5000.0,matiere);
		professeurRepository.save(prof4);
		professeurRepository.save(prof3);

	}

	@Test
	public void testGetProfesseurs() {
		// Création d'une matière
		matiere matiere = new matiere("POO");
		// Création de 3 professeurs
		professeur prof1 = new professeur("Dupont", "Jean", "Mathématiques", 4000.0,matiere);

		// Ajout des professeurs à la liste associée à la matière
		List<professeur> professeurs = new ArrayList<>();
		professeurs.add(prof1);
		matiere.setProfesseurs(professeurs);

		// Enregistrement de la matière et des professeurs en base de données
		matiereRepository.save(matiere);
		professeurRepository.saveAll(professeurs);

		// Récupération de la matière à partir de l'ID enregistré en base de données
		matiere matiereBDD = matiereRepository.findById(matiere.getId()).get();
		System.out.println("Id de la matiere: " + matiereBDD.getId());
		System.out.println("Nom de la matiere: " + matiereBDD.getNom());

		// Vérification que la méthode getProfesseurs renvoie une liste de professeurs non vide
		List<professeur> professeursBDD = matiereBDD.getProfesseurs();
		List<professeur> professeurss = professeurRepository.findByMatiereNom(matiere.getNom());
		for (professeur prof : professeurss) {
			System.out.println("///////////////////////////////////////////////////////////"+prof.toString());
		}

	}

/*
	@Test
	public void TestUpdateMATIERE(){
		matiere matiere=matiereRepository.findById(3L).get();
		matiere.setNom("Spring Boot");
		matiereRepository.save(matiere);
	}
*/
	@Test
	public void TestFindMATIEREById(){
		matiere mat=matiereRepository.findById(3L).get();
		System.out.println("*************************************************"+mat.toString());
	}

	@Test
	public void TestFindAllMATIERE(){
		List<matiere> matieres=matiereRepository.findAll();
		for(matiere p:matieres){
			System.out.println("/////////////////////////////////////////////////////////////////////////////////////"+p.getNom());
		}
	}

	@Test
	public void TestDeleteMatiereById(){
		matiereRepository.deleteById(1L);
	}
}
