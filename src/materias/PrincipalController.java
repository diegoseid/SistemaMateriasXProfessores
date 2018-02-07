/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package materias;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Diego Seid
 */
public class PrincipalController implements Initializable {

    @FXML private Pane P_Marcar;
    @FXML private Button but_MarcarProva;
    @FXML private Button but_Agendar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
      but_Agendar.setOnMouseClicked(((event) -> {
          P_Marcar.setVisible(true);
          but_MarcarProva.setVisible(true);
      }));
      
      but_MarcarProva.setOnMouseClicked(((event) -> {
         P_Marcar.setVisible(false);
          but_MarcarProva.setVisible(false); 
      }));
        
    }    
    
}
