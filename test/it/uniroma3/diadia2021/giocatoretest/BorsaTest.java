package it.uniroma3.diadia2021.giocatoretest;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia2021.attrezzi.Attrezzo;
import it.uniroma3.diadia2021.giocatore.Borsa;

public class BorsaTest {

	private static final String ATTREZZO  = "attrezzotest";
	private Borsa borsa;
	
	@Before
	public void setUp() {
		this.borsa = new Borsa();
	}

	@Test
	public void testBorsaVuota() {
		assertNull(this.borsa.getAttrezzo(ATTREZZO));
	}

	@Test
	public void testAddAttrezzoSingolo() {
		Attrezzo attrezzo = new Attrezzo(ATTREZZO, 2);
		this.borsa.addAttrezzo(attrezzo);
		assertEquals(attrezzo, this.borsa.getAttrezzo(ATTREZZO));
	}
	
}
