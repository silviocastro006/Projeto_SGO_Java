/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util.funcoes;

/**
 *
 * @author acer
 */
public class ValidarCNPJ {
    
    public static boolean validarCNPJ(String cnpj) {
        // Remover caracteres não numéricos
        cnpj = cnpj.replaceAll("[^0-9]", "");

        // Verificar se o CNPJ tem 14 dígitos
        if (cnpj.length() != 14) {
            return false;
        }

        // Verificar se o CNPJ tem todos os dígitos iguais (exemplo: 11.111.111/1111-11)
        if (cnpj.matches("(\\d)\\1{13}")) {
            return false;
        }

        // Validar o primeiro dígito verificador
        int soma = 0;
        int peso[] = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        for (int i = 0; i < 12; i++) {
            soma += Integer.parseInt(String.valueOf(cnpj.charAt(i))) * peso[i];
        }
        int digito1 = 11 - (soma % 11);
        if (digito1 >= 10) {
            digito1 = 0;
        }

        // Validar o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 13; i++) {
            soma += Integer.parseInt(String.valueOf(cnpj.charAt(i))) * peso[i];
        }
        int digito2 = 11 - (soma % 11);
        if (digito2 >= 10) {
            digito2 = 0;
        }

        // Verificar se os dígitos verificadores são iguais aos fornecidos
        return digito1 == Integer.parseInt(String.valueOf(cnpj.charAt(12))) && digito2 == Integer.parseInt(String.valueOf(cnpj.charAt(13)));
    }
    
}
