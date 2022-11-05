package com.esprit.examen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Facture;
import com.esprit.examen.repositories.FactureRepository;
import com.esprit.examen.services.FactureServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FactureServiceImplTest {

	FactureRepository factureRepo = Mockito.mock(FactureRepository.class);
	
	@InjectMocks
	private FactureServiceImpl factureService;
	
	private Facture f = Facture.builder().montantRemise(8).montantFacture(125).dateCreationFacture(new Date()).archivee(false).build();
	
	private List<Facture> list = new ArrayList<Facture>() {
		{
			
		add(Facture.builder().montantRemise(8).montantFacture(125).dateCreationFacture(new Date()).archivee(true).build());
		add(Facture.builder().montantRemise(8).montantFacture(125).dateCreationFacture(new Date()).archivee(false).build());
		}
	};
	
	@Test
	public void retrieveFactureTest() {
		Mockito.when(factureRepo.findById(f.getIdFacture())).thenReturn(Optional.of(f));
		assertEquals(f, factureService.retrieveFacture(f.getIdFacture()));		
	}
	
	@Test
	public void retrieveAllFacturesTest() {
		Mockito.when(factureRepo.findAll()).thenReturn(list);
		assertEquals(2, factureService.retrieveAllFactures().size());
	}
	
	@Test
	public void addFactureTest() {
		Mockito.when(factureRepo.save(f)).thenReturn(f);
		assertNotNull(f);
		Facture factPersistee = factureService.addFacture(f);
		assertEquals(f, factPersistee);
	}
	
}
