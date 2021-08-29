package JDBCImplementations.Service;

import JDBCImplementations.DB.DatabaseService;
import JDBCImplementations.Entity.Person;
import JDBCImplementations.Exceptions.UserCouldNotFoundException;
import JDBCImplementations.DB.Interfaces.IDatabaseService;
import JDBCImplementations.Service.Interfaces.IPersonService;

import java.sql.SQLException;

public class PersonService implements IPersonService {

    private static IDatabaseService database;


    // Şu kısım Spring'e bırakılacak
    public PersonService() {
        database = new DatabaseService();
    }



    @Override
    public void updateUserService(int id, Person person) {
        try {
            database.updateUser(id, person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUserService(int id) {
        try {
            database.deleteUser(id);
        } catch (UserCouldNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createUserService(Person person) {
        try {
            database.createUser(person);
        } catch (UserCouldNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readUserService(int id) {
        try {
            database.readUser(id);
        } catch (UserCouldNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


}
