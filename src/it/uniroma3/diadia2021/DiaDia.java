package it.uniroma3.diadia2021;


import it.uniroma3.diadia2021.ambienti.Labirinto;
import it.uniroma3.diadia2021.ambienti.LabirintoBuilder;
import it.uniroma3.diadia2021.comandi.Comando;
import it.uniroma3.diadia2021.comandi.FabbricaDiComandiFisarmonica;
import it.uniroma3.diadia2021.comandi.FabbricaDiComandi;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 */

public class DiaDia {

	public static final String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";


	private Partita partita;
	private IO io;

	public DiaDia(Labirinto labirinto, IO io) {
		this.partita = new Partita(labirinto);
		this.io = io;
	}

	public void gioca() {
		String istruzione; 

		this.io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do		
			istruzione = this.io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica();
		comandoDaEseguire = factory.costruisciComando(istruzione, this.io);
		comandoDaEseguire.esegui(this.partita);
		if(this.partita.vinta())
			this.io.mostraMessaggio("hai vinto!");
		if(this.partita.getPlayer().getCfu() == 0)
			this.io.mostraMessaggio("hai finito i CFU!");
		return this.partita.isFinita();
	} 
	
	public static void main(String[] argc) {
		IO io = new IOConsole();
		Labirinto labirinto = new LabirintoBuilder()
				//add delle stanze
				.addStanzaIniziale("atrio").addAttrezzo("osso", 1)
				.addStanzaVincente("biblioteca")
				.addStanza("mensa").addAttrezzo("lanterna", 3)
				.addStanzaBuia("aula N11", "lanterna").addAttrezzo("grimaldello", 1)
				.addStanzaMagica("laboratorio").addAttrezzo("spada", 3)
				.addStanzaBloccata("aula N10", "grimaldello", "est")
				//add delle adiacenze
				//atrio
				.addAdiacente("atrio", "mensa", "nord")
				.addAdiacente("atrio", "aula N10", "sud")
				.addAdiacente("atrio", "aula N11", "est")
				.addAdiacente("atrio", "laboratorio", "ovest")
				//aula n10
				.addAdiacente("aula N10", "atrio", "nord")
				.addAdiacente("aula N10", "aula N11", "sud")
				.addAdiacente("aula N10", "biblioteca", "est")
				//aula n11
				.addAdiacente("aula N11", "aula N10", "nord")
				.addAdiacente("aula N11", "atrio", "ovest")
				.addAdiacente("aula N11", "laboratorio", "est")
				//laboratorio
				.addAdiacente("laboratorio", "aula N11", "ovest")
				.addAdiacente("laboratorio", "atrio", "est")
				//mensa
				.addAdiacente("mensa", "atrio", "sud")
				//biblioteca (essendo la stanza vincente una volta entrati in biblioteca finisce il gioco
				//quindi non servirebbe mettere l'adiacenza da biblioteca ad altre stanze
//				.addAdiacente("biblioteca", "atrio", "sud")
//				.addAdiacente("biblioteca", "laboratorio", "nord")
				//getLabirinto
				.getLabirinto();
		
		DiaDia gioco = new DiaDia(labirinto, io);
		gioco.gioca();
	}

}