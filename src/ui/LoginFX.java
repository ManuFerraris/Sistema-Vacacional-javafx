package src.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginFX extends Application {
    @Override
    public void start(Stage stage) {
        // Contenedor tipo Rejilla (Grid)
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25));
        grid.setStyle("-fx-background-color: #2c3e50;");

        // Componentes
        Label lblUser = new Label("Admin Password:");
        lblUser.setStyle("-fx-text-fill: white; -fx-font-family: 'Andale Mono';");
        grid.add(lblUser, 0, 0); // Columna 0, Fila 0

        PasswordField txtPass = new PasswordField();
        grid.add(txtPass, 1, 0);

        Button btnLogin = new Button("Log In");
        btnLogin.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white;");
        grid.add(btnLogin, 1, 1);

        // Evento con logica
        btnLogin.setOnAction(e -> {
            if (txtPass.getText().equals("cocacola2026")) {
                System.out.println("Acceso concedido");
                // Aca agrego logica de la siguiente ventana
            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error");
                alerta.setContentText("Clave Incorrecta");
                alerta.show();
            }
        });

        Scene scene = new Scene(grid, 400, 250);
        stage.setTitle("Seguridad Coca-Cola");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
