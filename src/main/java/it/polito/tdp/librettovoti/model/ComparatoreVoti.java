package it.polito.tdp.librettovoti.model;

import java.util.Comparator;

public class ComparatoreVoti implements Comparator<Voto>{

	@Override
	public int compare(Voto o1, Voto o2) {
		
		if(o1.getNomeCorso().equals(o2.getNomeCorso()))
			return o2.getVoto()-o1.getVoto();
		
		return o1.getNomeCorso().compareTo(o2.getNomeCorso());
	}

}
