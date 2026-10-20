// ДЗ

package ru.itis.repository;

import ru.itis.models.Driver;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DriversRepositoryJdbcImpl implements DriversRepository {

    private DataSource dataSource;

    private static final String SQL_INSERT_INTO_DRIVERS = "insert into drivers (first_name, last_name, age, city, gender, experience) values (?,?,?,?,?,?)";
    private static final String SQL_SELECT_COUNT_FOR_SAVE = "select users_count from save_settings where id = 1";
    private static final String SQL_SELECT_BY_CITY = "select * from drivers where city = ?";
    private static final String SQL_SELECT_BY_GENDER = "select * from drivers where gender = ?";
    private static final String SQL_SELECT_BY_EXPERIENCE = "select * from drivers where experience = ?";

    public DriversRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(Driver entity) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_INTO_DRIVERS);
        preparedStatement.setString(1, entity.getFirstName());
        preparedStatement.setString(2, entity.getLastName());
        preparedStatement.setObject(3, entity.getAge());
        preparedStatement.setString(4, entity.getCity());
        preparedStatement.setString(5, entity.getGender());
        preparedStatement.setObject(6, entity.getExperience());
        preparedStatement.executeUpdate();
    }

    @Override
    public Integer findCountForSave() throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL_SELECT_COUNT_FOR_SAVE);
        resultSet.next();
        return resultSet.getInt("users_count");
    }

    @Override
    public List<Driver> findAllByCity(String city) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_CITY);
        preparedStatement.setString(1, city);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Driver> result = new ArrayList<>();
        while (resultSet.next()) {
            Driver driver = Driver.builder()
                    .id(resultSet.getLong("id"))
                    .firstName(resultSet.getString("first_name"))
                    .lastName(resultSet.getString("last_name"))
                    .age(resultSet.getInt("age"))
                    .city(resultSet.getString("city"))
                    .gender(resultSet.getString("gender"))
                    .experience(resultSet.getInt("experience"))
                    .build();
            result.add(driver);
        }
        return result;
    }

    @Override
    public List<Driver> findAllByGender(String gender) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_GENDER);
        preparedStatement.setString(1, gender);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Driver> result = new ArrayList<>();
        while (resultSet.next()) {
            Driver driver = Driver.builder()
                    .id(resultSet.getLong("id"))
                    .firstName(resultSet.getString("first_name"))
                    .lastName(resultSet.getString("last_name"))
                    .age(resultSet.getInt("age"))
                    .city(resultSet.getString("city"))
                    .gender(resultSet.getString("gender"))
                    .experience(resultSet.getInt("experience"))
                    .build();
            result.add(driver);
        }
        return result;
    }

    @Override
    public List<Driver> findAllByExperience(Integer experience) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_EXPERIENCE);
        preparedStatement.setInt(1, experience);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Driver> result = new ArrayList<>();
        while (resultSet.next()) {
            Driver driver = Driver.builder()
                    .id(resultSet.getLong("id"))
                    .firstName(resultSet.getString("first_name"))
                    .lastName(resultSet.getString("last_name"))
                    .age(resultSet.getInt("age"))
                    .city(resultSet.getString("city"))
                    .gender(resultSet.getString("gender"))
                    .experience(resultSet.getInt("experience"))
                    .build();
            result.add(driver);
        }
        return result;
    }
}
