import java.sql.SQLException;
import java.util.Scanner;
public class Client {
//

public  static  void main(String args[]) throws SQLException {
    Register_Login login_Register =new Register_Login();
    Scanner scanner = new Scanner(System.in);
    System.out.println("enter num 1 To Log in  or 2 To register :");
    Integer num = scanner.nextInt();
    switch (num){
        case 1:  login_Register.Login();
        break;
        case 2 :     login_Register.Register();
        break;
        default: System.out.println("the number is false ");
    }

}

    }

