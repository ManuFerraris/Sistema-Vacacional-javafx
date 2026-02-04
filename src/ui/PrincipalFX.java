package src.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import src.logica.*;
import src.util.Navegador;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;

public class PrincipalFX extends Application {

    @Override
    public void start(Stage stage) {

        VBox root = new VBox(0);
        root.getStyleClass().add("root-principal");
        root.setPadding(Insets.EMPTY);
        root.setAlignment(Pos.TOP_CENTER);

        // Menu
        MenuBar menuBar = new MenuBar();
        Menu menuOpciones = new Menu("Opciones");
        Menu menuAcercaDe = new Menu("Acerca de");
        MenuItem itemNuevo = new MenuItem("Nuevo (Limpiar)");
        MenuItem itemSalir = new MenuItem("Salir");
        MenuItem itemCreador = new MenuItem("El creador");
        menuOpciones.getItems().addAll(itemNuevo, itemSalir);
        menuAcercaDe.getItems().addAll(itemCreador);
        menuBar.getMenus().addAll(menuOpciones, menuAcercaDe);

        // Formulario
        VBox formContainer = new VBox(15);
        formContainer.getStyleClass().add("form-container");
        formContainer.setAlignment(Pos.CENTER);
        formContainer.setPadding(new Insets(20));
        formContainer.setMaxWidth(900);

        ImageView logoEncabezado = Navegador.obtenerLogo(this);
        logoEncabezado.setFitWidth(200);

        // Saludo
        String usuario = BienvenidaFX.nombreUsuario;
        if (BienvenidaFX.nombreUsuario.equals("")) {
            usuario = "Invitado de Prueba";
        }
        Label lblBienvenida = new Label("Bienvenido " + usuario);
        lblBienvenida.setStyle(
                "-fx-font-size: 26px; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-family: 'Andale Mono';");

        VBox contenedorLogoSaludo = new VBox(0);
        contenedorLogoSaludo.setAlignment(Pos.CENTER);
        VBox.setMargin(contenedorLogoSaludo, new Insets(0, 0, 10, 0));

        contenedorLogoSaludo.getChildren().addAll(logoEncabezado, lblBienvenida);

        // Nombre
        Label nombreLabel = new Label("Ingrese el nombre completo:");
        TextField nombreTxt = new TextField();
        nombreTxt.setPrefWidth(300);

        // Apellido
        Label apellidoLabel = new Label("Ingrese el/los apellido/s:");
        TextField apellidoTxt = new TextField();
        apellidoTxt.setPrefWidth(300);

        // Grid
        GridPane grid = new GridPane();
        grid.setHgap(30);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);

        grid.add(nombreLabel, 0, 0);
        grid.add(nombreTxt, 0, 1);

        grid.add(apellidoLabel, 0, 2);
        grid.add(apellidoTxt, 0, 3);

        // Departamento
        Label comboDeptoLabel = new Label("Seleccione el departamento:");
        ComboBox<String> comboDepto = new ComboBox<>();
        comboDepto.getItems().addAll("Atención al Cliente", "Logística", "Gerencia");
        comboDepto.setPrefWidth(300);

        // Antiguedad
        Label comboAntiguedadLabel = new Label("Seleccione el departamento:");
        ComboBox<String> comboAntiguedad = new ComboBox<>();
        comboAntiguedad.getItems().addAll("1 año de antigüedad", "2 a 6 años de antiguedad",
                "Más de 7 años de antigüedad");
        comboAntiguedad.setPrefWidth(300);

        grid.add(comboDeptoLabel, 1, 0);
        grid.add(comboDepto, 1, 1);

        grid.add(comboAntiguedadLabel, 1, 2);
        grid.add(comboAntiguedad, 1, 3);

        // Resultado
        Label lblResultado = new Label("Resultado del Cálculo:");
        TextArea txtResultado = new TextArea("Aqui aparecerá el resultado...");
        txtResultado.setEditable(false);
        txtResultado.setMinHeight(150);
        txtResultado.setPrefHeight(250);
        txtResultado.setWrapText(true);
        txtResultado.setStyle("-fx-font-family: 'Consolas'; -fx-font-size: 15px;");
        VBox.setVgrow(txtResultado, javafx.scene.layout.Priority.ALWAYS);

        // Boton
        Button btnCalcular = new Button("Calcular Vacaciones");
        btnCalcular.setPrefWidth(400);

        // Ensamblaje
        formContainer.getChildren().addAll(lblBienvenida, grid, btnCalcular, lblResultado, txtResultado);

        // Scroll de prueba
        ScrollPane scroll = new ScrollPane(formContainer);
        scroll.setFitToWidth(true);
        scroll.setPannable(true);
        scroll.setStyle("-fx-background: transparent; -fx-background-color: transparent;");
        VBox.setMargin(scroll, new Insets(20, 50, 20, 50));

        root.getChildren().addAll(menuBar, contenedorLogoSaludo, scroll);

        // --- Logica ---
        itemSalir.setOnAction(e -> stage.close());
        itemCreador.setOnAction(e -> Navegador.mostrarAlerta("Creador", "Sistema desarrollado por Manuel Ferraris",
                Alert.AlertType.INFORMATION));
        itemNuevo.setOnAction(e -> {
            nombreTxt.clear();
            apellidoTxt.clear();
            comboDepto.setValue(null);
            comboAntiguedad.setValue(null);
            txtResultado.setText("Aquí aparecerá el resultado...");
        });

        btnCalcular.setOnAction(e -> {
            String nombreCompleto = nombreTxt.getText();
            String apellidos = apellidoTxt.getText();
            String antiTxt = comboAntiguedad.getValue();
            String depto = comboDepto.getValue();

            if (nombreCompleto.isEmpty() || apellidos.isEmpty() || depto == null || antiTxt == null) {
                Navegador.mostrarAlerta("Error", "Por favor completa todos los campos", Alert.AlertType.ERROR);
            } else {
                int antiguedadNum = 0;
                if (antiTxt.equals("1 año de antigüedad"))
                    antiguedadNum = 1;
                else if (antiTxt.equals("2 a 6 años de antiguedad"))
                    antiguedadNum = 2;
                else
                    antiguedadNum = 7;

                Empleado empleado;

                if (depto.equals("Atención al Cliente")) {
                    empleado = new AtencionAlCliente(nombreCompleto, apellidos);
                } else if (depto.equals("Logística")) {
                    empleado = new Logistica(nombreCompleto, apellidos);
                } else {
                    empleado = new Gerente(nombreCompleto, apellidos);
                }

                int dias = empleado.obtenerDiasVacaciones(antiguedadNum);
                txtResultado.setText("\n  >>> RESULTADO DEL CÁLCULO <<<\n" +
                        "  -----------------------------\n" +
                        "\n El trabajador " + nombreCompleto + " " + apellidos +
                        "\n quien labora en " + depto +
                        "\n con " + antiTxt +
                        "\n recibe " + dias + " días de vacaciones.");
            }
        });

        Scene escena = new Scene(root);
        Navegador.configurarYMostrar(stage, escena, "Calculadora Vacacional", 1000, 720);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
