package LibrarianActions;

import Dto.Book;
import Dto.Librarian;
import Dto.Student;

public interface LibrarianActions {
	String addbook(String name,String Author,String subject,int quantity);
	String deletebook(int bid);
	String updatebook(Book Book);
	Book searchbook(int bid);
	String addstudent(String name,String branch,long conno);
	String  deletestudent(int sid);
	String updatestudent(Student student);
	Student searchstudent(int sid);
	String issuebook(int sid,int bid);
	int returnbook(int sid,int bid);
	String Studentreg(Student student);
	String Studentlog(String email,String password);
	String Librarianreg(Librarian L);
	String Librarianlog(String email,String password);
	
	
}
