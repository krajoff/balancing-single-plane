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


    public Set<String> uniqueMode() {
        Iterator<Record> record = repository.iterator();
        Set<String> set = new HashSet<>();
        while (record.hasNext()) {
            String mode = record.next().getMode();
            set.add(mode);
        }
        return set;
    }

    public Repository getRepositoryUniqueMode(String mode){
        Iterator<Record> record = repository.iterator();
        Repository repository = new Repository();
        while (record.hasNext()) {
            Record tempRecord = record.next();
            if (tempRecord.getMode().equals(mode)) {
                repository.add(tempRecord);
            }
        }
        return repository;
    }

    public List<Record> getRepository() {
        return repository;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "repository=" + repository +
                '}';
    }

    public void printTable() {
        System.out.print("+------------+---------+---------+-------------------");
        System.out.print("+---------+---------+--------------------");
        System.out.print("+-----+-----+\n" + "|       mode ");
        System.out.print("|    mP2P |    pP2P |              zP2P ");
        System.out.print("| mWeight | pWeight |            zWeight ");
        System.out.print("| ref | use |\n");
        System.out.print("+------------+---------+---------+-------------------");
        System.out.print("+---------+---------+--------------------");
        System.out.print("+-----+-----+\n");
        System.out.print(Arrays.toString(repository.toArray()).
                replace("[", "").
                replace("]", "").
                replace(", ", ""));
        System.out.print("+------------+---------+---------+-------------------");
        System.out.print("+---------+---------+--------------------");
        System.out.println("+-----+-----+");
    }

}
