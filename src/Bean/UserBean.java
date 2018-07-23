package Bean;

public class UserBean  implements java.io.Serializable{
    private String username;
    private String password;
    public UserBean(){

    }
    public String getUsername(){
        return username;
    }
   public String getPassword(){
        return password;
   }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
