package data;

import model.Magazin;

import java.io.*;

public class Chargeur extends IChargeur{
    @Override
    public Magazin load() {
        Magazin m = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("fichier.bin"))) {
            m = (Magazin) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return m;
    }
}
