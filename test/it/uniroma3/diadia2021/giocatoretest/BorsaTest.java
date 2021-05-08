package it.uniroma3.diadia2021.giocatoretest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia2021.attrezzi.Attrezzo;
import it.uniroma3.diadia2021.giocatore.Borsa;

public class BorsaTest {

	private static final String ATTREZZO  = "attrezzotest";
	private Borsa borsa;
	private String PIOMBO = "piombo";
	private String LIBRO = "libro";
	private String SPADA = "spada";
	private static final int PESO_MAX = 20;
	
	@Before
	public void setUp() {
		this.borsa = new Borsa(PESO_MAX);
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
	
	@Test
	public void testAttrezzoTroppoPesante() {
		Attrezzo pesante = new Attrezzo("pesante", PESO_MAX+1);
		assertFalse(this.borsa.addAttrezzo(pesante));
	}
	
	@Test
	public void testGetAttrezzoBorsaVuota() {
		assertNull(this.borsa.getAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testGetPesoMax() {
		assertEquals(PESO_MAX, this.borsa.getPesoMax());
	}
	
	@Test
	public void testGetPesoIniziale0() {
		assertEquals(0, this.borsa.getPeso());
	}
	
	@Test
	public void testBorsaVuotaIniziale() {
		assertTrue(this.borsa.isEmpty());
	}
	
	@Test
	public void testRemoveAttrezzo() {
		Attrezzo singolo = new Attrezzo(ATTREZZO, 2);
		this.borsa.addAttrezzo(singolo);
		assertEquals(singolo, this.borsa.getAttrezzo(ATTREZZO));
		this.borsa.removeAttrezzo(ATTREZZO);
		assertTrue(this.borsa.isEmpty());
		assertEquals(0, this.borsa.getPeso());
	}
 	
	@Test
	public void testGetContenutoOrdinatoPerPeso() {
		Attrezzo piombo = new Attrezzo(PIOMBO, 10);
		Attrezzo spada = new Attrezzo(SPADA, 7);
		Attrezzo libro = new Attrezzo(LIBRO, 2);
		this.borsa.addAttrezzo(piombo);
		this.borsa.addAttrezzo(libro);
		this.borsa.addAttrezzo(spada);
		assertEquals(libro, this.borsa.getContenutoOrdinatoPerPeso().get(0));
		assertEquals(spada, this.borsa.getContenutoOrdinatoPerPeso().get(1));
		
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNome() {
		Attrezzo piombo = new Attrezzo(PIOMBO, 10);
		Attrezzo spada = new Attrezzo(SPADA, 7);
		Attrezzo libro = new Attrezzo(LIBRO, 3);
		this.borsa.addAttrezzo(spada);
		this.borsa.addAttrezzo(libro);
		this.borsa.addAttrezzo(piombo);
		assertEquals(libro, this.borsa.getContenutoOrdinatoPerNome().first());
		assertEquals(spada, this.borsa.getContenutoOrdinatoPerNome().last());
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPeso() {
		Attrezzo piombo = new Attrezzo(PIOMBO, 10);
		Attrezzo spada = new Attrezzo(SPADA, 5);
		Attrezzo libro = new Attrezzo(LIBRO, 5);
		this.borsa.addAttrezzo(piombo);
		this.borsa.addAttrezzo(spada);
		this.borsa.addAttrezzo(libro);
		Map<Integer, Set<Attrezzo>> mappa = new HashMap<Integer, Set<Attrezzo>>();
		mappa.put(5, Collections.singleton(libro));
		mappa.put(5, Collections.singleton(spada));
		mappa.put(10, Collections.singleton(piombo));
		assertEquals(mappa, this.borsa.getContenutoRaggruppatoPerPeso());
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPeso() {
		Attrezzo piombo = new Attrezzo(PIOMBO, 10);
		Attrezzo spada = new Attrezzo(SPADA, 7);
		Attrezzo libro = new Attrezzo(LIBRO, 3);
		this.borsa.addAttrezzo(piombo);
		this.borsa.addAttrezzo(spada);
		this.borsa.addAttrezzo(libro);
		assertEquals(libro, this.borsa.getSortedSetOrdinatoPerPeso().first());
		assertEquals(piombo, this.borsa.getSortedSetOrdinatoPerPeso().last());
	}
	
}
