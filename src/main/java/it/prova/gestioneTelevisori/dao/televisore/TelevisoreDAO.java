package it.prova.gestioneTelevisori.dao.televisore;

import java.sql.Connection;

import it.prova.gestioneTelevisori.dao.IBaseDAO;
import it.prova.gestioneTelevisori.model.Televisore;

public interface TelevisoreDAO extends IBaseDAO<Televisore> {
	public void setConnection(Connection connection);
}
