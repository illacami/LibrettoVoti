package it.polito.tdp.librettovoti.model;

import java.util.*;

public class Libretto {

	private List<Voto> voti;
	private Map<String, Voto> mappaVoti;
	
	private List<Voto> migliorato;
	private List<Voto> ordinato;
	private List<Voto> votiAlti;
	
	public Libretto() {
		this.voti = new ArrayList<>();
		this.mappaVoti = new HashMap<>();
	}
	
	
	public  void add(Voto n) {
	
		if(this.conflitto(n) || this.votoEsistente(n))
			return;
		
		this.voti.add(n);
		this.mappaVoti.put(n.getNomeCorso(), n);
	}
	
	
	
	public String toString() {
		
		String s = "";
		
		for(Voto v : voti)
			s += v.toString() + "\n";
		
		return s;
	}
	
	public List<Voto> listaVotiUguali(int punteggio) {
		
		List<Voto> trovati = new ArrayList<>();
		
		for(Voto v : voti) {
			if(v.getVoto() == punteggio)
				trovati.add(v);					// stesso oggetto ora e' in due liste diverse
		}
		
		return trovati;
	}
	
	public Libretto votiUguali(int punteggio) {
		Libretto risultato = new Libretto();
		
		for(Voto v : this.voti) {
			if(v.getVoto() == punteggio)
				risultato.add(v);					// stesso oggetto ora e' in due liste diverse
		}
		return risultato;
	}
	
	public int cercaVoto(String materia) {
		
		for(Voto v : voti) 
			if(v.getNomeCorso().equals(materia))
				return v.getVoto();					// stesso oggetto ora e' in due liste diverse
		
		return 0;
	}
	
	public boolean votoEsistente(Voto v) {
		
		Voto corso = mappaVoti.get(v.getNomeCorso());
		
		if(corso != null && corso.getVoto() == v.getVoto() && corso.getNomeCorso().equals(v.getNomeCorso()))
				return true;
		
		return false;
				
	}
	
	public boolean conflitto(Voto v) {
		
		Voto corso = mappaVoti.get(v.getNomeCorso());
		
		if(corso != null && corso.getVoto() != v.getVoto() && corso.getNomeCorso().equals(v.getNomeCorso()))
				return true;
		
		return false;
				
	}
	
	public List<Voto> miglioraLibretto() {
		
		migliorato = new ArrayList<>();
		
		for(Voto v : voti) 
			migliorato.add(v.migliora());
		
		
		return migliorato;
	}
	
	public String ordinaLibretto() {
		
		ordinato = new ArrayList<>(voti);
		
		Collections.sort(ordinato, new ComparatoreVoti());
		
		String s = "";
		
		for(Voto v : ordinato)
			s += v.toString() + "\n";
		
		return s;
	}
	
	public String listaVotiAlti() {
		
		votiAlti = new ArrayList<>();
		
		String s = "";
		
		for(Voto v : voti)
			if(v.getVoto() > 24) {
				votiAlti.add(v);
				s += v.toString() + "\n";
			}
		return s;
	}
	
}
