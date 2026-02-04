package src.util;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.InputStream;
import java.net.URL;
import javafx.scene.image.ImageView;

public class Navegador {

    // Metodo estatico para cambiar la ventana facilmente
    public static void configurarYMostrar(Stage stage, Scene escena, String titulo, double ancho, double alto) {
        stage.setTitle(titulo);
        stage.setScene(escena);
        stage.setWidth(ancho);
        stage.setHeight(alto);
        stage.setResizable(false); // Evita que el usuario la deforme.
        stage.centerOnScreen(); // para que no aparezca en la esquina.

        InputStream iconStream = Navegador.class.getResourceAsStream("/src/ui/images/icon.png");
        if (iconStream != null) {
            stage.getIcons().add(new Image(iconStream));
        }

        String rutaCSS = "/src/ui/styles/style.css";
        URL cssURL = Navegador.class.getResource(rutaCSS);
        if (cssURL != null) {
            escena.getStylesheets().add(cssURL.toExternalForm());
        } else {
            System.out.println("Navegador: No se pudo aplicar el CSS desde " + rutaCSS);
        }

        stage.show();
    }

    public static void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null); // Quitamos la cabecera por defecto para que sea más limpio
        alerta.setContentText(mensaje);

        // VINCULAR EL CSS A LA ALERTA
        // Obtenemos el panel de la alerta y le añadimos la hoja de estilos
        DialogPane dialogPane = alerta.getDialogPane();
        String rutaCSS = "/src/ui/styles/style.css"; // Usa la misma ruta que en configurarYMostrar
        URL cssURL = Navegador.class.getResource(rutaCSS);

        if (cssURL != null) {
            dialogPane.getStylesheets().add(cssURL.toExternalForm());
            // Aplicamos una clase específica si queremos
            dialogPane.getStyleClass().add("my-alert");
        }

        alerta.show();
    }

    public static ImageView obtenerLogo(Object contexto) {
        ImageView logoView = new ImageView();
        InputStream logoStream = contexto.getClass().getResourceAsStream("/src/ui/images/logo-coca.png");
        if (logoStream != null) {
            logoView.setImage(new Image(logoStream));
            logoView.setFitWidth(150);
            logoView.setPreserveRatio(true);
        }
        return logoView;
    }
}