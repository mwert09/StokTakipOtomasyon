import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Rapor {
	static MySQLConnector connector = new MySQLConnector();
	
	public String RaporId;
	public String RaporAdi;
	public String RaporAciklama;
	public int PersonelId;
	
	public Rapor(String RaporAdi, String RaporAciklama, int PersonelId) {
		this.RaporAdi = RaporAdi;
		this.RaporAciklama = RaporAciklama;
		this.PersonelId = PersonelId;
	}
	
	public static boolean RaporEkle(Rapor rapor) {
		PreparedStatement preparedStatement = null;
		try 
		{
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("insert into rapor (raporAdi, raporAciklama, personelId) values (?, ?, ?)");
			preparedStatement.setString(1, rapor.RaporAdi);
			preparedStatement.setString(2, rapor.RaporAciklama);
			preparedStatement.setInt(3, rapor.PersonelId);
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
			connector.OpenCloseConnection(false);
			try {
				
				preparedStatement.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	} // RAPOR EKLE
	
	public static boolean RaporSil(String id, int pid) {
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2 = null;
		ResultSet result = null;
		try 
		{
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("delete from rapor where raporId = ?");
			preparedStatement.setString(1, id);
			
			
			preparedStatement2 = connector.connection.prepareStatement("select personelId from rapor where raporId = ?");
			preparedStatement2.setString(1, id);
			result = preparedStatement2.executeQuery();
			while(result.next()) {
				if(result.getInt(1) == pid) {
					preparedStatement.executeUpdate();
				}
				else {
					return false;
				}
			}
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		finally 
		{
			connector.OpenCloseConnection(false);
			try {
				
				preparedStatement.close();
				preparedStatement2.close();
				result.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	} // RAPOR SIL
	
	
	public static Rapor RaporBilgisiIste(String id) {
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try 
		{
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("select * from rapor where raporId = ?");
			preparedStatement.setString(1, id);
			result = preparedStatement.executeQuery();
			while(result.next()) {
				Rapor rapor = new Rapor(result.getString(2), result.getString(3), result.getInt(4));
				rapor.RaporId = result.getString(1);
				return rapor;
			}
			return null;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		finally 
		{
			connector.OpenCloseConnection(false);
			try {
				
				preparedStatement.close();
				result.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}// RAPOR BILGISI ISTE
	
	public static boolean RaporGuncelle(Rapor rapor) {
		PreparedStatement preparedStatement = null;
		/*PreparedStatement preparedStatement2 = null;
		ResultSet result = null;*/
		try 
		{
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("update rapor set raporAdi = ?, raporAciklama = ? where raporId = ?");
			preparedStatement.setString(1, rapor.RaporAdi);
			preparedStatement.setString(2, rapor.RaporAciklama);
			preparedStatement.setString(3, rapor.RaporId);
			
			/*preparedStatement2 = connector.connection.prepareStatement("select personelId from rapor where raporId = ?");
			preparedStatement2.setString(1, rapor.RaporId);
			result = preparedStatement2.executeQuery();*/
			
			if(rapor.PersonelId == Login.currentPersonel.personelId) {
				preparedStatement.executeUpdate();
				return true;
			}
			else {
				return false;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		finally 
		{
			connector.OpenCloseConnection(false);
			try {
				
				preparedStatement.close();
				//preparedStatement2.close();
				//result.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}// Rapor Guncelle
	
	
}// CLASS
