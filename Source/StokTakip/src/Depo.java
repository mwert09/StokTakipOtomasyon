import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Depo {
	
	static MySQLConnector connector = new MySQLConnector();
	
	public String depoId;
	public String depoAdi;
	public String personelId;
	public int depoTur;
	
	public Depo(String depoAdi, String personelId, int depoTur) {
		
		this.depoAdi = depoAdi;
		this.personelId = personelId;
		this.depoTur = depoTur;
	}
	
	public static boolean DepoEkle(Depo depo) {
		PreparedStatement preparedStatement = null;
		try 
		{
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("insert into depo (depoAdi, personelId, depoTur) values (?, ?, ?)");
			preparedStatement.setString(1, depo.depoAdi);
			preparedStatement.setString(2, depo.personelId);
			preparedStatement.setInt(3, depo.depoTur);
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
	} // DEPO EKLE
	
	public static boolean DepoSil(String id) {
		PreparedStatement preparedStatement = null;
		try 
		{
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("delete from depo where depoId = ?");
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
	} // DEPO SIL
	
	public static boolean DepoGuncelle(Depo depo) {
		PreparedStatement preparedStatement = null;
		try 
		{
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("update depo set depoAdi = ?, personelId = ?, depoTur = ?");
			preparedStatement.setString(1, depo.depoAdi);
			preparedStatement.setString(2, depo.personelId);
			preparedStatement.setInt(3, depo.depoTur);
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
	} // DEPO GUNCELLE
	
	public static Depo DepoBilgileri(String id) {
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try {
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("select * from depo where depoId = ?");
			preparedStatement.setString(1, id);
			result = preparedStatement.executeQuery();
			while(result.next()) {
				Depo depo = new Depo(result.getString(2), result.getString(3), result.getInt(4));
				depo.depoId = result.getString(1);
				return depo;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			connector.OpenCloseConnection(false);
			try {
				preparedStatement.close();
				result.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
	} // URUN BILGILERI
	
	public static boolean DepoyaEkle(String depoId, String IcerikId, int depoTur, String adet) {
		PreparedStatement preparedStatement = null;
		
		try {
			connector.OpenCloseConnection(true);
			if(DepodaVarMi(IcerikId, depoTur)) {
				if(depoTur == 1) {
					preparedStatement = connector.connection.prepareStatement("update urun_depo_icerik set adet = adet + ? where urunid = ?");
					preparedStatement.setString(1, adet);
					preparedStatement.setString(2, IcerikId);

				}
				else if(depoTur == 2) {
					preparedStatement = connector.connection.prepareStatement("update hammadde_depo_icerik set adet = adet + ? where hammaddeId = ?");
					preparedStatement.setString(1, adet);
					preparedStatement.setString(2, IcerikId);
				}
				
			}
			else {
				if(depoTur == 1) {
					preparedStatement = connector.connection.prepareStatement("insert into urun_depo_icerik (depoId, urunid, adet) values (?, ?, ?)");
				}
				else if(depoTur == 2) {
					preparedStatement = connector.connection.prepareStatement("insert into hammadde_depo_icerik (depoId, hammaddeId, adet) values (?, ?, ?)");
				}
				preparedStatement.setString(1, depoId);
				preparedStatement.setString(2, IcerikId);
				preparedStatement.setString(3, adet);
			}
			preparedStatement.executeUpdate();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			connector.OpenCloseConnection(false);
			try {
				preparedStatement.close();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	} // DEPOYA EKLE
	
	public static boolean DepodaVarMi(String IcerikId, int depoTur) {
		PreparedStatement preparedStatement = null;
		//Statement state = null;
		ResultSet result = null;
		try {
			connector.OpenCloseConnection(true);
			if(depoTur == 1) {
				preparedStatement = connector.connection.prepareStatement("select urunid from urun_depo_icerik where urunid = ?");
			}
			else if(depoTur == 2) {
				preparedStatement = connector.connection.prepareStatement("select hammaddeId from hammadde_depo_icerik where hammaddeId = ?");
			}
			
			preparedStatement.setString(1, IcerikId);
			
			result = preparedStatement.executeQuery();
			while(result.next()) {
				return true;
			}
			
			return false;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	} // DEPODA VAR MI
	
	
	public static boolean DepodaYeterliVarMi(String IcerikId, int depoTur, int adet) {
		PreparedStatement preparedStatement = null;
		//Statement state = null;
		ResultSet result = null;
		try {
			connector.OpenCloseConnection(true);
			if(depoTur == 1) {
				preparedStatement = connector.connection.prepareStatement("select adet from urun_depo_icerik where urunid = ?");
			}
			else if(depoTur == 2) {
				preparedStatement = connector.connection.prepareStatement("select adet from hammadde_depo_icerik where hammaddeId = ?");
			}
			
			preparedStatement.setString(1, IcerikId);
			
			result = preparedStatement.executeQuery();
			while(result.next()) {
				if(result.getInt(1) - adet >= 0) {
					return true;
				}
				else {
					return false;
				}
			}
			
			return false;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	} // DEPODA YETERLI VAR MI
	
	public static boolean DepodanSil(String depoId, String IcerikId, int depoTur, int adet) {
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2 = null;
		
		try {
			connector.OpenCloseConnection(true);
			if(depoTur == 1) {
				preparedStatement = connector.connection.prepareStatement("update urun_depo_icerik set adet = adet - ? where urunid = ?  and depoid = ?");
			}
			else if(depoTur == 2) {
				preparedStatement = connector.connection.prepareStatement("update hammadde_depo_icerik set adet = adet - ? where hammaddeId = ? and depoId = ?");
			}
			preparedStatement.setInt(1, adet);
			preparedStatement.setString(2, IcerikId);
			preparedStatement.setString(3, depoId);
			if(DepodaYeterliVarMi(IcerikId, depoTur, adet)) {
				preparedStatement.executeUpdate();
			}
			else {
				return false;
			}
			
			if(depoTur == 1) {
				preparedStatement2 = connector.connection.prepareStatement("delete from urun_depo_icerik where adet = 0 or adet < 0");
			}
			else if(depoTur == 2) {
				preparedStatement2 = connector.connection.prepareStatement("delete from hammadde_depo_icerik where adet = 0 or adet < 0");
			}
			preparedStatement2.executeUpdate();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			connector.OpenCloseConnection(false);
			try {
				preparedStatement.close();
				//state.close();
				preparedStatement2.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	} // DEPODAN SIL
	
} // CLASS
