

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.github.lgooddatepicker.components.DatePicker;
 

public class Personel {
	
	static MySQLConnector connector = new MySQLConnector();
	
	public int personelId;
	public String personelTC;
	public String Isim;
	public String SoyIsim;
	public String TamIsim;
	public String Cinsiyet;
	public String Email;
	public LocalDate DogumTarihi;
	public String TelefonNo;
	public String Adres;
	public int Yetki;
	public String YetkiAdi;
	
	
	public Personel(int personelId, 
			String personelTC, 
			String TamIsim,
			String Cinsiyet,
			String Email,
			LocalDate DogumTarihi,
			String TelefonNo,
			String Adres,
			int Yetki
			) 
	{
		this.personelId = personelId;
		this.personelTC = personelTC;
		this.TamIsim = TamIsim;
		this.Cinsiyet = Cinsiyet;
		this.Email = Email;
		this.DogumTarihi = DogumTarihi;
		this.TelefonNo = TelefonNo;
		this.Adres = Adres;
		this.Yetki = Yetki;
		
	} // personel constructor
	
	
	
	
	public static boolean PersonelEkle(String personelTC, String PersonelIsim, String PersonelSoyIsim, String PersonelCinsiyet, String PersonelEmail, LocalDate PersonelDogumTarihi, String PersonelTelefonNo, String PersonelAdres, int PersonelYetki, String PersonelUsername, String PersonelPassword) {
		
		PreparedStatement preparedStatement = null;
		try 
		{
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("insert into personel (personelTC, PersonelIsim, PersonelSoyIsim, PersonelCinsiyet, PersonelEmail, PersonelDogumTarihi, PersonelTelefonNo, PersonelAdres, PersonelYetki, PersonelUsername, PersonelPassword) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, personelTC);
			preparedStatement.setString(2, PersonelIsim);
			preparedStatement.setString(3, PersonelSoyIsim);
			preparedStatement.setString(4, PersonelCinsiyet);
			preparedStatement.setString(5, PersonelEmail);
			preparedStatement.setObject(6, PersonelDogumTarihi);
			preparedStatement.setString(7, PersonelTelefonNo);
			preparedStatement.setString(8, PersonelAdres);
			preparedStatement.setInt(9, PersonelYetki);
			preparedStatement.setString(10, PersonelUsername);
			preparedStatement.setString(11, PersonelPassword);
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
	}// PERSONEL EKLE
	
	public static boolean PersonelSil(String Tc) {
		PreparedStatement preparedStatement = null;
		try 
		{
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("delete from personel where personelTC = ?");
			preparedStatement.setString(1, Tc);
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
	}// PERSONELSIL
public static boolean PersonelGuncelle(String personelTC, String PersonelIsim, String PersonelSoyIsim, String PersonelCinsiyet, String PersonelEmail, LocalDate PersonelDogumTarihi, String PersonelTelefonNo, String PersonelAdres, int PersonelYetki, String PersonelUsername, String PersonelPassword) {
		
		PreparedStatement preparedStatement = null;
		try 
		{
			connector.OpenCloseConnection(true);
			preparedStatement = connector.connection.prepareStatement("update personel set personelTC = ?, PersonelIsim = ?, PersonelSoyIsim = ?, PersonelCinsiyet = ?, PersonelEmail = ?, PersonelDogumTarihi = ?, PersonelTelefonNo = ?, PersonelAdres = ?, PersonelYetki = ?, PersonelUsername = ?, PersonelPassword = ? where personelTC = ?");
			preparedStatement.setString(1, personelTC);
			preparedStatement.setString(2, PersonelIsim);
			preparedStatement.setString(3, PersonelSoyIsim);
			preparedStatement.setString(4, PersonelCinsiyet);
			preparedStatement.setString(5, PersonelEmail);
			preparedStatement.setObject(6, PersonelDogumTarihi);
			preparedStatement.setString(7, PersonelTelefonNo);
			preparedStatement.setString(8, PersonelAdres);
			preparedStatement.setInt(9, PersonelYetki);
			preparedStatement.setString(10, PersonelUsername);
			preparedStatement.setString(11, PersonelPassword);
			preparedStatement.setString(12, Main.Tc);
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
	
	}// PERSONEL GUNCELLE

public static void PersonelBilgisiIste(String Tc, JTextField textFieldGuncelleTC, JTextField textFieldGuncelleIsim, JTextField textFieldGuncelleSoyIsim, JRadioButton radioButtonErkek, JRadioButton radioButtonKadin, JTextField textFieldGuncelleEmail, DatePicker datePickerGuncelle, JTextField textFieldGuncelleTel, JTextArea textAreaGuncelleAdres, JComboBox comboBoxGuncelleYetki, JTextField textFieldGuncelleKullaniciAdi, JTextField textFieldGuncelleSifre) {
	ResultSet result = null;
	PreparedStatement preparedStatement = null;
	
	try 
	{
		connector.OpenCloseConnection(true);
		preparedStatement = connector.connection.prepareStatement("select * from personel where personelTC = ?");
		preparedStatement.setString(1, Tc);
		result = preparedStatement.executeQuery();
		while(result.next()) {
			textFieldGuncelleTC.setText(result.getString(2));
			textFieldGuncelleIsim.setText(result.getString(3));
			textFieldGuncelleSoyIsim.setText(result.getString(4));
			if(result.getString(5) == "Erkek") {
				radioButtonErkek.setSelected(true);
				radioButtonKadin.setSelected(false);
				
			}else {
				radioButtonErkek.setSelected(false);
				radioButtonKadin.setSelected(true);
			}
			textFieldGuncelleEmail.setText(result.getString(6));
			datePickerGuncelle.setDate(result.getObject(7, LocalDate.class));
			textFieldGuncelleTel.setText(result.getString(8));
			textAreaGuncelleAdres.setText(result.getString(9));
			textFieldGuncelleKullaniciAdi.setText(result.getString(11));
			textFieldGuncelleSifre.setText(result.getString(12));
			connector.FillComboBox(comboBoxGuncelleYetki, "select * from yetki");
			comboBoxGuncelleYetki.setSelectedIndex(result.getInt(10) - 1);
		}
		
	}
	catch(Exception e1)
	{
		e1.printStackTrace();
		
	}
	finally 
	{
		connector.OpenCloseConnection(false);
		try {
			result.close();
			preparedStatement.close();
		}catch(Exception e1)
		{
			e1.printStackTrace();
		}
	}
} // PERSONEL BILGISI ISTE

public static boolean TcExists(String Tc) {
	ResultSet result = null;
	PreparedStatement preparedStatement = null;
	
	try 
	{
		connector.OpenCloseConnection(true);
		preparedStatement = connector.connection.prepareStatement("select 1 from personel where personelTC = ?");
		preparedStatement.setString(1, Tc);
		result = preparedStatement.executeQuery();
		while(result.next()) {
			System.out.print(Tc);
			return true;
		}
		return false;
	}
	catch(Exception e1)
	{
		e1.printStackTrace();
		return false;
	}
	finally 
	{
		connector.OpenCloseConnection(false);
		try {
			result.close();
			preparedStatement.close();
		}catch(Exception e1)
		{
			e1.printStackTrace();
		}
	}
} // TcExists
	
	
	
}// class personel
