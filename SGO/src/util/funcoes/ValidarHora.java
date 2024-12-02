/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util.funcoes;

/**
 *
 * @author acer
 */
public class ValidarHora {
    public static boolean validarHora(String hora) {
        // Verificar se o formato da hora está correto (HH:mm)
        if (hora == null || !hora.matches("^([01][0-9]|2[0-3]):([0-5][0-9])$")) {
            return false;
        }

        // Dividir a hora e os minutos
        String[] partes = hora.split(":");
        int horaInt = Integer.parseInt(partes[0]);
        int minutoInt = Integer.parseInt(partes[1]);

        // Validar se a hora e os minutos estão dentro dos limites
        return horaInt >= 0 && horaInt <= 23 && minutoInt >= 0 && minutoInt <= 59;
    }
}
