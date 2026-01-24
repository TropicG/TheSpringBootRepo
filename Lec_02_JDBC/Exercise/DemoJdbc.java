import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoJdbc {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // this string specifies that PostgreSQL driver is used
        // it is trying to conenct to the current machine on port 5432
        String url = "jdbc:postgresql://localhost:5432/demo";

        // this is the username and password to access the database
        String username = "postgres";
        String password = "tropic";

        // it loads the driver for PostgraceSQL into the memory of Java, it is a good practice
        Class.forName("org.postgresql.Driver");
        // A connection to the database is created here
        Connection connection = DriverManager.getConnection(url, username, password);

        System.out.println("connection established");

        // The Statement interface is delivering the SQL queries to the database
        Statement statement = connection.createStatement();
        // this is the actual qu
        String sqlQuery = "select * from student";

        // the result from the database, imagine this ResultSet as a LinkedList that at first points to before the first element
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        // .next() is very important since it moves the current position with one position forward
        while(resultSet.next()) {
            // getting the values for the colums and outputing everything on the console
            String studentId = resultSet.getString("sid");
            String studentName = resultSet.getString("sname");
            Integer studentGrade = resultSet.getInt("marks");

            System.out.println("The student name is: " + studentName + " which id of " + studentId + " and has a total marks of : " + studentGrade);
        }

        // If you want to insert new values to the db execute this query
        //String insertQuery = "insert into student values (6,'Kosmatko',10)";
        //statement.execute(insertQuery);


        // if you want to update given value in the db execute this query
        //String updateQuery = "update student set marks=110 where sname = 'Deni'";
        //statement.execute(updateQuery);

        // If you want to delete a data from the db execute this query
        //String deleteQuery = "delete from student where id=3";
        //statement.execute(deleteQuery);

        // PrepearedStatements are the safer way to work with SQL queries, instead of placing the values to the sting place ?
        // the prepared statement offers method to set the corresponding values to the query
        String insertQuery = "insert into student values (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setInt(1, 3);
        preparedStatement.setString(2, "Bebcheto");
        preparedStatement.setInt(3, 140);

        connection.close();
    }
}
