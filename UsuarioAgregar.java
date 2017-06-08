package unidad1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UsuarioAgregar extends JFrame implements ActionListener {
	
	//todos los objetos o metodos a utilizar
	private JPanel contentpane;
	private JTextField tf_email;
	private JTextField tf_nombre;
	private JPasswordField pf_pass;
	private JComboBox cb_favorito;
	private JLabel lbl_imagen;
	private JButton btn_imagen;
	private JButton btn_agregar;
	private JButton lbl_cancelar;
	
public UsuarioAgregar()
{
	setExtendedState(Frame.MAXIMIZED_BOTH);
	setTitle("Agregar usuario");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	
	contentpane=new JPanel();
	contentpane.setBackground(new Color(255,175,175));
	contentpane.setBorder(new EmptyBorder(5,5,5,5));
	setContentPane(contentpane);
	contentpane.setLayout(null);
	
	//en esta parte vamos a subir una imagen como de encabezado
	Image im=Toolkit.getDefaultToolkit().getImage("icono.png");
	setIconImage(im);
	Icon ic=new ImageIcon("Banner.png");

	//muestra la imagen del encabezado
	JLabel lbl_Banner=new JLabel();
	lbl_Banner.setBounds(361, 22, 600, 150);
	lbl_Banner.setIcon(ic);
	contentpane.add(lbl_Banner);
	
	//seria la seccion de fondo o ventana
	lbl_imagen=new JLabel("New Label");
	lbl_imagen.setBounds(43, 174, 300, 300);
	contentpane.add(lbl_imagen);
	
	//te permite seleccionar una imagen 
	btn_imagen=new JButton("seleccionar la imagen");
	btn_imagen.setFont(new Font("tahoma", Font.PLAIN,16));
	btn_imagen.setBounds(132, 516, 200, 23);
	contentpane.add(btn_imagen);
	
	//es un boton que permite cerrar la ejecucion
	lbl_cancelar=new JButton("cancelar");
	lbl_cancelar.setFont(new Font ("Tahoma", Font.PLAIN,16));
	lbl_cancelar.setBounds(633, 516, 118, 23);
	contentpane.add(lbl_cancelar);
	
	//te permite agregar un nuevo usuario
	JLabel lbl_ventana=new JLabel("Agregar usuario");
	lbl_ventana.setForeground(new Color(85, 107, 47));
	lbl_ventana.setFont(new Font("Tahoma", Font.PLAIN,50));
	lbl_ventana.setBounds(907, 473, 396, 80);
	contentpane.add(lbl_ventana);
	
	//
	JPanel panel=new JPanel();
	panel.setBounds(430, 219, 531, 255);
	contentpane.add(panel);
	panel.setLayout(null);
	
	//te permite agregar un correo electronico
	JLabel label=new JLabel("Email");
	label.setBounds(36, 36, 44, 20);
	label.setFont(new Font("Tahoma", Font.PLAIN, 16));
	panel.add(label);
	
	//
	tf_email=new JTextField();
	tf_email.setBounds(121, 33, 268, 26);
	tf_email.setFont(new Font("Tahoma", Font.PLAIN,16));
	tf_email.setColumns(10);
	panel.add(tf_email);
	
	//
	tf_nombre=new JTextField();
	tf_nombre.setBounds(121, 83, 375, 26);
	tf_nombre.setFont(new Font("tahoma", Font.PLAIN,16));
	tf_nombre.setColumns(10);
	panel.add(tf_nombre);
	
	//dirve para ingresar la contraseña
	JLabel label_2=new JLabel("Password");
	label_2.setBounds(36, 136, 73, 20);
	label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
	panel.add(label_2);
	
	//para que muestre la opcion de ingresar contraseña
	pf_pass=new JPasswordField();
	pf_pass.setBounds(121, 133, 218, 26);
	pf_pass.setFont(new Font("Tahoma",Font.PLAIN,16));
	panel.add(pf_pass);
	
	//nos es posible visualizar una opcion de ingresar el nombre de un usuario
	JLabel label_1=new JLabel("Nombre");
	label_1.setBounds(36, 86, 63, 20);
	label_1.setFont(new Font("Tahoma", Font.PLAIN,16));
	panel.add(label_1);
	
	//por medio de una caja desplegable o boton desplegable podemos seleccionar algo
	JLabel label_3=new JLabel("Favorito");
	label_3.setBounds(36, 184, 63, 20);
	label_3.setFont(new Font("Tahoma", Font.PLAIN,16));
	panel.add(label_3);
	
	//muestra la opcion de favoritos
	cb_favorito=new JComboBox();
	cb_favorito.setBounds(121, 181, 218, 26);
	cb_favorito.setFont(new Font("Tahoma", Font.PLAIN,16));
	panel.add(cb_favorito);
	
	//hace que la ventana se mire
	setVisible(true);
	
}
	
	//te muestra todo lo ya ingresado
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				UsuarioAgregar ventana=new UsuarioAgregar();
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
	}

}

