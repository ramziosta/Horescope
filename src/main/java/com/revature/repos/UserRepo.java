package com.revature.repos;

import com.revature.models.User;
import com.revature.utils.CRUDDaoInterface;
import com.revature.utils.ConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepo implements CRUDDaoInterface<User> {

    public Connection connection;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRepo.class);

    public UserRepo() {

        try {
            connection = ConnectionManager.getConnection();
        } catch (SQLException sqlException) {

            System.out.println(sqlException.getMessage());
            LOGGER.error(sqlException.getMessage());
        }

    }

    // tested word fine
    @Override
    public int create(User user) {
        String sql = "INSERT INTO horoscope (id, firstname, lastname, email, pass_word, horoscope, birthday, mood, login) VALUES(default,?,?,?,?,?,TO_DATE(?, 'YYYY-MM-DD'),default,default); ";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, user.getfirstname());
            pstmt.setString(2, user.getlastname());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPassword());
            pstmt.setString(5, user.getHoroscope());
            pstmt.setString(6, user.getBirthday());
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();

            return rs.getInt("id");

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
            LOGGER.error(sqlException.getMessage());
        }
        return 0;
    }

    // ! needs testing
    @Override
    public List<User> getAll() {

        List<User> users = new ArrayList<>();

        try {
            String sql = "SELECT * FROM users";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setfirstname(rs.getString("first_name"));
                user.setlastname(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("pass_word"));
                users.add(user);
            }

            return users;
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return null;
    }

    // ! needs testing
    @Override
    public User getById(int id) {
        try {
            String sql = "SELECT * FROM users WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            User user = new User();

            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setfirstname(rs.getString("first_name"));
                user.setlastname(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("pass_word"));

            }

            return user;
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return null;
    }

    // !needs testing
    @Override
    public User update(User user) {

        try {

            String sql = "UPDATE users SET email = ? WHERE id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, user.getEmail());
            pstmt.setInt(2, user.getId());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            while (rs.next()) {
                user.setEmail(rs.getString("email"));
            }

            return user;

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return null;
    }

    // ! needs testing
    @Override
    public boolean delete(User user) {

        try {
            String sql = "DELETE FROM users WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, user.getId());
            pstmt.execute();
            return true;
            // pstmt.execute() specifically returns false

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

        return false;
    }

    // tested works fine
    public User login(User user) {

        try {

            String sql = "UPDATE horoscope SET login = true WHERE email = ? AND pass_word = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, user.getEmail());
            pstmt.setString(2, user.getPassword());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            while (rs.next()) {

                user.setId(rs.getInt("id"));
                user.setfirstname(rs.getString("firstname"));
                user.setlastname(rs.getString("lastname"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("pass_word"));
                user.setBirthday(rs.getString("birthday"));
                user.setHoroscope(rs.getString("horoscope"));
                user.setMood(rs.getString("mood"));
                user.setLogin(rs.getBoolean("login"));

            }

            return user;

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return null;
    }


    public User logout(User user) {

        try {

            String sql = "UPDATE horeoscope SET login = false WHERE email = ? AND pass_word = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, user.getEmail());
            pstmt.setString(2, user.getPassword());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            while (rs.next()) {
                user.setEmail(rs.getString("email"));
                user.setId(rs.getInt("id"));
                user.setfirstname(rs.getString("first_name"));
                user.setlastname(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("pass_word"));
            }

            return user;

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return null;
    }

}
