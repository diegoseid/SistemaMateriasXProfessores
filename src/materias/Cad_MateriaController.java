/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package materias;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author Diego Seid
 */
public class Cad_MateriaController implements Initializable {

    @FXML private ComboBox<ObservableList> CBDiaSemana;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    ArrayList array = new ArrayList<String>();
    ObservableList<String> oblProjeto = FXCollections.observableArrayList("Segunda-Feira", "Terça-Feira", "Quarta-Feira");
    CBDiaSemana.setValue(oblProjeto);
            
    }    
    
}
