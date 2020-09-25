package Tool;

import java.sql.*;

public class SqlTools {

    private final String url = "jdbc:mysql://localhost:3306/civbalance?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC&autoReconnect=true&useSSL=false";
    private final String user = "root";
    private final String password = "dota2010";
    private Connection myConn;
    private ResultSet rS;

    public void execQuery(String requete) {
        Connection myConn = null;
        try {
            myConn = DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Statement myStat = null;
        try {
            assert myConn != null;
            myStat = myConn.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ResultSet rs = null;
        try {
            assert myStat != null;
            rs = myStat.executeQuery(requete);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        this.setMyConn(myConn);
        this.setrS(rs);
    }

    public void execUpdate (String requete) {
        myConn = null;
        try {
            myConn = DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Statement myStat;
        try {
            assert myConn != null;
            myStat = myConn.createStatement();
            myStat.executeUpdate(requete);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            myConn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Connection getMyConn() {
        return myConn;
    }

    public void setMyConn(Connection myConn) {
        this.myConn = myConn;
    }

    public ResultSet getrS() {
        return rS;
    }

    public void setrS(ResultSet rS) {
        this.rS = rS;
    }
}
