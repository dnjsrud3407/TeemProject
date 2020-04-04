package vo;

public class CartBean {
	private int cartNum; // 카트에 저장될 카트번호
	private String uID; // 카트에 저장될 사용자 이름
	private String bookImage; // 카트에 저장될 이미지 파일명
	private String bookTitle;//  카트에 저장될 상품명
	private int bookPrice; // 카트에 저장될 상품 가격
	private int bookEA; // 카트에 저장될 상품가격
		
	public int getCartNum() {
		return cartNum;
	}
	public void setCartNum(int cartNum) {
		this.cartNum = cartNum;
	}
	public String getBookImage() {
		return bookImage;
	}
	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public int getBookEA() {
		return bookEA;
	}
	public void setBookEA(int bookEA) {
		this.bookEA = bookEA;
	}
	public CartBean() {
		super();
	}
	public CartBean(int cartNum, String bookImage, String bookTitle, int bookPrice, int bookEA) {
		super();
		this.cartNum = cartNum;
		this.bookImage = bookImage;
		this.bookTitle = bookTitle;
		this.bookPrice = bookPrice;
		this.bookEA = bookEA;
	}
	
	
}

