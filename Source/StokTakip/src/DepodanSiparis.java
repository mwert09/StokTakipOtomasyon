import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DepodanSiparis extends Siparis {
	
	static MySQLConnector connector = new MySQLConnector();
	
	public DepodanSiparis(String Adi, String aciklama, String adet, String hammaddeId, int pid) {
		this.siparisAdi = Adi;
		this.siparisTanim = aciklama;
		this.Adet = adet;
		this.hammaddeId = hammaddeId;
		this.personelId = pid;
		
	}
	
	public static boolean DepodanSiparisOlustur(DepodanSiparis depodan) {
		PreparedStatement preparedStatement = null;
		try 
		{
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("insert into depodansiparis (siparisAdi, siparisAciklama, siparisAdet, siparisHammadde, siparisPersonel) values (?, ?, ?, ?, ?)");
			preparedStatement.setString(1, depodan.siparisAdi);
			preparedStatement.setString(2, depodan.siparisTanim);
			preparedStatement.setString(3, depodan.Adet);
			preparedStatement.setString(4, depodan.hammaddeId);
			preparedStatement.setInt(5, depodan.personelId);
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
	} // DEPODAN SIPARIS OLUSTUR
	
	public static boolean DepodanSiparisSil(String id) {
		PreparedStatement preparedStatement = null;
		try 
		{
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("delete from depodansiparis where depodansiparisId = ?");
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
	} // DEPODAN SIPARIS SIL
	
	
	public static boolean DepodanSiparisGuncelle(DepodanSiparis depodan) {
		PreparedStatement preparedStatement = null;
		try 
		{
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("update depodansiparis set siparisAdi = ?, siparisAciklama = ?, siparisAdet = ?, siparisHammadde = ? where depodansiparisId = ?");
			preparedStatement.setString(1, depodan.siparisAdi);
			preparedStatement.setString(2, depodan.siparisTanim);
			preparedStatement.setString(3, depodan.Adet);
			preparedStatement.setString(4, depodan.hammaddeId);
			preparedStatement.setString(5, depodan.siparisID);
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
	} // DEPODAN SIPARIS GUNCELLE
	
	
	
	public static DepodanSiparis DepodanSiparisBilgileriAl(String id) {
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try 
		{
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("select * from depodansiparis where depodansiparisId = ?");
			preparedStatement.setString(1, id);
			result = preparedStatement.executeQuery();
			while(result.next()) {
				DepodanSiparis depodan = new DepodanSiparis(result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getInt(6));
				depodan.siparisID = id;
				return depodan;
			}
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
		return null;
	} // DEPODAN SIPARIS BILGILERI AL
	
	
	
	
}//CLASS
