package unidad1;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Border01 extends JFrame {
	private JButton boton1;
	private JButton boton2;
	private JButton boton3;
	private JButton boton4;
	private JButton boton5;
	

	public Border01(){
		
		super("Ventana que utilizamos Border Layout");
		setLayout(new BorderLayout());
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		boton1=new JButton("Button1");
		boton2=new JButton("Button2");
		boton3=new JButton("Button3");
		boton4=new JButton("Button4");
		boton5=new JButton("Button5");
		add(boton1,BorderLayout.NORTH);
		add(boton2, BorderLayout.CENTER);
		add(boton3, BorderLayout.SOUTH);
		add(boton4, BorderLayout.WEST);
		add(boton5, BorderLayout.EAST);
		
		setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Border01 ventana=new Border01();

	}

}
