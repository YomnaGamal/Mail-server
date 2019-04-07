package eg.edu.alexu.csd.datastructure.mailServer.cs12_cs57_cs62;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Change_Password extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JPasswordField passwordField_3;
	boolean u;
	static Change_Password frame = new Change_Password();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
	public Change_Password() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPleaseEnterOld = new JLabel("Please Enter old password");
		lblPleaseEnterOld.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPleaseEnterOld.setBounds(29, 11, 236, 43);
		contentPane.add(lblPleaseEnterOld);

		passwordField = new JPasswordField();
		passwordField.setBounds(288, 24, 136, 20);
		contentPane.add(passwordField);

		JLabel lblPleaseRepeatOld = new JLabel("Please Repeat old password");
		lblPleaseRepeatOld.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPleaseRepeatOld.setBounds(29, 65, 236, 43);
		contentPane.add(lblPleaseRepeatOld);

		JLabel lblPleaseEnterNew = new JLabel("Please Enter new password");
		lblPleaseEnterNew.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPleaseEnterNew.setBounds(29, 119, 236, 43);
		contentPane.add(lblPleaseEnterNew);

		JLabel lblPleaseRepeatNew = new JLabel("Please Repeat new password");
		lblPleaseRepeatNew.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPleaseRepeatNew.setBounds(29, 173, 236, 43);
		contentPane.add(lblPleaseRepeatNew);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(288, 78, 136, 20);
		contentPane.add(passwordField_1);

		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(288, 132, 136, 20);
		contentPane.add(passwordField_2);

		passwordField_3 = new JPasswordField();
		passwordField_3.setBounds(288, 186, 136, 20);
		contentPane.add(passwordField_3);

		JButton btnChange = new JButton("Change");
		btnChange.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnChange.setBounds(145, 217, 136, 33);
		contentPane.add(btnChange);

		ActionListener actionListenerchange = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// abstractButton.setText(newLabel);
				String op1 = "";
				String op2 = "";
				String np1 = "";
				String np2 = "";
				for (int i = 0; i < passwordField_1.getPassword().length; i++) {
					op1 += passwordField.getPassword()[i];
				}
				for (int i = 0; i < passwordField_2.getPassword().length; i++) {
					np1 += passwordField_2.getPassword()[i];
				}
				for (int i = 0; i < passwordField_1.getPassword().length; i++) {
					op2 += passwordField_1.getPassword()[i];
				}
				for (int i = 0; i < passwordField_2.getPassword().length; i++) {
					np2 += passwordField_3.getPassword()[i];
				}
				if (op1.equals(op2)) {
					if (np1.equals(np2)) {
						u = SignIn.account.changePassword(SignIn.account.currentContact, op1, np1);
					}
				} 
				if (!u) {
					// error massage
					JOptionPane.showMessageDialog(null, "INVALED INPUTS!");
					passwordField.setText("");
					passwordField_1.setText("");
					passwordField_2.setText("");
					passwordField_3.setText("");
				} else {
					frame.setVisible(false);
					TestNew.frame.setVisible(true);
				}
			}
		};
		btnChange.addActionListener(actionListenerchange);
	}
}
