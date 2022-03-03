package it.prova.gestioneTelevisori.dao;

import it.prova.gestioneTelevisori.dao.televisore.TelevisoreDAO;
import it.prova.gestioneTelevisori.dao.televisore.TelevisoreDAOImpl;

public class MyDaoFactory {

	private static TelevisoreDAO TELEVISORE_DAO_INSTANCE = null;

	public static TelevisoreDAO getTelevisoreDAOInstance() {
		if (TELEVISORE_DAO_INSTANCE == null)
			TELEVISORE_DAO_INSTANCE = new TelevisoreDAOImpl();

		return TELEVISORE_DAO_INSTANCE;
	}

}
