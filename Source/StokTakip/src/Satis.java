import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Satis {
	static MySQLConnector connector = new MySQLConnector();
	
	public String SatisId;
	public String FirmaId;
	public String HammaddeId;
	public String birimFiyat;
	
	public Satis(String FirmaId, String HammaddeId, String birimFiyat) {
		this.FirmaId = FirmaId;
		this.HammaddeId = HammaddeId;
		this.birimFiyat = birimFiyat;
	}
	
	public static boolean SatisEkle(Satis satis) {
		PreparedStatement preparedStatement = null;
		try 
		{
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("insert into firma_satis (FirmaId, hammaddeId, birimFiyat) values (?, ?, ?)");
			preparedStatement.setString(1, satis.FirmaId);
			preparedStatement.setString(2, satis.HammaddeId);
			preparedStatement.setString(3, satis.birimFiyat);
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
	}// SATIS EKLE
	
	public static boolean SatisSil(String id) {
		PreparedStatement preparedStatement = null;
		try 
		{
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("delete from firma_satis where satisId = ?");
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
	}// SATIS SIL
	
	public static boolean SatisGuncelle(Satis satis) {
		PreparedStatement preparedStatement = null;
		try 
		{
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("update firma_satis set FirmaId = ?, hammaddeId = ?, birimFiyat = ? where satisId = ?");
			preparedStatement.setString(1, satis.FirmaId);
			preparedStatement.setString(2, satis.HammaddeId);
			preparedStatement.setString(3, satis.birimFiyat);
			preparedStatement.setString(4, satis.SatisId);
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
	}// SATIS EKLE
	
	public static Satis SatisBilgisiIste(String id) {
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try 
		{
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("select * from firma_satis where satisId = ?");
			preparedStatement.setString(1, id);
			result = preparedStatement.executeQuery();
			while(result.next()) {
				Satis satis = new Satis(result.getString(1), result.getString(2), result.getString(3));
				satis.SatisId = result.getString(4);
				return satis;
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
	}// SATIS BILGISI ISTE
	
	public static boolean SatisVarMi(String id) {
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try 
		{
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("select 1 from firma_satis where satisId = ?");
			preparedStatement.setString(1, id);
			result = preparedStatement.executeQuery();
			while(result.next()) {
				return true;
			}
			return false;
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
				result.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}// SATIS VAR MI
	
	
} // CLASS
