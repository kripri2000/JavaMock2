import java.util.*;
class Book{
	
	private int isbno;
	private String bookName;
	private String author;
	public int getIsbno() {
		return isbno;
	}
	public void setIsbno(int isbno) {
		this.isbno = isbno;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

}
class Library{
	private ArrayList<Book> bookList = new ArrayList<Book>();

	public ArrayList<Book> getBookList() {
		return bookList;
	}

	public void setBookList(ArrayList<Book> bookList) {
		this.bookList = bookList;
	}
	void addBook(Book bobj)
	{
		bookList.add(bobj);
	}
	boolean isEmpty() {
		return bookList.isEmpty();
	}
	ArrayList<Book> viewAllBooks()
	{
		return getBookList();
	}
	ArrayList<Book> viewBooksByAuthor(String author)
	{
		 
			ArrayList<Book> booksByAuthor = new ArrayList<Book>();
			for(Book b:bookList)
			{
				if(b.getAuthor().contains(author))
					booksByAuthor.add(b);
			}
			return  booksByAuthor;
	}
	int countnoofbooks(String bname)
	{
		
		return (int)bookList.stream().filter(book->book.getBookName().contains(bname)).count();
		
		 
	}
}
public class BookMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Library libObj = new Library();
		int ch;
		do {
			System.out.println("\n1.Add Book\n2.Display all book details\n3.Search Book by author\n4.Count number of books - by book\n5.Exit ");
			System.out.println("Enter your choice:");
			ch = sc.nextInt();
			
			switch(ch)
			{
				case 1:
						System.out.println("Enter the isbno:");
						int isbno = sc.nextInt();
						System.out.println("Enter the book name:");
						String bookname = sc.next();
						System.out.println("Enter the author name:");
						String author = sc.next();				
						Book bookObj = new Book();
						bookObj.setIsbno(isbno);
						bookObj.setBookName(bookname);
						bookObj.setAuthor(author);
						libObj.addBook(bookObj);
						break;
				case 2: 
						
						for(Book b : libObj.getBookList()) {
							System.out.println("ISBN No:"+b.getIsbno());
							System.out.println("Book Name:"+b.getBookName());
							System.out.println("Author Name:"+b.getAuthor());
							System.out.println();
						}
						break;
				case 3:
						System.out.println("Enter the author:");
						String searchAuthor = sc.next();
						ArrayList<Book> bookListByAuth = libObj.viewBooksByAuthor(searchAuthor);
						if(bookListByAuth.isEmpty())
							System.out.println("No books by this author");
						else {
							for(Book b : bookListByAuth)
							{
								System.out.println("ISBN No:"+b.getIsbno());
								System.out.println("Book Name:"+b.getBookName());
								System.out.println("Author Name:"+b.getAuthor());
							}
						}
						break;
				case 4:
						System.out.println("Enter the bookname:");
						String searchBook = sc.next();
						int count = libObj.countnoofbooks(searchBook);
						System.out.println("No:of books with name "+searchBook+" : "+count);
						break;
				case 5: System.exit(0);
			}
		}while(ch<6);

	}

}
