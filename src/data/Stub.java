package data;

import model.Article;
import model.Habit;
import model.Magazin;
import model.Parfum;

import java.util.ArrayList;
import java.util.List;

public class Stub {
    public List<Article> creerMagazin(){
        List<Article> m = new ArrayList<>();

        Parfum p1 = new Parfum("parfum1", 25.5f);
        Parfum p2 = new Parfum("parfum2", 30);
        m.add(p1);
        m.add(p2);

        Habit h1 = new Habit("habit1", 12);
        Habit h2 = new Habit("habit2", 14.50f);
        m.add(h1);
        m.add(h2);

        return m;
    }
}
