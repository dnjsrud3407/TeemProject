package dao;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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


	public BookBean selectreviews(int num) {
		BookBean books = null;

		return books;
	}
	
	// 책 등록 시 카테고리 구하기(아직 미완성...)
	public int getBKLev(String BKLev) {
		int bookKategorie_BKID = 0;
		PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    String sql = "SELECT BKID FROM bookkategorie WHERE BKLev=?";
	    try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, BKLev);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bookKategorie_BKID = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	        if(rs != null) {close(rs);}
	        if(pstmt != null) {close(pstmt);}
	    }
		
		return bookKategorie_BKID;
	}
	
	// 책 등록 시 책 번호 구하기(책 번호 중 최대값 구하기)
	public int getMaxNum() {
	    int maxNum = 0;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    String sql = "SELECT MAX(bookID) FROM book";
	    try {
	        pstmt = con.prepareStatement(sql);
	        rs = pstmt.executeQuery();
	        if(rs.next()) {
	            maxNum = rs.getInt(1) + 1;  // 책 번호 최대값 + 1
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if(rs != null) {close(rs);}
	        if(pstmt != null) {close(pstmt);}
	    }
	    
	    return maxNum;
	}

	// 책 등록하는 작업
	public int insertBook(BookBean book) {
		int insertCount = 0;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO book(bookID,bookTitle,bookOriginImage,bookImage,bookPublisher,bookPublishedDate,"
		        + "bookPrice,bookEA,bookIntroduce,bookisView,saveRatio,bookKategorie_BKID)"
		        + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, book.getBookID());
            pstmt.setString(2, book.getBookTitle());
            pstmt.setString(3, book.getBookOriginImage());
            pstmt.setString(4, book.getBookImage());
            pstmt.setString(5, book.getBookPublisher());
            // 자바의 Date 를 Mysql 의 Date 형으로 바로 넣을 수 없기 때문에 변환 필요
            pstmt.setDate(6, new java.sql.Date(book.getBookPublishedDate().getTime()));
            pstmt.setInt(7, book.getBookPrice());
            pstmt.setInt(8, book.getBookEA());
            pstmt.setString(9, book.getBookIntroduce());
            pstmt.setBoolean(10, book.isBookisView());
            pstmt.setFloat(11, book.getSaveRatio());
            pstmt.setInt(12, book.getBookKategorie_BKID());
            insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(pstmt != null) {close(pstmt);}
        }
		
		return insertCount;
	}
	
	// 책 상세보기에서 사용하는 getArticle
	public BookBean selectBook(int bookID) {
	    BookBean book = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    String sql = "SELECT * FROM book WHERE bookID=?";
	    try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, bookID);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                book = new BookBean(
                        rs.getInt("bookID"), 
                        rs.getString("bookTitle"), 
                        rs.getString("bookOriginImage"), 
                        rs.getString("bookImage"), 
                        rs.getString("bookPublisher"), 
                        rs.getDate("bookPublishedDate"), 
                        rs.getInt("bookPrice"), 
                        rs.getInt("bookEA"), 
                        rs.getString("bookIntroduce"), 
                        rs.getBoolean("bookisView"), 
                        rs.getFloat("saveRatio"),
                        rs.getInt("bookKategorie_BKID")
                        );
            }
	    } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(rs != null) {close(rs);}
            if(pstmt != null) {close(pstmt);}
        }
	    
	    return book;
	}
	
	// 책 삭제 시 비밀번호 확인
	public boolean isRightUser(String uID, String pw) {
	    boolean isRightUser = false;
	    PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT uID FROM user WHERE uID=? AND pw=?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, uID);
            pstmt.setString(2, pw);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                isRightUser = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(rs != null) {close(rs);}
            if(pstmt != null) {close(pstmt);}
        }
        
	    return isRightUser;
	}

	// 책 삭제하기
	public int deleteBook(int bookID) {
	    int deleteCount = 0;
	    PreparedStatement pstmt = null;
        String sql = "DELETE FROM book WHERE bookID=?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, bookID);
            deleteCount = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(pstmt != null) {close(pstmt);}
        }
        
	    return deleteCount;
	}

	// 책 수정하기 
	public int updateBook(BookBean book) {
	    int updateCount = 0;
	    PreparedStatement pstmt = null;
        String sql = "UPDATE book SET bookTitle=?,bookOriginImage=?,bookImage=?,"
                + "bookPublisher=?,bookPublishedDate=?,bookPrice=?,bookEA=?,"
                + "bookIntroduce=?,bookisView=?,saveRatio=?,bookKategorie_BKID=? "
                + "WHERE bookID=?";
	    try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, book.getBookTitle());
            pstmt.setString(2, book.getBookOriginImage());
            pstmt.setString(3, book.getBookImage());
            pstmt.setString(4, book.getBookPublisher());
            // 자바의 Date 를 Mysql 의 Date 형으로 바로 넣을 수 없기 때문에 변환 필요
            pstmt.setDate(5, new java.sql.Date(book.getBookPublishedDate().getTime()));
            pstmt.setInt(6, book.getBookPrice());
            pstmt.setInt(7, book.getBookEA());
            pstmt.setString(8, book.getBookIntroduce());
            pstmt.setBoolean(9, book.isBookisView());
            pstmt.setFloat(10, book.getSaveRatio());
            pstmt.setInt(11, book.getBookKategorie_BKID());
            pstmt.setInt(12, book.getBookID());
            updateCount = pstmt.executeUpdate();
	    } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(pstmt != null) {close(pstmt);}
        }
	    
	    return updateCount;
	}
	
	// 책 목록 가져오기 
	public ArrayList<BookBean> selectBookList() {
		ArrayList<BookBean> bookList = new ArrayList<BookBean>();
		PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM book";
        BookBean book = null;
        
        try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				book = new BookBean(
						rs.getInt("bookID"), 
                        rs.getString("bookTitle"), 
                        rs.getString("bookOriginImage"), 
                        rs.getString("bookImage"), 
                        rs.getString("bookPublisher"), 
                        rs.getDate("bookPublishedDate"), 
                        rs.getInt("bookPrice"), 
                        rs.getInt("bookEA"), 
                        rs.getString("bookIntroduce"), 
                        rs.getBoolean("bookisView"), 
                        rs.getFloat("saveRatio"),
                        rs.getInt("bookKategorie_BKID")
                        );
				bookList.add(book);
				
			}
        } catch (SQLException e) {
			e.printStackTrace();
		}
        
		return bookList;
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
