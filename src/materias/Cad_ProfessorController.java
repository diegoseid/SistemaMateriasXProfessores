/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package materias;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Diego Seid
 */
public class Cad_ProfessorController implements Initializable {

    @FXML private JFXButton BTCadastar;
    @FXML private ComboBox<String> CBMateria;
    @FXML private TextField TFNome;
    @FXML private TextField TFEmail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    ObservableList<String> oblProjeto = FXCollections.observableArrayList("Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta-Feira");
    //Botão para cadastrar uma Professor.
    BTCadastar.setOnAction(((event) -> {
        String sql = "insert into Materia values ()";
      DAO.inserir(sql);
    }));
    }    
    
}
