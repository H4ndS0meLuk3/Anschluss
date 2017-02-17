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

/**
 *
 * @author DOMA
 */
public class praceslehtiController implements Initializable {
    
     @FXML 
    private Label trzba;
   
    @FXML 
    private TableView sklad;
    @FXML 
    private ChoiceBox vyber;
   
    @FXML
    private Label nic;
    @FXML
    private Label nic2;
    @FXML
    private void handleButtonAction(ActionEvent secti) {
        int i = 5;
        int a = 0+i;
    System.out.println("You clicked me!");
        trzba.setText( "Máte"+a+ "Kč");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       try (BufferedReader br = new BufferedReader(new FileReader("sklad.txt")))
{
        String s;
        ObservableList<Zbozi> zbozi = FXCollections.observableArrayList();
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
}
catch (Exception e)
{
	e.printStackTrace();
        System.err.println("Chyba při načtení ze souboru.");
}
    }    
    
}
