package it.polito.tdp.librettovoti;

import java.net.URL;

import java.time.*;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;
import javafx.scene.control.DatePicker;
import it.polito.tdp.librettovoti.model.Libretto;
import it.polito.tdp.librettovoti.model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Libretto model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtEsame;

    @FXML
    private TextField txtVoto;
    
    @FXML
    private DatePicker datePickerEsame;

    @FXML
    private TextArea txtResult;

    @FXML
    void handleInserisci(ActionEvent event) {
    	
    	// Leggi e controlla i dati
    	
    	String nomeEsame = txtEsame.getText();
    	
    	if(nomeEsame.isBlank()) {
    		txtResult.setText("ERRORE: nome esame vuoto");
    		return;
    	}
    	
    	String votoEsame = txtVoto.getText();
    	int votoInt = 0;
    	try {
    		votoInt = Integer.parseInt(votoEsame);
    	}catch(NumberFormatException ex){
    		txtResult.setText("ERRORE: inserire un valore numerico come voto");
    		return;
    	}
    	if(votoInt < 18 || votoInt > 30) {
    		txtResult.setText("ERRORE: inserire un valore numerico compreso tra 18 e 30 come voto");
    		return;
    	}
    	
/**    	String dataEsameString = txtData.getText();
    	LocalDate data ;
    	try {
    		data = LocalDate.parse(dataEsameString);
    	}catch(DateTimeParseException ex) {
    		txtResult.setText("ERRORE: la data non e' nel formato corretto (AAAA-MM-DD)");
    		return;
    	}
  */
    	LocalDate data = datePickerEsame.getValue();
    	if(data==null) {
    		txtResult.setText("ERRORE: inserire la data ");
    		return;
    	}
    	
    	// Esegui l'azione
    	Voto voto = new Voto(nomeEsame, votoInt, data);
    	model.add(voto);
    	
    	// Aggiorna i risultati
    	txtResult.setText(model.toString());
    	txtEsame.clear();
    	txtVoto.clear();
    	datePickerEsame.setValue(null);
    }
    
    public void setModel(Libretto model){
    	this.model = model;
    }

    @FXML
    void initialize() {
        assert txtEsame != null : "fx:id=\"txtEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVoto != null : "fx:id=\"txtVoto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert datePickerEsame != null : "fx:id=\"datePickerEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}

