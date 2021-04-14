package it.uniroma3.diadia2021test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia2021.Partita;
import it.uniroma3.diadia2021.ambienti.Stanza;

public class PartitaTest {

	private Partita partita;


	@Before
	public void setUp() {
		this.partita = new Partita();
	}

	@Test
	public void testPartitaVinta() {
		this.partita.getLabirinto().setStanzaCorrente(this.partita.getLabirinto().getStanzaVincente());
		assertTrue(this.partita.vinta());
	}
	
	@Test
	public void testPartitaNonVinta() {
		this.partita.getLabirinto().setStanzaCorrente(new Stanza("inutile"));
		assertFalse(this.partita.vinta());
		
	}

	@Test
	public void testPartitaFinita() {
		this.partita.getLabirinto().setStanzaCorrente(this.partita.getLabirinto().getStanzaVincente());
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	public void testPartitaFinitaPercfu() {
		this.partita.getPlayer().setCfu(0);
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	public void testPartitaFinitaForzata() {
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());	
	}
}








