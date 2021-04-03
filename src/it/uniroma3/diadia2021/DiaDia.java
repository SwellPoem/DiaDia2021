package it.uniroma3.diadia2021;


import it.uniroma3.diadia2021.ambienti.Stanza;
import it.uniroma3.diadia2021.attrezzi.Attrezzo;
import it.uniroma3.diadia2021.comandi.Comando;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	private Partita partita;
	private IOConsole io;

	public DiaDia(IOConsole io) {
		this.partita = new Partita();
		this.io = io;
	}

	public void gioca() {
		String istruzione; 

		this.io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do		
			istruzione = this.io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		if (comandoDaEseguire.getNome() == null) {
			this.io.mostraMessaggio("Inserisci un comando valido");
		}
		
		else if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} 

		else if (comandoDaEseguire.getNome().equals("vai")) {
			this.vai(comandoDaEseguire.getParametro());
		}

		else if (comandoDaEseguire.getNome().equals("aiuto")) {
			this.aiuto();
		}

		else if (comandoDaEseguire.getNome().equals("prendi")) {
			this.prendi(comandoDaEseguire.getParametro());
		}

		else if (comandoDaEseguire.getNome().equals("posa")) {
			this.posa(comandoDaEseguire.getParametro());
		}

		else
			this.io.mostraMessaggio("Comando sconosciuto");

		if (this.partita.isFinita()) {

			if (this.partita.getPlayer().getCfu()==0) {
				this.io.mostraMessaggio("Hai finito i CFU!");
			}

			else if (this.partita.vinta()) {
				this.io.mostraMessaggio("Hai vinto!");
			}
			return true;
		}
		else
			return false;
	}   

	private void posa(String attrezzo) {
		if(attrezzo == null) {
			this.io.mostraMessaggio("che cosa vuoi poosare?");
		}
		else {


			if(!this.partita.getPlayer().getSatchel().hasAttrezzo(attrezzo)) {
				this.io.mostraMessaggio("non hai questo attrezzo nell'inventario");
				return;
			}
			Attrezzo a = this.partita.getPlayer().getSatchel().removeAttrezzo(attrezzo);
			this.partita.getLabirinto().getStanzaCorrente().addAttrezzo(a);
			this.io.mostraMessaggio("attrezzo posato");
			this.io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
			this.io.mostraMessaggio("Peso della borsa: " + this.partita.getPlayer().getSatchel().getPeso() + "kg");
		}
	}

	private void prendi(String attrezzo) {
		if(attrezzo == null) {
			this.io.mostraMessaggio("che cosa vuoi prendere?");
		}
		else {
			if(!this.partita.getLabirinto().getStanzaCorrente().hasAttrezzo(attrezzo)) {
				this.io.mostraMessaggio("quello che stai cercando non c'è qui");
				return;
			}
			Attrezzo a = this.partita.getLabirinto().getStanzaCorrente().getAttrezzo(attrezzo);
			this.partita.getPlayer().getSatchel().addAttrezzo(a);
			this.partita.getLabirinto().getStanzaCorrente().removeAttrezzo(a);
			this.io.mostraMessaggio("attrezzo preso");
			this.io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
			this.io.mostraMessaggio("Peso della borsa: " + this.partita.getPlayer().getSatchel().getPeso() + "kg");
		}
	}

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			this.io.mostraMessaggio(elencoComandi[i]+" ");
		this.io.mostraMessaggio(" ");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			this.io.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			this.io.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getPlayer().getCfu();
			this.partita.getPlayer().setCfu(--cfu);
		}
		this.io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		this.io.mostraMessaggio("CFU rimasti: " +this.partita.getPlayer().getCfu());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		this.io.mostraMessaggio("ciao");  // si desidera smettere
	}

	public static void main(String[] argc) {
		IOConsole io = new IOConsole();
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
	}
}