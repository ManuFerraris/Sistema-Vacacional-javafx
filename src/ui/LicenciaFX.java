package src.ui;

import src.util.Navegador;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LicenciaFX extends Application {

    String nombre = "";

    @Override
    public void start(Stage stage) {

        if (BienvenidaFX.nombreUsuario != null) {
            nombre = BienvenidaFX.nombreUsuario;
        } else {
            nombre = "Usuario";
        }

        VBox root = new VBox(15);
        root.getStyleClass().add("root");
        root.setAlignment(Pos.CENTER);

        VBox form = new VBox(15);
        form.setSpacing(20);
        form.setMinWidth(400);
        form.getStyleClass().add("form-container");
        form.setAlignment(Pos.CENTER_LEFT);

        Label label = new Label("TERMINOS Y CONDICIONES");
        label.getStyleClass().add("titulo-licencia");

        TextArea areaLicencia = new TextArea(
                "\n\n          TERMINOS Y CONDICIONES" +
                        "\n\n          A. PROHIBIDA SU VENTA O DISTRUBICION SIN AUTORIZACON DE MANUEL FERRARIS." +
                        "\n          B.  PROHIBIDA LA ALTERACION DEL CODIGO FUENTE O DISEñO DE LAS INTERFACES GRAFICAS."
                        +
                        "\n          C. MANUEL FERRARIS NO SE HACE RESPONSABLE DEL MAL USO QUE USTED HAGA DE ESTE SOFTWARE."
                        +
                        "\n\n          LOS ACUERDOS LEGALES EXPUESTOS A CONTICUACION RIGEN EL USO QUE USTED HAGA DE ESTE SOFTWARE"
                        +
                        "\n          (EL AUTOR MANUEL FERRARIS), NO SE RESPONSABILIZA DEL USO QU USTED" +
                        "\n          HAGA CON ESTA SOFTWARE Y SUS SERVICIOS. PARA ACEPTAR LOS TERMINOS HAGA CLIC EN (ACEPTO)"
                        +
                        "\n          SI USTED NO ACEPTA ESTOS TERMINOS, HAGA CLIC EN (NO ACEPTO) Y NO UTILICE ESTE SOFTWARE."
                        +
                        "\n\n          PARA MAYOR INFORMACION SOBRE NUESTROS PRODUCTOS O SERVICIOS. POR FAVOR VISITE" +
                        "\n          www.miPerfilDeLinkedin");
        VBox.setVgrow(areaLicencia, javafx.scene.layout.Priority.ALWAYS);
        areaLicencia.setEditable(false);
        areaLicencia.setWrapText(true);
        areaLicencia.setPrefSize(600, 350);
        areaLicencia.setMinSize(600, 350);

        CheckBox checkAcepto = new CheckBox("Yo " + nombre + " acepto los términos.");

        Button btnContinuar = new Button("Continuar");
        Button btnNoAcepto = new Button("No Acepto");

        // BINDING
        btnContinuar.disableProperty().bind(checkAcepto.selectedProperty().not());

        btnContinuar.setOnAction(e -> {
            try {
                PrincipalFX principal = new PrincipalFX();
                principal.start(stage);
            } catch (Exception ex) {
                Navegador.mostrarAlerta("Error al pasar a principal", "No se puede pasar a la pagina principal",
                        Alert.AlertType.ERROR);
            }
        });

        btnNoAcepto.setOnAction(e -> {
            BienvenidaFX back = new BienvenidaFX();
            try {
                back.start(stage);
            } catch (Exception ex) {
            }
        });

        form.getChildren().addAll(label, areaLicencia, checkAcepto, btnContinuar, btnNoAcepto);
        root.getChildren().addAll(Navegador.obtenerLogo(this), form);

        Scene escena = new Scene(root);
        form.setMinWidth(650);
        form.setPrefHeight(500);
        Navegador.configurarYMostrar(stage, escena, "Terminos y Condiciones", 800, 720);

    }

    public static void main(String[] args) {
        launch(args);
    }
}