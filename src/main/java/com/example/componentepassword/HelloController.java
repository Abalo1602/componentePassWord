package com.example.componentepassword;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Clase HelloController.java donde manejamos el componente.
 * @author Roberto Abalo Rodr&iacute;guez
 */
public class HelloController {

    @FXML
    private Button btnAceptar;

    @FXML
    private Label labelText;

    @FXML
    private PasswordField etPassword;

    /**
     * Metodo donde implementamos el patron a comprobar por nuestro componente.
     * Tambien aqui controlamos la apariencia de nuestro componente segun si esta
     * correcto el password o no. Y habilitamos el boton dependiendo de si el
     * password es valido o no.
     */
    @FXML
    void comprobarPatron() {
        /* Cada vez que hacemos una pulsación de teclado comprobamos si se cumple el patrón.
         *  El patrón nos obliga a introducir una cadena de entre 8 y 16 caracteres, al menos un número,
         *  al menos una letra minuscula, al menos una letra mayuscula y un caracter especial !"#$%&'()*<=>?@ */
        String patron = "^(?=.*\\d)(?=.*[\\u0021-\\u002b\\u003c-\\u0040])(?=.*[A-Z])(?=.*[a-z])\\S{8,16}$";

        Pattern pat = Pattern.compile(patron);
        Matcher mat = pat.matcher(etPassword.getText());

        System.out.println("Pulsacion");

        if (mat.matches()){
            etPassword.setStyle("-fx-background-color:green;");
            labelText.setText("Tu contraseña cumple con las condiciones.");
            btnAceptar.setDisable(false);
        }else{
            etPassword.setStyle("-fx-background-color:red;");
            labelText.setText("Aun no cumples con las conciones");
            btnAceptar.setDisable(true);
        }

    }

    /**
     * Aqui controlamos el evento en el boton y cambiamos el aspecto del label.
     */
    @FXML
    void onAceptarButtonClick(ActionEvent event) {
        labelText.setText("Contraseña registrada");
        labelText.setStyle("-fx-text-fill: green;-fx-font-size: 16px;");
    }

    @FXML
    void pfPassword(ActionEvent event) {

    }

}