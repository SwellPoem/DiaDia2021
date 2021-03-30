package it.uniroma3.diadia;


import java.util.Scanner;

import it.uniroma3.diadia2021.ambienti.Labirinto;
import it.uniroma3.diadia2021.ambienti.Stanza;
import it.uniroma3.diadia2021.attrezzi.Attrezzo;
import it.uniroma3.diadia2021.comandi.Comando;
import it.uniroma3.diadia2021.giocatore.Giocatore;

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
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine"};

	private Partita partita;

	public DiaDia() {
		this.partita = new Partita();
	}

	@SuppressWarnings("resource")
	public void gioca() {
		String istruzione; 
		Scanner scannerDiLinee;

		System.out.println(MESSAGGIO_BENVENUTO);
		scannerDiLinee = new Scanner(System.in);		
		do		
			istruzione = scannerDiLinee.nextLine();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		
		if(comandoDaEseguire.getNome()!=null) {
			
		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else
			System.out.println("Comando sconosciuto");
		if (this.partita.vinta()) {
			System.out.println("Hai vinto!");
			return true;
		} else
			return false;
	}
		else
			System.out.println("non hai inserito nulla");
		return false;
	}

	private void posa(String attrezzo) {
		if(attrezzo == null) {
			System.out.println("che cosa vuoi poosare?");
		}
		if(!this.partita.getPlayer().getSatchel().hasAttrezzo(attrezzo)) {
			System.out.println("non hai questo attrezzo nell'inventario");
			return;
		}
		Attrezzo a = this.partita.getPlayer().getSatchel().removeAttrezzo(attrezzo);
		this.partita.getLabirinto().getStanzaCorrente().addAttrezzo(a);
		System.out.println("attrezzo posato");
	}

	private void prendi(String attrezzo) {
		if(attrezzo == null) {
			System.out.println("che cosa vuoi prendere?");
		}
		if(!this.partita.getLabirinto().getStanzaCorrente().hasAttrezzo(attrezzo)) {
			System.out.println("quello che stai cercando non c'� qui");
			return;
		}
		Attrezzo a = this.partita.getLabirinto().getStanzaCorrente().getAttrezzo(attrezzo);
		this.partita.getPlayer().getSatchel().addAttrezzo(a);
		this.partita.getLabirinto().getStanzaCorrente().removeAttrezzo(a);
		System.out.println("attrezzo preso");
	}


	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		System.out.println();
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			System.out.println("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			System.out.println("Direzione inesistente");
		else {
			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getPlayer().getCfu();
			this.partita.getPlayer().setCfu(--cfu);
		}
		System.out.println(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		System.out.println("CFU rimasti: " +this.partita.getPlayer().getCfu());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		System.out.println("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}