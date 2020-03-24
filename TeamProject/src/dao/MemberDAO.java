package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

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

	public int updateMember(MemberBean member) {
		// TODO Auto-generated method stub
		return 0;
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
	
	public int memberList() {

		
		return 0;
	}

}
