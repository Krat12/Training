package wsr.igorromanov.registration;


public class FieldRegistration {
    private final String NAME;
    private final String LOGIN;
    private final String PASSWORD;
    private final String ROLE;

    public FieldRegistration(String NAME, String LOGIN, String PASSWORD, String ROLE) {
        this.NAME = NAME;
        this.LOGIN = LOGIN;
        this.PASSWORD = PASSWORD;
        this.ROLE = ROLE;
    }

    public String getName() {
        return NAME;
    }

    public String getLogin() {
        return LOGIN;
    }

    public String getPassword() {
        return PASSWORD;
    }

    public String getRole() {
        return ROLE;
    }
    
    

}
