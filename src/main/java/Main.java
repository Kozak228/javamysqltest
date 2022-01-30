import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://MYSQL5045.site4now.net:3306/db_a7e000_laravel";
        String username = "a7e000_laravel";
        String password = "123-qwe-zxc-ASD";

        dbClass db = new dbClass(dbURL, username, password);
        try {
            db.Insert("test");
            db.Select();
        } catch(SQLException ex)
        {
            ex.printStackTrace();
        }

    }
}
