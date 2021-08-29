package JDBCImplementations;

import JDBCImplementations.Entity.Person;
import JDBCImplementations.Service.Interfaces.IPersonService;
import JDBCImplementations.Service.PersonService;

public class JDBCImplement {
    public static void main(String[] args){

        IPersonService personService = new PersonService();

//        Person person = new Person.PersonBuilder("Alex","De Souza")
//                .phone("2004")
//                .address("Kadıköy")
//                .city("İstanbul")
//                .build();
//
//        personService.createUserService(person);
//        personService.updateUserService(2, person);
//        personService.deleteUserService(7);
//        personService.readUserService(8);

    }
}
