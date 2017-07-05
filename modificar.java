package Integradora;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
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

public class modificar extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JTextField tf_email;
	private JTextField tf_nombre;
	private JPasswordField pf_pass;
	private JFileChooser fc_archivo;
	private JButton btn_imagen;
	private Icon ic;
	private JLabel lbl_imagen;
	private JButton btn_modificar, btn_cancelar, btn_buscar;
	private JComboBox cb_favorito;
	private usuario usuario;
	private CategoriasDAO categorias_dao=new CategoriasDAO();
	private usuarioDAO usuarios_dao=new usuarioDAO();
	private boolean bandera_foto=false;
	
	public modificar () {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("Modificar Usuario");
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
		btn_imagen.setEnabled(false);
		contentPane.add(btn_imagen);
		
		btn_buscar = new JButton("Buscar");
		btn_buscar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_buscar.setBounds(427, 516, 118, 23);
		btn_buscar.addActionListener(this);
		contentPane.add(btn_buscar);
		
		btn_modificar = new JButton("Modificar");
		btn_modificar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_modificar.setBounds(570, 516, 118, 23);
		btn_modificar.addActionListener(this);
		btn_modificar.setEnabled(false);
		contentPane.add(btn_modificar);
		
		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_cancelar.setBounds(705, 516, 118, 23);
		btn_cancelar.addActionListener(this);
		contentPane.add(btn_cancelar);
		
		JLabel lbl_ventana = new JLabel("Modificar usuario");
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
		tf_nombre.setEnabled(false);
		panel.add(tf_nombre);
		
		JLabel label_2 = new JLabel("Password:");
		label_2.setBounds(36, 136, 73, 20);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(label_2);
		
		pf_pass = new JPasswordField();
		pf_pass.setBounds(121, 133, 218, 26);
		pf_pass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pf_pass.setEnabled(false);
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
		cb_favorito.setEnabled(false);
		panel.add(cb_favorito);
		
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
					btn_modificar.setEnabled(true);
					btn_imagen.setEnabled(true);
					tf_nombre.setText(usuario.getNombre());
					ic = new ImageIcon(usuario.getImagen().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
			    	lbl_imagen.setIcon(ic);
			    	fc_archivo.setSelectedFile(usuario.getFoto());
			    	tf_nombre.setEnabled(true);
			    	pf_pass.setEnabled(true);
			    	cb_favorito.setEnabled(true);
			    	cb_favorito.setSelectedItem(categorias_dao.traer_nombre(usuario.getId_categoria()));
			    }else {
					JOptionPane.showMessageDialog(null, "El usuario no existe en la BD", "Se ha encontrado un error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
		if(e.getSource()==btn_cancelar) {
			btn_buscar.setEnabled(true);
			btn_modificar.setEnabled(false);
			btn_imagen.setEnabled(false);
			tf_nombre.setEnabled(false);
	    	pf_pass.setEnabled(false);
	    	tf_nombre.setText("");
	    	tf_email.setText("");
	    	pf_pass.setText("");
	    	cb_favorito.setSelectedIndex(0);
	    	lbl_imagen.setIcon(null);			
		}
		if(e.getSource()==btn_imagen) {
			int returnVal = fc_archivo.showOpenDialog(this);
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		    	ImageIcon imagen=new ImageIcon(fc_archivo.getSelectedFile().getAbsolutePath());
				ic = new ImageIcon(imagen.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
		    	//ic=new ImageIcon(fc_archivo.getSelectedFile().getAbsolutePath());
		    	lbl_imagen.setIcon(ic);
		    	bandera_foto=true;
		    }
		}
		if(e.getSource()==btn_modificar) {
			
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
			String c=String.copyValueOf(pf_pass.getPassword());
			m = p.matcher(c);
			b = m.matches();
			
			if(bandera && !c.isEmpty()) {
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
				
				if(bandera_foto) {
					File archivo=new File(fc_archivo.getSelectedFile().getPath());
					usuario.setFoto(archivo);
				}
				
				String c1=String.copyValueOf(pf_pass.getPassword());
				if(!c1.isEmpty()) {
					usuario.setPass(c1);	
				}
				
				usuario.setId_categoria(categorias_dao.traer_id(cb_favorito.getSelectedItem().toString()));
				
				if(usuarios_dao.modificar(usuario)) {
					btn_buscar.setEnabled(true);
					btn_modificar.setEnabled(false);
					btn_imagen.setEnabled(false);
					tf_nombre.setEnabled(false);
			    	pf_pass.setEnabled(false);
			    	tf_nombre.setText("");
			    	tf_email.setText("");
			    	pf_pass.setText("");
			    	cb_favorito.setSelectedIndex(0);
			    	lbl_imagen.setIcon(null);
					JOptionPane.showMessageDialog(null, "Usuario modificado", "Realizado", JOptionPane.INFORMATION_MESSAGE);
				}
				
				
			}
			
			
			
			
			
		}
		
	}

}