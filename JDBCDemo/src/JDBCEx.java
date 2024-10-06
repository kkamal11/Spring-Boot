import java.sql.*;
public class JDBCEx {
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

            String query1 = "SELECT * FROM STUDENT WHERE ID='1'";
            String query2 = "SELECT * FROM STUDENT";
            try {
                ResultSet rs = st.executeQuery(query2);
//                if(true || rs.next()){ //Need to use rs.next() to move the pointer to first data
//                    System.out.println("----Got the data-----");
////                    String name = rs.getString("name");
////                    System.out.println("Name: " + name);
//                }
                //FETCHING ALL RECORDS
                while(rs.next()){
                    System.out.print(rs.getInt(1) + " : ");
                    System.out.print(rs.getString(2) + " : ");
                    System.out.println(rs.getInt(3));
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
