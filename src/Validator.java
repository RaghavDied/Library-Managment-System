import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator 
 {
    private static Pattern ID_PATTERN = Pattern.compile("^\\d{1,4}$");
    private static Pattern AuthorTitle_Pattern=Pattern.compile("^[a-zA-Z ]+$");
    private static Pattern PublishYear_Pattern=Pattern.compile("^\\d{4}$");
    
    Scanner sc = new Scanner(System.in);

    public String validateId() 
    {
        String bookid;
        while (true) 
        {
            System.out.println("Enter Book ID....: ");
            bookid = sc.nextLine();
            if (!ID_PATTERN.matcher(bookid).matches())
            {
                System.out.println("SORRY !! PLEASE ENTER VALID BOOK ID !! ");
            } else 
            {
                break;
            }
        }//end of while()
        return bookid;
    }//end of validateId()

    public String validateAuthorTitle(String input)
    {
        String result;
        while (true)
        {
            if(input=="Title")
            {
                System.out.println("Enter Title....:");
            }
            else
            {
                System.out.println("Enter Author....:");
            }
            result=sc.nextLine();
            if(!AuthorTitle_Pattern.matcher(result).matches())
            {
                System.out.println("Please Enter Valid "+input+ " !!");
            }
            else
            {
                break;
            }

        }//end of while
        return result;
    }//end of validateAuthorTitle()

    public String validatePublishYear()
    {
        String year;
        while(true)
        {
            System.out.println("Enter Publish Year of Book....:");
            year=sc.nextLine();
            if(!PublishYear_Pattern.matcher(year).matches())
            {
                System.out.println("Please Enter Valid Publish Year !!");
            }
            else
            {
                break;
            }
        }//end of while()
        return year;
    }//end of validatePublishYear()

 }//end of class


