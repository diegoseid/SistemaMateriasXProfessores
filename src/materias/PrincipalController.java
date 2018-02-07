package materias;

import java.net.URL;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
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
    @FXML private Label DiaDaSemana;
    @FXML private DatePicker DtPc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      //Verificar Qual o Dia Da Semana.
      DiaDaSemana.setText(weekDay(Calendar.getInstance()));
    
     //Botao responsavel por permitir marca uma prova.
      but_Agendar.setOnMouseClicked(((event) -> {    
          P_Marcar.setVisible(true);
          but_MarcarProva.setVisible(true);
      }));
      
      //Botão que sempre aparecera apos clicar em Agendar.
      but_MarcarProva.setOnMouseClicked(((event) -> {
         P_Marcar.setVisible(false);
          but_MarcarProva.setVisible(false); 
          DAO.testeDaConexao();
      }));
        
    } 
    
    //Metodo para pegar o dia em numero e transformar em dia da semana.
    public String weekDay(Calendar cal) {
    return new DateFormatSymbols().getWeekdays()[cal.get(Calendar.DAY_OF_WEEK)];
}  
    
}
