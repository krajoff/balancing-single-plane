package regular;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Repository {

    private List<Record> repository = new ArrayList<>();

    public Repository(List<Record> repository) {
        this.repository = repository;
    }

    public Repository() {
        new Repository(repository);
    }

    public void add(Record record) {
        repository.add(record);
    }

    public void remove(Record record) {
        ListIterator<Record> iterator = repository.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(record)) {
                iterator.remove();
            }
        }
    }

    public List<Record> getRepository() {
        return repository;
    }

    @Override
    public String toString() {
        return "Vibration data:\n" +
                Arrays.toString(repository.toArray()).
                        replace("[", "").
                        replace("]", "").
                        replace(", ", "");
    }
}
