package Integradora;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;

public class usuarioDAO {
	private Connection c=null;
	private PreparedStatement pstm=null;
	private ResultSet rs=null;
	private String usr="root";
	private String pwd="";
	private String sql="";
	private String driver="com.mysql.jdbc.Driver";
	
public boolean agregar(usuario u) {
	boolean respuesta=false;
	try {
		Class.forName(driver);
		c=DriverManager.getConnection("jdbc:mysql://localhost/intregradora",usr,pwd);
		sql="INSERT INTO usuarios VALUES(?,?,?,?,MD5(?),?)";
		pstm=c.prepareStatement(sql);
		pstm.setString(1, null);
		pstm.setString(2, u.getNombre());
		pstm.setString(3, u.getEmail());
		
		FileInputStream streamEntrada=new FileInputStream(u.getFoto());
		pstm.setBinaryStream(4, streamEntrada,(int) u.getFoto().length());
		pstm.setString(5, u.getPass());
		pstm.setInt(6, u.getId_categoria());
		
		pstm.executeUpdate();

		streamEntrada.close();
		pstm.close();
		c.close();
		respuesta=true;
	} catch (ClassNotFoundException | SQLException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return respuesta;
}
public usuario traer_usuario(String email) {
	usuario usuario=new usuario();
	try {
		Class.forName(driver);
		c=DriverManager.getConnection("jdbc:mysql://localhost/intregradora",usr,pwd);
		sql="SELECT * FROM usuarios WHERE email=?";
		pstm=c.prepareStatement(sql);
		pstm.setString(1, email);
		rs=pstm.executeQuery();
		while(rs.next()) {
			usuario.setId_usuario(rs.getInt("id_usuario"));
			usuario.setNombre(rs.getString("nombre"));
			usuario.setEmail(rs.getString("email"));
			InputStream in=rs.getBinaryStream("foto");
			Image imagen;
			try {
				imagen=ImageIO.read(in);
				usuario.setImagen(imagen);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			usuario.setPass(rs.getString("password"));
			usuario.setId_categoria(rs.getInt("id_categoria"));
		}
		rs.close();
		pstm.close();
		c.close();
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
	return usuario;
}
public boolean eliminar(usuario usuario) {
	boolean respuesta=false;
	try {
		Class.forName(driver);
		c=DriverManager.getConnection("jdbc:mysql://localhost/intregradora",usr,pwd);
		sql="DELETE FROM usuarios WHERE id_usuario=?";
		pstm=c.prepareStatement(sql);
		pstm.setInt(1, usuario.getId_usuario());
		if(pstm.executeUpdate()==1) {
			respuesta=true;
		}else {
			respuesta=false;
		}
		pstm.close();
		c.close();
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return respuesta;
}
public boolean modificar(usuario u) {
	// TODO Auto-generated method stub
	boolean respuesta=false;
	FileInputStream streamEntrada;
	try {
		Class.forName(driver);
		c=DriverManager.getConnection("jdbc:mysql://localhost/intregradora",usr,pwd);
		if(u.getPass()!="") {
			sql="UPDATE usuarios SET nombre=?, email=?, foto=?, password=MD5(?), id_categoria=? WHERE id_usuario=?";
			pstm=c.prepareStatement(sql);
			pstm.setInt(1, u.getId_usuario());
			pstm.setString(2, u.getNombre());		
			pstm.setString(3, u.getEmail());
			streamEntrada=new FileInputStream(u.getFoto());
			pstm.setBinaryStream(4, streamEntrada,(int) u.getFoto().length());
			pstm.setString(5, u.getPass());
			pstm.setInt(6, u.getId_categoria());
			
		}else {
			sql="UPDATE usuarios SET nombre=?, email=?, foto=?, id_categoria=? WHERE id_usuario=?";
			pstm=c.prepareStatement(sql);
			pstm.setInt(1, u.getId_usuario());
			pstm.setString(2, u.getNombre());		
			pstm.setString(3, u.getEmail());		
			streamEntrada=new FileInputStream(u.getFoto());
			pstm.setBinaryStream(4, streamEntrada,(int) u.getFoto().length());
			pstm.setInt(5, u.getId_categoria());
			pstm.setInt(6, u.getId_usuario());
		}	
		
		
		
		pstm.executeUpdate();

		streamEntrada.close();
		pstm.close();
		c.close();
		respuesta=true;
	} catch (ClassNotFoundException | SQLException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return respuesta;
}
public static void saveOutputStream(String name, InputStream body) {
    int c;
    try {
      OutputStream f = new FileOutputStream(name);
      while ((c=body.read())>-1) {
        f.write(c);
      }
      f.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
}

}
