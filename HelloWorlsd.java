package unidad1;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloWorlsd extends JFrame implements ActionListener {
	private JLabel etiqueta1;
	private JButton boton1;
	
	public HelloWorlsd(){
		super("Hello Worlsd");
		setSize(300, 200);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image im= Toolkit.getDefaultToolkit().getImage("imagen-amor.jpg");
		setIconImage (im);
		Icon ic= new ImageIcon("icono.jpg");
		
		boton1=new JButton("aceptar");
		boton1.addActionListener(this);
		etiqueta1=new JLabel(ic);
		
		add(etiqueta1);
		add(boton1);
		setVisible(true);
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HelloWorlsd ventana=new HelloWorlsd();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		etiqueta1.setText("Elia Margarita");
		
		
	}

}
