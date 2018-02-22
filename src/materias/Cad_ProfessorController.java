package materias;

import com.jfoenix.controls.JFXButton;
import com.sun.javafx.binding.StringFormatter;
import java.net.URL;
import java.util.ArrayList;
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
    
    private DAO con = new DAO();
    private String chave = "Materia", Sql;
    public static int IDMateria;
    public String Materia;
    public static ObservableList<String> oblProjeto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    Sql = "Select idmateria, materia from materia";    
    con.pesquisar(chave, Sql);
    
    CBMateria.setItems(oblProjeto);
    
    //Botão para cadastrar uma Professor.
    BTCadastar.setOnAction(((event) -> {
        chave = "IDMateria";
        Sql = "select IDMATERIA from materia where Materia = '" + CBMateria.getValue() + "'";
        con.pesquisar(chave, Sql);
      Sql = "insert into professor values (seqprof.nextval, '" + TFNome.getText() + "', '" + TFEmail.getText() + "'," + IDMateria + ")";
        System.out.println(Sql);
      DAO.inserir(Sql);
    }));
    
    }
    
    public void IdMateriaP(int IDMateria){
        this.IDMateria = IDMateria;
    }
    
    public static void BucarDados(String Materia){
  
        ArrayList<String> array = new ArrayList<>();
        array.add(Materia);

       for(String ar : array){
           oblProjeto = FXCollections.observableArrayList(ar);
       }
    }

    }

