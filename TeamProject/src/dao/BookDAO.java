package dao;

import static db.JdbcUtil.*;

import java.sql.Connection;

import vo.BookBean;

public class BookDAO {
	public BookDAO() {}
	
	private static BookDAO instance = new BookDAO();

	public static BookDAO getInstance() { 
		return instance;
	}
	// ----------------------------------------------------
	Connection con;

	public void setConnection(Connection con) {
		this.con = con;
	}

	public BookBean selectBooks(int num) {
		BookBean books = null;

		return books;
	}

	public BookBean selectreviews(int num) {
		BookBean books = null;

		return books;
	}
	
	public int insertBooks(BookBean bookBean) {
		int insertCount = 0;
		
		return insertCount;
	}

	public void updateBoard_re_ref(BookBean bookBean) {
		
	}

	public int insertQuestion(BookBean bookBean) {
		
		return 0;
	}

	public boolean isWriter(int num, String pass) {
		
		return false;
	}

	public int updateReview(BookBean review) {
		return 0;
	}

	public BookBean selectBook(int num) {
		return null;
	}

	public int updateReadcount(int num) {
		return 0;
	}
	public BookBean selectQuestion(int num) {
		BookBean books = null;

		return books;
	}

	public int updateQuestion(BookBean question) {
		return 0;
	}

}
