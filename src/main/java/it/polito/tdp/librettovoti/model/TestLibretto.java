package it.polito.tdp.librettovoti.model;

import java.time.LocalDate;
import java.util.*;

public class TestLibretto {
	
	public static void main(String[] args) {

		Libretto libretto = new Libretto();
	
		Voto voto1 = new Voto("Analisi 1", 30, LocalDate.of(2019, 2, 15));
		
		libretto.add(voto1);
		
		libretto.add(new Voto("Fisica 1", 28, LocalDate.of(2019, 6, 27)));
		libretto.add(new Voto("Informatica", 30, LocalDate.of(2019, 2, 18)));
		libretto.add(new Voto("Algebra", 25, LocalDate.of(2019, 7, 18)));
		libretto.add(new Voto("Chimica", 18, LocalDate.of(2019, 6, 24)));
		libretto.add(new Voto("Chimica", 23, LocalDate.of(2019, 6, 24)));
		
		System.out.println("1. Stampo il libretto:\n");
		System.out.println(libretto);
		
		System.out.println("2. Stampo esami con voto = 25 \n");
		List<Voto> venticinque = libretto.listaVotiUguali(25);
		System.out.println(venticinque + "\n");
		
		String materia = "Informatica";
		System.out.println("3. Cerco il voto ottenuto nel corso di " + materia + "\n");
		Voto voto = libretto.cercaVoto(materia);
		System.out.println(voto.toString() + "\n");
		
		System.out.println("4. Creo nuovo voto, verifico se esiste \n");
		Voto nuovo = new Voto("Informatica", 30, LocalDate.of(2019, 2, 18));
		System.out.println("Nuovo voto: " + nuovo.toString());
		if(libretto.votoEsistente(nuovo))
			System.out.println("ESISTE gia' nel libretto");
		else
			System.out.println("NON ESISTE nel libretto");
		
		System.out.println("");
		
		System.out.println("5. Creo nuovo voto, verifico se esiste conflitto\n");
		Voto nuovoC = new Voto("Informatica", 24, LocalDate.of(2019, 2, 18));
		System.out.println("Nuovo voto: " + nuovoC.toString());
		if(libretto.conflitto(nuovoC))
			System.out.println("CONFLITTO nel libretto");
		else
			System.out.println("NESSUN CONFLITTO nel libretto");
		
		System.out.println("");
		
		System.out.println("6. provo ad aggiungere voto già esistente o in conflitto\n");
		String prima = libretto.toString();
		libretto.add(new Voto("Informatica", 28, LocalDate.of(2019, 2, 18)));
		String dopo = libretto.toString();
		if(prima.equals(dopo))
			System.out.println("Il voto NON E' stato aggiunto");
		else
			System.out.println("Il voto E' stato aggiunto");
		
		System.out.println("");
		
		System.out.println("7. Libretto Migliorato");
		System.out.println(libretto.miglioraLibretto().toString());
		System.out.println("Libretto Originale");
		System.out.println(libretto.toString());
		
		System.out.println("");
		
		System.out.println("8. Ordino il libretto per CORSO e VOTO");
		System.out.println(libretto.ordinaLibretto());
		
		System.out.println("9. Elimino voti infariori al 24");
		System.out.println(libretto.listaVotiAlti());
	}
}
