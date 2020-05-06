package cc.Book.JavaBean;

public class Book {
	private long bookId;			//图书编号
	private String bookName;		//图书书名
	private String bookConcern;		//图书出版社
	private int bookNum;			//图书库存	
	private double bookPrice;		//图书单价
	private String bookAuthor;		//图书作者	
	private String bookSummary;		//图书简介
	
	public Book(){
		
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookConcern() {
		return bookConcern;
	}

	public void setBookConcern(String bookConcern) {
		this.bookConcern = bookConcern;
	}

	public int getBookNum() {
		return bookNum;
	}

	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}


	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookSummary() {
		return bookSummary;
	}

	public void setBookSummary(String bookSummary) {
		this.bookSummary = bookSummary;
	}
	

}
