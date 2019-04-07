package eg.edu.alexu.csd.datastructure.mailServer.cs12_cs57_cs62;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
 
/**
 * Demo of file extension filter. Applied since Java 1.6
 * @author www.codejava.net
 *
 */
@SuppressWarnings("serial")
public class FileExtensionFilterDemo extends JFrame {
    private JButton buttonBrowse;
 
    public FileExtensionFilterDemo() {
        super("Demo File Type Filter");
        setLayout(new FlowLayout());
        buttonBrowse = new JButton("Browse...");
        buttonBrowse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                showOpenFileDialog();
            }
        });
        getContentPane().add(buttonBrowse);
        setSize(300, 100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
 
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) { }
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FileExtensionFilterDemo();
            }
        });
    }
 
    private void showOpenFileDialog() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("PDF Documents", "pdf"));
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("MS Office Documents", "docx", "xlsx", "pptx"));
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
        fileChooser.setAcceptAllFileFilterUsed(true);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            File server = new File("C:\\Users\\lenovo\\git\\team3\\team3\\Server",selectedFile.getAbsolutePath());
    		server.mkdir();
    		 File f = new File(selectedFile.getAbsolutePath());
    		    Desktop dt = Desktop.getDesktop();
    		    try {
					dt.open(f);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		    System.out.println("Done.");
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());

        }
    }
}
