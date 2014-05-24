package com.exemple.ecommerce.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Manage connection with database
 * @author L4ngu0r
 *
 */
public class Connexion {

	private String url;
	private String login;
	private String mdp;
	private String driver;
	private Connection connex;
	
	/**
	 * Constructor of class Connexion
	 *  
	 * @param url database url
	 * @param login database login
	 * @param mdp databse password
	 * @param driver database java package driver
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Connexion(String url,String login,String mdp,String driver) throws ClassNotFoundException, SQLException{
		this.url = url;
		this.login = login;
		this.mdp = mdp;
		this.driver = driver;
		Class.forName(driver);
		connex = DriverManager.getConnection(url, login, mdp);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public Connection getConnex() {
		return connex;
	}

	public void setConnex(Connection connex) {
		this.connex = connex;
	}
}
