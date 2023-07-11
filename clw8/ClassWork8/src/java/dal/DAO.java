/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;

/**
 *
 * @author xuant
 */
public class DAO extends DBcontext {

    public User check(String username, String password) {
        String sql = "SELECT [Username]\n"
                + "      ,[Password]\n"
                + "  FROM [dbo].[UserTBL]\n"
                + "  WHERE Username =?\n"
                + "  AND [Password] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User a = new User(rs.getString("Username"), rs.getString("Password"));

                return a;

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    public static void main(String[] args) {
        DAO d  = new DAO();
        System.out.println(d.check("usernamea", "12321"));
    }
}
