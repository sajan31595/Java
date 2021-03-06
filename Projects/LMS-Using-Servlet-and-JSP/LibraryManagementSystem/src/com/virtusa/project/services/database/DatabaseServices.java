package com.virtusa.project.services.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.virtusa.project.ServiceMain;
import com.virtusa.project.books.Book;
import com.virtusa.project.users.Admin;
import com.virtusa.project.users.Member;

public class DatabaseServices {

	@SuppressWarnings("deprecation")
	public boolean authenticateAdmin(int adminId,String passwd) {
		Session session = openSession();
		Transaction transaction = session.beginTransaction();
		
		if(validateAdminId(adminId)){
			Admin admin = (Admin) session.get(Admin.class, adminId);
			if(admin.getId() == adminId && admin.getUserPassword().equals(passwd)){
				transaction.commit();
				closeSession(session);
				System.out.println("\nAuthentication Successful\n");
				return true;
			}
			else{
				transaction.commit();
				closeSession(session);
				System.out.println("\nInvalid User ID or Password\n");
				return false;
			}
		}
		System.out.println("\nUser ID does not exist\n");
		closeSession(session);
		return false;
	}
	@SuppressWarnings("deprecation")
	public boolean authenticateMember(int mamberId,String passwd) {
		Session session = openSession();
		Transaction transaction = session.beginTransaction();
		
		if(validateMemberId(mamberId)){
			Member member = (Member) session.get(Member.class, mamberId);
			if(member.getId() == mamberId && member.getUserPassword().equals(passwd)){
				transaction.commit();
				closeSession(session);
				System.out.println("\nAuthentication Successful\n");
				return true;
			}
			else{
				transaction.commit();
				closeSession(session);
				System.out.println("\nInvalid User ID or Password\n");
				return false;
			}
		}
		System.out.println("\nUser ID does not exist\n");
		return false;
	}
	@SuppressWarnings("deprecation")
	public boolean validateBookId(int bookId) {
		Session session = openSession();
		Transaction transaction = session.beginTransaction();
		
		Book book = (Book) session.get(Book.class, bookId);
		if(book != null){
			transaction.commit();
			closeSession(session);
			return true;
		}
		else{
			transaction.commit();
			closeSession(session);
			return false;
		}
	}
	@SuppressWarnings("deprecation")
	public boolean validateMemberId(int memberId) {
		Session session = openSession();
		Transaction transaction = session.beginTransaction();
		
		Member member = (Member) session.get(Member.class, memberId);
		if(member != null){
			transaction.commit();
			closeSession(session);
			return true;
		}
		else{
			transaction.commit();
			closeSession(session);
			return false;
		}
	}
	@SuppressWarnings("deprecation")
	public boolean validateAdminId(int adminId) {
		
		Session session = openSession();
		Transaction transaction = session.beginTransaction();
		
		Admin admin = (Admin) session.get(Admin.class, adminId);
		if(admin != null){
			transaction.commit();
			closeSession(session);
			return true;
		}
		else{
			transaction.commit();
			closeSession(session);
			return false;
		}
	}
	@SuppressWarnings("deprecation")
	public void changePassword(int memberId) {
		Session session = openSession();
		Transaction transaction = session.beginTransaction();
//		ServiceMain serviceMain = new ServiceMain();
//		
//		Member member = (Member) session.get(Member.class, memberId);
//		String oldPassword = serviceMain.stringEntry("Current Password");
//		if(oldPassword.equals(member.getUserPassword())){
//			String newPassword = serviceMain.stringEntry("New Password");
//			String confirmPassword = serviceMain.stringEntry("Confirm Password");
//			if(newPassword.equals(confirmPassword) && !newPassword.equals(oldPassword)){
//				member.setUserPassword(newPassword);
//				session.saveOrUpdate(member);
//				ServiceMain.printAcknowledgeMessage("\nPassword Updated Successfully\n");
//			}
//			else{
//				ServiceMain.printAcknowledgeMessage("\nPassword didn't Match or Password didn't change\n");
//				changePassword(memberId);
//			}
//		}else{
//			ServiceMain.printAcknowledgeMessage("\nWrong Password\n");
//			changePassword(memberId);
//		}
		
		
		transaction.commit();
		changePassword(memberId);
	}

	public static Session openSession(){
		final Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		final SessionFactory sessionFactory = configuration.buildSessionFactory();
		final Session session = sessionFactory.openSession();
		return session;
	}
	public static void closeSession(Session session) {
		SessionFactory sessionFactory = session.getSessionFactory();
		session.close();
		sessionFactory.close();
		
	}
	
	public String getAdminNameFromDB(int adminId) {
		Session session = openSession();
		Admin admin = (Admin) session.get(Admin.class, adminId);
		closeSession(session);
		return admin.getUserName();
	}
	public String getMemberNameFromDB(int memberId) {
		Session session = openSession();
		Member member = (Member) session.get(Member.class, memberId);
		closeSession(session);
		return member.getUserName();
	}
	public String getMemberObjectString(int memberId){
		Session session = openSession();
		Member member = (Member) session.get(Member.class, memberId);
		closeSession(session);
		return member.getUserName()+" "+member.getUserPassword()+" "+member.getPhoneNumber();
	}
	public String getBookObjectString(int memberId){
		Session session = openSession();
		Book book = (Book) session.get(Book.class, memberId);
		closeSession(session);
		return book.getBookName()+" "+book.getAuthor()+" "+book.getEdition();
	}
}
