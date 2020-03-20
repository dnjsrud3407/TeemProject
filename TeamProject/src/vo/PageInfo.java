package vo;

public class PageInfo {
	// 페이징 처리를 위한 페이지 정보를 저장하는 객체
	private int page; // 현재 페이지
	private int maxPage; // 총 페이지 수
	private int startPage; // 시작 페이지
	private int endPage; // 끝 페이지
	private int pageBlock; // 페이징 사이즈 
	private int listCount; // 게시물 수
	
	public PageInfo() {
		super();
	}
	public PageInfo(int page, int maxPage, int startPage, int endPage, int pageBlock, int listCount) {
		super();
		this.page = page;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.pageBlock = pageBlock;
		this.listCount = listCount;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getListCount() {
		return listCount;
	}
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	public int getPageBlock() {
		return pageBlock;
	}
	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}
	
}
