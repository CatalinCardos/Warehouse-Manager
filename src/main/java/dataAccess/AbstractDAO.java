package dataAccess;

import com.mysql.cj.xdevapi.Statement;
import connectionFactory.ConnectionFactory;
import model.Client;

import javax.sql.StatementEvent;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());
    private final Class<T> type;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public String queryInsert()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("insert into `");
        sb.append(type.getSimpleName());
        sb.append("` (");
        int nrOfTypes = 0;
        try {

                int ok = 0;
                nrOfTypes = type.getDeclaredFields().length;
                for (Field field : type.getDeclaredFields()) {
                    if(ok > 0 && ok < type.getDeclaredFields().length - 1){
                        String fieldName = field.getName();
                        sb.append(fieldName);
                        sb.append(", ");
                    }
                    if(ok == type.getDeclaredFields().length - 1 )
                    {
                        String fieldName = field.getName();
                        sb.append(fieldName);
                        sb.append(")");
                    }
                    ok ++;
                }

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        sb.append(" values (");
        for (int i = 0; i < nrOfTypes - 2; i++) {
            sb.append("?, ");
        }
        sb.append("?)");
        return sb.toString();
    }
    public List<T> findAll()
    {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory. getConnection();

            statement = connection.prepareStatement("select * from " + "`" + type.getSimpleName() + "`");
            resultSet = statement.executeQuery();

            return createObjects(resultSet);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findALL " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;


    }
    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM `");
        sb.append(type.getSimpleName());
        sb.append("` WHERE " + field + " = ?");
        return sb.toString();
    }

    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Field[] allFields = type.getDeclaredFields();
        String query = createSelectQuery(allFields[0].getName());
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    public String deleteQuery()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("delete from `");
        sb.append(type.getSimpleName());
        sb.append("` where ");
        return sb.toString();
    }

    public void deleteById(int id, String chosenType)
    {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = deleteQuery();
        query = query + chosenType + "= ?";

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:deleteById " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }
    public T findByName(String name) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("nume");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, name);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findByName " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    public String updateQuery()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("update `");
        sb.append(type.getSimpleName());
        sb.append("` set ");
        Field[] allFields = type.getDeclaredFields();
        for (int i = 1; i < type.getDeclaredFields().length - 1; i++)
        {

                sb.append(allFields[i].getName());
                sb.append(" = ?, ");
        }
        sb.append(allFields[type.getDeclaredFields().length - 1].getName());
        sb.append(" = ? where ");
        sb.append(allFields[0].getName());
        sb.append("= ?");
        return sb.toString();
    }
    public void update(T e)
    {
        Connection connection = null;
        PreparedStatement statement = null;
        List<Object> objectList = new ArrayList<>();
        try {
            connection = ConnectionFactory. getConnection();
            String query = updateQuery();
            statement = connection.prepareStatement(query);
            boolean ok = false;
            for (Field field : type.getDeclaredFields()){
                field.setAccessible(true);
                    Object v = field.get(e);
                    objectList.add(v);
            }

            int i;
            for (i = 1; i < type.getDeclaredFields().length; i++) {
                statement.setObject(i,objectList.get(i));
            }
            statement.setObject(i,objectList.get(0));
            statement.executeUpdate();
        } catch (SQLException a) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + a.getMessage());
        }  catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }  finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }
    public void insert(T e)
    {
        Connection connection = null;
        PreparedStatement statement = null;
        List<Object> objectList = new ArrayList<>();
        try {
            connection = ConnectionFactory. getConnection();
            String query = queryInsert();
            statement = connection.prepareStatement(query);
            boolean ok = false;
            for (Field field : type.getDeclaredFields()){
                field.setAccessible(true);
                if(ok)
                {
                    Object v = field.get(e);
                    objectList.add(v);
                }
                ok = true;
            }

            for (int i = 0; i < type.getDeclaredFields().length - 1; i++) {
                statement.setObject(i + 1,objectList.get(i));
            }
            statement.executeUpdate();
        } catch (SQLException a) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + a.getMessage());
        }  catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }  finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T)ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

}
