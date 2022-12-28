import java.sql.*;
import java.util.Scanner;

public class Register_Login {

  public  void Login() {
    try (Scanner scanner = new Scanner(System.in)) {
        System.out.println("To Login to your account");
        System.out.println("Enter Phone=>");
        String Phone = scanner.nextLine();
        System.out.println("Enter password=> ");
        String password = scanner.nextLine();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/securityproject",
                "root", "");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from users");
        while (resultSet.next()) {
            if ((resultSet.getString("phone").equals(Phone)) &&
                    (resultSet.getString("password").equals(password))) {
                System.out.println("User is successful loggined ..");
                break;
            }
            else
                System.out.println("Invalid Phone or password .. ");
       break;
        }

        connection.close();
    } catch (Exception e) {
        System.out.println(e);
    }


}

void Register() throws SQLException {
        try(Scanner scanner = new Scanner(System.in)) {
            String url ="jdbc:mysql://localhost:3306/securityproject " ;
            System.out.println("To register a new account : ");
            System.out.println("Enter Phone=>");
            String Phone=scanner.nextLine();
            System.out.println("Enter password=> ");
            String password =scanner.nextLine();
            Connection connection=null;
            Statement statement=null;
            try {
                 connection = DriverManager.getConnection(url,
                    "root", "");
                statement = connection.createStatement();
                String sql = "INSERT INTO users"+"(phone ,password)"+"Values('"+Phone+"','"+password+"')";
                statement.execute(sql);
                System.out.println("Register complete");

            }
            catch (Exception e)
            {
                e.printStackTrace();
            } finally {
                if(statement!=null){
                    statement.close();}
                if (connection!=null){
                    connection.close();
                }
            }


        }
  }
}

