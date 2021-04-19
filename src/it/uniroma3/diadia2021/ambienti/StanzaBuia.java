package it.uniroma3.diadia2021.ambienti;

public class StanzaBuia extends Stanza {

	private String rgb;
	
	public StanzaBuia(String nome, String attrezzo) {
		super(nome);
		this.rgb = attrezzo;
		
	}
	
	@Override
	public String getDescrizione() {
		if(!this.hasAttrezzo(this.rgb)) {
			return "fai come emily";
		}
		else {
			return this.toString();
		}
	}

}
