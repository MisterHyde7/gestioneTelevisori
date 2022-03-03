package it.prova.gestioneTelevisori.service;

import it.prova.gestioneTelevisori.dao.MyDaoFactory;
import it.prova.gestioneTelevisori.service.televisore.TelevisoreService;
import it.prova.gestioneTelevisori.service.televisore.TelevisoreServiceImpl;

public class MyServiceFactory {
	// rendiamo questo factory SINGLETON
	private static TelevisoreService TELEVISORE_SERVICE_INSTANCE;

	public static TelevisoreService getTelevisoreServiceInstance() {
		if (TELEVISORE_SERVICE_INSTANCE == null)
			TELEVISORE_SERVICE_INSTANCE = new TelevisoreServiceImpl();

		TELEVISORE_SERVICE_INSTANCE.setTelevisoreDAO(MyDaoFactory.getTelevisoreDAOInstance());

		return TELEVISORE_SERVICE_INSTANCE;
	}
}
