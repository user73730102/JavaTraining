import java.sql.*;
public class CallableDemo {
    public static void main(String[] args) {
        try{
        Connection conn= JdbcFactory.getConnection();

        CallableStatement stmt=conn.prepareCall("{? = CALL get_name(?)}");

        // Index 1 is the return value of the function
        stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
        
        // Index 2 is the input argument 'id'
        stmt.setInt(2, 12);
        
        stmt.execute();

        System.out.println("Name: "+stmt.getString(1));


        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
    }
}
