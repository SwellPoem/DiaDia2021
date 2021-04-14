package it.uniroma3.diadia2021.comandi;

import java.util.Scanner;

public class FabbricaDiComadiFisarmonica implements FabbricaDiComandi {

	@Override
	public Comando costruisciComando(String istruzione) {
		@SuppressWarnings("resource")
		Scanner scannerDiProle = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		Comando comando = null;
		
		if(scannerDiProle.hasNext())
			nomeComando = scannerDiProle.next();
		if(scannerDiProle.hasNext())
			parametro = scannerDiProle.next();
		
		if(nomeComando == null)
			comando = new ComandoNonValido();
		else if(nomeComando.equals("vai"))
			comando = new ComandoVai();
		else if(nomeComando.equals("aiuto"))
			comando = new ComandoAiuto();
		else if(nomeComando.equals("fine"))
			comando = new ComandoFine();
		else if(nomeComando.equals("prendi"))
			comando = new ComandoPrendi();
		else if(nomeComando.equals("posa"))
			comando = new ComandoPosa();
		else if(nomeComando.equals("guarda"))
			comando = new ComandoGuarda();
		else comando = new ComandoNonValido();
		comando.setParametro(parametro);
		return comando;
	}
}
