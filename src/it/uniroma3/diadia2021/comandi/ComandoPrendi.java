package it.uniroma3.diadia2021.comandi;

import it.uniroma3.diadia2021.IO;
import it.uniroma3.diadia2021.Partita;
import it.uniroma3.diadia2021.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {

	private IO io;
	private String attrezzo;
	private String prendi;
	
	
	@Override
	public void esegui(Partita partita) {
		if(attrezzo == null) {
			this.io.mostraMessaggio("che cosa vuoi prendere?");
		}
		else {
			if(!partita.getLabirinto().getStanzaCorrente().hasAttrezzo(attrezzo)) {
				this.io.mostraMessaggio("quello che stai cercando non c'è qui");
				return;
			}
			Attrezzo a = partita.getLabirinto().getStanzaCorrente().getAttrezzo(attrezzo);
			partita.getPlayer().getSatchel().addAttrezzo(a);
			partita.getLabirinto().getStanzaCorrente().removeAttrezzo(a);
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
		return this.prendi;
	}

	@Override
	public String getParametro() {
		return this.attrezzo;
	}

}
