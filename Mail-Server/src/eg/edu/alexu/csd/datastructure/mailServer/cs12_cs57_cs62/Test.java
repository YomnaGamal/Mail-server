package eg.edu.alexu.csd.datastructure.mailServer.cs12_cs57_cs62;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import eg.edu.alexu.csd.datastructure.linkedList.cs12_cs62.SLinkedList;
import eg.edu.alexu.csd.datastructure.queue.cs57_cs12_cs62.LinkedBased;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JMenuItem;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Test extends JFrame {
	static Test frame = new Test();
	private JPanel contentPane;
	private final JRadioButton checkbox = new JRadioButton("Selecte ALL", false);
	static int noPag = 1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Toolkit toolkit = frame.getToolkit();
					Dimension size = toolkit.getScreenSize();
					frame.setSize(size.width, size.height);
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
	public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 928, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton b = new JButton("New button");
		b.setBounds(1250, 5, 90, 69);
        JPopupMenu m = new JPopupMenu();
        ActionListener menuListener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            if (event.getActionCommand().equals("Sign_Out")) {
            	frame.setVisible(false);
				SignIn.frame.setVisible(true);
            } /**else if (event.getActionCommand().equals("Change passowrd")) {
            	frame.setVisible(false);
				SignIn.frame.setVisible(true);
            }**/
            }
          };
        JMenuItem item;
        m.add(item = new JMenuItem("Change passowrd" /**,new ImageIcon("1.gif")**/));
        item.setHorizontalTextPosition(JMenuItem.RIGHT);
        item.addActionListener(menuListener);
        m.add(item = new JMenuItem("Sign_Out" /**, new ImageIcon("2.gif")**/));
        item.setHorizontalTextPosition(JMenuItem.RIGHT);
        item.addActionListener(menuListener);
        b.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		m.show(b, b.getWidth()/2, b.getHeight()/2);
        	}
        });
        contentPane.setLayout(null);
        getContentPane().add(b);
		 b.setIcon(resizeIcon(new ImageIcon(getClass().getResource("/me.jpg")), b.getWidth(), b.getHeight()));

		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(850, 32, 121, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		frame.setVisible(false);
					Search.frame.setVisible(true);
	        	}
	        });
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(20, 5, 146, 69);
		 getContentPane().add(btnNewButton_3);
		 btnNewButton_3.setIcon(resizeIcon(new ImageIcon(getClass().getResource("/LogoMakr2.png")), btnNewButton_3.getWidth(), btnNewButton_3.getHeight()));

		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(5, 5, 1500, 72);
		scrollPane.setBackground(Color.PINK);
		contentPane.add(scrollPane);
		checkbox.setBounds(238, 83, 146, 23);
		checkbox.setBackground(new Color(255, 204, 204));
		contentPane.add(checkbox);
		
		JButton buttonR = new JButton("Refresh");
		buttonR.setBounds(400, 83, 90, 22);
		contentPane.add(buttonR);
		
		JButton buttonM = new JButton("Move To");
		buttonM.setBounds(500, 83, 90, 22);
		contentPane.add(buttonM);

		
		JButton buttonD = new JButton("Delete");
		buttonD.setBounds(600, 83, 90, 22);
		contentPane.add(buttonD);
		
		JButton btnNewButton_1 = new JButton("COMPOSE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
				Compose.frame.setVisible(true);
				}
		});
		btnNewButton_1.setBounds(20, 83, 155, 23);
		contentPane.add(btnNewButton_1);
		
		/**
		 * put number of pages.
		 
		int noMails = 30;
		int n;
		if ((noMails % 10) == 0) {
			n = noMails / 10;
		} else {
			n = noMails / 10 + 1;
		}
		*/
		JSpinner spinner = new JSpinner(new SpinnerNumberModel(1, 0, 3, 1));
		spinner.setBounds(1050, 83, 57, 20);
		contentPane.add(spinner);
		
		JButton btnNewButton_2 = new JButton("GO");
		btnNewButton_2.setBounds(1150, 83, 89, 23);
		contentPane.add(btnNewButton_2);
		/**
		 * action of button go to get number of page.
		 */
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer currentValue = (Integer)spinner.getValue();
				noPag = currentValue;
			}
		});
		
		ScrollPane scrollPane_1 = new ScrollPane();
		scrollPane_1.setBounds(5, 80, 1692, 34);
		scrollPane_1.setBackground(Color.PINK);
		contentPane.add(scrollPane_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(119, 117, 1400, 500);
		contentPane.add(panel);
		panel.setLayout(null);
	
		JPanel panelS = new JPanel();
		panelS.setBounds(119, 117, 1400, 500);
		contentPane.add(panelS);
		panelS.setLayout(null);
		panelS.setVisible(false);
		
		JPanel panelD = new JPanel();
		panelD.setBounds(119, 117, 1400, 500);
		contentPane.add(panelD);
		panelD.setLayout(null);
		panelD.setVisible(false);
		
		JPanel panelT = new JPanel();
		panelT.setBounds(119, 117, 1400, 500);
		contentPane.add(panelT);
		panelT.setLayout(null);
		panelT.setVisible(false);
		
		JPanel panelSt = new JPanel();
		panelSt.setBounds(119, 117, 1400, 500);
		contentPane.add(panelSt);
		panelSt.setLayout(null);
		panelSt.setVisible(false);
		
		JPanel panelE = new JPanel();
		panelE.setBounds(119, 117, 1400, 500);
		contentPane.add(panelE);
		panelE.setLayout(null);
		panelE.setVisible(false);
		
		JButton btnNewButton_4 = new JButton("Inbox");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				panelS.setVisible(false);
				panelD.setVisible(false);
				panelT.setVisible(false);
				panelSt.setVisible(false);
				panelE.setVisible(false);
				if (checkbox.isSelected()) {
				checkbox.setSelected(false);
				}
				JLabel lblSelecte = new JLabel("Selecte");
				lblSelecte.setOpaque(true);
				lblSelecte.setBackground(Color.PINK);
				lblSelecte.setBounds(119 - 119, 117 - 117, 46, 24);
				panel.add(lblSelecte);
				
				JLabel lblNewLabel = new JLabel("Stare");
				lblNewLabel.setOpaque(true);
				lblNewLabel.setBackground(Color.PINK);
				lblNewLabel.setBounds(175 - 119, 117 - 117, 46, 24);
				panel.add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel("From");
				lblNewLabel_1.setOpaque(true);
				lblNewLabel_1.setBackground(Color.PINK);
				lblNewLabel_1.setBounds(300 - 119, 117 - 117, 46, 24);
				panel.add(lblNewLabel_1);
				
				JLabel lblNewLabel_2 = new JLabel("Subject");
				lblNewLabel_2.setOpaque(true);
				lblNewLabel_2.setBackground(Color.PINK);
				lblNewLabel_2.setBounds(600 - 119, 117 - 117, 46, 24);
				panel.add(lblNewLabel_2);
				
				JLabel lblNewLabel_3 = new JLabel("Date");
				lblNewLabel_3.setOpaque(true);
				lblNewLabel_3.setBackground(Color.PINK);
				lblNewLabel_3.setBounds(1050 - 119, 117 - 117, 46, 24);
				panel.add(lblNewLabel_3);
				
				Folder x = new Folder();
				x.setFolder("Inbox");
				Sort y = new Sort();
				y.setCriteria("default");
				SignIn.account.setViewingOptions(x, null, y);
				Mail[] mails = (Mail[]) SignIn.account.listEmails(noPag);
				if (mails.length != 0) {
					int i, j; 
					for ( i = 0, j = 0; i < mails.length; i++, j = j + 30) {
						Mail current = (Mail) mails[i];
						
						JRadioButton select = new JRadioButton("", false);
						select.setBounds(125 - 119, 145 + j - 117, 20, 23);
						panel.add(select);
						
						JCheckBox stare = new JCheckBox(new CheckboxAction("", current, x));
						if (current.getStarred().equals("True")) {
							stare.setSelected(true);
						}
						stare.setBounds(180 - 119, 145 + j - 117, 20, 23);
						panel.add(stare);
												
						JButton btnNewButton_91 = new JButton(current.getSender());
						btnNewButton_91.setBounds(240 - 119, 145 + j - 117, 180, 23);
						panel.add(btnNewButton_91);
						JTextField textField1;
						JTextField textField_11;
						btnNewButton_91.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								panel.setVisible(false);
								panelS.setVisible(false);
								panelD.setVisible(false);
								panelT.setVisible(false);
								panelSt.setVisible(false);
								panelE.removeAll();
								panelE.setVisible(true);
								
								Action action = new Action();
								action.status(current.getName(), x);	
								
								JLabel lblNewLabel_4 = new JLabel("From");
								lblNewLabel_4.setBounds(30, 10, 50, 30);
								panelE.add(lblNewLabel_4);
								
								JLabel lblNewLabel_5 = new JLabel("Subject");
								lblNewLabel_5.setBounds(30, 50, 50, 30);
								panelE.add(lblNewLabel_5);
								
								JLabel lblNewLabel = new JLabel("email is");
								lblNewLabel.setBounds(30, 90, 50, 30);
								panelE.add(lblNewLabel);
								
								JTextField textField_4 = new JTextField();
								textField_4.setText(current.getSender());
								textField_4.setBounds(100, 10, 100, 30);
								panelE.add(textField_4);
								textField_4.setColumns(10);
								
								JTextField textField_5 = new JTextField();
								textField_5.setText(current.getSubject());
								textField_5.setBounds(100, 50, 100, 30);
								panelE.add(textField_5);
								textField_5.setColumns(10);
								
								
								JTextField textField_3 = new JTextField();
								String data = null;
								try {
									data = readFileAsString("C:\\Users\\lenovo\\git\\team3\\team3\\Server\\n1@mail.com\\Inbox\\09 05 2018 23 00 09\\Body.txt");
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								textField_3.setText(data);
								textField_3.setBounds(30, 130, 1200, 300);
								panelE.add(textField_3);
								textField_3.setColumns(10);
							}
						});
						
						textField1 = new JTextField(); 
						textField1.setText(current.getSubject());
						textField1.setBounds(500 - 119, 146 + j - 117, 300, 20);
						panel.add(textField1);
						textField1.setColumns(10);
						
						textField_11 = new JTextField();
						textField_11.setText(current.getDate());
						textField_11.setBounds(1000 - 119, 146 + j - 117, 150, 20);
						panel.add(textField_11);
						textField_11.setColumns(10);
						
						/**
						 * action of select all.
						 */
						 checkbox.addActionListener(new ActionListener() {
						     	public void actionPerformed(ActionEvent e) {
						     		if (!select.isSelected()){
						     			select.setSelected(true);
						     		} else {
						     			select.setSelected(false);
						     		}
						     	}
						     });
						 /**
						  * action of Refresh.
						  */
						 buttonR.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
					     			select.setSelected(false);
					     			checkbox.setSelected(false);
								}
							});
						 /**
						  * action of move.
						  */
						 JPopupMenu m2 = new JPopupMenu();
					        ActionListener menuListener1 = new ActionListener() {
					            public void actionPerformed(ActionEvent event) {
					            if (event.getActionCommand().equals("Trash")) {
					            	SLinkedList delet = null;
									if (select.isSelected()) {
										 delet = new SLinkedList();
										delet.add(current);
									}
									Folder x = new Folder();
									x.setFolder("Drafts");
									Sort y = new Sort();
									y.setCriteria("default");
									SignIn.account.setViewingOptions(x, null, y);
									SignIn.account.moveEmails(delet, x);
					            	frame.setVisible(false);
									SignIn.frame.setVisible(true);
					            } else if (event.getActionCommand().equals("Another")) {
					            	SLinkedList move = null;
									if (select.isSelected()) {
										 move = new SLinkedList();
										move.add(current);
									}
									Folder x = new Folder();
									x.setContact(SignIn.account.currentContact);
									x.createNewFolder("anther", null);
					            	System.out.println(x.createNewFolder("anther", null));
									SignIn.account.moveEmails(move, x);
					            	System.out.println("another");
					            }
					            }
					          };
					        JMenuItem item1;
					        m2.add(item1 = new JMenuItem("Trash"));
					        item1.setHorizontalTextPosition(JMenuItem.RIGHT);
					        item1.addActionListener(menuListener1);
					        m2.add(item1 = new JMenuItem("Another"));
					        item1.setHorizontalTextPosition(JMenuItem.RIGHT);
					        item1.addActionListener(menuListener1);
					        buttonM.addActionListener(new ActionListener() {
					        	public void actionPerformed(ActionEvent e) {
					        		m2.show(buttonM, buttonM.getWidth()/2, buttonM.getHeight()/2);
					        	}
					        });
					       
						
						 /**
						  * action of delete.
						  */
						 buttonD.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									SLinkedList delet = null;
									if (select.isSelected()) {
										 delet = new SLinkedList();
										delet.add(current);
									}
									SignIn.account.deleteEmails(delet);
								}
							});

					}
				} 
			}
		});
		btnNewButton_4.setBounds(20, 118, 89, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Sent mail");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelE.setVisible(false);
				panel.setVisible(false);
				panelS.setVisible(true);
				panelD.setVisible(false);
				panelT.setVisible(false);
				panelSt.setVisible(false);
				if (checkbox.isSelected()) {
					checkbox.setSelected(false);
					}
				
				JLabel lblSelecteS = new JLabel("Selecte");
				lblSelecteS.setOpaque(true);
				lblSelecteS.setBackground(Color.PINK);
				lblSelecteS.setBounds(119 - 119, 117 - 117, 46, 24);
				panelS.add(lblSelecteS);
				
				JLabel lblNewLabelS = new JLabel("Stare");
				lblNewLabelS.setOpaque(true);
				lblNewLabelS.setBackground(Color.PINK);
				lblNewLabelS.setBounds(175 - 119, 117 - 117, 46, 24);
				panelS.add(lblNewLabelS);
				
				JLabel lblNewLabel_1S = new JLabel("TO");
				lblNewLabel_1S.setOpaque(true);
				lblNewLabel_1S.setBackground(Color.PINK);
				lblNewLabel_1S.setBounds(300 - 119, 117 - 117, 46, 24);
				panelS.add(lblNewLabel_1S);
				
				JLabel lblNewLabel_2S = new JLabel("Subject");
				lblNewLabel_2S.setOpaque(true);
				lblNewLabel_2S.setBackground(Color.PINK);
				lblNewLabel_2S.setBounds(600 - 119, 117 - 117, 46, 24);
				panelS.add(lblNewLabel_2S);
				
				JLabel lblNewLabel_3S = new JLabel("Date");
				lblNewLabel_3S.setOpaque(true);
				lblNewLabel_3S.setBackground(Color.PINK);
				lblNewLabel_3S.setBounds(1050 - 119, 117 - 117, 46, 24);
				panelS.add(lblNewLabel_3S);
				
				Folder x = new Folder();
				x.setFolder("Sent");
				Sort y = new Sort();
				y.setCriteria("default");
				SignIn.account.setViewingOptions(x, null, y);
				Mail[] mails = (Mail[]) SignIn.account.listEmails(noPag);
				if (mails.length != 0) {
					int i, j; 
					for ( i = 0, j = 0; i < mails.length; i++, j = j + 30) {
						Mail current = (Mail) mails[i];
						LinkedBased receivers = current.getReceivers();
						int no = receivers.size();
						for (int c = 0; c < no; c++) {
							String s = (String) receivers.dequeue();
							JRadioButton select1S = new JRadioButton("", false);
							select1S.setBounds(125 - 119, 145 + j - 117, 20, 23);
							panelS.add(select1S);
							
							JCheckBox stare1S = new JCheckBox(new CheckboxAction("", current, x));
							if (current.getStarred().equals("True")) {
								stare1S.setSelected(true);
							}
							stare1S.setBounds(180 - 119, 145 + j - 117, 20, 23);
							panelS.add(stare1S);
							
							JButton btnNewButton_9S = new JButton(s);
							btnNewButton_9S.setBounds(240 - 119, 145 + j - 117, 180, 23);
							panelS.add(btnNewButton_9S);
							JTextField textFieldS;
							JTextField textField_S;
							btnNewButton_9S.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									panel.setVisible(false);
									panelS.setVisible(false);
									panelD.setVisible(false);
									panelT.setVisible(false);
									panelSt.setVisible(false);
									panelE.removeAll();
									panelE.setVisible(true);
									
									JLabel lblNewLabel_4S = new JLabel("TO");
									lblNewLabel_4S.setBounds(30, 10, 50, 30);
									panelE.add(lblNewLabel_4S);
									
									JLabel lblNewLabel_5 = new JLabel("Subject");
									lblNewLabel_5.setBounds(30, 50, 50, 30);
									panelE.add(lblNewLabel_5);
									
									JLabel lblNewLabel = new JLabel("email is");
									lblNewLabel.setBounds(30, 90, 50, 30);
									panelE.add(lblNewLabel);
									
									JTextField textField_4 = new JTextField();
									textField_4.setText(s);
									textField_4.setBounds(100, 10, 100, 30);
									panelE.add(textField_4);
									textField_4.setColumns(10);
									
									JTextField textField_5 = new JTextField();
									textField_5.setText(current.getSubject());
									textField_5.setBounds(100, 50, 100, 30);
									panelE.add(textField_5);
									textField_5.setColumns(10);
									
									
									JTextField textField_3 = new JTextField();
									String data = null;
									try {
										data = readFileAsString("C:\\Users\\lenovo\\git\\team3\\team3\\Server\\n1@mail.com\\Inbox\\09 05 2018 23 00 09\\Body.txt");
									} catch (Exception e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									textField_3.setText(data);
									textField_3.setBounds(30, 130, 1200, 300);
									panelE.add(textField_3);
									textField_3.setColumns(10);
								}
							});
							
							textFieldS = new JTextField();
							textFieldS.setText(current.getSubject());
							textFieldS.setBounds(500 - 119, 146 + j - 117, 300, 20);
							panelS.add(textFieldS);
							textFieldS.setColumns(10);
							
							textField_S = new JTextField();
							textField_S.setText(current.getDate());
							textField_S.setBounds(1000 - 119, 146 + j - 117, 150, 20);
							panelS.add(textField_S);
							textField_S.setColumns(10);
							
							/**
							 * action of select all.
							 */
							 checkbox.addActionListener(new ActionListener() {
							     	public void actionPerformed(ActionEvent e) {
							     		if (!select1S.isSelected()){
							     			select1S.setSelected(true);
							     		} else {
							     			select1S.setSelected(false);
							     		}
							     	}
							     });
							 /**
							  * for mark of stare.
							  */
							 if (!stare1S.isSelected()) {
								 
							 }
							 /**
							  * action of Refresh.
							  */
							 buttonR.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
						     			select1S.setSelected(false);
						     			checkbox.setSelected(false);
									}
								});
							 /**
							  * action of move.
							  */
							 buttonM.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										
									}
								});
							 /**
							  * action of delete.
							  */
							 buttonD.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										SLinkedList delet = null;
										if (select1S.isSelected()) {
											 delet = new SLinkedList();
											delet.add(current);
										}
										SignIn.account.deleteEmails(delet);
									}
								});
						}
					}
				} 
			}
		});
		btnNewButton_5.setBounds(20, 145, 89, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Drafts");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelE.setVisible(false);
				panel.setVisible(false);
				panelS.setVisible(false);
				panelD.setVisible(true);
				panelT.setVisible(false);
				panelSt.setVisible(false);
				if (checkbox.isSelected()) {
					checkbox.setSelected(false);
					}
				
				JLabel lblSelecteD = new JLabel("Selecte");
				lblSelecteD.setOpaque(true);
				lblSelecteD.setBackground(Color.PINK);
				lblSelecteD.setBounds(119 - 119, 117 - 117, 46, 24);
				panelD.add(lblSelecteD);
				
				JLabel lblNewLabelD = new JLabel("Stare");
				lblNewLabelD.setOpaque(true);
				lblNewLabelD.setBackground(Color.PINK);
				lblNewLabelD.setBounds(175 - 119, 117 - 117, 46, 24);
				panelD.add(lblNewLabelD);
				
				JLabel lblNewLabel_1D = new JLabel("From");
				lblNewLabel_1D.setOpaque(true);
				lblNewLabel_1D.setBackground(Color.PINK);
				lblNewLabel_1D.setBounds(300 - 119, 117 - 117, 46, 24);
				panelD.add(lblNewLabel_1D);
				
				JLabel lblNewLabel_2D = new JLabel("Subject");
				lblNewLabel_2D.setOpaque(true);
				lblNewLabel_2D.setBackground(Color.PINK);
				lblNewLabel_2D.setBounds(600 - 119, 117 - 117, 46, 24);
				panelD.add(lblNewLabel_2D);
				
				JLabel lblNewLabel_3D = new JLabel("Date");
				lblNewLabel_3D.setOpaque(true);
				lblNewLabel_3D.setBackground(Color.PINK);
				lblNewLabel_3D.setBounds(1050 - 119, 117 - 117, 46, 24);
				panelD.add(lblNewLabel_3D);
				
				Folder x = new Folder();
				x.setFolder("Drafts");
				Sort y = new Sort();
				y.setCriteria("default");
				SignIn.account.setViewingOptions(x, null, y);
				Mail[] mails = (Mail[]) SignIn.account.listEmails(noPag);
				if (mails.length != 0) {
					int i, j; 
					for ( i = 0, j = 0; i < mails.length; i++, j = j + 30) {
						Mail current = (Mail) mails[i];
						
						JRadioButton selectD = new JRadioButton("", false);
						selectD.setBounds(125 - 119, 145 + j - 117, 20, 23);
						panelD.add(selectD);
						
						JCheckBox stareD = new JCheckBox(new CheckboxAction("", current, x));
						if (current.getStarred().equals("True")) {
							stareD.setSelected(true);
						}
						stareD.setBounds(180 - 119, 145 + j - 117, 20, 23);
						panelD.add(stareD);
												
						JButton btnNewButtonD = new JButton(current.getSender());
						btnNewButtonD.setBounds(240 - 119, 145 + j - 117, 180, 23);
						panel.add(btnNewButtonD);
						JTextField textFieldD;
						JTextField textField_D;
						btnNewButtonD.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								panel.setVisible(false);
								panelS.setVisible(false);
								panelD.setVisible(false);
								panelT.setVisible(false);
								panelSt.setVisible(false);
								panelE.removeAll();
								panelE.setVisible(true);
								
								JLabel lblNewLabel_4 = new JLabel("From");
								lblNewLabel_4.setBounds(30, 10, 50, 30);
								panelE.add(lblNewLabel_4);
								
								JLabel lblNewLabel_5 = new JLabel("Subject");
								lblNewLabel_5.setBounds(30, 50, 50, 30);
								panelE.add(lblNewLabel_5);
								
								JLabel lblNewLabel = new JLabel("email is");
								lblNewLabel.setBounds(30, 90, 50, 30);
								panelE.add(lblNewLabel);
								
								JTextField textField_4 = new JTextField();
								textField_4.setText(current.getSender());
								textField_4.setBounds(100, 10, 100, 30);
								panelE.add(textField_4);
								textField_4.setColumns(10);
								
								JTextField textField_5 = new JTextField();
								textField_5.setText(current.getSubject());
								textField_5.setBounds(100, 50, 100, 30);
								panelE.add(textField_5);
								textField_5.setColumns(10);
								
								
								JTextField textField_3 = new JTextField();
								String data = null;
								try {
									data = readFileAsString("C:\\Users\\lenovo\\git\\team3\\team3\\Server\\n1@mail.com\\Inbox\\09 05 2018 23 00 09\\Body.txt");
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								textField_3.setText(data);
								textField_3.setBounds(30, 130, 1200, 300);
								panelE.add(textField_3);
								textField_3.setColumns(10);
							}
						});
						
						textFieldD = new JTextField();
						textFieldD.setText(current.getSubject());
						textFieldD.setBounds(500 - 119, 146 + j - 117, 300, 20);
						panelD.add(textFieldD);
						textFieldD.setColumns(10);
						
						textField_D = new JTextField();
						textField_D.setText(current.getDate());
						textField_D.setBounds(1000 - 119, 146 + j - 117, 150, 20);
						panelD.add(textField_D);
						textField_D.setColumns(10);
						
						/**
						 * action of select all.
						 */
						 checkbox.addActionListener(new ActionListener() {
						     	public void actionPerformed(ActionEvent e) {
						     		if (!selectD.isSelected()){
						     			selectD.setSelected(true);
						     		} else {
						     			selectD.setSelected(false);
						     		}
						     	}
						     });
						 /**
						  * for mark of stare.
						  */
						 if (!stareD.isSelected()) {
							 
						 }
						 /**
						  * action of Refresh.
						  */
						 buttonR.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
					     			selectD.setSelected(false);
					     			checkbox.setSelected(false);
								}
							});
						 /**
						  * action of move.
						  */
						 buttonM.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									
								}
							});
						 /**
						  * action of delete.
						  */
						 buttonD.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									SLinkedList delet = null;
									if (selectD.isSelected()) {
										 delet = new SLinkedList();
										delet.add(current);
									}
									SignIn.account.deleteEmails(delet);
								}
							});

					}
				} 
			}
		});
		btnNewButton_6.setBounds(20, 172, 89, 23);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Trash");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelE.setVisible(false);
				panel.setVisible(false);
				panelS.setVisible(false);
				panelD.setVisible(false);
				panelT.setVisible(true);
				panelSt.setVisible(false);
				if (checkbox.isSelected()) {
					checkbox.setSelected(false);
					}
				
				JLabel lblSelecteT = new JLabel("Selecte");
				lblSelecteT.setOpaque(true);
				lblSelecteT.setBackground(Color.PINK);
				lblSelecteT.setBounds(119 - 119, 117 - 117, 46, 24);
				panelT.add(lblSelecteT);
				
				JLabel lblNewLabel_T = new JLabel("From");
				lblNewLabel_T.setOpaque(true);
				lblNewLabel_T.setBackground(Color.PINK);
				lblNewLabel_T.setBounds(300 - 119, 117 - 117, 46, 24);
				panelT.add(lblNewLabel_T);
				
				JLabel lblNewLabel_2T = new JLabel("Subject");
				lblNewLabel_2T.setOpaque(true);
				lblNewLabel_2T.setBackground(Color.PINK);
				lblNewLabel_2T.setBounds(600 - 119, 117 - 117, 46, 24);
				panelT.add(lblNewLabel_2T);
				
				JLabel lblNewLabel_3T = new JLabel("Date");
				lblNewLabel_3T.setOpaque(true);
				lblNewLabel_3T.setBackground(Color.PINK);
				lblNewLabel_3T.setBounds(1050 - 119, 117 - 117, 46, 24);
				panelT.add(lblNewLabel_3T);
				
				Folder x = new Folder();
				x.setFolder("Trash");
				Sort y = new Sort();
				y.setCriteria("default");
				SignIn.account.setViewingOptions(x, null, y);
				Mail[] mails = (Mail[]) SignIn.account.listEmails(noPag);
				if (mails.length != 0) {
					int i, j; 
					for ( i = 0, j = 0; i < mails.length; i++, j = j + 30) {
						Mail current = (Mail) mails[i];
						
						JRadioButton selectT = new JRadioButton("", false);
						selectT.setBounds(125 - 119, 145 + j - 117, 20, 23);
						panelT.add(selectT);
												
						JButton btnNewButton_91T = new JButton(current.getSender());
						btnNewButton_91T.setBounds(240 - 119, 145 + j - 117, 180, 23);
						panelT.add(btnNewButton_91T);
						JTextField textField1T;
						JTextField textField_11T;
						btnNewButton_91T.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								panel.setVisible(false);
								panelS.setVisible(false);
								panelD.setVisible(false);
								panelT.setVisible(false);
								panelSt.setVisible(false);
								panelE.removeAll();
								panelE.setVisible(true);
								
								JLabel lblNewLabel_4 = new JLabel("From");
								lblNewLabel_4.setBounds(30, 10, 50, 30);
								panelE.add(lblNewLabel_4);
								
								JLabel lblNewLabel_5 = new JLabel("Subject");
								lblNewLabel_5.setBounds(30, 50, 50, 30);
								panelE.add(lblNewLabel_5);
								
								JLabel lblNewLabel = new JLabel("email is");
								lblNewLabel.setBounds(30, 90, 50, 30);
								panelE.add(lblNewLabel);
								
								JTextField textField_4 = new JTextField();
								textField_4.setText(current.getSender());
								textField_4.setBounds(100, 10, 100, 30);
								panelE.add(textField_4);
								textField_4.setColumns(10);
								
								JTextField textField_5 = new JTextField();
								textField_5.setText(current.getSubject());
								textField_5.setBounds(100, 50, 100, 30);
								panelE.add(textField_5);
								textField_5.setColumns(10);
								
								
								JTextField textField_3 = new JTextField();
								String data = null;
								try {
									data = readFileAsString("C:\\Users\\lenovo\\git\\team3\\team3\\Server\\n1@mail.com\\Inbox\\09 05 2018 23 00 09\\Body.txt");
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								textField_3.setText(data);
								textField_3.setBounds(30, 130, 1200, 300);
								panelE.add(textField_3);
								textField_3.setColumns(10);
							}
						});
						
						textField1T = new JTextField();
						textField1T.setText(current.getSubject());
						textField1T.setBounds(500 - 119, 146 + j - 117, 300, 20);
						panelT.add(textField1T);
						textField1T.setColumns(10);
						
						textField_11T = new JTextField();
						textField_11T.setText(current.getDate());
						textField_11T.setBounds(1000 - 119, 146 + j - 117, 150, 20);
						panelT.add(textField_11T);
						textField_11T.setColumns(10);
						
						/**
						 * action of select all.
						 */
						 checkbox.addActionListener(new ActionListener() {
						     	public void actionPerformed(ActionEvent e) {
						     		if (!selectT.isSelected()){
						     			selectT.setSelected(true);
						     		} else {
						     			selectT.setSelected(false);
						     		}
						     	}
						     });
						 /**
						  * action of Refresh.
						  */
						 buttonR.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
					     			selectT.setSelected(false);
					     			checkbox.setSelected(false);
								}
							});
						 /**
						  * action of move.
						  */
						 buttonM.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									
								}
							});
						 /**
						  * action of delete.
						  */
						 buttonD.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									SLinkedList delet = null;
									if (selectT.isSelected()) {
										 delet = new SLinkedList();
										delet.add(current);
									}
									SignIn.account.deleteEmails(delet);
								}
							});

					}
				} 
			}
		});
		btnNewButton_7.setBounds(20, 200, 89, 23);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Starred");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelE.setVisible(false);
				panel.setVisible(false);
				panelS.setVisible(false);
				panelD.setVisible(false);
				panelT.setVisible(false);
				panelE.removeAll();
				panelSt.setVisible(true);
				if (checkbox.isSelected()) {
					checkbox.setSelected(false);
					}
				
				JLabel lblSelecteST = new JLabel("Selecte");
				lblSelecteST.setOpaque(true);
				lblSelecteST.setBackground(Color.PINK);
				lblSelecteST.setBounds(119 - 119, 117 - 117, 46, 24);
				panelSt.add(lblSelecteST);
				
				JLabel lblNewLabelST = new JLabel("Stare");
				lblNewLabelST.setOpaque(true);
				lblNewLabelST.setBackground(Color.PINK);
				lblNewLabelST.setBounds(175 - 119, 117 - 117, 46, 24);
				panelSt.add(lblNewLabelST);
				
				JLabel lblNewLabel_1ST = new JLabel("From");
				lblNewLabel_1ST.setOpaque(true);
				lblNewLabel_1ST.setBackground(Color.PINK);
				lblNewLabel_1ST.setBounds(300 - 119, 117 - 117, 46, 24);
				panelSt.add(lblNewLabel_1ST);
				
				JLabel lblNewLabel_2ST = new JLabel("Subject");
				lblNewLabel_2ST.setOpaque(true);
				lblNewLabel_2ST.setBackground(Color.PINK);
				lblNewLabel_2ST.setBounds(600 - 119, 117 - 117, 46, 24);
				panelSt.add(lblNewLabel_2ST);
				
				JLabel lblNewLabel_3ST = new JLabel("Date");
				lblNewLabel_3ST.setOpaque(true);
				lblNewLabel_3ST.setBackground(Color.PINK);
				lblNewLabel_3ST.setBounds(1050 - 119, 117 - 117, 46, 24);
				panelSt.add(lblNewLabel_3ST);
				
				Folder x = new Folder();
				x.setFolder("Starred");
				Sort y = new Sort();
				y.setCriteria("default");
				SignIn.account.setViewingOptions(x, null, y);
				Mail[] mails = (Mail[]) SignIn.account.listEmails(noPag);
				if (mails.length != 0) {
					int i, j; 
					for ( i = 0, j = 0; i < mails.length; i++, j = j + 30) {
						Mail current = (Mail) mails[i];
						
						JRadioButton selectST = new JRadioButton("", false);
						selectST.setBounds(125 - 119, 145 + j - 117, 20, 23);
						panelSt.add(selectST);
						
						JCheckBox stareST = new JCheckBox(new CheckboxAction("", current, x));
						stareST.setSelected(true);
						stareST.setBounds(180 - 119, 145 + j - 117, 20, 23);
						panelSt.add(stareST);
												
						JButton btnNewButton_91ST = new JButton(current.getSender());
						btnNewButton_91ST.setBounds(240 - 119, 145 + j - 117, 180, 23);
						panelSt.add(btnNewButton_91ST);
						JTextField textField1ST;
						JTextField textField_11ST;
						btnNewButton_91ST.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								panel.setVisible(false);
								panelS.setVisible(false);
								panelD.setVisible(false);
								panelT.setVisible(false);
								panelSt.setVisible(false);
								panelE.removeAll();
								panelE.setVisible(true);
								
								JLabel lblNewLabel_4 = new JLabel("From");
								lblNewLabel_4.setBounds(30, 10, 50, 30);
								panelE.add(lblNewLabel_4);
								
								JLabel lblNewLabel_5 = new JLabel("Subject");
								lblNewLabel_5.setBounds(30, 50, 50, 30);
								panelE.add(lblNewLabel_5);
								
								JLabel lblNewLabel = new JLabel("email is");
								lblNewLabel.setBounds(30, 90, 50, 30);
								panelE.add(lblNewLabel);
								
								JTextField textField_4 = new JTextField();
								textField_4.setText(current.getSender());
								textField_4.setBounds(100, 10, 100, 30);
								panelE.add(textField_4);
								textField_4.setColumns(10);
								
								JTextField textField_5 = new JTextField();
								textField_5.setText(current.getSubject());
								textField_5.setBounds(100, 50, 100, 30);
								panelE.add(textField_5);
								textField_5.setColumns(10);
								
								
								JTextField textField_3 = new JTextField();
								String data = null;
								try {
									data = readFileAsString("C:\\Users\\lenovo\\git\\team3\\team3\\Server\\n1@mail.com\\Inbox\\09 05 2018 23 00 09\\Body.txt");
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								textField_3.setText(data);
								textField_3.setBounds(30, 130, 1200, 300);
								panelE.add(textField_3);
								textField_3.setColumns(10);
							}
						});
						
						textField1ST = new JTextField();
						textField1ST.setText(current.getSubject());
						textField1ST.setBounds(500 - 119, 146 + j - 117, 300, 20);
						panelSt.add(textField1ST);
						textField1ST.setColumns(10);
						
						textField_11ST = new JTextField();
						textField_11ST.setText(current.getDate());
						textField_11ST.setBounds(1000 - 119, 146 + j - 117, 150, 20);
						panel.add(textField_11ST);
						textField_11ST.setColumns(10);
						
						/**
						 * action of select all.
						 */
						 checkbox.addActionListener(new ActionListener() {
						     	public void actionPerformed(ActionEvent e) {
						     		if (!selectST.isSelected()){
						     			selectST.setSelected(true);
						     		} else {
						     			selectST.setSelected(false);
						     		}
						     	}
						     });
						 /**
						  * for mark of stare.
						  */
						 if (!stareST.isSelected()) {
							 
						 }
						 /**
						  * action of Refresh.
						  */
						 buttonR.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
					     			selectST.setSelected(false);
					     			checkbox.setSelected(false);
								}
							});
						 /**
						  * action of move.
						  */
						 buttonM.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									if (selectST.isSelected()) {
										
									}
								}
							});
						 /**
						  * action of delete.
						  */
						 buttonD.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									SLinkedList delet = null;
									if (selectST.isSelected()) {
										 delet = new SLinkedList();
										delet.add(current);
									}
									SignIn.account.deleteEmails(delet);
								}
							});

					}
				} 
			}
		});
		btnNewButton_8.setBounds(20, 228, 89, 23);
		contentPane.add(btnNewButton_8);
	}
	class CheckboxAction extends AbstractAction {
	    Mail current;
	    Folder x;
	    public CheckboxAction(String text, Mail curr, Folder f) {
	        super(text);
	        current = curr;
	        x = f;
	    }
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        JCheckBox cbLog = (JCheckBox) e.getSource();
	        if (cbLog.isSelected()) {
				 System.out.println("ok");
				 Action action = new Action();
				action.star(current.getName(), x);
				 System.out.println(current.getStarred());
			 } else {
				 System.out.println("No");
				 Action action = new Action();
				 action.unstar(current.getName());
				 System.out.println(current.getStarred());
			 }
	    }
	}
	
	public static String readFileAsString(String fileName)throws Exception
	  {
	    String data = "";
	    data = new String(Files.readAllBytes(Paths.get(fileName)));
	    return data;
	  }
	
	private Icon resizeIcon(Icon icon, int width, int height) {
		// TODO Auto-generated method stub
		Image img = ((ImageIcon) icon).getImage();  
	    Image resizedImage = img.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH);  
	    return new ImageIcon(resizedImage);
	}
}
