package data;

import model.Magazin;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Sauveur extends ISauveur{

    @Override
    public void save(Magazin magazin) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("fichier.bin"))){
            oos.writeObject(magazin);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
