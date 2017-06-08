package unidad1;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VentanaInicio extends JFrame implements ActionListener{
	private JLabel lbl_usuario, lbl_contra, lbl_mensaje;
	private JTextField tf_usuario;
	private JPasswordField pf_contra;
	private JButton btn_aceptar;
	private JLabel lbl_Image;
	private ImageIcon interrogacion=new ImageIcon("question-mark-29033.jpg");
	private ImageIcon palomita=new ImageIcon("nuovext-19.jpg");
	private ImageIcon tacha=new ImageIcon("nuovext-18.jpg");
	
public VentanaInicio(int ancho, int alto){
	super("Ingresa tus datos");
	setLayout(new FlowLayout());
	setSize(ancho, alto);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	Image im= Toolkit.getDefaultToolkit().getImage("imagen-amor.jpg");
	setIconImage (im);
	
	lbl_usuario=new JLabel("nombre de usuario:");
	lbl_contra=new JLabel("contraseña:");
	JLabel lbl_Image=new JLabel();
	lbl_Image.setIcon(interrogacion);
	tf_usuario=new JTextField(20);
	pf_contra=new JPasswordField(20);
	lbl_mensaje=new JLabel();
	btn_aceptar=new JButton("aceptar");
	btn_aceptar.addActionListener(this);
	
	add(lbl_usuario);
	add(tf_usuario);
	add(lbl_contra);
	add(pf_contra);
	add(btn_aceptar);
	add(lbl_mensaje);
	add(lbl_Image);
	
	setVisible(true);
}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VentanaInicio ventana=new VentanaInicio(300, 200);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn_aceptar){
			String u=tf_usuario.getText();
			String p=String.valueOf(pf_contra.getPassword());
			
			if(u.equals("abrete") && p.equals("sesamo")){
				lbl_mensaje.setIcon(palomita);
				
			}else {
				lbl_mensaje.setIcon(tacha);
				
				
			}
			tf_usuario.setText("");
			pf_contra.setText("");
			
			Encriptacion enc=new Encriptacion();
			
			
				try {
					lbl_contra.setText(enc.encriptar(p));
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				lbl_usuario.setText(enc.desencriptar(p));
				
			}
			}
		
	}


