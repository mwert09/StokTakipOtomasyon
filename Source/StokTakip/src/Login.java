import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
	
	static Login frame;
	
	MySQLConnector mySqlConnector = new MySQLConnector();
	public static Personel currentPersonel;

	private JPanel contentPane;
	public static JTextField txtFieldUsername;
	public static JPasswordField txtFieldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Login();
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
	public Login() {
		
		setBackground(Color.WHITE);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Resources/login-square-arrow-button-outline_icon-icons.com_73220.png")));
		setTitle("Login");
		setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 348, 364);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblImage = new JLabel("");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setIcon(new ImageIcon(Login.class.getResource("/Resources/login-square-arrow-button-outline_icon-icons.com_73220.png")));
		
		JLabel lblUsername = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lblUsername.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		
		JLabel lblPassword = new JLabel("\u015Eifre");
		lblPassword.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		
		JButton btnLogin = new JButton("Giri\u015F");
		
		
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		
		txtFieldUsername = new JTextField();
		txtFieldUsername.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		txtFieldUsername.setColumns(10);
		
		txtFieldPassword = new JPasswordField();
		txtFieldPassword.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		
		final JLabel lblInfo = new JLabel("Lutfen bosluklari doldurunuz.");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(97)
					.addComponent(lblImage, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
					.addGap(98))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUsername)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtFieldPassword, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
						.addComponent(txtFieldUsername, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblInfo, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblImage)
					.addGap(52)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(txtFieldUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(txtFieldPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addComponent(lblInfo)
					.addGap(18)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(44, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		// LISTENER //
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = new String(txtFieldPassword.getPassword());
				if(mySqlConnector.Login(txtFieldUsername.getText(), password, lblInfo)) {
					// eger giris yapilmissa ana ekrani ac
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								SetCurrentUser();
								frame.setVisible(false);
								Main mainFrame = new Main(); 
								mainFrame.setVisible(true);
								
								
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					
				}
			}
		});
		
	}// LOGIN
	
	public void SetCurrentUser() {
		PreparedStatement state = null;
		PreparedStatement stateYetki = null;
		ResultSet result = null;
		ResultSet resultYetki = null;
		String password = new String(Login.txtFieldPassword.getPassword());
	
		try {
			mySqlConnector.OpenCloseConnection(true);
			state = mySqlConnector.connection.prepareStatement("select PersonelId, personelTC, PersonelIsim, PersonelSoyIsim, PersonelCinsiyet, PersonelEmail, PersonelDogumTarihi, PersonelTelefonNo, PersonelAdres, PersonelYetki, PersonelUsername, PersonelPassword from personel where PersonelUsername = ? and PersonelPassword = ?");
			state.setString(1, Login.txtFieldUsername.getText());
			state.setString(2, new String(password));
			result = state.executeQuery();
			if(result.next()) {
				String Isim = result.getString(3);
				String SoyIsim = result.getString(4);
				int personelId = result.getInt(1);
				String personelTC = result.getString(2);
				String TamIsim = result.getString(3) + " " + result.getString(4);
				String Cinsiyet = result.getString(5);
				String Email = result.getString(6);
				LocalDate DogumTarihi = result.getObject(7, LocalDate.class);
				String TelefonNo = result.getString(8);
				String Adres = result.getString(9);
				int Yetki = result.getInt(10);
				currentPersonel = new Personel(personelId, personelTC, TamIsim, Cinsiyet, Email, DogumTarihi, TelefonNo, Adres, Yetki);
				currentPersonel.Isim = Isim;
				currentPersonel.SoyIsim = SoyIsim;
			}
			stateYetki = mySqlConnector.connection.prepareStatement("select yetkiadi from yetki where idyetki = ?");
			stateYetki.setInt(1, currentPersonel.Yetki);
			resultYetki = stateYetki.executeQuery();
			if(resultYetki.next()) {
				currentPersonel.YetkiAdi = resultYetki.getString(1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "SetCurrentUser hatasi olustu");
		}
		finally {
			mySqlConnector.OpenCloseConnection(false);
			try {
				state.close();
				result.close();
				resultYetki.close();
				stateYetki.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
}
