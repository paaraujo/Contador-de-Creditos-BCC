/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contadordecreditosbcc;

import controle.Acesso;
import dao.DisciplinaDAO;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import model.Disciplina;

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
    @FXML private TableColumn<Disciplina, Number> tbvOBRcreditos;
    
    // tabela de disciplinas limitadas
    @FXML private TableView<Disciplina> tbvLIM;
    // colunas da tabela de disciplinas obrigatórias
    @FXML private TableColumn<Disciplina, String> tbvLIMcodigo;
    @FXML private TableColumn<Disciplina, String> tbvLIMnome;
    @FXML private TableColumn<Disciplina, Number> tbvLIMcreditos;
    
    // tabela de disciplinas livres
    @FXML private TableView<Disciplina> tbvLIV;
    // colunas da tabela de disciplinas obrigatórias
    @FXML private TableColumn<Disciplina, String> tbvLIVcodigo;
    @FXML private TableColumn<Disciplina, String> tbvLIVnome;
    @FXML private TableColumn<Disciplina, Number> tbvLIVcreditos;
    
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
    
    @FXML private Text txtD01; @FXML private Text txtD02; @FXML private Text txtD03; @FXML private Text txtD04; @FXML private Text txtD05;
    @FXML private Text txtD06; @FXML private Text txtD07; @FXML private Text txtD08; @FXML private Text txtD09; @FXML private Text txtD10;
    @FXML private Text txtD11; @FXML private Text txtD12; @FXML private Text txtD13; @FXML private Text txtD14; @FXML private Text txtD15;
    @FXML private Text txtD16; @FXML private Text txtD17; @FXML private Text txtD18; @FXML private Text txtD19; @FXML private Text txtD20;
    @FXML private Text txtD21; @FXML private Text txtD22; @FXML private Text txtD23; @FXML private Text txtD24; @FXML private Text txtD25;
    @FXML private Text txtD26; @FXML private Text txtD27; @FXML private Text txtD28; @FXML private Text txtD29; @FXML private Text txtD30;
    @FXML private Text txtD31; @FXML private Text txtD32; @FXML private Text txtD33; @FXML private Text txtD34; @FXML private Text txtD35;
    @FXML private Text txtD36; @FXML private Text txtD37; @FXML private Text txtD38; @FXML private Text txtD39; @FXML private Text txtD40;
    @FXML private Text txtD41; @FXML private Text txtD42; @FXML private Text txtD43; @FXML private Text txtD44; @FXML private Text txtD45;
    @FXML private Text txtD46; @FXML private Text txtD47; @FXML private Text txtD48; @FXML private Text txtD49; @FXML private Text txtD50;
    @FXML private Text txtD51; @FXML private Text txtD52; @FXML private Text txtD53; @FXML private Text txtD54; @FXML private Text txtD55;
    @FXML private Text txtD56; @FXML private Text txtD57; @FXML private Text txtD58; @FXML private Text txtD59;    
    
    // radiobuttons
    @FXML private RadioButton rdbPG; @FXML private RadioButton rdbEST; @FXML private RadioButton rdbPGEST;
        
    // variáveis globais
    private ContextMenu                 entriesPopup;
    private Disciplina                  dscEscolhida;
    private DisciplinaDAO               dscDAO;
    private ObservableList<Disciplina>  listaOBR, listaLIM, listaLIV;
    private double                      totalOBR, totalLIM, totalLIV, totalOBRcred, totalLIMcred, totalLIVcred, parcialLIM;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

       tbvOBR.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
       tbvLIM.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
       tbvLIV.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        /* adicionando uma espera de mudança de texto na caixa de busca */
        dscDAO       = new DisciplinaDAO(Acesso.getDS());
        
        entriesPopup = new ContextMenu();
        entriesPopup.prefWidth(490);
        entriesPopup.minWidth(entriesPopup.getPrefWidth());
        entriesPopup.maxWidth(entriesPopup.getPrefWidth());
        
        txtBusca.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (txtBusca.getText().length() == 0) {
                    entriesPopup.hide();
                } else {
                    ArrayList<Disciplina> searchResult = dscDAO.findSpecific(txtBusca.getText());
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
        
        // ajustando os parâmentros das colunas das tabelas
        tbvOBRcodigo.setCellValueFactory(cellData -> cellData.getValue().codigoProperty());
        tbvOBRnome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
        tbvOBRcreditos.setCellValueFactory(cellData -> cellData.getValue().creditosProperty());
        
        tbvLIMcodigo.setCellValueFactory(cellData -> cellData.getValue().codigoProperty());
        tbvLIMnome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
        tbvLIMcreditos.setCellValueFactory(cellData -> cellData.getValue().creditosProperty());
        
        tbvLIVcodigo.setCellValueFactory(cellData -> cellData.getValue().codigoProperty());
        tbvLIVnome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
        tbvLIVcreditos.setCellValueFactory(cellData -> cellData.getValue().creditosProperty());
            
        /* adicionando listener chamando um menu de contexto para deletar uma linha das tabelas */
        tbvOBR.setRowFactory((TableView<Disciplina> tableView) -> {
            final TableRow<Disciplina> row = new TableRow<>();
            final ContextMenu contextMenu = new ContextMenu();
            Label deleteLabel = new Label("Remover");
            final CustomMenuItem removeMenuItem = new CustomMenuItem(deleteLabel);
            removeMenuItem.setOnAction((ActionEvent event) -> {
                tbvOBR.getItems().remove(row.getItem());
                dscDAO.removeDiscFromUser(Acesso.getUsuario(), row.getItem());
                populateTableFromDB();
                calculateTotalCreditsFromDB();
                populateProgressesIndicators();
                updateMatriz();
            });
            contextMenu.getItems().add(removeMenuItem);
            // Set context menu on row, but use a binding to make it only show for non-empty rows:
            row.contextMenuProperty().bind(
                    Bindings.when(row.emptyProperty())
                            .then((ContextMenu)null)
                            .otherwise(contextMenu)
            );
            return row ;
        }); 
        
        tbvLIM.setRowFactory((TableView<Disciplina> tableView) -> {
            final TableRow<Disciplina> row = new TableRow<>();
            final ContextMenu contextMenu = new ContextMenu();
            Label deleteLabel = new Label("Remover");
            final CustomMenuItem removeMenuItem = new CustomMenuItem(deleteLabel);
            removeMenuItem.setOnAction((ActionEvent event) -> {
                tbvLIM.getItems().remove(row.getItem());
                dscDAO.removeDiscFromUser(Acesso.getUsuario(), row.getItem());
                populateTableFromDB();
                calculateTotalCreditsFromDB();
                populateProgressesIndicators();
                updateMatriz();
            });
            contextMenu.getItems().add(removeMenuItem);
            // Set context menu on row, but use a binding to make it only show for non-empty rows:
            row.contextMenuProperty().bind(
                    Bindings.when(row.emptyProperty())
                            .then((ContextMenu)null)
                            .otherwise(contextMenu)
            );
            return row ;
        }); 
        
        tbvLIV.setRowFactory((TableView<Disciplina> tableView) -> {
            final TableRow<Disciplina> row = new TableRow<>();
            final ContextMenu contextMenu = new ContextMenu();
            Label deleteLabel = new Label("Remover");
            final CustomMenuItem removeMenuItem = new CustomMenuItem(deleteLabel);
            removeMenuItem.setOnAction((ActionEvent event) -> {
                tbvLIV.getItems().remove(row.getItem());
                dscDAO.removeDiscFromUser(Acesso.getUsuario(), row.getItem());
                populateTableFromDB();
                calculateTotalCreditsFromDB();
                populateProgressesIndicators();
                updateMatriz();
            });
            contextMenu.getItems().add(removeMenuItem);
            // Set context menu on row, but use a binding to make it only show for non-empty rows:
            row.contextMenuProperty().bind(
                    Bindings.when(row.emptyProperty())
                            .then((ContextMenu)null)
                            .otherwise(contextMenu)
            );
            return row ;
        }); 
        
        /* radiobuttons listener */
        parcialLIM = 30;
        ToggleGroup group = new ToggleGroup();
        rdbPG.setToggleGroup(group);
        rdbEST.setToggleGroup(group);
        rdbPGEST.setToggleGroup(group);
        rdbPG.setSelected(true);
        
        group.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) -> {
            if(rdbPG.isSelected()){
                parcialLIM = 30;
            }
            if(rdbEST.isSelected()){
                parcialLIM = 44;
            }
            if(rdbPGEST.isSelected()){
                parcialLIM = 20;
            }
            populateProgressesIndicators();
            System.out.println(new_toggle);
            System.out.println(parcialLIM);
       });
                      
        // método para inicializar as tabelas com os dados do banco de dados  
        populateTableFromDB();
        
        // método para inicializar os contadores de créditos
        calculateTotalCreditsFromDB();
        
        // método para inicializar os indicadores de progresso
        populateProgressesIndicators();
        
        // método para atualizar a matriz
        updateMatriz();
        
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
    
    // método para preencher as tabelas a partir do banco de dados do usuário
    public void populateTableFromDB(){
        
        // inicializando as listas de disciplinas
        listaOBR = FXCollections.observableArrayList();
        listaLIM = FXCollections.observableArrayList();
        listaLIV = FXCollections.observableArrayList();
        
        // recuperando dados do banco e alimentando as listas de disciplinas
        ArrayList<Disciplina> array_temp = dscDAO.readAllByUser(Acesso.getUsuario());
        for ( Disciplina d: array_temp){
            switch (d.getCategoria()) {
            case "OBRIGATORIA": listaOBR.add(d); break;
            case "LIMITADA":    listaLIM.add(d); break;
            case "LIVRE":       listaLIV.add(d); break;
            default: System.out.println("Disciplina - " + d.getNome() + " - não contem categoria definida");
            }
        }

        // carregando as tabelas
        tbvOBR.setItems(listaOBR);
        tbvLIM.setItems(listaLIM);
        tbvLIV.setItems(listaLIV);
               
    }
    
    // método para calcular o total de créditos que o usuário possui
    public void calculateTotalCreditsFromDB(){
        
        // reiniciando as variáveis de contagem de créditos e disciplinas
        totalOBRcred = 0; totalLIMcred = 0; totalLIVcred = 0;
        totalOBR     = 0; totalLIM     = 0; totalLIV     = 0;
        
        // recuperando dados do banco
        ArrayList<Disciplina> array_temp = dscDAO.readAllByUser(Acesso.getUsuario());
        for ( Disciplina d: array_temp){
            switch (d.getCategoria()) {
            case "OBRIGATORIA": totalOBRcred += d.getCreditos(); totalOBR += 1; break;
            case "LIMITADA":    totalLIMcred += d.getCreditos(); totalLIM += 1; break;
            case "LIVRE":       totalLIVcred += d.getCreditos(); totalLIV += 1; break;
            default: System.out.println("Disciplina - " + d.getNome() + " - não contem categoria definida");
            }
        }
         
        // carregando as variáveis na interface gráfica
        txtOBRtotalcreditos.setText(String.valueOf((int)totalOBRcred));
        txtLIMtotalcreditos.setText(String.valueOf((int)totalLIMcred));
        txtLIVtotalcreditos.setText(String.valueOf((int)totalLIVcred));
        
        txtOBRtotaldisciplinas.setText(String.valueOf((int)totalOBR));
        txtLIMtotaldisciplinas.setText(String.valueOf((int)totalLIM));
        txtLIVtotaldisciplinas.setText(String.valueOf((int)totalLIV));
               
    }
    
    // método para atualizar a matriz de disciplinas
    public void updateMatriz(){
                   
        // reiniciando matriz
        panD01.getStyleClass().removeAll("disc-undone","disc-done"); panD01.getStyleClass().add( "disc-undone");        
        panD02.getStyleClass().removeAll("disc-undone","disc-done"); panD02.getStyleClass().add( "disc-undone");
        panD03.getStyleClass().removeAll("disc-undone","disc-done"); panD03.getStyleClass().add( "disc-undone");
        panD04.getStyleClass().removeAll("disc-undone","disc-done"); panD04.getStyleClass().add( "disc-undone");
        panD05.getStyleClass().removeAll("disc-undone","disc-done"); panD05.getStyleClass().add( "disc-undone");
        panD06.getStyleClass().removeAll("disc-undone","disc-done"); panD06.getStyleClass().add( "disc-undone");
        panD07.getStyleClass().removeAll("disc-undone","disc-done"); panD07.getStyleClass().add( "disc-undone");
        panD08.getStyleClass().removeAll("disc-undone","disc-done"); panD08.getStyleClass().add( "disc-undone");
        panD09.getStyleClass().removeAll("disc-undone","disc-done"); panD09.getStyleClass().add( "disc-undone");
        panD10.getStyleClass().removeAll("disc-undone","disc-done"); panD10.getStyleClass().add( "disc-undone");
        panD11.getStyleClass().removeAll("disc-undone","disc-done"); panD11.getStyleClass().add( "disc-undone");
        panD12.getStyleClass().removeAll("disc-undone","disc-done"); panD12.getStyleClass().add( "disc-undone");
        panD13.getStyleClass().removeAll("disc-undone","disc-done"); panD13.getStyleClass().add( "disc-undone");
        panD14.getStyleClass().removeAll("disc-undone","disc-done"); panD14.getStyleClass().add( "disc-undone");
        panD15.getStyleClass().removeAll("disc-undone","disc-done"); panD15.getStyleClass().add( "disc-undone");
        panD16.getStyleClass().removeAll("disc-undone","disc-done"); panD16.getStyleClass().add( "disc-undone");
        panD17.getStyleClass().removeAll("disc-undone","disc-done"); panD17.getStyleClass().add( "disc-undone");
        panD18.getStyleClass().removeAll("disc-undone","disc-done"); panD18.getStyleClass().add( "disc-undone");
        panD19.getStyleClass().removeAll("disc-undone","disc-done"); panD19.getStyleClass().add( "disc-undone");
        panD20.getStyleClass().removeAll("disc-undone","disc-done"); panD20.getStyleClass().add( "disc-undone");
        panD21.getStyleClass().removeAll("disc-undone","disc-done"); panD21.getStyleClass().add( "disc-undone");
        panD22.getStyleClass().removeAll("disc-undone","disc-done"); panD22.getStyleClass().add( "disc-undone");
        panD23.getStyleClass().removeAll("disc-undone","disc-done"); panD23.getStyleClass().add( "disc-undone");
        panD24.getStyleClass().removeAll("disc-undone","disc-done"); panD24.getStyleClass().add( "disc-undone");
        panD25.getStyleClass().removeAll("disc-undone","disc-done"); panD25.getStyleClass().add( "disc-undone");
        panD26.getStyleClass().removeAll("disc-undone","disc-done"); panD26.getStyleClass().add( "disc-undone");
        panD27.getStyleClass().removeAll("disc-undone","disc-done"); panD27.getStyleClass().add( "disc-undone");
        panD28.getStyleClass().removeAll("disc-undone","disc-done"); panD28.getStyleClass().add( "disc-undone");
        panD29.getStyleClass().removeAll("disc-undone","disc-done"); panD29.getStyleClass().add( "disc-undone");
        panD30.getStyleClass().removeAll("disc-undone","disc-done"); panD30.getStyleClass().add( "disc-undone");
        panD31.getStyleClass().removeAll("disc-undone","disc-done"); panD31.getStyleClass().add( "disc-undone");
        panD32.getStyleClass().removeAll("disc-undone","disc-done"); panD32.getStyleClass().add( "disc-undone");
        panD33.getStyleClass().removeAll("disc-undone","disc-done"); panD33.getStyleClass().add( "disc-undone");
        panD34.getStyleClass().removeAll("disc-undone","disc-done"); panD34.getStyleClass().add( "disc-undone");
        panD35.getStyleClass().removeAll("disc-undone","disc-done"); panD35.getStyleClass().add( "disc-undone");
        panD36.getStyleClass().removeAll("disc-undone","disc-done"); panD36.getStyleClass().add( "disc-undone");
        panD37.getStyleClass().removeAll("disc-undone","disc-done"); panD37.getStyleClass().add( "disc-undone");
        panD38.getStyleClass().removeAll("disc-undone","disc-done"); panD38.getStyleClass().add( "disc-undone");
        panD39.getStyleClass().removeAll("disc-undone","disc-done"); panD39.getStyleClass().add( "disc-undone");
        panD40.getStyleClass().removeAll("disc-undone","disc-done"); panD40.getStyleClass().add( "disc-undone");
        panD41.getStyleClass().removeAll("disc-undone","disc-done"); panD41.getStyleClass().add( "disc-undone");
        panD42.getStyleClass().removeAll("disc-undone","disc-done"); panD42.getStyleClass().add( "disc-undone");
        panD43.getStyleClass().removeAll("disc-undone","disc-done"); panD43.getStyleClass().add( "disc-undone");
        panD44.getStyleClass().removeAll("disc-undone","disc-done"); panD44.getStyleClass().add( "disc-undone");
        panD45.getStyleClass().removeAll("disc-undone","disc-done"); panD45.getStyleClass().add( "disc-undone");
        panD46.getStyleClass().removeAll("disc-undone","disc-done"); panD46.getStyleClass().add( "disc-undone");
        panD47.getStyleClass().removeAll("disc-undone","disc-done"); panD47.getStyleClass().add( "disc-undone");
        panD48.getStyleClass().removeAll("disc-undone","disc-done"); panD48.getStyleClass().add( "disc-undone");
        panD49.getStyleClass().removeAll("disc-undone","disc-done"); panD49.getStyleClass().add( "disc-undone");
        panD50.getStyleClass().removeAll("disc-undone","disc-done"); panD50.getStyleClass().add( "disc-undone");
        panD51.getStyleClass().removeAll("disc-undone","disc-done"); panD51.getStyleClass().add( "disc-undone");
        panD52.getStyleClass().removeAll("disc-undone","disc-done"); panD52.getStyleClass().add( "disc-undone");
        panD53.getStyleClass().removeAll("disc-undone","disc-done"); panD53.getStyleClass().add( "disc-undone");
        panD54.getStyleClass().removeAll("disc-undone","disc-done"); panD54.getStyleClass().add( "disc-undone");
        panD55.getStyleClass().removeAll("disc-undone","disc-done"); panD55.getStyleClass().add( "disc-undone");
        panD56.getStyleClass().removeAll("disc-undone","disc-done"); panD56.getStyleClass().add( "disc-undone");
        panD57.getStyleClass().removeAll("disc-undone","disc-done"); panD57.getStyleClass().add( "disc-undone");
        panD58.getStyleClass().removeAll("disc-undone","disc-done"); panD58.getStyleClass().add( "disc-undone");
        panD59.getStyleClass().removeAll("disc-undone","disc-done"); panD59.getStyleClass().add( "disc-undone");
        
        txtD01.getStyleClass().removeAll("h5", "h6"); txtD01.getStyleClass().add("h5");
        txtD02.getStyleClass().removeAll("h5", "h6"); txtD02.getStyleClass().add("h5");
        txtD03.getStyleClass().removeAll("h5", "h6"); txtD03.getStyleClass().add("h5");
        txtD04.getStyleClass().removeAll("h5", "h6"); txtD04.getStyleClass().add("h5");
        txtD05.getStyleClass().removeAll("h5", "h6"); txtD05.getStyleClass().add("h5");
        txtD06.getStyleClass().removeAll("h5", "h6"); txtD06.getStyleClass().add("h5");
        txtD07.getStyleClass().removeAll("h5", "h6"); txtD07.getStyleClass().add("h5");
        txtD08.getStyleClass().removeAll("h5", "h6"); txtD08.getStyleClass().add("h5");
        txtD09.getStyleClass().removeAll("h5", "h6"); txtD09.getStyleClass().add("h5");
        txtD10.getStyleClass().removeAll("h5", "h6"); txtD10.getStyleClass().add("h5");
        txtD11.getStyleClass().removeAll("h5", "h6"); txtD11.getStyleClass().add("h5");
        txtD12.getStyleClass().removeAll("h5", "h6"); txtD12.getStyleClass().add("h5");
        txtD13.getStyleClass().removeAll("h5", "h6"); txtD13.getStyleClass().add("h5");
        txtD14.getStyleClass().removeAll("h5", "h6"); txtD14.getStyleClass().add("h5");
        txtD15.getStyleClass().removeAll("h5", "h6"); txtD15.getStyleClass().add("h5");
        txtD16.getStyleClass().removeAll("h5", "h6"); txtD16.getStyleClass().add("h5");
        txtD17.getStyleClass().removeAll("h5", "h6"); txtD17.getStyleClass().add("h5");
        txtD18.getStyleClass().removeAll("h5", "h6"); txtD18.getStyleClass().add("h5");
        txtD19.getStyleClass().removeAll("h5", "h6"); txtD19.getStyleClass().add("h5");
        txtD20.getStyleClass().removeAll("h5", "h6"); txtD20.getStyleClass().add("h5");
        txtD21.getStyleClass().removeAll("h5", "h6"); txtD21.getStyleClass().add("h5");
        txtD22.getStyleClass().removeAll("h5", "h6"); txtD22.getStyleClass().add("h5");
        txtD23.getStyleClass().removeAll("h5", "h6"); txtD23.getStyleClass().add("h5");
        txtD24.getStyleClass().removeAll("h5", "h6"); txtD24.getStyleClass().add("h5");
        txtD25.getStyleClass().removeAll("h5", "h6"); txtD25.getStyleClass().add("h5");
        txtD26.getStyleClass().removeAll("h5", "h6"); txtD26.getStyleClass().add("h5");
        txtD27.getStyleClass().removeAll("h5", "h6"); txtD27.getStyleClass().add("h5");
        txtD28.getStyleClass().removeAll("h5", "h6"); txtD28.getStyleClass().add("h5");
        txtD29.getStyleClass().removeAll("h5", "h6"); txtD29.getStyleClass().add("h5");
        txtD30.getStyleClass().removeAll("h5", "h6"); txtD30.getStyleClass().add("h5");
        txtD31.getStyleClass().removeAll("h5", "h6"); txtD31.getStyleClass().add("h5");
        txtD32.getStyleClass().removeAll("h5", "h6"); txtD32.getStyleClass().add("h5");
        txtD33.getStyleClass().removeAll("h5", "h6"); txtD33.getStyleClass().add("h5");
        txtD34.getStyleClass().removeAll("h5", "h6"); txtD34.getStyleClass().add("h5");
        txtD35.getStyleClass().removeAll("h5", "h6"); txtD35.getStyleClass().add("h5");
        txtD36.getStyleClass().removeAll("h5", "h6"); txtD36.getStyleClass().add("h5");
        txtD37.getStyleClass().removeAll("h5", "h6"); txtD37.getStyleClass().add("h5");
        txtD38.getStyleClass().removeAll("h5", "h6"); txtD38.getStyleClass().add("h5");
        txtD39.getStyleClass().removeAll("h5", "h6"); txtD39.getStyleClass().add("h5");
        txtD40.getStyleClass().removeAll("h5", "h6"); txtD40.getStyleClass().add("h5");
        txtD41.getStyleClass().removeAll("h5", "h6"); txtD41.getStyleClass().add("h5");
        txtD42.getStyleClass().removeAll("h5", "h6"); txtD42.getStyleClass().add("h5");
        txtD43.getStyleClass().removeAll("h5", "h6"); txtD43.getStyleClass().add("h5");
        txtD44.getStyleClass().removeAll("h5", "h6"); txtD44.getStyleClass().add("h5");
        txtD45.getStyleClass().removeAll("h5", "h6"); txtD45.getStyleClass().add("h5");
        txtD46.getStyleClass().removeAll("h5", "h6"); txtD46.getStyleClass().add("h5");
        txtD47.getStyleClass().removeAll("h5", "h6"); txtD47.getStyleClass().add("h5");
        txtD48.getStyleClass().removeAll("h5", "h6"); txtD48.getStyleClass().add("h5");
        txtD49.getStyleClass().removeAll("h5", "h6"); txtD49.getStyleClass().add("h5");
        txtD50.getStyleClass().removeAll("h5", "h6"); txtD50.getStyleClass().add("h5");
        txtD51.getStyleClass().removeAll("h5", "h6"); txtD51.getStyleClass().add("h5");
        txtD52.getStyleClass().removeAll("h5", "h6"); txtD52.getStyleClass().add("h5");
        txtD53.getStyleClass().removeAll("h5", "h6"); txtD53.getStyleClass().add("h5");
        txtD54.getStyleClass().removeAll("h5", "h6"); txtD54.getStyleClass().add("h5");
        txtD55.getStyleClass().removeAll("h5", "h6"); txtD55.getStyleClass().add("h5");
        txtD56.getStyleClass().removeAll("h5", "h6"); txtD56.getStyleClass().add("h5");
        txtD57.getStyleClass().removeAll("h5", "h6"); txtD57.getStyleClass().add("h5");
        txtD58.getStyleClass().removeAll("h5", "h6"); txtD58.getStyleClass().add("h5");
        txtD59.getStyleClass().removeAll("h5", "h6"); txtD59.getStyleClass().add("h5");
           
        // recuperando dados do banco
        ArrayList<Disciplina> array_temp = dscDAO.readAllByUser(Acesso.getUsuario());
        for ( Disciplina d: array_temp){
            switch (d.getCodigo()) {
            case "BIS0005-15":  
                panD01.getStyleClass().remove("disc-undone"); panD01.getStyleClass().add("disc-done"); 
                txtD01.getStyleClass().remove("h5"); txtD01.getStyleClass().add("h6");
                break;
            case "BCS0001-15":  
                panD02.getStyleClass().remove("disc-undone"); panD02.getStyleClass().add("disc-done"); 
                txtD02.getStyleClass().remove("h5"); txtD02.getStyleClass().add("h6");
                break;
            case "BIK0102-15":
                panD03.getStyleClass().remove("disc-undone"); panD03.getStyleClass().add("disc-done"); 
                txtD03.getStyleClass().remove("h5"); txtD03.getStyleClass().add("h6");
                break;
            case "BIS0003-15":
                panD04.getStyleClass().remove("disc-undone"); panD04.getStyleClass().add("disc-done"); 
                txtD04.getStyleClass().remove("h5"); txtD04.getStyleClass().add("h6");
                break;
            case "BIJ0207-15":
                panD05.getStyleClass().remove("disc-undone"); panD05.getStyleClass().add("disc-done"); 
                txtD05.getStyleClass().remove("h5"); txtD05.getStyleClass().add("h6");
                break;
            case "BIL0304-15":
                panD06.getStyleClass().remove("disc-undone"); panD06.getStyleClass().add("disc-done"); 
                txtD06.getStyleClass().remove("h5"); txtD06.getStyleClass().add("h6");
                break;
            case "BCM0504-15":
                panD07.getStyleClass().remove("disc-undone"); panD07.getStyleClass().add("disc-done"); 
                txtD07.getStyleClass().remove("h5"); txtD07.getStyleClass().add("h6");
                break;
            case "BCJ0204-15":
                panD08.getStyleClass().remove("disc-undone"); panD08.getStyleClass().add("disc-done"); 
                txtD08.getStyleClass().remove("h5"); txtD08.getStyleClass().add("h6");
                break;
            case "BCN0404-15":
                panD09.getStyleClass().remove("disc-undone"); panD09.getStyleClass().add("disc-done"); 
                txtD09.getStyleClass().remove("h5"); txtD09.getStyleClass().add("h6");
                break;
            case "BCN0402-15":
                panD10.getStyleClass().remove("disc-undone"); panD10.getStyleClass().add("disc-done"); 
                txtD10.getStyleClass().remove("h5"); txtD10.getStyleClass().add("h6");
                break;
            case "BCL0306-15":
                panD11.getStyleClass().remove("disc-undone"); panD11.getStyleClass().add("disc-done"); 
                txtD11.getStyleClass().remove("h5"); txtD11.getStyleClass().add("h6");
                break;
            case "BCM0505-15":
                panD12.getStyleClass().remove("disc-undone"); panD12.getStyleClass().add("disc-done"); 
                txtD12.getStyleClass().remove("h5"); txtD12.getStyleClass().add("h6");
                break;
            case "BCJ0205-15":
                panD13.getStyleClass().remove("disc-undone"); panD13.getStyleClass().add("disc-done"); 
                txtD13.getStyleClass().remove("h5"); txtD13.getStyleClass().add("h6");
                break;
            case "BCN0407-15":
                panD14.getStyleClass().remove("disc-undone"); panD14.getStyleClass().add("disc-done"); 
                txtD14.getStyleClass().remove("h5"); txtD14.getStyleClass().add("h6");
                break;
            case "BCL0307-15":
                panD15.getStyleClass().remove("disc-undone"); panD15.getStyleClass().add("disc-done"); 
                txtD15.getStyleClass().remove("h5"); txtD15.getStyleClass().add("h6");
                break;
            case "BCM0506-15":
                panD16.getStyleClass().remove("disc-undone"); panD16.getStyleClass().add("disc-done"); 
                txtD16.getStyleClass().remove("h5"); txtD16.getStyleClass().add("h6");
                break;
            case "BCJ0203-15":
                panD17.getStyleClass().remove("disc-undone"); panD17.getStyleClass().add("disc-done"); 
                txtD17.getStyleClass().remove("h5"); txtD17.getStyleClass().add("h6");
                break;
            case "BIN0406-15":
                panD18.getStyleClass().remove("disc-undone"); panD18.getStyleClass().add("disc-done"); 
                txtD18.getStyleClass().remove("h5"); txtD18.getStyleClass().add("h6");
                break;
            case "BCN0405-15":
                panD19.getStyleClass().remove("disc-undone"); panD19.getStyleClass().add("disc-done"); 
                txtD19.getStyleClass().remove("h5"); txtD19.getStyleClass().add("h6");
                break;
            case "BIR0004-15":
                panD20.getStyleClass().remove("disc-undone"); panD20.getStyleClass().add("disc-done"); 
                txtD20.getStyleClass().remove("h5"); txtD20.getStyleClass().add("h6");
                break;
            case "BCK0103-15":
                panD21.getStyleClass().remove("disc-undone"); panD21.getStyleClass().add("disc-done"); 
                txtD21.getStyleClass().remove("h5"); txtD21.getStyleClass().add("h6");
                break;
            case "BCL0308-15":
                panD22.getStyleClass().remove("disc-undone"); panD22.getStyleClass().add("disc-done"); 
                txtD22.getStyleClass().remove("h5"); txtD22.getStyleClass().add("h6");
                break;
            case "BIQ0602-15":
                panD23.getStyleClass().remove("disc-undone"); panD23.getStyleClass().add("disc-done"); 
                txtD23.getStyleClass().remove("h5"); txtD23.getStyleClass().add("h6");
                break;
            case "NHI2049-13":
                panD24.getStyleClass().remove("disc-undone"); panD24.getStyleClass().add("disc-done"); 
                txtD24.getStyleClass().remove("h5"); txtD24.getStyleClass().add("h6");
                break;
            case "MCTA028-15":
                panD25.getStyleClass().remove("disc-undone"); panD25.getStyleClass().add("disc-done"); 
                txtD25.getStyleClass().remove("h5"); txtD25.getStyleClass().add("h6");
                break;
            case "BCK0104-15":
                panD26.getStyleClass().remove("disc-undone"); panD26.getStyleClass().add("disc-done"); 
                txtD26.getStyleClass().remove("h5"); txtD26.getStyleClass().add("h6");
                break;
            case "BIR0603-15":
                panD27.getStyleClass().remove("disc-undone"); panD27.getStyleClass().add("disc-done"); 
                txtD27.getStyleClass().remove("h5"); txtD27.getStyleClass().add("h6");
                break;
            case "MCTA006-13":
                panD28.getStyleClass().remove("disc-undone"); panD28.getStyleClass().add("disc-done"); 
                txtD28.getStyleClass().remove("h5"); txtD28.getStyleClass().add("h6");
                break;
            case "MCTA001-13":
                panD29.getStyleClass().remove("disc-undone"); panD29.getStyleClass().add("disc-done"); 
                txtD29.getStyleClass().remove("h5"); txtD29.getStyleClass().add("h6");
                break;
            case "MCTB019-13":
                panD30.getStyleClass().remove("disc-undone"); panD30.getStyleClass().add("disc-done"); 
                txtD30.getStyleClass().remove("h5"); txtD30.getStyleClass().add("h6");
                break;
            case "MCTA024-13":
                panD31.getStyleClass().remove("disc-undone"); panD31.getStyleClass().add("disc-done"); 
                txtD31.getStyleClass().remove("h5"); txtD31.getStyleClass().add("h6");
                break;
            case "MCTA003-13":
                panD32.getStyleClass().remove("disc-undone"); panD32.getStyleClass().add("disc-done"); 
                txtD32.getStyleClass().remove("h5"); txtD32.getStyleClass().add("h6");
                break;
            case "MCTA018-13":
                panD33.getStyleClass().remove("disc-undone"); panD33.getStyleClass().add("disc-done"); 
                txtD33.getStyleClass().remove("h5"); txtD33.getStyleClass().add("h6");
                break;
            case "MCTB001-13":
                panD34.getStyleClass().remove("disc-undone"); panD34.getStyleClass().add("disc-done"); 
                txtD34.getStyleClass().remove("h5"); txtD34.getStyleClass().add("h6");
                break;  
            case "MCTA009-13":
                panD35.getStyleClass().remove("disc-undone"); panD35.getStyleClass().add("disc-done"); 
                txtD35.getStyleClass().remove("h5"); txtD35.getStyleClass().add("h6");
                break;
            case "MCTA004-13":
                panD36.getStyleClass().remove("disc-undone"); panD36.getStyleClass().add("disc-done"); 
                txtD36.getStyleClass().remove("h5"); txtD36.getStyleClass().add("h6");
                break;
            case "MCTA002-13":
                panD37.getStyleClass().remove("disc-undone"); panD37.getStyleClass().add("disc-done"); 
                txtD37.getStyleClass().remove("h5"); txtD37.getStyleClass().add("h6");
                break;
            case "MCTA027-13":
                panD38.getStyleClass().remove("disc-undone"); panD38.getStyleClass().add("disc-done"); 
                txtD38.getStyleClass().remove("h5"); txtD38.getStyleClass().add("h6");
                break;
            case "MCTA005-13":
                panD39.getStyleClass().remove("disc-undone"); panD39.getStyleClass().add("disc-done"); 
                txtD39.getStyleClass().remove("h5"); txtD39.getStyleClass().add("h6");
                break;
            case "MCTAO14-13":
                panD40.getStyleClass().remove("disc-undone"); panD40.getStyleClass().add("disc-done"); 
                txtD40.getStyleClass().remove("h5"); txtD40.getStyleClass().add("h6");
                break;
            case "MCTA022-13":
                panD41.getStyleClass().remove("disc-undone"); panD41.getStyleClass().add("disc-done"); 
                txtD41.getStyleClass().remove("h5"); txtD41.getStyleClass().add("h6");
                break;
            case "MCTA026-13":
                panD42.getStyleClass().remove("disc-undone"); panD42.getStyleClass().add("disc-done"); 
                txtD42.getStyleClass().remove("h5"); txtD42.getStyleClass().add("h6");
                break;
            case "MCTA015-13":
                panD43.getStyleClass().remove("disc-undone"); panD43.getStyleClass().add("disc-done"); 
                txtD43.getStyleClass().remove("h5"); txtD43.getStyleClass().add("h6");
                break;
            case "MCTA010-13":
                panD44.getStyleClass().remove("disc-undone"); panD44.getStyleClass().add("disc-done"); 
                txtD44.getStyleClass().remove("h5"); txtD44.getStyleClass().add("h6");
                break;
            case "BCS0002-15":
                panD45.getStyleClass().remove("disc-undone"); panD45.getStyleClass().add("disc-done"); 
                txtD45.getStyleClass().remove("h5"); txtD45.getStyleClass().add("h6");
                break;
            case "MCTA019-13":
                panD47.getStyleClass().remove("disc-undone"); panD47.getStyleClass().add("disc-done"); 
                txtD47.getStyleClass().remove("h5"); txtD47.getStyleClass().add("h6");
                break;
            case "MCTA025-13":
                panD48.getStyleClass().remove("disc-undone"); panD48.getStyleClass().add("disc-done"); 
                txtD48.getStyleClass().remove("h5"); txtD48.getStyleClass().add("h6");
                break;
            case "MCTA007-13":
                panD49.getStyleClass().remove("disc-undone"); panD49.getStyleClass().add("disc-done"); 
                txtD49.getStyleClass().remove("h5"); txtD49.getStyleClass().add("h6");
                break;
            case "MCTA016-13":
                panD50.getStyleClass().remove("disc-undone"); panD50.getStyleClass().add("disc-done"); 
                txtD50.getStyleClass().remove("h5"); txtD50.getStyleClass().add("h6");
                break;
            case "MCTA020-13":
                panD52.getStyleClass().remove("disc-undone"); panD52.getStyleClass().add("disc-done"); 
                txtD52.getStyleClass().remove("h5"); txtD52.getStyleClass().add("h6");
                break;
            case "MCTA008-13":
                panD53.getStyleClass().remove("disc-undone"); panD53.getStyleClass().add("disc-done"); 
                txtD53.getStyleClass().remove("h5"); txtD53.getStyleClass().add("h6");
                break; 
            case "MCTA017-13":
                panD54.getStyleClass().remove("disc-undone"); panD54.getStyleClass().add("disc-done"); 
                txtD54.getStyleClass().remove("h5"); txtD54.getStyleClass().add("h6");
                break; 
            case "MCTA021-13":
                panD56.getStyleClass().remove("disc-undone"); panD56.getStyleClass().add("disc-done"); 
                txtD56.getStyleClass().remove("h5"); txtD56.getStyleClass().add("h6");
                break; 
            case "MCTA023-13":
                panD57.getStyleClass().remove("disc-undone"); panD57.getStyleClass().add("disc-done"); 
                txtD57.getStyleClass().remove("h5"); txtD57.getStyleClass().add("h6");
                break;
                
            default: System.out.println("Disciplina - " + d.getNome() + " - não encontrada na grade do BCC");
            }
        }
         
        // livres
        if(totalLIVcred >= 12){
            panD46.getStyleClass().remove("disc-undone"); panD46.getStyleClass().add("disc-done");
            txtD46.getStyleClass().remove("h5"); txtD46.getStyleClass().add("h6");
            panD59.getStyleClass().remove("disc-undone"); panD59.getStyleClass().add("disc-done");
            txtD59.getStyleClass().remove("h5"); txtD59.getStyleClass().add("h6");
        }
        
        // limitadas
        if(totalLIMcred >= 30){
            panD51.getStyleClass().remove("disc-undone"); panD51.getStyleClass().add("disc-done");
            panD55.getStyleClass().remove("disc-undone"); panD55.getStyleClass().add("disc-done");
            panD58.getStyleClass().remove("disc-undone"); panD58.getStyleClass().add("disc-done");
        }     
               
    }
    
    // método para atualizar os indicadores de progresso
    public void populateProgressesIndicators(){
        
        double localLIVcred, localLIMcred;
        if(totalLIVcred > 12){
            localLIVcred = 12;
        } else {
            localLIVcred = totalLIVcred;
        }
        
        if(totalLIMcred > parcialLIM){
            localLIMcred = parcialLIM;
        } else {
            localLIMcred = totalLIMcred;
        }
        
        progressCPK.setProgress((totalOBRcred+localLIMcred+localLIVcred)/(226+parcialLIM));
        progressOBR.setProgress(totalOBRcred/214);        
        progressLIM.setProgress(localLIMcred/parcialLIM);
        progressLIV.setProgress(localLIVcred/12);
        
    }
    
    // método para adicionar uma disciplina ao histórico do aluno
    public void addDisc(ActionEvent actionEvent){
        
        // inserindo disciplina no banco de dados do usuário
        dscDAO.insertDiscToUser(Acesso.getUsuario(), dscEscolhida);
        
        // adicionando a disciplina na tableview correspondente
        populateTableFromDB(); // provisório: sobrecarregar método com otimização de leitura
        
        calculateTotalCreditsFromDB();
        
        populateProgressesIndicators();
        
        updateMatriz();
                
    }
}
