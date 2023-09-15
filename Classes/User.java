package Classes;

import Classes.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
    
    private ArrayList<Task> taskList;
    private int pointBalance;

    public User(){
        this.taskList = new ArrayList<Task>();
        initPoints();
        initTasks();
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public int getPointBalance() {
        return pointBalance;
    }

    public void setPointBalance(int pointBalance) {
        this.pointBalance = pointBalance;
    }


    public void initPoints(){
        /*
         * Init user's points
         */
        try{
            Scanner scan = new Scanner(new File("Data/user.csv"));
            if(!scan.hasNextLine()){ //New User
                try{
                    FileWriter writer = new FileWriter("Data/user.csv");
                    writer.write("0");
                    writer.close();
                    pointBalance = 0;   
                }
                catch(IOException e){
                    System.out.println("Error");
                }
            }
            else{ //User already exist
                String filePoints = scan.nextLine();
                pointBalance = Integer.parseInt(filePoints);
            }
            scan.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Le fichier n'existe pas");
        }
    }

    public void initTasks(){
        /*
         * Init user's tasks
         */
        try{
            Scanner scan = new Scanner(new File("Data/tasks.csv"));
            if(!scan.hasNextLine()){
                this.taskList = new ArrayList<Task>();
                System.out.println(this.taskList);
            }
            else{
                while(scan.hasNextLine()){
                    String[] data = scan.nextLine().split(";");
                    Task task = new Task();
                    try{
                        task.setTitle(data[0]);
                        task.setDescription(data[1]);
                        task.setDone(Boolean.parseBoolean(data[2]));
                        task.setRewardPoints(Integer.parseInt(data[3]));
                        task.setDate(data[4]);
                        this.taskList.add(task);
                        
                    }
                    catch(ParseException e){
                        System.out.println("Error reading tasks from tasks.csv file");
                    }
                    
                }
            }

        }
        catch(FileNotFoundException e){
            System.out.println("Le fichier n'existe pas");
        }
    }


}
