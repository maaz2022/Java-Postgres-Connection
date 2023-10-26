import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class db {
public Connection connect_to_db( String dbname,String user,String pass) {
    Connection con = null;
    try {
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, pass);
        if (con != null) {
            System.out.println("Connection Established");
        } else {
            System.out.println("Connection failed");
        }


    } catch (Exception e) {
        System.out.println(e);
    }
    return con;
}
public  void CreateTable(Connection con, String TableName){
    Statement statement;
    try{
        String Query ="Create table " + TableName + "(Stdid SERIAL, Name varchar(200),Grade varchar(200),primary key(Stdid))";
        statement = con.createStatement();
        statement.executeUpdate(Query);
        System.out.println("Table Created");
    }catch (Exception e){
        System.out.println(e);
    }
}
public void RowInsert(Connection con,String TableName,String name,String grade){
    Statement statement;
    try{
        String Query = String.format("insert into %s(name,grade) values ('%s','%s');" ,TableName,name,grade);
        statement =con.createStatement();
        statement.executeUpdate(Query);
        System.out.println("Row Inserted");
    }catch (Exception e){
        System.out.println(e);
    }
}
public  void ReadData(Connection con,String TableName){
    Statement statement;
    ResultSet resultSet = null;
    try{
        String query = String.format("SELECT * FROM %s", TableName);
    statement= con.createStatement();
    resultSet = statement.executeQuery(query);
    while (resultSet.next()){
        System.out.print(resultSet.getString("stdid") + " ");
        System.out.print(resultSet.getString("name") + " ");
        System.out.println(resultSet.getString("grade") + " ");
    }

    }catch (Exception e){
        System.out.println(e);
    }
}
public  void updataData(Connection con,String TableName,int Id,String NewName){
    Statement statement;
    try {
        String query = String.format("update %s set name ='%s' where stdid = '%s' ",TableName,NewName,Id);
        statement=con.createStatement();
        statement.executeUpdate(query);
        System.out.println("Updated");

    }catch (Exception e){
        System.out.println(e);
    }
}
public void search(Connection con,String tableName,String searhTerm){
    Statement statement;
    ResultSet resultSet = null;
    try {
        String query = String.format("Select * from %s where name='%s'",tableName,searhTerm);
        statement = con.createStatement();
        resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            System.out.print(resultSet.getString("stdid") + " ");
            System.out.print(resultSet.getString("name") + " ");
            System.out.println(resultSet.getString("grade") + " ");
        }

    }catch (Exception e){
        System.out.println(e);
    }
}
public void delete(Connection con,String tableName,String deltTerm){
    Statement statement;
    try {
        String query = String.format("Delete from %s where name='%s'", tableName, deltTerm);
        statement = con.createStatement();
        statement.executeUpdate(query);
    }catch (Exception e){
        System.out.println(e);
    }
}
public void deleteTable(Connection con,String tableName){
    Statement statement;
    try{
        String query = String.format("drop table %s",tableName);
        statement = con.createStatement();
        statement.executeUpdate(query);
        System.out.println("Table deleted");
    }catch (Exception e){
        System.out.println(e);
    }
}
}
