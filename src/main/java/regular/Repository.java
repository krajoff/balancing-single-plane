package regular;

import java.util.*;

import regular.Record;

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
        repository.removeIf(record1
                -> record1.equals(record));
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

    public Repository getRepositoryUniqueMode(String mode) {
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

    public Record getRecord(int id) {
        return repository.get(id);
    }


    @Override
    public String toString() {
        return "Repository{" +
                "repository=" + repository +
                '}';
    }

    public void printTable() {
        int[] sml = Record.sml;
        String pline = "+" + "-".repeat(sml[1] + 2) +
                "+" + "-".repeat(sml[1] + 2) + "+" + "-".repeat(sml[2] + 2);
        String line = "+" + "-".repeat(sml[0] + 2) +
                "+" + "-".repeat(sml[1] + 2) + pline + pline +
                "+" + "-".repeat(sml[0] + 2) + pline +
                "+" + "-".repeat(sml[0] + 2) + "+";
        System.out.println(line);
        String head = "|" + " ".repeat(sml[0] - "id".length() + 1) + "id |" +
                headColumn(sml[1], "mode") + headColumn(sml[1], "mP2P") +
                headColumn(sml[1], "pP2P") + headColumn(sml[2], "zP2P") +
                headColumn(sml[1], "mWeight") + headColumn(sml[1], "pWeight") +
                headColumn(sml[2], "zWeight") + headColumn(sml[0], "ref") +
                headColumn(sml[1], "mTotWgt") + headColumn(sml[1], "pTotWgt") +
                headColumn(sml[2], "zTotWgt") + headColumn(sml[0], "use");
        System.out.println(head);
        System.out.println(line);
        System.out.print(Arrays.toString(repository.toArray()).
                replace("[", "").
                replace("]", "").
                replace(", ", ""));
        System.out.println(line);
    }

    private String headColumn(int n, String title) {
        return " ".repeat(n - title.length() + 1) + title + " |";
    }

}
