package util.funcoes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
        
public class ValidadorData {
     public static boolean validarData(String data) {
        // Verifica se a data está no formato correto (dd/MM/yyyy)
        if (data == null || !data.matches("^([0-2][0-9]|3[01])/(0[1-9]|1[0-2])/[0-9]{4}$")) {
            return false;
        }

        // Define o formato esperado para a data
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);  // Impede que datas inválidas sejam aceitas (por exemplo, 32/13/2024)

        try {
            // Tenta fazer o parsing da data
            format.parse(data);
            return true;
        } catch (ParseException e) {
            // Se ocorrer um erro ao tentar fazer o parsing, a data é inválida
            return false;
        }
    }
}
