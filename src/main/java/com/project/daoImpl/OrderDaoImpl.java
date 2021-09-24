package com.project.daoImpl;

import com.project.constants.SqlConstants;
import com.project.daobd.OrderDao;
import com.project.model.Order;
import com.project.utils.WrapperConnector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
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
            preparedStatement = connection.prepareStatement(SqlConstants.SQL_INSERT_NEW_ORDER,
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

    @Override
    public List findAllOrders() {
        List<Order> orderList = new LinkedList<>();
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            conn = wrapperConnection.getConnection();
            conn.setAutoCommit(false);

            statement = conn.createStatement();
            rs = statement.executeQuery(SqlConstants.SQL_FIND_ALL_ORDERS);
            while (rs.next()) {
                orderList.add(buildOrder(rs));
            }
            conn.commit();
        } catch (SQLException | ClassNotFoundException throwables) {
            logger.error(throwables.getMessage());
            WrapperConnector.rollback(conn);
        } finally {
            wrapperConnection.close(rs);
            wrapperConnection.close(statement);
            wrapperConnection.close(conn);
        }
        return orderList;
    }

    @Override
    public List findUserOrders(int userId) {
        List<Order> orderList = new LinkedList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            conn = wrapperConnection.getConnection();
            conn.setAutoCommit(false);

            statement = conn.prepareStatement(SqlConstants.SQL_FIND_USER_ORDERS);
            statement.setInt(1,userId);

            rs = statement.executeQuery();
            while (rs.next()) {
                orderList.add(buildOrder(rs));
            }
            conn.commit();
        } catch (SQLException | ClassNotFoundException throwables) {
            logger.error(throwables.getMessage());
            WrapperConnector.rollback(conn);
        } finally {
            wrapperConnection.close(rs);
            wrapperConnection.close(statement);
            wrapperConnection.close(conn);
        }
        return orderList;
    }

    private Order buildOrder(ResultSet rs) throws SQLException {
        Order order = new Order();
        order.setOrderName(rs.getString("order_name"));
        order.setOrderPrice(rs.getDouble("order_price"));
        order.setOrderDate(rs.getDate("order_date"));
        order.setOrderStatus(rs.getString("order_status"));
        order.setPaymantStatus(rs.getString("paymant_status"));
        order.setUserid(rs.getInt("id_user"));
        return order;
    }
}
