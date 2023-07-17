package regular;

import java.util.Iterator;
import java.util.Set;

public class TotalWeight {
    public static void calculation(Repository repository) {
        Set<String> modeSet = repository.uniqueMode();
        Complex totalWeight;
        Record tempRecord;
        int BaseId;
        boolean initial;
        for (String mode : modeSet) {
            Repository uniqueModeRep = repository.getRepositoryUniqueMode(mode);
            Iterator<Record> record = uniqueModeRep.getRepository().iterator();
            while (record.hasNext()) {
                tempRecord = record.next();
                BaseId = tempRecord.getId();
                initial = true;
                totalWeight = Transform.toComplex(0, 0);
                while (initial) {
                    if (tempRecord.getReference() == -1) {
                        initial = false;
                        totalWeight = totalWeight.plus(tempRecord.getComplexWeight());
                        repository.getRecord(BaseId).
                                setTotalComplexWeight(totalWeight);
                        repository.getRecord(BaseId).
                                setTotalMagnitudeWeight(totalWeight.abs());
                        repository.getRecord(BaseId).
                                setTotalPhaseWeight(Math.toDegrees(totalWeight.phase()));
                    } else {
                        totalWeight = totalWeight.plus(tempRecord.getComplexWeight());
                        tempRecord = uniqueModeRep.getRecord(tempRecord.getReference() - 1);
                    }
                }
            }
        }
    }
}