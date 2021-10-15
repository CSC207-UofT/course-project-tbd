package Phase_0;

public class Task {

    public String information;
    public boolean status;

    public Task(String information){
        this.information = information;
        this.status = false;
    }

    public boolean getStatus(){
        return this.status;
    }

    public String getTaskName(){
        return this.information;
    }

}
