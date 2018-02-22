package materias;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.text.DateFormatSymbols;
import java.util.Calendar;
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
public class Cad_MateriaController implements Initializable {

    @FXML private ComboBox<String> CBDiaSemana;
    @FXML private JFXButton BTCadastar;
    @FXML
    private TextField TFMateria;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    ObservableList<String> oblProjeto = FXCollections.observableArrayList("Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira");
    CBDiaSemana.setValue(weekDay(Calendar.getInstance()));
    CBDiaSemana.setItems(oblProjeto);
    
    //Botão para cadastrar uma materira.
    BTCadastar.setOnAction(((event) -> {
        String sql = "insert into Materia values (seqmat.nextval, '" + TFMateria.getText() + "', '" + CBDiaSemana.getValue() + "')";
      DAO.inserir(sql);
    }));
            
    } 
    
    //Metodo para pegar o dia em numero e transformar em dia da semana.
    public String weekDay(Calendar cal) {
    return new DateFormatSymbols().getWeekdays()[cal.get(Calendar.DAY_OF_WEEK)];}
    
}
