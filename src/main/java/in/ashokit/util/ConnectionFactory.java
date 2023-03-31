package in.ashokit.util;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {
	
private static DataSource ds=null;

public static Connection getConnection() throws Exception{
	
	if(ds == null) {
	FileInputStream fis=new FileInputStream("D:\\corejava\\BookProject\\dbconfig.properties");
	Properties p=new Properties();
	p.load(fis);
	
	String url= p.getProperty("db.url");
	String uname = p.getProperty("db.username");
	String pwd= p.getProperty("db.password");
	
	
	HikariConfig config=new HikariConfig();
	config.setUsername(uname);
	config.setPassword(pwd);
	config.setJdbcUrl(url);
	
	ds=new HikariDataSource(config);
	}
	Connection con = ds.getConnection();
	return con;

	
}
}
