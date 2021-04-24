package it.uniroma3.diadia2021.comanditest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia2021.DiaDia;
import it.uniroma3.diadia2021.IOConsole;
import it.uniroma3.diadia2021.Partita;
import it.uniroma3.diadia2021.ambienti.Stanza;
import it.uniroma3.diadia2021.comandi.Comando;
import it.uniroma3.diadia2021.comandi.ComandoFine;
import it.uniroma3.diadia2021.comandi.ComandoVai;
import it.uniroma3.diadia2021.fixture.Fixture;
import it.uniroma3.diadia2021test.IOSimulator;

public class ComandoVaiTest {
	
	private static final String PARTENZA = "partenza";
	private static final String DIREZIONE = "nord";
	private Comando comandoVai;
	private Partita partita;
	private Stanza stanzaDiPartenza;

	@Before
	public void setUp() throws Exception {
		this.comandoVai = new ComandoVai();
		this.comandoVai.setIO(new IOConsole());
		this.partita = new Partita();
		this.stanzaDiPartenza = new Stanza(PARTENZA);
		this.partita.getLabirinto().setStanzaCorrente(stanzaDiPartenza);
	}

	@Test
	public void testEseguiStanzaNonPresente() {
		this.comandoVai.setParametro(DIREZIONE);
		this.comandoVai.esegui(partita);
		assertEquals(PARTENZA, this.partita.getLabirinto().getStanzaCorrente().getNome());
	}

	@Test
	public void testEseguiStanzaPresente() {
		Stanza destinazione = new Stanza("destinazione");
		this.stanzaDiPartenza.impostaStanzaAdiacente(DIREZIONE, destinazione);
		this.comandoVai.setParametro(DIREZIONE);
		this.comandoVai.esegui(partita);
		assertEquals("destinazione", this.partita.getLabirinto().getStanzaCorrente().getNome());
	}
	
	@Test
	public void testPartitaComandoVai() {
		String[] comandiDaEseguire = {"vai sud", "fine"};
		IOSimulator io = Fixture.creaSimulazionePartitaEGioca(comandiDaEseguire);
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertContains("sei in: Aula N10", io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals("ciao", io.nextMessaggio());
	}
	
	public void assertContains(String expected, String interaRiga) {
		assertTrue(interaRiga.contains(expected));
	}
}
