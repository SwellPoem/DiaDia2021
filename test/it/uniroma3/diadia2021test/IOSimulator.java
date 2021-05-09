package it.uniroma3.diadia2021test;

import java.util.ArrayList;
import java.util.List;

import it.uniroma3.diadia2021.IO;

public class IOSimulator implements IO {
	
	private List<String> righeDaLeggere;
//	private String[] righeDaLeggere;
	private int indiceRigheDaLeggere;
	private List<String> messaggiProdotti;
//	private String[] messaggiProdotti;
	private int indiceMessaggiProdotti;
	private int indiceMessaggiMostrati;
	
	
	public IOSimulator(List<String> righeDaLeggere) {
		this.righeDaLeggere = righeDaLeggere;
		this.indiceRigheDaLeggere = 0;
		this.messaggiProdotti = new ArrayList<String>();
		this.indiceMessaggiProdotti = 0;
		this.indiceMessaggiMostrati = 0;
	}

	@Override
	public void mostraMessaggio(String msg) {
		this.messaggiProdotti.add(indiceMessaggiProdotti, msg);
		this.indiceMessaggiProdotti++;
	}

	@Override
	public String leggiRiga() {
		String rigaLetta = this.righeDaLeggere.get(this.indiceRigheDaLeggere);
		this.indiceRigheDaLeggere++;
		return rigaLetta;
	}
	
	public String nextMessaggio() {
		String next = this.messaggiProdotti.get(this.indiceMessaggiMostrati);
		this.indiceMessaggiMostrati++;
		return next;
	}
	
	public boolean hasNextMessaggio() {
		return this.indiceMessaggiMostrati < this.indiceMessaggiProdotti;
	}

}
