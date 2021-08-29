package JDBCImplementations.DB;

public class PostgresDB {
    // variables
    private final String connectionAddress = "jdbc:postgresql://";
    private String host = "localhost";
    private String databaseName = "postgres";
    private String username = "postgres";
    private String password = "1234";

    // constructers
    private PostgresDB(){}


    // SINGLETON
    private static PostgresDB database;

    public static PostgresDB getSingleDatabaseObject(){
        if( database == null){
            return new PostgresDB();
        }
        return database;
    }

    // Metods

    public String prepareFullConnectionUrl(){
        return this.getConnectionAddress()+this.getHost()+this.getDatabaseName()+this.getUsername()+this.getPassword();
    }


    // - - - Getter Setter - - - - - - - - - - - - - - - - - - -

    public String getConnectionAddress() {
        return connectionAddress;
    }

    public String getHost() {
        return host+"/";
    }

    public void setHost(String host) {
        database.host = host;
    }

    public String getDatabaseName() {
        return databaseName+"?";
    }

    public void setDatabaseName(String databaseName) {
        database.databaseName = databaseName;
    }

    public String getUsername() {
        return "user="+username;
    }

    public void setUsername(String username) {
        database.username = username;
    }

    public String getPassword() {
        return "&password="+password;
    }

    public void setPassword(String password) {
        database.password = password;
    }
}
