package vo;

import java.util.Date;

public class BookBean {
	private int bookID;
    private String bookTitle;
    private String bookOriginImage; // 서버에 저장되는 상품 이미지 이름
    private String bookImage;   // 상품이미지 이름(보여지는)
    private String bookPublisher;   // 출판사
    private Date bookPublishedDate; // 출판일
    private int bookPrice;  // 가격
    private int bookEA; // 상품 재고
    private String bookIntroduce;   // 상품 소개
    private boolean bookisView; // 상품의 공개여부
    private float saveRatio;    // 상품별 포인트 적립률
    
    
    public BookBean(int bookID, String bookTitle, String bookOriginImage, String bookImage, String bookPublisher,
            Date bookPublishedDate, int bookPrice, int bookEA, String bookIntroduce, boolean bookisView,
            float saveRatio) {
        super();
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.bookOriginImage = bookOriginImage;
        this.bookImage = bookImage;
        this.bookPublisher = bookPublisher;
        this.bookPublishedDate = bookPublishedDate;
        this.bookPrice = bookPrice;
        this.bookEA = bookEA;
        this.bookIntroduce = bookIntroduce;
        this.bookisView = bookisView;
        this.saveRatio = saveRatio;
    }
    
    public int getBookID() {
        return bookID;
    }
    public void setBookID(int bookID) {
        this.bookID = bookID;
    }
    public String getBookTitle() {
        return bookTitle;
    }
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    public String getBookOriginImage() {
        return bookOriginImage;
    }
    public void setBookOriginImage(String bookOriginImage) {
        this.bookOriginImage = bookOriginImage;
    }
    public String getBookImage() {
        return bookImage;
    }
    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }
    public String getBookPublisher() {
        return bookPublisher;
    }
    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }
    public Date getBookPublishedDate() {
        return bookPublishedDate;
    }
    public void setBookPublishedDate(Date bookPublishedDate) {
        this.bookPublishedDate = bookPublishedDate;
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
    public String getBookIntroduce() {
        return bookIntroduce;
    }
    public void setBookIntroduce(String bookIntroduce) {
        this.bookIntroduce = bookIntroduce;
    }
    public boolean isBookisView() {
        return bookisView;
    }
    public void setBookisView(boolean bookisView) {
        this.bookisView = bookisView;
    }
    public float getSaveRatio() {
        return saveRatio;
    }
    public void setSaveRatio(float saveRatio) {
        this.saveRatio = saveRatio;
    }
}
