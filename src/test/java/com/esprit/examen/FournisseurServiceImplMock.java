/*
 * package com.esprit.examen;
 * 
 * import static org.assertj.core.api.Assertions.assertThat; import static
 * org.junit.jupiter.api.Assertions.assertEquals; import static
 * org.junit.jupiter.api.Assertions.assertNotNull; import static
 * org.mockito.ArgumentMatchers.any; import static
 * org.mockito.ArgumentMatchers.anyLong; import static
 * org.mockito.BDDMockito.given; import static org.mockito.Mockito.doNothing;
 * import static org.mockito.Mockito.times; import static
 * org.mockito.Mockito.verify; import static org.mockito.Mockito.when;
 * 
 * import java.util.ArrayList; import java.util.List; import java.util.Optional;
 * 
 * import org.junit.jupiter.api.Test; //import org.junit.Test; import
 * org.junit.jupiter.api.extension.ExtendWith; import
 * org.mockito.ArgumentMatchers; import org.mockito.InjectMocks; import
 * org.mockito.Mock; import org.mockito.Mockito; import
 * org.mockito.junit.jupiter.MockitoExtension; import
 * org.springframework.boot.test.context.SpringBootTest;
 * 
 * import com.esprit.examen.entities.DetailFournisseur; import
 * com.esprit.examen.entities.Fournisseur; import
 * com.esprit.examen.repositories.DetailFournisseurRepository; import
 * com.esprit.examen.repositories.FournisseurRepository; import
 * com.esprit.examen.services.FournisseurServiceImpl;
 * 
 * @SpringBootTest
 * 
 * @ExtendWith(MockitoExtension.class) public class FournisseurServiceImplMock {
 * 
 * @Mock FournisseurRepository fp ;
 * 
 * @Mock DetailFournisseurRepository dfR ;
 * 
 * @InjectMocks FournisseurServiceImpl fournisseurService;
 * 
 * Fournisseur f = new Fournisseur("CodeFournisseur","LibelleFournisseur");
 * DetailFournisseur df = new DetailFournisseur("matr","addr");
 * 
 * List<Fournisseur> list = new ArrayList<Fournisseur> () { { add(new
 * Fournisseur("CodeFournisseur","LibelleFournisseur")); add(new
 * Fournisseur("CodeFournisseur","LibelleFournisseur"));
 * 
 * } };
 * 
 * @Test public void testRetrieveAllFournisseurs() {
 * Mockito.when(fp.findAll()).thenReturn(list); assertEquals(list.size(),
 * fournisseurService.retrieveAllFournisseurs().size()); }
 * 
 * 
 * @Test public void testAddFournisseur() {
 * Mockito.when(fp.save(any(Fournisseur.class))).thenReturn(f); Fournisseur f1 =
 * fournisseurService.addFournisseur(f); assertNotNull(f1);
 * 
 * }
 * 
 * @Test public void testRetrieveFournisseur() {
 * 
 * Mockito.when(fp.findById(Mockito.anyLong())).thenReturn(Optional.of(f) );
 * Fournisseur f = fournisseurService.retrieveFournisseur(2L); assertNotNull(f);
 * 
 * }
 * 
 * @Test public void testSaveDetailFournisseur() { DetailFournisseur dt =new
 * DetailFournisseur("adresse","matricule");
 * Mockito.when(fp.save(any(Fournisseur.class))).thenReturn(f);
 * Mockito.when(dfR.save(any(DetailFournisseur.class))).thenReturn(df);
 * f.setDetailFournisseur(df); Fournisseur fourn = fp.save(f); DetailFournisseur
 * dfs = fournisseurService.saveDetailFournisseur(fourn); assertNotNull(dfs);
 * assertNotNull(f); }
 * 
 * @Test public void testUpdateFournisseur() { DetailFournisseur df = new
 * DetailFournisseur("matricule","addresse");
 * System.out.println("++++++++++++++++++++++++"+f);
 * Mockito.when(fp.save(any(Fournisseur.class))).thenReturn(f);
 * Mockito.when(dfR.save(any(DetailFournisseur.class))).thenReturn(df);
 * f.setLibelle("LibelleUpdated"); f.setCode("CodeUpdated");
 * f.setDetailFournisseur(df); System.out.println("++++++++++++++++++++++++"+f);
 * Fournisseur fUpdated = fournisseurService.updateFournisseur(f);
 * assertNotNull(fUpdated); assertEquals(f.getLibelle(),fUpdated.getLibelle());
 * 
 * }
 * 
 * @Test public void testDeleteFournisseur() { f.setIdFournisseur(1L);
 * doNothing().when(fp).deleteById(Mockito.anyLong());
 * fournisseurService.deleteFournisseur(1L);
 * verify(fp,times(1)).deleteById(f.getIdFournisseur()); }
 * 
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 */