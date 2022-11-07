package com.esprit.examen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
//@ExtendWith(MockitoExtension.class)
public class FactureServiceImplTest {

	FactureRepository factureRepo = Mockito.mock(FactureRepository.class);
	
	@InjectMocks
	FactureServiceImpl factureService;
	
	private Facture f1 = new Facture(8L, 125L, new Date(), false);
	private Facture f2 = new Facture(4L, 265L, new Date(), true);
	
	/*private List<Facture> list = new ArrayList<Facture>() {
		{
			
		add(Facture.builder().montantRemise(8).montantFacture(125).dateCreationFacture(new Date()).archivee(true).build());
		add(Facture.builder().montantRemise(8).montantFacture(125).dateCreationFacture(new Date()).archivee(false).build());
		}
	};*/
	
	@Test
	public void addFactureTest() {
		when(factureRepo.save(f2)).thenReturn(f2);
		assertNotNull(f2);
		Facture factPersistee = factureService.addFacture(f2);
		assertEquals(f2, factPersistee);
	}
	
	@Test
	public void retrieveFactureTest() {
		when(factureRepo.findById(f2.getIdFacture())).thenReturn(Optional.of(f2));
		assertEquals(f2, factureService.retrieveFacture(f2.getIdFacture()));		
	}
	
	@Test
	public void retrieveAllFacturesTest() {
		when(factureRepo.findAll()).thenReturn(Stream.of(f1, f2).collect(Collectors.toList()));
		assertEquals(2, factureService.retrieveAllFactures().size());
	}
	

	
}
