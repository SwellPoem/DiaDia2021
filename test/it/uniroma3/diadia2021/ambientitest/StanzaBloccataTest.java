package it.uniroma3.diadia2021.ambientitest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia2021.ambienti.Stanza;
import it.uniroma3.diadia2021.ambienti.StanzaBloccata;
import it.uniroma3.diadia2021.attrezzi.Attrezzo;

public class StanzaBloccataTest {

	Stanza stanzaCorrente;
	Stanza stanzaNonBloccata;
	StanzaBloccata stanzaBloccata;
	Attrezzo attrezzoSbloccante;
	Attrezzo attrezzoNonSbloccante;
	String direzioneBloccata = new String("direzioneBloccata");
	String direzioneNonBloccata = new String("direzioneNonBloccata");

	@Before
	public void setUp() throws Exception {
		stanzaCorrente = new Stanza("stanzaCorrente");
		stanzaNonBloccata = new Stanza("stanzaNonBloccata");
		stanzaBloccata = new StanzaBloccata("stanzaBloccata", "direzioneBloccata", "attrezzoSbloccante");
		attrezzoSbloccante = new Attrezzo("attrezzoSbloccante", 1);
		attrezzoNonSbloccante = new Attrezzo("attrezzoNonSbloccante", 1);
	}
	
	//test di una stanza non bloccata con stanza null adiacente  nella direzione bloccata
	@Test
	public void testStanzaNull() {
		stanzaCorrente.impostaStanzaAdiacente(direzioneBloccata, null);
		assertNull(stanzaCorrente.getStanzaAdiacente("direzioneBloccata"));
	}
	@Test
	public void testStanzaBloccataOggettoSbloccante() {
		stanzaCorrente.impostaStanzaAdiacente("direzioneBloccata", stanzaBloccata);
		stanzaCorrente.addAttrezzo(attrezzoSbloccante);
		assertEquals(stanzaBloccata, stanzaCorrente.getStanzaAdiacente("direzioneBloccata"));
	}
	
	@Test
	public void testStanzaBloccataAdiacenteOggettoNonSbloccante() {
		stanzaCorrente.impostaStanzaAdiacente("direzioneBloccata", stanzaBloccata);
		stanzaCorrente.addAttrezzo(attrezzoNonSbloccante);
		assertEquals(stanzaBloccata, stanzaCorrente.getStanzaAdiacente("direzioneBloccata"));
	}

	@Test
	public void testDirezioneNonBloccata() {
		stanzaCorrente.impostaStanzaAdiacente("direzioneNonBloccata",stanzaNonBloccata);
		assertEquals(stanzaNonBloccata, stanzaCorrente.getStanzaAdiacente("direzioneNonBloccata"));	
	}

	@Test
	public void testGetDescrizioneStanzaNonBloccata() {
		stanzaCorrente.impostaStanzaAdiacente("direzioneNonBloccata", stanzaNonBloccata);
		assertEquals(stanzaNonBloccata.toString(), stanzaCorrente.getStanzaAdiacente("direzioneNonBloccata").getDescrizione());
	}
	
}
