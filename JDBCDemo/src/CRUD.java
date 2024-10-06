import java.sql.*;
public class CRUD {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/java_db";
        String user = "postgres";
        String password = "kamaliitm211";
        try{
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException e){
            System.out.println("Error...");
        }
        try {
            Connection conn = DriverManager.getConnection(url,user,password);
            System.out.println("==========Connection Established===========");

            Statement st = conn.createStatement();

            String insertQuery = "INSERT INTO STUDENT VALUES('5','Boomrah','3')";
            String updateQuery = "UPDATE STUDENT SET AGE='30' WHERE ID='5' AND AGE=3";
            String deleteQuery = "DELETE FROM STUDENT WHERE ID='6'";
            try {
                boolean status = st.execute(updateQuery);
                if (!status){ //returns false for insert and update
                    System.out.println("DML executed...");
                }
            } catch (Exception e) {
                System.out.println("Error while executing query: " + e);
            }
            finally {
                conn.close();
                System.out.println("==========Connection Closed===========");
            }
        }
        catch (SQLException e){
            System.out.println("Error in conn...");
            System.out.println(e);
        }

    }
}
