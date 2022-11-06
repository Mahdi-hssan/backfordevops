package com.esprit.examen;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.repositories.CategorieProduitRepository;
import com.esprit.examen.services.CategorieProduitServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CategorieProduitServiceImplTest {
	@Autowired
	CategorieProduitServiceImpl catServ;
	
	@Autowired
	CategorieProduitRepository catRepo;
	
	@Test
	public void testAddCategorieCategorieProduit(){
		CategorieProduit pr=new CategorieProduit("code", "libelle"); 
		CategorieProduit p = catServ.addCategorieProduit(pr);
		assertNotNull(p.getIdCategorieProduit());
		assertTrue(p.getCodeCategorie().length() > 0);
		catServ.deleteCategorieProduit(p.getIdCategorieProduit());
	}

	@Test
	public void testRetrieveAllCategorieProduits() {
				
		List<CategorieProduit> produits = catServ.retrieveAllCategorieProduits();
		int expected = produits.size();
		CategorieProduit pr=new CategorieProduit("code", "libelle"); 
		CategorieProduit p = catServ.addCategorieProduit(pr);
		assertEquals(expected + 1, catServ.retrieveAllCategorieProduits().size());
		catServ.deleteCategorieProduit(p.getIdCategorieProduit());;
	}
	
	@Test
	public void testDeleteCategorieProduit() {
		CategorieProduit pr=new CategorieProduit("code", "libelle"); 
		CategorieProduit p = catServ.addCategorieProduit(pr);
		catServ.deleteCategorieProduit(p.getIdCategorieProduit());
		assertNull(catServ.retrieveCategorieProduit(p.getIdCategorieProduit()));
	};
	

	@Test
	public void testRetrieveCategorieProduit()
	{
		CategorieProduit pr=new CategorieProduit("code", "libelle"); 
		CategorieProduit p = catServ.addCategorieProduit(pr);
		CategorieProduit produit = catServ.retrieveCategorieProduit(p.getIdCategorieProduit());
		assertEquals(p.getIdCategorieProduit().longValue(),produit.getIdCategorieProduit().longValue());
		
	}
	
	
	@Test
	public void testUpdateCategorieProduit()
	{
		CategorieProduit pr=new CategorieProduit("code", "libelle"); 
		CategorieProduit p1 = catServ.addCategorieProduit(pr);
		CategorieProduit p = catServ.retrieveCategorieProduit(p1.getIdCategorieProduit());
		p.setCodeCategorie("test");
		p.setLibelleCategorie("tst");
		CategorieProduit updatedCategorieProduit=catServ.updateCategorieProduit(p);
		assertEquals(p.getLibelleCategorie(),updatedCategorieProduit.getLibelleCategorie());
	}

}
