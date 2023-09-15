package Classes;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Task {
    
    private String title;
    private String description;
    private boolean done;
    private int rewardPoints;
    private Date date;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(String date) throws ParseException {
        SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.date = dtf.parse(date);
    }

    @Override
    public String toString(){
        StringBuilder build = new StringBuilder();
        build.append(getTitle());
        build.append(";");
        build.append(getDescription());
        build.append(";");
        build.append(String.valueOf(done));
        build.append(";");
        build.append(String.valueOf(rewardPoints));
        build.append(";");
        SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        build.append(dtf.format(date));
        return build.toString();
    }

}
