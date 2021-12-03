public class Usuario {
    private String password;
    private String username;
    Usuario(){}
    Usuario(String usr, String pass){
        setUsername(usr);
        setPassword(pass);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
