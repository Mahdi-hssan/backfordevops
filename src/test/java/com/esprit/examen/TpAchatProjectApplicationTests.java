package com.esprit.examen;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Facture;
import com.esprit.examen.repositories.FactureRepository;
import com.esprit.examen.services.FactureServiceImpl;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class TpAchatProjectApplicationTests {

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
		Mockito.when(factureRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(f));
		Facture facture = factureService.retrieveFacture((long) 1);
		assertNotNull(facture);
		log.info("get =>" + facture.toString());
		
	}
}
