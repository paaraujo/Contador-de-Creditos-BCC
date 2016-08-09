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
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import model.Disciplina;
import model.Usuario;

/**
 *
 * @author pauloaraujo
 */
public class ContadorDeCreditosBCCController implements Initializable {
    
    // campo de busca por disciplina
    @FXML private TextField txtBusca;
    
    // botão para adicionar a disciplina ao currículo do aluno
    @FXML private Button btnAdiciona;
  
    // tabela de disciplinas obrigatórias
    @FXML private TableView<Disciplina> tbvOBR;
    // colunas da tabela de disciplinas obrigatórias
    @FXML private TableColumn<Disciplina, String> tbvOBRcodigo;
    @FXML private TableColumn<Disciplina, String> tbvOBRnome;
    @FXML private TableColumn<Disciplina, Integer> tbvOBRcreditos;
    
    // tabela de disciplinas limitadas
    @FXML private TableView<Disciplina> tbvLIM;
    // colunas da tabela de disciplinas obrigatórias
    @FXML private TableColumn<Disciplina, String> tbvLIMcodigo;
    @FXML private TableColumn<Disciplina, String> tbvLIMnome;
    @FXML private TableColumn<Disciplina, Integer> tbvLIMcreditos;
    
    // tabela de disciplinas livres
    @FXML private TableView<Disciplina> tbvLIV;
    // colunas da tabela de disciplinas obrigatórias
    @FXML private TableColumn<Disciplina, String> tbvLIVcodigo;
    @FXML private TableColumn<Disciplina, String> tbvLIVnome;
    @FXML private TableColumn<Disciplina, Integer> tbvLIVcreditos;
    
    // contadores de disciplinas
    @FXML private Text txtOBRtotaldisciplinas;
    @FXML private Text txtLIMtotaldisciplinas;
    @FXML private Text txtLIVtotaldisciplinas;
    
    // contadores de créditos
    @FXML private Text txtOBRtotalcreditos;
    @FXML private Text txtLIMtotalcreditos;
    @FXML private Text txtLIVtotalcreditos;
    
    // progressores
    @FXML private ProgressIndicator progressCPK;
    @FXML private ProgressIndicator progressOBR;
    @FXML private ProgressIndicator progressLIM;
    @FXML private ProgressIndicator progressLIV;
    
    // painéis de visualização
    @FXML private Pane panD01; @FXML private Pane panD02; @FXML private Pane panD03; @FXML private Pane panD04; @FXML private Pane panD05;
    @FXML private Pane panD06; @FXML private Pane panD07; @FXML private Pane panD08; @FXML private Pane panD09; @FXML private Pane panD10;
    @FXML private Pane panD11; @FXML private Pane panD12; @FXML private Pane panD13; @FXML private Pane panD14; @FXML private Pane panD15;
    @FXML private Pane panD16; @FXML private Pane panD17; @FXML private Pane panD18; @FXML private Pane panD19; @FXML private Pane panD20;
    @FXML private Pane panD21; @FXML private Pane panD22; @FXML private Pane panD23; @FXML private Pane panD24; @FXML private Pane panD25;
    @FXML private Pane panD26; @FXML private Pane panD27; @FXML private Pane panD28; @FXML private Pane panD29; @FXML private Pane panD30;
    @FXML private Pane panD31; @FXML private Pane panD32; @FXML private Pane panD33; @FXML private Pane panD34; @FXML private Pane panD35;
    @FXML private Pane panD36; @FXML private Pane panD37; @FXML private Pane panD38; @FXML private Pane panD39; @FXML private Pane panD40;
    @FXML private Pane panD41; @FXML private Pane panD42; @FXML private Pane panD43; @FXML private Pane panD44; @FXML private Pane panD45;
    @FXML private Pane panD46; @FXML private Pane panD47; @FXML private Pane panD48; @FXML private Pane panD49; @FXML private Pane panD50;
    @FXML private Pane panD51; @FXML private Pane panD52; @FXML private Pane panD53; @FXML private Pane panD54; @FXML private Pane panD55;
    @FXML private Pane panD56; @FXML private Pane panD57; @FXML private Pane panD58; @FXML private Pane panD59;
        
    // variáveis globais
    private ArrayList<Disciplina>   searchResult;
    private ContextMenu             entriesPopup;
    private Disciplina              dscEscolhida;
    private DisciplinaDAO           dscDAO;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // ajustando a cor de fundo da matriz
        //panDisc01.setStyle("-fx-background-color: #C0C0C0;");  
        
        /* adicionando uma espera de mudança de texto na caixa de busca */
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
    
    // método para adicionar uma disciplina ao histórico do aluno
    public void adicionaDisciplina(ActionEvent actionEvent){
        
        // inserindo disciplina no banco de dados do usuário
        dscDAO.insert(Acesso.getUsuario(), dscEscolhida);
        
        // adicionando a disciplina na tableview correspondente
        
                
    }
}
