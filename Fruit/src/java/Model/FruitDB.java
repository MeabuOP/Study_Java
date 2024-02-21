/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class FruitDB implements DatabaseInfo {

    public static Connection getConnect() {
        try {
            Class.forName(DRIVERNAME);
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver" + e);
        }
        try {
            Connection con = DriverManager.getConnection(DBURL, USERDB, PASSDB);
            return con;
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

    public static ArrayList<Fruit> getFruits(String name) {
        Connection con = getConnect();
        ArrayList<Fruit> fruitList = new ArrayList<>();
        try {
            PreparedStatement st = con.prepareStatement("Select productID, productName, description, price from Products where productName LIKE ?");
            st.setString(1, "%" + name + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Fruit f = new Fruit(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
                fruitList.add(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FruitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fruitList;
    }

    public static Fruit getFruit(String ID) {
        Connection con = getConnect();
        Fruit f = null;
        try {
            PreparedStatement st = con.prepareStatement("Select productID, productName, description, price from Products where productID = ?");
            st.setString(1, ID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                f = new Fruit(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4));;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FruitDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;
    }

    public static void main(String[] a) {
        ArrayList<Fruit> list = FruitDB.getFruits("apple");
        for (Fruit item : list) {
            System.out.println(item);
        }
    }
}
