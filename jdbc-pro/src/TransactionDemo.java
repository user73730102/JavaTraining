import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDemo {
    public static void main(String[] args) {
    
        String sql1= "insert into cust values (15,'Nike','Hyd')";
        String sql2="update cust set city='Bangaluru' where cid=12";
        String sql3="delete from cust where cid=15";

        Connection conn = null;
        try {
            conn = JdbcFactory.getConnection();
            conn.setAutoCommit(false);

            Statement stmt=conn.createStatement();
            stmt.addBatch(sql1);
            stmt.addBatch(sql2);
            stmt.addBatch(sql3);

            stmt.executeBatch();
            conn.commit();
            System.out.println("Transaction successful");

            
        } catch (SQLException e) {
            System.out.println("Transaction failed");
            
                try {
                    conn.rollback();
                } catch(SQLException e1) {
                    e1.printStackTrace();
                }
            
            e.printStackTrace();
        }
    }
}
