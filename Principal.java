package Integradora;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class Principal extends JFrame implements ActionListener{
	private JMenuBar jmb_principal;
	private JMenu jm_usuarios,jm_publicaciones, jm_salir;
	private JMenuItem jmi_usuarios_agregar, jmi_usuarios_eliminar, jmi_usuarios_modificar, jmi_usuarios_consultar, jmi_usuarios_reportes;
	private JMenuItem jmi_publicaciones_agregar, jmi_publicaciones_eliminar, jmi_publicaciones_modificar, jmi_publicaciones_consultar, jmi_publicaciones_reportes;
	private JMenuItem jmi_salir_salir;
	private agregar ventana_usuario_agregar;
	private eliminar ventana_usuario_eliminar;
	private modificar ventana_usuario_modificar;
	
public Principal(){
		super("Mano Humanoide");
		setSize(800, 600);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font letra_menu=new Font("Tahoma", Font.PLAIN, 16);
		
		Image im = Toolkit.getDefaultToolkit().getImage("icono.png");
		 setIconImage(im);
		 Icon ic= new ImageIcon("sinovation logo.png"); 
		
		
		jmb_principal=new JMenuBar();
		jm_usuarios=new JMenu("Usuarios");
		jm_usuarios.setFont(letra_menu);
		jm_usuarios.setMnemonic(KeyEvent.VK_U);
		jm_usuarios.setIcon(new ImageIcon("user.png"));
		
		jmi_usuarios_agregar=new JMenuItem("Agregar Usuario (1)", new ImageIcon("add1.png"));
		jmi_usuarios_agregar.addActionListener(this);
		jmi_usuarios_agregar.setMnemonic(KeyEvent.VK_1);
	
		jmi_usuarios_eliminar=new JMenuItem("Eliminar Usuario (2)",new ImageIcon("rem.png"));
		jmi_usuarios_eliminar.addActionListener(this);
		jmi_usuarios_eliminar.setMnemonic(KeyEvent.VK_2);
		
		jmi_usuarios_modificar=new JMenuItem("Modificar Usuario (3)", new ImageIcon("mod.png"));
		jmi_usuarios_modificar.addActionListener(this);
		jmi_usuarios_modificar.setMnemonic(KeyEvent.VK_3);
		
		/*
		jmi_usuarios_consultar=new JMenuItem("Consultar Usuario (4)", new ImageIcon("consulta.png"));
		jmi_usuarios_consultar.addActionListener(this);
		jmi_usuarios_consultar.setMnemonic(KeyEvent.VK_4);
		
		jmi_usuarios_reportes=new JMenuItem("Reportes de Usuario (5)", new ImageIcon("reporte.png"));
		jmi_usuarios_reportes.addActionListener(this);
		jmi_usuarios_reportes.setMnemonic(KeyEvent.VK_5);
		*/
		
		jm_usuarios.add(jmi_usuarios_agregar);
		jm_usuarios.add(jmi_usuarios_eliminar);
		jm_usuarios.add(jmi_usuarios_modificar);
		/*
		jm_usuarios.add(jmi_usuarios_consultar);
		jm_usuarios.add(jmi_usuarios_reportes);
		*/
		/*
		jm_publicaciones=new JMenu("Publicaciones");
		jm_publicaciones.setFont(letra_menu);
		jmi_publicaciones_agregar=new JMenuItem("Agregar Publicaciones");
		jmi_publicaciones_agregar.addActionListener(this);
		
		jmi_publicaciones_eliminar=new JMenuItem("Eliminar Publicaciones");
		jmi_publicaciones_eliminar.addActionListener(this);
		
		jmi_publicaciones_modificar=new JMenuItem("Modificar Publicaciones");
		jmi_publicaciones_modificar.addActionListener(this);
		
		jmi_publicaciones_consultar=new JMenuItem("Consultar Publicaciones");
		jmi_publicaciones_consultar.addActionListener(this);
		
		jmi_publicaciones_reportes=new JMenuItem("Reportes de Publicaciones");
		jmi_publicaciones_reportes.addActionListener(this);
		
		jm_publicaciones.add(jmi_publicaciones_agregar);
		jm_publicaciones.add(jmi_publicaciones_eliminar);
		jm_publicaciones.add(jmi_publicaciones_modificar);
		jm_publicaciones.add(jmi_publicaciones_consultar);
		jm_publicaciones.add(jmi_publicaciones_reportes);
		*/
		jm_salir=new JMenu("ventana");
		jm_salir.setFont(letra_menu);
		jmi_salir_salir=new JMenuItem("Salir");
		jm_salir.add(jmi_salir_salir);
		jmi_salir_salir.addActionListener(this);
		
		jmb_principal.add(jm_usuarios);
		jm_usuarios.setFont(letra_menu);
		//jmb_principal.add(jm_publicaciones);
		jmb_principal.add(jm_salir);
		
		this.setJMenuBar(jmb_principal);
			
		
		setVisible(true);
		
	}
		
public static void main(String[] args){
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try{
			Principal ventana_principal=new Principal();
			agregar ventana_agregar= new agregar();
			} catch (Exception e){
				e.printStackTrace();
			}
			
		}
	});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jmi_salir_salir){
			System.out.print("Saliendo");
			System.exit(0);
		}
		
		if(e.getSource()==jmi_usuarios_agregar) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						ventana_usuario_agregar=new agregar();
						ventana_usuario_agregar.setVisible(true);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
		}
		if(e.getSource()==jmi_usuarios_eliminar) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						ventana_usuario_eliminar=new eliminar();
						ventana_usuario_eliminar.setVisible(true);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
		}
		if(e.getSource()==jmi_usuarios_modificar) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						ventana_usuario_modificar=new modificar();
						ventana_usuario_modificar.setVisible(true);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
		}
		
	}

}