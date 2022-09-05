package entidade;

public class Cliente {

	public  int cnpj_Client;	
	public String name_Client;
	public String product_type;
	public int product_quantity;
	public float price;
	public String email;
	public String phone;
	
	
	public Cliente() {
		super();
		this.cnpj_Client = cnpj_Client;
		this.name_Client = name_Client;
		this.product_type = product_type;
		this.product_quantity = product_quantity;
		this.price = price;
		this.email = email;
		this.phone = phone;
	}


	public int getCnpj_Client() {
		return cnpj_Client;
	}


	public void setCnpj_Client(int cnpj_Client) {
		this.cnpj_Client = cnpj_Client;
	}


	public String getName_Client() {
		return name_Client;
	}


	public void setName_Client(String name_Client) {
		this.name_Client = name_Client;
	}


	public String getProduct_type() {
		return product_type;
	}


	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}


	public int getProduct_quantity() {
		return product_quantity;
	}


	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public  double TotalStock(){
		double TotalStock = product_quantity * price;
		 return TotalStock;
	
	}
		

	public String toString() {
		return 	  " Nome : " + name_Client + "\n" 
				+ " email: " + email + "\n" 
				+ " Telefone: " + phone +"\n"
				+ " Valor por unidade do produto R$" + String.format("%.2f", price) + "\n"
				+ " "+  product_quantity +" unidades \n" 
				+ " valor total do estoque: R$" + String.format("%.2f", TotalStock());
		 
	}
}
