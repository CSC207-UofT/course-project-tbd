package Phase_2.UseCaseClass.Builder;

import Phase_2.Entity.NormalUser;
import Phase_2.Entity.User;

public class UserBuilder {
    private User norm;
    /**
     * This UserBuilder build NormalUser instance
     * @param id username of the new user
     * @param password password of the new user
     * @param sq security question of new user
     * @param sa security answer of new user
     */
    public void setUserInfo(String id, String password, String sq, String sa) {
        this.norm = new NormalUser(id, password, sq, sa);
    }
    /**
     * This UserBuilder build NormalUser instance
     * @return new user created
     */
    public User re(){
        return  this.norm;
    }

}
