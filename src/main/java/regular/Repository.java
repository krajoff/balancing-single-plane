package regular;

import org.apache.poi.ss.usermodel.Cell;

import java.util.*;

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
        repository.removeIf(record1 -> record1.equals(record));
    }


    public int unique() {
        Iterator<Record> record = repository.iterator();
        int unique = 0;
        while (record.hasNext()) {
            String mode = record.next().getMode();
        }
        return 0;
    }

    public List<Record> getRepository() {
        return repository;
    }

    @Override
    public String toString() {
        return
                "+------------+---------+---------+-------------------" +
                        "+---------+---------+--------------------" +
                        "+-----+-----+\n" + "|       mode " +
                        "|    mP2P |    pP2P |              zP2P " +
                        "| mWeight | pWeight |            zWeight " +
                        "| ref | use |\n" +
                        "+------------+---------+---------+-------------------" +
                        "+---------+---------+--------------------" +
                        "+-----+-----+\n" +

                        Arrays.toString(repository.toArray()).
                                replace("[", "").
                                replace("]", "").
                                replace(", ", "") +

                        "+------------+---------+---------+-------------------" +
                        "+---------+---------+--------------------" +
                        "+-----+-----+";
    }
}
