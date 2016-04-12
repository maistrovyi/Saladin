package com.maystrovoy.service;

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

    private final String DB_CONNECTION = "jdbc:Oracle:thin:@10.1.32.39:1521:MAXIMO2T";
    private final String DB_USER = "MXSAP";
    private final String DB_PASSWORD = "INTEGRATION";

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
        Queue queue = queueFactory.createInstance(location + "-" + materialSap, login, QueueFactory.ObjectType.CHECK_STOCK.getObjectTypeValue());
        checkStockDAO.addQueue(queue);
    }

    public String checkCorrectLocationValue(String location) throws SQLException {
        String error = null;
        try (Connection connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD)) {
        DriverManager.registerDriver(new OracleDriver());
        System.out.println("Connection into MAXIMO2T LOCATIONS ... ");
        PreparedStatement preparedStatement = connection.prepareStatement(LOCATION_QUERY);
        preparedStatement.setString(1, location);
        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.println("Executing LOCATIONS query ... ");
        if (!resultSet.next()) {
            error = "Location is invalid! Please, input correct location.";
            System.out.println("LOCATION IS NOT EXIST!");
        } else {
            error = null;
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        if (connection.isClosed()) {
            System.out.println("Connection Location closed!");
        }
        } catch (Exception e) {
            LOGGER.error("Error closing connection!");
        }
        return error;
    }

    public String checkCorrectMaterialValue(String material) {
        String error = null;
        try (Connection connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD)) {
            DriverManager.registerDriver(new OracleDriver());
            System.out.println("Connection into MAXIMO2T ITEM ... ");
            PreparedStatement preparedStatement = connection.prepareStatement(MATERIAL_QUERY);
            preparedStatement.setString(1, material);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Executing query ... ");
            if (!resultSet.next()) {
                error = "Material is invalid! Please, input correct material.";
            } else {
                error = null;
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            if (connection.isClosed()) {
                System.out.println("Connection Material closed!");
            }
        } catch (Exception e) {
            LOGGER.error("Error closing connection!");
        }
        return error;
    }

}
