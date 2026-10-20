// ДЗ

package ru.itis.repository;

import ru.itis.models.Driver;

import java.sql.SQLException;
import java.util.List;

public interface DriversRepository extends CrudRepository<Driver> {
    Integer findCountForSave() throws SQLException;
    List<Driver> findAllByCity(String city) throws SQLException;
    List<Driver> findAllByGender(String gender) throws SQLException;
    List<Driver> findAllByExperience(Integer experience) throws SQLException;
}
