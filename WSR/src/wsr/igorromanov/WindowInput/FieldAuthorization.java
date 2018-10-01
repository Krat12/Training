package wsr.igorromanov.WindowInput;


public class FieldAuthorization {
    private String LOGIN;
    private String PASSWORD;

    public FieldAuthorization(String Login, String PASSWORD) {
        this.LOGIN = Login;
        this.PASSWORD = PASSWORD;
    }

    public String getLogin() {
        return LOGIN;
    }

    public String getPassword() {
        return PASSWORD;
    }

    public void setLogin(String LOGIN) {
        this.LOGIN = LOGIN;
    }

    public void setPassword(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }
    

}
