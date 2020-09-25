package Tool;

import java.sql.*;
import java.util.Scanner;

public class User {
    private String username;
    private String password;
    private int user_id;

    public void login() {

        String url = "jdbc:mysql://localhost:3306/civbalance?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC&autoReconnect=true&useSSL=false";
        String username;
        try (Connection myConn = DriverManager.getConnection(url, "root", "dota2010")) {
            Scanner scanner = new Scanner(System.in);
            boolean login = false;
            System.out.println("Welcome to CivBalance, please login : ");
            while (!login) {
                System.out.println("username : ");
                username = scanner.nextLine();
                Statement user_name = myConn.createStatement();
                String sql = "SELECT * FROM civbalance.user WHERE username = " + "'" + username + "'";
                try (ResultSet rs = user_name.executeQuery(sql)) {
                    System.out.println("password : ");
                    while (rs.next()) if (scanner.nextLine().equals(rs.getString("password"))) {
                        login = true;
                        this.setUsername(username);
                        this.setPassword(rs.getString("password"));
                        this.setUser_id(rs.getInt("user_id"));
                    }
                    else
                        System.out.println("Nope, try again");
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
