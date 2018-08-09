package bdd;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.Utilisateur;

class UtilisateurBDDTest {

	@Test
	void testGetListUsers() {
		UtilisateurBDD testList = new UtilisateurBDD();
		
		ArrayList<Utilisateur> list = testList.getListUsers();
		
		System.out.println("list user");
		if(list == null) {
			fail("Liste vide");
		}else {
			System.out.println(list.get(0).toString());
		}
		System.out.println();
	}
	
	@Test
	void testGetListNewUsers() {
		UtilisateurBDD testList = new UtilisateurBDD();
		
		ArrayList<Utilisateur> list = testList.getListNewUsers();
		
		System.out.println("list new user");
		if(list == null) {
			fail("Liste vide");
		}else {
			System.out.println(list.get(0).toString());
		}
		System.out.println();
	}

}
