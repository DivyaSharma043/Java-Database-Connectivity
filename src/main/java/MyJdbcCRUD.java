import java.sql.*;

public class MyJdbcCRUD {
    static final String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    static final String dbURL = "jdbc:mysql://127.0.0.1/study";
    
    public static void main(String[] args)throws Exception
    {
        Connection con = null;
        Statement stat = null;
        ResultSet rs = null;
        
        try
        {
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection(dbURL, "root","root");
            stat = con.createStatement();
            
            String sql;
            sql = "INSERT INTO Accounts VALUES(1001,'Joe', 5000.0)";
            stat.executeUpdate(sql);
            
            sql= "UPDATE Accounts SET NAME='Sanjay' WHERE ID = 1023";
            stat.executeUpdate(sql);
            
            sql= "DELETE FROM Accounts WHERE ID = 1044";
            stat.executeUpdate(sql);
            
            sql = "SELECT * FROM Accounts";
            rs = stat.executeQuery(sql);
            
            int id;
            String name;
            float balance;
            
            while(rs.next())
            {
                id = rs.getInt("ID");
                name= rs.getString("Name");
                balance = rs.getFloat("Balance");
                
                System.out.println(id+" "+name+" "+balance);
            }
            rs.close();
            stat.close();
        }
        finally
        {
            if(con!=null)
                con.close();
        }
    }
}
