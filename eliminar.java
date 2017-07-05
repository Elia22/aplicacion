package Integradora;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class eliminar extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JTextField tf_email;
	private JTextField tf_nombre;
	private Icon ic;
	private JLabel lbl_imagen;
	private JButton btn_eliminar, btn_cancelar, btn_buscar;
	private JComboBox cb_favorito;
	private usuario usuario;
	private CategoriasDAO categorias_dao=new CategoriasDAO();
	private usuarioDAO usuarios_dao=new usuarioDAO();
	
public eliminar() {
	setExtendedState(Frame.MAXIMIZED_BOTH);
	setTitle("Eliminar Usuario");
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(79, 148, 205));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	Image im = Toolkit.getDefaultToolkit().getImage("icono.png");
	 setIconImage(im);
	 Icon ic= new ImageIcon("sinovation logo.png"); 
	 
	 usuario=new usuario();
	
	JLabel lbl_banner = new JLabel();
	lbl_banner.setBounds(460, 22, 900, 150);
	lbl_banner.setIcon(ic);
	contentPane.add(lbl_banner);
	
	lbl_imagen = new JLabel();
	lbl_imagen.setBounds(43, 174, 300, 300);
	contentPane.add(lbl_imagen);
	
	btn_buscar=new JButton("Buscar");
	btn_buscar.setFont(new Font("Tahoma", Font.PLAIN, 16));
	btn_buscar.setBounds(430, 516, 118, 23);
	btn_buscar.addActionListener(this);
	contentPane.add(btn_buscar);
	
	btn_eliminar = new JButton("Eliminar");
	btn_eliminar.setFont(new Font("Tahoma", Font.PLAIN, 16));
	btn_eliminar.setBounds(560, 516, 118, 23);
	btn_eliminar.addActionListener(this);
	btn_eliminar.setEnabled(false);
	contentPane.add(btn_eliminar);
	
	btn_cancelar = new JButton("Cancelar");
	btn_cancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
	btn_cancelar.setBounds(690, 516, 118, 23);
	btn_cancelar.addActionListener(this);
	contentPane.add(btn_cancelar);
	
	JLabel lbl_ventana = new JLabel("Eliminar usuario");
	lbl_ventana.setForeground(new Color(255, 255, 255));
	lbl_ventana.setFont(new Font("Tahoma", Font.PLAIN, 50));
	lbl_ventana.setBounds(907, 473, 396, 80);
	contentPane.add(lbl_ventana);
	
	JPanel panel = new JPanel();
	panel.setBounds(430, 219, 531, 255);
	contentPane.add(panel);
	panel.setLayout(null);
	
	JLabel label = new JLabel("email:");
	label.setBounds(36, 84, 44, 20);
	label.setFont(new Font("Tahoma", Font.PLAIN, 16));
	panel.add(label);
	
	tf_email = new JTextField();
	tf_email.setBounds(121, 84, 268, 26);
	tf_email.setFont(new Font("Tahoma", Font.PLAIN, 16));
	tf_email.setColumns(10);
	panel.add(tf_email);
	
	tf_nombre = new JTextField();
	tf_nombre.setBounds(121, 124, 375, 26);
	tf_nombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
	tf_nombre.setColumns(10);
	tf_nombre.setEnabled(false);
	panel.add(tf_nombre);
	
	JLabel label_1 = new JLabel("Nombre:");
	label_1.setBounds(36, 124, 63, 20);
	label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
	panel.add(label_1);
	
		
	
}

	

	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn_buscar) {
			boolean bandera=true;
			
			Pattern p;
			Matcher m;
			boolean b=true;
			p = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
			m = p.matcher(tf_email.getText());
			b = m.matches();
			
			if(b==false) {
				JOptionPane.showMessageDialog(null, "email incorrecto", "Se ha encontrado un error", JOptionPane.ERROR_MESSAGE);
				bandera=false;
			}else {
				usuario=usuarios_dao.traer_usuario(tf_email.getText());
				if(usuario.getId_usuario()!=0) {
					btn_buscar.setEnabled(false);
					btn_eliminar.setEnabled(true);
					tf_nombre.setText(usuario.getNombre());
					ic = new ImageIcon(usuario.getImagen().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
			    	lbl_imagen.setIcon(ic);
			    	tf_email.setEnabled(false);
				}else {
					JOptionPane.showMessageDialog(null, "El usuario no existe en la BD", "Se ha encontrado un error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
		if(e.getSource()==btn_cancelar) {
			tf_email.setText("");
			tf_nombre.setText("");
			lbl_imagen.setIcon(null);
			tf_email.setEnabled(true);
			btn_buscar.setEnabled(true);
			btn_eliminar.setEnabled(false);
			usuario=new usuario();
		}
		if(e.getSource()==btn_eliminar) {
			if(usuarios_dao.eliminar(usuario)) {
				JOptionPane.showMessageDialog(null, "Usuario ha sido eliminado", "Acción correcta", JOptionPane.ERROR_MESSAGE);
				tf_email.setText("");
				tf_nombre.setText("");
				lbl_imagen.setIcon(null);
				tf_email.setEnabled(true);
				btn_buscar.setEnabled(true);
				btn_eliminar.setEnabled(false);
				usuario=new usuario();
			}else {
				JOptionPane.showMessageDialog(null, "no se elimino el usuario", "Se ha encontrado un error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}

}