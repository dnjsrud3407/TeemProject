package dao;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

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
	
	// 책 등록 시 다중 카테고리 생성
//	public JSONArray selectBKList(String col, String type) {
//		JSONArray BKList = new JSONArray();
//		PreparedStatement pstmt = null;
//	    ResultSet rs = null;
//		String sql = "select distinct " + col + " from bookkategorie";
//		try {
//			pstmt = con.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			if(type.equals("BK1")) {
//				while(rs.next()){
//					JSONObject jbb = new JSONObject();
//					jbb.put("BK1", rs.getString("BK1"));
//					BKList.add(jbb);
//				}
//			} else if(type.equals("BK2")) {
//				while(rs.next()){
//					JSONObject jbb = new JSONObject();
//					jbb.put("BK1", rs.getString("BK1"));
//					jbb.put("BK2", rs.getString("BK2"));
//					BKList.add(jbb);
//				}
//			} else if(type.equals("BK3")) {
//				while(rs.next()){
//					JSONObject jbb = new JSONObject();
//					jbb.put("BK1", rs.getString("BK1"));
//					jbb.put("BK2", rs.getString("BK2"));
//					jbb.put("BK3", rs.getString("BK3"));
//					BKList.add(jbb);
//				}
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//	        if(rs != null) {close(rs);}
//	        if(pstmt != null) {close(pstmt);}
//	    }
//		return BKList;
//	}
	
	public ArrayList<String> selectBKList(String col, String type) {
		ArrayList<String> BKList = new ArrayList<String>();
		PreparedStatement pstmt = null;
	    ResultSet rs = null;
		String sql = "select distinct " + col + " from bookkategorie";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(type.equals("BK1")) {
				while(rs.next()){
					BKList.add(rs.getString("BK1"));
				}
			} else if(type.equals("BK2")) {
				while(rs.next()){
					BKList.add(rs.getString("BK1"));
					BKList.add(rs.getString("BK2"));
				}
			} else if(type.equals("BK3")) {
				while(rs.next()){
					BKList.add(rs.getString("BK1"));
					BKList.add(rs.getString("BK2"));
					BKList.add(rs.getString("BK3"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	        if(rs != null) {close(rs);}
	        if(pstmt != null) {close(pstmt);}
	    }
		return BKList;
	}
	
	// 책 등록 시 카테고리 번호 구하기
	public int selectBKID(String BK1, String BK2, String BK3) {
		int BKID = 0;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    String sql = "SELECT BKID FROM bookkategorie WHERE BK1=? AND BK2=? AND BK3=?";
	    try {
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, BK1);
	        pstmt.setString(2, BK2);
	        pstmt.setString(3, BK3);
	        rs = pstmt.executeQuery();
	        if(rs.next()) {
	        	BKID = rs.getInt(1);  // 책 번호 최대값 + 1
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if(rs != null) {close(rs);}
	        if(pstmt != null) {close(pstmt);}
	    }
	    
	    return BKID;
	}
	
	// 책 등록 시 책 번호 구하기(책 번호 중 최대값 구하기)
	public int selectMaxNum() {
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
		        + "bookPrice,bookEA,salesVolume,bookIntroduce,bookisView,saveRatio,bookKategorie_BKID)"
		        + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, book.getBookID());
            pstmt.setString(2, book.getBookTitle());
            pstmt.setString(3, book.getBookOriginImage());
            pstmt.setString(4, book.getBookImage());
            pstmt.setString(5, book.getBookPublisher());
            // 자바의 Date 를 Mysql 의 Date 형으로 바로 넣을 수 없기 때문에 변환 필요
            if(book.getBookPublishedDate() == null) {	// 날짜 입력 못 받았을 경우
            	pstmt.setDate(6, null);
            } else {
            	pstmt.setDate(6, new java.sql.Date(book.getBookPublishedDate().getTime()));
            }
            pstmt.setInt(7, book.getBookPrice());
            pstmt.setInt(8, book.getBookEA());
            pstmt.setInt(9, book.getSalesVolume());
            pstmt.setString(10, book.getBookIntroduce());
            pstmt.setBoolean(11, book.isBookisView());
            pstmt.setFloat(12, book.getSaveRatio());
            pstmt.setInt(13, book.getBookKategorie_BKID());
            insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(pstmt != null) {close(pstmt);}
        }
		
		return insertCount;
	}
	
	// 책 상세보기에서 사용하는 selectBook
	public BookBean selectBook(int bookID) {
	    BookBean book = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    String sql = "SELECT * FROM book JOIN bookkategorie ON book.bookKategorie_BKID = bookkategorie.BKID WHERE bookID=?";
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
                        rs.getInt("salesVolume"), 
                        rs.getString("bookIntroduce"), 
                        rs.getBoolean("bookisView"), 
                        rs.getFloat("saveRatio"),
                        rs.getInt("bookKategorie_BKID"),
                        rs.getString("BK1"),
                        rs.getString("BK2"),
                        rs.getString("BK3")
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
	
	// 책 상세보기에서 사용하는 카테고리 보기
//	public JSONArray selectBKCategorie(int BKID) {
//		JSONArray BKCategorie = new JSONArray();
//		PreparedStatement pstmt = null;
//	    ResultSet rs = null;
//	    String sql = "SELECT * FROM bookkategorie WHERE BKID=?";
//		try {
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, BKID);
//			rs = pstmt.executeQuery();
//			while(rs.next()){
//				JSONObject jbb = new JSONObject();
//				jbb.put("BKID", BKID);
//				jbb.put("BK1", rs.getString("BK1"));
//				jbb.put("BK2", rs.getString("BK2"));
//				jbb.put("BK3", rs.getString("BK3"));
//				BKCategorie.add(jbb);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//	        if(rs != null) {close(rs);}
//	        if(pstmt != null) {close(pstmt);}
//	    }
//		return BKCategorie;
//	}
	
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
            if(book.getBookPublishedDate() == null) {	// 날짜 입력 못 받았을 경우
            	pstmt.setDate(5, null);
            } else {
            	pstmt.setDate(5, new java.sql.Date(book.getBookPublishedDate().getTime()));
            }
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
	
	// 책 목록 개수
	public int selectListCount() {
		int listCount = 0;
		PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(*) FROM book";
        try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
        } catch (SQLException e) {
			e.printStackTrace();
		} finally {
            if(rs != null) {close(rs);}
            if(pstmt != null) {close(pstmt);}
        }
        
		return listCount;
	}
	
	// 책 목록 가져오기 
	public ArrayList<BookBean> selectBookList(int page, int limit) {
		ArrayList<BookBean> bookList = new ArrayList<BookBean>();
		PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM book join bookkategorie "
        		+ "on book.bookKategorie_BKID = bookkategorie.BKID ORDER BY bookID DESC LIMIT ?,?";
        BookBean book = null;
        
        int startRow = (page - 1) * limit;
        int endRow = startRow + limit;
        
        try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
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
                        rs.getInt("salesVolume"),
                        rs.getString("bookIntroduce"), 
                        rs.getBoolean("bookisView"), 
                        rs.getFloat("saveRatio"),
                        rs.getInt("bookKategorie_BKID"),
                        rs.getString("BK1"),
                        rs.getString("BK2"),
                        rs.getString("BK3")
                        );
				bookList.add(book);
				
			}
        } catch (SQLException e) {
			e.printStackTrace();
		} finally {
            if(rs != null) {close(rs);}
            if(pstmt != null) {close(pstmt);}
        }
        
		return bookList;
	}
	
	// 검색한 결과 들고오기
	public ArrayList<BookBean> selectSearchBookList(Map<Object, Object> searchList, int page, int limit) {
		ArrayList<BookBean> bookList = new ArrayList<BookBean>();
		PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM book JOIN bookkategorie "
        		+ "ON book.bookKategorie_BKID = bookkategorie.BKID WHERE 1=1";
        BookBean book = null;
        int startRow = (page - 1) * limit;
        int endRow = startRow + limit;

        // map 객체 key값 들고오기
        ArrayList keyList = new ArrayList(searchList.keySet());

        for(int i = 0; i < searchList.size(); i++) {
    		if(keyList.get(i).equals("bookID")) {
    			// 만약 bookID 값이 체크 되었다면
    			sql += " and " + keyList.get(i) + "=" + searchList.get(keyList.get(i));
    		} else if(keyList.get(i).equals("bookEA")) {
    			// 만약 bookEA 값이 체크 되었다면
    			sql += " and " + keyList.get(i) + "<" + 10;
    		} else if(keyList.get(i).equals("bookisView")) {
    			// 만약 bookisView 값이 체크 되었다면
    			sql += " and " + keyList.get(i) + "=false";
    		} else {	// 그 밖의 컬럼 : 전부 문자열
    			sql += " and " + keyList.get(i) + "='" + searchList.get(keyList.get(i)) + "'";
    		}
        }
        // 페이징 처리
        sql += " ORDER BY bookID DESC LIMIT ?,?";
        try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
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
                        rs.getInt("salesVolume"),
                        rs.getString("bookIntroduce"), 
                        rs.getBoolean("bookisView"), 
                        rs.getFloat("saveRatio"),
                        rs.getInt("bookKategorie_BKID"),
                        rs.getString("BK1"),
                        rs.getString("BK2"),
                        rs.getString("BK3")
                        );
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            if(rs != null) {close(rs);}
            if(pstmt != null) {close(pstmt);}
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
