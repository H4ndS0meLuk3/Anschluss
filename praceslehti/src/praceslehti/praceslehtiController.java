/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praceslehti;



import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author DOMA
 */
public class praceslehtiController implements Initializable {

	private int total = 0;
        ObservableList<Zbozi> zbozi;
    
     @FXML 
    private Label trzba;
   @FXML 
   private TextArea text;
   
    @FXML 
    private ChoiceBox<Zbozi> vyber;
   
    @FXML
    private Label nic;
    @FXML
    private Label nic2;
    @FXML
    private void handleButtonAction(ActionEvent secti) {
	Zbozi vybranezbozi = vyber.getValue();
        if (vybranezbozi.pocet <= 0) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Varování !");
            alert.setHeaderText("Nedostatek zboží na skladě");
            alert.setContentText("Doplňte " + vybranezbozi.jmeno);
            alert.showAndWait();
            return;
        }
        vybranezbozi.pocet -= 1;
	System.out.println("Přidali jste "+vybranezbozi.jmeno+ "!");
    	total += vybranezbozi.cena;
        napsatZbozi();
        trzba.setText( "Celkem "+ total + " Kč");
    }
     @FXML
    private void handleButtonAction2(ActionEvent ucet) {
	    total = 0;
    System.out.println("Vynulovali jste účet !");
        trzba.setText( "Celkem "+ total + " Kč");
    }
    
    private void napsatZbozi() {
        StringBuilder pismena = new StringBuilder();
        for (Zbozi vec : zbozi) {
            pismena.append(vec.jmeno);
            pismena.append("  ");
            pismena.append(vec.pocet);
            pismena.append("  ");
            pismena.append(vec.cena);
            pismena.append("\n");
        }
        text.setText(pismena.toString());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       try (BufferedReader br = new BufferedReader(new FileReader("sklad.txt")))
{
        String s;
        zbozi = FXCollections.observableArrayList();
        while ((s = br.readLine()) != null)
        {
            String[] casti = s.split(" ");
            if (casti.length != 3) {
                System.out.println("CHYBA");
                continue;
            }

            zbozi.add(new Zbozi(casti[0], Integer.valueOf(casti[1]), Integer.valueOf(casti[2])));
        }

    vyber.setItems(zbozi);
    napsatZbozi();
}
catch (Exception e)
{
	e.printStackTrace();
        System.err.println("Chyba při načtení ze souboru.");
}
       
    } 
    
    
}
