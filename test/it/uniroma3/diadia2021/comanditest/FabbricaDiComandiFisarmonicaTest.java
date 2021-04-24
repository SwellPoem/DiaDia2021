package it.uniroma3.diadia2021.comanditest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia2021.IO;
import it.uniroma3.diadia2021.IOConsole;
import it.uniroma3.diadia2021.comandi.Comando;
import it.uniroma3.diadia2021.comandi.FabbricaDiComandiFisarmonica;

public class FabbricaDiComandiFisarmonicaTest {
	   
    private FabbricaDiComandiFisarmonica fisarmonica;
    private IO io;
   
    @Before
    public void setUp() {
        this.fisarmonica = new FabbricaDiComandiFisarmonica();
        this.io = new IOConsole();
    }
   
    @Test
    public void testComandoAiuto() {
        Comando aiuto = this.fisarmonica.costruisciComando("aiuto", io);
        assertEquals("aiuto",aiuto.getNome());
    }
   
    @Test
    public void testComandoFine() {
        Comando fine = this.fisarmonica.costruisciComando("fine", io);
        assertEquals("fine",fine.getNome());
    }
   
    @Test
    public void testComandoGuarda() {
        Comando guarda = this.fisarmonica.costruisciComando("guarda", io);
        assertEquals("guarda",guarda.getNome());
    }
   
    @Test
    public void testComandoVai() {
        Comando vai = this.fisarmonica.costruisciComando("vai nord", io);
        assertEquals("vai",vai.getNome());
        assertEquals("nord",vai.getParametro());
    }
   
    @Test
    public void testComandoPrendi() {
        Comando prendi = this.fisarmonica.costruisciComando("prendi lanterna", io);
        assertEquals("prendi",prendi.getNome());
        assertEquals("lanterna",prendi.getParametro());
    }
   
    @Test
    public void testComandoPosa() {
        Comando posa = this.fisarmonica.costruisciComando("posa lanterna", io);
        assertEquals("posa",posa.getNome());
        assertEquals("lanterna",posa.getParametro());
    }
}

