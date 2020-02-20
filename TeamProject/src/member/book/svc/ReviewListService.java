package member.book.svc;

import dao.BookDAO;
import vo.BookBean;

public class ReviewListService {
	
	public BookBean getBooks(int num) {
		
		BookDAO bookDAO = BookDAO.getInstance();
		
		BookBean reviews = bookDAO.selectreviews(num);
		
		
		return reviews;
	}

}
