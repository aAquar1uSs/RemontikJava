package com.project.daobd;

import com.project.constants.SqlConstants;
import com.project.model.Order;
import com.project.utils.WrapperConnector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    private static Logger logger = LogManager.getLogger(OrderDaoImpl.class.getName());
    private WrapperConnector wrapperConnection;

    public OrderDaoImpl() {
        wrapperConnection = WrapperConnector.getInstance();
    }


    @Override
    public List<Order> getAll() {
        return null;
    }

    @Override
    public boolean update(Order entity) {
        return false;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public boolean create(Order entity) {
        return false;
    }

    @Override
    public Order getById(Integer integer) {
        return null;
    }


    @Override
    public boolean insertNewOrder(Order order) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = wrapperConnection.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(SqlConstants.INSERT_NEW_ORDER,
                    Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, order.getOrderName());
            preparedStatement.setDouble(2, order.getOrderPrice());
            preparedStatement.setDate(3, order.getOrderDate());
            preparedStatement.setString(4, order.getOrderStatus());
            preparedStatement.setString(5, order.getPaymantStatus());
            preparedStatement.setLong(6, order.getUserid());

            if (preparedStatement.executeUpdate() > 0) {
                rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    order.setId(rs.getLong(1));
                }
            }
            connection.commit();
        } catch (SQLException | ClassNotFoundException throwables) {
            WrapperConnector.rollback(connection);
            logger.error(throwables.getMessage());
        } finally {
            wrapperConnection.close(rs);
            wrapperConnection.close(preparedStatement);
            wrapperConnection.close(connection);
        }
        return false;
    }
}
