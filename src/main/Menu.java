package main;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import grabdata.ListAllBooks;
import grabdata.ListTransactionHistory;
import grabdata.SearchAuthorByName;
import grabdata.SearchBookByIsbn;
import grabdata.SearchBookByTitle;
import grabdata.SearchBorrower;
import insertdata.CheckingOutABook;
import insertdata.InsertNewAuthor;
import insertdata.InsertNewBook;
import insertdata.InsertNewBorrower;
import insertdata.ReturnABook;
import utils.InputHelper;

public class Menu {
	public static void main(String args[]) throws SQLException
	{	
		/* Printing out the menu */
		System.out.print(""
				+ "Welcome to Library Management System (LMS). Choose one of the following \n"
				+ "------------------------------------------------- \n"
				+ "1. Search a book by ISBN \n"
				+ "2. Search a Book by Title \n"
				+ "3. Search a Borrower by CardNo \n"
				+ "4. Search an Author by Name \n"
				+ "5. Insert a New book \n"
				+ "6. Insert a New Author \n"
				+ "7. Insert a New Borrower \n"
				+ "8. Check Out a Book \n"
				+ "9. Return a Book \n"
				+ "10. List All Books \n"
				+ "11. List Transaction History for a Book \n"
				+ "12. Exit \n\n"
				);
		
		/* Getting input from user for selecting the menu */
		int menu_id = InputHelper.getIntegerInput("Choose menu item: ");
		
		/* Switching to different options based on input number */
		switch(menu_id)
		{
		case 1:
			System.out.println("Enter an ISBN of the book to search for it. \n");
			int isbn = 0;
			try{
				/* Getting ISBN number from user*/
				isbn = InputHelper.getIntegerInput("");
				
				/* Search the book by ISBN */
				SearchBookByIsbn.srch(isbn);
			}catch(Exception exception){
				/* Throw error if input is not integer */
				System.out.println("Please enter a integer!");
				
				/* Take input again */
				isbn = InputHelper.getIntegerInput("");
				SearchBookByIsbn.srch(isbn);
			}
			break;
			
		case 2:
			System.out.println("Enter the title of the book to search for it. \n");
			
			/* Getting book title from user*/
			String title = InputHelper.getStringInput("");
			
			/* Search by title */
			SearchBookByTitle.srch(title);
			break;
			
		case 3:
			System.out.println("Enter the card no. of the borrower to search for him/her. \n");
			try{
				/* Getting card no. of the borrower */
				int card_no = InputHelper.getIntegerInput("");
				
				/* Search the borrower by card no. */
				SearchBorrower.srch(card_no);
			}catch(Exception exception)
			{
				/* Throw error in case the input is not integer */
				System.out.println("Please enter a integer!");
				
				/* Take input again */
				int card_no = InputHelper.getIntegerInput("");
				SearchBorrower.srch(card_no);
			}
			break;
			
		case 4:
			System.out.println("Enter the name of the author to search for him/her. \n");
			try{
				/* Getting the author name from the user */
				String name = InputHelper.getStringInput("");
				
				/* Checking if name contains numbers and throwing error*/
				if(name.matches(".*\\d+.*"))
				{
					System.out.println("Enter only text");
					
				}else{
					/* Search author name */
					SearchAuthorByName.srch(name);
				}
				
			}catch(Exception exception)
			{
				
			}
			break;
			
		case 5:
			System.out.println("Inserting a new book \n");
			System.out.println("----------------------------------------------- \n");
			System.out.println("Enter the ISBN no. of the book \n");
			/* Getting isbn of the book */
			int isbn_insert = InputHelper.getIntegerInput("");
			
			System.out.println("Enter the title of the book \n");
			/* Getting title of the book */
			String title_insert = InputHelper.getStringInput("");
			
			System.out.println("Enter the publisher id of the book \n");
			/* Getting publisher id of the book */
			int pub_id_insert = InputHelper.getIntegerInput("");
			
			System.out.println("Enter the author id of the book \n");
			/* Getting author id of the book */
			int author_id_insert = InputHelper.getIntegerInput("");
			
			System.out.println("Enter the published date of the book (Use format mm-dd-yyyy) \n");
			/* Getting published date of the book */
			String date_insert = InputHelper.getStringInput("");
			
			System.out.println("Enter the available copies of the book \n");
			/* Getting available copies */
			int avail_copies_insert = InputHelper.getIntegerInput("");
			
			/* Insert the data */
			InsertNewBook.insertData(isbn_insert, title_insert, pub_id_insert, author_id_insert, date_insert, avail_copies_insert);
			break;
			
		case 6:
			System.out.println("Inserting a new author \n");
			System.out.println("----------------------------------------------- \n");
			System.out.println("Enter the author id of the author \n");
			/* Getting id of the author */
			int auth_id_insert = InputHelper.getIntegerInput("");
			
			System.out.println("Enter the name of the author \n");
			/* Getting name of the author */
			String auth_name_insert = InputHelper.getStringInput("");
			
			System.out.println("Enter the email of the author \n");
			/* Getting email of the author */
			String auth_email_insert = InputHelper.getStringInput("");
			
			/* Insert the data */
			InsertNewAuthor.insertData(auth_id_insert, auth_name_insert, auth_email_insert);
			break;
			
		case 7:
			System.out.println("Inserting a new borrower \n");
			System.out.println("----------------------------------------------- \n");
			System.out.println("Enter the card no. of the borrower\n");
			/* Getting card no. of the borrower */
			int borrower_card_no_insert = InputHelper.getIntegerInput("");
			
			System.out.println("Enter the name of the borrower \n");
			/* Getting name of the borrower */
			String borrower_name_insert = InputHelper.getStringInput("");
			
			System.out.println("Enter the address of the borrower \n");
			/* Getting address of the borrower */
			String borrower_address_insert = InputHelper.getStringInput("");
			
			System.out.println("Enter the phone of the borrower \n");
			/* Getting phone of the borrower*/
			int borrower_phone_insert = InputHelper.getIntegerInput("");
			
			/* Insert the data */
			InsertNewBorrower.insertData(borrower_card_no_insert, borrower_name_insert, borrower_address_insert, borrower_phone_insert);
			break;
			
		case 8:
			System.out.println("Checking out a book");
			System.out.println("------------------------------------------------------------");
			System.out.println("Enter the ISBN of the book you want to check out.");
			/* Getting isbn of the book to check out*/
			int isbn_book_borrow = InputHelper.getIntegerInput("");
			
			System.out.println("Enter the card no. of the book borrower.");
			/* Getting card no. of the book borrower */
			int card_no_book_borrow = InputHelper.getIntegerInput("");
			
			/* Getting todays date automatically from the system */
			String todaysDate = new SimpleDateFormat("MM-dd-yyyy").format(new Date());
			
			/* Insert the data */
			CheckingOutABook.insertData(isbn_book_borrow, card_no_book_borrow, todaysDate);
			break;
			
		case 9:
			System.out.println("Returning a book");
			System.out.println("--------------------------------------------------------------");
			
			System.out.println("Enter the ISBN of the book that you want to return:");
			/* Getting the ISBN of the book to return */
			int isbn_book_return  = InputHelper.getIntegerInput("");
			
			System.out.println("Enter the card no. of the borrower:");
			/* Getting card no. of the borrower */
			int card_no_book_return  = InputHelper.getIntegerInput("");
			
			System.out.println("Enter the date when this book was borrowed (Use format mm-dd-yyyy):");
			/* Getting the date when the book was borrowed*/
			String date_book_return  = InputHelper.getStringInput("");
			
			/* Getting todays date automatically from the system */
			String todaysReturnDate = new SimpleDateFormat("MM-dd-yyyy").format(new Date());
			
			/* Call function to return book */
			ReturnABook.returnBook(isbn_book_return, card_no_book_return, date_book_return, todaysReturnDate);
			break;
			
		case 10:
			System.out.println("All books \n");
			/* Print out all the book by calling listall() function */
			ListAllBooks.listall();
			break;
			
		case 11:
			System.out.println("Transaction history of a book");
			System.out.println("---------------------------------------------");
			System.out.println("Enter the ISBN of the book that you want to see the transaction history:");
			/* Getting isbn of the book to see its transaction */
			int isbn_transaction_history = InputHelper.getIntegerInput("");
			ListTransactionHistory.list(isbn_transaction_history);
			break;
			
		case 12:	
			/* Exiting from the system */
			System.exit(0);		
		}
		
		
	}
}
