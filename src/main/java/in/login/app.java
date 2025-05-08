package in.login;

import java.util.Scanner;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class app {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("abhi");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		Customer customer=new Customer(1,"abhishek varpe",Customer.hashcode("abhishek@123"),"Abhishek@123");
		em.persist(customer);
		
//		Customer customer=new Customer();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the Email");
		String email=scanner.next();
		System.out.println("enter the password");
		String password=scanner.next();
		String hashString=Customer.hashcode(password);
		Query query=em.createQuery("from Customer where password=:pass and email=:email ");
		query.setParameter("pass", hashString);
		query.setParameter("email",email);
		
		int id1=customer.getCid();
		
		Customer customer1=(Customer)query.getSingleResult();
		System.out.print("welcome"+customer1.getUsername());
		System.out.println("do you want to update your Username (y/n)");
		char option=scanner.next().charAt(0);
		if(option=='y')
		{
			System.out.println("Enter the username");
			String username=scanner.next();
			Query query2=em.createQuery("update Customer set username=:user where  cid=:id1");
			query2.setParameter("user",username);
			query2.setParameter("id1",id1 );
			query2.executeUpdate();
			
		}else if (option=='n') {
			System.out.println("ok Done");
			
		}{
			
		}
		
		et.commit();

	}

}
