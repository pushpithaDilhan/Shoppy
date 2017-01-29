
/**
 *
 * @author Pushpitha
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException ;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SQLiteConnector {
    private Connection conn = null ;
    private Statement stmt = null;
    private String url = "jdbc:sqlite:C:/db/shoplayout.db";
    
    public SQLiteConnector(){
        try {
            
            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Database found");
    }
    
    public void createTable(){
        try {
            String sql = "CREATE TABLE ShopCoords ("
                    + "item TEXT,"
                    + "x REAL,"
                    + "y REAL"
                    + ");";
            stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        
    public void insert(String name , double x_val , double y_val){
        String sql = "INSERT INTO Shopcoords VALUES( ?,?,?)";
        try{
           PreparedStatement pstmt = conn.prepareStatement(sql);
           pstmt.setString(1,name);
           pstmt.setDouble(2,x_val);
           pstmt.setDouble(3,y_val);
           pstmt.executeUpdate();
        }catch(Exception e){}
    }
    
    public void showTable() throws SQLException{
        String showsql = "SELECT item,x,y FROM ShopCoords ;";
            ResultSet rs = stmt.executeQuery(showsql);
            while(rs.next()){
                System.out.println(rs.getString("item")+"  "+rs.getDouble("x")+"  "+rs.getDouble("y"));
            }
    }
    
    public ResultSet getResultSet() throws SQLException{
        String showsql = "SELECT item,x,y FROM ShopCoords ;";
        ResultSet rs = stmt.executeQuery(showsql);
        return rs ;
    }
    
}
