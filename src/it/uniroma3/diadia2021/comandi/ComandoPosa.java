package it.uniroma3.diadia2021.comandi;

import it.uniroma3.diadia2021.IO;
import it.uniroma3.diadia2021.Partita;
import it.uniroma3.diadia2021.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {

	private IO io;
	private String attrezzo;
	private final String POSA = "posa";

	@Override
	public void esegui(Partita partita) {
		if(attrezzo == null) {
			this.io.mostraMessaggio("che cosa vuoi poosare?");
		}
		else { 
			
			if(!partita.getPlayer().getSatchel().hasAttrezzo(attrezzo)) {
				this.io.mostraMessaggio("non hai questo attrezzo nell'inventario");
			}
			else {
				Attrezzo attrezzoAppoggio = partita.getPlayer().getSatchel().getAttrezzo(attrezzo);
                partita.getLabirinto().getStanzaIniziale().addAttrezzo(attrezzoAppoggio);
                partita.getPlayer().getSatchel().removeAttrezzo(attrezzo);
				this.io.mostraMessaggio("attrezzo posato");
			}
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
		return this.POSA;
	}

	@Override
	public String getParametro() {
		return this.attrezzo;
	}

}
