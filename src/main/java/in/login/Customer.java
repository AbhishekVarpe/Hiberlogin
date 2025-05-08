package in.login;

import java.security.MessageDigest;

import org.hibernate.dialect.identity.DB2390IdentityColumnSupport;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Customer {
	@Id
	private int cid;
	private String username;
	private String password;
	private String email;
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer(int cid, String username, String password, String email) {
		super();
		this.cid = cid;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public static String hashcode(String password)
	{
		
		try {
			MessageDigest mDigest=MessageDigest.getInstance("SHA-256");
			byte[]hashcode=mDigest.digest(password.getBytes());
			StringBuilder sb= new StringBuilder();
			for(byte hash:hashcode)
			{
				sb.append(String.format("%02x",hash ));
			}
			
			return sb.toString();
			
		} 
		
		catch (Exception e) {
		      throw new RuntimeException("operation is failed");
		}
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", username=" + username + ", password=" + password + ", email=" + email + "]";
	}
	
	

}
