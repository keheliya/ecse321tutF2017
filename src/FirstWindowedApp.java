import java.awt.EventQueue;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.IDN;


public class FirstWindowedApp extends JFrame {
	private static final long serialVersionUID = -4426310869335015542L;

	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new FirstWindowedApp().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FirstWindowedApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textField = new JTextField();
		textField.setColumns(10);
		
		final JEditorPane editorPane = new JEditorPane();
		
		final JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ac) {
				try {
			          String url = textField.getText().toLowerCase();
			          if (url.startsWith("http://"))
			            url = url.substring(7);
			          editorPane.setPage("http://" + IDN.toASCII(url));
			        } catch (Exception e) {
			          e.printStackTrace();
			          JOptionPane.showMessageDialog( btnGo, "Browser problem: " + e.getMessage());
			        }
			}
		});
		getContentPane().add(textField, BorderLayout.NORTH);
	    getContentPane().add(btnGo, BorderLayout.EAST);
		add(new JScrollPane(editorPane));

		
	}
	


}
