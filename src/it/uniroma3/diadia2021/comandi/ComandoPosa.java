package it.uniroma3.diadia2021.comandi;

import it.uniroma3.diadia2021.IOConsole;
import it.uniroma3.diadia2021.Partita;
import it.uniroma3.diadia2021.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {

	private IOConsole io;
	private String attrezzo;

	@Override
	public void esegui(Partita partita) {
		if(attrezzo == null) {
			this.io.mostraMessaggio("che cosa vuoi poosare?");
		}
		else {


			if(!partita.getPlayer().getSatchel().hasAttrezzo(attrezzo)) {
				this.io.mostraMessaggio("non hai questo attrezzo nell'inventario");
				return;
			}
			Attrezzo a = partita.getPlayer().getSatchel().removeAttrezzo(attrezzo);
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(a);
			this.io.mostraMessaggio("attrezzo posato");
			this.io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
			this.io.mostraMessaggio("Peso della borsa: " + partita.getPlayer().getSatchel().getPeso() + "kg");
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.attrezzo = parametro;

	}

}
