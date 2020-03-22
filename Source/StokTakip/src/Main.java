import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.github.lgooddatepicker.components.DatePicker;
import com.toedter.calendar.JCalendar;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JMenu;




public class Main extends JFrame {
	

	MySQLConnector connector = new MySQLConnector();
	
	private JPanel contentPane;
	private JTable tablePersonel;
	private JTextField textFieldTC;
	private JTextField textFieldIsim;
	private JTextField textFieldSoyIsim;
	private JTextField textFieldEmail;
	private JTextField textFieldTel;
	private JTextField textFieldKullaniciAdi;
	private JTextField textFieldSifre;
	
	String WelcomeCard = "Welcome";
	String YonetimCard = "Yonetim";
	String PersonelCard = "Personel";
	String PersonelEkleCard = "PersonelEkle";
	String PersonelGuncelleCard = "PersonelGuncelle";
	String HammaddeCard = "Hammadde";
	String HammaddeEkleCard = "HammaddeEkle";
	String HammaddeGuncelleCard = "HammaddeGuncelle";
	String UrunCard = "Urun";
	String UrunEkleCard = "UrunEkle";
	String UrunGuncelleCard = "UrunGuncelle";
	String DepoYonetimCard = "DepoYonetim";
	String DepoEkleCard = "DepoEkle";
	String DepoGuncelleCard = "DepoGuncelle";
	String DepoCard = "Depo";
	String DepoIcerikCard = "DepoIcerik";
	String FirmaYonetimCard = "FirmaCard";
	String FirmaEkleCard = "FirmaEkle";
	String FirmaGuncelleCard = "FirmaGuncelle";
	String SatisYonetimCard = "SatisCard";
	String SatisEkleCard = "SatisEkle";
	String SatisGuncelleCard = "SatisGuncelle";
	String MatbaaSiparisCard = "SiparisYonetim";
	String DepoSiparisEkleCard = "DepoSiparisEkle";
	String MatbaaSiparisEkleCard = "MatbaaSiparisEkle";
	String MatbaaSiparisGuncelleCard = "MatbaaSiparisGuncelle";
	String DepoSiparisCard = "DepoSiparis";
	String DepoSiparisGuncelleCard = "DepoSiparisGuncelle";
	String YoneticiSiparisCard = "YoneticiSiparis";
	String RaporCard = "Rapor";
	String RaporEkleCard = "RaporEkle";
	String RaporGuncelleCard = "RaporGuncelle";
	String GunlukCard = "Gunluk";
	
	
	final static CardLayout cardLayout = new CardLayout();
	final static JPanel panels = new JPanel(cardLayout);
	final JPanel panelPersonelEkle = new JPanel();
	final JPanel panelPersonel = new JPanel();
	final JPanel panelWelcome = new JPanel();
	final JPanel panelPersonelGuncelle = new JPanel();
	final JPanel panelHammadde = new JPanel();
	final JPanel panelHammaddeEkle = new JPanel();
	final JPanel panelHammaddeGuncelle = new JPanel();
	final JPanel panelYonetim = new JPanel();
	final JPanel panelUrun = new JPanel();
	final JPanel panelUrunEkle = new JPanel();
	final JPanel panelUrunGuncelle = new JPanel();
	final JPanel panelDepoYonetim = new JPanel();
	final JPanel panelDepoEkle = new JPanel();
	final JPanel panelDepoGuncelle = new JPanel();
	final JPanel panelDepo = new JPanel();
	final JPanel panelDepoIcerik = new JPanel();
	final JPanel panelTedarikciFirma = new JPanel();
	final JPanel panelFirmaEkle = new JPanel();
	final JPanel panelFirmaGuncelle = new JPanel();
	final JPanel panelFirmaSatis = new JPanel();
	final JPanel panelSatisEkle = new JPanel();
	final JPanel panelSatisGuncelle = new JPanel();
	final JPanel panelMatbaaSiparis = new JPanel();
	final JPanel panelDepoSiparisEkle = new JPanel();
	final JPanel panelMatbaaSiparisEkle = new JPanel();
	final JPanel panelMatbaaSiparisGuncelle = new JPanel();
	final JPanel panelDepoSiparis = new JPanel();
	final JPanel panelDepoSiparisGuncelle = new JPanel();
	final JPanel panelYoneticiSiparis = new JPanel();
	final JPanel panelRapor = new JPanel();
	final JPanel panelRaporEkle = new JPanel();
	final JPanel panelRaporGuncelle = new JPanel();
	final JPanel panelGunluk = new JPanel();
	
	
	private  JTextField textFieldGuncelleTC;
	private  JTextField textFieldGuncelleIsim;
	private  JTextField textFieldGuncelleSoyIsim;
	private  JTextField textFieldGuncelleEmail;
	private  JTextField textFieldGuncelleTel;
	private  JTextField textFieldGuncelleKullaniciAdi;
	private  JTextField textFieldGuncelleSifre;
	
	
	public static String Tc;
	private JTable tableHammadde;
	private JTextField textFieldHammaddeAdi;
	private JTextField textFieldHammaddeGuncelle;
	private JTable tableHammaddeTur;
	private JTable tableUrun;
	private JTextField textFieldUrunAdi;
	private JTextField textFieldFiyat;
	private JTextField textFieldUrunAdiGuncelle;
	private JTextField textFieldFiyatGuncelle;
	private JTable tableUrunDepo;
	private JTable tableHammaddeDepo;
	private JTextField textFieldDepoAdi;
	private JTextField textFieldPersonelId;
	private JTextField textFieldDepoAdiGuncelle;
	private JTextField textFieldPersonelIdGuncelle;
	private JTable tableUrunDepolar;
	private JTable tableHammaddeDepolar;
	private JTable tableDepoIcerik;
	private JTable tableFirmalar;
	private JTextField textFieldFirmaAdi;
	private JTextField textFieldFirmaTel;
	private JTextField textFieldFirmaAdiGuncelle;
	private JTextField textFieldFirmaTelGuncelle;
	private JTable tableSatislar;
	private JTextField textFieldFirmaID;
	private JTextField textFieldHammaddeID;
	private JTextField textFieldBirimFiyat;
	private JTextField textField;
	private JTextField textFieldHammaddeIdGuncelle;
	private JTextField textFieldBirimFiyatGuncelle;
	private JTable tableMatbaaSiparisler;
	private JTextField textFieldSiparisAdi;
	private JTextField textFieldSiparisAdet;
	private JTextField textFieldFirmaSatisID;
	private JTable tableFirmaSatislar;
	private JTextField textFieldMatbaaSiparisAdi;
	private JTextField textFieldMatbaaSiparisAdet;
	private JTextField textFieldMatbaaSiparisHammaddeID;
	private JTable tableSiparisHammaddeler;
	private JTextField textFieldMatbaaSiparisGuncelleAdi;
	private JTextField textFieldMatbaaSiparisGuncelleAdet;
	private JTextField textFieldMatbaaSiparisGuncelleHammaddeID;
	private JTable tableHammaddelerGuncelle;
	private JTable tableHammaddeSiparisleri;
	private JTable tableDepodanBeklenenSiparisler;
	private JTextField textFieldSiparisAdiGuncelle;
	private JTextField textFieldSiparisAdetGuncelle;
	private JTextField textFieldFirmaSatisIDGuncelle;
	private JTable tableSiparisGuncelleFirmaSatis;
	private JTable tableSiparisler;
	private JTable tableRaporlar;
	private JTextField textFieldRaporAdi;
	private JTextField textFieldRaporAdiGuncelle;
	private JTable tableGunlukHammadde;
	private JTable tableGunlukUrun;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/Resources/Logo.png")));
		setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		setTitle("Matbaa Otomasyon");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 901, 533);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		
		JPanel panelButtons = new JPanel();
		
		panelButtons.setBackground(Color.BLACK);
		
		final JLabel lblAdSoyad = new JLabel(Login.currentPersonel.TamIsim);
		
		lblAdSoyad.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdSoyad.setFont(new Font("JetBrains Mono", Font.BOLD, 15));
		lblAdSoyad.setForeground(Color.WHITE);
		
		JLabel lblYetki = new JLabel(Login.currentPersonel.YetkiAdi);
		lblYetki.setHorizontalAlignment(SwingConstants.CENTER);
		lblYetki.setForeground(Color.WHITE);
		lblYetki.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		
		final JButton btnYonetim = new JButton("Yonetim");
		btnYonetim.setHorizontalAlignment(SwingConstants.LEFT);
		
		
		btnYonetim.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		btnYonetim.setForeground(Color.WHITE);
		btnYonetim.setBackground(Color.BLACK);
		btnYonetim.setFocusPainted(false);
		btnYonetim.setBorderPainted(false);
		
		
		
		
		final JButton btnGoBack = new JButton("");
		btnGoBack.setEnabled(false);
		
		
		btnGoBack.setForeground(Color.WHITE);
		btnGoBack.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		btnGoBack.setFocusPainted(false);
		btnGoBack.setBorderPainted(false);
		btnGoBack.setBackground(Color.BLACK);
		
		final JButton btnHammadde = new JButton("Hammadde");
		btnHammadde.setHorizontalAlignment(SwingConstants.LEFT);
		btnHammadde.setForeground(Color.WHITE);
		btnHammadde.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		btnHammadde.setFocusPainted(false);
		btnHammadde.setBorderPainted(false);
		btnHammadde.setBackground(Color.BLACK);
		
		final JButton btnUrun = new JButton("Urun");
		
		btnUrun.setHorizontalAlignment(SwingConstants.LEFT);
		btnUrun.setForeground(Color.WHITE);
		btnUrun.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		btnUrun.setFocusPainted(false);
		btnUrun.setBorderPainted(false);
		btnUrun.setBackground(Color.BLACK);
		
		final JButton btnDepo = new JButton("Depo");
		
		btnDepo.setHorizontalAlignment(SwingConstants.LEFT);
		btnDepo.setForeground(Color.WHITE);
		btnDepo.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		btnDepo.setFocusPainted(false);
		btnDepo.setBorderPainted(false);
		btnDepo.setBackground(Color.BLACK);
		
		final JButton btnSiparis = new JButton("Siparis");
		
		btnSiparis.setHorizontalAlignment(SwingConstants.LEFT);
		btnSiparis.setForeground(Color.WHITE);
		btnSiparis.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		btnSiparis.setFocusPainted(false);
		btnSiparis.setBorderPainted(false);
		btnSiparis.setBackground(Color.BLACK);
		
		final JButton btnRapor = new JButton("Rapor");
		
		btnRapor.setHorizontalAlignment(SwingConstants.LEFT);
		btnRapor.setForeground(Color.WHITE);
		btnRapor.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		btnRapor.setFocusPainted(false);
		btnRapor.setBorderPainted(false);
		btnRapor.setBackground(Color.BLACK);
		GroupLayout gl_panelButtons = new GroupLayout(panelButtons);
		gl_panelButtons.setHorizontalGroup(
			gl_panelButtons.createParallelGroup(Alignment.TRAILING)
				.addComponent(btnHammadde, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
				.addComponent(btnUrun, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
				.addComponent(btnDepo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
				.addComponent(btnYonetim, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
				.addComponent(btnRapor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
				.addComponent(btnSiparis, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
				.addComponent(btnGoBack, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(lblAdSoyad, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(lblYetki, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
		);
		gl_panelButtons.setVerticalGroup(
			gl_panelButtons.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelButtons.createSequentialGroup()
					.addGap(25)
					.addComponent(lblAdSoyad)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblYetki, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(btnYonetim, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnHammadde, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnUrun, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDepo, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSiparis, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRapor, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
					.addComponent(btnGoBack, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
		);
		panelButtons.setLayout(gl_panelButtons);
		
		panelWelcome.setBackground(Color.WHITE);
		
		
		
		
		
		panelPersonel.setBackground(Color.WHITE);
		GridBagConstraints gbc_panelYonetim = new GridBagConstraints();
		gbc_panelYonetim.fill = GridBagConstraints.BOTH;
		gbc_panelYonetim.gridx = 1;
		gbc_panelYonetim.gridy = 0;
		//contentPane.add(panelYonetim, gbc_panelYonetim);
		//panelWelcome.setLayout(new CardLayout(0, 0));
		
		
		
		// panel ekleme yeri
		panels.add(panelWelcome, WelcomeCard);
		panels.add(panelYonetim, YonetimCard);
		panels.add(panelPersonel, PersonelCard);
		panels.add(panelPersonelEkle, PersonelEkleCard);
		panels.add(panelHammadde, HammaddeCard);
		panels.add(panelPersonelGuncelle, PersonelGuncelleCard);
		panels.add(panelHammaddeEkle, HammaddeEkleCard);
		panels.add(panelHammaddeGuncelle, HammaddeGuncelleCard);
		panels.add(panelUrun, UrunCard);
		panels.add(panelUrunEkle, UrunEkleCard);
		panels.add(panelUrunGuncelle, UrunGuncelleCard);
		panels.add(panelDepoYonetim, DepoYonetimCard);
		panels.add(panelDepoEkle, DepoEkleCard);
		panels.add(panelDepoGuncelle, DepoGuncelleCard);
		panels.add(panelDepo, DepoCard);
		panels.add(panelDepoIcerik, DepoIcerikCard);
		panels.add(panelTedarikciFirma, FirmaYonetimCard);
		panels.add(panelFirmaEkle, FirmaEkleCard);
		panels.add(panelFirmaGuncelle, FirmaGuncelleCard);
		panels.add(panelFirmaSatis, SatisYonetimCard);
		panels.add(panelSatisEkle, SatisEkleCard);
		panels.add(panelSatisGuncelle, SatisGuncelleCard);
		panels.add(panelMatbaaSiparis, MatbaaSiparisCard);
		panels.add(panelDepoSiparisEkle, DepoSiparisEkleCard);
		panels.add(panelMatbaaSiparisEkle, MatbaaSiparisEkleCard);
		panels.add(panelMatbaaSiparisGuncelle, MatbaaSiparisGuncelleCard);
		panels.add(panelDepoSiparis, DepoSiparisCard);
		panels.add(panelDepoSiparisGuncelle, DepoSiparisGuncelleCard);
		panels.add(panelYoneticiSiparis, YoneticiSiparisCard);
		panels.add(panelRapor, RaporCard);
		panels.add(panelRaporEkle, RaporEkleCard);
		panels.add(panelRaporGuncelle, RaporGuncelleCard);
		panels.add(panelGunluk, GunlukCard);
		
		
		
		panelPersonelEkle.setBackground(Color.WHITE);
		GridBagLayout gbl_panelPersonel = new GridBagLayout();
		gbl_panelPersonel.columnWidths = new int[]{159, 159, 193, 0};
		gbl_panelPersonel.rowHeights = new int[]{57, 84, 308, 0};
		gbl_panelPersonel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelPersonel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panelPersonel.setLayout(gbl_panelPersonel);
		
		JButton btnYeniPersonel = new JButton("Yeni Personel Ekle");
		
		
		btnYeniPersonel.setBackground(Color.WHITE);
		btnYeniPersonel.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		GridBagConstraints gbc_btnYeniPersonel = new GridBagConstraints();
		gbc_btnYeniPersonel.fill = GridBagConstraints.BOTH;
		gbc_btnYeniPersonel.insets = new Insets(0, 0, 5, 5);
		gbc_btnYeniPersonel.gridx = 0;
		gbc_btnYeniPersonel.gridy = 0;
		panelPersonel.add(btnYeniPersonel, gbc_btnYeniPersonel);
		
		
		
		JButton btnPersonelSil = new JButton("Personel Sil");
		
		btnPersonelSil.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		btnPersonelSil.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnPersonelSil = new GridBagConstraints();
		gbc_btnPersonelSil.fill = GridBagConstraints.BOTH;
		gbc_btnPersonelSil.insets = new Insets(0, 0, 5, 5);
		gbc_btnPersonelSil.gridx = 1;
		gbc_btnPersonelSil.gridy = 0;
		panelPersonel.add(btnPersonelSil, gbc_btnPersonelSil);
		
		JButton btnPersonelGuncelle = new JButton("Personel Guncelle");
		
		btnPersonelGuncelle.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		btnPersonelGuncelle.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnPersonelGuncelle = new GridBagConstraints();
		gbc_btnPersonelGuncelle.fill = GridBagConstraints.BOTH;
		gbc_btnPersonelGuncelle.insets = new Insets(0, 0, 5, 0);
		gbc_btnPersonelGuncelle.gridx = 2;
		gbc_btnPersonelGuncelle.gridy = 0;
		panelPersonel.add(btnPersonelGuncelle, gbc_btnPersonelGuncelle);
		
		tablePersonel = new JTable();
		tablePersonel.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Sifre", "Id", "TC No", "Isim", "SoyIsim", "Cinsiyet", "Email", "Dogum Tarihi", "TelefonNo", "Adres", "Yetki", "Kullanici Adi"
			}
		));
		tablePersonel.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		GridBagConstraints gbc_tablePersonel = new GridBagConstraints();
		gbc_tablePersonel.fill = GridBagConstraints.BOTH;
		gbc_tablePersonel.gridwidth = 3;
		gbc_tablePersonel.gridx = 0;
		gbc_tablePersonel.gridy = 2;
		panelPersonel.add(tablePersonel, gbc_tablePersonel);
		
		
		//ilk panel
		cardLayout.show(panels, "Welcome");
		panelWelcome.setLayout(new BorderLayout(0, 0));
		
		JLabel lblHosgeldiniz = new JLabel("Hosgeldin " + Login.currentPersonel.Isim + "!");
		lblHosgeldiniz.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		lblHosgeldiniz.setHorizontalAlignment(SwingConstants.CENTER);
		panelWelcome.add(lblHosgeldiniz);
		GridBagLayout gbl_panelPersonelEkle = new GridBagLayout();
		gbl_panelPersonelEkle.columnWidths = new int[]{114, 86, 81, 33, 132, 0};
		gbl_panelPersonelEkle.rowHeights = new int[]{20, 20, 20, 23, 20, 20, 20, 55, 22, 20, 23, 44, 0};
		gbl_panelPersonelEkle.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelPersonelEkle.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelPersonelEkle.setLayout(gbl_panelPersonelEkle);
		
		JLabel lblTC = new JLabel("TC No:");
		lblTC.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		GridBagConstraints gbc_lblTC = new GridBagConstraints();
		gbc_lblTC.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTC.insets = new Insets(0, 0, 5, 5);
		gbc_lblTC.gridx = 0;
		gbc_lblTC.gridy = 0;
		panelPersonelEkle.add(lblTC, gbc_lblTC);
		
		textFieldTC = new JTextField();
		textFieldTC.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		GridBagConstraints gbc_textFieldTC = new GridBagConstraints();
		gbc_textFieldTC.anchor = GridBagConstraints.NORTH;
		gbc_textFieldTC.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTC.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTC.gridwidth = 2;
		gbc_textFieldTC.gridx = 1;
		gbc_textFieldTC.gridy = 0;
		panelPersonelEkle.add(textFieldTC, gbc_textFieldTC);
		textFieldTC.setColumns(10);
		
		JLabel lblIsim = new JLabel("Isim:");
		lblIsim.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		GridBagConstraints gbc_lblIsim = new GridBagConstraints();
		gbc_lblIsim.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIsim.insets = new Insets(0, 0, 5, 5);
		gbc_lblIsim.gridx = 0;
		gbc_lblIsim.gridy = 1;
		panelPersonelEkle.add(lblIsim, gbc_lblIsim);
		
		textFieldIsim = new JTextField();
		textFieldIsim.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		textFieldIsim.setColumns(10);
		GridBagConstraints gbc_textFieldIsim = new GridBagConstraints();
		gbc_textFieldIsim.anchor = GridBagConstraints.NORTH;
		gbc_textFieldIsim.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldIsim.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldIsim.gridwidth = 2;
		gbc_textFieldIsim.gridx = 1;
		gbc_textFieldIsim.gridy = 1;
		panelPersonelEkle.add(textFieldIsim, gbc_textFieldIsim);
		
		JLabel lblSoyISim = new JLabel("SoyIsim:");
		lblSoyISim.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		GridBagConstraints gbc_lblSoyISim = new GridBagConstraints();
		gbc_lblSoyISim.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSoyISim.insets = new Insets(0, 0, 5, 5);
		gbc_lblSoyISim.gridx = 0;
		gbc_lblSoyISim.gridy = 2;
		panelPersonelEkle.add(lblSoyISim, gbc_lblSoyISim);
		
		textFieldSoyIsim = new JTextField();
		textFieldSoyIsim.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		textFieldSoyIsim.setColumns(10);
		GridBagConstraints gbc_textFieldSoyIsim = new GridBagConstraints();
		gbc_textFieldSoyIsim.anchor = GridBagConstraints.NORTH;
		gbc_textFieldSoyIsim.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldSoyIsim.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldSoyIsim.gridwidth = 2;
		gbc_textFieldSoyIsim.gridx = 1;
		gbc_textFieldSoyIsim.gridy = 2;
		panelPersonelEkle.add(textFieldSoyIsim, gbc_textFieldSoyIsim);
		
		JLabel lblCinsiyet = new JLabel("Cinsiyet:");
		lblCinsiyet.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		GridBagConstraints gbc_lblCinsiyet = new GridBagConstraints();
		gbc_lblCinsiyet.anchor = GridBagConstraints.WEST;
		gbc_lblCinsiyet.insets = new Insets(0, 0, 5, 5);
		gbc_lblCinsiyet.gridx = 0;
		gbc_lblCinsiyet.gridy = 3;
		panelPersonelEkle.add(lblCinsiyet, gbc_lblCinsiyet);
		
		
		JRadioButton rdbtnErkek = new JRadioButton("Erkek");
		rdbtnErkek.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		rdbtnErkek.setBackground(Color.WHITE);
		GridBagConstraints gbc_rdbtnErkek = new GridBagConstraints();
		gbc_rdbtnErkek.anchor = GridBagConstraints.NORTH;
		gbc_rdbtnErkek.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnErkek.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnErkek.gridx = 1;
		gbc_rdbtnErkek.gridy = 3;
		panelPersonelEkle.add(rdbtnErkek, gbc_rdbtnErkek);
		rdbtnErkek.setActionCommand(rdbtnErkek.getText());
		
		
		JRadioButton radioBtnKadin = new JRadioButton("Kadin");
		radioBtnKadin.setBackground(Color.WHITE);
		radioBtnKadin.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		GridBagConstraints gbc_radioBtnKadin = new GridBagConstraints();
		gbc_radioBtnKadin.anchor = GridBagConstraints.NORTH;
		gbc_radioBtnKadin.fill = GridBagConstraints.HORIZONTAL;
		gbc_radioBtnKadin.insets = new Insets(0, 0, 5, 5);
		gbc_radioBtnKadin.gridx = 2;
		gbc_radioBtnKadin.gridy = 3;
		radioBtnKadin.setActionCommand(rdbtnErkek.getText());
		panelPersonelEkle.add(radioBtnKadin, gbc_radioBtnKadin);
		
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 4;
		panelPersonelEkle.add(lblEmail, gbc_lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		textFieldEmail.setColumns(10);
		GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
		gbc_textFieldEmail.anchor = GridBagConstraints.NORTH;
		gbc_textFieldEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEmail.gridwidth = 2;
		gbc_textFieldEmail.gridx = 1;
		gbc_textFieldEmail.gridy = 4;
		panelPersonelEkle.add(textFieldEmail, gbc_textFieldEmail);
		
		JLabel lblDogumTarihi = new JLabel("Dogum Tarihi:");
		lblDogumTarihi.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		GridBagConstraints gbc_lblDogumTarihi = new GridBagConstraints();
		gbc_lblDogumTarihi.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDogumTarihi.insets = new Insets(0, 0, 5, 5);
		gbc_lblDogumTarihi.gridx = 0;
		gbc_lblDogumTarihi.gridy = 5;
		panelPersonelEkle.add(lblDogumTarihi, gbc_lblDogumTarihi);
		
		final DatePicker datePicker = new DatePicker();
		datePicker.setBackground(Color.WHITE);
		GridBagConstraints gbc_datePicker = new GridBagConstraints();
		gbc_datePicker.anchor = GridBagConstraints.NORTH;
		gbc_datePicker.fill = GridBagConstraints.HORIZONTAL;
		gbc_datePicker.insets = new Insets(0, 0, 5, 5);
		gbc_datePicker.gridwidth = 2;
		gbc_datePicker.gridx = 1;
		gbc_datePicker.gridy = 5;
		panelPersonelEkle.add(datePicker, gbc_datePicker);
		
		JLabel lblTelefonNo = new JLabel("Telefon No:");
		lblTelefonNo.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		GridBagConstraints gbc_lblTelefonNo = new GridBagConstraints();
		gbc_lblTelefonNo.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblTelefonNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefonNo.gridx = 0;
		gbc_lblTelefonNo.gridy = 6;
		panelPersonelEkle.add(lblTelefonNo, gbc_lblTelefonNo);
		
		textFieldTel = new JTextField();
		textFieldTel.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		textFieldTel.setColumns(10);
		GridBagConstraints gbc_textFieldTel = new GridBagConstraints();
		gbc_textFieldTel.anchor = GridBagConstraints.NORTH;
		gbc_textFieldTel.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTel.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTel.gridwidth = 2;
		gbc_textFieldTel.gridx = 1;
		gbc_textFieldTel.gridy = 6;
		panelPersonelEkle.add(textFieldTel, gbc_textFieldTel);
		
		JLabel lblAdres = new JLabel("Adres:");
		lblAdres.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		GridBagConstraints gbc_lblAdres = new GridBagConstraints();
		gbc_lblAdres.anchor = GridBagConstraints.NORTH;
		gbc_lblAdres.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAdres.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdres.gridx = 0;
		gbc_lblAdres.gridy = 7;
		panelPersonelEkle.add(lblAdres, gbc_lblAdres);
		
		final JTextArea textAreaAdres = new JTextArea();
		textAreaAdres.setFont(new Font("JetBrains Mono", Font.BOLD, 9));
		GridBagConstraints gbc_textAreaAdres = new GridBagConstraints();
		gbc_textAreaAdres.fill = GridBagConstraints.BOTH;
		gbc_textAreaAdres.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaAdres.gridwidth = 2;
		gbc_textAreaAdres.gridx = 1;
		gbc_textAreaAdres.gridy = 7;
		panelPersonelEkle.add(textAreaAdres, gbc_textAreaAdres);
		
		JLabel lblYetkiPersonelEkle = new JLabel("Yetki:");
		lblYetkiPersonelEkle.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		GridBagConstraints gbc_lblYetkiPersonelEkle = new GridBagConstraints();
		gbc_lblYetkiPersonelEkle.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblYetkiPersonelEkle.insets = new Insets(0, 0, 5, 5);
		gbc_lblYetkiPersonelEkle.gridx = 0;
		gbc_lblYetkiPersonelEkle.gridy = 8;
		panelPersonelEkle.add(lblYetkiPersonelEkle, gbc_lblYetkiPersonelEkle);
		
		final JComboBox comboBoxYetki = new JComboBox();
		
		comboBoxYetki.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		comboBoxYetki.setBackground(Color.WHITE);
		GridBagConstraints gbc_comboBoxYetki = new GridBagConstraints();
		gbc_comboBoxYetki.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxYetki.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxYetki.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxYetki.gridwidth = 2;
		gbc_comboBoxYetki.gridx = 1;
		gbc_comboBoxYetki.gridy = 8;
		panelPersonelEkle.add(comboBoxYetki, gbc_comboBoxYetki);
		
		
		
		JLabel lblKullaniciAdi = new JLabel("Kullanici Adi:");
		lblKullaniciAdi.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		GridBagConstraints gbc_lblKullaniciAdi = new GridBagConstraints();
		gbc_lblKullaniciAdi.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblKullaniciAdi.insets = new Insets(0, 0, 5, 5);
		gbc_lblKullaniciAdi.gridx = 0;
		gbc_lblKullaniciAdi.gridy = 9;
		panelPersonelEkle.add(lblKullaniciAdi, gbc_lblKullaniciAdi);
		
		textFieldKullaniciAdi = new JTextField();
		textFieldKullaniciAdi.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		textFieldKullaniciAdi.setColumns(10);
		GridBagConstraints gbc_textFieldKullaniciAdi = new GridBagConstraints();
		gbc_textFieldKullaniciAdi.anchor = GridBagConstraints.NORTH;
		gbc_textFieldKullaniciAdi.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldKullaniciAdi.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldKullaniciAdi.gridwidth = 2;
		gbc_textFieldKullaniciAdi.gridx = 1;
		gbc_textFieldKullaniciAdi.gridy = 9;
		panelPersonelEkle.add(textFieldKullaniciAdi, gbc_textFieldKullaniciAdi);
		
		JLabel lblSifre = new JLabel("Sifre:");
		lblSifre.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		GridBagConstraints gbc_lblSifre = new GridBagConstraints();
		gbc_lblSifre.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSifre.insets = new Insets(0, 0, 5, 5);
		gbc_lblSifre.gridx = 0;
		gbc_lblSifre.gridy = 10;
		panelPersonelEkle.add(lblSifre, gbc_lblSifre);
		
		textFieldSifre = new JTextField();
		textFieldSifre.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		textFieldSifre.setColumns(10);
		GridBagConstraints gbc_textFieldSifre = new GridBagConstraints();
		gbc_textFieldSifre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldSifre.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldSifre.gridwidth = 2;
		gbc_textFieldSifre.gridx = 1;
		gbc_textFieldSifre.gridy = 10;
		panelPersonelEkle.add(textFieldSifre, gbc_textFieldSifre);
		
		JButton btnAutomaticPassword = new JButton("Otomatik Sifre");
		
		btnAutomaticPassword.setBackground(Color.WHITE);
		btnAutomaticPassword.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		GridBagConstraints gbc_btnAutomaticPassword = new GridBagConstraints();
		gbc_btnAutomaticPassword.anchor = GridBagConstraints.NORTH;
		gbc_btnAutomaticPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAutomaticPassword.insets = new Insets(0, 0, 5, 0);
		gbc_btnAutomaticPassword.gridx = 4;
		gbc_btnAutomaticPassword.gridy = 10;
		panelPersonelEkle.add(btnAutomaticPassword, gbc_btnAutomaticPassword);
		
		JButton btnKaydet = new JButton("Kaydet");
		
		btnKaydet.setBackground(Color.WHITE);
		btnKaydet.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		GridBagConstraints gbc_btnKaydet = new GridBagConstraints();
		gbc_btnKaydet.fill = GridBagConstraints.BOTH;
		gbc_btnKaydet.insets = new Insets(0, 0, 0, 5);
		gbc_btnKaydet.gridwidth = 2;
		gbc_btnKaydet.gridx = 1;
		gbc_btnKaydet.gridy = 11;
		panelPersonelEkle.add(btnKaydet, gbc_btnKaydet);
		
		
		
		final ButtonGroup group = new ButtonGroup();
		group.add(rdbtnErkek);
		group.add(radioBtnKadin);
		
		
		
		panelPersonelGuncelle.setBackground(Color.WHITE);
		GridBagLayout gbl_panelPersonelGuncelle = new GridBagLayout();
		gbl_panelPersonelGuncelle.columnWidths = new int[]{114, 86, 81, 33, 132, 0};
		gbl_panelPersonelGuncelle.rowHeights = new int[]{20, 20, 20, 23, 20, 20, 20, 55, 22, 20, 23, 44, 0};
		gbl_panelPersonelGuncelle.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelPersonelGuncelle.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelPersonelGuncelle.setLayout(gbl_panelPersonelGuncelle);
		
		JLabel labelTC = new JLabel("TC No:");
		labelTC.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		GridBagConstraints gbc_labelTC = new GridBagConstraints();
		gbc_labelTC.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelTC.insets = new Insets(0, 0, 5, 5);
		gbc_labelTC.gridx = 0;
		gbc_labelTC.gridy = 0;
		panelPersonelGuncelle.add(labelTC, gbc_labelTC);
		
		textFieldGuncelleTC = new JTextField();
		textFieldGuncelleTC.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		textFieldGuncelleTC.setColumns(10);
		GridBagConstraints gbc_textFieldGuncelleTC = new GridBagConstraints();
		gbc_textFieldGuncelleTC.anchor = GridBagConstraints.NORTH;
		gbc_textFieldGuncelleTC.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldGuncelleTC.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldGuncelleTC.gridwidth = 2;
		gbc_textFieldGuncelleTC.gridx = 1;
		gbc_textFieldGuncelleTC.gridy = 0;
		panelPersonelGuncelle.add(textFieldGuncelleTC, gbc_textFieldGuncelleTC);
		
		JLabel labelIsim = new JLabel("Isim:");
		labelIsim.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		GridBagConstraints gbc_labelIsim = new GridBagConstraints();
		gbc_labelIsim.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelIsim.insets = new Insets(0, 0, 5, 5);
		gbc_labelIsim.gridx = 0;
		gbc_labelIsim.gridy = 1;
		panelPersonelGuncelle.add(labelIsim, gbc_labelIsim);
		
		textFieldGuncelleIsim = new JTextField();
		textFieldGuncelleIsim.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		textFieldGuncelleIsim.setColumns(10);
		GridBagConstraints gbc_textFieldGuncelleIsim = new GridBagConstraints();
		gbc_textFieldGuncelleIsim.anchor = GridBagConstraints.NORTH;
		gbc_textFieldGuncelleIsim.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldGuncelleIsim.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldGuncelleIsim.gridwidth = 2;
		gbc_textFieldGuncelleIsim.gridx = 1;
		gbc_textFieldGuncelleIsim.gridy = 1;
		panelPersonelGuncelle.add(textFieldGuncelleIsim, gbc_textFieldGuncelleIsim);
		
		JLabel labelSoyIsim = new JLabel("SoyIsim:");
		labelSoyIsim.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		GridBagConstraints gbc_labelSoyIsim = new GridBagConstraints();
		gbc_labelSoyIsim.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelSoyIsim.insets = new Insets(0, 0, 5, 5);
		gbc_labelSoyIsim.gridx = 0;
		gbc_labelSoyIsim.gridy = 2;
		panelPersonelGuncelle.add(labelSoyIsim, gbc_labelSoyIsim);
		
		textFieldGuncelleSoyIsim = new JTextField();
		textFieldGuncelleSoyIsim.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		textFieldGuncelleSoyIsim.setColumns(10);
		GridBagConstraints gbc_textFieldGuncelleSoyIsim = new GridBagConstraints();
		gbc_textFieldGuncelleSoyIsim.anchor = GridBagConstraints.NORTH;
		gbc_textFieldGuncelleSoyIsim.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldGuncelleSoyIsim.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldGuncelleSoyIsim.gridwidth = 2;
		gbc_textFieldGuncelleSoyIsim.gridx = 1;
		gbc_textFieldGuncelleSoyIsim.gridy = 2;
		panelPersonelGuncelle.add(textFieldGuncelleSoyIsim, gbc_textFieldGuncelleSoyIsim);
		
		JLabel labelCinsiyet = new JLabel("Cinsiyet:");
		labelCinsiyet.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		GridBagConstraints gbc_labelCinsiyet = new GridBagConstraints();
		gbc_labelCinsiyet.anchor = GridBagConstraints.WEST;
		gbc_labelCinsiyet.insets = new Insets(0, 0, 5, 5);
		gbc_labelCinsiyet.gridx = 0;
		gbc_labelCinsiyet.gridy = 3;
		panelPersonelGuncelle.add(labelCinsiyet, gbc_labelCinsiyet);
		
		final JRadioButton radioButtonErkek = new JRadioButton("Erkek");
		radioButtonErkek.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		radioButtonErkek.setBackground(Color.WHITE);
		radioButtonErkek.setActionCommand("Erkek");
		GridBagConstraints gbc_radioButtonErkek = new GridBagConstraints();
		gbc_radioButtonErkek.anchor = GridBagConstraints.NORTH;
		gbc_radioButtonErkek.fill = GridBagConstraints.HORIZONTAL;
		gbc_radioButtonErkek.insets = new Insets(0, 0, 5, 5);
		gbc_radioButtonErkek.gridx = 1;
		gbc_radioButtonErkek.gridy = 3;
		
		panelPersonelGuncelle.add(radioButtonErkek, gbc_radioButtonErkek);
		
		final JRadioButton radioButtonKadin = new JRadioButton("Kadin");
		radioButtonKadin.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		radioButtonKadin.setBackground(Color.WHITE);
		radioButtonKadin.setActionCommand("Erkek");
		GridBagConstraints gbc_radioButtonKadin = new GridBagConstraints();
		gbc_radioButtonKadin.anchor = GridBagConstraints.NORTH;
		gbc_radioButtonKadin.fill = GridBagConstraints.HORIZONTAL;
		gbc_radioButtonKadin.insets = new Insets(0, 0, 5, 5);
		gbc_radioButtonKadin.gridx = 2;
		gbc_radioButtonKadin.gridy = 3;
		
		panelPersonelGuncelle.add(radioButtonKadin, gbc_radioButtonKadin);
		
		final ButtonGroup groupGuncelle = new ButtonGroup();
		groupGuncelle.add(radioButtonErkek);
		groupGuncelle.add(radioButtonKadin);
		radioButtonErkek.setActionCommand(radioButtonErkek.getText());
		radioButtonKadin.setActionCommand(radioButtonKadin.getText());
		
		JLabel labelEmail = new JLabel("Email:");
		labelEmail.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		GridBagConstraints gbc_labelEmail = new GridBagConstraints();
		gbc_labelEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelEmail.insets = new Insets(0, 0, 5, 5);
		gbc_labelEmail.gridx = 0;
		gbc_labelEmail.gridy = 4;
		panelPersonelGuncelle.add(labelEmail, gbc_labelEmail);
		
		textFieldGuncelleEmail = new JTextField();
		textFieldGuncelleEmail.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		textFieldGuncelleEmail.setColumns(10);
		GridBagConstraints gbc_textFieldGuncelleEmail = new GridBagConstraints();
		gbc_textFieldGuncelleEmail.anchor = GridBagConstraints.NORTH;
		gbc_textFieldGuncelleEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldGuncelleEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldGuncelleEmail.gridwidth = 2;
		gbc_textFieldGuncelleEmail.gridx = 1;
		gbc_textFieldGuncelleEmail.gridy = 4;
		panelPersonelGuncelle.add(textFieldGuncelleEmail, gbc_textFieldGuncelleEmail);
		
		JLabel labelDogumTarihi = new JLabel("Dogum Tarihi:");
		labelDogumTarihi.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		GridBagConstraints gbc_labelDogumTarihi = new GridBagConstraints();
		gbc_labelDogumTarihi.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelDogumTarihi.insets = new Insets(0, 0, 5, 5);
		gbc_labelDogumTarihi.gridx = 0;
		gbc_labelDogumTarihi.gridy = 5;
		panelPersonelGuncelle.add(labelDogumTarihi, gbc_labelDogumTarihi);
		
		final DatePicker datePickerGuncelle = new DatePicker();
		GridBagConstraints gbc_datePicker_1_1 = new GridBagConstraints();
		gbc_datePicker_1_1.anchor = GridBagConstraints.NORTH;
		gbc_datePicker_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_datePicker_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_datePicker_1_1.gridwidth = 2;
		gbc_datePicker_1_1.gridx = 1;
		gbc_datePicker_1_1.gridy = 5;
		panelPersonelGuncelle.add(datePickerGuncelle, gbc_datePicker_1_1);
		
		JLabel labelTel = new JLabel("Telefon No:");
		labelTel.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		GridBagConstraints gbc_labelTel = new GridBagConstraints();
		gbc_labelTel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_labelTel.insets = new Insets(0, 0, 5, 5);
		gbc_labelTel.gridx = 0;
		gbc_labelTel.gridy = 6;
		panelPersonelGuncelle.add(labelTel, gbc_labelTel);
		
		textFieldGuncelleTel = new JTextField();
		textFieldGuncelleTel.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		textFieldGuncelleTel.setColumns(10);
		GridBagConstraints gbc_textFieldGuncelleTel = new GridBagConstraints();
		gbc_textFieldGuncelleTel.anchor = GridBagConstraints.NORTH;
		gbc_textFieldGuncelleTel.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldGuncelleTel.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldGuncelleTel.gridwidth = 2;
		gbc_textFieldGuncelleTel.gridx = 1;
		gbc_textFieldGuncelleTel.gridy = 6;
		panelPersonelGuncelle.add(textFieldGuncelleTel, gbc_textFieldGuncelleTel);
		
		JLabel labelAdres = new JLabel("Adres:");
		labelAdres.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		GridBagConstraints gbc_labelAdres = new GridBagConstraints();
		gbc_labelAdres.anchor = GridBagConstraints.NORTH;
		gbc_labelAdres.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelAdres.insets = new Insets(0, 0, 5, 5);
		gbc_labelAdres.gridx = 0;
		gbc_labelAdres.gridy = 7;
		panelPersonelGuncelle.add(labelAdres, gbc_labelAdres);
		
		final JTextArea textAreaGuncelleAdres = new JTextArea();
		textAreaGuncelleAdres.setFont(new Font("JetBrains Mono", Font.BOLD, 9));
		GridBagConstraints gbc_textAreaGuncelleAdres = new GridBagConstraints();
		gbc_textAreaGuncelleAdres.fill = GridBagConstraints.BOTH;
		gbc_textAreaGuncelleAdres.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaGuncelleAdres.gridwidth = 2;
		gbc_textAreaGuncelleAdres.gridx = 1;
		gbc_textAreaGuncelleAdres.gridy = 7;
		panelPersonelGuncelle.add(textAreaGuncelleAdres, gbc_textAreaGuncelleAdres);
		
		JLabel labelYetki = new JLabel("Yetki:");
		labelYetki.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		GridBagConstraints gbc_labelYetki = new GridBagConstraints();
		gbc_labelYetki.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelYetki.insets = new Insets(0, 0, 5, 5);
		gbc_labelYetki.gridx = 0;
		gbc_labelYetki.gridy = 8;
		panelPersonelGuncelle.add(labelYetki, gbc_labelYetki);
		
		final JComboBox comboBoxGuncelleYetki = new JComboBox();
		comboBoxGuncelleYetki.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		comboBoxGuncelleYetki.setBackground(Color.WHITE);
		GridBagConstraints gbc_comboBoxGuncelleYetki = new GridBagConstraints();
		gbc_comboBoxGuncelleYetki.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxGuncelleYetki.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxGuncelleYetki.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxGuncelleYetki.gridwidth = 2;
		gbc_comboBoxGuncelleYetki.gridx = 1;
		gbc_comboBoxGuncelleYetki.gridy = 8;
		panelPersonelGuncelle.add(comboBoxGuncelleYetki, gbc_comboBoxGuncelleYetki);
		
		JLabel labelKullaniciAdi = new JLabel("Kullanici Adi:");
		labelKullaniciAdi.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		GridBagConstraints gbc_labelKullaniciAdi = new GridBagConstraints();
		gbc_labelKullaniciAdi.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelKullaniciAdi.insets = new Insets(0, 0, 5, 5);
		gbc_labelKullaniciAdi.gridx = 0;
		gbc_labelKullaniciAdi.gridy = 9;
		panelPersonelGuncelle.add(labelKullaniciAdi, gbc_labelKullaniciAdi);
		
		textFieldGuncelleKullaniciAdi = new JTextField();
		textFieldGuncelleKullaniciAdi.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		textFieldGuncelleKullaniciAdi.setColumns(10);
		GridBagConstraints gbc_textFieldGuncelleKullaniciAdi = new GridBagConstraints();
		gbc_textFieldGuncelleKullaniciAdi.anchor = GridBagConstraints.NORTH;
		gbc_textFieldGuncelleKullaniciAdi.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldGuncelleKullaniciAdi.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldGuncelleKullaniciAdi.gridwidth = 2;
		gbc_textFieldGuncelleKullaniciAdi.gridx = 1;
		gbc_textFieldGuncelleKullaniciAdi.gridy = 9;
		panelPersonelGuncelle.add(textFieldGuncelleKullaniciAdi, gbc_textFieldGuncelleKullaniciAdi);
		
		JLabel labelSifre = new JLabel("Sifre:");
		labelSifre.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		GridBagConstraints gbc_labelSifre = new GridBagConstraints();
		gbc_labelSifre.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelSifre.insets = new Insets(0, 0, 5, 5);
		gbc_labelSifre.gridx = 0;
		gbc_labelSifre.gridy = 10;
		panelPersonelGuncelle.add(labelSifre, gbc_labelSifre);
		
		textFieldGuncelleSifre = new JTextField();
		textFieldGuncelleSifre.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		textFieldGuncelleSifre.setColumns(10);
		GridBagConstraints gbc_textFieldGuncelleSifre = new GridBagConstraints();
		gbc_textFieldGuncelleSifre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldGuncelleSifre.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldGuncelleSifre.gridwidth = 2;
		gbc_textFieldGuncelleSifre.gridx = 1;
		gbc_textFieldGuncelleSifre.gridy = 10;
		panelPersonelGuncelle.add(textFieldGuncelleSifre, gbc_textFieldGuncelleSifre);
		
		JButton buttonGuncelleOtomatik = new JButton("Otomatik Sifre");
		buttonGuncelleOtomatik.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		buttonGuncelleOtomatik.setBackground(Color.WHITE);
		GridBagConstraints gbc_buttonGuncelleOtomatik = new GridBagConstraints();
		gbc_buttonGuncelleOtomatik.anchor = GridBagConstraints.NORTH;
		gbc_buttonGuncelleOtomatik.fill = GridBagConstraints.HORIZONTAL;
		gbc_buttonGuncelleOtomatik.insets = new Insets(0, 0, 5, 0);
		gbc_buttonGuncelleOtomatik.gridx = 4;
		gbc_buttonGuncelleOtomatik.gridy = 10;
		panelPersonelGuncelle.add(buttonGuncelleOtomatik, gbc_buttonGuncelleOtomatik);
		
		JButton buttonGuncelleKaydet = new JButton("Kaydet");
		
		buttonGuncelleKaydet.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		buttonGuncelleKaydet.setBackground(Color.WHITE);
		GridBagConstraints gbc_buttonGuncelleKaydet = new GridBagConstraints();
		gbc_buttonGuncelleKaydet.fill = GridBagConstraints.BOTH;
		gbc_buttonGuncelleKaydet.insets = new Insets(0, 0, 0, 5);
		gbc_buttonGuncelleKaydet.gridwidth = 2;
		gbc_buttonGuncelleKaydet.gridx = 1;
		gbc_buttonGuncelleKaydet.gridy = 11;
		panelPersonelGuncelle.add(buttonGuncelleKaydet, gbc_buttonGuncelleKaydet);
		
		// HAMMADDE PANELI
		
		panelHammadde.setBackground(Color.WHITE);
		GridBagLayout gbl_panelHammadde = new GridBagLayout();
		gbl_panelHammadde.columnWidths = new int[]{159, 159, 193, 0};
		gbl_panelHammadde.rowHeights = new int[]{41, 38, 48, 229, 0};
		gbl_panelHammadde.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelHammadde.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panelHammadde.setLayout(gbl_panelHammadde);
		
		JButton btnHammaddeEkle = new JButton("Yeni Hammadde Ekle");
		
		btnHammaddeEkle.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		btnHammaddeEkle.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnHammaddeEkle = new GridBagConstraints();
		gbc_btnHammaddeEkle.fill = GridBagConstraints.BOTH;
		gbc_btnHammaddeEkle.insets = new Insets(0, 0, 5, 5);
		gbc_btnHammaddeEkle.gridx = 0;
		gbc_btnHammaddeEkle.gridy = 0;
		panelHammadde.add(btnHammaddeEkle, gbc_btnHammaddeEkle);
		
		JButton btnHammaddeSil = new JButton("Hammadde Sil");
		
		btnHammaddeSil.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		btnHammaddeSil.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnHammaddeSil = new GridBagConstraints();
		gbc_btnHammaddeSil.fill = GridBagConstraints.BOTH;
		gbc_btnHammaddeSil.insets = new Insets(0, 0, 5, 5);
		gbc_btnHammaddeSil.gridx = 1;
		gbc_btnHammaddeSil.gridy = 0;
		panelHammadde.add(btnHammaddeSil, gbc_btnHammaddeSil);
		
		JButton btnHammaddeGuncelle = new JButton("Hammadde Guncelle");
		
		btnHammaddeGuncelle.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		btnHammaddeGuncelle.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnHammaddeGuncelle = new GridBagConstraints();
		gbc_btnHammaddeGuncelle.fill = GridBagConstraints.BOTH;
		gbc_btnHammaddeGuncelle.insets = new Insets(0, 0, 5, 0);
		gbc_btnHammaddeGuncelle.gridx = 2;
		gbc_btnHammaddeGuncelle.gridy = 0;
		panelHammadde.add(btnHammaddeGuncelle, gbc_btnHammaddeGuncelle);
		
		tableHammadde = new JTable();
		tableHammadde.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Hammadde Id", "Hammadde Adi", "Hammadde Tur"
			}
		));
		tableHammadde.getColumnModel().getColumn(1).setPreferredWidth(107);
		tableHammadde.getColumnModel().getColumn(2).setPreferredWidth(106);
		
		JButton btnYeniHammaddeTur = new JButton("Yeni Hammadde Tur");
		btnYeniHammaddeTur.setBackground(Color.WHITE);
		
		btnYeniHammaddeTur.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		GridBagConstraints gbc_btnYeniHammaddeTur = new GridBagConstraints();
		gbc_btnYeniHammaddeTur.fill = GridBagConstraints.BOTH;
		gbc_btnYeniHammaddeTur.insets = new Insets(0, 0, 5, 5);
		gbc_btnYeniHammaddeTur.gridx = 0;
		gbc_btnYeniHammaddeTur.gridy = 1;
		panelHammadde.add(btnYeniHammaddeTur, gbc_btnYeniHammaddeTur);
		
		JButton btnHammaddeTurSil = new JButton("Hammadde Tur Sil");
		
		btnHammaddeTurSil.setBackground(Color.WHITE);
		btnHammaddeTurSil.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		GridBagConstraints gbc_btnHammaddeTurSil = new GridBagConstraints();
		gbc_btnHammaddeTurSil.fill = GridBagConstraints.BOTH;
		gbc_btnHammaddeTurSil.insets = new Insets(0, 0, 5, 5);
		gbc_btnHammaddeTurSil.gridx = 1;
		gbc_btnHammaddeTurSil.gridy = 1;
		panelHammadde.add(btnHammaddeTurSil, gbc_btnHammaddeTurSil);
		
		JButton btnHammaddeTurGuncelle = new JButton("Hammadde Tur Guncelle");
		
		btnHammaddeTurGuncelle.setBackground(Color.WHITE);
		btnHammaddeTurGuncelle.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		GridBagConstraints gbc_btnHammaddeTurGuncelle = new GridBagConstraints();
		gbc_btnHammaddeTurGuncelle.fill = GridBagConstraints.BOTH;
		gbc_btnHammaddeTurGuncelle.insets = new Insets(0, 0, 5, 0);
		gbc_btnHammaddeTurGuncelle.gridx = 2;
		gbc_btnHammaddeTurGuncelle.gridy = 1;
		panelHammadde.add(btnHammaddeTurGuncelle, gbc_btnHammaddeTurGuncelle);
		
		final JComboBox comboBoxHammadde = new JComboBox();
		comboBoxHammadde.setBackground(Color.WHITE);
		
		comboBoxHammadde.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		GridBagConstraints gbc_comboBoxHammadde = new GridBagConstraints();
		gbc_comboBoxHammadde.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxHammadde.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxHammadde.gridx = 0;
		gbc_comboBoxHammadde.gridy = 2;
		panelHammadde.add(comboBoxHammadde, gbc_comboBoxHammadde);
		
		JButton btnGoster = new JButton("Goster");
		
		btnGoster.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		btnGoster.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnGoster = new GridBagConstraints();
		gbc_btnGoster.fill = GridBagConstraints.BOTH;
		gbc_btnGoster.insets = new Insets(0, 0, 5, 5);
		gbc_btnGoster.gridx = 1;
		gbc_btnGoster.gridy = 2;
		panelHammadde.add(btnGoster, gbc_btnGoster);
		
		JButton btnHepsiniGoster = new JButton("Hepsini Goster");
		
		btnHepsiniGoster.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		btnHepsiniGoster.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnHepsiniGoster = new GridBagConstraints();
		gbc_btnHepsiniGoster.fill = GridBagConstraints.BOTH;
		gbc_btnHepsiniGoster.insets = new Insets(0, 0, 5, 0);
		gbc_btnHepsiniGoster.gridx = 2;
		gbc_btnHepsiniGoster.gridy = 2;
		panelHammadde.add(btnHepsiniGoster, gbc_btnHepsiniGoster);
		tableHammadde.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		GridBagConstraints gbc_tableHammadde = new GridBagConstraints();
		gbc_tableHammadde.insets = new Insets(0, 0, 0, 5);
		gbc_tableHammadde.fill = GridBagConstraints.BOTH;
		gbc_tableHammadde.gridwidth = 2;
		gbc_tableHammadde.gridx = 0;
		gbc_tableHammadde.gridy = 3;
		panelHammadde.add(tableHammadde, gbc_tableHammadde);
		
		tableHammaddeTur = new JTable();
		tableHammaddeTur.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Hammadde Tur ID", "Hammadde Tur Adi"
			}
		));
		tableHammaddeTur.getColumnModel().getColumn(0).setPreferredWidth(109);
		tableHammaddeTur.getColumnModel().getColumn(1).setPreferredWidth(119);
		tableHammaddeTur.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		tableHammaddeTur.setBackground(Color.WHITE);
		GridBagConstraints gbc_tableHammaddeTur = new GridBagConstraints();
		gbc_tableHammaddeTur.fill = GridBagConstraints.BOTH;
		gbc_tableHammaddeTur.gridx = 2;
		gbc_tableHammaddeTur.gridy = 3;
		panelHammadde.add(tableHammaddeTur, gbc_tableHammaddeTur);
		
		
		panelHammaddeEkle.setBackground(Color.WHITE);
		GridBagLayout gbl_panelHammaddeEkle = new GridBagLayout();
		gbl_panelHammaddeEkle.columnWidths = new int[]{133, 186, 0};
		gbl_panelHammaddeEkle.rowHeights = new int[]{22, 40, 22, 48, 44, 0};
		gbl_panelHammaddeEkle.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelHammaddeEkle.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelHammaddeEkle.setLayout(gbl_panelHammaddeEkle);
		
		JLabel labelHammaddeAdi = new JLabel("Hammadde Adi:");
		labelHammaddeAdi.setBackground(Color.WHITE);
		labelHammaddeAdi.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		GridBagConstraints gbc_labelHammaddeAdi = new GridBagConstraints();
		gbc_labelHammaddeAdi.fill = GridBagConstraints.BOTH;
		gbc_labelHammaddeAdi.insets = new Insets(0, 0, 5, 5);
		gbc_labelHammaddeAdi.gridx = 0;
		gbc_labelHammaddeAdi.gridy = 0;
		panelHammaddeEkle.add(labelHammaddeAdi, gbc_labelHammaddeAdi);
		
		textFieldHammaddeAdi = new JTextField();
		textFieldHammaddeAdi.setBackground(Color.WHITE);
		textFieldHammaddeAdi.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		GridBagConstraints gbc_textFieldHammaddeAdi = new GridBagConstraints();
		gbc_textFieldHammaddeAdi.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldHammaddeAdi.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldHammaddeAdi.gridx = 1;
		gbc_textFieldHammaddeAdi.gridy = 0;
		panelHammaddeEkle.add(textFieldHammaddeAdi, gbc_textFieldHammaddeAdi);
		textFieldHammaddeAdi.setColumns(10);
		
		JLabel labelHammaddeTur = new JLabel("Hammadde Tur:");
		labelHammaddeTur.setBackground(Color.WHITE);
		labelHammaddeTur.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		GridBagConstraints gbc_labelHammaddeTur = new GridBagConstraints();
		gbc_labelHammaddeTur.fill = GridBagConstraints.BOTH;
		gbc_labelHammaddeTur.insets = new Insets(0, 0, 5, 5);
		gbc_labelHammaddeTur.gridx = 0;
		gbc_labelHammaddeTur.gridy = 2;
		panelHammaddeEkle.add(labelHammaddeTur, gbc_labelHammaddeTur);
		
		final JComboBox comboBoxHammaddeTurleri = new JComboBox();
		comboBoxHammaddeTurleri.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		comboBoxHammaddeTurleri.setBackground(Color.WHITE);
		GridBagConstraints gbc_comboBoxHammaddeTurleri = new GridBagConstraints();
		gbc_comboBoxHammaddeTurleri.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxHammaddeTurleri.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxHammaddeTurleri.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxHammaddeTurleri.gridx = 1;
		gbc_comboBoxHammaddeTurleri.gridy = 2;
		panelHammaddeEkle.add(comboBoxHammaddeTurleri, gbc_comboBoxHammaddeTurleri);
		
		JButton btnHammaddeKaydet = new JButton("Kaydet");
		
		btnHammaddeKaydet.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		btnHammaddeKaydet.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnHammaddeKaydet = new GridBagConstraints();
		gbc_btnHammaddeKaydet.fill = GridBagConstraints.BOTH;
		gbc_btnHammaddeKaydet.gridx = 1;
		gbc_btnHammaddeKaydet.gridy = 4;
		panelHammaddeEkle.add(btnHammaddeKaydet, gbc_btnHammaddeKaydet);
		
		btnHammaddeKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int hammaddeindex = Hammadde.GetHammaddeTurId(comboBoxHammaddeTurleri.getSelectedItem().toString());
				Hammadde hammadde = new Hammadde(textFieldHammaddeAdi.getText(), hammaddeindex);
				if(Hammadde.HammaddeEkle(hammadde)) {
					JOptionPane.showMessageDialog(null, "Hammadde basariyla kaydedildi");
					cardLayout.show(panels, HammaddeCard);
					connector.FillTable(tableHammadde, "select hammaddeId, hammaddeAdi, ht.hammaddeturAdi from hammadde as h left join hammaddetur as ht on h.hammaddeTur = ht.hammaddeturId");
				}
				else {
					JOptionPane.showMessageDialog(null, "Bir hata olustu!");
				}
			}
		});
		panelHammaddeGuncelle.setBackground(Color.WHITE);
		GridBagLayout gbl_panelHammaddeGuncelle = new GridBagLayout();
		gbl_panelHammaddeGuncelle.columnWidths = new int[]{133, 186, 0};
		gbl_panelHammaddeGuncelle.rowHeights = new int[]{22, 22, 40, 22, 48, 44, 0};
		gbl_panelHammaddeGuncelle.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelHammaddeGuncelle.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelHammaddeGuncelle.setLayout(gbl_panelHammaddeGuncelle);
		
		final JLabel labelHammaddeGuncelleId = new JLabel("HamIdde Adi:");
		labelHammaddeGuncelleId.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		labelHammaddeGuncelleId.setBackground(Color.WHITE);
		GridBagConstraints gbc_labelHammaddeGuncelleId = new GridBagConstraints();
		gbc_labelHammaddeGuncelleId.fill = GridBagConstraints.BOTH;
		gbc_labelHammaddeGuncelleId.insets = new Insets(0, 0, 5, 5);
		gbc_labelHammaddeGuncelleId.gridx = 0;
		gbc_labelHammaddeGuncelleId.gridy = 0;
		panelHammaddeGuncelle.add(labelHammaddeGuncelleId, gbc_labelHammaddeGuncelleId);
		
		final JLabel labelId = new JLabel("");
		labelId.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		labelId.setBackground(Color.WHITE);
		GridBagConstraints gbc_labelId = new GridBagConstraints();
		gbc_labelId.fill = GridBagConstraints.BOTH;
		gbc_labelId.insets = new Insets(0, 0, 5, 0);
		gbc_labelId.gridx = 1;
		gbc_labelId.gridy = 0;
		panelHammaddeGuncelle.add(labelId, gbc_labelId);
		
		JLabel labelHammaddeAdiGuncelle = new JLabel("Hammadde Adi:");
		labelHammaddeAdiGuncelle.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		labelHammaddeAdiGuncelle.setBackground(Color.WHITE);
		GridBagConstraints gbc_labelHammaddeAdiGuncelle = new GridBagConstraints();
		gbc_labelHammaddeAdiGuncelle.fill = GridBagConstraints.BOTH;
		gbc_labelHammaddeAdiGuncelle.insets = new Insets(0, 0, 5, 5);
		gbc_labelHammaddeAdiGuncelle.gridx = 0;
		gbc_labelHammaddeAdiGuncelle.gridy = 1;
		panelHammaddeGuncelle.add(labelHammaddeAdiGuncelle, gbc_labelHammaddeAdiGuncelle);
		
		textFieldHammaddeGuncelle = new JTextField();
		textFieldHammaddeGuncelle.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		textFieldHammaddeGuncelle.setColumns(10);
		textFieldHammaddeGuncelle.setBackground(Color.WHITE);
		GridBagConstraints gbc_textFieldHammaddeGuncelle = new GridBagConstraints();
		gbc_textFieldHammaddeGuncelle.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldHammaddeGuncelle.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldHammaddeGuncelle.gridx = 1;
		gbc_textFieldHammaddeGuncelle.gridy = 1;
		panelHammaddeGuncelle.add(textFieldHammaddeGuncelle, gbc_textFieldHammaddeGuncelle);
		
		JLabel labelHammaddeTurGuncelle = new JLabel("Hammadde Tur:");
		labelHammaddeTurGuncelle.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		labelHammaddeTurGuncelle.setBackground(Color.WHITE);
		GridBagConstraints gbc_labelHammaddeTurGuncelle = new GridBagConstraints();
		gbc_labelHammaddeTurGuncelle.fill = GridBagConstraints.BOTH;
		gbc_labelHammaddeTurGuncelle.insets = new Insets(0, 0, 5, 5);
		gbc_labelHammaddeTurGuncelle.gridx = 0;
		gbc_labelHammaddeTurGuncelle.gridy = 3;
		panelHammaddeGuncelle.add(labelHammaddeTurGuncelle, gbc_labelHammaddeTurGuncelle);
		
		
		final JComboBox comboBoxHammaddeGuncelle = new JComboBox();
		comboBoxHammaddeGuncelle.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		comboBoxHammaddeGuncelle.setBackground(Color.WHITE);
		GridBagConstraints gbc_comboBoxHammaddeGuncelle = new GridBagConstraints();
		gbc_comboBoxHammaddeGuncelle.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxHammaddeGuncelle.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxHammaddeGuncelle.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxHammaddeGuncelle.gridx = 1;
		gbc_comboBoxHammaddeGuncelle.gridy = 3;
		panelHammaddeGuncelle.add(comboBoxHammaddeGuncelle, gbc_comboBoxHammaddeGuncelle);
		
		JButton btnHammaddeGuncelleKaydet = new JButton("Kaydet");
		
		btnHammaddeGuncelleKaydet.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		btnHammaddeGuncelleKaydet.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnHammaddeGuncelleKaydet = new GridBagConstraints();
		gbc_btnHammaddeGuncelleKaydet.fill = GridBagConstraints.BOTH;
		gbc_btnHammaddeGuncelleKaydet.gridx = 1;
		gbc_btnHammaddeGuncelleKaydet.gridy = 5;
		panelHammaddeGuncelle.add(btnHammaddeGuncelleKaydet, gbc_btnHammaddeGuncelleKaydet);
		
		btnHammaddeGuncelleKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int turid = Hammadde.GetHammaddeTurId(comboBoxHammaddeGuncelle.getSelectedItem().toString());
				if(Hammadde.HammaddeGuncelle(labelId.getText(), textFieldHammaddeGuncelle.getText(), turid)) {
					JOptionPane.showMessageDialog(null, "Hammadde basariyla guncellendi");
					cardLayout.show(panels, HammaddeCard);
					connector.FillTable(tableHammadde, "select hammaddeId, hammaddeAdi, ht.hammaddeturAdi from hammadde as h left join hammaddetur as ht on h.hammaddeTur = ht.hammaddeturId");
				}else {
					JOptionPane.showMessageDialog(null, "Hammadde guncellenirken bir sorun olustu!");
				}
			}
		});
		
		
		panelYonetim.setBackground(Color.WHITE);
		
		panelYonetim.setLayout(null);
		
		JButton btnPersonelButton = new JButton("Personel Yonetim");
		
		btnPersonelButton.setBackground(Color.WHITE);
		btnPersonelButton.setBounds(10, 11, 252, 65);
		btnPersonelButton.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		panelYonetim.add(btnPersonelButton);
		
		JButton btnDepoYonetim = new JButton("Depo Yonetim");
		
		btnDepoYonetim.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		btnDepoYonetim.setBackground(Color.WHITE);
		btnDepoYonetim.setBounds(272, 11, 252, 65);
		panelYonetim.add(btnDepoYonetim);
		
		JButton btnFirmaYonetim = new JButton("Firma  Yonetim");
		
		btnFirmaYonetim.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		btnFirmaYonetim.setBackground(Color.WHITE);
		btnFirmaYonetim.setBounds(10, 87, 252, 65);
		panelYonetim.add(btnFirmaYonetim);
		
		JButton btnFirmaSatislar = new JButton("Firma  Satislar");
		
		btnFirmaSatislar.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		btnFirmaSatislar.setBackground(Color.WHITE);
		btnFirmaSatislar.setBounds(272, 87, 252, 65);
		panelYonetim.add(btnFirmaSatislar);
		
		JButton btnGunluk = new JButton("Gunluk");
		
		btnGunluk.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		btnGunluk.setBackground(Color.WHITE);
		btnGunluk.setBounds(10, 163, 252, 65);
		panelYonetim.add(btnGunluk);
		
		
		panelUrun.setBackground(Color.WHITE);
		
		GridBagLayout gbl_panelUrun = new GridBagLayout();
		gbl_panelUrun.columnWidths = new int[]{159, 159, 193, 0};
		gbl_panelUrun.rowHeights = new int[]{57, 84, 308, 0};
		gbl_panelUrun.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelUrun.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		panelUrun.setLayout(gbl_panelUrun);
		
		JButton btnUrunEkle = new JButton("Yeni Urun Ekle");
		
		btnUrunEkle.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		btnUrunEkle.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnUrunEkle = new GridBagConstraints();
		gbc_btnUrunEkle.fill = GridBagConstraints.BOTH;
		gbc_btnUrunEkle.insets = new Insets(0, 0, 5, 5);
		gbc_btnUrunEkle.gridx = 0;
		gbc_btnUrunEkle.gridy = 0;
		panelUrun.add(btnUrunEkle, gbc_btnUrunEkle);
		
		JButton btnUrunSil = new JButton("Urun Sil");
		
		btnUrunSil.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		btnUrunSil.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnUrunSil = new GridBagConstraints();
		gbc_btnUrunSil.fill = GridBagConstraints.BOTH;
		gbc_btnUrunSil.insets = new Insets(0, 0, 5, 5);
		gbc_btnUrunSil.gridx = 1;
		gbc_btnUrunSil.gridy = 0;
		panelUrun.add(btnUrunSil, gbc_btnUrunSil);
		
		JButton btnUrunGuncelle = new JButton("Urun Guncelle");
		
		btnUrunGuncelle.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		btnUrunGuncelle.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnUrunGuncelle = new GridBagConstraints();
		gbc_btnUrunGuncelle.fill = GridBagConstraints.BOTH;
		gbc_btnUrunGuncelle.insets = new Insets(0, 0, 5, 0);
		gbc_btnUrunGuncelle.gridx = 2;
		gbc_btnUrunGuncelle.gridy = 0;
		panelUrun.add(btnUrunGuncelle, gbc_btnUrunGuncelle);
		
		tableUrun = new JTable();
		tableUrun.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Urun ID", "Urun Adi", "Urun Aciklamasi", "Kagit", "Boya", "Yapistirici", "Fiyat"
			}
		));
		tableUrun.getColumnModel().getColumn(2).setPreferredWidth(104);
		tableUrun.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		GridBagConstraints gbc_tableUrun = new GridBagConstraints();
		gbc_tableUrun.fill = GridBagConstraints.BOTH;
		gbc_tableUrun.gridwidth = 3;
		gbc_tableUrun.gridx = 0;
		gbc_tableUrun.gridy = 2;
		panelUrun.add(tableUrun, gbc_tableUrun);
		
		
		panelUrunEkle.setBackground(Color.WHITE);
		GridBagLayout gbl_panelUrunEkle = new GridBagLayout();
		gbl_panelUrunEkle.columnWidths = new int[]{106, 42, 214, 30, 97, 150, 0};
		gbl_panelUrunEkle.rowHeights = new int[]{14, 22, 22, 81, 14, 20, 46, 51, 0};
		gbl_panelUrunEkle.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelUrunEkle.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelUrunEkle.setLayout(gbl_panelUrunEkle);
		
		JLabel lblHammaddeler = new JLabel("Kullanilan Hammaddeler");
		lblHammaddeler.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		GridBagConstraints gbc_lblHammaddeler = new GridBagConstraints();
		gbc_lblHammaddeler.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblHammaddeler.insets = new Insets(0, 0, 5, 0);
		gbc_lblHammaddeler.gridwidth = 2;
		gbc_lblHammaddeler.gridx = 4;
		gbc_lblHammaddeler.gridy = 0;
		panelUrunEkle.add(lblHammaddeler, gbc_lblHammaddeler);
		
		JLabel lblUrunAdi = new JLabel("Urun Adi:");
		lblUrunAdi.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		GridBagConstraints gbc_lblUrunAdi = new GridBagConstraints();
		gbc_lblUrunAdi.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblUrunAdi.insets = new Insets(0, 0, 5, 5);
		gbc_lblUrunAdi.gridx = 0;
		gbc_lblUrunAdi.gridy = 1;
		panelUrunEkle.add(lblUrunAdi, gbc_lblUrunAdi);
		
		textFieldUrunAdi = new JTextField();
		textFieldUrunAdi.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		GridBagConstraints gbc_textFieldUrunAdi = new GridBagConstraints();
		gbc_textFieldUrunAdi.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldUrunAdi.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldUrunAdi.gridx = 2;
		gbc_textFieldUrunAdi.gridy = 1;
		panelUrunEkle.add(textFieldUrunAdi, gbc_textFieldUrunAdi);
		textFieldUrunAdi.setColumns(10);
		
		JLabel labelKagit = new JLabel("Kagit:");
		labelKagit.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		GridBagConstraints gbc_labelKagit = new GridBagConstraints();
		gbc_labelKagit.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelKagit.insets = new Insets(0, 0, 5, 5);
		gbc_labelKagit.gridx = 4;
		gbc_labelKagit.gridy = 1;
		panelUrunEkle.add(labelKagit, gbc_labelKagit);
		
		final JComboBox comboBoxKagit = new JComboBox();
		comboBoxKagit.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		GridBagConstraints gbc_comboBoxKagit = new GridBagConstraints();
		gbc_comboBoxKagit.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxKagit.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxKagit.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxKagit.gridx = 5;
		gbc_comboBoxKagit.gridy = 1;
		panelUrunEkle.add(comboBoxKagit, gbc_comboBoxKagit);
		
		JLabel lblUrunAciklamasi = new JLabel("Urun Aciklamasi");
		lblUrunAciklamasi.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		GridBagConstraints gbc_lblUrunAciklamasi = new GridBagConstraints();
		gbc_lblUrunAciklamasi.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblUrunAciklamasi.insets = new Insets(0, 0, 5, 5);
		gbc_lblUrunAciklamasi.gridx = 0;
		gbc_lblUrunAciklamasi.gridy = 2;
		panelUrunEkle.add(lblUrunAciklamasi, gbc_lblUrunAciklamasi);
		
		final JTextArea textAreaUrunAciklamasi = new JTextArea();
		textAreaUrunAciklamasi.setFont(new Font("JetBrains Mono", Font.BOLD, 9));
		GridBagConstraints gbc_textAreaUrunAciklamasi = new GridBagConstraints();
		gbc_textAreaUrunAciklamasi.fill = GridBagConstraints.BOTH;
		gbc_textAreaUrunAciklamasi.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaUrunAciklamasi.gridheight = 2;
		gbc_textAreaUrunAciklamasi.gridx = 2;
		gbc_textAreaUrunAciklamasi.gridy = 2;
		panelUrunEkle.add(textAreaUrunAciklamasi, gbc_textAreaUrunAciklamasi);
		
		JLabel labelBoya = new JLabel("Boya:");
		labelBoya.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		GridBagConstraints gbc_labelBoya = new GridBagConstraints();
		gbc_labelBoya.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelBoya.insets = new Insets(0, 0, 5, 5);
		gbc_labelBoya.gridx = 4;
		gbc_labelBoya.gridy = 2;
		panelUrunEkle.add(labelBoya, gbc_labelBoya);
		
		final JComboBox comboBoxBoya = new JComboBox();
		comboBoxBoya.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		GridBagConstraints gbc_comboBoxBoya = new GridBagConstraints();
		gbc_comboBoxBoya.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxBoya.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxBoya.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxBoya.gridx = 5;
		gbc_comboBoxBoya.gridy = 2;
		panelUrunEkle.add(comboBoxBoya, gbc_comboBoxBoya);
		
		JLabel lblYapistirici = new JLabel("Yapistirici:");
		lblYapistirici.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		GridBagConstraints gbc_lblYapistirici = new GridBagConstraints();
		gbc_lblYapistirici.anchor = GridBagConstraints.NORTH;
		gbc_lblYapistirici.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblYapistirici.insets = new Insets(0, 0, 5, 5);
		gbc_lblYapistirici.gridx = 4;
		gbc_lblYapistirici.gridy = 3;
		panelUrunEkle.add(lblYapistirici, gbc_lblYapistirici);
		
		final JComboBox comboBoxYapistirici = new JComboBox();
		comboBoxYapistirici.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		GridBagConstraints gbc_comboBoxYapistirici = new GridBagConstraints();
		gbc_comboBoxYapistirici.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxYapistirici.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxYapistirici.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxYapistirici.gridx = 5;
		gbc_comboBoxYapistirici.gridy = 3;
		panelUrunEkle.add(comboBoxYapistirici, gbc_comboBoxYapistirici);
		
		JLabel lblMaxKarakter = new JLabel("Maksimum 90 karakter giriniz");
		lblMaxKarakter.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		GridBagConstraints gbc_lblMaxKarakter = new GridBagConstraints();
		gbc_lblMaxKarakter.anchor = GridBagConstraints.NORTH;
		gbc_lblMaxKarakter.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblMaxKarakter.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaxKarakter.gridx = 2;
		gbc_lblMaxKarakter.gridy = 4;
		panelUrunEkle.add(lblMaxKarakter, gbc_lblMaxKarakter);
		
		JLabel lblFiyat = new JLabel("Fiyat:");
		lblFiyat.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		GridBagConstraints gbc_lblFiyat = new GridBagConstraints();
		gbc_lblFiyat.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFiyat.insets = new Insets(0, 0, 5, 5);
		gbc_lblFiyat.gridx = 0;
		gbc_lblFiyat.gridy = 5;
		panelUrunEkle.add(lblFiyat, gbc_lblFiyat);
		
		textFieldFiyat = new JTextField();
		GridBagConstraints gbc_textFieldFiyat = new GridBagConstraints();
		gbc_textFieldFiyat.anchor = GridBagConstraints.NORTH;
		gbc_textFieldFiyat.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFiyat.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldFiyat.gridx = 2;
		gbc_textFieldFiyat.gridy = 5;
		panelUrunEkle.add(textFieldFiyat, gbc_textFieldFiyat);
		textFieldFiyat.setColumns(10);
		
		JButton btnUrunKaydet = new JButton("Urunu Kaydet");
		
		btnUrunKaydet.setBackground(Color.WHITE);
		btnUrunKaydet.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		GridBagConstraints gbc_btnUrunKaydet = new GridBagConstraints();
		gbc_btnUrunKaydet.fill = GridBagConstraints.BOTH;
		gbc_btnUrunKaydet.insets = new Insets(0, 0, 0, 5);
		gbc_btnUrunKaydet.gridx = 2;
		gbc_btnUrunKaydet.gridy = 7;
		panelUrunEkle.add(btnUrunKaydet, gbc_btnUrunKaydet);
		
		
		
		
		panelUrunGuncelle.setBackground(Color.WHITE);
		
		GridBagLayout gbl_panelUrunGuncelle = new GridBagLayout();
		gbl_panelUrunGuncelle.columnWidths = new int[]{106, 42, 214, 30, 97, 150, 0};
		gbl_panelUrunGuncelle.rowHeights = new int[]{14, 22, 22, 81, 14, 20, 46, 51, 0};
		gbl_panelUrunGuncelle.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelUrunGuncelle.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelUrunGuncelle.setLayout(gbl_panelUrunGuncelle);
		
		JLabel labelUrunIdGuncelle = new JLabel("Urun ID:");
		labelUrunIdGuncelle.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		GridBagConstraints gbc_labelUrunIdGuncelle = new GridBagConstraints();
		gbc_labelUrunIdGuncelle.insets = new Insets(0, 0, 5, 5);
		gbc_labelUrunIdGuncelle.gridx = 0;
		gbc_labelUrunIdGuncelle.gridy = 0;
		panelUrunGuncelle.add(labelUrunIdGuncelle, gbc_labelUrunIdGuncelle);
		
		final JLabel labelUrunGuncelleID = new JLabel("");
		labelUrunGuncelleID.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		GridBagConstraints gbc_labelUrunGuncelleID = new GridBagConstraints();
		gbc_labelUrunGuncelleID.insets = new Insets(0, 0, 5, 5);
		gbc_labelUrunGuncelleID.gridx = 1;
		gbc_labelUrunGuncelleID.gridy = 0;
		panelUrunGuncelle.add(labelUrunGuncelleID, gbc_labelUrunGuncelleID);
		
		JLabel labelKullanilanHammaddelerGuncelle = new JLabel("Kullanilan Hammaddeler");
		labelKullanilanHammaddelerGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		GridBagConstraints gbc_labelKullanilanHammaddelerGuncelle = new GridBagConstraints();
		gbc_labelKullanilanHammaddelerGuncelle.anchor = GridBagConstraints.NORTHEAST;
		gbc_labelKullanilanHammaddelerGuncelle.insets = new Insets(0, 0, 5, 0);
		gbc_labelKullanilanHammaddelerGuncelle.gridwidth = 2;
		gbc_labelKullanilanHammaddelerGuncelle.gridx = 4;
		gbc_labelKullanilanHammaddelerGuncelle.gridy = 0;
		panelUrunGuncelle.add(labelKullanilanHammaddelerGuncelle, gbc_labelKullanilanHammaddelerGuncelle);
		
		JLabel labelUrunAdiGuncelle = new JLabel("Urun Adi:");
		labelUrunAdiGuncelle.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		GridBagConstraints gbc_labelUrunAdiGuncelle = new GridBagConstraints();
		gbc_labelUrunAdiGuncelle.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelUrunAdiGuncelle.insets = new Insets(0, 0, 5, 5);
		gbc_labelUrunAdiGuncelle.gridx = 0;
		gbc_labelUrunAdiGuncelle.gridy = 1;
		panelUrunGuncelle.add(labelUrunAdiGuncelle, gbc_labelUrunAdiGuncelle);
		
		textFieldUrunAdiGuncelle = new JTextField();
		textFieldUrunAdiGuncelle.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		textFieldUrunAdiGuncelle.setColumns(10);
		GridBagConstraints gbc_textFieldUrunAdiGuncelle = new GridBagConstraints();
		gbc_textFieldUrunAdiGuncelle.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldUrunAdiGuncelle.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldUrunAdiGuncelle.gridx = 2;
		gbc_textFieldUrunAdiGuncelle.gridy = 1;
		panelUrunGuncelle.add(textFieldUrunAdiGuncelle, gbc_textFieldUrunAdiGuncelle);
		
		JLabel labelKagitGuncelle = new JLabel("Kagit:");
		labelKagitGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		GridBagConstraints gbc_labelKagitGuncelle = new GridBagConstraints();
		gbc_labelKagitGuncelle.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelKagitGuncelle.insets = new Insets(0, 0, 5, 5);
		gbc_labelKagitGuncelle.gridx = 4;
		gbc_labelKagitGuncelle.gridy = 1;
		panelUrunGuncelle.add(labelKagitGuncelle, gbc_labelKagitGuncelle);
		
		final JComboBox comboBoxKagitGuncelle = new JComboBox();
		comboBoxKagitGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		GridBagConstraints gbc_comboBoxKagitGuncelle = new GridBagConstraints();
		gbc_comboBoxKagitGuncelle.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxKagitGuncelle.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxKagitGuncelle.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxKagitGuncelle.gridx = 5;
		gbc_comboBoxKagitGuncelle.gridy = 1;
		panelUrunGuncelle.add(comboBoxKagitGuncelle, gbc_comboBoxKagitGuncelle);
		
		JLabel labelUrunAciklamasiGuncelle = new JLabel("Urun Aciklamasi");
		labelUrunAciklamasiGuncelle.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		GridBagConstraints gbc_labelUrunAciklamasiGuncelle = new GridBagConstraints();
		gbc_labelUrunAciklamasiGuncelle.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelUrunAciklamasiGuncelle.insets = new Insets(0, 0, 5, 5);
		gbc_labelUrunAciklamasiGuncelle.gridx = 0;
		gbc_labelUrunAciklamasiGuncelle.gridy = 2;
		panelUrunGuncelle.add(labelUrunAciklamasiGuncelle, gbc_labelUrunAciklamasiGuncelle);
		
		final JTextArea textAreaUrunAciklamasiGuncelle = new JTextArea();
		textAreaUrunAciklamasiGuncelle.setFont(new Font("JetBrains Mono", Font.BOLD, 9));
		GridBagConstraints gbc_textAreaUrunAciklamasiGuncelle = new GridBagConstraints();
		gbc_textAreaUrunAciklamasiGuncelle.fill = GridBagConstraints.BOTH;
		gbc_textAreaUrunAciklamasiGuncelle.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaUrunAciklamasiGuncelle.gridheight = 2;
		gbc_textAreaUrunAciklamasiGuncelle.gridx = 2;
		gbc_textAreaUrunAciklamasiGuncelle.gridy = 2;
		panelUrunGuncelle.add(textAreaUrunAciklamasiGuncelle, gbc_textAreaUrunAciklamasiGuncelle);
		
		JLabel labelBoyaGuncelle = new JLabel("Boya:");
		labelBoyaGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		GridBagConstraints gbc_labelBoyaGuncelle = new GridBagConstraints();
		gbc_labelBoyaGuncelle.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelBoyaGuncelle.insets = new Insets(0, 0, 5, 5);
		gbc_labelBoyaGuncelle.gridx = 4;
		gbc_labelBoyaGuncelle.gridy = 2;
		panelUrunGuncelle.add(labelBoyaGuncelle, gbc_labelBoyaGuncelle);
		
		final JComboBox comboBoxBoyaGuncelle = new JComboBox();
		comboBoxBoyaGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		GridBagConstraints gbc_comboBoxBoyaGuncelle = new GridBagConstraints();
		gbc_comboBoxBoyaGuncelle.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxBoyaGuncelle.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxBoyaGuncelle.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxBoyaGuncelle.gridx = 5;
		gbc_comboBoxBoyaGuncelle.gridy = 2;
		panelUrunGuncelle.add(comboBoxBoyaGuncelle, gbc_comboBoxBoyaGuncelle);
		
		JLabel labelYapistiriciGuncelle = new JLabel("Yapistirici:");
		labelYapistiriciGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		GridBagConstraints gbc_labelYapistiriciGuncelle = new GridBagConstraints();
		gbc_labelYapistiriciGuncelle.anchor = GridBagConstraints.NORTH;
		gbc_labelYapistiriciGuncelle.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelYapistiriciGuncelle.insets = new Insets(0, 0, 5, 5);
		gbc_labelYapistiriciGuncelle.gridx = 4;
		gbc_labelYapistiriciGuncelle.gridy = 3;
		panelUrunGuncelle.add(labelYapistiriciGuncelle, gbc_labelYapistiriciGuncelle);
		
		final JComboBox comboBoxYapistiriciGuncelle = new JComboBox();
		comboBoxYapistiriciGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		GridBagConstraints gbc_comboBoxYapistiriciGuncelle = new GridBagConstraints();
		gbc_comboBoxYapistiriciGuncelle.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxYapistiriciGuncelle.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxYapistiriciGuncelle.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxYapistiriciGuncelle.gridx = 5;
		gbc_comboBoxYapistiriciGuncelle.gridy = 3;
		panelUrunGuncelle.add(comboBoxYapistiriciGuncelle, gbc_comboBoxYapistiriciGuncelle);
		
		JLabel labelDurumTextGuncelle = new JLabel("Maksimum 90 karakter giriniz");
		labelDurumTextGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		GridBagConstraints gbc_labelDurumTextGuncelle = new GridBagConstraints();
		gbc_labelDurumTextGuncelle.anchor = GridBagConstraints.NORTH;
		gbc_labelDurumTextGuncelle.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelDurumTextGuncelle.insets = new Insets(0, 0, 5, 5);
		gbc_labelDurumTextGuncelle.gridx = 2;
		gbc_labelDurumTextGuncelle.gridy = 4;
		panelUrunGuncelle.add(labelDurumTextGuncelle, gbc_labelDurumTextGuncelle);
		
		JLabel labelUrunFiyatGuncelle = new JLabel("Fiyat:");
		labelUrunFiyatGuncelle.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		GridBagConstraints gbc_labelUrunFiyatGuncelle = new GridBagConstraints();
		gbc_labelUrunFiyatGuncelle.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelUrunFiyatGuncelle.insets = new Insets(0, 0, 5, 5);
		gbc_labelUrunFiyatGuncelle.gridx = 0;
		gbc_labelUrunFiyatGuncelle.gridy = 5;
		panelUrunGuncelle.add(labelUrunFiyatGuncelle, gbc_labelUrunFiyatGuncelle);
		
		textFieldFiyatGuncelle = new JTextField();
		textFieldFiyatGuncelle.setColumns(10);
		GridBagConstraints gbc_textFieldFiyatGuncelle = new GridBagConstraints();
		gbc_textFieldFiyatGuncelle.anchor = GridBagConstraints.NORTH;
		gbc_textFieldFiyatGuncelle.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFiyatGuncelle.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldFiyatGuncelle.gridx = 2;
		gbc_textFieldFiyatGuncelle.gridy = 5;
		panelUrunGuncelle.add(textFieldFiyatGuncelle, gbc_textFieldFiyatGuncelle);
		
		JButton btnUrunuGuncelle = new JButton("Urunu Guncelle");
		
		btnUrunuGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		btnUrunuGuncelle.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnUrunuGuncelle = new GridBagConstraints();
		gbc_btnUrunuGuncelle.fill = GridBagConstraints.BOTH;
		gbc_btnUrunuGuncelle.insets = new Insets(0, 0, 0, 5);
		gbc_btnUrunuGuncelle.gridx = 2;
		gbc_btnUrunuGuncelle.gridy = 7;
		panelUrunGuncelle.add(btnUrunuGuncelle, gbc_btnUrunuGuncelle);
		
		
		
	
		panelDepoYonetim.setBackground(Color.WHITE);
		GridBagLayout gbl_panelDepoYonetim = new GridBagLayout();
		gbl_panelDepoYonetim.columnWidths = new int[]{229, 99, 64, 66, 262, 0};
		gbl_panelDepoYonetim.rowHeights = new int[]{38, 41, 14, 317, 0};
		gbl_panelDepoYonetim.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelDepoYonetim.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelDepoYonetim.setLayout(gbl_panelDepoYonetim);
		
		JButton btnDepoEkle = new JButton("Yeni Depo Ekle");
		
		btnDepoEkle.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		btnDepoEkle.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnDepoEkle = new GridBagConstraints();
		gbc_btnDepoEkle.fill = GridBagConstraints.BOTH;
		gbc_btnDepoEkle.insets = new Insets(0, 0, 5, 5);
		gbc_btnDepoEkle.gridx = 0;
		gbc_btnDepoEkle.gridy = 0;
		panelDepoYonetim.add(btnDepoEkle, gbc_btnDepoEkle);
		
		
		
		JButton btnDepoSil = new JButton("Depo Sil");
		
		btnDepoSil.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		btnDepoSil.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnDepoSil = new GridBagConstraints();
		gbc_btnDepoSil.fill = GridBagConstraints.BOTH;
		gbc_btnDepoSil.insets = new Insets(0, 0, 5, 5);
		gbc_btnDepoSil.gridwidth = 3;
		gbc_btnDepoSil.gridx = 1;
		gbc_btnDepoSil.gridy = 0;
		panelDepoYonetim.add(btnDepoSil, gbc_btnDepoSil);
		
		JButton btnDepoGuncelle = new JButton("Depo Guncelle");
		
		btnDepoGuncelle.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
		btnDepoGuncelle.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnDepoGuncelle = new GridBagConstraints();
		gbc_btnDepoGuncelle.fill = GridBagConstraints.BOTH;
		gbc_btnDepoGuncelle.insets = new Insets(0, 0, 5, 0);
		gbc_btnDepoGuncelle.gridx = 4;
		gbc_btnDepoGuncelle.gridy = 0;
		panelDepoYonetim.add(btnDepoGuncelle, gbc_btnDepoGuncelle);
		
		JLabel labelUrunDepo = new JLabel("Urun Deposu");
		labelUrunDepo.setHorizontalAlignment(SwingConstants.CENTER);
		labelUrunDepo.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		GridBagConstraints gbc_labelUrunDepo = new GridBagConstraints();
		gbc_labelUrunDepo.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelUrunDepo.anchor = GridBagConstraints.NORTH;
		gbc_labelUrunDepo.insets = new Insets(0, 0, 5, 5);
		gbc_labelUrunDepo.gridx = 0;
		gbc_labelUrunDepo.gridy = 2;
		panelDepoYonetim.add(labelUrunDepo, gbc_labelUrunDepo);
		
		JLabel labelHammaddeDeposu = new JLabel("Hammadde Deposu");
		labelHammaddeDeposu.setHorizontalAlignment(SwingConstants.CENTER);
		labelHammaddeDeposu.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		GridBagConstraints gbc_labelHammaddeDeposu = new GridBagConstraints();
		gbc_labelHammaddeDeposu.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelHammaddeDeposu.anchor = GridBagConstraints.NORTH;
		gbc_labelHammaddeDeposu.insets = new Insets(0, 0, 5, 0);
		gbc_labelHammaddeDeposu.gridx = 4;
		gbc_labelHammaddeDeposu.gridy = 2;
		panelDepoYonetim.add(labelHammaddeDeposu, gbc_labelHammaddeDeposu);
		
		tableUrunDepo = new JTable();
		tableUrunDepo.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Depo ID", "Depo Adi", "Personel", "Depo Turu"
			}
		));
		tableUrunDepo.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		GridBagConstraints gbc_tableUrunDepo = new GridBagConstraints();
		gbc_tableUrunDepo.fill = GridBagConstraints.BOTH;
		gbc_tableUrunDepo.insets = new Insets(0, 0, 0, 5);
		gbc_tableUrunDepo.gridwidth = 2;
		gbc_tableUrunDepo.gridx = 0;
		gbc_tableUrunDepo.gridy = 3;
		panelDepoYonetim.add(tableUrunDepo, gbc_tableUrunDepo);
		
		tableHammaddeDepo = new JTable();
		tableHammaddeDepo.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Depo ID", "Depo Adi", "Personel", "Depo Turu"
			}
		));
		tableHammaddeDepo.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		GridBagConstraints gbc_tableHammaddeDepo = new GridBagConstraints();
		gbc_tableHammaddeDepo.fill = GridBagConstraints.BOTH;
		gbc_tableHammaddeDepo.gridwidth = 2;
		gbc_tableHammaddeDepo.gridx = 3;
		gbc_tableHammaddeDepo.gridy = 3;
		panelDepoYonetim.add(tableHammaddeDepo, gbc_tableHammaddeDepo);
		
		
		panelDepoEkle.setBackground(Color.WHITE);
		GridBagLayout gbl_panelDepoEkle = new GridBagLayout();
		gbl_panelDepoEkle.columnWidths = new int[]{98, 188, 0};
		gbl_panelDepoEkle.rowHeights = new int[]{53, 20, 20, 22, 34, 41, 0};
		gbl_panelDepoEkle.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelDepoEkle.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelDepoEkle.setLayout(gbl_panelDepoEkle);
		
		JLabel labelDepoAdi = new JLabel("Depo Adi:");
		labelDepoAdi.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		GridBagConstraints gbc_labelDepoAdi = new GridBagConstraints();
		gbc_labelDepoAdi.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelDepoAdi.insets = new Insets(0, 0, 5, 5);
		gbc_labelDepoAdi.gridx = 0;
		gbc_labelDepoAdi.gridy = 1;
		panelDepoEkle.add(labelDepoAdi, gbc_labelDepoAdi);
		
		textFieldDepoAdi = new JTextField();
		textFieldDepoAdi.setBackground(Color.WHITE);
		textFieldDepoAdi.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		GridBagConstraints gbc_textFieldDepoAdi = new GridBagConstraints();
		gbc_textFieldDepoAdi.anchor = GridBagConstraints.NORTH;
		gbc_textFieldDepoAdi.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDepoAdi.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDepoAdi.gridx = 1;
		gbc_textFieldDepoAdi.gridy = 1;
		panelDepoEkle.add(textFieldDepoAdi, gbc_textFieldDepoAdi);
		textFieldDepoAdi.setColumns(10);
		
		JLabel lblPersonel = new JLabel("Personel ID:");
		lblPersonel.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		GridBagConstraints gbc_lblPersonel = new GridBagConstraints();
		gbc_lblPersonel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPersonel.insets = new Insets(0, 0, 5, 5);
		gbc_lblPersonel.gridx = 0;
		gbc_lblPersonel.gridy = 2;
		panelDepoEkle.add(lblPersonel, gbc_lblPersonel);
		
		textFieldPersonelId = new JTextField();
		textFieldPersonelId.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		textFieldPersonelId.setColumns(10);
		textFieldPersonelId.setBackground(Color.WHITE);
		GridBagConstraints gbc_textFieldPersonelId = new GridBagConstraints();
		gbc_textFieldPersonelId.anchor = GridBagConstraints.NORTH;
		gbc_textFieldPersonelId.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPersonelId.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPersonelId.gridx = 1;
		gbc_textFieldPersonelId.gridy = 2;
		panelDepoEkle.add(textFieldPersonelId, gbc_textFieldPersonelId);
		
		JLabel labelDepoTur = new JLabel("Depo Turu:");
		labelDepoTur.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		GridBagConstraints gbc_labelDepoTur = new GridBagConstraints();
		gbc_labelDepoTur.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelDepoTur.insets = new Insets(0, 0, 5, 5);
		gbc_labelDepoTur.gridx = 0;
		gbc_labelDepoTur.gridy = 3;
		panelDepoEkle.add(labelDepoTur, gbc_labelDepoTur);
		
		final JComboBox comboBoxDepoTur = new JComboBox();
		comboBoxDepoTur.setBackground(Color.WHITE);
		comboBoxDepoTur.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		GridBagConstraints gbc_comboBoxDepoTur = new GridBagConstraints();
		gbc_comboBoxDepoTur.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxDepoTur.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxDepoTur.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxDepoTur.gridx = 1;
		gbc_comboBoxDepoTur.gridy = 3;
		panelDepoEkle.add(comboBoxDepoTur, gbc_comboBoxDepoTur);
		
		JButton btnDepoKaydet = new JButton("Depoyu Kaydet");
		
		btnDepoKaydet.setBackground(Color.WHITE);
		btnDepoKaydet.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		GridBagConstraints gbc_btnDepoKaydet = new GridBagConstraints();
		gbc_btnDepoKaydet.fill = GridBagConstraints.BOTH;
		gbc_btnDepoKaydet.gridx = 1;
		gbc_btnDepoKaydet.gridy = 5;
		panelDepoEkle.add(btnDepoKaydet, gbc_btnDepoKaydet);
		
		btnDepoKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Depo depo = new Depo(textFieldDepoAdi.getText(), textFieldPersonelId.getText(), comboBoxDepoTur.getSelectedIndex() + 1);
				if(Depo.DepoEkle(depo)) {
					JOptionPane.showMessageDialog(null, "Depo basariyla kaydedildi");
					cardLayout.show(panels, DepoYonetimCard);
					connector.FillTable(tableHammaddeDepo, "select depoId, depoAdi, PersonelIsim, depoturAdi from depo as d left join personel as p on p.PersonelId = d.personelId left join depotur as dt on dt.depoturId = d.depoTur where d.depoTur = 1");
					connector.FillTable(tableHammaddeDepo, "select depoId, depoAdi, PersonelIsim, depoturAdi from depo as d left join personel as p on p.PersonelId = d.personelId left join depotur as dt on dt.depoturId = d.depoTur where d.depoTur = 2");
				
				}
				else {
					JOptionPane.showMessageDialog(null, "Depo kaydedilirken bir sorun olustu!");
				}
			}
		});
		panelDepoGuncelle.setBackground(Color.WHITE);
		GridBagLayout gbl_panelDepoGuncelle = new GridBagLayout();
		gbl_panelDepoGuncelle.columnWidths = new int[]{98, 188, 0};
		gbl_panelDepoGuncelle.rowHeights = new int[]{15, 20, 20, 22, 34, 41, 0};
		gbl_panelDepoGuncelle.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelDepoGuncelle.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelDepoGuncelle.setLayout(gbl_panelDepoGuncelle);
		
		JLabel labelDepoId = new JLabel("Depo ID:");
		labelDepoId.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		GridBagConstraints gbc_labelDepoId = new GridBagConstraints();
		gbc_labelDepoId.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelDepoId.insets = new Insets(0, 0, 5, 5);
		gbc_labelDepoId.gridx = 0;
		gbc_labelDepoId.gridy = 0;
		panelDepoGuncelle.add(labelDepoId, gbc_labelDepoId);
		
		final JLabel labelDepoID = new JLabel("");
		labelDepoID.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		GridBagConstraints gbc_labelDepoID = new GridBagConstraints();
		gbc_labelDepoID.fill = GridBagConstraints.BOTH;
		gbc_labelDepoID.insets = new Insets(0, 0, 5, 0);
		gbc_labelDepoID.gridx = 1;
		gbc_labelDepoID.gridy = 0;
		panelDepoGuncelle.add(labelDepoID, gbc_labelDepoID);
		
		
		JLabel labelDepoAdiGuncelle = new JLabel("Depo Adi:");
		labelDepoAdiGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		GridBagConstraints gbc_labelDepoAdiGuncelle = new GridBagConstraints();
		gbc_labelDepoAdiGuncelle.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelDepoAdiGuncelle.insets = new Insets(0, 0, 5, 5);
		gbc_labelDepoAdiGuncelle.gridx = 0;
		gbc_labelDepoAdiGuncelle.gridy = 1;
		panelDepoGuncelle.add(labelDepoAdiGuncelle, gbc_labelDepoAdiGuncelle);
		
		textFieldDepoAdiGuncelle = new JTextField();
		textFieldDepoAdiGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		textFieldDepoAdiGuncelle.setColumns(10);
		textFieldDepoAdiGuncelle.setBackground(Color.WHITE);
		GridBagConstraints gbc_textFieldDepoAdiGuncelle = new GridBagConstraints();
		gbc_textFieldDepoAdiGuncelle.anchor = GridBagConstraints.NORTH;
		gbc_textFieldDepoAdiGuncelle.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDepoAdiGuncelle.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDepoAdiGuncelle.gridx = 1;
		gbc_textFieldDepoAdiGuncelle.gridy = 1;
		panelDepoGuncelle.add(textFieldDepoAdiGuncelle, gbc_textFieldDepoAdiGuncelle);
		
		JLabel labelPersonelIdGuncelle = new JLabel("Personel ID:");
		labelPersonelIdGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		GridBagConstraints gbc_labelPersonelIdGuncelle = new GridBagConstraints();
		gbc_labelPersonelIdGuncelle.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelPersonelIdGuncelle.insets = new Insets(0, 0, 5, 5);
		gbc_labelPersonelIdGuncelle.gridx = 0;
		gbc_labelPersonelIdGuncelle.gridy = 2;
		panelDepoGuncelle.add(labelPersonelIdGuncelle, gbc_labelPersonelIdGuncelle);
		
		textFieldPersonelIdGuncelle = new JTextField();
		textFieldPersonelIdGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		textFieldPersonelIdGuncelle.setColumns(10);
		textFieldPersonelIdGuncelle.setBackground(Color.WHITE);
		GridBagConstraints gbc_textFieldPersonelIdGuncelle = new GridBagConstraints();
		gbc_textFieldPersonelIdGuncelle.anchor = GridBagConstraints.NORTH;
		gbc_textFieldPersonelIdGuncelle.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPersonelIdGuncelle.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPersonelIdGuncelle.gridx = 1;
		gbc_textFieldPersonelIdGuncelle.gridy = 2;
		panelDepoGuncelle.add(textFieldPersonelIdGuncelle, gbc_textFieldPersonelIdGuncelle);
		
		JLabel labelDepoTuruGuncelle = new JLabel("Depo Turu:");
		labelDepoTuruGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		GridBagConstraints gbc_labelDepoTuruGuncelle = new GridBagConstraints();
		gbc_labelDepoTuruGuncelle.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelDepoTuruGuncelle.insets = new Insets(0, 0, 5, 5);
		gbc_labelDepoTuruGuncelle.gridx = 0;
		gbc_labelDepoTuruGuncelle.gridy = 3;
		panelDepoGuncelle.add(labelDepoTuruGuncelle, gbc_labelDepoTuruGuncelle);
		
		final JComboBox comboBoxDepoTuruGuncelle = new JComboBox();
		comboBoxDepoTuruGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		comboBoxDepoTuruGuncelle.setBackground(Color.WHITE);
		GridBagConstraints gbc_comboBoxDepoTuruGuncelle = new GridBagConstraints();
		gbc_comboBoxDepoTuruGuncelle.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxDepoTuruGuncelle.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxDepoTuruGuncelle.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxDepoTuruGuncelle.gridx = 1;
		gbc_comboBoxDepoTuruGuncelle.gridy = 3;
		panelDepoGuncelle.add(comboBoxDepoTuruGuncelle, gbc_comboBoxDepoTuruGuncelle);
		
		JButton btnDepoyuGuncelle = new JButton("Depoyu Guncelle");
		
		btnDepoyuGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		btnDepoyuGuncelle.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnDepoyuGuncelle = new GridBagConstraints();
		gbc_btnDepoyuGuncelle.fill = GridBagConstraints.BOTH;
		gbc_btnDepoyuGuncelle.gridx = 1;
		gbc_btnDepoyuGuncelle.gridy = 5;
		panelDepoGuncelle.add(btnDepoyuGuncelle, gbc_btnDepoyuGuncelle);
		
		btnDepoyuGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Depo depo = new Depo(textFieldDepoAdiGuncelle.getText(), textFieldPersonelIdGuncelle.getText(), comboBoxDepoTuruGuncelle.getSelectedIndex() + 1);
				Depo.DepoGuncelle(depo);
				cardLayout.show(panels, DepoYonetimCard);
				connector.FillTable(tableUrunDepo, "select depoId, depoAdi, PersonelIsim, depoturAdi from depo as d left join personel as p on p.PersonelId = d.personelId left join depotur as dt on dt.depoturId = d.depoTur where d.depoTur = 1");
				connector.FillTable(tableHammaddeDepo, "select depoId, depoAdi, PersonelIsim, depoturAdi from depo as d left join personel as p on p.PersonelId = d.personelId left join depotur as dt on dt.depoturId = d.depoTur where d.depoTur = 2");
				
			}
		});
		
		
		panelDepo.setBackground(Color.WHITE);
		
		panelDepo.setLayout(null);
		
		JButton btnDepoIcerik = new JButton("Depo Icerigi Goruntule");
		
		btnDepoIcerik.setBackground(Color.WHITE);
		btnDepoIcerik.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		btnDepoIcerik.setBounds(0, 0, 740, 36);
		panelDepo.add(btnDepoIcerik);
		
		tableUrunDepolar = new JTable();
		tableUrunDepolar.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Depo ID", "Depo Adi", "Personel", "Depo Turu"
			}
		));
		tableUrunDepolar.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		tableUrunDepolar.setBounds(0, 72, 359, 338);
		panelDepo.add(tableUrunDepolar);
		
		tableHammaddeDepolar = new JTable();
		tableHammaddeDepolar.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Depo ID", "Depo Adi", "Personel", "Depo Turu"
			}
		));
		tableHammaddeDepolar.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		tableHammaddeDepolar.setBounds(369, 72, 371, 338);
		panelDepo.add(tableHammaddeDepolar);
		
		JLabel labelUrunDepolar = new JLabel("Urun Depolari");
		labelUrunDepolar.setHorizontalAlignment(SwingConstants.CENTER);
		labelUrunDepolar.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		labelUrunDepolar.setBounds(0, 47, 359, 14);
		panelDepo.add(labelUrunDepolar);
		
		JLabel labelHammaddeDepolari = new JLabel("Hammadde Depolari");
		labelHammaddeDepolari.setHorizontalAlignment(SwingConstants.CENTER);
		labelHammaddeDepolari.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		labelHammaddeDepolari.setBounds(359, 47, 381, 14);
		panelDepo.add(labelHammaddeDepolari);
		
		
		panelDepoIcerik.setLayout(null);
		panelDepoIcerik.setBackground(Color.WHITE);
		
		
		JButton btnDepoyaEkle = new JButton("Depoya Ekle");
		
		btnDepoyaEkle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		btnDepoyaEkle.setBackground(Color.WHITE);
		btnDepoyaEkle.setBounds(0, 0, 359, 36);
		panelDepoIcerik.add(btnDepoyaEkle);
		
		tableDepoIcerik = new JTable();
		tableDepoIcerik.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Icerik ID", "Icerik Adi", "Adet"
			}
		));
		tableDepoIcerik.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		tableDepoIcerik.setBounds(0, 72, 740, 338);
		panelDepoIcerik.add(tableDepoIcerik);
		
		JButton btnDepotanSil = new JButton("Depodan Sil");
		
		btnDepotanSil.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		btnDepotanSil.setBackground(Color.WHITE);
		btnDepotanSil.setBounds(369, 0, 371, 36);
		panelDepoIcerik.add(btnDepotanSil);
		
		JLabel labelDepoIcerikId = new JLabel("Depo ID:");
		labelDepoIcerikId.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		labelDepoIcerikId.setBounds(0, 47, 89, 14);
		panelDepoIcerik.add(labelDepoIcerikId);
		
		final JLabel labelDepoIcerikID = new JLabel("");
		labelDepoIcerikID.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		labelDepoIcerikID.setBounds(99, 47, 89, 14);
		panelDepoIcerik.add(labelDepoIcerikID);
		
		
		panelTedarikciFirma.setBackground(Color.WHITE);
		
		panelTedarikciFirma.setLayout(null);
		
		JButton btnFirmaEkle = new JButton("Firma Ekle");
		
		btnFirmaEkle.setBackground(Color.WHITE);
		btnFirmaEkle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		btnFirmaEkle.setBounds(0, 0, 229, 35);
		panelTedarikciFirma.add(btnFirmaEkle);
		
		JButton btnFirmaSil = new JButton("Firma Sil");
		
		btnFirmaSil.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		btnFirmaSil.setBackground(Color.WHITE);
		btnFirmaSil.setBounds(239, 0, 244, 35);
		panelTedarikciFirma.add(btnFirmaSil);
		
		JButton btnFirmaGuncelle = new JButton("Firma Guncelle");
		
		btnFirmaGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		btnFirmaGuncelle.setBackground(Color.WHITE);
		btnFirmaGuncelle.setBounds(493, 0, 247, 35);
		panelTedarikciFirma.add(btnFirmaGuncelle);
		
		tableFirmalar = new JTable();
		tableFirmalar.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Firma ID", "Firma Adi", "Firma Tel", "Firma Adres"
			}
		));
		tableFirmalar.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		tableFirmalar.setBounds(0, 46, 740, 364);
		panelTedarikciFirma.add(tableFirmalar);
		
		
		panelFirmaEkle.setBackground(Color.WHITE);
		
		panelFirmaEkle.setLayout(null);
		
		JLabel labelFirmaAdi = new JLabel("Firma Adi:");
		labelFirmaAdi.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		labelFirmaAdi.setBounds(10, 43, 126, 14);
		panelFirmaEkle.add(labelFirmaAdi);
		
		JLabel labelFirmaTel = new JLabel("Firma Tel:");
		labelFirmaTel.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		labelFirmaTel.setBounds(10, 68, 126, 14);
		panelFirmaEkle.add(labelFirmaTel);
		
		JLabel labelFirmaAdres = new JLabel("Firma Adres:");
		labelFirmaAdres.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		labelFirmaAdres.setBounds(10, 93, 126, 14);
		panelFirmaEkle.add(labelFirmaAdres);
		
		textFieldFirmaAdi = new JTextField();
		textFieldFirmaAdi.setBounds(159, 40, 170, 20);
		panelFirmaEkle.add(textFieldFirmaAdi);
		textFieldFirmaAdi.setColumns(10);
		
		textFieldFirmaTel = new JTextField();
		textFieldFirmaTel.setColumns(10);
		textFieldFirmaTel.setBounds(159, 65, 170, 20);
		panelFirmaEkle.add(textFieldFirmaTel);
		
		final JTextArea textAreaFirmaAdres = new JTextArea();
		textAreaFirmaAdres.setBounds(159, 106, 170, 126);
		panelFirmaEkle.add(textAreaFirmaAdres);
		
		JButton btnFirmaKaydet = new JButton("Firma Kaydet");
		
		btnFirmaKaydet.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		btnFirmaKaydet.setBackground(Color.WHITE);
		btnFirmaKaydet.setBounds(159, 268, 170, 61);
		panelFirmaEkle.add(btnFirmaKaydet);
		
		
		panelFirmaGuncelle.setLayout(null);
		panelFirmaGuncelle.setBackground(Color.WHITE);
		
		
		JLabel labelFirmaAdiGuncelle = new JLabel("Firma Adi:");
		labelFirmaAdiGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		labelFirmaAdiGuncelle.setBounds(10, 43, 126, 14);
		panelFirmaGuncelle.add(labelFirmaAdiGuncelle);
		
		JLabel labelFirmaTelGuncelle = new JLabel("Firma Tel:");
		labelFirmaTelGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		labelFirmaTelGuncelle.setBounds(10, 68, 126, 14);
		panelFirmaGuncelle.add(labelFirmaTelGuncelle);
		
		JLabel labelFirmaAdresGuncelle = new JLabel("Firma Adres:");
		labelFirmaAdresGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		labelFirmaAdresGuncelle.setBounds(10, 93, 126, 14);
		panelFirmaGuncelle.add(labelFirmaAdresGuncelle);
		
		textFieldFirmaAdiGuncelle = new JTextField();
		textFieldFirmaAdiGuncelle.setColumns(10);
		textFieldFirmaAdiGuncelle.setBounds(159, 40, 170, 20);
		panelFirmaGuncelle.add(textFieldFirmaAdiGuncelle);
		
		textFieldFirmaTelGuncelle = new JTextField();
		textFieldFirmaTelGuncelle.setColumns(10);
		textFieldFirmaTelGuncelle.setBounds(159, 65, 170, 20);
		panelFirmaGuncelle.add(textFieldFirmaTelGuncelle);
		
		final JTextArea textAreaFirmaAdresGuncelle = new JTextArea();
		textAreaFirmaAdresGuncelle.setBounds(159, 106, 170, 126);
		panelFirmaGuncelle.add(textAreaFirmaAdresGuncelle);
		
		JButton btnFirmaKaydetGuncelle = new JButton("Firma Kaydet");
		
		btnFirmaKaydetGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		btnFirmaKaydetGuncelle.setBackground(Color.WHITE);
		btnFirmaKaydetGuncelle.setBounds(159, 268, 170, 61);
		panelFirmaGuncelle.add(btnFirmaKaydetGuncelle);
		
		JLabel labelFirmaGuncelleId = new JLabel("Firma ID:");
		labelFirmaGuncelleId.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		labelFirmaGuncelleId.setBounds(10, 11, 126, 14);
		panelFirmaGuncelle.add(labelFirmaGuncelleId);
		
		final JLabel labelFirmaGuncelleID = new JLabel("");
		labelFirmaGuncelleID.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		labelFirmaGuncelleID.setBounds(159, 11, 170, 14);
		panelFirmaGuncelle.add(labelFirmaGuncelleID);
		
		
		panelFirmaSatis.setLayout(null);
		panelFirmaSatis.setBackground(Color.WHITE);
		
		
		JButton btnFirmaSatisEkle = new JButton("Satis Ekle");
		
		btnFirmaSatisEkle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		btnFirmaSatisEkle.setBackground(Color.WHITE);
		btnFirmaSatisEkle.setBounds(0, 0, 229, 35);
		panelFirmaSatis.add(btnFirmaSatisEkle);
		
		JButton btnSatisSil = new JButton("Satis Sil");
		
		btnSatisSil.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		btnSatisSil.setBackground(Color.WHITE);
		btnSatisSil.setBounds(239, 0, 244, 35);
		panelFirmaSatis.add(btnSatisSil);
		
		JButton btnSatisGuncelle = new JButton("Satis Guncelle");
		
		btnSatisGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		btnSatisGuncelle.setBackground(Color.WHITE);
		btnSatisGuncelle.setBounds(493, 0, 247, 35);
		panelFirmaSatis.add(btnSatisGuncelle);
		
		tableSatislar = new JTable();
		tableSatislar.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Satis ID", "Firma", "Hammadde", "Birim Fiyat"
			}
		));
		tableSatislar.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		tableSatislar.setBounds(0, 46, 740, 364);
		panelFirmaSatis.add(tableSatislar);
		
		
		panelSatisEkle.setBackground(Color.WHITE);
		
		panelSatisEkle.setLayout(null);
		
		JLabel labelFirmaId = new JLabel("Firma ID:");
		labelFirmaId.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		labelFirmaId.setBounds(10, 54, 110, 14);
		panelSatisEkle.add(labelFirmaId);
		
		JLabel labelHammaddeId = new JLabel("Hammadde ID:");
		labelHammaddeId.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		labelHammaddeId.setBounds(10, 79, 110, 14);
		panelSatisEkle.add(labelHammaddeId);
		
		JLabel labelBirimFiyat = new JLabel("Birim Fiyat:");
		labelBirimFiyat.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		labelBirimFiyat.setBounds(10, 104, 110, 14);
		panelSatisEkle.add(labelBirimFiyat);
		
		textFieldFirmaID = new JTextField();
		textFieldFirmaID.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		textFieldFirmaID.setBounds(144, 51, 187, 20);
		panelSatisEkle.add(textFieldFirmaID);
		textFieldFirmaID.setColumns(10);
		
		textFieldHammaddeID = new JTextField();
		textFieldHammaddeID.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		textFieldHammaddeID.setColumns(10);
		textFieldHammaddeID.setBounds(144, 76, 187, 20);
		panelSatisEkle.add(textFieldHammaddeID);
		
		textFieldBirimFiyat = new JTextField();
		textFieldBirimFiyat.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		textFieldBirimFiyat.setColumns(10);
		textFieldBirimFiyat.setBounds(144, 101, 187, 20);
		panelSatisEkle.add(textFieldBirimFiyat);
		
		JButton btnSatisKaydet = new JButton("Satis Kaydet");
		
		btnSatisKaydet.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		btnSatisKaydet.setBackground(Color.WHITE);
		btnSatisKaydet.setBounds(144, 132, 187, 55);
		panelSatisEkle.add(btnSatisKaydet);
		
		
		panelSatisGuncelle.setLayout(null);
		panelSatisGuncelle.setBackground(Color.WHITE);
		
		
		JLabel label = new JLabel("Firma ID:");
		label.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		label.setBounds(10, 54, 110, 14);
		panelSatisGuncelle.add(label);
		
		JLabel label_1 = new JLabel("Hammadde ID:");
		label_1.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		label_1.setBounds(10, 79, 110, 14);
		panelSatisGuncelle.add(label_1);
		
		JLabel label_2 = new JLabel("Birim Fiyat:");
		label_2.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		label_2.setBounds(10, 104, 110, 14);
		panelSatisGuncelle.add(label_2);
		
		textField = new JTextField();
		textField.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		textField.setColumns(10);
		textField.setBounds(144, 51, 187, 20);
		panelSatisGuncelle.add(textField);
		
		textFieldHammaddeIdGuncelle = new JTextField();
		textFieldHammaddeIdGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		textFieldHammaddeIdGuncelle.setColumns(10);
		textFieldHammaddeIdGuncelle.setBounds(144, 76, 187, 20);
		panelSatisGuncelle.add(textFieldHammaddeIdGuncelle);
		
		textFieldBirimFiyatGuncelle = new JTextField();
		textFieldBirimFiyatGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		textFieldBirimFiyatGuncelle.setColumns(10);
		textFieldBirimFiyatGuncelle.setBounds(144, 101, 187, 20);
		panelSatisGuncelle.add(textFieldBirimFiyatGuncelle);
		
		JButton btnSayisGuncelleKaydet = new JButton("Satis Kaydet");
		
		btnSayisGuncelleKaydet.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		btnSayisGuncelleKaydet.setBackground(Color.WHITE);
		btnSayisGuncelleKaydet.setBounds(144, 132, 187, 55);
		panelSatisGuncelle.add(btnSayisGuncelleKaydet);
		
		JLabel labelFirmaSatisIdGuncelle = new JLabel("Satis ID:");
		labelFirmaSatisIdGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		labelFirmaSatisIdGuncelle.setBounds(10, 11, 110, 14);
		panelSatisGuncelle.add(labelFirmaSatisIdGuncelle);
		
		final JLabel labelSatisIDGuncelle = new JLabel("");
		labelSatisIDGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		labelSatisIDGuncelle.setBounds(144, 11, 187, 14);
		panelSatisGuncelle.add(labelSatisIDGuncelle);
		
		
		panelMatbaaSiparis.setBackground(Color.WHITE);
		
		panelMatbaaSiparis.setLayout(null);
		
		JButton btnSiparisEkle = new JButton("Siparis Ekle");
		
		btnSiparisEkle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		btnSiparisEkle.setBackground(Color.WHITE);
		btnSiparisEkle.setBounds(0, 0, 229, 23);
		panelMatbaaSiparis.add(btnSiparisEkle);
		
		JButton btnSiparisSil = new JButton("Siparis Sil");
		
		btnSiparisSil.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		btnSiparisSil.setBackground(Color.WHITE);
		btnSiparisSil.setBounds(251, 0, 238, 23);
		panelMatbaaSiparis.add(btnSiparisSil);
		
		JButton btnSiparisGuncelle = new JButton("Siparis Guncelle");
		
		btnSiparisGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		btnSiparisGuncelle.setBackground(Color.WHITE);
		btnSiparisGuncelle.setBounds(511, 0, 179, 23);
		panelMatbaaSiparis.add(btnSiparisGuncelle);
		
		tableMatbaaSiparisler = new JTable();
		tableMatbaaSiparisler.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Adi", "Aciklama", "Adet", "Hammadde", "Personel ID", "Personel Adi"
			}
		));
		tableMatbaaSiparisler.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		tableMatbaaSiparisler.setBounds(0, 34, 690, 376);
		panelMatbaaSiparis.add(tableMatbaaSiparisler);
		
		
		panelDepoSiparisEkle.setBackground(Color.WHITE);
		
		panelDepoSiparisEkle.setLayout(null);
		
		JLabel labelSiparisAdi = new JLabel("Siparis Adi:");
		labelSiparisAdi.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		labelSiparisAdi.setBounds(10, 48, 133, 14);
		panelDepoSiparisEkle.add(labelSiparisAdi);
		
		JLabel labelSiparisAciklama = new JLabel("Siparis Aciklamasi:");
		labelSiparisAciklama.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		labelSiparisAciklama.setBounds(10, 73, 133, 14);
		panelDepoSiparisEkle.add(labelSiparisAciklama);
		
		textFieldSiparisAdi = new JTextField();
		textFieldSiparisAdi.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		textFieldSiparisAdi.setBounds(169, 46, 148, 20);
		panelDepoSiparisEkle.add(textFieldSiparisAdi);
		textFieldSiparisAdi.setColumns(10);
		
		final JTextArea textAreaSiparisAciklama = new JTextArea();
		textAreaSiparisAciklama.setBounds(169, 77, 148, 110);
		panelDepoSiparisEkle.add(textAreaSiparisAciklama);
		
		JLabel labelSiparisAdet = new JLabel("Siparis Adet:");
		labelSiparisAdet.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		labelSiparisAdet.setBounds(10, 193, 133, 14);
		panelDepoSiparisEkle.add(labelSiparisAdet);
		
		textFieldSiparisAdet = new JTextField();
		textFieldSiparisAdet.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		textFieldSiparisAdet.setColumns(10);
		textFieldSiparisAdet.setBounds(169, 191, 148, 20);
		panelDepoSiparisEkle.add(textFieldSiparisAdet);
		
		JLabel labelFirmaSatisId = new JLabel("Firma Satis ID:");
		labelFirmaSatisId.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		labelFirmaSatisId.setBounds(10, 233, 133, 14);
		panelDepoSiparisEkle.add(labelFirmaSatisId);
		
		textFieldFirmaSatisID = new JTextField();
		textFieldFirmaSatisID.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		textFieldFirmaSatisID.setColumns(10);
		textFieldFirmaSatisID.setBounds(169, 233, 148, 20);
		panelDepoSiparisEkle.add(textFieldFirmaSatisID);
		
		JButton btnDepoSiparisKaydet = new JButton("Siparis Kaydet");
		
		btnDepoSiparisKaydet.setBackground(Color.WHITE);
		btnDepoSiparisKaydet.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		btnDepoSiparisKaydet.setBounds(169, 275, 148, 57);
		panelDepoSiparisEkle.add(btnDepoSiparisKaydet);
		
		tableFirmaSatislar = new JTable();
		tableFirmaSatislar.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Satis ID", "Firma Adi", "Hammadde Adi", "Birim Fiyat"
			}
		));
		tableFirmaSatislar.getColumnModel().getColumn(2).setPreferredWidth(91);
		tableFirmaSatislar.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		tableFirmaSatislar.setBounds(347, 11, 343, 395);
		panelDepoSiparisEkle.add(tableFirmaSatislar);
		
		
		panelMatbaaSiparisEkle.setLayout(null);
		panelMatbaaSiparisEkle.setBackground(Color.WHITE);
		
		
		JLabel labelMatbaaSiparisAdi = new JLabel("Siparis Adi:");
		labelMatbaaSiparisAdi.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		labelMatbaaSiparisAdi.setBounds(10, 48, 149, 14);
		panelMatbaaSiparisEkle.add(labelMatbaaSiparisAdi);
		
		JLabel labelMatbaaSiparisAciklama = new JLabel("Siparis Aciklamasi:");
		labelMatbaaSiparisAciklama.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		labelMatbaaSiparisAciklama.setBounds(10, 73, 149, 14);
		panelMatbaaSiparisEkle.add(labelMatbaaSiparisAciklama);
		
		textFieldMatbaaSiparisAdi = new JTextField();
		textFieldMatbaaSiparisAdi.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		textFieldMatbaaSiparisAdi.setColumns(10);
		textFieldMatbaaSiparisAdi.setBounds(169, 46, 148, 20);
		panelMatbaaSiparisEkle.add(textFieldMatbaaSiparisAdi);
		
		final JTextArea textAreaMatbaaSiparisAciklama = new JTextArea();
		textAreaMatbaaSiparisAciklama.setBounds(169, 77, 148, 110);
		panelMatbaaSiparisEkle.add(textAreaMatbaaSiparisAciklama);
		
		JLabel labelMatbaaSiparisAdet = new JLabel("Siparis Adet:");
		labelMatbaaSiparisAdet.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		labelMatbaaSiparisAdet.setBounds(10, 193, 149, 14);
		panelMatbaaSiparisEkle.add(labelMatbaaSiparisAdet);
		
		textFieldMatbaaSiparisAdet = new JTextField();
		textFieldMatbaaSiparisAdet.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		textFieldMatbaaSiparisAdet.setColumns(10);
		textFieldMatbaaSiparisAdet.setBounds(169, 191, 148, 20);
		panelMatbaaSiparisEkle.add(textFieldMatbaaSiparisAdet);
		
		JLabel labelHammaddeID = new JLabel("Siparis Hammadde ID:");
		labelHammaddeID.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		labelHammaddeID.setBounds(10, 233, 149, 14);
		panelMatbaaSiparisEkle.add(labelHammaddeID);
		
		textFieldMatbaaSiparisHammaddeID = new JTextField();
		textFieldMatbaaSiparisHammaddeID.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		textFieldMatbaaSiparisHammaddeID.setColumns(10);
		textFieldMatbaaSiparisHammaddeID.setBounds(169, 233, 148, 20);
		panelMatbaaSiparisEkle.add(textFieldMatbaaSiparisHammaddeID);
		
		JButton btnMatbaaSiparisKaydet = new JButton("Siparis Kaydet");
		
		btnMatbaaSiparisKaydet.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		btnMatbaaSiparisKaydet.setBackground(Color.WHITE);
		btnMatbaaSiparisKaydet.setBounds(169, 275, 148, 57);
		panelMatbaaSiparisEkle.add(btnMatbaaSiparisKaydet);
		
		tableSiparisHammaddeler = new JTable();
		tableSiparisHammaddeler.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Hammadde ID", "Hammadde Adi", "Hammadde Turu"
			}
		));
		tableSiparisHammaddeler.getColumnModel().getColumn(0).setPreferredWidth(80);
		tableSiparisHammaddeler.getColumnModel().getColumn(1).setPreferredWidth(92);
		tableSiparisHammaddeler.getColumnModel().getColumn(2).setPreferredWidth(92);
		tableSiparisHammaddeler.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		tableSiparisHammaddeler.setBounds(347, 11, 343, 395);
		panelMatbaaSiparisEkle.add(tableSiparisHammaddeler);
		
		
		panelMatbaaSiparisGuncelle.setLayout(null);
		panelMatbaaSiparisGuncelle.setBackground(Color.WHITE);
		
		
		JLabel labelMatbaaSiparisGuncelleAdi = new JLabel("Siparis Adi:");
		labelMatbaaSiparisGuncelleAdi.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		labelMatbaaSiparisGuncelleAdi.setBounds(10, 48, 149, 14);
		panelMatbaaSiparisGuncelle.add(labelMatbaaSiparisGuncelleAdi);
		
		JLabel labelMatbaaSiparisGuncelleAciklama = new JLabel("Siparis Aciklamasi:");
		labelMatbaaSiparisGuncelleAciklama.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		labelMatbaaSiparisGuncelleAciklama.setBounds(10, 73, 149, 14);
		panelMatbaaSiparisGuncelle.add(labelMatbaaSiparisGuncelleAciklama);
		
		textFieldMatbaaSiparisGuncelleAdi = new JTextField();
		textFieldMatbaaSiparisGuncelleAdi.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		textFieldMatbaaSiparisGuncelleAdi.setColumns(10);
		textFieldMatbaaSiparisGuncelleAdi.setBounds(169, 46, 148, 20);
		panelMatbaaSiparisGuncelle.add(textFieldMatbaaSiparisGuncelleAdi);
		
		final JTextArea textAreaMatbaaSiparisGuncelleAciklama = new JTextArea();
		textAreaMatbaaSiparisGuncelleAciklama.setBounds(169, 77, 148, 110);
		panelMatbaaSiparisGuncelle.add(textAreaMatbaaSiparisGuncelleAciklama);
		
		JLabel labelMatbaaSiparisGuncelleAdet = new JLabel("Siparis Adet:");
		labelMatbaaSiparisGuncelleAdet.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		labelMatbaaSiparisGuncelleAdet.setBounds(10, 193, 149, 14);
		panelMatbaaSiparisGuncelle.add(labelMatbaaSiparisGuncelleAdet);
		
		textFieldMatbaaSiparisGuncelleAdet = new JTextField();
		textFieldMatbaaSiparisGuncelleAdet.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		textFieldMatbaaSiparisGuncelleAdet.setColumns(10);
		textFieldMatbaaSiparisGuncelleAdet.setBounds(169, 191, 148, 20);
		panelMatbaaSiparisGuncelle.add(textFieldMatbaaSiparisGuncelleAdet);
		
		JLabel labelMatbaaSiparisGuncelleHammaddeId = new JLabel("Siparis Hammadde ID:");
		labelMatbaaSiparisGuncelleHammaddeId.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		labelMatbaaSiparisGuncelleHammaddeId.setBounds(10, 233, 149, 14);
		panelMatbaaSiparisGuncelle.add(labelMatbaaSiparisGuncelleHammaddeId);
		
		textFieldMatbaaSiparisGuncelleHammaddeID = new JTextField();
		textFieldMatbaaSiparisGuncelleHammaddeID.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		textFieldMatbaaSiparisGuncelleHammaddeID.setColumns(10);
		textFieldMatbaaSiparisGuncelleHammaddeID.setBounds(169, 233, 148, 20);
		panelMatbaaSiparisGuncelle.add(textFieldMatbaaSiparisGuncelleHammaddeID);
		
		JButton btnMatbaaSiparisGuncelle = new JButton("Siparis Guncelle");
		
		btnMatbaaSiparisGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		btnMatbaaSiparisGuncelle.setBackground(Color.WHITE);
		btnMatbaaSiparisGuncelle.setBounds(169, 275, 148, 57);
		panelMatbaaSiparisGuncelle.add(btnMatbaaSiparisGuncelle);
		
		tableHammaddelerGuncelle = new JTable();
		tableHammaddelerGuncelle.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Hammadde ID", "Hammadde Adi", "Hammadde Tur"
			}
		));
		tableHammaddelerGuncelle.getColumnModel().getColumn(0).setPreferredWidth(96);
		tableHammaddelerGuncelle.getColumnModel().getColumn(1).setPreferredWidth(86);
		tableHammaddelerGuncelle.getColumnModel().getColumn(2).setPreferredWidth(102);
		tableHammaddelerGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		tableHammaddelerGuncelle.setBounds(347, 11, 343, 395);
		panelMatbaaSiparisGuncelle.add(tableHammaddelerGuncelle);
		
		JLabel labelMatbaaSiparidGuncelleId = new JLabel("Siparis ID:");
		labelMatbaaSiparidGuncelleId.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		labelMatbaaSiparidGuncelleId.setBounds(10, 11, 149, 14);
		panelMatbaaSiparisGuncelle.add(labelMatbaaSiparidGuncelleId);
		
		final JLabel labelMatbaaSiparisGuncelleID = new JLabel("");
		labelMatbaaSiparisGuncelleID.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		labelMatbaaSiparisGuncelleID.setBounds(168, 11, 149, 14);
		panelMatbaaSiparisGuncelle.add(labelMatbaaSiparisGuncelleID);
		
		
		panelDepoSiparis.setLayout(null);
		panelDepoSiparis.setBackground(Color.WHITE);
		
		
		JButton btnHammaddeSiparisEkle = new JButton("Hammadde Siparisi Ekle");
		
		btnHammaddeSiparisEkle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		btnHammaddeSiparisEkle.setBackground(Color.WHITE);
		btnHammaddeSiparisEkle.setBounds(0, 0, 229, 23);
		panelDepoSiparis.add(btnHammaddeSiparisEkle);
		
		JButton btnHammaddeSiparisSil = new JButton("Hammadde Siparisi Sil");
		
		btnHammaddeSiparisSil.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		btnHammaddeSiparisSil.setBackground(Color.WHITE);
		btnHammaddeSiparisSil.setBounds(251, 0, 238, 23);
		panelDepoSiparis.add(btnHammaddeSiparisSil);
		
		JButton btnHammaddeSiparisGuncelle = new JButton("Hammadde Siparisi Guncelle");
		
		btnHammaddeSiparisGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		btnHammaddeSiparisGuncelle.setBackground(Color.WHITE);
		btnHammaddeSiparisGuncelle.setBounds(511, 0, 179, 23);
		panelDepoSiparis.add(btnHammaddeSiparisGuncelle);
		
		tableHammaddeSiparisleri = new JTable();
		tableHammaddeSiparisleri.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"SIparis ID", "Adi", "Aciklama", "Satis ID", "Adet", "Siparis Durum", "Hammadde Adi", "Personel ID", "Personel Adi"
			}
		));
		tableHammaddeSiparisleri.getColumnModel().getColumn(5).setPreferredWidth(82);
		tableHammaddeSiparisleri.getColumnModel().getColumn(6).setPreferredWidth(94);
		tableHammaddeSiparisleri.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		tableHammaddeSiparisleri.setBounds(0, 98, 347, 312);
		panelDepoSiparis.add(tableHammaddeSiparisleri);
		
		JButton btnDepodanSiparisOnay = new JButton("Beklenen Siparisi Onayla");
		
		btnDepodanSiparisOnay.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		btnDepodanSiparisOnay.setBackground(Color.WHITE);
		btnDepodanSiparisOnay.setBounds(0, 34, 690, 23);
		panelDepoSiparis.add(btnDepodanSiparisOnay);
		
		tableDepodanBeklenenSiparisler = new JTable();
		tableDepodanBeklenenSiparisler.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Adi", "Aciklama", "Adet", "Hammadde Adi", "Personel Adi"
			}
		));
		tableDepodanBeklenenSiparisler.getColumnModel().getColumn(4).setPreferredWidth(99);
		tableDepodanBeklenenSiparisler.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		tableDepodanBeklenenSiparisler.setBounds(353, 98, 347, 312);
		panelDepoSiparis.add(tableDepodanBeklenenSiparisler);
		
		JLabel labelFirmadanSiparisler = new JLabel("Firmadan Siparisler");
		labelFirmadanSiparisler.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		labelFirmadanSiparisler.setHorizontalAlignment(SwingConstants.CENTER);
		labelFirmadanSiparisler.setBounds(0, 73, 347, 14);
		panelDepoSiparis.add(labelFirmadanSiparisler);
		
		JLabel labelBekleyenSiparisler = new JLabel("Depodan Beklenen Siparisler");
		labelBekleyenSiparisler.setHorizontalAlignment(SwingConstants.CENTER);
		labelBekleyenSiparisler.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		labelBekleyenSiparisler.setBounds(343, 73, 347, 14);
		panelDepoSiparis.add(labelBekleyenSiparisler);
		
		
		panelDepoSiparisGuncelle.setLayout(null);
		panelDepoSiparisGuncelle.setBackground(Color.WHITE);
		
		
		JLabel labelSiparisAdiGuncelle = new JLabel("Siparis Adi:");
		labelSiparisAdiGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		labelSiparisAdiGuncelle.setBounds(10, 48, 133, 14);
		panelDepoSiparisGuncelle.add(labelSiparisAdiGuncelle);
		
		JLabel labelSiparisAciklamasiGuncelle = new JLabel("Siparis Aciklamasi:");
		labelSiparisAciklamasiGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		labelSiparisAciklamasiGuncelle.setBounds(10, 73, 133, 14);
		panelDepoSiparisGuncelle.add(labelSiparisAciklamasiGuncelle);
		
		textFieldSiparisAdiGuncelle = new JTextField();
		textFieldSiparisAdiGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		textFieldSiparisAdiGuncelle.setColumns(10);
		textFieldSiparisAdiGuncelle.setBounds(169, 46, 148, 20);
		panelDepoSiparisGuncelle.add(textFieldSiparisAdiGuncelle);
		
		final JTextArea textAreaSiparisAciklamasiGuncelle = new JTextArea();
		textAreaSiparisAciklamasiGuncelle.setBounds(169, 77, 148, 110);
		panelDepoSiparisGuncelle.add(textAreaSiparisAciklamasiGuncelle);
		
		JLabel labelSiparisAdetGuncelle = new JLabel("Siparis Adet:");
		labelSiparisAdetGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		labelSiparisAdetGuncelle.setBounds(10, 193, 133, 14);
		panelDepoSiparisGuncelle.add(labelSiparisAdetGuncelle);
		
		textFieldSiparisAdetGuncelle = new JTextField();
		textFieldSiparisAdetGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		textFieldSiparisAdetGuncelle.setColumns(10);
		textFieldSiparisAdetGuncelle.setBounds(169, 191, 148, 20);
		panelDepoSiparisGuncelle.add(textFieldSiparisAdetGuncelle);
		
		JLabel labelFirmaSatisIDGuncelle = new JLabel("Firma Satis ID:");
		labelFirmaSatisIDGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		labelFirmaSatisIDGuncelle.setBounds(10, 233, 133, 14);
		panelDepoSiparisGuncelle.add(labelFirmaSatisIDGuncelle);
		
		textFieldFirmaSatisIDGuncelle = new JTextField();
		textFieldFirmaSatisIDGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		textFieldFirmaSatisIDGuncelle.setColumns(10);
		textFieldFirmaSatisIDGuncelle.setBounds(169, 233, 148, 20);
		panelDepoSiparisGuncelle.add(textFieldFirmaSatisIDGuncelle);
		
		JButton btnSiparisGuncelleKaydet = new JButton("Siparis Guncelle");
		
		btnSiparisGuncelleKaydet.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		btnSiparisGuncelleKaydet.setBackground(Color.WHITE);
		btnSiparisGuncelleKaydet.setBounds(169, 275, 148, 57);
		panelDepoSiparisGuncelle.add(btnSiparisGuncelleKaydet);
		
		tableSiparisGuncelleFirmaSatis = new JTable();
		tableSiparisGuncelleFirmaSatis.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Satis ID", "Firma Adi", "Hammadde Adi", "Birim Fiyat"
			}
		));
		tableSiparisGuncelleFirmaSatis.getColumnModel().getColumn(2).setPreferredWidth(119);
		tableSiparisGuncelleFirmaSatis.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		tableSiparisGuncelleFirmaSatis.setBounds(347, 11, 343, 395);
		panelDepoSiparisGuncelle.add(tableSiparisGuncelleFirmaSatis);
		
		JLabel lblSiparisId = new JLabel("Siparis ID:");
		lblSiparisId.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		lblSiparisId.setBounds(10, 11, 133, 14);
		panelDepoSiparisGuncelle.add(lblSiparisId);
		
		final JLabel labelSiparisID = new JLabel("");
		labelSiparisID.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		labelSiparisID.setBounds(169, 11, 148, 14);
		panelDepoSiparisGuncelle.add(labelSiparisID);
		
		
		panelYoneticiSiparis.setBackground(Color.WHITE);
		
		panelYoneticiSiparis.setLayout(null);
		
		JButton btnYoneticiSiparisOnayla = new JButton("Siparis Onayla");
		
		btnYoneticiSiparisOnayla.setBackground(Color.WHITE);
		btnYoneticiSiparisOnayla.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		btnYoneticiSiparisOnayla.setBounds(0, 0, 740, 23);
		panelYoneticiSiparis.add(btnYoneticiSiparisOnayla);
		
		tableSiparisler = new JTable();
		tableSiparisler.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Adi", "Aciklama", "Satis ID", "Adet", "Siparis Durum", "Personel Adi", "Personel ID"
			}
		));
		tableSiparisler.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		tableSiparisler.setBounds(10, 34, 730, 372);
		panelYoneticiSiparis.add(tableSiparisler);
		
		
		panelRapor.setBackground(Color.WHITE);
		
		panelRapor.setLayout(null);
		
		JButton btnRaporOlustur = new JButton("Rapor Olustur");
		btnRaporOlustur.setBackground(Color.WHITE);
		
		btnRaporOlustur.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		btnRaporOlustur.setBounds(0, 0, 216, 23);
		panelRapor.add(btnRaporOlustur);
		
		JButton btnRaporSil = new JButton("Rapor Sil");
		
		btnRaporSil.setBackground(Color.WHITE);
		btnRaporSil.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		btnRaporSil.setBounds(226, 1, 216, 23);
		panelRapor.add(btnRaporSil);
		
		JButton btnRaporGuncelle = new JButton("Rapor Guncelle");
		
		btnRaporGuncelle.setBackground(Color.WHITE);
		btnRaporGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		btnRaporGuncelle.setBounds(452, 1, 216, 23);
		panelRapor.add(btnRaporGuncelle);
		
		tableRaporlar = new JTable();
		tableRaporlar.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Rapor ID", "Rapor Baslik", "Rapor Aciklama", "Personel ID", "Personel Adi"
			}
		));
		tableRaporlar.getColumnModel().getColumn(2).setPreferredWidth(95);
		tableRaporlar.setBounds(0, 34, 740, 372);
		panelRapor.add(tableRaporlar);
		
		
		panelRaporEkle.setBackground(Color.WHITE);
		GridBagLayout gbl_panelRaporEkle = new GridBagLayout();
		gbl_panelRaporEkle.columnWidths = new int[]{105, 180, 0};
		gbl_panelRaporEkle.rowHeights = new int[]{51, 20, 114, 47, 0};
		gbl_panelRaporEkle.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelRaporEkle.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelRaporEkle.setLayout(gbl_panelRaporEkle);
		
		JLabel labelRaporAdi = new JLabel("Rapor Adi:");
		labelRaporAdi.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		GridBagConstraints gbc_labelRaporAdi = new GridBagConstraints();
		gbc_labelRaporAdi.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelRaporAdi.insets = new Insets(0, 0, 5, 5);
		gbc_labelRaporAdi.gridx = 0;
		gbc_labelRaporAdi.gridy = 1;
		panelRaporEkle.add(labelRaporAdi, gbc_labelRaporAdi);
		
		textFieldRaporAdi = new JTextField();
		textFieldRaporAdi.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		textFieldRaporAdi.setBackground(Color.WHITE);
		GridBagConstraints gbc_textFieldRaporAdi = new GridBagConstraints();
		gbc_textFieldRaporAdi.anchor = GridBagConstraints.NORTH;
		gbc_textFieldRaporAdi.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldRaporAdi.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldRaporAdi.gridx = 1;
		gbc_textFieldRaporAdi.gridy = 1;
		panelRaporEkle.add(textFieldRaporAdi, gbc_textFieldRaporAdi);
		textFieldRaporAdi.setColumns(10);
		
		JLabel labelRaporAciklama = new JLabel("Rapor Aciklama");
		labelRaporAciklama.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		GridBagConstraints gbc_labelRaporAciklama = new GridBagConstraints();
		gbc_labelRaporAciklama.anchor = GridBagConstraints.NORTH;
		gbc_labelRaporAciklama.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelRaporAciklama.insets = new Insets(0, 0, 5, 5);
		gbc_labelRaporAciklama.gridx = 0;
		gbc_labelRaporAciklama.gridy = 2;
		panelRaporEkle.add(labelRaporAciklama, gbc_labelRaporAciklama);
		
		final JTextArea textAreaRaporAciklama = new JTextArea();
		textAreaRaporAciklama.setFont(new Font("JetBrains Mono", Font.PLAIN, 9));
		GridBagConstraints gbc_textAreaRaporAciklama = new GridBagConstraints();
		gbc_textAreaRaporAciklama.fill = GridBagConstraints.BOTH;
		gbc_textAreaRaporAciklama.insets = new Insets(0, 0, 5, 0);
		gbc_textAreaRaporAciklama.gridx = 1;
		gbc_textAreaRaporAciklama.gridy = 2;
		panelRaporEkle.add(textAreaRaporAciklama, gbc_textAreaRaporAciklama);
		
		JButton btnRaporKaydet = new JButton("Rapor Kaydet");
		btnRaporKaydet.setBackground(Color.WHITE);
		
		btnRaporKaydet.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		GridBagConstraints gbc_btnRaporKaydet = new GridBagConstraints();
		gbc_btnRaporKaydet.fill = GridBagConstraints.BOTH;
		gbc_btnRaporKaydet.gridx = 1;
		gbc_btnRaporKaydet.gridy = 3;
		panelRaporEkle.add(btnRaporKaydet, gbc_btnRaporKaydet);
		
		btnRaporKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rapor rapor = new Rapor(textFieldRaporAdi.getText(), textAreaRaporAciklama.getText(), Login.currentPersonel.personelId);
				if(Rapor.RaporEkle(rapor)) {
					JOptionPane.showMessageDialog(null, "Rapor basariyla eklendi.");
					cardLayout.show(panels, RaporCard);
					connector.FillTable(tableRaporlar, "select raporId, raporAdi, raporAciklama, p.PersonelId, p.PersonelIsim from rapor as r left join personel as p on r.personelId = p.PersonelId");

				}
				else {
					JOptionPane.showMessageDialog(null, "Rapor olusturulurken bir sorun olustu!");
				}
			}
		});
		panelRaporGuncelle.setBackground(Color.WHITE);
		GridBagLayout gbl_panelRaporGuncelle = new GridBagLayout();
		gbl_panelRaporGuncelle.columnWidths = new int[]{105, 180, 0};
		gbl_panelRaporGuncelle.rowHeights = new int[]{14, 20, 114, 47, 0};
		gbl_panelRaporGuncelle.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelRaporGuncelle.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelRaporGuncelle.setLayout(gbl_panelRaporGuncelle);
		
		JLabel labelRaporId = new JLabel("Rapor ID:");
		labelRaporId.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		GridBagConstraints gbc_labelRaporId = new GridBagConstraints();
		gbc_labelRaporId.anchor = GridBagConstraints.NORTH;
		gbc_labelRaporId.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelRaporId.insets = new Insets(0, 0, 5, 5);
		gbc_labelRaporId.gridx = 0;
		gbc_labelRaporId.gridy = 0;
		panelRaporGuncelle.add(labelRaporId, gbc_labelRaporId);
		
		final JLabel labelRaporID = new JLabel("");
		labelRaporID.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		GridBagConstraints gbc_labelRaporID = new GridBagConstraints();
		gbc_labelRaporID.fill = GridBagConstraints.BOTH;
		gbc_labelRaporID.insets = new Insets(0, 0, 5, 0);
		gbc_labelRaporID.gridx = 1;
		gbc_labelRaporID.gridy = 0;
		panelRaporGuncelle.add(labelRaporID, gbc_labelRaporID);
		
		
		JLabel labelRaporAdiGuncelle = new JLabel("Rapor Adi:");
		labelRaporAdiGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		GridBagConstraints gbc_labelRaporAdiGuncelle = new GridBagConstraints();
		gbc_labelRaporAdiGuncelle.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelRaporAdiGuncelle.insets = new Insets(0, 0, 5, 5);
		gbc_labelRaporAdiGuncelle.gridx = 0;
		gbc_labelRaporAdiGuncelle.gridy = 1;
		panelRaporGuncelle.add(labelRaporAdiGuncelle, gbc_labelRaporAdiGuncelle);
		
		textFieldRaporAdiGuncelle = new JTextField();
		textFieldRaporAdiGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		textFieldRaporAdiGuncelle.setColumns(10);
		textFieldRaporAdiGuncelle.setBackground(Color.WHITE);
		GridBagConstraints gbc_textFieldRaporAdiGuncelle = new GridBagConstraints();
		gbc_textFieldRaporAdiGuncelle.anchor = GridBagConstraints.NORTH;
		gbc_textFieldRaporAdiGuncelle.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldRaporAdiGuncelle.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldRaporAdiGuncelle.gridx = 1;
		gbc_textFieldRaporAdiGuncelle.gridy = 1;
		panelRaporGuncelle.add(textFieldRaporAdiGuncelle, gbc_textFieldRaporAdiGuncelle);
		
		JLabel labelRaporAciklamaGuncelle = new JLabel("Rapor Aciklama");
		labelRaporAciklamaGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		GridBagConstraints gbc_labelRaporAciklamaGuncelle = new GridBagConstraints();
		gbc_labelRaporAciklamaGuncelle.anchor = GridBagConstraints.NORTH;
		gbc_labelRaporAciklamaGuncelle.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelRaporAciklamaGuncelle.insets = new Insets(0, 0, 5, 5);
		gbc_labelRaporAciklamaGuncelle.gridx = 0;
		gbc_labelRaporAciklamaGuncelle.gridy = 2;
		panelRaporGuncelle.add(labelRaporAciklamaGuncelle, gbc_labelRaporAciklamaGuncelle);
		
		final JTextArea textAreaRaporAciklamaGuncelle = new JTextArea();
		textAreaRaporAciklamaGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 9));
		GridBagConstraints gbc_textAreaRaporAciklamaGuncelle = new GridBagConstraints();
		gbc_textAreaRaporAciklamaGuncelle.fill = GridBagConstraints.BOTH;
		gbc_textAreaRaporAciklamaGuncelle.insets = new Insets(0, 0, 5, 0);
		gbc_textAreaRaporAciklamaGuncelle.gridx = 1;
		gbc_textAreaRaporAciklamaGuncelle.gridy = 2;
		panelRaporGuncelle.add(textAreaRaporAciklamaGuncelle, gbc_textAreaRaporAciklamaGuncelle);
		
		JButton btnRaporKaydetGuncelle = new JButton("Rapor Guncelle");
		
		btnRaporKaydetGuncelle.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		btnRaporKaydetGuncelle.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnRaporKaydetGuncelle = new GridBagConstraints();
		gbc_btnRaporKaydetGuncelle.fill = GridBagConstraints.BOTH;
		gbc_btnRaporKaydetGuncelle.gridx = 1;
		gbc_btnRaporKaydetGuncelle.gridy = 3;
		panelRaporGuncelle.add(btnRaporKaydetGuncelle, gbc_btnRaporKaydetGuncelle);
		
		btnRaporKaydetGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rapor rapor = Rapor.RaporBilgisiIste(labelRaporID.getText());
				rapor.RaporAdi = textFieldRaporAdiGuncelle.getText();
				rapor.RaporAciklama = textAreaRaporAciklamaGuncelle.getText();
				if(Rapor.RaporGuncelle(rapor)) {
					JOptionPane.showMessageDialog(null, "Rapor basariyla guncellendi.");
					cardLayout.show(panels, RaporCard);
					connector.FillTable(tableRaporlar, "select raporId, raporAdi, raporAciklama, p.PersonelId, p.PersonelIsim from rapor as r left join personel as p on r.personelId = p.PersonelId");

				}
				else {
					JOptionPane.showMessageDialog(null, "Bu rapor size ait degil!");
				}
			}
		});
		
		
		panelGunluk.setBackground(Color.WHITE);
		GridBagLayout gbl_panelGunluk = new GridBagLayout();
		gbl_panelGunluk.columnWidths = new int[]{225, 146, 334, 0};
		gbl_panelGunluk.rowHeights = new int[]{23, 14, 367, 0};
		gbl_panelGunluk.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelGunluk.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelGunluk.setLayout(gbl_panelGunluk);
		
		final DatePicker datePicker_1 = new DatePicker();
		datePicker_1.getComponentToggleCalendarButton().setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		datePicker_1.getComponentToggleCalendarButton().setBackground(Color.WHITE);
		datePicker_1.getComponentDateTextField().setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		datePicker_1.getComponentDateTextField().setBackground(Color.WHITE);
		GridBagConstraints gbc_datePicker_1_11 = new GridBagConstraints();
		gbc_datePicker_1_11.fill = GridBagConstraints.HORIZONTAL;
		gbc_datePicker_1_11.insets = new Insets(0, 0, 5, 5);
		gbc_datePicker_1_11.gridx = 0;
		gbc_datePicker_1_11.gridy = 0;
		panelGunluk.add(datePicker_1, gbc_datePicker_1_11);
		
		JButton btnGunlukGoster = new JButton("Goster");
		
		btnGunlukGoster.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		btnGunlukGoster.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnGunlukGoster = new GridBagConstraints();
		gbc_btnGunlukGoster.anchor = GridBagConstraints.NORTH;
		gbc_btnGunlukGoster.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGunlukGoster.insets = new Insets(0, 0, 5, 5);
		gbc_btnGunlukGoster.gridx = 1;
		gbc_btnGunlukGoster.gridy = 0;
		panelGunluk.add(btnGunlukGoster, gbc_btnGunlukGoster);
		
		btnGunlukGoster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalDate tarih = datePicker_1.getDate();
				Gunluk gunluk = Gunluk.GunlukBilgisiIste(tarih);
				connector.FillTable(tableGunlukHammadde, "select p.PersonelId, p.PersonelIsim, islemturAdi, h.hammaddeId, h.hammaddeAdi, adet from gunlukhammadde as gh left join personel as p on gh.personelId = p.PersonelId left join islemtur as it on gh.islemturId = it.islemturId left join gunluk as g on gh.gunlukId = g.gunlukId left join hammadde as h on gh.hammaddeId = h.hammaddeId where gh.gunlukId = " + gunluk.GunlukId);
				connector.FillTable(tableGunlukUrun, "select p.PersonelId, p.PersonelIsim, islemturAdi, u.urunId, u.urunAdi, adet from gunlukurun as gu left join personel as p on gu.personelId = p.PersonelId left join islemtur as it on gu.islemturId = it.islemturId left join gunluk as g on gu.gunlukId = g.gunlukId left join urun as u on gu.urunId = u.urunId where gu.gunlukId = " + gunluk.GunlukId);
			}
		});
		
		JLabel labelGunlukHammadde = new JLabel("Gunluk Hammadde");
		labelGunlukHammadde.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		labelGunlukHammadde.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_labelGunlukHammadde = new GridBagConstraints();
		gbc_labelGunlukHammadde.anchor = GridBagConstraints.NORTH;
		gbc_labelGunlukHammadde.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelGunlukHammadde.insets = new Insets(0, 0, 5, 5);
		gbc_labelGunlukHammadde.gridwidth = 2;
		gbc_labelGunlukHammadde.gridx = 0;
		gbc_labelGunlukHammadde.gridy = 1;
		panelGunluk.add(labelGunlukHammadde, gbc_labelGunlukHammadde);
		
		JLabel lblGunlukUrun = new JLabel("Gunluk Urun");
		lblGunlukUrun.setHorizontalAlignment(SwingConstants.CENTER);
		lblGunlukUrun.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		GridBagConstraints gbc_lblGunlukUrun = new GridBagConstraints();
		gbc_lblGunlukUrun.anchor = GridBagConstraints.NORTH;
		gbc_lblGunlukUrun.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblGunlukUrun.insets = new Insets(0, 0, 5, 0);
		gbc_lblGunlukUrun.gridx = 2;
		gbc_lblGunlukUrun.gridy = 1;
		panelGunluk.add(lblGunlukUrun, gbc_lblGunlukUrun);
		
		tableGunlukHammadde = new JTable();
		tableGunlukHammadde.setBackground(Color.WHITE);
		tableGunlukHammadde.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Personel ID", "Personel Adi", "Islem Turu", "Hammadde ID", "Hammadde Adi", "Adet"
			}
		));
		tableGunlukHammadde.getColumnModel().getColumn(3).setPreferredWidth(85);
		tableGunlukHammadde.getColumnModel().getColumn(4).setPreferredWidth(87);
		tableGunlukHammadde.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		GridBagConstraints gbc_tableGunlukHammadde = new GridBagConstraints();
		gbc_tableGunlukHammadde.fill = GridBagConstraints.BOTH;
		gbc_tableGunlukHammadde.insets = new Insets(0, 0, 0, 5);
		gbc_tableGunlukHammadde.gridwidth = 2;
		gbc_tableGunlukHammadde.gridx = 0;
		gbc_tableGunlukHammadde.gridy = 2;
		panelGunluk.add(tableGunlukHammadde, gbc_tableGunlukHammadde);
		
		tableGunlukUrun = new JTable();
		tableGunlukUrun.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Personel ID", "Personel Adi", "Islem Turu", "Urun ID", "Urun Adi", "Adet"
			}
		));
		tableGunlukUrun.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		GridBagConstraints gbc_tableGunlukUrun = new GridBagConstraints();
		gbc_tableGunlukUrun.fill = GridBagConstraints.BOTH;
		gbc_tableGunlukUrun.gridx = 2;
		gbc_tableGunlukUrun.gridy = 2;
		panelGunluk.add(tableGunlukUrun, gbc_tableGunlukUrun);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panelButtons, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(panels, GroupLayout.PREFERRED_SIZE, 750, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panels, GroupLayout.PREFERRED_SIZE, 454, GroupLayout.PREFERRED_SIZE)
				.addComponent(panelButtons, GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
		
				
		
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		
						// eger suanki ekran personel ekle ise 
				if(panels.getComponent(1).isShowing()) {
					cardLayout.show(panels, WelcomeCard);
				}
				else if(panels.getComponent(2).isShowing()) {
					cardLayout.show(panels, YonetimCard);
				}
				else if(panels.getComponent(3).isShowing()) {
					cardLayout.show(panels, PersonelCard);
				}
				else if(panels.getComponent(4).isShowing()) {
					cardLayout.show(panels, WelcomeCard);
				}
				else if(panels.getComponent(5).isShowing()) {
					cardLayout.show(panels, PersonelCard);
				}
				else if(panels.getComponent(6).isShowing()) {
					cardLayout.show(panels, HammaddeCard);
				}
				else if(panels.getComponent(7).isShowing()) {
					cardLayout.show(panels, HammaddeCard);
				}
				else if(panels.getComponent(8).isShowing()) {
					cardLayout.show(panels, WelcomeCard);
				}
				else if(panels.getComponent(9).isShowing()) {
					cardLayout.show(panels, UrunCard);
				}
				else if(panels.getComponent(10).isShowing()) {
					cardLayout.show(panels, UrunCard);
				}
				else if(panels.getComponent(11).isShowing()) {
					cardLayout.show(panels, YonetimCard);
				}
				else if(panels.getComponent(12).isShowing()) {
					cardLayout.show(panels, YonetimCard);
				}
				else if(panels.getComponent(13).isShowing()) {
					cardLayout.show(panels, YonetimCard);
				}
				else if(panels.getComponent(14).isShowing()) {
					cardLayout.show(panels, WelcomeCard);
				}
				else if(panels.getComponent(15).isShowing()) {
					cardLayout.show(panels, DepoCard);
				}
				else if(panels.getComponent(16).isShowing()) {
					cardLayout.show(panels, YonetimCard);
				}
				else if(panels.getComponent(17).isShowing()) {
					cardLayout.show(panels, YonetimCard);
				}
				else if(panels.getComponent(18).isShowing()) {
					cardLayout.show(panels, YonetimCard);
				}
				else if(panels.getComponent(19).isShowing()) {
					cardLayout.show(panels, YonetimCard);
				}
				else if(panels.getComponent(20).isShowing()) {
					cardLayout.show(panels, YonetimCard);
				}
				else if(panels.getComponent(21).isShowing()) {
					cardLayout.show(panels, YonetimCard);
				}
				else if(panels.getComponent(22).isShowing()) {
					cardLayout.show(panels, WelcomeCard);
				}
				else if(panels.getComponent(23).isShowing()) {
					cardLayout.show(panels, WelcomeCard);
				}
				else if(panels.getComponent(24).isShowing()) {
					cardLayout.show(panels, WelcomeCard);
				}
				else {
					cardLayout.show(panels, WelcomeCard);
				}
				
				btnGoBack.setBackground(Color.BLACK);
				btnGoBack.setForeground(Color.BLACK);
			}
		});
		
		btnAutomaticPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PasswordGenerator passwordGenerator = new PasswordGenerator.PasswordGeneratorBuilder().useDigits(true).useLower(true).useUpper(true).build();
				String password = passwordGenerator.generate(8);
				textFieldSifre.setText(password);
			}
		});
		
		btnGoBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(btnGoBack.isEnabled()) {
					btnGoBack.setBackground(Color.WHITE);
					btnGoBack.setForeground(Color.BLACK);
				}
			}
			
			
			@Override
			public void mouseExited(MouseEvent e) {
				if(btnGoBack.isEnabled()) {
					btnGoBack.setBackground(Color.BLACK);
					btnGoBack.setForeground(Color.WHITE);
				}
			}
		});
		
		btnYonetim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panels, YonetimCard);
			}
		});
		
		btnYonetim.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(btnYonetim.isEnabled()) {
					btnYonetim.setBackground(Color.WHITE);
					btnYonetim.setForeground(Color.BLACK);
				}
			}
			
			
			@Override
			public void mouseExited(MouseEvent e) {
				if(btnYonetim.isEnabled()) {
					btnYonetim.setBackground(Color.BLACK);
					btnYonetim.setForeground(Color.WHITE);
				}
			}
		});
		
		btnGunluk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panels, GunlukCard);
			}
		});
		
		btnPersonelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panels, PersonelCard);
			}
		});
		
		btnRapor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panels, RaporCard);
				connector.FillTable(tableRaporlar, "select raporId, raporAdi, raporAciklama, p.PersonelId, p.PersonelIsim from rapor as r left join personel as p on r.personelId = p.PersonelId");
				
			}
		});
		
		btnRapor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(btnRapor.isEnabled()) {
					btnRapor.setBackground(Color.WHITE);
					btnRapor.setForeground(Color.BLACK);
				}
			}
			
			
			@Override
			public void mouseExited(MouseEvent e) {
				if(btnRapor.isEnabled()) {
					btnRapor.setBackground(Color.BLACK);
					btnRapor.setForeground(Color.WHITE);
				}
			}
		});
		
		btnRaporOlustur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panels, RaporEkleCard);
			}
		});
		
		btnRaporSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog("Silmek istediginiz raporun id'sini giriniz.");
				if(!id.isEmpty()) {
					if(Rapor.RaporSil(id, Login.currentPersonel.personelId)) {
						JOptionPane.showMessageDialog(null, "Rapor basariyla silindi.");
						connector.FillTable(tableRaporlar, "select raporId, raporAdi, raporAciklama, p.PersonelId, p.PersonelIsim from rapor as r left join personel as p on r.personelId = p.PersonelId");

					}
					else {
						JOptionPane.showMessageDialog(null, "Bu rapor size ait degil!");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Bos Birakilamaz!");
				}
			}
		});
		
		btnRaporGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog("Guncellemek istediginiz rapor id'sini giriniz.");
				if(!id.isEmpty()) {
					Rapor rapor = Rapor.RaporBilgisiIste(id);
					if(rapor.PersonelId == Login.currentPersonel.personelId) {
						cardLayout.show(panels, RaporGuncelleCard);
						labelRaporID.setText(id);
						textFieldRaporAdiGuncelle.setText(rapor.RaporAdi);
						textAreaRaporAciklamaGuncelle.setText(rapor.RaporAciklama);
					}
					else {
						JOptionPane.showMessageDialog(null, "Bu rapor size ait degil!");
					}
				
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Bos Birakilamaz!");
				}
				
				
			}
		});
		
		btnSiparis.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(btnSiparis.isEnabled()) {
					btnSiparis.setBackground(Color.WHITE);
					btnSiparis.setForeground(Color.BLACK);
				}
			}
			
			
			@Override
			public void mouseExited(MouseEvent e) {
				if(btnSiparis.isEnabled()) {
					btnSiparis.setBackground(Color.BLACK);
					btnSiparis.setForeground(Color.WHITE);
				}
			}
		});
		
		btnSiparis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Login.currentPersonel.Yetki == 1) {
					cardLayout.show(panels, YoneticiSiparisCard);
					connector.FillTable(tableSiparisler, "select siparisId, siparisAdi, siparisAciklama, tf.FirmaAdi, siparisAdet, durumAdi, hammaddeAdi, PersonelId, PersonelIsim from siparis as s left join firma_satis as fs on fs.satisId = s.siparisFirmaSatis left join tedarikcifirma as tf on fs.FirmaId = tf.FirmaId left join hammadde as h on h.hammaddeId = fs.hammaddeId left join personel as p on s.siparisPersonel = p.PersonelId left join siparisdurum as sd on s.siparisDurum = sd.durumId");

				}
				else if(Login.currentPersonel.Yetki == 2) {
					cardLayout.show(panels, DepoSiparisCard);
					connector.FillTable(tableHammaddeSiparisleri, "select siparisId, siparisAdi, siparisAciklama, tf.FirmaAdi, siparisAdet, durumAdi, hammaddeAdi, PersonelId, PersonelIsim from siparis as s left join firma_satis as fs on fs.satisId = s.siparisFirmaSatis left join tedarikcifirma as tf on fs.FirmaId = tf.FirmaId left join hammadde as h on h.hammaddeId = fs.hammaddeId left join personel as p on s.siparisPersonel = p.PersonelId left join siparisdurum as sd on s.siparisDurum = sd.durumId");
					connector.FillTable(tableDepodanBeklenenSiparisler, "select depodansiparisId, siparisAdi, siparisAciklama, siparisAdet, hammaddeAdi, PersonelIsim from depodansiparis as d left join hammadde as h on d.siparisHammadde = h.hammaddeId left join personel as p on d.siparisPersonel = p.PersonelId");
				}
				else if(Login.currentPersonel.Yetki == 3) {
					cardLayout.show(panels, MatbaaSiparisCard);
					connector.FillTable(tableMatbaaSiparisler, "select depodansiparisId, siparisAdi, siparisAciklama, siparisAdet, hammaddeAdi, PersonelId, PersonelIsim from depodansiparis as d left join hammadde as h on d.siparisHammadde = h.hammaddeId left join personel as p on d.siparisPersonel = p.PersonelId");
				}
			}
		});
		
		btnHammaddeSiparisEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panels, DepoSiparisEkleCard);
				connector.FillTable(tableFirmaSatislar, "select satisId, firmaAdi, hammaddeAdi, birimFiyat from firma_satis as fs left join tedarikcifirma as tf on fs.FirmaId = tf.FirmaId left join hammadde as h on fs.hammaddeId = h.hammaddeId");
				
			}
		});
		
		btnSiparisEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panels, MatbaaSiparisEkleCard);
				connector.FillTable(tableSiparisHammaddeler, "select hammaddeId, hammaddeAdi, hammaddeturAdi from hammadde as h left join hammaddetur as ht on h.hammaddeTur = ht.hammaddeturId");
			}
		});
		
		btnMatbaaSiparisKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DepodanSiparis depodan = new DepodanSiparis(textFieldMatbaaSiparisAdi.getText(), textAreaMatbaaSiparisAciklama.getText(), textFieldMatbaaSiparisAdet.getText(), textFieldMatbaaSiparisHammaddeID.getText(), Login.currentPersonel.personelId);
				if(DepodanSiparis.DepodanSiparisOlustur(depodan)) {
					JOptionPane.showMessageDialog(null, "Siparis basariyla kaydedildi.");
					cardLayout.show(panels, MatbaaSiparisCard);
					connector.FillTable(tableMatbaaSiparisler, "select depodansiparisId, siparisAdi, siparisAciklama, siparisAdet, hammaddeAdi, PersonelId, PersonelIsim from depodansiparis as d left join hammadde as h on d.siparisHammadde = h.hammaddeId left join personel as p on d.siparisPersonel = p.PersonelId");

				}
				else {
					JOptionPane.showMessageDialog(null, "Siparis kaydedilirken bir sorun olustu!");
				}
			}
		});
		
		btnSiparisSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog("Lutfen silmek istediginiz siparisin id'sini giriniz.");
				if(!id.isEmpty()) {
					if(DepodanSiparis.DepodanSiparisSil(id)) {
						JOptionPane.showMessageDialog(null, "Siparis basariyla silindi.");
						connector.FillTable(tableMatbaaSiparisler, "select depodansiparisId, siparisAdi, siparisAciklama, siparisAdet, hammaddeAdi, PersonelId, PersonelIsim from depodansiparis as d left join hammadde as h on d.siparisHammadde = h.hammaddeId left join personel as p on d.siparisPersonel = p.PersonelId");

					}
					else {
						JOptionPane.showMessageDialog(null, "Siparis silinirken bir hata olustu!");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Bos Birakilamaz!");
				}
			}
		});
		
		btnSiparisGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog("Guncellemek istediginiz siparisin id'sini giriniz.");
				if(!id.isEmpty()) {
					cardLayout.show(panels, MatbaaSiparisGuncelleCard);
					connector.FillTable(tableHammaddelerGuncelle, "select hammaddeId, hammaddeAdi, hammaddeturAdi from hammadde as h left join hammaddetur as ht on h.hammaddeTur = ht.hammaddeturId");
					DepodanSiparis depodan = DepodanSiparis.DepodanSiparisBilgileriAl(id);
					labelMatbaaSiparisGuncelleID.setText(id);
					textFieldMatbaaSiparisGuncelleAdi.setText(depodan.siparisAdi);
					textAreaMatbaaSiparisGuncelleAciklama.setText(depodan.siparisTanim);
					textFieldMatbaaSiparisAdet.setText(depodan.Adet);
					textFieldMatbaaSiparisHammaddeID.setText(depodan.hammaddeId);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Bos Birakilamaz!");
				}
				
			}
		});
		
		btnMatbaaSiparisGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepodanSiparis depodan = DepodanSiparis.DepodanSiparisBilgileriAl(labelMatbaaSiparisGuncelleID.getText());
				depodan.siparisAdi = textFieldMatbaaSiparisGuncelleAdi.getText();
				depodan.siparisTanim = textAreaMatbaaSiparisGuncelleAciklama.getText();
				depodan.Adet = textFieldMatbaaSiparisGuncelleAdet.getText();
				depodan.hammaddeId = textFieldMatbaaSiparisGuncelleHammaddeID.getText();
				depodan.siparisID =  labelMatbaaSiparisGuncelleID.getText();
				if(depodan != null) {
					if(DepodanSiparis.DepodanSiparisGuncelle(depodan)) {
						JOptionPane.showMessageDialog(null, "Siparis basariyla guncellendi.");
						cardLayout.show(panels, MatbaaSiparisCard);
						connector.FillTable(tableMatbaaSiparisler, "select depodansiparisId, siparisAdi, siparisAciklama, siparisAdet, hammaddeAdi, PersonelId, PersonelIsim from depodansiparis as d left join hammadde as h on d.siparisHammadde = h.hammaddeId left join personel as p on d.siparisPersonel = p.PersonelId");

					}
					else {
						JOptionPane.showMessageDialog(null, "Siparis guncellenirken bir hata olustu!");
					}
				}
			}
		});
		
		btnDepoSiparisKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HammaddeSiparis siparis = new HammaddeSiparis(textFieldSiparisAdi.getText(), textAreaSiparisAciklama.getText(), textFieldSiparisAdet.getText(), 1, Login.currentPersonel.personelId, textFieldFirmaSatisID.getText());
				
				if(HammaddeSiparis.HammaddeSiparisOlustur(siparis)) {
					JOptionPane.showMessageDialog(null, "Siparis basariyla eklendi.");
					cardLayout.show(panels, DepoSiparisCard);
					connector.FillTable(tableHammaddeSiparisleri, "select siparisId, siparisAdi, siparisAciklama, tf.FirmaAdi, siparisAdet, durumAdi, hammaddeAdi, PersonelId, PersonelIsim from siparis as s left join firma_satis as fs on fs.satisId = s.siparisFirmaSatis left join tedarikcifirma as tf on fs.FirmaId = tf.FirmaId left join hammadde as h on h.hammaddeId = fs.hammaddeId left join personel as p on s.siparisPersonel = p.PersonelId left join siparisdurum as sd on s.siparisDurum = sd.durumId");

				}
				else {
					JOptionPane.showMessageDialog(null, "Siparis eklenirken bir sorun olustu!");
				}
			}
		});
		
		btnHammaddeSiparisSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog("Lutfen silmek istediginiz siparisin id'sini giriniz.");
				if(!id.isEmpty()) {
					if(HammaddeSiparis.HammaddeSiparisSil(id)) {
						JOptionPane.showMessageDialog(null, "Siparis basariyla silindi.");
						connector.FillTable(tableHammaddeSiparisleri, "select siparisId, siparisAdi, siparisAciklama, tf.FirmaAdi, siparisAdet, durumAdi, hammaddeAdi, PersonelId, PersonelIsim from siparis as s left join firma_satis as fs on fs.satisId = s.siparisFirmaSatis left join tedarikcifirma as tf on fs.FirmaId = tf.FirmaId left join hammadde as h on h.hammaddeId = fs.hammaddeId left join personel as p on s.siparisPersonel = p.PersonelId left join siparisdurum as sd on s.siparisDurum = sd.durumId");

					}
					else {
						JOptionPane.showMessageDialog(null, "Siparis silinirken bir hata olustu!");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Bos Birakilamaz!");
				}
			}
		});
		
		btnHammaddeSiparisGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog("Guncellemek istediginiz siparisin id'sini giriniz.");
				if(!id.isEmpty()) {
					HammaddeSiparis siparis = HammaddeSiparis.HammaddeSiparisBilgileriAl(id);
					cardLayout.show(panels, DepoSiparisGuncelleCard);
					labelSiparisID.setText(siparis.siparisID);
					textFieldSiparisAdiGuncelle.setText(siparis.siparisAdi);
					textAreaSiparisAciklamasiGuncelle.setText(siparis.siparisTanim);
					textFieldSiparisAdetGuncelle.setText(siparis.Adet);
					textFieldFirmaSatisIDGuncelle.setText(siparis.tfId);
					connector.FillTable(tableSiparisGuncelleFirmaSatis, "select satisId, FirmaAdi,  hammaddeAdi, birimFiyat from firma_satis as fs left join tedarikcifirma as t on fs.FirmaId = t.FirmaId left join hammadde as h on fs.hammaddeId = h.hammaddeId");
				}
				else {
					JOptionPane.showMessageDialog(null, "Bos Birakilamaz1");
				}
			}
		});
		
		btnSiparisGuncelleKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HammaddeSiparis siparis = HammaddeSiparis.HammaddeSiparisBilgileriAl(labelSiparisID.getText());
				siparis.siparisAdi = textFieldSiparisAdiGuncelle.getText();
				siparis.siparisTanim = textAreaSiparisAciklamasiGuncelle.getText();
				siparis.Adet = textFieldSiparisAdetGuncelle.getText();
				siparis.hammaddeId = Satis.SatisBilgisiIste(siparis.tfId).HammaddeId;
				siparis.tfId =  textFieldFirmaSatisIDGuncelle.getText();
				siparis.siparisID = labelSiparisID.getText();
				if(siparis != null) {
					if(HammaddeSiparis.HammaddeSiparisGuncelle(siparis)) {
						JOptionPane.showMessageDialog(null, "Siparis basariyla guncellendi.");
						cardLayout.show(panels, DepoSiparisCard);
						connector.FillTable(tableHammaddeSiparisleri, "select siparisId, siparisAdi, siparisAciklama, tf.FirmaAdi, siparisAdet, durumAdi, hammaddeAdi, PersonelId, PersonelIsim from siparis as s left join firma_satis as fs on fs.satisId = s.siparisFirmaSatis left join tedarikcifirma as tf on fs.FirmaId = tf.FirmaId left join hammadde as h on h.hammaddeId = fs.hammaddeId left join personel as p on s.siparisPersonel = p.PersonelId left join siparisdurum as sd on s.siparisDurum = sd.durumId");

					}
					else {
						JOptionPane.showMessageDialog(null, "Siparis guncellenirken bir hata olustu!");
					}
				}
			}
		});
		
		btnDepodanSiparisOnay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog("Hammadde gondermek istediginiz siparisin id'sini giriniz.");
				DepodanSiparis siparis = DepodanSiparis.DepodanSiparisBilgileriAl(id);
				if(!id.isEmpty()) {
					System.out.println(siparis.hammaddeId);
					if(Depo.DepodaVarMi(siparis.hammaddeId, 2)) {
						int adet = Integer.parseInt(JOptionPane.showInputDialog("Ne kadar hammadde gondermek istiyorsunuz?"));
						if(adet > 0) {
							String depo = JOptionPane.showInputDialog("Cikarmak istediginiz depo id'sini giriniz.");
							if(!depo.isEmpty()) {
								if(Depo.DepodaYeterliVarMi(siparis.hammaddeId, 2, adet)) {
									if(Depo.DepodanSil(depo, siparis.hammaddeId, 2, adet)) {
										
										if(HammaddeSiparis.HammaddeSiparisAdetEksilt(adet, id)) {
											JOptionPane.showMessageDialog(null, "Hammadde cikisi basariyla gerceklesti.");
											connector.FillTable(tableDepodanBeklenenSiparisler, "select depodansiparisId, siparisAdi, siparisAciklama, siparisAdet, hammaddeAdi, PersonelId, PersonelIsim from depodansiparis as d left join hammadde as h on d.siparisHammadde = h.hammaddeId left join personel as p on d.siparisPersonel = p.PersonelId");

										}
										else {
											JOptionPane.showMessageDialog(null, "Hammadde eksiltirken bir sorun olustu!");
										}
									}
									else {
										JOptionPane.showMessageDialog(null, "Depoda yeterli hammadde yok!");
									}
								}
								else {
									JOptionPane.showMessageDialog(null, "Depoda yeterli hammadde yok!");
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "Gecersiz Depo!");
							}
							
						}
						else {
							JOptionPane.showMessageDialog(null, "Bos Birakilamaz!");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Depoda bu hammadde yok!");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Bos Birakilamaz!");
				}
			}
		});
		
		btnYoneticiSiparisOnayla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog("Onaylamak istediginiz siparis id'sini giriniz");
				if(!id.isEmpty()) {
					if(HammaddeSiparis.SiparisOnay(id, 2)) {
						JOptionPane.showMessageDialog(null, "Siparis basariyla onaylandi.");
						connector.FillTable(tableSiparisler, "select siparisId, siparisAdi, siparisAciklama, tf.FirmaAdi, siparisAdet, durumAdi, hammaddeAdi, PersonelId, PersonelIsim from siparis as s left join firma_satis as fs on fs.satisId = s.siparisFirmaSatis left join tedarikcifirma as tf on fs.FirmaId = tf.FirmaId left join hammadde as h on h.hammaddeId = fs.hammaddeId left join personel as p on s.siparisPersonel = p.PersonelId left join siparisdurum as sd on s.siparisDurum = sd.durumId");

					}
					else {
						JOptionPane.showMessageDialog(null, "Onaylanirken bir sorun olustu!");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Bos Birakilamaz!");
				}
			}
		});
		
		btnFirmaYonetim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panels, FirmaYonetimCard);
				connector.FillTable(tableFirmalar, "select * from tedarikcifirma");
			}
		});
		
		btnFirmaEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panels, FirmaEkleCard);
			}
		});
		
		btnFirmaKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TedarikciFirma firma = new TedarikciFirma(textFieldFirmaAdi.getText(), textFieldFirmaTel.getText(), textAreaFirmaAdres.getText());
				if(TedarikciFirma.FirmaEkle(firma)) {
					JOptionPane.showMessageDialog(null, "Firma basariyla eklendi.");
					cardLayout.show(panels, FirmaYonetimCard);
					connector.FillTable(tableFirmalar, "select * from tedarikcifirma");
				}
			}
		});
		
		btnFirmaSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = JOptionPane.showInputDialog("Lutfen silmek istediginiz firmanin id'sini giriniz.");
				if(!input.isEmpty()) {
					if(TedarikciFirma.FirmaSil(input)) {
						JOptionPane.showMessageDialog(null, "Firma basariyla silindi");
						connector.FillTable(tableFirmalar, "select * from tedarikcifirma");
					}
					else {
						JOptionPane.showMessageDialog(null, "Firma silinirken bir sorun olustu!");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Bos Birakilamaz!");
				}
			}
		});
		
		btnFirmaGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog("Lutfen guncellemek istediginiz firmanin id'sini giriniz.");
				if(!id.isEmpty()) {
					cardLayout.show(panels, FirmaGuncelleCard);
					TedarikciFirma firma = TedarikciFirma.FirmaBilgiIste(id);
					labelFirmaGuncelleID.setText(firma.FirmaID);
					textFieldFirmaAdiGuncelle.setText(firma.FirmaAdi);
					textFieldFirmaTelGuncelle.setText(firma.FirmaTelefon);
					textAreaFirmaAdresGuncelle.setText(firma.FirmaAdres);
				}
				else {
					JOptionPane.showMessageDialog(null, "Bos Birakilamaz!");
				}
				
			}
		});
		
		btnFirmaKaydetGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TedarikciFirma firma = new TedarikciFirma(textFieldFirmaAdiGuncelle.getText(), textFieldFirmaTelGuncelle.getText(), textAreaFirmaAdresGuncelle.getText());
				firma.FirmaID = labelFirmaGuncelleID.getText();
				if(TedarikciFirma.FirmaGuncelle(firma)) {
					JOptionPane.showMessageDialog(null, "Firma basariyla guncellendi.");
					cardLayout.show(panels, FirmaYonetimCard);
					connector.FillTable(tableFirmalar, "select * from tedarikcifirma");
				}
			}
		});
		
		btnFirmaSatislar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panels, SatisYonetimCard);
				connector.FillTable(tableSatislar, "select satisId, FirmaAdi, hammaddeAdi, birimFiyat from firma_satis as fs left join tedarikcifirma as tf on fs.FirmaId = tf.FirmaId left join hammadde as h on fs.hammaddeId = h.hammaddeId");
			}
		});
		
		btnFirmaSatisEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panels, SatisEkleCard);
			}
		});
		
		btnSatisKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Satis satis = new Satis(textFieldFirmaID.getText(), textFieldHammaddeID.getText(), textFieldBirimFiyat.getText());
				if(Satis.SatisEkle(satis)) {
					JOptionPane.showMessageDialog(null, "Satis basariyla kaydedildi");
					cardLayout.show(panels, SatisYonetimCard);
					connector.FillTable(tableSatislar, "select satisId, FirmaAdi, hammaddeAdi, birimFiyat from firma_satis as fs left join tedarikcifirma as tf on fs.FirmaId = tf.FirmaId left join hammadde as h on fs.hammaddeId = h.hammaddeId");

				}
				else {
					JOptionPane.showMessageDialog(null, "Satis kaydedilirken bir sorun olustu!");
				}
			}
		});
		
		btnSatisSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog("Lutfen silmek istediginiz satisin id'sini giriniz.");
				if(!id.isEmpty()) {
					if(Satis.SatisSil(id)) {
						JOptionPane.showMessageDialog(null, "Satis basariyla silindi.");
						connector.FillTable(tableSatislar, "select satisId, FirmaAdi, hammaddeAdi, birimFiyat from firma_satis as fs left join tedarikcifirma as tf on fs.FirmaId = tf.FirmaId left join hammadde as h on fs.hammaddeId = h.hammaddeId");

					}
					else {
						JOptionPane.showMessageDialog(null, "Satis silinirken bir sorun olustu!");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Bos Birakilamaz!");
				}
			}
		});
		
		btnSatisGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog("Lutfen guncellemek istediginiz satisin id'sini giriniz.");
				if(!id.isEmpty()) {
					cardLayout.show(panels, SatisGuncelleCard);
					labelSatisIDGuncelle.setText(id);
					Satis satis = Satis.SatisBilgisiIste(labelSatisIDGuncelle.getText());
					textFieldFirmaAdiGuncelle.setText(satis.FirmaId);
					textFieldHammaddeGuncelle.setText(satis.HammaddeId);
					textFieldBirimFiyatGuncelle.setText(satis.birimFiyat);
				}
				else {
					JOptionPane.showMessageDialog(null, "Bos Birakilamaz!");
				}	
			}
		});
		
		btnSayisGuncelleKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Satis satis = new Satis(textFieldFirmaAdiGuncelle.getText(), textFieldHammaddeIdGuncelle.getText(), textFieldBirimFiyatGuncelle.getText());
				satis.SatisId = labelSatisIDGuncelle.getText();
				if(Satis.SatisGuncelle(satis)) {
					JOptionPane.showMessageDialog(null, "Satis basariyla guncellendi.");
					cardLayout.show(panels, SatisYonetimCard);
					connector.FillTable(tableSatislar, "select satisId, FirmaAdi, hammaddeAdi, birimFiyat from firma_satis as fs left join tedarikcifirma as tf on fs.FirmaId = tf.FirmaId left join hammadde as h on fs.hammaddeId = h.hammaddeId");

				}
				else {
					JOptionPane.showMessageDialog(null, "Satis guncellenirken bir sorun olustu!");
				}
			}
		});
		
		btnDepoYonetim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panels, DepoYonetimCard);
				connector.FillTable(tableUrunDepo, "select depoId, depoAdi, PersonelIsim, depoturAdi from depo as d left join personel as p on p.PersonelId = d.personelId left join depotur as dt on dt.depoturId = d.depoTur where d.depoTur = 1");
				connector.FillTable(tableHammaddeDepo, "select depoId, depoAdi, PersonelIsim, depoturAdi from depo as d left join personel as p on p.PersonelId = d.personelId left join depotur as dt on dt.depoturId = d.depoTur where d.depoTur = 2");
			}
		});
		
		btnDepoEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panels, DepoEkleCard);
				comboBoxDepoTur.removeAllItems();
				connector.FillComboBox(comboBoxDepoTur, "select * from depotur");
			}
		});
		
		btnDepoSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = JOptionPane.showInputDialog("Lutfen silmek istediginiz deponun id'sini giriniz.");
				if(!input.isEmpty()) {
					if(Depo.DepoSil(input)) {
						JOptionPane.showMessageDialog(null, "Depo basariyla silindi");
						connector.FillTable(tableHammaddeDepo, "select depoId, depoAdi, PersonelIsim, depoturAdi from depo as d left join personel as p on p.PersonelId = d.personelId left join depotur as dt on dt.depoturId = d.depoTur where d.depoTur = 1");
						connector.FillTable(tableHammaddeDepo, "select depoId, depoAdi, PersonelIsim, depoturAdi from depo as d left join personel as p on p.PersonelId = d.personelId left join depotur as dt on dt.depoturId = d.depoTur where d.depoTur = 2");
					
					}
				}
			}
		});
		
		btnDepoGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = JOptionPane.showInputDialog("Lutfen guncellemek istediginiz deponun id'sini giriniz.");
				if(!input.isEmpty()) {
					cardLayout.show(panels, DepoGuncelleCard);
					Depo depo = Depo.DepoBilgileri(input);
					labelDepoID.setText(depo.depoId);
					textFieldDepoAdiGuncelle.setText(depo.depoAdi);
					textFieldPersonelIdGuncelle.setText(depo.personelId);
					connector.FillComboBox(comboBoxDepoTuruGuncelle, "select * from depotur");
				}
				else {
					JOptionPane.showMessageDialog(null,"Bos Birakilamaz!");
				}
				
			}
		});
		
		
		btnHammadde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panels, HammaddeCard);
				connector.FillComboBox(comboBoxHammadde, "select * from hammaddetur");
				connector.FillTable(tableHammaddeTur, "select * from hammaddetur");
			}
		});
		
		btnHammadde.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(btnHammadde.isEnabled()) {
					btnHammadde.setBackground(Color.WHITE);
					btnHammadde.setForeground(Color.BLACK);
				}
			}
			
			
			@Override
			public void mouseExited(MouseEvent e) {
				if(btnHammadde.isEnabled()) {
					btnHammadde.setBackground(Color.BLACK);
					btnHammadde.setForeground(Color.WHITE);
				}
			}
		});
		
		btnUrun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panels, UrunCard);
				connector.FillTable(tableUrun, "select urunId, UrunAdi, UrunAciklamasi, Fiyat, h.hammaddeAdi, a.hammaddeAdi, b.hammaddeAdi from urun as u left join hammadde as h on u.Kagit = h.hammaddeId left join hammadde as a on u.Boya = a.hammaddeId left join hammadde as b on u.Yapistirici = b.hammaddeId");
			}
		});
		
		btnUrun.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(btnUrun.isEnabled()) {
					btnUrun.setBackground(Color.WHITE);
					btnUrun.setForeground(Color.BLACK);
				}
			}
			
			
			@Override
			public void mouseExited(MouseEvent e) {
				if(btnUrun.isEnabled()) {
					btnUrun.setBackground(Color.BLACK);
					btnUrun.setForeground(Color.WHITE);
				}
			}
		});
		
		btnDepo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panels, DepoCard);
				connector.FillTable(tableUrunDepolar, "select depoId, depoAdi, PersonelIsim, depoturAdi from depo as d left join personel as p on p.PersonelId = d.personelId left join depotur as dt on dt.depoturId = d.depoTur where d.depoTur = 1");
				connector.FillTable(tableHammaddeDepolar, "select depoId, depoAdi, PersonelIsim, depoturAdi from depo as d left join personel as p on p.PersonelId = d.personelId left join depotur as dt on dt.depoturId = d.depoTur where d.depoTur = 2");
				
			}
		});
		
		btnDepo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(btnDepo.isEnabled()) {
					btnDepo.setBackground(Color.WHITE);
					btnDepo.setForeground(Color.BLACK);
				}
			}
			
			
			@Override
			public void mouseExited(MouseEvent e) {
				if(btnDepo.isEnabled()) {
					btnDepo.setBackground(Color.BLACK);
					btnDepo.setForeground(Color.WHITE);
				}
			}
		});
		
		btnDepoIcerik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = JOptionPane.showInputDialog("Lutfen gormek istediginiz deponun id'sini giriniz.");
				if(!input.isEmpty()) {
					cardLayout.show(panels, DepoIcerikCard);
					labelDepoIcerikID.setText(input);
					Depo depo = Depo.DepoBilgileri(input);
					if(depo.depoTur == 1) {
						connector.FillTable(tableDepoIcerik, "select i.urunid, u.UrunAdi, i.adet from urun_depo_icerik as i left join depo as d on d.depoId = i.depoid left join urun as u on i.urunid = u.urunId where d.depoTur = 1 and d.depoId = " + input);
					}
					else if(depo.depoTur == 2) {
						connector.FillTable(tableDepoIcerik, "select i.hammaddeId, h.hammaddeAdi, i.adet from hammadde_depo_icerik as i left join depo as d on d.depoId = i.depoid left join hammadde as h on i.hammaddeId = h.hammaddeId where d.depoTur = 2 and d.depoId = " + input);

					}
				}else {
					JOptionPane.showMessageDialog(null, "Bos Birakilamaz!");
				}
				
				
			}
		});
		
		btnDepoyaEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Depo depo = Depo.DepoBilgileri(labelDepoIcerikID.getText());
				String icerik = JOptionPane.showInputDialog("Eklemek istediginiz icerigin id'sini giriniz.");
				String adet = JOptionPane.showInputDialog("Eklemek istediginiz miktari giriniz.");
				if(Depo.DepoyaEkle(depo.depoId, icerik, depo.depoTur, adet)) {
					JOptionPane.showMessageDialog(null, "Icerik basariyla kaydedildi");
					
					if(depo.depoTur == 1) {
						connector.FillTable(tableDepoIcerik, "select i.urunid, u.UrunAdi, i.adet from urun_depo_icerik as i left join depo as d on d.depoId = i.depoid left join urun as u on i.urunid = u.urunId where d.depoTur = 1 and d.depoId = " + labelDepoIcerikID.getText());
						
						LocalDate date = LocalDate.now();
						Gunluk.GunlukOlustur(date);
						int adet2 = Integer.parseInt(adet);
						Gunluk.GunlugeEkle(1, adet2, icerik, false, date, Login.currentPersonel.personelId);
					}
					else if(depo.depoTur == 2) {
						connector.FillTable(tableDepoIcerik, "select i.hammaddeId, h.hammaddeAdi, i.adet from hammadde_depo_icerik as i left join depo as d on d.depoId = i.depoid left join hammadde as h on i.hammaddeId = h.hammaddeId where d.depoTur = 2 and d.depoId = " + labelDepoIcerikID.getText());
						LocalDate date = LocalDate.now();
						Gunluk.GunlukOlustur(date);
						int adet2 = Integer.parseInt(adet);
						Gunluk.GunlugeEkle(1, adet2, icerik, true, date, Login.currentPersonel.personelId);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Icerik kaydedilirken bir sorun olustu!");
				}
			}
		});
		
		btnDepotanSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Depo depo = Depo.DepoBilgileri(labelDepoIcerikID.getText());
				String icerik = JOptionPane.showInputDialog("Silmek istediginiz icerigin id'sini giriniz.");
				int adet = Integer.parseInt(JOptionPane.showInputDialog("Silmek istediginiz miktari giriniz."));
				if(Depo.DepodanSil(depo.depoId, icerik, depo.depoTur, adet)) {
					JOptionPane.showMessageDialog(null, "Icerik basariyla silindi");
					if(depo.depoTur == 1) {
						connector.FillTable(tableDepoIcerik, "select i.urunid, u.UrunAdi, i.adet from urun_depo_icerik as i left join depo as d on d.depoId = i.depoid left join urun as u on i.urunid = u.urunId where d.depoTur = 1 and d.depoId = " + labelDepoIcerikID.getText());
						LocalDate date = LocalDate.now();
						Gunluk.GunlukOlustur(date);
						Gunluk.GunlugeEkle(2, adet, icerik, false, date, Login.currentPersonel.personelId);
					}
					else if(depo.depoTur == 2) {
						connector.FillTable(tableDepoIcerik, "select i.hammaddeId, h.hammaddeAdi, i.adet from hammadde_depo_icerik as i left join depo as d on d.depoId = i.depoid left join hammadde as h on i.hammaddeId = h.hammaddeId where d.depoTur = 2 and d.depoId = " + labelDepoIcerikID.getText());
						LocalDate date = LocalDate.now();
						Gunluk.GunlukOlustur(date);
						Gunluk.GunlugeEkle(2, adet, icerik, true, date, Login.currentPersonel.personelId);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Icerik silinirken bir sorun olustu!");
				}
			}
		});
		
		btnUrunEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panels, UrunEkleCard);
				comboBoxKagit.removeAllItems();
				comboBoxBoya.removeAllItems();
				comboBoxYapistirici.removeAllItems();
				connector.FillComboBox(comboBoxKagit, "select * from hammadde where hammaddeTur = 1");
				connector.FillComboBox(comboBoxBoya, "select * from hammadde where hammaddeTur = 2");
				connector.FillComboBox(comboBoxYapistirici, "select * from hammadde where hammaddeTur = 3");
			}
		});
		
		btnUrunKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int kagitid = Hammadde.HammaddeAdinaGoreIdBul(comboBoxKagit.getSelectedItem().toString());
				int boyaid = Hammadde.HammaddeAdinaGoreIdBul(comboBoxBoya.getSelectedItem().toString());
				int yapistiriciid = Hammadde.HammaddeAdinaGoreIdBul(comboBoxYapistirici.getSelectedItem().toString());
				Urun urun = new Urun(textFieldUrunAdi.getText(), textAreaUrunAciklamasi.getText(), kagitid, boyaid, yapistiriciid, textFieldFiyat.getText());
				
				if(Urun.UrunEkle(urun)) {
					JOptionPane.showMessageDialog(null, "Urun basariyla kaydedildi");
					
					cardLayout.show(panels, UrunCard);
					connector.FillTable(tableUrun, "select urunId, UrunAdi, UrunAciklamasi, Fiyat, h.hammaddeAdi, a.hammaddeAdi, b.hammaddeAdi from urun as u left join hammadde as h on u.Kagit = h.hammaddeId left join hammadde as a on u.Boya = a.hammaddeId left join hammadde as b on u.Yapistirici = b.hammaddeId");
				}
				else {
					JOptionPane.showMessageDialog(null, "Urun kaydedilirken bir sorun olustu!");
				}
				
			}
		});
		
		btnUrunSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog("Silmek istediginiz urunun id'sini giriniz.");
				if(!id.isEmpty()) {
					if(Urun.UrunSil(id)) {
						JOptionPane.showMessageDialog(null, "Urun basariyla silindi");
						connector.FillTable(tableUrun, "select urunId, UrunAdi, UrunAciklamasi, Fiyat, h.hammaddeAdi, a.hammaddeAdi, b.hammaddeAdi from urun as u left join hammadde as h on u.Kagit = h.hammaddeId left join hammadde as a on u.Boya = a.hammaddeId left join hammadde as b on u.Yapistirici = b.hammaddeId");
					}
				}
			}
		});
		
		btnUrunGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog("Guncellemek istediginiz urunun id'sini giriniz.");
				cardLayout.show(panels, UrunGuncelleCard);
				Urun urun = Urun.UrunBilgileri(id);
				textFieldUrunAdiGuncelle.setText(urun.UrunAdi);
				textAreaUrunAciklamasiGuncelle.setText(urun.UrunAciklamasi);
				textFieldFiyatGuncelle.setText(urun.Fiyat);
				connector.FillComboBox(comboBoxKagitGuncelle, "select * from hammadde where hammaddeTur = 1");
				connector.FillComboBox(comboBoxBoyaGuncelle, "select * from hammadde where hammaddeTur = 2");
				connector.FillComboBox(comboBoxYapistiriciGuncelle, "select * from hammadde where hammaddeTur = 3");
				comboBoxKagitGuncelle.setSelectedIndex(0);
				comboBoxBoyaGuncelle.setSelectedIndex(0);
				comboBoxYapistiriciGuncelle.setSelectedIndex(0);
				labelUrunGuncelleID.setText(urun.UrunId);
			}
		});
		
		btnUrunuGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int kagitid = Hammadde.HammaddeAdinaGoreIdBul(comboBoxKagitGuncelle.getSelectedItem().toString());
				int boyaid = Hammadde.HammaddeAdinaGoreIdBul(comboBoxBoyaGuncelle.getSelectedItem().toString());
				int yapistiriciid = Hammadde.HammaddeAdinaGoreIdBul(comboBoxYapistiriciGuncelle.getSelectedItem().toString());
				Urun urun = new Urun(textFieldUrunAdiGuncelle.getText(), textAreaUrunAciklamasiGuncelle.getText(), kagitid, boyaid, yapistiriciid, textFieldFiyatGuncelle.getText());
				urun.UrunId = labelUrunGuncelleID.getText();
				if(Urun.UrunGuncelle(urun.UrunId, urun)) {
					JOptionPane.showMessageDialog(null, "Urun basariyla guncellendi.");
					cardLayout.show(panels, UrunCard);
					connector.FillTable(tableUrun, "select urunId, UrunAdi, UrunAciklamasi, Fiyat, h.hammaddeAdi, a.hammaddeAdi, b.hammaddeAdi from urun as u left join hammadde as h on u.Kagit = h.hammaddeId left join hammadde as a on u.Boya = a.hammaddeId left join hammadde as b on u.Yapistirici = b.hammaddeId");
				}
				else {
					JOptionPane.showMessageDialog(null, "Urun guncellenirken bir sorun olustu!");
				}
				
			}
		});
		
		btnHammaddeEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panels, HammaddeEkleCard);
				comboBoxHammadde.removeAllItems();
				connector.FillComboBox(comboBoxHammaddeTurleri, "select * from hammaddetur");
			}
		});
		
		btnHammaddeSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog(null, "Silmek istediginiz hammaddenin id'sini giriniz.");
				if(!id.isEmpty()) {
					int input = JOptionPane.showConfirmDialog(null, "Silmek istedinizden emin misiniz?");
					if(input == 0) {
						if(Hammadde.HammaddeSil(id)) {
							JOptionPane.showMessageDialog(null, "Hammadde basariyla silindi");
							connector.FillTable(tableHammadde, "select hammaddeId, hammaddeAdi, ht.hammaddeturAdi from hammadde as h left join hammaddetur as ht on h.hammaddeTur = ht.hammaddeturId");
						}
						else {
							JOptionPane.showMessageDialog(null, "Hammadde silinirken bir hata olustu!");
						}
					}
				}
			}
		});
		
		
		btnHammaddeGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog("Guncellemek istediginiz hammadde id'sini giriniz.");
				if(id != "0" && !id.isEmpty()) {
					cardLayout.show(panels, HammaddeGuncelleCard);
					comboBoxHammaddeGuncelle.removeAllItems();
					connector.FillComboBox(comboBoxHammaddeGuncelle, "select * from hammaddetur");
					Hammadde.HammaddeBilgileriIste(labelId, textFieldHammaddeGuncelle, comboBoxHammaddeGuncelle, id);
				}else {
					cardLayout.show(panels, HammaddeCard);
				}
				
			}
		});
		
		btnHepsiniGoster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				connector.FillTable(tableHammadde, "select hammaddeId, hammaddeAdi, ht.hammaddeturAdi from hammadde as h left join hammaddetur as ht on h.hammaddeTur = ht.hammaddeturId");
			}
		});
		
		btnGoster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SecilmisTur = comboBoxHammadde.getSelectedItem().toString();
				int index = Hammadde.GetHammaddeTurId(SecilmisTur);
				connector.FillTable(tableHammadde, "select hammaddeId, hammaddeAdi, ht.hammaddeturAdi from hammadde as h left join hammaddetur as ht on h.hammaddeTur = ht.hammaddeturId and h.hammaddeTur = " + index);
			}
		});
		
		btnYeniHammaddeTur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String TurAdi = JOptionPane.showInputDialog("Eklemek istediginiz tur adini giriniz.");
				if(Hammadde.HammaddeTurEkle(TurAdi)) {
					JOptionPane.showMessageDialog(null, "Yeni tur basariyla kaydedildi");
					comboBoxHammadde.removeAllItems();
					connector.FillComboBox(comboBoxHammadde, "select * from hammaddetur");
					connector.FillTable(tableHammaddeTur, "select * from hammaddetur");
				}
				else {
					JOptionPane.showMessageDialog(null, "Bir hata olustu!");
				}
				
			}
		});
		
		btnHammaddeTurSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String TurId = JOptionPane.showInputDialog("Silmek istediginiz tur id'sini giriniz.");
				int input = JOptionPane.showConfirmDialog(null, "Silmek istedinizden emin misiniz?");
				if(input == 0) {
					if(Hammadde.HammaddeTurSil(TurId)) {
						JOptionPane.showMessageDialog(null, "Tur basariyla silindi.");
						comboBoxHammadde.removeAllItems();
						connector.FillComboBox(comboBoxHammadde, "select * from hammaddetur");
						connector.FillTable(tableHammaddeTur, "select * from hammaddetur");
					}
					else {
						JOptionPane.showMessageDialog(null, "Bir hata olustu!");
					}
				}
				
			}
		});
		
		btnHammaddeTurGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String TurId = JOptionPane.showInputDialog("Guncellemek istediginiz tur id'sini giriniz.");
				String YeniTurAdi = JOptionPane.showInputDialog("Yeni tur adini giriniz.");
				if(!YeniTurAdi.isEmpty()) {
					if(Hammadde.HammaddeTurGuncelle(TurId, YeniTurAdi)) {
						JOptionPane.showMessageDialog(null, "Tur basariyla guncellendi.");
						comboBoxHammadde.removeAllItems();
						connector.FillComboBox(comboBoxHammadde, "select * from hammaddetur");
						connector.FillTable(tableHammaddeTur, "select * from hammaddetur");
					}
					else {
						JOptionPane.showMessageDialog(null, "Bir hata olustu!");
					}
				}
			}
		});
		
		comboBoxYetki.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				connector.FillComboBox(comboBoxYetki, "select * from yetki");
			}
		});
		
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalDate date = datePicker.getDate();
				if(Personel.PersonelEkle(textFieldTC.getText(), textFieldIsim.getText(), textFieldSoyIsim.getText(), group.getSelection().getActionCommand(), textFieldEmail.getText(), date, textFieldTel.getText(), textAreaAdres.getText(), comboBoxYetki.getSelectedIndex() + 1, textFieldKullaniciAdi.getText(), textFieldSifre.getText())) {
					JOptionPane.showMessageDialog(null, "Personel basariyla kaydedildi.");
					cardLayout.show(panels, YonetimCard);
					connector.FillTable(tablePersonel, "select PersonelId, personelTC, PersonelIsim, PersonelSoyIsim, PersonelCinsiyet, PersonelEmail, PersonelDogumTarihi, PersonelTelefonNo, PersonelAdres, y.yetkiadi, PersonelUsername, PersonelPassword from personel as p left join yetki as y on p.PersonelYetki = y.idyetki");
				}
				else {
					JOptionPane.showMessageDialog(null, "Bir hata olustu!");
				}
				
			}
		});
		
		btnYeniPersonel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panels, PersonelEkleCard);
				connector.FillComboBox(comboBoxYetki, "select * from yetki");
			}
		});
		
		
		
		btnPersonelSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Tc = JOptionPane.showInputDialog("Silmek istediginiz personelin TC Kimlik numarasini giriniz.");
				if(Tc != null) {
					int input = JOptionPane.showConfirmDialog(null, "Silmek istediginize emin misiniz?");
					if(input == 0) {
						Personel.PersonelSil(Tc);
						connector.FillTable(tablePersonel, "select PersonelId, personelTC, PersonelIsim, PersonelSoyIsim, PersonelCinsiyet, PersonelEmail, PersonelDogumTarihi, PersonelTelefonNo, PersonelAdres, y.yetkiadi, PersonelUsername, PersonelPassword from personel as p left join yetki as y on p.PersonelYetki = y.idyetki");
						JOptionPane.showMessageDialog(null, "Personel basariyla silindi.");
					}
				}
				
			}
		});
		
		
		
		btnPersonelGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tc = JOptionPane.showInputDialog("Guncellemek istediginiz personelin TC Kimlik numarasini giriniz.");
				if(Tc != null && !Tc.isEmpty()) {
					if(Personel.TcExists(Tc)) {
						cardLayout.show(panels, PersonelGuncelleCard);
					}else {
						JOptionPane.showMessageDialog(null, "Tc Bulunamadi!");
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Bos birakilamaz!");
				}
			}
		});
		
		buttonGuncelleKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Personel.PersonelGuncelle(textFieldGuncelleTC.getText(), textFieldGuncelleIsim.getText(), textFieldGuncelleSoyIsim.getText(), groupGuncelle.getSelection().getActionCommand(), textFieldGuncelleEmail.getText(), datePickerGuncelle.getDate(), textFieldGuncelleTel.getText(), textAreaGuncelleAdres.getText(), comboBoxGuncelleYetki.getSelectedIndex() + 1, textFieldGuncelleKullaniciAdi.getText(), textFieldGuncelleSifre.getText())) {
					JOptionPane.showMessageDialog(null, "Guncelleme basariyla kaydedildi.");
					cardLayout.show(panels, YonetimCard);
					connector.FillTable(tablePersonel, "select PersonelId, personelTC, PersonelIsim, PersonelSoyIsim, PersonelCinsiyet, PersonelEmail, PersonelDogumTarihi, PersonelTelefonNo, PersonelAdres, y.yetkiadi, PersonelUsername, PersonelPassword from personel as p left join yetki as y on p.PersonelYetki = y.idyetki");
				}else {
					JOptionPane.showMessageDialog(null, "Bir hata olustu!");
				}
			}
		});
		
		
		panelWelcome.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
				if(panels.getComponent(0).isShowing()) {
					btnGoBack.setEnabled(false);
					btnGoBack.setText("");
				}else {
					btnGoBack.setEnabled(true);
					btnGoBack.setText("<- Geri <-");
					btnGoBack.setForeground(Color.WHITE);
				}
			}
			
			@Override
			public void componentHidden(ComponentEvent e) {
				
				if(panels.getComponent(0).isShowing()) {
					btnGoBack.setEnabled(false);
					btnGoBack.setText("");
				}else {
					btnGoBack.setEnabled(true);
					btnGoBack.setText("<- Geri <-");
					btnGoBack.setForeground(Color.WHITE);
				}
			}
		});
		
		panelPersonel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				connector.FillTable(tablePersonel, "select PersonelId, personelTC, PersonelIsim, PersonelSoyIsim, PersonelCinsiyet, PersonelEmail, PersonelDogumTarihi, PersonelTelefonNo, PersonelAdres, y.yetkiadi, PersonelUsername, PersonelPassword from personel as p left join yetki as y on p.PersonelYetki = y.idyetki");
				
			}
		});
		
		panelPersonelGuncelle.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				if(Personel.TcExists(Tc)) {
					Personel.PersonelBilgisiIste(Tc, textFieldGuncelleTC, textFieldGuncelleIsim, textFieldGuncelleSoyIsim, radioButtonErkek, radioButtonKadin, textFieldGuncelleEmail, datePickerGuncelle, textFieldGuncelleTel, textAreaGuncelleAdres, comboBoxGuncelleYetki, textFieldGuncelleKullaniciAdi, textFieldGuncelleSifre);
				}else {
					JOptionPane.showMessageDialog(null, "Tc Bulunamadi!");
				}
			}
		});
		
		panelHammadde.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				connector.FillTable(tableHammadde, "select hammaddeId, hammaddeAdi, ht.hammaddeturAdi from hammadde as h left join hammaddetur as ht on h.hammaddeTur = ht.hammaddeturId");
			}
		});
		
		panelButtons.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
			}
		});
		
		
		// BUTON YETKILERINI VERDIGIMIZ YER
				if(Login.currentPersonel.Yetki == 1) {
					btnYonetim.setEnabled(true);
					
				}
				else if(Login.currentPersonel.Yetki == 2) {
					btnYonetim.setEnabled(false);
					btnYonetim.hide();
				}
				else if(Login.currentPersonel.Yetki == 3) {
					btnYonetim.setEnabled(false);
					btnDepo.setEnabled(false);
					btnDepo.hide();
					btnYonetim.hide();
				}
				// BUTON YETKILERINI VERDIGIMIZ YER
		
	}// MAIN
} // CLASS

