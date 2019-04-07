package eg.edu.alexu.csd.datastructure.mailServer.cs12_cs57_cs62;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import eg.edu.alexu.csd.datastructure.mailServer.cs12_cs57_cs62.MailServer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JToggleButton;

@SuppressWarnings("serial")
public class SignIn extends JFrame {

	static SignIn frame = new SignIn();

	static MailServer account = new MailServer();
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;
	private String email;
	private String password = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setTitle("Mail");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SignIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 428);
		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEnterYourAccount = new JLabel("E-mail");
		lblEnterYourAccount.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblEnterYourAccount.setBounds(98, 73, 131, 28);
		contentPane.add(lblEnterYourAccount);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(259, 73, 197, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				email = textField.getText();
			}

		});

		JLabel lblEnterPassword = new JLabel("Password");
		lblEnterPassword.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblEnterPassword.setBounds(98, 127, 108, 28);
		contentPane.add(lblEnterPassword);

		textField_1 = new JPasswordField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setBounds(259, 127, 197, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				char[] temp = textField_1.getPassword();
				for (int i = 0; i < temp.length; i++) {
					password += temp[i];
				}
			}
		});

		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.setBackground(new Color(230, 230, 250));
		btnSignIn.setFont(new Font("Arial Black", Font.PLAIN, 22));
		btnSignIn.setBounds(240, 237, 131, 36);
		contentPane.add(btnSignIn);
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean check = account.signin(email, password);
				if (!check) {
					JOptionPane.showMessageDialog(null, "Please check your e-mail and password");

				} else {
					frame.setVisible(false);
					TestNew.frame.setVisible(true);
				}
				textField_1.setText(""); 
				textField.setText("");
				password = "";
				email = "";
			}
		});

		JButton btnCreate = new JButton("Create New Account");
		btnCreate.setFont(new Font("Arial", Font.PLAIN, 15));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				SignUp.frame.setVisible(true);
			}
		});
		btnCreate.setBounds(202, 331, 207, 36);
		contentPane.add(btnCreate);
	}
}
