package eg.edu.alexu.csd.datastructure.mailServer.cs12_cs57_cs62;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import eg.edu.alexu.csd.datastructure.linkedList.cs12_cs62.SLinkedList;
import eg.edu.alexu.csd.datastructure.queue.cs57_cs12_cs62.LinkedBased;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class Compose extends JFrame {

	private static JPanel contentPane;
	static Compose frame = new Compose();
	private JTextField textField;
	private JTextField textField_1;
	private JTextArea textArea;

	private Mail mail;
	private String subject;
	private String receiver;
	private LinkedBased receivers = new LinkedBased();
	private String priority;
	private File body = new File("Body.txt");
	private SLinkedList attachments = new SLinkedList();
	private String s;
	private int attCounter = 0;
	private int recCounter = 0;
	private boolean attached = false;
	private boolean draft;
	private Mail x;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setUndecorated(true);
					Toolkit toolkit = frame.getToolkit();
					Dimension size = toolkit.getScreenSize();
					frame.setLocation(size.width/2 - frame.getWidth()/2 , size.height/2 - frame.getHeight()/2);
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Compose() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1204, 760);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextArea txtrTo = new JTextArea();
		txtrTo.setFont(new Font("Modern No. 20", Font.BOLD, 20));
		txtrTo.setEditable(false);
		txtrTo.setText("To:");
		txtrTo.setBounds(38, 51, 47, 33);
		contentPane.add(txtrTo);

		JTextArea txtrSubject = new JTextArea();
		txtrSubject.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
		txtrSubject.setEditable(false);
		txtrSubject.setText("Subject:");
		txtrSubject.setBounds(38, 211, 99, 34);
		contentPane.add(txtrSubject);

		textField = new JTextField();
		textField.setBounds(104, 51, 446, 33);
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
				if (textField.getText().length() != 0) {
					receiver = textField.getText();
				}
			}

		});

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(202, 208, 518, 40);
		contentPane.add(textField_1);
		textField_1.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				if (textField_1.getText().length() != 0) {
					subject = textField_1.getText();
				}
			}

		});

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Priority", "1", "2", "3", "4" }));
		comboBox.setBounds(952, 29, 118, 28);
		contentPane.add(comboBox);
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (comboBox.getSelectedIndex() != 0) {
					priority = Integer.toString(comboBox.getSelectedIndex());
				}
			}
		});

		textArea = new JTextArea();
		textArea.setFont(new Font("Arial", Font.PLAIN, 15));
		textArea.setLineWrap(true);
		textArea.setBounds(38, 258, 1110, 309);
		contentPane.add(textArea);
		Document d = textArea.getDocument();
		textArea.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				try {
					s = d.getText(0, d.getLength());
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (receivers.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No contacts is entered");
				} else {
					mail = new Mail();
					mail.setReceivers(receivers);
					if (subject == null || subject.length() == 0) {
						mail.setSubject("No Subject");
					} else {
						mail.setSubject(subject);
					}
					try {
						FileWriter fw = new FileWriter(body);
						if (s != null) {
							fw.write(s);
						}
						fw.flush();
						fw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					mail.setBody(body);
					mail.setAttachments(attachments);
					if (priority == null) {
						mail.setPriority("4");
					} else {
						mail.setPriority(priority);
					}
					boolean check = SignIn.account.compose(mail);
					if (!check) {
						LinkedBased errors = mail.getErrors();
						if (errors.size() == 1) {
							String error = (String) errors.dequeue();
							JOptionPane.showMessageDialog(null, error + "is not found");
						} else {
							String error = (String) errors.dequeue();
							while (!errors.isEmpty()) {
								error += "," + (String) errors.dequeue();
							}
							JOptionPane.showMessageDialog(null, error + "are not found");
						}
						// frame.setVisible(false);
						frame.dispose();
					} else {
						// frame.setVisible(false);
						frame.dispose();
					}
				}
				textArea.setText("");
				textField_1.setText("");
			}
		});
		btnSend.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 15));
		btnSend.setBounds(1041, 671, 115, 40);
		contentPane.add(btnSend);

		JPanel panel = new JPanel();
		panel.setBounds(38, 94, 1113, 107);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 10, 146, 35);
		panel.add(lblNewLabel);
		lblNewLabel.setVisible(false);

		JButton btnNewButton = new JButton("x");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				receivers.dequeue();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(155, 10, 51, 35);
		panel.add(btnNewButton);
		btnNewButton.setVisible(false);

		JButton button_1 = new JButton("x");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LinkedBased temp = new LinkedBased();
				for (int i = 0; i < 1; i++) {
					temp.enqueue(receivers.dequeue());
				}
				receivers.dequeue();
				while (!receivers.isEmpty()) {
					temp.enqueue(receivers.dequeue());
				}
				while (!temp.isEmpty()) {
					receivers.enqueue(temp.dequeue());
				}
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.setBounds(377, 10, 51, 35);
		panel.add(button_1);
		button_1.setVisible(false);

		JLabel label = new JLabel("New label");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(230, 10, 146, 35);
		panel.add(label);
		label.setVisible(false);

		JLabel label_1 = new JLabel("New label");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(450, 10, 146, 35);
		panel.add(label_1);
		label_1.setVisible(false);

		JButton button_2 = new JButton("x");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LinkedBased temp = new LinkedBased();
				for (int i = 0; i < 2; i++) {
					temp.enqueue(receivers.dequeue());
				}
				receivers.dequeue();
				while (!receivers.isEmpty()) {
					temp.enqueue(receivers.dequeue());
				}
				while (!temp.isEmpty()) {
					receivers.enqueue(temp.dequeue());
				}
			}
		});
		button_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		button_2.setBackground(Color.LIGHT_GRAY);
		button_2.setBounds(596, 10, 51, 35);
		panel.add(button_2);
		button_2.setVisible(false);

		JLabel label_2 = new JLabel("New label");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(667, 10, 159, 35);
		panel.add(label_2);
		label_2.setVisible(false);

		JButton button_3 = new JButton("x");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LinkedBased temp = new LinkedBased();
				for (int i = 0; i < 3; i++) {
					temp.enqueue(receivers.dequeue());
				}
				receivers.dequeue();
				while (!receivers.isEmpty()) {
					temp.enqueue(receivers.dequeue());
				}
				while (!temp.isEmpty()) {
					receivers.enqueue(temp.dequeue());
				}
			}
		});
		button_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		button_3.setBackground(Color.LIGHT_GRAY);
		button_3.setBounds(826, 10, 49, 35);
		panel.add(button_3);
		button_3.setVisible(false);

		JLabel label_3 = new JLabel("New label");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(904, 10, 146, 35);
		panel.add(label_3);
		label_3.setVisible(false);

		JButton button_13 = new JButton("x");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LinkedBased temp = new LinkedBased();
				for (int i = 0; i < 4; i++) {
					temp.enqueue(receivers.dequeue());
				}
				receivers.dequeue();
				while (!receivers.isEmpty()) {
					temp.enqueue(receivers.dequeue());
				}
				while (!temp.isEmpty()) {
					receivers.enqueue(temp.dequeue());
				}
			}
		});
		button_13.setFont(new Font("Tahoma", Font.BOLD, 10));
		button_13.setBackground(Color.LIGHT_GRAY);
		button_13.setBounds(1052, 10, 51, 35);
		panel.add(button_13);
		button_13.setVisible(false);

		JLabel label_4 = new JLabel("New label");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_4.setBounds(10, 55, 146, 35);
		panel.add(label_4);
		label_4.setVisible(false);

		JButton button_14 = new JButton("x");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LinkedBased temp = new LinkedBased();
				for (int i = 0; i < 5; i++) {
					temp.enqueue(receivers.dequeue());
				}
				receivers.dequeue();
				while (!receivers.isEmpty()) {
					temp.enqueue(receivers.dequeue());
				}
				while (!temp.isEmpty()) {
					receivers.enqueue(temp.dequeue());
				}
			}
		});
		button_14.setFont(new Font("Tahoma", Font.BOLD, 10));
		button_14.setBackground(Color.LIGHT_GRAY);
		button_14.setBounds(155, 55, 51, 35);
		panel.add(button_14);
		button_14.setVisible(false);

		JLabel label_5 = new JLabel("New label");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBounds(230, 55, 146, 35);
		panel.add(label_5);
		label_5.setVisible(false);

		JButton button_15 = new JButton("x");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LinkedBased temp = new LinkedBased();
				for (int i = 0; i < 6; i++) {
					temp.enqueue(receivers.dequeue());
				}
				receivers.dequeue();
				while (!receivers.isEmpty()) {
					temp.enqueue(receivers.dequeue());
				}
				while (!temp.isEmpty()) {
					receivers.enqueue(temp.dequeue());
				}
			}
		});
		button_15.setFont(new Font("Tahoma", Font.BOLD, 10));
		button_15.setBackground(Color.LIGHT_GRAY);
		button_15.setBounds(377, 55, 51, 35);
		panel.add(button_15);
		button_15.setVisible(false);

		JLabel label_6 = new JLabel("New label");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_6.setBounds(450, 55, 146, 35);
		panel.add(label_6);
		label_6.setVisible(false);

		JButton button_16 = new JButton("x");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LinkedBased temp = new LinkedBased();
				for (int i = 0; i < 7; i++) {
					temp.enqueue(receivers.dequeue());
				}
				receivers.dequeue();
				while (!receivers.isEmpty()) {
					temp.enqueue(receivers.dequeue());
				}
				while (!temp.isEmpty()) {
					receivers.enqueue(temp.dequeue());
				}
			}
		});
		button_16.setFont(new Font("Tahoma", Font.BOLD, 10));
		button_16.setBackground(Color.LIGHT_GRAY);
		button_16.setBounds(596, 55, 51, 35);
		panel.add(button_16);
		button_16.setVisible(false);

		JLabel label_7 = new JLabel("New label");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_7.setBounds(667, 55, 159, 35);
		panel.add(label_7);
		label_7.setVisible(false);

		JButton button_17 = new JButton("x");
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LinkedBased temp = new LinkedBased();
				for (int i = 0; i < 8; i++) {
					temp.enqueue(receivers.dequeue());
				}
				receivers.dequeue();
				while (!receivers.isEmpty()) {
					temp.enqueue(receivers.dequeue());
				}
				while (!temp.isEmpty()) {
					receivers.enqueue(temp.dequeue());
				}
			}
		});
		button_17.setFont(new Font("Tahoma", Font.BOLD, 10));
		button_17.setBackground(Color.LIGHT_GRAY);
		button_17.setBounds(826, 55, 49, 35);
		panel.add(button_17);
		button_17.setVisible(false);

		JLabel label_8 = new JLabel("New label");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_8.setBounds(904, 55, 146, 35);
		panel.add(label_8);
		label_8.setVisible(false);

		JButton button_18 = new JButton("x");
		button_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LinkedBased temp = new LinkedBased();
				for (int i = 0; i < 9; i++) {
					temp.enqueue(receivers.dequeue());
				}
				receivers.dequeue();
				while (!receivers.isEmpty()) {
					temp.enqueue(receivers.dequeue());
				}
				while (!temp.isEmpty()) {
					receivers.enqueue(temp.dequeue());
				}
			}
		});
		button_18.setFont(new Font("Tahoma", Font.BOLD, 10));
		button_18.setBackground(Color.LIGHT_GRAY);
		button_18.setBounds(1052, 55, 51, 35);
		panel.add(button_18);
		button_18.setVisible(false);

		JButton button = new JButton("+");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (receiver != null) {
					receivers.enqueue(receiver);
					switch (recCounter) {
					case 0:
						lblNewLabel.setText(receiver);
						lblNewLabel.setVisible(true);
						btnNewButton.setVisible(true);
						break;
					case 1:
						label.setText(receiver);
						label.setVisible(true);
						button_1.setVisible(true);
						break;
					case 2:
						label_1.setText(receiver);
						label_1.setVisible(true);
						button_2.setVisible(true);
						break;
					case 3:
						label_2.setText(receiver);
						label_2.setVisible(true);
						button_3.setVisible(true);
						break;
					case 4:
						label_3.setText(receiver);
						label_3.setVisible(true);
						button_13.setVisible(true);
						break;
					case 5:
						label_4.setText(receiver);
						label_4.setVisible(true);
						button_14.setVisible(true);
						break;
					case 6:
						label_5.setText(receiver);
						label_5.setVisible(true);
						button_15.setVisible(true);
						break;
					case 7:
						label_6.setText(receiver);
						label_6.setVisible(true);
						button_16.setVisible(true);
						break;
					case 8:
						label_7.setText(receiver);
						label_7.setVisible(true);
						button_17.setVisible(true);
						break;
					case 9:
						label_8.setText(receiver);
						label_8.setVisible(true);
						button_18.setVisible(true);
						break;
					}
					recCounter++;
					receiver = null;
					textField.setText("");
				}
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 18));
		button.setBounds(560, 51, 56, 30);
		contentPane.add(button);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(41, 577, 1096, 84);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File x = (File) attachments.get(0);
				Desktop dt = Desktop.getDesktop();
				try {
					dt.open(x);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_2.setForeground(SystemColor.textHighlight);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(10, 10, 187, 29);
		panel_1.add(btnNewButton_2);
		btnNewButton_2.setVisible(false);

		JButton button_4 = new JButton("New button");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File x = (File) attachments.get(1);
				Desktop dt = Desktop.getDesktop();
				try {
					dt.open(x);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button_4.setForeground(SystemColor.textHighlight);
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_4.setBounds(236, 10, 187, 29);
		panel_1.add(button_4);
		button_4.setVisible(false);

		JButton button_5 = new JButton("New button");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File x = (File) attachments.get(2);
				Desktop dt = Desktop.getDesktop();
				try {
					dt.open(x);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button_5.setForeground(SystemColor.textHighlight);
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_5.setBounds(454, 10, 187, 29);
		panel_1.add(button_5);
		button_5.setVisible(false);

		JButton button_6 = new JButton("New button");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File x = (File) attachments.get(3);
				Desktop dt = Desktop.getDesktop();
				try {
					dt.open(x);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button_6.setForeground(SystemColor.textHighlight);
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_6.setBounds(680, 10, 187, 29);
		panel_1.add(button_6);
		button_6.setVisible(false);

		JButton button_7 = new JButton("New button");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File x = (File) attachments.get(4);
				Desktop dt = Desktop.getDesktop();
				try {
					dt.open(x);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button_7.setForeground(SystemColor.textHighlight);
		button_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_7.setBounds(899, 10, 187, 29);
		panel_1.add(button_7);
		button_7.setVisible(false);

		JButton button_8 = new JButton("New button");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File x = (File) attachments.get(5);
				Desktop dt = Desktop.getDesktop();
				try {
					dt.open(x);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button_8.setForeground(SystemColor.textHighlight);
		button_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_8.setBounds(10, 45, 187, 29);
		panel_1.add(button_8);
		button_8.setVisible(false);

		JButton button_9 = new JButton("New button");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File x = (File) attachments.get(6);
				Desktop dt = Desktop.getDesktop();
				try {
					dt.open(x);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button_9.setForeground(SystemColor.textHighlight);
		button_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_9.setBounds(236, 45, 187, 29);
		panel_1.add(button_9);
		button_9.setVisible(false);

		JButton button_10 = new JButton("New button");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File x = (File) attachments.get(7);
				Desktop dt = Desktop.getDesktop();
				try {
					dt.open(x);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button_10.setForeground(SystemColor.textHighlight);
		button_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_10.setBounds(454, 45, 187, 29);
		panel_1.add(button_10);
		button_10.setVisible(false);

		JButton button_11 = new JButton("New button");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File x = (File) attachments.get(8);
				Desktop dt = Desktop.getDesktop();
				try {
					dt.open(x);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button_11.setForeground(SystemColor.textHighlight);
		button_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_11.setBounds(680, 45, 187, 29);
		panel_1.add(button_11);
		button_11.setVisible(false);

		JButton button_12 = new JButton("New button");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File x = (File) attachments.get(9);
				Desktop dt = Desktop.getDesktop();
				try {
					dt.open(x);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button_12.setForeground(SystemColor.textHighlight);
		button_12.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_12.setBounds(899, 45, 187, 29);
		panel_1.add(button_12);
		button_12.setVisible(false);

		Icon icon = new ImageIcon("attachment.png");
		JButton btnAttachment = new JButton("");
		btnAttachment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showOpenFileDialog();
				if (attached) {
					File x = (File) attachments.get(attCounter);
					switch (attCounter) {
					case 0:
						btnNewButton_2.setText(x.getName());
						btnNewButton_2.setVisible(true);
						break;
					case 1:
						button_4.setText(x.getName());
						button_4.setVisible(true);
						break;
					case 2:
						button_5.setText(x.getName());
						button_5.setVisible(true);
						break;
					case 3:
						button_6.setText(x.getName());
						button_6.setVisible(true);
						break;
					case 4:
						button_7.setText(x.getName());
						button_7.setVisible(true);
						break;
					case 5:
						button_8.setText(x.getName());
						button_8.setVisible(true);
						break;
					case 6:
						button_9.setText(x.getName());
						button_9.setVisible(true);
						break;
					case 7:
						button_10.setText(x.getName());
						button_10.setVisible(true);
						break;
					case 8:
						button_11.setText(x.getName());
						button_11.setVisible(true);
						break;
					case 9:
						button_12.setText(x.getName());
						button_12.setVisible(true);
						break;
					}
					attCounter++;
					attached = false;
				}
				if (attCounter >= 10) {
					btnAttachment.setEnabled(false);
				}
			}
		});
		btnAttachment.setBounds(704, 671, 47, 40);
		btnAttachment.setIcon(resizeIcon(icon, btnAttachment.getWidth(), btnAttachment.getHeight()));
		contentPane.add(btnAttachment);

		JButton btnSaveDraft = new JButton("Save Draft");
		btnSaveDraft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mail = new Mail();
				mail.setReceivers(receivers);
				if (subject == null || subject.length() == 0) {
					mail.setSubject("No Subject");
				} else {
					mail.setSubject(subject);
				}
				try {
					FileWriter fw = new FileWriter(body);
					if (s != null) {
						fw.write(s);
					}
					fw.flush();
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mail.setBody(body);
				mail.setAttachments(attachments);
				mail.setPriority(priority);
				SignIn.account.draft(mail);
				frame.dispose();
				textArea.setText("");
				textField_1.setText("");
				textField.setText("");
				frame.dispose();
				frame.setVisible(false);
			}
		});
		btnSaveDraft.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 15));
		btnSaveDraft.setBounds(881, 671, 133, 40);
		contentPane.add(btnSaveDraft);
	}

	private Icon resizeIcon(Icon icon, int width, int height) {
		// TODO Auto-generated method stub
		Image img = ((ImageIcon) icon).getImage();
		Image resizedImage = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(resizedImage);
	}

	private void showOpenFileDialog() {
		// TODO Auto-generated method stub
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setAcceptAllFileFilterUsed(true);
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			attachments.add(selectedFile);
			attached = true;
		}
	}
}
