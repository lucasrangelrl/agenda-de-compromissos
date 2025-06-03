import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import utils.ArquivoUtils;
import view.AgendaView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Agenda de Compromissos");
        AgendaView agendaView = new AgendaView();
        Scene scene = new Scene(agendaView.criarTela(), 500, 400);
        primaryStage.setScene(scene);

        // Evento para salvar quando fechar a janela
        primaryStage.setOnCloseRequest((WindowEvent event) -> {
            ArquivoUtils.salvar(agendaView.getCompromissos());
        });

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
