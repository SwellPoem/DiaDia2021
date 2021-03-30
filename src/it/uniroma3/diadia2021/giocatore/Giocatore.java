package it.uniroma3.diadia2021.giocatore;

public class Giocatore {

	static final public int CFU_INIZIALI = 20;
	public int cfu;
	private Borsa satchel;
	
	public Giocatore() {
		this.satchel = new Borsa();
		this.cfu = CFU_INIZIALI;
	}
	
	public int getCfu() {
		return this.cfu;
	}
	
	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}

	public Borsa getSatchel() {
		return this.satchel;
	}
}
