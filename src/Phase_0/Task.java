package Phase_0;

public class Task {
    public String title;
    public String information;
    public boolean status;

    public Task(String title){
        this.title = title;
        this.status = false;
    }

    public Task(String title, String information){
        this.title = title;
        this.information = information;
        this.status = false;
    }

    public void setStatus(Boolean status){this.status = status;}

    public boolean getStatus(){
        return this.status;
    }


    public String getTaskName(){
        return this.title;
    }

    public void completeTask(){
        this.status = true;
    }

    @Override
    public String toString() {
        String s = "Title: " + this.title + "\n";
        s += "TODO: " + this.information;
        return s;
    }
}
