import java.sql.Date;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ReservaUI extends Application {
    private TextField valorField;
    private DatePicker dataEntradaPicker;
    private DatePicker dataSaidaPicker;
    private Button adicionarButton;

    @Override
    public void start(Stage primaryStage) {
        
        valorField = new TextField();
        valorField.setPromptText("Valor da Reserva");
        dataEntradaPicker = new DatePicker();
        dataEntradaPicker.setPromptText("Data de Entrada");
        dataSaidaPicker = new DatePicker();
        dataSaidaPicker.setPromptText("Data de Saída");
        adicionarButton = new Button("Adicionar Reserva");

        
        adicionarButton.setOnAction(e -> adicionarReserva());

        
        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(valorField, dataEntradaPicker, dataSaidaPicker, adicionarButton);

        
        Scene scene = new Scene(vbox, 300, 200);

       
        primaryStage.setTitle("Sistema de Reservas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void adicionarReserva() {
        
        double valor = Double.parseDouble(valorField.getText());
        String dataEntrada = dataEntradaPicker.getValue().toString();
        String dataSaida = dataSaidaPicker.getValue().toString();

        
        Reserva reserva = new Reserva(Date.valueOf(dataEntrada), Date.valueOf(dataSaida), valor, "Forma de Pagamento");
        DatabaseManager dbManager = new DatabaseManager();
        dbManager.adicionarReserva(reserva);

        
        valorField.clear();
        dataEntradaPicker.getEditor().clear();
        dataSaidaPicker.getEditor().clear();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
