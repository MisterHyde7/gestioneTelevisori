package it.prova.gestioneTelevisori.dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import it.prova.gestioneTelevisori.model.Televisore;

public class DB_Mock {
	public static final List<Televisore> LISTA_TELEVISORI = new ArrayList<>();

	static {
		// preparo una lista mock perché ancora non ho il collegamento alla
		// base dati
		LISTA_TELEVISORI.add(new Televisore("philips", "pus43", 400, 48, "pus43y"));
		LISTA_TELEVISORI.add(new Televisore("hisense", "sense8", 200, 30, "sen8"));
		LISTA_TELEVISORI.add(new Televisore("samsung", "sam77", 300, 20, "samuel7"));
		LISTA_TELEVISORI.add(new Televisore("lg", "legible", 100, 14, "cheap"));
		LISTA_TELEVISORI.add(new Televisore("toshiba", "jap99", 250, 40, "jappy"));
		LISTA_TELEVISORI.add(new Televisore("dell", "linear", 175, 28, "linear7"));
		LISTA_TELEVISORI.add(new Televisore("lenovo", "legion", 225, 23, "legionario"));
		LISTA_TELEVISORI.add(new Televisore("hp", "heartpulse", 325, 70, "heartfull"));
	}

	public static Long getNexIdAvailable() {
		Long resultId = null;
		if (LISTA_TELEVISORI == null || LISTA_TELEVISORI.isEmpty()) {
			resultId = 1L;
		}
		resultId = LISTA_TELEVISORI.stream().max(Comparator.comparing(Televisore::getId)).get().getId();
		return ++resultId;
	}

}
