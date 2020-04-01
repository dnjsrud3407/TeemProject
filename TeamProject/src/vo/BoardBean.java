package vo;

import java.sql.Timestamp;
import java.util.List;

public class BoardBean {
	
	private int boardNum;
	private String k1;
	private String k2;
	
	private String boardWriter;
	private String boardTitle;
	private String boardContent;
	private Timestamp boardRegTime;
	private int boardReRef;
	private int boardReLev;
	private int boardReSeq;
	private int boardReadcount;
	private int bookID;
	
	private List<FileBean> fileList;
	
	public BoardBean() {}
	
	

	public BoardBean(int boardNum, String k1, String k2, String boardWriter, String boardTitle, String boardContent,
			Timestamp boardRegTime, int boardReRef, int boardReLev, int boardReSeq, int boardReadcount, int bookID,
			List<FileBean> fileList) {
		super();
		this.boardNum = boardNum;
		this.k1 = k1;
		this.k2 = k2;
		this.boardWriter = boardWriter;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardRegTime = boardRegTime;
		this.boardReRef = boardReRef;
		this.boardReLev = boardReLev;
		this.boardReSeq = boardReSeq;
		this.boardReadcount = boardReadcount;
		this.bookID = bookID;
		this.fileList = fileList;
	}
	
	public BoardBean(int boardNum, String k1, String k2, String boardWriter, String boardTitle, String boardContent,
			Timestamp boardRegTime, int boardReRef, int boardReLev, int boardReSeq, int boardReadcount, int bookID) {
		super();
		this.boardNum = boardNum;
		this.k1 = k1;
		this.k2 = k2;
		this.boardWriter = boardWriter;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardRegTime = boardRegTime;
		this.boardReRef = boardReRef;
		this.boardReLev = boardReLev;
		this.boardReSeq = boardReSeq;
		this.boardReadcount = boardReadcount;
		this.bookID = bookID;
	}

	

	public BoardBean(int boardNum, String k1, String k2, String boardTitle, String boardContent,
			List<FileBean> fileList) {
		super();
		this.boardNum = boardNum;
		this.k1 = k1;
		this.k2 = k2;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.fileList = fileList;
	}



	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getK1() {
		return k1;
	}

	public void setK1(String k1) {
		this.k1 = k1;
	}

	public String getK2() {
		return k2;
	}

	public void setK2(String k2) {
		this.k2 = k2;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public Timestamp getBoardRegTime() {
		return boardRegTime;
	}

	public void setBoardRegTime(Timestamp boardRegTime) {
		this.boardRegTime = boardRegTime;
	}

	public int getBoardReRef() {
		return boardReRef;
	}

	public void setBoardReRef(int boardReRef) {
		this.boardReRef = boardReRef;
	}

	public int getBoardReLev() {
		return boardReLev;
	}

	public void setBoardReLev(int boardReLev) {
		this.boardReLev = boardReLev;
	}

	public int getBoardReSeq() {
		return boardReSeq;
	}

	public void setBoardReSeq(int boardReSeq) {
		this.boardReSeq = boardReSeq;
	}

	public int getBoardReadcount() {
		return boardReadcount;
	}

	public void setBoardReadcount(int boardReadcount) {
		this.boardReadcount = boardReadcount;
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public List<FileBean> getFileList() {
		return fileList;
	}

	public void setFileList(List<FileBean> fileList) {
		this.fileList = fileList;
	}

	
}	