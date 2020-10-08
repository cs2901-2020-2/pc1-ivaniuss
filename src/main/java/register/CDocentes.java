package register;
public class CDocentes implements Observer {
    private String title;
    private String link;
    private Subject actor;

    public CDocentes(Subject actor) {
        this.actor = actor;
        actor.registerObserver(this);
    }

    public void update(String title, String link) {
        this.title = title;
        this.link = link;
    }
}