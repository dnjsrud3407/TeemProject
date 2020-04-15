package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.BoardBean;
import vo.FileBean;
import vo.PageInfo;

import static db.JdbcUtil.*;

public class BoardDAO {
	public BoardDAO() {}
	
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null; 

	public void setConnection(Connection con) {
		this.con = con;
	}
	////////////////////////////////////////////////////////////////////////////

	// ************카테고리 번호(kID)를 가져오는 메서드 get_kID(k2가 null인 애들)
			public int get_kID(String k1) {
				int kID = -1;
				
				String sql = "SELECT kID FROM kategorie Where k1=?";
				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, k1);
										
					rs = pstmt.executeQuery();
					
					if(rs.next()) {
						kID = rs.getInt(1);
						System.out.println(kID);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(rs); close(pstmt);
				}
				System.out.println(kID);
				return kID;
			}
	
	// ************카테고리 번호(kID) 를 가져오는 메서드 get_kId(k2가 null이 아닌 애들)
		public int get_kID(String k1, String k2) {
			int kID = -1;
			String sql = "SELECT kID FROM kategorie Where k1=? and k2=?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, k1);
				pstmt.setString(2, k2);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					kID = rs.getInt(1);
					System.out.println(kID);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rs); close(pstmt);
			}
			System.out.println(kID);
			return kID;
		}
	// ***************해당 대분류(k1)에서 가장 큰 글 번호를 가져오는 메서드 getMaxNum
	public int getMaxNum(String k1) {
		int maxNum = 0;
		
		String sql = "SELECT MAX(boardNum) FROM board WHERE kID IN (SELECT kID FROM kategorie WHERE k1=?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, k1);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				maxNum = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); close(pstmt);
		}
		
		return maxNum;
	}
	//
	//
	//
	//
	//  글 작성
	
	public int insertArticle(BoardBean bb) {
		int insertCount = 0;
		int kID = 0;
		
		if(bb.getK2() != null) {
			kID = get_kID(bb.getK1(), bb.getK2()); //  1:1 문의 답변 용으로 따로 체크해야함
		} else {
			kID = get_kID(bb.getK1());
		}
		
		System.out.println(kID);
		String sql = "INSERT INTO board values(?, ?, ?, ?,"
				+ " ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bb.getBoardNum()); pstmt.setInt(2, kID); pstmt.setString(3, bb.getBoardWriter());
			pstmt.setString(4, bb.getBoardTitle()); pstmt.setString(5, bb.getBoardContent());
			pstmt.setTimestamp(6, bb.getBoardRegTime()); pstmt.setInt(7, bb.getBoardReRef()); 
			pstmt.setInt(8, bb.getBoardReLev()); pstmt.setInt(9, bb.getBoardReSeq()); 
			pstmt.setInt(10, bb.getBoardReadcount()); pstmt.setInt(11, bb.getBookID());
			insertCount = pstmt.executeUpdate();
//			int update = pstmt.executeUpdate();
//			if(update != 0) {
//				if(bb.getFileList().size() != 0) {
//					bb.getFileList().size();
//					insertCount = insertFile(bb, kID);
//				} else {
//					insertCount = update;
//				}
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return insertCount;
	}
	
	
	// 글 쓸때 파일을 같이 업로드 하는 insertFile 메서드
	public int insertFile(BoardBean  bb, int kID) {
		int insertCount = 0;
		int count = 0;
		int listSize = bb.getFileList().size();
		try {
			for(FileBean file : bb.getFileList()) {
				String sql = "INSERT INTO boardFile VALUES(null, ?, ?, ?, ?, ?, ?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, file.getOriginFilename());
				pstmt.setString(2, file.getstoredFileName());
				pstmt.setString(3, file.getFileType());
				pstmt.setInt(4, bb.getBoardNum());
				pstmt.setInt(5, kID);
				pstmt.setString(6, bb.getBoardWriter());
			
				count += pstmt.executeUpdate();
			}
			if(count != listSize) {
				// DB에 업로드 되지 않은 파일이 있을 경우 insertCount는 0이다.
			} else {
				insertCount = 1; // DB에 모든 파일이 업로드 되었을 경우 1을 반환
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return insertCount;
	}
	
	
	// 글작성
	//
	//
	//
	//
	//
	//
	//
	//
	//-------------------------------------------------------------------------------
	// 글 내용 보는 메서드들
	
	public BoardBean selectArticle(int boardNum, String k1, String k2) {
		BoardBean bb = null;
		int kID = get_kID(k1, k2);
		
		String sql = "SELECT * FROM board WHERE boardNum=? AND kID=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardNum); pstmt.setInt(2, kID);
			
			rs = pstmt.executeQuery();
			
			if(rs != null) {
				bb = new BoardBean(rs.getInt("boardNum"), rs.getString("k1"), rs.getString("k2"),
						rs.getString("boardWriter"), rs.getString("boardTitle"), rs.getString("boardContent"),
						rs.getTimestamp("boardRegTime"), rs.getInt("boardReRef"), rs.getInt("boardReLev"),
						rs.getInt("boardReSeq"), rs.getInt("boardReadcount"), rs.getInt("bookID"));
				bb.setFileList(selectFileList(boardNum, kID));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); close(pstmt);
		}
		
		return bb;
	}
	// 파일 가져오기
	public List<FileBean> selectFileList(int boardNum, int kID) {
		
		List<FileBean> fileList = new ArrayList<FileBean>();
		FileBean file = null;
		
		String sql = "SELECT * FROM boardFile WHERE board_boardNum=? AND board_kID=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			pstmt.setInt(2, kID);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				file = new  FileBean(rs.getInt("fileNum"), rs.getString("originFilename"),
						rs.getString("storedFileName"), rs.getString("fileType"),
						rs.getInt("board_boardNum"), rs.getInt("board_kID"),
						rs.getString("board_boardWriter"));
				fileList.add(file);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); close(pstmt);
		}
		
		
		return fileList;
	}
	
	public int get_kID(int boardNum, String k1) {
		int kID = -1;
		
		String sql = "SELECT b.kID FROM board b JOIN kategorie k ON b.kID=k.kID WHERE b.boardNum=? AND k.k1=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardNum); pstmt.setString(2, k1);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				kID = rs.getInt("b.kID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); close(pstmt);
		}
		
		
		return kID;
	}
	
	// 조회수 증가 메서드
		public int increaseReadCount(int boardNum, int kID) {
			int updateCount = 0;
			
			String sql = "UPDATE board SET readCount=readCount+1 WHERE boardNum=? AND kID=?";
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, boardNum); pstmt.setInt(2, kID);
				updateCount = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
			return updateCount;
		}
	
	
	

	
	
	
	//
	//
	//-------------------------------------------------------------------------------
	// 글 내용 보는 메서드들
	
	// 글 삭제하는 메서드들
	
		public int deleteArticle(int boardNum, String k1, String k2) {
			int deleteCount = 0;
			int kID = get_kID(k1, k2);
			
			List<FileBean> fileList = selectFileList(boardNum, kID);
			
			if(fileList.size() > 0) {
				int deleteFile = deleteAllFile(boardNum, kID);
				if(deleteFile == 0) {
					return 0;
				}
			}
			String sql = "DELETE FROM board WHERE boardNum=? AND kID=?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, boardNum); pstmt.setInt(2, kID);
				
				int delete = pstmt.executeUpdate();
				if(delete != 0) {
					deleteCount = deleteAllFile(boardNum, kID);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			return deleteCount;
		}
	
		public int deleteAllFile(int boardNum, int kID) {
			int deleteFile = 0;
			
			String sql = "DELETE FROM boardFile WHERE board_boardNum=? AND board_kID=?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, boardNum); pstmt.setInt(2, kID);
				
				deleteFile = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
			return deleteFile;
		}
	
	
	
	
	
	//
	//
	// 글 수정하는 메서드들

	public int updateArticle(BoardBean bb, List<String> deleteFileName) {
		int updateCount = 0;
		
		int kID = get_kID(bb.getK1(), bb.getK2());
		int delFile = deleteFile(bb, deleteFileName, kID);
		
		if(delFile != 0) {
			String sql = "UPDATE board SET boardTitle=?, boardContent=? WHERE boardNum=? AND kID=?";
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, bb.getBoardTitle()); pstmt.setString(2, bb.getBoardContent());
				pstmt.setInt(3, bb.getBoardNum()); pstmt.setInt(4, kID);
				
				updateCount = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		}
		
		
		return updateCount;
	}

	public int deleteFile(BoardBean bb, List<String> deleteFileName, int kID) {
		int deleteCount = 0;
		
		String sql = "DELETE FROM boardFile WHERE storedFileName=? ADN board_boardNum=? AND board_kID=?";
		
		for(String delFileName : deleteFileName) {
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, delFileName);
				pstmt.setInt(2, bb.getBoardNum());
				pstmt.setInt(3, kID);
				
				deleteCount += pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		}
		
		if(deleteCount != deleteFileName.size()) {
			deleteCount = 0;
		}
		
		return deleteCount;
	}

	
	// 글 목록 관련 메서드
	
	
	public int selectListCount(String k1, String k2) {
		int listCount = 0;
		String sql = "";
		
		if(k2 != null) {
			sql = "SELECT count(*) FROM board Where k1=? AND k2=?";
		} else {
			sql = "SELECT count(*) FROM board WHERE k1=?";
		}
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, k1);
			if(k2 != null) { pstmt.setString(2, k2); }
			rs = pstmt.executeQuery();
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); close(pstmt);
		}
		
		return listCount;
	}
	
	public ArrayList<BoardBean> selectArticleList(PageInfo pageInfo) {
		// 게시물 목록 조회 후 리턴
		ArrayList<BoardBean> articleList = new ArrayList<BoardBean>();
		
		int page = pageInfo.getPage();
		int limit = pageInfo.getLimit();
		String k1 = pageInfo.getK1();
		String k2 = pageInfo.getK2();
		/* 
		 * 전체 게시물 중 원하는 페이지의 게시물 첫번째 row 번호 설정
		 * - 원본 글 번호(board_re_ref) 기준으로 내림차순 정렬
		 * - 글 순서번호(board_re_seq) 기준으로 오름차순 정렬
		 * - 조회할 게시물 갯수 : 첫번째 게시물 위치 ~ limit 수 만큼
		 *   첫번째 게시물 위치 = (현재페이지 - 1) * 10
		 * 
		 * ex) 현재 페이지(page) 가 1 페이지 일 경우 : 게시물 조회 결과의 0번 행부터 10개 가져오기
		 */
		int startRow = (page - 1) * 10; // 첫번째 게시물 행(row) 번호 계산
		String sql ="";
		
		try {
//			 조회 결과(ResultSet) 객체가 존재할 경우
//			 반복문을 사용하여 1개 게시물 정보(패스워드 제외한 나머지)를 BoardBean 객체에 저장하고
//			 BoardBean 객체를 ArrayList<BoardBean> 객체에 저장 반복
			if(k2 != null) {
				sql = "SELECT * FROM board WHERE k1=? AND k2=? ORDER BY board_re_ref DESC, board_re_seq ASC LIMIT ?,?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, k1); pstmt.setString(2, k2);
				pstmt.setInt(3, startRow); pstmt.setInt(4, limit);
			} else {
				sql = "SELECT * FROM board WHERE k1=? ORDER BY board_re_ref DESC, board_re_seq ASC LIMIT ?,?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, k1);
				pstmt.setInt(2, startRow); pstmt.setInt(3, limit);
			}
            rs = pstmt.executeQuery();
            
            // ResultSet 객체 내의 모든 레코드를 각각 레코드별로 BoardBean 에 담아서 ArrayList 객체에 저장
            // => 패스워드 제외
            while(rs.next()) {
                BoardBean boardBean = new BoardBean();
                boardBean.setBoardNum(rs.getInt("boardNum"));
                boardBean.setBoardWriter(rs.getString("boardWriter"));
                boardBean.setBoardTitle(rs.getString("boarTitle"));
                boardBean.setBoardContent(rs.getString("boardContent"));
                boardBean.setBoardRegTime(rs.getTimestamp("boardRegTime"));
                boardBean.setBoardReRef(rs.getInt("boardReRef"));
                boardBean.setBoardReLev(rs.getInt("boardReLev"));
                boardBean.setBoardReSeq(rs.getInt("boardReSeq"));
                boardBean.setBoardReadcount(rs.getInt("boardReadcount"));
                
                articleList.add(boardBean);
            }
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return articleList;
	}

	
	// 상품문의  게시판 불러 올 때 사용
	public ArrayList<BoardBean> selectArticleList(PageInfo pageInfo, int bookID) {
		// 게시물 목록 조회 후 리턴
		ArrayList<BoardBean> articleQnaList = new ArrayList<BoardBean>();
		
		int page = pageInfo.getPage();
		int limit = pageInfo.getLimit();
		String k1 = pageInfo.getK1();
		String k2 = pageInfo.getK2();
		int kID = get_kID(k1);
		/* 
		 * 전체 게시물 중 원하는 페이지의 게시물 첫번째 row 번호 설정
		 * - 원본 글 번호(board_re_ref) 기준으로 내림차순 정렬
		 * - 글 순서번호(board_re_seq) 기준으로 오름차순 정렬
		 * - 조회할 게시물 갯수 : 첫번째 게시물 위치 ~ limit 수 만큼
		 *   첫번째 게시물 위치 = (현재페이지 - 1) * 10
		 * 
		 * ex) 현재 페이지(page) 가 1 페이지 일 경우 : 게시물 조회 결과의 0번 행부터 10개 가져오기
		 */
		int startRow = (page - 1) * 10; // 첫번째 게시물 행(row) 번호 계산
		String sql ="";
		
		try {
//			 조회 결과(ResultSet) 객체가 존재할 경우
//			 반복문을 사용하여 1개 게시물 정보(패스워드 제외한 나머지)를 BoardBean 객체에 저장하고
//			 BoardBean 객체를 ArrayList<BoardBean> 객체에 저장 반복
			if(k2 != null) {
				sql = "SELECT * FROM board WHERE k1=? AND k2=? ORDER BY board_re_ref DESC, board_re_seq ASC LIMIT ?,?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, k1); pstmt.setString(2, k2);
				pstmt.setInt(3, startRow); pstmt.setInt(4, limit);
			} else {
				sql = "SELECT * FROM board WHERE bookID=? and kID= (select kID from kategorie where kID=102)"
						+ "order by boardReRef DESC, boardReSeq ASC limit ?,?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, bookID);
				pstmt.setInt(2, startRow); 
				pstmt.setInt(3, limit);
			}
            rs = pstmt.executeQuery();
            
            // ResultSet 객체 내의 모든 레코드를 각각 레코드별로 BoardBean 에 담아서 ArrayList 객체에 저장
            // => 패스워드 제외
            while(rs.next()) {
                BoardBean boardBean = new BoardBean();
                boardBean.setBoardNum(rs.getInt("boardNum"));
                boardBean.setBoardWriter(rs.getString("boardWriter"));
                boardBean.setBoardTitle(rs.getString("boardTitle"));
                boardBean.setBoardContent(rs.getString("boardContent"));
                boardBean.setBoardRegTime(rs.getTimestamp("boardRegTime"));
                boardBean.setBoardReRef(rs.getInt("boardReRef"));
                boardBean.setBoardReLev(rs.getInt("boardReLev"));
                boardBean.setBoardReSeq(rs.getInt("boardReSeq"));
                boardBean.setBoardReadcount(rs.getInt("boardReadcount"));
                
                articleQnaList.add(boardBean);
            }
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return articleQnaList;
	}

	// 하나의 책 상품에 대한 문의 글 전체 갯수
	public int qnaListCount(int bookID, int kID) {
		int listCount = 0;
		String sql = "";

		sql = "SELECT count(*) FROM board WHERE bookID=? and kID=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bookID);
			pstmt.setInt(2, kID);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				listCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

			return listCount;
	}
	
	
	// 글번호에 맞는 상품문의 글 가져오기
	public BoardBean getQuestion(int boardNum ) {
		// TODO Auto-generated method stub
		BoardBean boardBean = new BoardBean();
			
		String sql = "select * from board where boardNum =? ";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
                boardBean.setBoardNum(rs.getInt("boardNum"));
                boardBean.setBoardWriter(rs.getString("boardWriter"));
                boardBean.setBoardTitle(rs.getString("boardTitle"));
                boardBean.setBoardContent(rs.getString("boardContent"));
                boardBean.setBoardRegTime(rs.getTimestamp("boardRegTime"));
                boardBean.setBoardReRef(rs.getInt("boardReRef"));
                boardBean.setBoardReLev(rs.getInt("boardReLev"));
                boardBean.setBoardReSeq(rs.getInt("boardReSeq"));
                boardBean.setBoardReadcount(rs.getInt("boardReadcount"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return boardBean;
	}

		
	
	// ====================== 상품 문의, 후기 관리자 메서드 ==================================
	// 상품 문의, 후기 게시글 개수 가져오기
	public int selectListCount(int kID) {
		int listCount = 0;
        String sql = "SELECT COUNT(*) FROM board JOIN book ON board.bookID = book.bookID"
        		+ " WHERE kID=? AND boardReLev=?";
        try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, kID);
			pstmt.setInt(2, 0);
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

	// 상품 문의, 후기 게시글 들고오기
	public ArrayList<BoardBean> selectList(int kID, int page, int limit) {
		ArrayList<BoardBean> qList = new ArrayList<BoardBean>();
        // 답변 안 된 글(boardReSeq=0)이 우선적으로 보여지고
        // 다음에는 최근글 부터 보여짐
        String sql = "SELECT board.*, book.bookTitle FROM board"
        		+ " JOIN book ON board.bookID = book.bookID"
        		+ " WHERE kID=? AND boardReLev=?"
        		+ " ORDER BY boardReSeq asc, boardReRef desc LIMIT ?,?";
		int startRow = (page - 1) * limit;
        try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, kID);
			pstmt.setInt(2, 0);	// 문의글만 보기
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, limit);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardBean board = new BoardBean(
						rs.getInt("boardNum"), 
						rs.getString("boardWriter"), 
						rs.getString("boardTitle"), 
						rs.getString("boardContent"), 
						rs.getTimestamp("boardRegTime"), 
						rs.getInt("boardReRef"), 
						rs.getInt("boardReLev"), 
						rs.getInt("boardReSeq"), 
						rs.getInt("bookID"), 
						rs.getString("bookTitle")
						);
				
				qList.add(board);
			}
			
			setAnswerRegTime(qList);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            if(rs != null) {close(rs);}
            if(pstmt != null) {close(pstmt);}
        }
		
		return qList;
	}

	// selectList 에서 호출되는 함수 - 답글이 달린 경우 답변된 날짜 set 시켜줌
	void setAnswerRegTime(ArrayList<BoardBean> qList) {
        String sql = null;
        
		for(int i = 0; i < qList.size(); i++) {
			BoardBean board = qList.get(i);
			
			// 만약 답글이 달린 경우 - board.setBoardAnswerRegTime() 호출
			if(board.getBoardReSeq() > 0) {
				sql = "SELECT boardRegTime" 
							+ " FROM board"
							+ " WHERE boardReRef=? AND boardReLev=?";
				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, board.getBoardReRef());
					pstmt.setInt(2, 1);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						board.setBoardAnswerRegTime(rs.getTimestamp(1));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
		            if(rs != null) {close(rs);}
		            if(pstmt != null) {close(pstmt);}
		        }
				
			}
			
		}
	}
	
	// 사용자 문의, 후기글 가져오기
	public BoardBean selectBoard(int boardNum) {
		BoardBean board = null;
        String sql = "SELECT board.*, book.bookTitle FROM board" + 
        		" JOIN book ON board.bookID = book.bookID WHERE boardNum=?";
        try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				board = new BoardBean(
						boardNum, 
						rs.getString("boardWriter"), 
						rs.getString("boardTitle"), 
						rs.getString("boardContent"), 
						rs.getTimestamp("boardRegTime"), 
						rs.getInt("boardReRef"), 
						rs.getInt("boardReLev"), 
						rs.getInt("boardReSeq"), 
						rs.getInt("bookID"), 
						rs.getString("bookTitle")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            if(rs != null) {close(rs);}
            if(pstmt != null) {close(pstmt);}
        }
        
		return board;
	}

	// 문의, 후기 답변 등록 시 게시글 번호 구하기 (게시글 중 최대값 구하기)
	public int selectMaxNum() {
		int maxNum = 0;
	    String sql = "SELECT MAX(boardNum) FROM board";
	    try {
	        pstmt = con.prepareStatement(sql);
	        rs = pstmt.executeQuery();
	        if(rs.next()) {
	            maxNum = rs.getInt(1) + 1;  // 게시글 번호 최대값 + 1
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if(rs != null) {close(rs);}
	        if(pstmt != null) {close(pstmt);}
	    }
	    
		return maxNum;
	}
	
	// 상품 문의, 후기 답변 등록 하기
	public int insertAnswerBoard(BoardBean board) {
		int insertCount = 0;
	    String sql = "INSERT INTO board(boardNum,kID,boardWriter,boardTitle,boardContent,boardRegTime,boardReRef,boardReLev,bookID)"
	    		+ "VALUES (?,?,?,?,?,now(),?,?,?)";
	    try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board.getBoardNum());
			pstmt.setInt(2, board.getkID());
			pstmt.setString(3, board.getBoardWriter());
			pstmt.setString(4, board.getBoardTitle());
			pstmt.setString(5, board.getBoardContent());
			pstmt.setInt(6, board.getBoardReRef());
			pstmt.setInt(7, board.getBoardReLev());
			pstmt.setInt(8, board.getBookID());
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	        if(pstmt != null) {close(pstmt);}
	    }
	    
	    return insertCount;
	}

	// 상품 문의, 후기 답변 등록 성공 시 문의 글 Seq+1 시키기
	public int updateReSeqPlus(int boardReRef) {
		int insertCount = 0;
		String sql = "UPDATE board SET boardReSeq=boardReSeq+1 WHERE boardNum=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardReRef);
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	        if(pstmt != null) {close(pstmt);}
	    }
		
		return insertCount;
	}
	
	// 상품 문의, 후기 글과, 관리자가 답변한 글 모두 가져옴 - 답변 작성 후 수정시에 사용
	public ArrayList<BoardBean> selectqnaList(int boardReRef) {
		ArrayList<BoardBean> qnaList = new ArrayList<BoardBean>();
	    String sql = "SELECT board.*, book.bookTitle FROM board" + 
        		" JOIN book ON board.bookID = book.bookID WHERE boardReRef=?";
	    try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardReRef);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardBean board = new BoardBean(
						rs.getInt("boardNum"), 
						rs.getString("boardWriter"), 
						rs.getString("boardTitle"), 
						rs.getString("boardContent"), 
						rs.getTimestamp("boardRegTime"), 
						rs.getInt("boardReRef"), 
						rs.getInt("boardReLev"), 
						rs.getInt("boardReSeq"), 
						rs.getInt("bookID"), 
						rs.getString("bookTitle")
						);
				qnaList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	        if(rs != null) {close(rs);}
	        if(pstmt != null) {close(pstmt);}
	    }
		
		return qnaList;
	}

	// 상품 문의, 후기 답변 수정 하기
	public int updateAnswerBoard(BoardBean board) {
		int updateCount = 0;
		String sql = "UPDATE board SET boardWriter=?, boardTitle=?, boardContent=?, boardRegTime=now() WHERE boardNum=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getBoardWriter());
			pstmt.setString(2, board.getBoardTitle());
			pstmt.setString(3, board.getBoardContent());
			pstmt.setInt(4, board.getBoardNum());
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	        if(pstmt != null) {close(pstmt);}
	    }
		
		return updateCount;
	}

	// 상품 문의, 후기 글 검색한 게시글 개수 구하기
	public int getSearchListCount(int kID, String boardRegTime_Before, String boardRegTime_After, String searchSql) {
		int listCount = 0;
		String sql = "SELECT COUNT(*) FROM board JOIN book ON board.bookID = book.bookID"
				+ " WHERE kID=? AND boardReLev=? AND DATE(boardRegTime) BETWEEN ? AND ?" + searchSql;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, kID);	
			pstmt.setInt(2, 0);		// 답변인 글만 가져옴
			pstmt.setString(3, boardRegTime_Before);
			pstmt.setString(4, boardRegTime_After);
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

	// 상품 문의, 후기 글 검색한 게시글 리스트
	public ArrayList<BoardBean> getSearchBoardList(int kID, String boardRegTime_Before, String boardRegTime_After,
			String searchSql, int page, int limit) {
		ArrayList<BoardBean> qSearchList = new ArrayList<BoardBean>();
		String sql = "SELECT board.*, book.bookTitle FROM board"
        		+ " JOIN book ON board.bookID = book.bookID"
        		+ " WHERE kID=? AND boardReLev=?"
        		+ " AND DATE(boardRegTime) BETWEEN ? AND ?" + searchSql 
        		+ " ORDER BY boardReSeq asc, boardReRef desc LIMIT ?,?";
		int startRow = (page - 1) * limit;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, kID);
			pstmt.setInt(2, 0);
			pstmt.setString(3, boardRegTime_Before);
			pstmt.setString(4, boardRegTime_After);
			pstmt.setInt(5, startRow);
			pstmt.setInt(6, limit);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardBean board = new BoardBean(
						rs.getInt("boardNum"), 
						rs.getString("boardWriter"), 
						rs.getString("boardTitle"), 
						rs.getString("boardContent"), 
						rs.getTimestamp("boardRegTime"), 
						rs.getInt("boardReRef"), 
						rs.getInt("boardReLev"), 
						rs.getInt("boardReSeq"), 
						rs.getInt("bookID"), 
						rs.getString("bookTitle")
						);
				qSearchList.add(board);
			}
			
			setAnswerRegTime(qSearchList);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	        if(rs != null) {close(rs);}
	        if(pstmt != null) {close(pstmt);}
	    }
		
		return qSearchList;
	}
	
	// 상품 문의, 후기 답변 글 삭제하기
	public int deleteBoard(int boardReref) {
		int deleteCount = 0;
		String sql = "DELETE FROM board WHERE boardReref=? AND boardReLev=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardReref);
			pstmt.setInt(2, 1);
			deleteCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	        if(pstmt != null) {close(pstmt);}
	    }
		
		return deleteCount;
	}
	
	// 상품 문의, 후기 답변 등록 성공 시 문의 글 Seq-1 시키기 (단, 답변이 달린경우만 삭제(oardReSeq=1))
	public int updateReSeqMinus(int boardReRef) {
		int insertCount = 0;
		String sql = "UPDATE board SET boardReSeq=boardReSeq-1 WHERE boardNum=? AND boardReSeq=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardReRef);
			pstmt.setInt(2, 1);
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	        if(pstmt != null) {close(pstmt);}
	    }
		
		return insertCount;
	}
	
	// 후기 답변 시 유저 포인트 올리기
	public int updateMemberPoint(String uID) {
		int updateCount = 0;
		String sql = "UPDATE user SET point=point+500 WHERE uID=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, uID);
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	        if(pstmt != null) {close(pstmt);}
	    }
		
		return updateCount;
	}


	// 포인트 히스토리 max(pID) 구하기
	public int selectpIDMaxNum() {
		int pID = 0;
		String sql = "SELECT MAX(pID) FROM pointhistory";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pID = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	        if(rs != null) {close(rs);}
	        if(pstmt != null) {close(pstmt);}
	    }
		
		return pID;
	}
	
	// 포인트 히스토리 insert 
	public int insertPointHistory(int pID, String uID) {
		int insertPointHistory = 0;
		String sql = "INSERT INTO pointhistory VALUES(?,?,now(),?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, pID);
			pstmt.setString(2, uID);
			pstmt.setString(3, "책 후기 적립금");
			pstmt.setInt(4, 500);
			pstmt.setBoolean(5, true);
			
			insertPointHistory = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	        if(pstmt != null) {close(pstmt);}
	    }
		
		return insertPointHistory;
	}
	
	
	//-----------사용자 1:1 문의 글 등록----------------------------------------------
    //헷갈리지 않게 1:1 = OneOnOne 
	public Boolean insertOneOnOne(String kakegoire, BoardBean boardBean) {
		Boolean isSuccess = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num=0;
		
		System.out.println("BoardDAO.insertOneOnOne(String kakegoire, BoardBean boardBean)");
		
		
		try {
			
			String sql = "select max(boardNum) from board";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				num=rs.getInt("max(boardNum)")+1; 
			}
			
			
			sql="insert into board value(?,?,?,?,?,now(),?,?,?,0,null)";
			pstmt=con.prepareStatement(sql);
			
			pstmt.setInt(1,num); 
			pstmt.setInt(2, boardBean.getkID()); 
			pstmt.setString(3,boardBean.getBoardWriter());
			pstmt.setString(4, boardBean.getBoardTitle());
			pstmt.setString(5, boardBean.getBoardContent());
			pstmt.setInt(6,num);//re_ref
			pstmt.setInt(7,0);//re_lev
			pstmt.setInt(8,0);//re_seq
			pstmt.executeUpdate();
			
			
			sql="insert into boardfile value(null,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,boardBean.getOriginFileName());
			pstmt.setString(2, boardBean.getStoredFileName());
			pstmt.setString(3, boardBean.getFileType());
			pstmt.setInt(4,num);//re_ref
			pstmt.setInt(5,boardBean.getkID());//re_ref
			pstmt.setString(6, boardBean.getBoardWriter());
			pstmt.executeUpdate();
			
			isSuccess=true;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			close(pstmt);
			close(rs);
		}
		return isSuccess;
	}
	
	
	
	// 1:1문의 게시글 가져오기 

	public ArrayList<BoardBean> getOneonOneQList(String uID) {
		
		System.out.println("BoardDAO.getOneonOneQList(String uID)");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BoardBean> QList = null;
		int num = 0; //첫번째 join문이 true라면 boardNum의 값을 저장시킬 변수
		
		try {
			
			String sql="select *\r\n" + 
					"from board b left outer join boardfile f\r\n" + 
					"on b.boardNum = f.board_boardNum where b.boardWriter=? or b.boardWriter='admin'";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, uID);
			rs = pstmt.executeQuery();
			
			
			BoardBean boardBean = null;
			QList = new ArrayList<BoardBean>();
			
			
			while (rs.next()) {
				boardBean = new BoardBean(
						rs.getInt("boardNum"),
						rs.getInt("kID"), 
						rs.getString("boardWriter"),
						rs.getString("boardTitle"),
						rs.getString("boardContent"), 
						rs.getInt("boardReRef"),
						rs.getInt("boardReLev"), 
						rs.getInt("boardReSeq"), 
						rs.getInt("boardReadcount"),
						rs.getTimestamp("boardRegTime"),
						rs.getInt("bookID"),
						rs.getString("storedFileName"));
				QList.add(boardBean);
			}

			
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
				close(rs);
				
			}
		
			return QList;
		}

	//1:1문의  상세내용보기
	public BoardBean getOneonOnegetArticle(int boardNum) {
		System.out.println("BoardDAO.getOneonOnegetArticle(int boardNum)");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardBean boardBean = null;
		
		try {
			
			String sql="select *\r\n" + 
					"from board b left outer join boardfile f\r\n" + 
					"on b.boardNum = f.board_boardNum where b.boardNum=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			rs = pstmt.executeQuery();
			
			
			if (rs.next()) {
				boardBean = new BoardBean(
						rs.getInt("boardNum"),
						rs.getInt("kID"), 
						rs.getString("boardWriter"),
						rs.getString("boardTitle"),
						rs.getString("boardContent"), 
						rs.getInt("boardReRef"),
						rs.getInt("boardReLev"), 
						rs.getInt("boardReSeq"), 
						rs.getInt("boardReadcount"),
						rs.getTimestamp("boardRegTime"),
						rs.getInt("bookID"),
						rs.getString("storedFileName"));
			}//if
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return boardBean;
	}

	//1:1문의  답변
	public BoardBean getOneonOnegetAnswer(int boardNum) {
		System.out.println("BoardDAO.getOneonOnegetAnswer(int boardNum)");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardBean boardBean2 = null;

		try {
			
			String sql="select * from board where boardReRef=? and boardWriter='admin'";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			rs = pstmt.executeQuery();
			
			
			if (rs.next()) {
				boardBean2 = new BoardBean(
						rs.getInt("boardNum"),
						rs.getInt("kID"), 
						rs.getString("boardWriter"),
						rs.getString("boarTitle"),
						rs.getString("boardContent"), 
						rs.getInt("boardReRef"),
						rs.getInt("boardReLev"), 
						rs.getInt("boardReSeq"), 
						rs.getInt("boardReadcount"),
						rs.getTimestamp("boardRegTime"),
						rs.getInt("bookID"));
				System.out.println(	rs.getInt("boardNum"));
			}else {
				System.out.println("답변없음");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return boardBean2;
	}

	// 상품문의 수정
	public int updateQuestion(BoardBean boardBean) {
		int updateCount = 0;
		String sql = "";

		try {
			sql = "select * from board where boardNum = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardBean.getBoardNum());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (boardBean.getBoardWriter().equals(rs.getString("boardWriter"))) {
					sql = "update board set boardTitle=? , boardContent=? where boardNum=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, boardBean.getBoardTitle());
					pstmt.setString(2, boardBean.getBoardContent());
					pstmt.setInt(3, boardBean.getBoardNum());

					updateCount = pstmt.executeUpdate();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return updateCount;
	}

	// 상품문의 삭제
	public int removeQuestion(BoardBean boardBean) {
		int deleteCount = 0;
		
		String sql = "";

		try {
			sql = "select * from board where boardNum = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardBean.getBoardNum());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (boardBean.getBoardWriter().equals(rs.getString("boardWriter"))) {
					sql = "delete from board where boardNum=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, boardBean.getBoardNum());
					deleteCount = pstmt.executeUpdate();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return deleteCount;
	}


	

	

	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

