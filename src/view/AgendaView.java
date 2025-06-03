package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.Compromisso;
import utils.ArquivoUtils;

public class AgendaView {
    private ObservableList<Compromisso> compromissos;

    public AgendaView() {
        compromissos = FXCollections.observableArrayList();
        compromissos.addAll(ArquivoUtils.carregar());  
    }

    public ObservableList<Compromisso> getCompromissos() {
        return compromissos;
    }

    public BorderPane criarTela() {
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(20)); 

        ListView<Compromisso> listView = new ListView<>(compromissos);
        pane.setCenter(listView);

        GridPane form = new GridPane();
        form.setHgap(15);  
        form.setVgap(15);  
        form.setPadding(new Insets(15)); 
        form.setAlignment(Pos.CENTER_LEFT);

        String estiloCampos = "-fx-background-radius: 8; " +
                              "-fx-border-radius: 8; " +
                              "-fx-border-color: #cccccc; " +
                              "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 4, 0.5, 0, 2);";

        TextField tituloField = new TextField();
        tituloField.setPromptText("Digite o título");
        tituloField.setStyle(estiloCampos);

        TextField descricaoField = new TextField();
        descricaoField.setPromptText("Descrição breve");
        descricaoField.setStyle(estiloCampos);

        DatePicker dataPicker = new DatePicker();
        dataPicker.setPromptText("Selecione a data");
        dataPicker.setStyle(estiloCampos);

        TextField horaField = new TextField();
        horaField.setPromptText("Ex: 10:30");
        horaField.setStyle(estiloCampos);

        form.add(new Label("Título:"), 0, 0);
        form.add(tituloField, 1, 0);
        form.add(new Label("Descrição:"), 0, 1);
        form.add(descricaoField, 1, 1);
        form.add(new Label("Data:"), 0, 2);
        form.add(dataPicker, 1, 2);
        form.add(new Label("Hora (HH:mm):"), 0, 3);
        form.add(horaField, 1, 3);

        Button btnAdicionar = new Button("Adicionar");
        btnAdicionar.setStyle("-fx-background-radius: 8; -fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold;");
        btnAdicionar.setPrefWidth(100);

        Button btnRemover = new Button("Remover Selecionado");
        btnRemover.setStyle("-fx-background-radius: 8; -fx-background-color: #f44336; -fx-text-fill: white; -fx-font-weight: bold;");
        btnRemover.setPrefWidth(150);

        HBox botoes = new HBox(15, btnAdicionar, btnRemover); // espaço maior entre botões
        botoes.setPadding(new Insets(10, 0, 0, 0));
        form.add(botoes, 1, 4);

        pane.setBottom(form);

        btnAdicionar.setOnAction(e -> {
            String titulo = tituloField.getText().trim();
            String descricao = descricaoField.getText().trim();
            String data = dataPicker.getValue() != null ? dataPicker.getValue().toString() : "";
            String hora = horaField.getText().trim();

            if (titulo.isEmpty() || data.isEmpty() || hora.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Aviso");
                alert.setHeaderText(null);
                alert.setContentText("Título, Data e Hora são obrigatórios!");
                alert.showAndWait();
                return;
            }

            if (!hora.matches("^\\d{2}:\\d{2}$")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText(null);
                alert.setContentText("Hora inválida! Use o formato HH:mm.");
                alert.showAndWait();
                return;
            }

            Compromisso c = new Compromisso(titulo, descricao, data, hora);
            compromissos.add(c);

            ArquivoUtils.salvar(compromissos);  

            tituloField.clear();
            descricaoField.clear();
            dataPicker.setValue(null);
            horaField.clear();

            Alert sucesso = new Alert(Alert.AlertType.INFORMATION);
            sucesso.setTitle("Sucesso");
            sucesso.setHeaderText(null);
            sucesso.setContentText("Compromisso adicionado!");
            sucesso.showAndWait();
        });

        btnRemover.setOnAction(e -> {
            Compromisso selecionado = listView.getSelectionModel().getSelectedItem();
            if (selecionado != null) {
                Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
                confirm.setTitle("Confirmação");
                confirm.setHeaderText(null);
                confirm.setContentText("Deseja realmente remover este compromisso?");

                confirm.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        compromissos.remove(selecionado);
                        ArquivoUtils.salvar(compromissos);  

                        Alert sucesso = new Alert(Alert.AlertType.INFORMATION);
                        sucesso.setTitle("Sucesso");
                        sucesso.setHeaderText(null);
                        sucesso.setContentText("Compromisso removido!");
                        sucesso.showAndWait();
                    }
                });
            }
        });

        return pane;
    }
}
