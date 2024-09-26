package db;

import java.sql.*;

import character.Character;
import io.github.cdimascio.dotenv.Dotenv;

public class DB {

    Dotenv dotenv = Dotenv.load();

    String dbHost = dotenv.get("DB_HOST");
    String dbUser = dotenv.get("DB_USER");
    String dbPassword = dotenv.get("DB_PASSWORD");
    String dbName = dotenv.get("DB_NAME");
    String dbPort = dotenv.get("DB_PORT");

    final String DB_URL = "jdbc:mysql://localhost:3306/" + dbName;
    final String USER = dbUser;
    final String PASS = dbPassword;
    Connection conn;
    Statement stmt;
    PreparedStatement pstmt;



    public DB() throws SQLException {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            System.out.println("DB connection established");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getHeroes() throws SQLException {
        String sql = "SELECT * FROM hero";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.print("ID: " + rs.getInt("id") + " NAME: " + rs.getString("name") + " TYPE: " + rs.getString("type") + "\n");
        }
    }

    public void createHero (Character character) throws SQLException {
        // Prepare the SQL query with placeholders for the parameters (?)
        String sql = "INSERT INTO hero (type, name, health, attack, weapon_spell) VALUES (?, ?, ?, ?, ?)";
        pstmt = conn.prepareStatement(sql);
        // Set the parameters
        pstmt.setString(1, character.getType());  // Set 'type' as the first parameter
        pstmt.setString(2, character.getName());  // Set 'name' as the second parameter
        pstmt.setInt(3, character.getHealth());   // Set 'health' as the third parameter
        pstmt.setInt(4, character.getAttack());   // Set 'attack' as the fourth parameter
        pstmt.setString(5, character.getOffensiveEquipment());  // Set 'offensiveEquipment' as the fifth parameter (for weapon_spell)

        pstmt.executeUpdate();
    }

    public ResultSet getOneHero (int id) throws SQLException {
        String sql = "SELECT * FROM hero WHERE id = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        return pstmt.executeQuery();
    }
    public void editHero () {

    }
    public void changeHealthPoints (Character character) throws SQLException {
        String sql = "UPDATE hero SET health = ? WHERE name =? ";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, character.getHealth());
        pstmt.setString(2, character.getName());
        pstmt.executeUpdate();
    }


}
