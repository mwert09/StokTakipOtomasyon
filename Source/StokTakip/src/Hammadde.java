import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Hammadde {
	
	static MySQLConnector connector = new MySQLConnector();

	public String HammaddeAdi;
	public int HammaddeTur;
	
	//CONSTRUCTOR
	public Hammadde(String HammaddeAdi, int HammaddeTur) {
		this.HammaddeAdi = HammaddeAdi;
		this.HammaddeTur = HammaddeTur;
	}
	
	// HAMMADDE EKLE
	public static boolean HammaddeEkle(Hammadde hammadde) {
		PreparedStatement preparedStatement = null;
		try 
		{
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("insert into hammadde (hammaddeAdi, hammaddeTur) values (?, ?)");
			preparedStatement.setString(1, hammadde.HammaddeAdi);
			preparedStatement.setInt(2, hammadde.HammaddeTur);
			preparedStatement.executeUpdate();
			return true;
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			return false;
		}
		finally 
		{
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connector.OpenCloseConnection(false);
		}
	}// HAMMADDE EKLE
	
	public static boolean HammaddeSil(String id) {
		PreparedStatement preparedStatement = null;
		try 
		{
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("delete from hammadde where hammaddeId = ?");
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
			return true;
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			return false;
		}
		finally 
		{
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connector.OpenCloseConnection(false);
		}
	} // HAMMADDE SIL
	
	public static boolean HammaddeTurEkle(String TurAdi) {
		PreparedStatement preparedStatement = null;
		try 
		{
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("insert into hammaddetur (hammaddeturAdi) values (?)");
			preparedStatement.setString(1, TurAdi);
			preparedStatement.executeUpdate();
			return true;
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			return false;
		}
		finally 
		{
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connector.OpenCloseConnection(false);
		}
	}// HAMMADDE TUR EKLE
	
	public static boolean HammaddeTurSil(String turId) {
		PreparedStatement preparedStatement = null;
		try 
		{
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("delete from hammaddetur where hammaddeturId =  ?");
			preparedStatement.setString(1, turId);
			preparedStatement.executeUpdate();
			return true;
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			return false;
		}
		finally 
		{
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connector.OpenCloseConnection(false);
		}
	}// HAMMADDE TUR SIL
	
	public static boolean HammaddeTurGuncelle(String id, String YeniTurAdi) {
		PreparedStatement preparedStatement = null;
		try 
		{
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("update hammaddetur set hammaddeturAdi = ? where hammaddeturId = ?");
			preparedStatement.setString(1, YeniTurAdi);
			preparedStatement.setString(2, id);
			preparedStatement.executeUpdate();
			return true;
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			return false;
		}
		finally 
		{
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connector.OpenCloseConnection(false);
		}
	}// HAMMADDE TUR EKLE
	
	
	public static int GetHammaddeTurId(String WhatToGet) {
		PreparedStatement stat = null;
		ResultSet rs = null;
		int res = 0;
		Object[] row;
		
		try {
			connector.OpenCloseConnection(true);
			stat = connector.connection.prepareStatement("select hammaddeturId from hammaddetur where hammaddeturAdi = ?");
			stat.setString(1, WhatToGet);
			rs = stat.executeQuery();
			while(rs.next()) {
				res = rs.getInt(1);
			}
			return res;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		finally {
			try {
				rs.close();
				stat.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connector.OpenCloseConnection(false);
		}
	} // hammadde tur id
	
	
	public static void HammaddeBilgileriIste(JLabel hammaddeid, JTextField hammaddeAdi, JComboBox hammaddetur, String id) {
		PreparedStatement stat = null;
		ResultSet rs = null;
		
		try {
			connector.OpenCloseConnection(true);
			stat = connector.connection.prepareStatement("select * from hammadde where hammaddeId = ?");
			stat.setString(1, id);
			rs = stat.executeQuery();
			while(rs.next()) {
				hammaddeid.setText(rs.getString(1));
				hammaddeAdi.setText(rs.getString(2));
				hammaddetur.setSelectedIndex(rs.getInt(3) - 1);
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
			connector.OpenCloseConnection(false);
		}
	} // HAMMADDE BILGILERI ISTE
	
	public static boolean HammaddeGuncelle(String id, String hammaddeAdi, int hammaddeTur) {
		PreparedStatement stat = null;
		
		
		try {
			connector.OpenCloseConnection(true);
			stat = connector.connection.prepareStatement("update hammadde set hammaddeAdi = ?, hammaddeTur = ? where hammaddeId = ?");
			stat.setString(1, hammaddeAdi);
			stat.setInt(2, hammaddeTur);
			stat.setString(3, id);
			stat.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				
				stat.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connector.OpenCloseConnection(false);
		}
	} // HAMMADDE GUNCELLE
	
	
	public static int HammaddeAdinaGoreIdBul(String HammaddeAdi) {
		PreparedStatement stat = null;
		ResultSet result = null;
		try {
			connector.OpenCloseConnection(true);
			stat = connector.connection.prepareStatement("select hammaddeId from hammadde where hammaddeAdi = ?");
			stat.setString(1, HammaddeAdi);
			result = stat.executeQuery();
			while(result.next()) {
				return result.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		finally {
			try {
				
				stat.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connector.OpenCloseConnection(false);
		}
		return 0;
	} // HAMMADDE ID BUL
	
	
}// CLASS HAMMADDE
