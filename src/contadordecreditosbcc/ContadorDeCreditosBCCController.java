/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contadordecreditosbcc;

import controladores.Acesso;
import dao.DataSource;
import dao.DisciplinaDAO;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import model.Disciplina;
import model.Usuario;

/**
 *
 * @author pauloaraujo
 */
public class ContadorDeCreditosBCCController implements Initializable {
    
    @FXML
    private TextField txtBusca;
  
    @FXML
    private GridPane gridPane;

    @FXML
    private Text txtDisc01;
    
    
    private ArrayList<Disciplina> searchResult;
    private ContextMenu entriesPopup;
    private Disciplina dscEscolhida;
    private DisciplinaDAO dscDAO;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // ajustando a cor de fundo da matriz
        //panDisc01.setStyle("-fx-background-color: #C0C0C0;");  
        
        // adicionando uma espera de mudança de texto na caixa de busca
        entriesPopup = new ContextMenu();
        entriesPopup.prefWidth(490);
        entriesPopup.minWidth(entriesPopup.getPrefWidth());
        entriesPopup.maxWidth(entriesPopup.getPrefWidth());
        dscDAO = new DisciplinaDAO(Acesso.getDS());
        
        txtBusca.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (txtBusca.getText().length() == 0) {
                    entriesPopup.hide();
                } else {
                    searchResult = new ArrayList<>();
                    searchResult = dscDAO.findSpecific(txtBusca.getText());
                    if (searchResult.size() > 0) {
                        populatePopup(searchResult);
                        if (!entriesPopup.isShowing()) {
                            entriesPopup.show(txtBusca, Side.BOTTOM, 0, 0);
                        }
                    } else {
                        entriesPopup.hide();
                    }
                }
            }
        });
        
        txtBusca.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                entriesPopup.hide();
            }
        });
    }
    
    // método para adicionar os elementos da busca realizada pelo usuário ao menu de contexto
    public void populatePopup(ArrayList<Disciplina> searchResult) {
        List<CustomMenuItem> menuItems = new LinkedList<>();
        // If you'd like more entries, modify this line.
        int maxEntries = 10;
        int count = Math.min(searchResult.size(), maxEntries);
              
        for (int i = 0; i < count; i++)
        {
            final Disciplina dscLocal = searchResult.get(i);
            final String result = dscLocal.getNome();
            Label entryLabel = new Label(result);
            CustomMenuItem item = new CustomMenuItem(entryLabel, true);
            item.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    txtBusca.setText(result);
                    dscEscolhida = dscLocal;
                    entriesPopup.hide();
                }
            });

            menuItems.add(item);
        }      
        entriesPopup.getItems().clear();
        entriesPopup.getItems().addAll(menuItems);
    }
    
    public void stop() throws Exception{
        System.out.println(getClass().getName());
    }
    
}
