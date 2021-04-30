package it.uniroma3.diadia2021.ambientitest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia2021.ambienti.Stanza;
import it.uniroma3.diadia2021.ambienti.StanzaBuia;
import it.uniroma3.diadia2021.attrezzi.Attrezzo;

public class StanzaBuiaTest {

	StanzaBuia stanzaBuia;
	Stanza stanzaNonBuia;
	Attrezzo oggettoChiave;
	Attrezzo attrezzoNonChiave;

	@Before
	public void setUp() throws Exception {
		stanzaBuia = new StanzaBuia("stanzaBuia", "oggettoChiave");
		stanzaNonBuia = new Stanza("stanzaNonBuia");
		oggettoChiave = new Attrezzo("oggettoChiave", 1);
		attrezzoNonChiave = new Attrezzo("attrezzoNonChiave", 2);

	}

	@Test
	public void testStanzaBuia() {
		assertEquals("qui è tutto buio", stanzaBuia.getDescrizione());
	}

	@Test
	public void testStanzaBuiaNonPiuBuia() {
		stanzaBuia.addAttrezzo(oggettoChiave);
		assertNotEquals("qui è tutto buio", stanzaBuia.getDescrizione());
	}

	@Test
	public void testStanzaBuiaDopoAverRimossoOggettoChiave() {
		stanzaBuia.removeAttrezzo(oggettoChiave);
		assertEquals("qui è tutto buio", stanzaBuia.getDescrizione());
	}

	@Test
	public void testStanzaBuiaConOggettoNonChiave() {
		stanzaBuia.addAttrezzo(attrezzoNonChiave);
		assertEquals("qui è tutto buio", stanzaBuia.getDescrizione());
	}

}
