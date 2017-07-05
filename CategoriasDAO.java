package Integradora;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.Vector;

	public class CategoriasDAO {
		private Connection c=null;
		private PreparedStatement pstm=null;
		private ResultSet rs=null;
		private String usr="root";
		private String pwd="";
		private String sql="";
		private String driver="com.mysql.jdbc.Driver";
		
	public Vector traer() {
		Vector categorias=new Vector();
		
		
		try {
			Class.forName(driver);
			c=DriverManager.getConnection("jdbc:mysql://localhost/intregradora",usr,pwd);
			sql="SELECT nombre FROM categorias ORDER BY nombre";
			pstm=c.prepareStatement(sql);
			rs=pstm.executeQuery();
			categorias.add("Seleccione categoria:");
			while(rs.next()) {
				categorias.add(rs.getString("nombre"));
			}
			rs.close();
			pstm.close();
			c.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return categorias;
	}
	public int traer_id(String nombre) {
		int respuesta=0;
		try {
			Class.forName(driver);
			c=DriverManager.getConnection("jdbc:mysql://localhost/intregradora",usr,pwd);
			sql="SELECT id_categoria FROM categorias WHERE nombre=?";
			pstm=c.prepareStatement(sql);
			pstm.setString(1, nombre);
			rs=pstm.executeQuery();
			while(rs.next()) {
				respuesta=rs.getInt("id_categoria");
			}
			rs.close();
			pstm.close();
			c.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return respuesta;	
	}
	public String traer_nombre(int id_categoria) {
		String respuesta=new String();
		try {
			Class.forName(driver);
			c=DriverManager.getConnection("jdbc:mysql://localhost/intregradora",usr,pwd);
			sql="SELECT nombre FROM categorias WHERE id_categoria=?";
			pstm=c.prepareStatement(sql);
			pstm.setInt(1, id_categoria);
			rs=pstm.executeQuery();
			while(rs.next()) {
				respuesta=rs.getString("nombre");
			}
			rs.close();
			pstm.close();
			c.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return respuesta;	
	}
		

	}





