package it.uniroma3.diadia2021;

import it.uniroma3.diadia2021.ambienti.Labirinto;
import it.uniroma3.diadia2021.ambienti.Stanza;
import it.uniroma3.diadia2021.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private boolean finita;
	private Labirinto labirinto;
	public Giocatore player;
	
	
	public Partita(){
		this.labirinto = new Labirinto();
		this.finita = false;
		this.player = new Giocatore();
	}

	public Labirinto getLabirinto() {
		return labirinto;
	}
   

	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getLabirinto().getStanzaCorrente()== this.getLabirinto().getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.player.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}


	public Giocatore getPlayer() {
		return this.player;
	}

	public void setPlayer(Giocatore player) {
		this.player = player;
	}

		
}
