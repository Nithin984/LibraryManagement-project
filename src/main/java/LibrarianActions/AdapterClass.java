package LibrarianActions;

import Dto.Book;
import Dto.Librarian;
import Dto.Student;

public class AdapterClass implements LibrarianActions {

	@Override
	public String Studentreg(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Studentlog(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Librarianreg(Librarian L) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Librarianlog(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addbook(String name, String Author, String subject, int quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletebook(int bid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updatebook(Book Book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book searchbook(int bid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addstudent(String name, String branch, long conno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletestudent(int sid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updatestudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student searchstudent(int sid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String issuebook(int sid, int bid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int returnbook(int sid, int bid) {
		// TODO Auto-generated method stub
		return 0;
	}





}
