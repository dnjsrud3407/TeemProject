package member.book.svc;

import dao.BookDAO;
import vo.BookBean;

public class QListService {
	
	public BookBean getQuestion(int num) {
		
		BookDAO bookDAO = BookDAO.getInstance();
		
		BookBean questions = bookDAO.selectQuestion(num);
		
		
		return questions;
	}
}
