package it.uniroma3.diadia2021.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia2021.attrezzi.Attrezzo;

public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private List<Attrezzo> attrezzi;
	private int pesoMax;
	private int pesoBorsa;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<Attrezzo>(); 
		this.pesoBorsa = 0;
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		this.attrezzi.add(attrezzo);
		this.pesoBorsa += attrezzo.getPeso();
		return true;
	}

	public int getPesoMax() {
		return pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato = null;
		Iterator<Attrezzo> iterator = this.attrezzi.iterator();
		while(iterator.hasNext()) {
			attrezzoCercato = iterator.next();
			if(attrezzoCercato.getNome().equals(nomeAttrezzo)) {
				return attrezzoCercato;
			}
		}
		return null;
	}

	
	public int getPeso() {
		int pesoTotale = 0;
		for(Attrezzo a : this.attrezzi) {
			pesoTotale += a.getPeso();
		}
		return pesoTotale;
	}

	
	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}
	

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!= null;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		while(iteratore.hasNext()) {
			a = iteratore.next();
			if(a.getNome().equals(nomeAttrezzo)) {
				iteratore.remove();
				this.pesoBorsa = this.pesoBorsa - a.getPeso();
				return a;
			}
		}
		return null;
    }
	
	public String getContenuto() {
		return this.toString();
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append(""+this.getPeso()+"kg/"+this.getPesoMax()+"kg: ");
			s.append(this.attrezzi.toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
	
	
	/*restituisce la lista degli attrezzi nella borsa ordinati per peso e
	quindi, a parità di peso, per nome*/
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		List<Attrezzo> attrezzo2peso = new LinkedList<Attrezzo>(this.attrezzi);
		Collections.sort(attrezzo2peso, new ComparatoreAttrezziPerPeso());
		return attrezzo2peso;
	}
	

	/*restituisce l'insieme degli attrezzi nella borsa ordinati per nome*/
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
		return new TreeSet<Attrezzo>(this.attrezzi);
	}
	
	
	/*restituisce una mappa che associa un intero (rappresentante un
	peso) con l’insieme (comunque non vuoto) degli attrezzi di tale
	peso: tutti gli attrezzi dell'insieme che figura come valore hanno
	lo stesso peso pari all'intero che figura come chiave*/
	
	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
		final Map<Integer, Set<Attrezzo>> contenuto2attrezzi = new HashMap<Integer, Set<Attrezzo>>();
		for(Attrezzo attrezzo : this.attrezzi) {
			if(contenuto2attrezzi.containsKey(attrezzo.getPeso())) {
				Set<Attrezzo> tmp = null;
				tmp = contenuto2attrezzi.get(attrezzo.getPeso());
				tmp.add(attrezzo);
			}
			else {
				Set<Attrezzo> set = new HashSet<>();
				set.add(attrezzo);
				contenuto2attrezzi.put(attrezzo.getPeso(), set);
			}
		}
		return contenuto2attrezzi;
	}
	
	
	/*restituisce l'insieme gli attrezzi nella borsa
	ordinati per peso e quindi, a parità di peso, per
	nome*/
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {
		SortedSet<Attrezzo> attrezzos = new TreeSet<Attrezzo>(new ComparatoreAttrezziPerPeso());
		attrezzos.addAll(this.attrezzi);
		return attrezzos;
	}
}

