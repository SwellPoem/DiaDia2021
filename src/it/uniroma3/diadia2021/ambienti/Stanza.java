package it.uniroma3.diadia2021.ambienti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import it.uniroma3.diadia2021.attrezzi.Attrezzo;


public class Stanza {

	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	static final public int NUMERO_MASSIMO_ATTREZZI = 10;

	protected String nome;
	protected List<Attrezzo> attrezzi;
	protected Map<String, Stanza> stanzeAdiacenti;


	
	public Stanza(String nome) {
		this.nome = nome;
		this.stanzeAdiacenti = new HashMap<>();
		this.attrezzi = new ArrayList<>();
	}

	
	public void impostaStanzaAdiacente(String direzione, Stanza stanzaAdiacente) {
		if(this.stanzeAdiacenti.size()>= NUMERO_MASSIMO_DIREZIONI)
			return;
		this.stanzeAdiacenti.put(direzione, stanzaAdiacente);
	}

	
	public Stanza getStanzaAdiacente(String direzione) {
		return this.stanzeAdiacenti.get(direzione);
	}

	
	public String getNome() {
		return this.nome;
	}

	
	public String getDescrizione() {
		return this.toString();
	}

	
	public List<Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}

	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(this.attrezzi.size() == NUMERO_MASSIMO_ATTREZZI)
			return false;
		this.attrezzi.add(attrezzo);
		return true;
	}

	
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		risultato.append("\nUscite: ");
		risultato.append(this.stanzeAdiacenti.keySet().toString());
		risultato.append("\nAttrezzi nella stanza: ");
		risultato.append(attrezzi.toString()+" ");
		return risultato.toString();
	}


	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!= null;
	}

	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzo = null;
		Iterator<Attrezzo> it = this.attrezzi.iterator();
		while(it.hasNext()) {
			attrezzo = it.next();
			if(attrezzo.getNome().equals(nomeAttrezzo)) {
				return attrezzo;
			}
		}
		return null;
	}

	
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		Attrezzo a = null;
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		while(iteratore.hasNext()) {
			a = iteratore.next();
			if(a.equals(attrezzo)) {
				iteratore.remove();
				return true;
			}
		}
		return false;
	}    


	public Map<String, Stanza> getDirezioni() {
		return this.stanzeAdiacenti;
	}

}