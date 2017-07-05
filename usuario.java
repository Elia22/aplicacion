package Integradora;

import java.awt.Image;
import java.io.File;

public class usuario {
	private int id_usuario;
	private String nombre;
	private String descripcion;
	private String email;
	private File foto;
	private Image imagen;
	private String pass;
	private int id_categoria;
	
	
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getdescripcion() {
		return nombre;
	}
	public void setdescripcion(String descripcion) {
		this.nombre = nombre;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public File getFoto() {
		return foto;
	}
	public void setFoto(File foto) {
		this.foto = foto;
	}
	public Image getImagen() {
		return imagen;
	}
	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public int getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	@Override
	public String toString() {
		return "Usuarioa [id_usuario=" + id_usuario + ", nombre=" + nombre + ", email=" + email + ", foto=" + foto
				+ ", imagen=" + imagen + ", pass=" + pass + "]";
	}
	
	

}