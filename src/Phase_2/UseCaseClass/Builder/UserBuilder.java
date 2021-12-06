package Phase_2.UseCaseClass.Builder;

import Phase_2.Entity.NormalUser;
import Phase_2.Entity.User;

public class UserBuilder {
    private User norm;

    public void setUserInfo(String id, String password, String sq, String sa) {
        this.norm = new NormalUser(id, password, sq, sa);
    }
    public User re(){
        return  this.norm;
    }

}
