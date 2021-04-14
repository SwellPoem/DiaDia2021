package it.uniroma3.diadia2021.ambientitest;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia2021.ambienti.Labirinto;

public class LabirintoTest {

	private Labirinto labirinto;

	@Before
	public void setUp() {
		this.labirinto = new Labirinto();
	}

	@Test
	public void testGetStanzaCorrente() {
		assertNotNull(this.labirinto.getStanzaCorrente());
	}

	@Test
	public void testGetStanzaVincente() {
		assertNotNull(this.labirinto.getStanzaVincente());
	}
}
