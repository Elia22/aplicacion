package Integradora;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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

public class agregar extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JTextField tf_email;
	private JTextField tf_nombre;
	private JPasswordField pf_pass;
	private JFileChooser fc_archivo;
	private JButton btn_imagen;
	private Icon ic;
	private JLabel lbl_imagen;
	private JButton btn_agregar, btn_cancelar;
	private JComboBox cb_favorito;
	private usuario usuario;
	private CategoriasDAO categorias_dao=new CategoriasDAO();
	private usuarioDAO usuarios_dao=new usuarioDAO();

public agregar() {
	setExtendedState(Frame.MAXIMIZED_BOTH);
	setTitle("Agregar usurio");
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
	 
	 fc_archivo=new JFileChooser();
	 FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
	 fc_archivo.setFileFilter(filter);
	 
	 usuario=new usuario();
	
	JLabel lbl_banner = new JLabel();
	lbl_banner.setBounds(460, 22, 900, 150);
	lbl_banner.setIcon(ic);
	contentPane.add(lbl_banner);
	
	lbl_imagen = new JLabel();
	lbl_imagen.setBounds(43, 174, 300, 300);
	contentPane.add(lbl_imagen);
	
	btn_imagen = new JButton("Seleccionar Imagen");
	btn_imagen.setFont(new Font("Tahoma", Font.PLAIN, 16));
	btn_imagen.setBounds(132, 516, 200, 23);
	btn_imagen.addActionListener(this);
	contentPane.add(btn_imagen);
	
	btn_agregar = new JButton("Agregar");
	btn_agregar.setFont(new Font("Tahoma", Font.PLAIN, 16));
	btn_agregar.setBounds(505, 516, 118, 23);
	btn_agregar.addActionListener(this);
	contentPane.add(btn_agregar);
	
	btn_cancelar = new JButton("Cancelar");
	btn_cancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
	btn_cancelar.setBounds(633, 516, 118, 23);
	btn_cancelar.addActionListener(this);
	contentPane.add(btn_cancelar);
	
	JLabel lbl_ventana = new JLabel("Agregar Usuario");
	lbl_ventana.setForeground(new Color(255, 255, 255));
	lbl_ventana.setFont(new Font("Tahoma", Font.PLAIN, 50));
	lbl_ventana.setBounds(907, 473, 396, 80);
	contentPane.add(lbl_ventana);
	
	JPanel panel = new JPanel();
	panel.setBounds(430, 219, 531, 255);
	contentPane.add(panel);
	panel.setLayout(null);
	
	JLabel label = new JLabel("email:");
	label.setBounds(36, 36, 44, 20);
	label.setFont(new Font("Tahoma", Font.PLAIN, 16));
	panel.add(label);
	
	tf_email = new JTextField();
	tf_email.setBounds(121, 33, 268, 26);
	tf_email.setFont(new Font("Tahoma", Font.PLAIN, 16));
	tf_email.setColumns(10);
	panel.add(tf_email);
	
	tf_nombre = new JTextField();
	tf_nombre.setBounds(121, 83, 375, 26);
	tf_nombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
	tf_nombre.setColumns(10);
	panel.add(tf_nombre);
	
	JLabel label_2 = new JLabel("Password:");
	label_2.setBounds(36, 136, 73, 20);
	label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
	panel.add(label_2);
	
	pf_pass = new JPasswordField();
	pf_pass.setBounds(121, 133, 218, 26);
	pf_pass.setFont(new Font("Tahoma", Font.PLAIN, 16));
	panel.add(pf_pass);
	
	JLabel label_1 = new JLabel("Nombre:");
	label_1.setBounds(36, 86, 63, 20);
	label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
	panel.add(label_1);
	
	JLabel label_3 = new JLabel("Favorito:");
	label_3.setBounds(36, 184, 63, 20);
	label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
	panel.add(label_3);
	
	cb_favorito = new JComboBox(categorias_dao.traer());
	cb_favorito.setBounds(121, 181, 218, 26);
	cb_favorito.setFont(new Font("Tahoma", Font.PLAIN, 16));
	panel.add(cb_favorito);
	
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn_imagen) {
			int returnVal = fc_archivo.showOpenDialog(this);
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		    	ImageIcon imagen=new ImageIcon(fc_archivo.getSelectedFile().getAbsolutePath());
				ic = new ImageIcon(imagen.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
		    	//ic=new ImageIcon(fc_archivo.getSelectedFile().getAbsolutePath());
		    	lbl_imagen.setIcon(ic);
		    }
		}
		if(e.getSource()==btn_agregar) {
			
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
			}
			
			p = Pattern.compile("^[a-zA-Z][a-zA-Z0-9\\s]+$");
			m = p.matcher(tf_nombre.getText());
			b = m.matches();
			
			if(bandera) {
				if(b==false) {
					JOptionPane.showMessageDialog(null, "nombre incorrecto", "Se ha encontrado un error", JOptionPane.ERROR_MESSAGE);
					bandera=false;
				}
			}
			
			
			p = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})");
			m = p.matcher(String.copyValueOf(pf_pass.getPassword()));
			b = m.matches();
			
			if(bandera) {
				if(b==false) {
					JOptionPane.showMessageDialog(null, "password incorrecto", "Se ha encontrado un error", JOptionPane.ERROR_MESSAGE);
					bandera=false;
				}
			}
			
			if(bandera) {
				if(lbl_imagen.getIcon()==null) {
					JOptionPane.showMessageDialog(null, "seleccione una imágen", "Se ha encontrado un error", JOptionPane.ERROR_MESSAGE);
					bandera=false;
				}
			}
			if(bandera) {
				if(cb_favorito.getSelectedItem().toString().equals("Seleccione categoria:")) {
					JOptionPane.showMessageDialog(null, "seleccione una categoria", "Se ha encontrado un error", JOptionPane.ERROR_MESSAGE);	
					bandera=false;
				}
				
			}
			if(bandera) {
				usuario.setNombre(tf_nombre.getText());
				usuario.setEmail(tf_email.getText());
				
				File archivo=new File(fc_archivo.getSelectedFile().getPath());
				
				usuario.setFoto(archivo);
				usuario.setPass(String.copyValueOf(pf_pass.getPassword()));
				usuario.setId_categoria(categorias_dao.traer_id(cb_favorito.getSelectedItem().toString()));
				
				if(usuarios_dao.agregar(usuario)) {
					btn_agregar.setEnabled(false);
					btn_cancelar.setEnabled(false);
					btn_imagen.setEnabled(false);
					JOptionPane.showMessageDialog(null, "Usuario agregado", "Realizado", JOptionPane.INFORMATION_MESSAGE);
				}
				
				
			}
			
			
			
			
			
		}
		
	}

}	