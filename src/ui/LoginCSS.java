package src.ui;

import src.util.Navegador;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginCSS extends Application {

    private final String ADMIN_PASS = "cocacola2026";
    private final String MANAGER_PASS = "gerente2026";
    public static String tipoUsuario = "";

    @Override
    public void start(Stage stage) {

        // Contenedor principal (Layout)
        VBox root = new VBox(10);
        root.getStyleClass().add("root");
        root.setAlignment(Pos.CENTER);

        // Contenedor del formulario
        VBox form = new VBox(15);
        form.setSpacing(20);
        form.setMinWidth(400);
        form.getStyleClass().add("form-container");
        form.setAlignment(Pos.CENTER_LEFT); // Etiquetas a la izquierda

        Label lblLogin = new Label("Ingrese su Password:");
        PasswordField txtPass = new PasswordField();

        ComboBox<String> comboRol = new ComboBox<>();
        comboRol.setPromptText("Seleccine su rol:");
        comboRol.getItems().addAll("Seleccione su rol...", "Administrador", "Gerente");
        comboRol.setMaxWidth(Double.MAX_VALUE);

        Button btnLogin = new Button("Entrar");
        btnLogin.setPrefWidth(400);
        VBox.setMargin(btnLogin, new javafx.geometry.Insets(10, 0, 0, 0)); // Centramos solo el botón

        // Armado de la estructura (Scene Graph)
        form.getChildren().addAll(comboRol, lblLogin, txtPass, btnLogin);
        root.getChildren().addAll(Navegador.obtenerLogo(this), form);

        btnLogin.setOnAction(e -> {
            String rolSeleccionado = comboRol.getValue();
            String passwordIngresada = txtPass.getText();

            if (rolSeleccionado == null || rolSeleccionado.equals("Seleccione su rol...")) {
                Navegador.mostrarAlerta("Atencion", "Por favor, seleccione un rol antes de continuar.",
                        Alert.AlertType.WARNING);
                return;
            }
            if ((rolSeleccionado.equals("Administrador") && passwordIngresada.equals(ADMIN_PASS)) ||
                    (rolSeleccionado.equals("Gerente") && passwordIngresada.equals(MANAGER_PASS))) {
                LoginCSS.tipoUsuario = rolSeleccionado;
                BienvenidaFX bienvenida = new BienvenidaFX();
                try {
                    bienvenida.start(stage);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                Navegador.mostrarAlerta("Error", "Password incorrecta", Alert.AlertType.ERROR);
            }
        });

        Scene scene = new Scene(root);
        Navegador.configurarYMostrar(stage, scene, "Coca-Cola Login", 400, 550);
    }

    public static void main(String args[]) {
        launch(args);
    }
}