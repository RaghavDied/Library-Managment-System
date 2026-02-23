import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookServiceImpl implements BookServiceInterface 
{
    Scanner sc=new Scanner(System.in);
    Validator validator=new Validator();
    List<Book> books=new ArrayList<>();

    @Override
    public void addBook()
    {

        String bookid= validator.validateId();
        String Author=validator.validateAuthorTitle("Author");
        String Title=validator.validateAuthorTitle("Title");
        String year=validator.validatePublishYear();
        Book book=new Book(bookid,Author,Title,year,"Available");
        books.add(book);
        System.out.println("Book Added Successfully !!!");

    }//end of addBook()

    @Override
    public void showAllBooks() 
    {
        boolean flag=false;
        System.out.println("\n----------------------------------------------------------------------------------------------");
        System.out.format("%s%15s%15s%15s%15s","ID","TITLE","AUTHOR","PUBLISH YEAR","STATUS");
        System.out.println("\n----------------------------------------------------------------------------------------------");

        for (Book book:books)
        {
            System.out.format("%s%15s%15s%15s%15s",book.getId(),book.getTitle(),book.getAuthor(),book.getPublishYear(),book.getStatus());
            System.out.println();
            flag=true;
        }//end of for()
        System.out.println("\n----------------------------------------------------------------------------------------------");
        if(flag==false)
        {
            System.out.println("There are no Books in Library");
        }
    }//end of showAllBooks()

    public void showAllAvailableBooks()
    {
        boolean flag=false;
        System.out.println("\n----------------------------------------------------------------------------------------------");
        System.out.format("%s%15s%15s%15s%15s","ID","TITLE","AUTHOR","PUBLISH YEAR","STATUS");
        System.out.println("\n----------------------------------------------------------------------------------------------");

        if(books.size()>0)
        {
            for (Book book:books)
            {
                if(book.getStatus()=="Available")
                {
                    System.out.format("%s%15s%15s%15s%15s",book.getId(),book.getTitle(),book.getAuthor(),book.getPublishYear(),book.getStatus());
                    System.out.println();
                    flag=true;
                }
            }//end of for()
        }
        else
        {
            System.out.println("No Books Available in the library");
        }
        System.out.println("\n----------------------------------------------------------------------------------------------");
        if(flag==false)
        {
            System.out.println("There are no books with status Available");
        }
    }//end of showAllAvailableBooks() 

    public void borrowBook(){
        String bookid= validator.validateId();
        boolean flag=false;
        for(Book book:books)
        {
            if(book.getId().equals(bookid) && book.getStatus().equals("Available"))
            {
                flag=true;
                System.out.println("Book Borrowed Successfully !!!");
                book.setStatus("Not Available");
                System.out.println("Borrowed Book Details: "+book);
            }
        }//end of for()
        if(flag==false)
        {
            System.out.println("This book is not available to borrow");
        }

    }//end of borrowBook

    public void returnBook()
    {
        boolean flag=false;
        String bookid= validator.validateId();
        for(Book book:books)
        {
            if(book.getId().equals(bookid) && book.getStatus().equals("Not Available"))
            {   flag=true;
                System.out.println("Book Returned Successfully !!!");
                book.setStatus("Available");
                System.out.println("Returned Book Details: "+book);
            }

        }//end of for()
        if(flag==false)
        {
            System.out.println("We Cannot Accept this Book....!!");
        }
    }//end of returnBook()
}//end of class
