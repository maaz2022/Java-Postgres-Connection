import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        db jdbc = new db();
        Connection con = jdbc.connect_to_db("test","postgres","1234");
//        jdbc.CreateTable(con,"Student");
//        jdbc.RowInsert(con,"Student","Muhammad","b");
//        jdbc.updataData(con,"Student",8,"Anas");
//        jdbc.delete(con,"Student","Muhammad");
//        jdbc.ReadData(con,"Student");
//        jdbc.search(con,"Student","Qasim");
//        jdbc.search(con,"Student","Maaz");
//        jdbc.deleteTable(con,"Student");



    }
}