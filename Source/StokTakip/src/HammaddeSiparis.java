import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HammaddeSiparis extends Siparis {
	
	static MySQLConnector connector = new MySQLConnector();
	
	public HammaddeSiparis(String Adi, String aciklama, String adet, int siparisDurum, int pid, String tfId) {
		this.siparisAdi = Adi;
		this.siparisTanim = aciklama;
		this.Adet = adet;
		
		this.personelId = pid;
		this.tfId = tfId;
		this.siparisDurum = siparisDurum;
		
	}
	
	public static boolean HammaddeSiparisOlustur(HammaddeSiparis siparis) {
		PreparedStatement preparedStatement = null;
		try 
		{
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("insert into siparis (siparisAdi, siparisAciklama, siparisAdet, siparisDurum, siparisHammadde, siparisPersonel, siparisFirmaSatis) values (?, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, siparis.siparisAdi);
			preparedStatement.setString(2, siparis.siparisTanim);
			preparedStatement.setString(3, siparis.Adet);
			preparedStatement.setInt(4, siparis.siparisDurum);
			preparedStatement.setString(5, Satis.SatisBilgisiIste(siparis.tfId).HammaddeId);
			preparedStatement.setInt(6, siparis.personelId);
			preparedStatement.setString(7, siparis.tfId);
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
	} // Hammadde SIPARIS OLUSTUR
	
	public static boolean HammaddeSiparisSil(String id) {
		PreparedStatement preparedStatement = null;
		try 
		{
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("delete from siparis where siparisId = ?");
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
	} // HAMMADDE SIPARIS SIL
	
	
	public static boolean HammaddeSiparisGuncelle(HammaddeSiparis siparis) {
		PreparedStatement preparedStatement = null;
		try 
		{
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("update siparis set siparisAdi = ?, siparisAciklama = ?, siparisAdet = ?, siparisDurum = ?,  siparisHammadde = ?, siparisFirmaSatis = ? where siparisId = ?");
			preparedStatement.setString(1, siparis.siparisAdi);
			preparedStatement.setString(2, siparis.siparisTanim);
			preparedStatement.setString(3, siparis.Adet);
			preparedStatement.setInt(4, siparis.siparisDurum);
			preparedStatement.setString(5, siparis.hammaddeId);
			preparedStatement.setString(6, siparis.tfId);
			preparedStatement.setString(7, siparis.siparisID);
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
	} // HAMMADDE SIPARIS GUNCELLE
	
	
	
	public static HammaddeSiparis HammaddeSiparisBilgileriAl(String id) {
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try 
		{
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("select * from siparis where siparisId = ?");
			preparedStatement.setString(1, id);
			result = preparedStatement.executeQuery();
			while(result.next()) {
				HammaddeSiparis siparis = new HammaddeSiparis(result.getString(2), result.getString(3), result.getString(4), result.getInt(5), result.getInt(6), result.getString(8));
				siparis.siparisID = result.getString(1);
				siparis.hammaddeId = result.getString(6);
				return siparis;
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
	} // HAMMADDE SIPARIS BILGILERI AL
	
	
	public static boolean AdetKontrol(int adet, String id) {
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try 
		{
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("select siparisAdet from depodansiparis where depodansiparisId = ?");
			
			preparedStatement.setString(1, id);
			
			result = preparedStatement.executeQuery();
			while(result.next()) {
				if(result.getInt(1) >= adet) {
					return true;
				}
				else {
					return false;
				}
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
				result.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return false;
	} // HAMMADDE SIPARIS GUNCELLE
	
	
	
	public static boolean HammaddeSiparisAdetEksilt(int adet, String id) {
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2 = null;
		try 
		{
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("update depodansiparis set siparisAdet = siparisAdet - ? where depodansiparisId = ?");
			preparedStatement.setInt(1, adet);
			preparedStatement.setString(2, id);
			preparedStatement2 = connector.connection.prepareStatement("delete from depodansiparis where siparisAdet = 0 or siparisAdet < 0");
			if(AdetKontrol(adet, id)) {
				preparedStatement.executeUpdate();
				preparedStatement2.executeUpdate();
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
				preparedStatement2.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	} // HAMMADDE SIPARIS GUNCELLE
	
	
	public static boolean SiparisOnay(String id, int durum) {
		PreparedStatement preparedStatement = null;
		try 
		{
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("update siparis set siparisDurum = ? where siparisId = ?");
			preparedStatement.setInt(1, durum);
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
			connector.OpenCloseConnection(false);
			try {
				
				preparedStatement.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	} // SIPARIS ONAY
	
	
}//CLASS
