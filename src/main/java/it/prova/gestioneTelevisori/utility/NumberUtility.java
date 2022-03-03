package it.prova.gestioneTelevisori.utility;

public class NumberUtility {

	public static Integer verificaSeInteroValido(String input) {
		
		Integer valoreNumericoDaStringa = null;
		if (Integer.parseInt(input) > 0) {
			valoreNumericoDaStringa = Integer.parseInt(input);
		} else {
			return valoreNumericoDaStringa;
		}
		return valoreNumericoDaStringa;
	}

}
