package it.uniroma3.diadia2021.fixture;

import java.util.List;

import it.uniroma3.diadia2021.DiaDia;
import it.uniroma3.diadia2021.ambienti.Labirinto;
import it.uniroma3.diadia2021.ambienti.LabirintoBuilder;
import it.uniroma3.diadia2021.ambienti.Stanza;
import it.uniroma3.diadia2021.attrezzi.Attrezzo;
import it.uniroma3.diadia2021test.IOSimulator;

public class Fixture {

	public static IOSimulator creaSimulazionePartitaEGioca(List<String> righeDaLeggere) {
		IOSimulator io = new IOSimulator(righeDaLeggere);
		Labirinto labirinto = new LabirintoBuilder()
				//add delle stanze
				.addStanzaIniziale("atrio").addAttrezzo("osso", 1)
				.addStanzaVincente("biblioteca")
				.addStanza("aula N10").addAttrezzo("lanterna", 3)
				.addStanzaBuia("aula N11", "lanterna").addAttrezzo("grimaldello", 1)
				.addStanzaMagica("laboratorio").addAttrezzo("spada", 3)
				//add delle adiacenze
				.addAdiacente("atrio", "biblioteca", "nord")
				.addAdiacente("atrio", "aula N10", "sud")
				.addAdiacente("atrio", "aula N11", "est")
				.addAdiacente("atrio", "laboratorio", "ovest")
				.addAdiacente("aula N10", "atrio", "nord")
				.addAdiacente("aula N10", "aula N11", "est")
				.addAdiacente("aula N11", "aula N10", "ovest")
				.addAdiacente("aula N11", "laboratorio", "est")
				.addAdiacente("laboratorio", "aula N11", "ovest")
				.addAdiacente("laboratorio", "atrio", "est")
				.addAdiacente("biblioteca", "atrio", "sud")
				//add delle particolarità
				.addStanzaBloccata("atrio", "grimaldello", "ovest")
				//getLabirinto
				.getLabirinto();
		
		new DiaDia(labirinto, io).gioca();
		return io;
	}
	
	public static Attrezzo creaAttrezzoEAggiungiStanza(Stanza stanzaDaRiempire, String nomeAttrezzo, int peso) {
		Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
		stanzaDaRiempire.addAttrezzo(attrezzo);
		return attrezzo;
	}
}
