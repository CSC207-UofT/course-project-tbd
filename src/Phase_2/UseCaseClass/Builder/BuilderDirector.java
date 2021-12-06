package Phase_2.UseCaseClass.Builder;

import Phase_2.Entity.User;

public class BuilderDirector {

    private UserBuilder userBuilder;
    public void setInfo(String id, String password, String sq, String sa){
            this.userBuilder = new UserBuilder();
            userBuilder.setUserInfo(id, password, sq, sa);

    }
    public User buildUser(){
        return  userBuilder.re();

    }
}
