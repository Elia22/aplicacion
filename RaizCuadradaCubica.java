package unidad1;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RaizCuadradaCubica extends JFrame implements ActionListener{
	private JLabel lbl_numero, lbl_resultado;
	private JTextField tf_numero;
	private JButton btn_cuadrado, btn_cubo;
	
public RaizCuadradaCubica(){
	super("Raiz cubica y cuadrada");
	setSize(300, 200);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	Image im= Toolkit.getDefaultToolkit().getImage("imagen-amor.jpg");
	setIconImage (im);
	
	setLayout(null);
	lbl_numero =new JLabel("ingrese número");
	lbl_numero.setBounds(20, 10, 100, 25);
	
	tf_numero=new JTextField();
	tf_numero.setBounds(120, 10, 50, 25);
	
	btn_cuadrado=new JButton("Cuadrado");
	btn_cuadrado.setBounds(20, 50, 100, 30);
	btn_cuadrado.addActionListener(this);
	
	btn_cubo=new JButton("Cubo");
	btn_cubo.setBounds(130, 50, 100, 30);
	btn_cubo.addActionListener(this);
	
	lbl_resultado=new JLabel();
	lbl_resultado.setBounds(100, 90, 120, 25);
	
	add(lbl_resultado);
	add(lbl_numero);
	add(tf_numero);
	add(btn_cuadrado);
	add(btn_cubo);
	
	setVisible(true);
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
		public void run(){
			
		RaizCuadradaCubica ventana=new RaizCuadradaCubica();
		}
	});
	
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		double numero =Double.valueOf(tf_numero.getText());
		if(e.getSource()==btn_cuadrado){
			double resultado=Math.pow(numero, 2.0);
			lbl_resultado.setText(String.valueOf(resultado));		
		}
		if(e.getSource()==btn_cubo){
			double resultado=Math.pow(numero, 3.0);
			lbl_resultado.setText(String.valueOf(resultado));		
		}
	}
		}
	

	

	
