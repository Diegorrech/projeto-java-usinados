package Aplicacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Driver;

import db.ConexaoMySQL;

import entidade.Cliente;

public class Registro {

	public static void main(String[] args)    throws Exception {

		
		
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner (System.in);
		
		Connection conecta = null;
		
		
		try {

	         conecta = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_registro?" +
	                  "user=root&password=06857594902");
	          
	       System.out.println("Conexão realizada com sucesso.");
	       
	       
		 }catch (SQLException ex) {
		     	
             //Caso ocorram erros na tentativa de conexão com o MySQL
     	
             System.out.println("SQLException: " + ex.getMessage());
             System.out.println("SQLState: " + ex.getSQLState());
             System.out.println("VendorError: " + ex.getErrorCode());
         
		
     }
        
       
		
		
		Cliente client1 = new Cliente ();
		
	
		
		System.out.println("cadastre o cnpj do cliente");
		client1.cnpj_Client =  input.nextInt();
		
		System.out.println("cadastre o nome do cliente");
		client1.name_Client = input.next();
		
		System.out.println("tipo do produto");
		client1.product_type = input.next();		
		
		System.out.println("cadastre a quantidade de produto ");
		client1.product_quantity = input.nextInt();
		
		System.out.println("cadastre o preco");
		client1.price = input.nextFloat();
		
		System.out.println("email do cliente ");
		client1.email = input.next();
		
		System.out.println("telefone do cliente");
		client1.phone = input.next();
		
		
		
		
		
		System.out.println();
		System.out.println("CNPJ                      :" + client1.cnpj_Client);
		System.out.println();
		System.out.println("NOME DO CLIENTE           :" + client1.name_Client);
		System.out.println();
		System.out.println("TIPO DO PRODUTO           :" + client1.product_type);
		System.out.println();
		System.out.println("QUANTIDADE DE PRODUTOS    :" + client1.product_quantity);
		System.out.println();
		System.out.println("VALOR UNITARIO DO PRODUTO :" + client1.price);	
		System.out.println();
		System.out.println("EMAIL DO CLIENTE          :" + client1.email);
		System.out.println();
		System.out.println("TELEFONE DO CLIENTE       :" + client1.phone);
		System.out.println();
		System.out.println();
		System.out.println(client1.toString());
		
		
		JOptionPane.showMessageDialog(null, client1.toString() );
		
		
		
	
	 try {

       
       Driver driver = new Driver();
       DriverManager.registerDriver(driver);
       PreparedStatement stmt = conecta.prepareStatement("INSERT INTO bd_registro.cliente (cnpj_client,name_client,product_type,"
       		+ "product_quantity,price,email,phone) VALUES (?,?,?,?,?,?,?)");
       
       stmt.setInt(1, client1.cnpj_Client);
       stmt.setString(2,client1.name_Client);
       stmt.setString(3, client1.product_type );
       stmt.setInt(4, client1.product_quantity);
       stmt.setFloat(5,client1.price );
       stmt.setString(6,client1.email);
       stmt.setString(7,client1.phone);
       
       int rowsAffected = stmt.executeUpdate();
       if (rowsAffected > 0 ) {
    	   System.out.println("usuario inserido com sucesso");
       }else {
    	   System.out.println("erro ao cadastrar usuario");
    	  
       }
       
       

		
     }catch (SQLException ex) {
     	
             //Caso ocorram erros na tentativa de conexão com o MySQL
     	
             System.out.println("SQLException: " + ex.getMessage());
             System.out.println("SQLState: " + ex.getSQLState());
             System.out.println("VendorError: " + ex.getErrorCode());
         
		
     }
}
}
		
		

		


