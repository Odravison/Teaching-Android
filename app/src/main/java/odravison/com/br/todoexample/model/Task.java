package odravison.com.br.todoexample.model;

/**
 * Created by odravison on 11/10/16.
 */

public class Task {

    private String taskText;
    private boolean done;

    public Task(String taskText) {
        this.taskText = taskText;
        this.done = false;
    }

    public void checkTask (){
        this.done = true;
    }

    public void unchekTask(){
        this.done = false;
    }

    public void setTaskText(String taskText){
        this.taskText = taskText;
    }

    public String getTaskText(){
        return this.taskText;
    }
}
