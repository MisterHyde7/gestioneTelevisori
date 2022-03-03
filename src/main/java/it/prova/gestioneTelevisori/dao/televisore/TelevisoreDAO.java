package it.prova.gestioneTelevisori.dao.televisore;

import java.sql.Connection;
import java.util.List;

import it.prova.gestioneTelevisori.dao.IBaseDAO;
import it.prova.gestioneTelevisori.model.Televisore;

public interface TelevisoreDAO extends IBaseDAO<Televisore> {
	
	public void setConnection(Connection connection);

	public List<Televisore> findByExample(Televisore televisoreInput) throws Exception;
}
