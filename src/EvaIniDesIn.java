import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class EvaIniDesIn {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EvaIniDesIn window = new EvaIniDesIn();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EvaIniDesIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(100, 97, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(156, 94, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(87, 134, 59, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(156, 131, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// conectar con BD
				CreaConexion();  
				// comprobar usuario y contraseña
			}
		});
		btnNewButton.setBounds(153, 182, 89, 23); 
		frame.getContentPane().add(btnNewButton);
	}
	/**
	 * esto seria para modularizar, crea una conexión con Mysql y comprueba usuario y contraseña
	 */
	public void CreaConexion() {
		try
		{
		   Class.forName("com.mysql.jdbc.Driver");
		// Establecemos la conexión con la base de datos.
		   Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost/Usuarios","roque", "1234");
		// Preparamos la consulta
		   java.sql.Statement s = conexion.createStatement();
		   ResultSet rs = s.executeQuery ("select nombre, login from Usuarios where nombre="+textField_1.getText());
		   
		} catch (Exception e)
		{
		   e.printStackTrace();
		}
		
	}
	
}
