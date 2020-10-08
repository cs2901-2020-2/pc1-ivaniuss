package register;
import java.util.ArrayList;

public class Actor implements Subject{
    public ArrayList observers;
    private String title;
    private String link;


    public Actor(){
        observers = new ArrayList();
    }

    public void registerObserver(Observer o){
        observers.add(o);
    }

    public void removeObserver(Observer o){
        int i = observers.indexOf(o);
        if (i >= 0){
            observers.remove(i);
        }
    }

    public void notifyObservers(){
        for(int i = 0; i < observers.size(); i++){
            Observer observer = (Observer)observers.get(i);
            observer.update(title, link);
        }
    }

    public void measurementsChanged(){
        notifyObservers();
    }
    public void registerInformation(String title, String link) {
        

        this.title = title;
        this.link = link;
        measurementsChanged();
    }
}