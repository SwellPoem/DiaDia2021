package it.uniroma3.diadia2021.ambienti;

public class StanzaBloccata extends Stanza {

	private String sbloccante;
	private String direzioneBloccata;

	public StanzaBloccata(String nome, String attrezzoSbloccante, String direzioneBloccata) {
		super(nome);
		this.sbloccante = attrezzoSbloccante;
		this.direzioneBloccata = direzioneBloccata;
		
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(this.direzioneBloccata.equals(direzione)) {
			if(!this.hasAttrezzo(sbloccante)) {
				System.out.println("la stanza ? bloccata");
				return this;
			} else {
				return super.getStanzaAdiacente(direzione);
			}
		}
		else {
			return super.getStanzaAdiacente(direzione);
			//			Stanza stanza = null;
			//			for(int i=0; i<this.numeroStanzeAdiacenti; i++)
			//				if (this.direzioni[i].equals(direzione))
			//					stanza = this.stanzeAdiacenti[i];
			//			return stanza;
		}
	}

	@Override
	public String getDescrizione() {
		if(!this.hasAttrezzo(sbloccante)) {
			StringBuilder s = new StringBuilder();
			s.append("questa stanza ha un'uscita bloccata... ");
			s.append("\n" + this.direzioneBloccata + " rester? bloccata se non hai " + this.sbloccante);
			return s.toString();
		}
		
		return this.toString();
	}
}
