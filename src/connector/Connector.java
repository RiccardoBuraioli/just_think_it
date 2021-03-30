package connector;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class Connector {
	
		    private  String host;
		    private  String user;
		    private  String password;

		    public Connector(String host, String user, String password) {
		        this.host = host;
		        this.user = user;
		        this.password = password;
		    }

		    //tipo di ritorno: Connection.class obj
		    public Connection getConnection() throws SQLException {
		        return DriverManager.getConnection(host, user, password);
		      
		    }

		}
	