package JDBCImplementations.DB.Interfaces;

import JDBCImplementations.Entity.Person;
import JDBCImplementations.Exceptions.UserCouldNotFoundException;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDatabaseService {
    ResultSet getUser(int id);
    void updateUser(int id, Person person) throws Exception;
    void deleteUser(int id) throws UserCouldNotFoundException, SQLException;
    void createUser(Person person)  throws UserCouldNotFoundException;
    void readUser(int id) throws UserCouldNotFoundException, SQLException;
}
