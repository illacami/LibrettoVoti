package it.polito.tdp.librettovoti.model;
import java.time.*;

public class Voto {
	
	private String nomeCorso;
	private int voto;
	private LocalDate data;
	
	
	public Voto(String nomeCorso, int voto, LocalDate data) {
		super();
		this.nomeCorso = nomeCorso;
		this.voto = voto;
		this.data = data;
	}


	public String getNomeCorso() {
		return nomeCorso;
	}


	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}


	public int getVoto() {
		return voto;
	}


	public void setVoto(int voto) {
		this.voto = voto;
	}


	public LocalDate getData() {
		return data;
	}


	public void setData(LocalDate data) {
		this.data = data;
	}


	@Override
	public String toString() {
		return "Esame " + nomeCorso + " superato con " + voto + " il " + data;
	}

	public Voto migliora() {
		
		Voto nuovo = new Voto(nomeCorso, voto, data);
		
		if((this.voto < 24 && this.voto > 17) || this.voto == 29)
			nuovo.setVoto(this.voto + 1);
		
		else if(this.voto > 24 && this.voto < 29)
			nuovo.setVoto(this.voto + 2);
	
		return nuovo;
	}
	
}
