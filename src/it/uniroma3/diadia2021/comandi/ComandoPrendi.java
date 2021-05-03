package it.uniroma3.diadia2021.comandi;

import it.uniroma3.diadia2021.IO;
import it.uniroma3.diadia2021.Partita;
import it.uniroma3.diadia2021.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {

	private IO io;
	private String attrezzo;
	private final String PRENDI = "prendi";
	
	
	@Override
	public void esegui(Partita partita) {
		if(attrezzo == null) {
			this.io.mostraMessaggio("che cosa vuoi prendere?");
		}
		else {
			if(!partita.getLabirinto().getStanzaIniziale().hasAttrezzo(attrezzo)) {
				this.io.mostraMessaggio("quello che stai cercando non c'è qui");
				return;
			}
			Attrezzo a = partita.getLabirinto().getStanzaIniziale().getAttrezzo(attrezzo);
			partita.getPlayer().getSatchel().addAttrezzo(a);
			partita.getLabirinto().getStanzaIniziale().removeAttrezzo(a);
			this.io.mostraMessaggio("attrezzo preso");
			this.io.mostraMessaggio("Peso della borsa: " + partita.getPlayer().getSatchel().getPeso() + "kg");
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.attrezzo = parametro;

	}

	@Override
	public void setIO(IO io) {
		this.io = io;
	}

	@Override
	public String getNome() {
		return this.PRENDI;
	}

	@Override
	public String getParametro() {
		return this.attrezzo;
	}

}
