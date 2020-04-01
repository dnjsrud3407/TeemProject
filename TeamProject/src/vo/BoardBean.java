package vo;

import java.util.Date;

public class BoardBean {
	private int boardNum;
	private int kID;
	private String boardWriter;
	private String boardTitle;
	private String boardContent;
	private Date boardRegTime;
	private int boardReRef;
	private int boardReLev;		// 질문인지(0) or 답변인지(1) 판정
	private int boardReSeq;		// 답변됐는지(1), 안됐는지(0) 판정
	private int boardReadCount;
	private int bookID;
	private String k1;
	private String k2;
	private String k3;
	private String bookTitle;
	
	public BoardBean() {
		super();
	}
	
	// 문의 내역 불러올때 사용
	public BoardBean(int boardNum, String boardWriter, String boardTitle, String boardContent,
			Date boardRegTime, int boardReRef, int boardReLev, int boardReSeq, int bookID, String bookTitle) {
		super();
		this.boardNum = boardNum;
		this.boardWriter = boardWriter;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardRegTime = boardRegTime;
		this.boardReRef = boardReRef;
		this.boardReLev = boardReLev;
		this.boardReSeq = boardReSeq;
		this.bookID = bookID;			
		this.bookTitle = bookTitle;
	}
	
	// 게시글 답변 작성 시 사용
	public BoardBean(int boardNum, int kID, String boardWriter, String boardTitle, String boardContent, int boardReRef,
			int boardReLev, int bookID) {
		super();
		this.boardNum = boardNum;
		this.kID = kID;
		this.boardWriter = boardWriter;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardReRef = boardReRef;
		this.boardReLev = boardReLev;
		this.bookID = bookID;
	}
	

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public int getkID() {
		return kID;
	}
	public void setkID(int kID) {
		this.kID = kID;
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
	public Date getBoardRegTime() {
		return boardRegTime;
	}
	public void setBoardRegTime(Date boardRegTime) {
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
	public int getBoardReadCount() {
		return boardReadCount;
	}
	public void setBoardReadCount(int boardReadCount) {
		this.boardReadCount = boardReadCount;
	}
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
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
	public String getK3() {
		return k3;
	}
	public void setK3(String k3) {
		this.k3 = k3;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	
}
