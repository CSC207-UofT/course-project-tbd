package Phase_2.UseCaseClass.Builder;

import Phase_2.Entity.User;

public class BuilderDirector {
    private UserBuilder userBuilder;

    /**
     * BuilderDirector receive new user information and calls an appropriate UserBuilder to create NormalUser instance
     * @param id username of the new user
     * @param password password of the new user
     * @param sq security question of new user
     * @param sa security answer of new user
     */
    public void setInfo(String id, String password, String sq, String sa){
            this.userBuilder = new UserBuilder();
            userBuilder.setUserInfo(id, password, sq, sa);

    }
    /**
     * return the user built by the builder and set builder to null
     * @return user that is created by the builder
     */
    public User buildNormalUser(){
        User user = userBuilder.re();
        userBuilder = null;
        return user;

    }
}
