import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;


public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<String> lista = new ArrayList<String>();
		
		String url = "jdbc:postgresql://localhost/JAVANES";
		String user = "postgres";
		String password = "senacrs";
		
		try {
			con = DriverManager.getConnection(url,user,password);
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM teste");
			
			//st.executeUpdate("INSERT INTO teste (id, nome) VALUES (nextval('teste_seq'),'Ezequiel')");
			
			//String proc = "{call TesteInsert(?)}";
			//CallableStatement cs = con.prepareCall(proc);
			//cs.setString(1, "Ezequiel");
			//cs.executeUpdate();

			while (rs.next()) {
				lista.add(rs.getString(1).trim());
			}
			
			JOptionPane.showMessageDialog(null, lista);

		} catch (SQLException e) {
			// TODO: handle exception
			Logger lgr = Logger.getLogger(Principal.class.getName());
			lgr.log(Level.SEVERE, e.getMessage(),e);
		} finally{
			try{
				if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }//

			}
			catch (SQLException ex) {
				// TODO: handle exception
				Logger lgr = Logger.getLogger(Principal.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
			} 
		}
	}

}
