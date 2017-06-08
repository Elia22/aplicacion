package unidad1;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.color.WHITE;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Dinner extends JFrame{
	private Container contents;
	private JLabel labelText;
	//private JLabel label Image;
	
	public Dinner(){
		super ( "What's for dinner?" );
		contents = getContentPane();
		//call JFrame constructor
		//get content pane
		setLayout (new FlowLayout()); // set layout manager
		//use the JLabel constructor whit a String argument
		labelText= new JLabel( "Sushi tonight?" );
		//set label properties
		labelText.setForeground( java.awt.Color.MAGENTA);
		labelText.setBackground(java.awt.Color.BLUE);
		labelText.setOpaque(true);
		// use the JLabel contructor whit an imageIcon argument
		JLabel labelImage = new JLabel( new ImageIcon("sushi.jpg"));
		
		contents.add(labelText);
		contents.add(labelImage);
		setSize(300, 200);
		setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		Dinner dinner=new Dinner();
		dinner.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		
	}

}
