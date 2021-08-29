package JDBCImplementations.DB;
import JDBCImplementations.Entity.Person;
import JDBCImplementations.Exceptions.ServiceException;
import JDBCImplementations.Exceptions.UserCouldNotFoundException;
import JDBCImplementations.DB.Interfaces.IDatabaseService;
import java.sql.*;

public class DatabaseService implements IDatabaseService {

    private static final PostgresDB postgresDB = PostgresDB.getSingleDatabaseObject();
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    @Override
    public ResultSet getUser(int id) {
        try {
            connection = DriverManager.getConnection(postgresDB.prepareFullConnectionUrl());
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Persons WHERE personid ="+id);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultSet;
    }

    @Override
    public void updateUser(int id, Person person) throws Exception {

        if (getUser(id)== null){
           throw new UserCouldNotFoundException("Kullanıcı bulunamadı");
        }

        try {
            connection = DriverManager.getConnection(postgresDB.prepareFullConnectionUrl());
            preparedStatement = connection.prepareStatement("UPDATE Persons SET firstname = ? , lastname = ? , address = ? , city = ? , phone = ? WHERE personid = ?");
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setString(3, person.getAddress());
            preparedStatement.setString(4, person.getCity());
            preparedStatement.setString(5, person.getPhone());
            preparedStatement.setInt(6, id);
            if(preparedStatement.executeUpdate()==1){
                System.out.println("Güncelleme işlemi başarılı");
            }else{
                throw new ServiceException("Güncelleme işlemi başarısız");
            }


        } catch (SQLException | ServiceException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void deleteUser(int id) throws UserCouldNotFoundException, SQLException {

        if (!getUser(id).next()){
            throw new UserCouldNotFoundException("Kullanıcı bulunamadı");
        }
        try {
            connection = DriverManager.getConnection(postgresDB.prepareFullConnectionUrl());
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM Persons WHERE personid="+id);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void createUser(Person person) throws UserCouldNotFoundException {
        try {
            connection = DriverManager.getConnection(postgresDB.prepareFullConnectionUrl());
            preparedStatement = connection.prepareStatement("INSERT INTO Persons (firstname, lastname, address, city, phone) VALUES (?,?,?,?,?)");
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setString(3, person.getAddress());
            preparedStatement.setString(4, person.getCity());
            preparedStatement.setString(5, person.getPhone());
            if(preparedStatement.executeUpdate()==1){
                System.out.println("Kayıt ekleme işlemi başarılı");
            }else{
                System.out.println("Kayıt ekleme işlemi başarısız");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void readUser(int id) throws UserCouldNotFoundException, SQLException {
        if (!getUser(id).next()){
            throw new UserCouldNotFoundException("Kullanıcı bulunamadı");
        }
        try {
            connection = DriverManager.getConnection(postgresDB.prepareFullConnectionUrl());
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Persons WHERE personid="+id);

            if(resultSet.next()){
                System.out.format("%s %s,%s/%s",
                        resultSet.getString(3),
                        resultSet.getString(2),
                        resultSet.getString(4),
                        resultSet.getString(5)
                  );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
