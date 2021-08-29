package JDBCImplementations.Service.Interfaces;

import JDBCImplementations.Entity.Person;

public interface IPersonService {
    void updateUserService(int id, Person person);
    void deleteUserService(int id);
    void readUserService(int id);
    void createUserService(Person person);
}
