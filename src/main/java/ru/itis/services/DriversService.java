// ДЗ

package ru.itis.services;

import ru.itis.dto.DriverForm;
import ru.itis.models.Driver;

import java.sql.SQLException;
import java.util.List;

public interface DriversService {
    Integer getCountForSave() throws SQLException;
    void saveDrivers(List<DriverForm> forms) throws SQLException;
    List<Driver> getAllByCity(String city) throws SQLException;
    List<Driver> getAllByGender(String gender) throws SQLException;
    List<Driver> getAllByExperience(Integer experience) throws SQLException;
}
