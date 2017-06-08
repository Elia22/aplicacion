package unidad1;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UTextArea extends JFrame implements ActionListener {
	private JLabel lbl_producto, lbl_descripcion, lbl_mensaje;
	private JTextField tf_producto;
	private JTextArea ta_descripcion;
	private JButton btn_aceptar;
	private JScrollPane scrollPane;
	
	public UTextArea(){
		super("Usando Text Area");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		Image im= Toolkit.getDefaultToolkit().getImage("imagen-amor.jpg");
		setIconImage (im);
		
		lbl_producto=new JLabel("Nombre del producto");
		lbl_descripcion=new JLabel("Descripcion del producto");
		lbl_mensaje=new JLabel();
		
		tf_producto=new JTextField(20);
		ta_descripcion=new JTextArea(7,20);
		scrollPane=new JScrollPane(ta_descripcion);
		
		btn_aceptar=new JButton("Aceptar");
		btn_aceptar.addActionListener(this);
		
		add(lbl_producto);
		add(tf_producto);
		add(lbl_descripcion);
		add(scrollPane);
		add(btn_aceptar);
		add(lbl_mensaje);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UTextArea ventana=new UTextArea();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn_aceptar){
			//lbl_mensaje.setText(ta_descripcion.getSelectedText());
			//ta_descripcion.insert(tf_producto.getText(), 0);
			ta_descripcion.replaceRange(tf_producto.getText(), 3, 7);
			
		}
	}

}
