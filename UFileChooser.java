package unidad1;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UFileChooser extends JFrame implements ActionListener {
	private JLabel lbl_archivo, lbl_foto;
	private JTextField tf_archivo;
	private JButton btn_abrir;
	private Icon ic;
	private JFileChooser fc_archivo;
	
public UFileChooser(){
	super("Usando el seleccionador de archivos");
	setSize(600, 300);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	lbl_foto=new JLabel();
	lbl_foto.setBounds(10, 20, 300, 300);
	
	lbl_archivo=new JLabel("Seleccionar archivo");
	lbl_archivo.setBounds(340, 20, 180, 25);
	
	tf_archivo=new JTextField();
	tf_archivo.setBounds(330, 50, 180, 25);
	
	btn_abrir=new JButton("abrir");
	btn_abrir.setBounds(350, 90, 100, 25);
	btn_abrir.addActionListener(this);
	
	fc_archivo=new JFileChooser();
	FileNameExtensionFilter filtro=new FileNameExtensionFilter("JPG & GIF", "jpg","gif","png");
	fc_archivo.setFileFilter(filtro);
	
	
	
	add(tf_archivo);
	add(tf_archivo);
	add(lbl_archivo);
	add(lbl_foto);
	add(btn_abrir);
	
	setLayout(null);
	setVisible(true);
}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
		public void run(){
			
			UFileChooser ventana=new UFileChooser();
		}
		});
		
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn_abrir) {
			int respuesta=fc_archivo.showOpenDialog(this);
			if(respuesta==JFileChooser.APPROVE_OPTION){
				tf_archivo.setText(fc_archivo.getSelectedFile().getAbsolutePath());
				ImageIcon imagen=new ImageIcon(fc_archivo.getSelectedFile().getAbsolutePath());
				ic=new ImageIcon(imagen.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
				lbl_foto.setIcon(ic);
				
				
			}
		}
		
		
	}

}




//JEditorPane
