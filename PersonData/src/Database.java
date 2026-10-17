import java.sql.*;
public class Database {
    private Connection cn;
    private Statement st;

    public Database(){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/person", "root", "");
            st = cn.createStatement();
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    public ResultSet selectQuery(String sql){
        try{
            st.executeQuery(sql);
            return st.getResultSet();
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    public int Changes(String sql){
        try{
            return st.executeUpdate(sql);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    public Statement getStatement(){
        return st;
    }
}
