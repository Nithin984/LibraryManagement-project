package LibrarianActions;

public class Controller {

	LibrarianActions l=null;
	public LibrarianActions BookManage() {
		 l=new BookManage();
		return l;
		
	}
	public LibrarianActions StudentManage() {
		l=new StudentManage();
		return l;
	}
	public LibrarianActions Issue() {
		l=new BookIssue();
		return l;
	}
	public LibrarianActions Return() {
		l=new BookReturn();
		return l;
	
	}
	public LibrarianActions log() {
		 l=new reglog();
		 return l;
	}
	




}
