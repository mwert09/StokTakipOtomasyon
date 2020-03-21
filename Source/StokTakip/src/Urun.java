import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Urun {
	
	static MySQLConnector connector = new MySQLConnector();
	
	public String UrunId;
	public String UrunAdi;
	public String UrunAciklamasi;
	public int KagitId;
	public int BoyaId;
	public int YapistiriciId;
	public String Fiyat;
	
	public Urun(String UrunAdi, String UrunAciklamasi, int KagitId, int BoyaId, int YapistiriciId, String Fiyat) {
		this.UrunAdi = UrunAdi;
		this.UrunAciklamasi = UrunAciklamasi;
		this.KagitId = KagitId;
		this.BoyaId = BoyaId;
		this.YapistiriciId = YapistiriciId;
		this.Fiyat = Fiyat;
	}
	
	public static boolean UrunEkle(Urun urun) {
		PreparedStatement preparedStatement = null;
		
		try {
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("insert into urun (UrunAdi, UrunAciklamasi, Fiyat, Kagit, Boya, Yapistirici) values (?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, urun.UrunAdi);
			preparedStatement.setString(2, urun.UrunAciklamasi);
			preparedStatement.setString(3, urun.Fiyat);
			preparedStatement.setInt(4, urun.KagitId);
			preparedStatement.setInt(5, urun.BoyaId);
			preparedStatement.setInt(6, urun.YapistiriciId);
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
	}// URUN EKLE
	
	
	public static boolean UrunSil(String id) {
		PreparedStatement preparedStatement = null;
		
		try {
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("delete from urun where urunId = ?");
			preparedStatement.setString(1, id);
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
	}// URUN SIL
	
	public static Urun UrunBilgileri(String id) {
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try {
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("select * from urun where urunId = ?");
			preparedStatement.setString(1, id);
			result = preparedStatement.executeQuery();
			while(result.next()) {
				Urun urun = new Urun(result.getString(2), result.getString(3), result.getInt(5), result.getInt(6), result.getInt(7), result.getString(4));
				urun.UrunId = result.getString(1);
				return urun;
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
	
	
	public static boolean UrunGuncelle(String id, Urun urun) {
		PreparedStatement preparedStatement = null;
		
		try {
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("update urun set UrunAdi = ?, UrunAciklamasi = ?, Fiyat = ?, Kagit = ?, Boya = ?, Yapistirici = ? where urunId = ?");
			preparedStatement.setString(1, urun.UrunAdi);
			preparedStatement.setString(2, urun.UrunAciklamasi);
			preparedStatement.setString(3, urun.Fiyat);
			preparedStatement.setInt(4, urun.KagitId);
			preparedStatement.setInt(5, urun.BoyaId);
			preparedStatement.setInt(6, urun.YapistiriciId);
			preparedStatement.setString(7, id);
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
	}// URUN GUNCELLE
	
	
	
}// URUN CLASS
