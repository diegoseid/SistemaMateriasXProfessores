package materias;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
    @FXML private MenuItem MIProfessor;
    @FXML private MenuItem MiMateria;
    @FXML private MenuItem MISobre;
    @FXML private Label LBLMateria;
    @FXML private Label LBLProfessor;
    @FXML private Label LBLEmail;
    
    private DAO con = new DAO();
    private String Sql, Chave = "Inicial";
    public static ArrayList<String> array = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       //Botão para abrir o Cadastro da Materia
      MiMateria.setOnAction(((event) -> {
          try {
              Parent root = FXMLLoader.load(getClass().getResource("Cad_Materia.fxml"));
              Scene scene = new Scene(root);
              Stage stage = new Stage();
              stage.setScene(scene);
              stage.show();
          } catch (IOException ex) {
              Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
          }
 
      })); 
      
      //Botão para abrir o Cadastro da Professor
      MIProfessor.setOnAction(((event) -> {
          try {
              Parent root = FXMLLoader.load(getClass().getResource("Cad_Professor.fxml"));
              Scene scene = new Scene(root);
              Stage stage = new Stage();
              stage.setScene(scene);
              stage.show();
          } catch (IOException ex) {
              Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
          }
 
      }));  
        
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
      
       //Pesquisar no banco os dados de acordo com o dia da semana
        Sql = "select ma.materia, prf.nomeprofessor, prf.email from materia ma "
                + "join professor prf on ma.IDMATERIA = prf.FK_IDMATERIA where ma.DIAAULA = '"+ DiaDaSemana.getText() +"'";
        con.pesquisar(Chave, Sql);
        
        //seta o valor dos dados na tela
        LBLMateria.setText(array.get(0));
        LBLProfessor.setText(array.get(1));
        LBLEmail.setText(array.get(2));
        
    } 
    
    //Metodo para pegar o dia em numero e transformar em dia da semana.
    public String weekDay(Calendar cal) {
    return new DateFormatSymbols().getWeekdays()[cal.get(Calendar.DAY_OF_WEEK)];
}  
    public void ListarDados(String Materia, String Profesor, String Email){
     array.add(Materia);
     array.add(Profesor);
     array.add(Email);
    }
    
}
