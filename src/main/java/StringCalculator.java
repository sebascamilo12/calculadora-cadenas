import java.util.ArrayList;

public class StringCalculator {
    public int add(String valor) throws Exception { //"1,1"
        if (valor.length() > 0) {

            String delimitador = null;
            try {
                int temp = Integer.parseInt("" + valor.charAt(0));
            } catch (Exception e) {
                if (("" + valor.charAt(0)) == "-") {
                    delimitador = null;
                } else {
                    delimitador = "" + valor.charAt(0);
                }
            }

            String[] splittedList = validarDelimitador(delimitador, valor);
            ArrayList<Integer> numberList = new ArrayList<>();

            numberList = agregarNumerosLista(splittedList);


            return sumarNumerosLista(numberList);
        }
        return 0;
    }

    String[] validarDelimitador(String delimitador, String valor) {
        String[] splittedList = null;
        if (delimitador != null) {
            return splittedList = valor.substring(1, valor.length()).split(delimitador);
        } else {
            return splittedList = valor.split("[,|\n]");
        }
    }

    ArrayList<Integer> agregarNumerosLista(String[] splittedList) throws Exception {

        ArrayList<Integer> numberList = new ArrayList<>();
        for (String element : splittedList) {
            int tempValue = Integer.parseInt(element);
            if (tempValue < 0) {
                throw new Exception("NegativeNumberException");
            }
            if (tempValue > 1000) {
                continue;
            }
            numberList.add(tempValue);
        }

        return numberList;

    }

    Integer sumarNumerosLista(ArrayList<Integer> numberList){
        int acumulador = 0;
        for (Integer number : numberList) {
            acumulador += number;
        }
        return acumulador;
    }
}
