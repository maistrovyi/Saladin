package com.maystrovoy.service;

import com.maystrovoy.config.ApplicationConfig;
import com.maystrovoy.dao.QueueDAO;
import com.maystrovoy.factory.QueueFactory;
import com.maystrovoy.model.Queue;
import oracle.jdbc.driver.OracleDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.sql.*;

@Service
public class CheckStockService {

    private final String LOCATION_QUERY = "SELECT LOCATION FROM MAXIMO.LOCATIONS WHERE LOCATION = ?";
    private final String MATERIAL_QUERY = "SELECT ITEMNUM FROM MAXIMO.ITEM WHERE ITEMNUM = ?";

    private static final Logger LOGGER = LogManager.getLogger(CheckStockService.class);

    @Autowired
    private QueueDAO checkStockDAO;

    @Qualifier("queueFactory")
    @Autowired
    private QueueFactory queueFactory;

    @Inject
    private MaterialService materialService;

    public void processCheckStock(String location, String material, String login) {
        String materialSap = materialService.optimizeMaterialValue(material);
        LOGGER.info("Check Stock query : " + location + "-" + materialSap + " by user: " + login);
        Queue queue = queueFactory.createInstance(location + "-" + materialSap, login,
                QueueFactory.ObjectType.CHECK_STOCK.getObjectTypeValue());
        checkStockDAO.addQueue(queue);
    }

    public String checkCorrectLocationValue(String location, String login) throws SQLException {
        String error = null;
        LOGGER.info("Person " + login + " open " + LOCATION_QUERY + " connection for checking location: " + location);
        try (Connection connection = DriverManager.getConnection(ApplicationConfig.DB_CONNECTION_TEST,
                ApplicationConfig.DB_USER_TEST, ApplicationConfig.DB_PASSWORD_TEST)) {
            DriverManager.registerDriver(new OracleDriver());
            PreparedStatement preparedStatement = connection.prepareStatement(LOCATION_QUERY);
            preparedStatement.setString(1, location);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                error = "Location is invalid! Please, input correct location.";
            } else {
                error = null;
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            LOGGER.error("Error closing " + LOCATION_QUERY + " connection!");
        }
        return error;
    }

    public String checkCorrectMaterialValue(String material, String login) {
        String error = null;
        LOGGER.info("Person " + login + " open " + MATERIAL_QUERY + " connection for checking material: " + material);
        try (Connection connection = DriverManager.getConnection(ApplicationConfig.DB_CONNECTION_TEST,
                ApplicationConfig.DB_USER_TEST, ApplicationConfig.DB_PASSWORD_TEST)) {
            DriverManager.registerDriver(new OracleDriver());
            PreparedStatement preparedStatement = connection.prepareStatement(MATERIAL_QUERY);
            preparedStatement.setString(1, material);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                error = "Material is invalid! Please, input correct material.";
            } else {
                error = null;
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            LOGGER.error("Error closing " + MATERIAL_QUERY + " connection!");
        }
        return error;
    }

}
