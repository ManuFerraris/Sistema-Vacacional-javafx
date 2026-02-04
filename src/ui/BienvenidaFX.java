package src.ui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import src.util.Navegador;

public class BienvenidaFX extends Application {

    public static String nombreUsuario = "";

    @Override
    public void start(Stage stage) {

        VBox root = new VBox(15);
        root.getStyleClass().add("root");
        root.setAlignment(Pos.CENTER);

        VBox form = new VBox(15);
        form.setSpacing(20);
        form.setMinWidth(400);
        form.getStyleClass().add("form-container");
        form.setAlignment(Pos.CENTER_LEFT);

        Label label = new Label("Bienvenido al sistema Coca-Cola");
        String tipoUser = LoginCSS.tipoUsuario;
        Label labelNombre = new Label(tipoUser + " ingrese su nombre: ");
        TextField txtNombre = new TextField();

        Button btnContinuar = new Button("Ingresar");
        btnContinuar.setPrefWidth(400);
        Button btnRegresar = new Button("Regresar");
        btnRegresar.setPrefWidth(400);
        btnRegresar.setOnAction(e -> {
            LoginCSS back = new LoginCSS();
            try {
                back.start(stage);
            } catch (Exception ex) {
            }
        });

        btnContinuar.setOnAction(e -> {
            BienvenidaFX.nombreUsuario = txtNombre.getText();
            LicenciaFX continuar = new LicenciaFX();
            try {
                continuar.start(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        form.getChildren().addAll(label, labelNombre, txtNombre, btnContinuar, btnRegresar);
        root.getChildren().addAll(Navegador.obtenerLogo(this), form);

        Scene escena = new Scene(root);
        Navegador.configurarYMostrar(stage, escena, "Sistema Vacacional Coca-Cola 2026", 500, 450);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
