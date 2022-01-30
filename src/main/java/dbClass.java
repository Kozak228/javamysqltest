import java.sql.*;

public class dbClass {
    public Connection conn;

    public dbClass(String dbURL, String username, String password)
    {
        try {
            this.conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                System.out.println("Connected");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean Insert(String text) throws SQLException {
        String sql = "INSERT INTO deleteTable (deleteText) VALUES (?)";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, text);

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new user was inserted successfully!");
            return true;
        }
        return false;
    }

    public boolean Delete(String text) throws SQLException {
        String sql = "DELETE FROM deleteTable WHERE deleteText=?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, "bill");

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A user was deleted successfully!");
            return true;
        }
        return false;
    }

    public boolean Select() throws SQLException {
        String sql = "SELECT * FROM deletetable";

        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()){
            String id = result.getString(1);
            String text = result.getString(2);

            System.out.println(id + ": " + text);
        }

        return true;
    }
}
