package it.uniroma3.diadia2021.comandi;

import it.uniroma3.diadia2021.IO;

public interface FabbricaDiComandi {

	public Comando costruisciComando(String istruzione, IO io);
}
