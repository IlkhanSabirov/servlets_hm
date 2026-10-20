// ДЗ

package ru.itis.services;

import ru.itis.dto.DriverForm;
import ru.itis.models.Driver;
import ru.itis.repository.DriversRepository;

import java.sql.SQLException;
import java.util.List;

public class DriversServiceImpl implements DriversService {

    private DriversRepository driversRepository;

    public DriversServiceImpl(DriversRepository driversRepository) {
        this.driversRepository = driversRepository;
    }

    @Override
    public Integer getCountForSave() throws SQLException {
        return driversRepository.findCountForSave();
    }

    @Override
    public void saveDrivers(List<DriverForm> forms) throws SQLException {
        for (DriverForm form : forms) {
            Driver driver = Driver.builder()
                    .firstName(form.getFirstName())
                    .lastName(form.getLastName())
                    .age(form.getAge())
                    .city(form.getCity())
                    .gender(form.getGender())
                    .experience(form.getExperience())
                    .build();
            driversRepository.save(driver);
        }
    }

    @Override
    public List<Driver> getAllByCity(String city) throws SQLException {
        return driversRepository.findAllByCity(city);
    }

    @Override
    public List<Driver> getAllByGender(String gender) throws SQLException {
        return driversRepository.findAllByGender(gender);
    }

    @Override
    public List<Driver> getAllByExperience(Integer experience) throws SQLException {
        return driversRepository.findAllByExperience(experience);
    }
}
