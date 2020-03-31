package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static db.JdbcUtil.*;

import vo.MemberBean;

public class MemberDAO {
public MemberDAO() {}
	
	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() { 
		return instance;
	}
	// ----------------------------------------------------
	Connection con;

	public void setConnection(Connection con) {
		this.con = con;
	}

	public static MemberBean selectreviews(int num) {
		MemberBean member = null;
		
		return member;
	}

	public boolean isArticleWriter(int num, String parameter) {
		// TODO Auto-generated method stub
		return false;
	}

	public int insertMember(MemberBean member) {
		int insertCount = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql="insert into user values(?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getuID());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getU_name());
			pstmt.setString(4, member.getAddress());
			pstmt.setString(5, member.getPhone_num());
			pstmt.setString(6, member.getEmail());
			pstmt.setString(7, member.getTell_num());
			pstmt.setString(8, member.getAddress2());
			pstmt.setInt(9, member.getPoint());
			pstmt.setInt(10,member.getGrade());
			pstmt.setDate(11, member.getJoinDate());
			
			insertCount = pstmt.executeUpdate();
			System.out.println(insertCount);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return insertCount;
	}

	public int selectMember(MemberBean member) {
		int loginResult = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from user where uID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getuID());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("pw").equals(member.getPw())) {
					loginResult = 1;
					
				} else { 
					loginResult = -1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return loginResult;
	}

	public int selectMemberList() {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM user";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}

	public List<MemberBean> getMemberList() {
		List<MemberBean> memberList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from user";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberBean mb = new MemberBean();
				mb.setuID(rs.getString("uID"));
				mb.setU_name(rs.getString("u_name"));
				mb.setAddress(rs.getString("address"));
				mb.setAddress2(rs.getString("address2"));
				mb.setPoint(rs.getInt("point"));
				mb.setGrade(rs.getInt("grade"));
				memberList.add(mb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);			
		}
		
		return memberList;
	}

	public MemberBean selectMember(String members) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberBean member = null;
		
		try {
			String sql = "select * from user where uID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, members);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				member = new MemberBean();
				member.setuID(rs.getString("uID"));
				member.setPw(rs.getString("pw"));
				member.setU_name(rs.getString("u_name"));
				member.setAddress(rs.getString("address"));
				member.setEmail(rs.getString("email"));
				member.setTell_num(rs.getString("tell_num"));
				member.setAddress2(rs.getString("address2"));
				member.setPoint(rs.getInt("point"));
				member.setGrade(rs.getInt("grade"));
				member.setJoinDate(rs.getDate("joinDate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return member;
	}

	/* 관리자아이디체크 */
//	public boolean isAdminWriter(String uID, String pw) {
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		boolean isAdminWriter = false;
//		
//		try {
//			String sql = "SELECT pw FROM user WHERE uID=?";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, uID);
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) { // 조회 결과가 있을 경우 패스워드가 일치하는 게시물이므로 true 설정
//				isAdminWriter = true;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(rs);
//			close(pstmt);
//		}
//		return isAdminWriter;
//	}
	/* 멤버수정 - 포인트와 그레이드 */
	public int updateMember(MemberBean member) {
		int updateCount = 0;
		
		PreparedStatement pstmt = null;

		try {
//			String sql = "UPDATE board SET board_name=?,board_subject=?,board_content=? WHERE board_num=?";
			String sql = "UPDATE user SET point=?, grade=? WHERE uID=?";
			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, article.getBoard_name());
			pstmt.setInt(1, member.getPoint());
			pstmt.setInt(2, member.getGrade());
			pstmt.setString(3, member.getuID());

			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return updateCount;
	}

	public int deleteMember(String uID) {
		int deleteCount = 0;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "DELETE FROM user WHERE uID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, uID);
			deleteCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return deleteCount;
	}

//	public ArrayList<MemberBean> selectMemberList(int page, int limit) {
//		ArrayList<MemberBean> memberList = new ArrayList<MemberBean>();
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		int startRow = (page - 1) * 10;
//		 
//		try { 
//			String sql = "SELECT * FROM user ORDER BY uID DESC lIMIT ?,?";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, startRow);
//			pstmt.setInt(2, limit);
//			
//			while(rs.next()) {
//				MemberBean memberBean = new MemberBean();
//				memberBean.setuID(rs.getString("uID"));
//				memberBean.setU_name(rs.getString("u_name"));
//				memberBean.setAddress(rs.getString("address"));
//				memberBean.setAddress2(rs.getString("address2"));
//				memberBean.setPoint(rs.getInt("point"));
//				memberBean.setGrade(rs.getInt("grade"));
//				
//				memberList.add(memberBean);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(rs);
//			close(pstmt);
//		}
//		return memberList;
//	}
	
	

}
