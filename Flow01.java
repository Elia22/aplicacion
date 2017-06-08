package unidad1;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Flow01 extends JFrame {
	
	private JButton boton1;
	private JButton boton2;
	private JButton boton3;
	private JButton boton4;
	private JButton boton5;
	
	public Flow01(){
		super("Ventana con Flowlayout");
		setLayout(new FlowLayout());
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		boton1=new JButton("Button1");
		boton2=new JButton("Button2");
		boton3=new JButton("Button3");
		boton4=new JButton("Button4");
		boton5=new JButton("Button5");
		
		add(boton1);
		add(boton2);
		add(boton3);
		add(boton4);
		add(boton5);
		
		setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Flow01 ventana=new Flow01();

	}

}
