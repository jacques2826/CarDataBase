/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carsorter;

/**
 *
 * @author jacqu_000
 */



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jacques
 */
public class CarDB {

    public static void main(String[] args) {
   final String QUERY = "select CarYear, CarMake, CarModel, CarHorsepower, MSRP, "
                + "CarYear from Car";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/car", "jacques", "mucis");
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            System.out.println(stmt.toString());
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                System.out.println(
                        +rs.getInt("CarYear") + ", "
                        + rs.getString("CarMake") + ", "
                        + rs.getString("CarModel") + ", "        
                        + rs.getString("CarHorsepower") + ", "
                        + rs.getInt("MSRP"));
            }
        } catch (SQLException ex) {
            System.out.println("Retrieve SQLException: " + ex.getMessage());

        }
    }
}