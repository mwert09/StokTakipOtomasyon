import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TedarikciFirma {
	static MySQLConnector connector = new MySQLConnector();
	
	public String FirmaID;
	public String FirmaAdi;
	public String FirmaTelefon;
	public String FirmaAdres;
	
	public TedarikciFirma(String FirmaAdi, String FirmaTelefon, String FirmaAdres) {
		this.FirmaAdi = FirmaAdi;
		this.FirmaTelefon = FirmaTelefon;
		this.FirmaAdres = FirmaAdres;
	}
	
	public static boolean FirmaEkle(TedarikciFirma firma) {
		PreparedStatement preparedStatement = null;
		try 
		{
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("insert into tedarikcifirma (FirmaAdi, FirmaTelefon, FirmaAdres) values (?, ?, ?)");
			preparedStatement.setString(1, firma.FirmaAdi);
			preparedStatement.setString(2, firma.FirmaTelefon);
			preparedStatement.setString(3, firma.FirmaAdres);
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
	} // FIRMA EKLE
	
	public static boolean FirmaSil(String id) {
		PreparedStatement preparedStatement = null;
		try 
		{
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("delete from tedarikcifirma where FirmaId = ?");
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
			connector.OpenCloseConnection(false);
			try {
				
				preparedStatement.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	} // FIRMA SIL
	
	public static boolean FirmaGuncelle(TedarikciFirma firma) {
		PreparedStatement preparedStatement = null;
		try 
		{
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("update tedarikcifirma set FirmaAdi = ?, FirmaTelefon = ?, FirmaAdres = ? where FirmaId = ?");
			preparedStatement.setString(1, firma.FirmaAdi);
			preparedStatement.setString(2, firma.FirmaTelefon);
			preparedStatement.setString(3, firma.FirmaAdres);
			preparedStatement.setString(4, firma.FirmaID);
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
	} // FIRMA GUNCELLE
	
	public static TedarikciFirma FirmaBilgiIste(String id) {
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try 
		{
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("select * from tedarikcifirma where FirmaId = ?");
			preparedStatement.setString(1, id);
			result = preparedStatement.executeQuery();
			while(result.next()) {
				TedarikciFirma firma = new TedarikciFirma(result.getString(2), result.getString(3), result.getString(4));
				firma.FirmaID = result.getString(1);
				return firma;
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
				result.close();
				preparedStatement.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	
} // CLASS
