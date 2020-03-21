import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

public class Gunluk {
	static MySQLConnector connector = new MySQLConnector();
	
	public String GunlukId;
	public Date date;
	
	public Gunluk(Date date) {
		this.date = date;
	}
	
	
	public static void GunlukOlustur(LocalDate date) {
		// bu tarihle gunluk var mi kontrol et
		// varsa olusturma
		// yoksa olustur
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2 = null;
		ResultSet result = null;
		try 
		{
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("select gunlukTarih from gunluk");
			
			result = preparedStatement.executeQuery();
			while(result.next()) {
				if(result.getObject(1) != date) {
					preparedStatement2 = connector.connection.prepareStatement("insert into gunluk (gunlukTarih) values (?)");
					preparedStatement2.setObject(1, date);
					preparedStatement2.executeUpdate();
					return;
				}else {
					return;
				}
				
			}
			
			/*preparedStatement2 = connector.connection.prepareStatement("insert into gunluk (gunlukTarih) values (?)");
			preparedStatement2.setObject(1, date);
			preparedStatement2.executeUpdate();*/
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
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
	} // GUNLUK OLUSTUR
	
	public static void GunlugeEkle(int islemTur, int adet, String icerikId, boolean hammaddemi, LocalDate date, int personelId) {
		PreparedStatement preparedStatement = null;
		try 
		{
			Gunluk gunluk = Gunluk.GunlukBilgisiIste(date);
			connector.OpenCloseConnection(true);
			
			if(hammaddemi) {
				preparedStatement = connector.connection.prepareStatement("insert into gunlukhammadde (gunlukId, islemturId, hammaddeId, adet, personelId) values (?, ?, ?, ?, ?)");
			}
			else {
				preparedStatement = connector.connection.prepareStatement("insert into gunlukurun (gunlukId, islemturId, urunId, adet, personelId) values (?, ?, ?, ?, ?)");
			}
			
			preparedStatement.setString(1, gunluk.GunlukId);
			preparedStatement.setInt(2, islemTur);
			preparedStatement.setString(3, icerikId);
			preparedStatement.setInt(4, adet);
			preparedStatement.setInt(5, personelId);
			preparedStatement.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
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
	} // GUNLUGE EKLE
	
	
	public static Gunluk GunlukBilgisiIste(LocalDate date) {
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try 
		{
			connector.OpenCloseConnection(true);
			
			preparedStatement = connector.connection.prepareStatement("select * from gunluk where gunlukTarih = ?");
			
			
			preparedStatement.setObject(1, date);
			
			result = preparedStatement.executeQuery();
			while(result.next()) {
				Gunluk gunluk = new Gunluk(result.getDate(2));
				gunluk.GunlukId = result.getString(1);
				return gunluk;
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
	}
	
	
} // CLASS
