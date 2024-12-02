/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util.funcoes;

/**
 *
 * @author acer
 */
public class ValidadorEmail {
    // Método para validar o e-mail
    public static boolean validarEmail(String email) {
        // Verifica se o e-mail contém um '@' e um '.'
        return email.contains("@") && email.contains(".");
    }
}
