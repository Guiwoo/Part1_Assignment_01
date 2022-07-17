package Controller;

import java.sql.*;

import static Controller.Db_Utility.Wifi_History_table;
import static Controller.Db_Utility.Wifi_Table;

public class Db_Handler {
    public Connection connection;
    public void init(){
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
            Statement statement = connection.createStatement();
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    public void close(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTables(){
        init();
        try{
            PreparedStatement preparedStatement2 = connection.prepareStatement(Wifi_History_table);
            PreparedStatement preparedStatement = connection.prepareStatement(Wifi_Table);
            int affected = preparedStatement.executeUpdate();
            int affected2 = preparedStatement2.executeUpdate();
            System.out.println(affected2);
        }catch(SQLException e){
            e.printStackTrace();
        }
        close(connection);
    }

    public void close(PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            if (resultSet != null && !resultSet.isClosed()) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
