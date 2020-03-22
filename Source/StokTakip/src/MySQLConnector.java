

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class MySQLConnector {
	
	
	public static Connection connection;
	private String username, pw;
	
	public MySQLConnector() {
		
	}
	
	public boolean Login(String username, String pw, JLabel lblInfo) {
		this.username = username;
		this.pw = pw;
		if(UsernameExists(username)) {
			PreparedStatement state = null;
			ResultSet result = null;
			try {
				OpenCloseConnection(true);
				state = connection.prepareStatement("select PersonelId from personel where PersonelUsername = ? and PersonelPassword = ?");
				state.setString(1, username);
				state.setString(2, new String(pw));
				result = state.executeQuery();
				if(result.next()) {
					// STATIC KULLANICI SINIFINI AYARLA
					lblInfo.setText("Bulundu");
					return true;
				}else {
					lblInfo.setText("Sifreniz yanlis.");
					return false;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
				
			}finally {
				OpenCloseConnection(false);
				try {
					state.close();
					result.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				
			}
		}else {
			lblInfo.setText("Kullanici adi bulunamadi.");
			return false;
		}
		
	}
	
	public boolean UsernameExists(String username) {
		PreparedStatement state = null;
		ResultSet result = null;
		try {
			OpenCloseConnection(true);
			state = connection.prepareStatement("select PersonelId from personel where PersonelUsername = ?");
			state.setString(1, username);
			result = state.executeQuery();
			if(result.next()) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			OpenCloseConnection(false);
			try {
				state.close();
				result.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}// USERNAME EXISTS

	
	
	public static void OpenCloseConnection(boolean tf) {
		if(tf) {
			try {
				connection = DriverManager.getConnection("jdbc:mysql://www.db4free.net:3306/stoktakipproje1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","stokadmin","123456789Stok");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	public static void FillTable(JTable table, String Query) {
		Statement stat = null;
		ResultSet rs = null;
		
		Object[] row;
		
		try {
			OpenCloseConnection(true);
			stat = connection.createStatement();
			rs = stat.executeQuery(Query);
			while(table.getRowCount() > 0) 
	        {
	            ((DefaultTableModel) table.getModel()).removeRow(0);
	        }
	        int columns = rs.getMetaData().getColumnCount();
	        while(rs.next())
	        {  
	        	row = new Object[columns];
	            for (int i = 1; i <= columns; i++)
	            {  
	                row[i - 1] = rs.getObject(i);
	               
	            }
	            
	            
	            ((DefaultTableModel) table.getModel()).insertRow(rs.getRow()-1,row);
	        }
	        
	        
	        
	        
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				stat.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			OpenCloseConnection(false);
		}
		
	}// fill table
	
	
	
	
	
	// DAHA SONRA QUERY DEGISTIRILIP GETSTRING(1) YAPILABILIR
	public static void FillComboBox(JComboBox comboBox, String query) 
	{
		ResultSet result = null;
		Statement state = null;
		try {
			OpenCloseConnection(true);
			state = connection.createStatement();
			result = state.executeQuery(query);
			while(result.next()) {
				
				comboBox.addItem(result.getString(2));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			OpenCloseConnection(false);
			try {
				result.close();
				state.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}// fill combobox
	
	
	
	
} // mysqlconnector class
	
