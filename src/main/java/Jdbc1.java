import java.sql.*;
public class Jdbc1 {
    
    static final String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    static final String dbURL = "jdbc:mysql://localhost/record";
       
    public static void main(String[] args)throws Exception
    {
        Connection con = null;
        Statement stat = null;
        ResultSet rs = null;
        
        try
        {
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection(dbURL, "root","root");
            if(con!=null)
            {
                System.out.println("Connected to the database");
            }
            stat = con.createStatement();
            
            String catalogName = con.getCatalog();
            System.out.println("Current catalog name is: "+ catalogName);
            
            
            String sql;
            
            sql = "SELECT * FROM data";
            rs = stat.executeQuery(sql);
            
            //sql = "INSERT INTO data VALUES(1005,'Shivam', 'Kaliya')";
            //stat.executeUpdate(sql);
           
            
            sql= "UPDATE data SET First_Name='Divya' WHERE ID = 1001";
            stat.executeUpdate(sql);
            
            sql= "UPDATE data SET LAST_NAME='Manral' WHERE ID = 1003";
            stat.executeUpdate(sql);
            
            sql= "DELETE FROM data WHERE ID = 1004";
           stat.executeUpdate(sql);
            
            sql = "SELECT * FROM data";
            rs = stat.executeQuery(sql);
            
            int id;
            String first_name;
            String last_name;
                        
            while(rs.next())
            {
                id = rs.getInt("ID");
                first_name= rs.getString("First_Name");
                last_name = rs.getString("Last_Name");
                
                System.out.println(id+" | "+first_name+" | "+last_name);
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
