package regular;

import java.util.Iterator;
import java.util.Set;

public class Weight {
    public static Repository totalWeight(Repository repository) {
        Set<String> modeSet = repository.uniqueMode();
        for (String mode : modeSet) {
//            Repository tempRep = repository.getRepositoryUniqueMode(mode);
//            Iterator<Record> record = tempRep.getRepository().iterator();
//            while (record.hasNext()) {
//                Record tempRec = record.next();
//                while (tempRec.getReference() != -1) {
//                    Complex TotalComplexWeight = tempRec.getComplexWeight();
//                    TotalComplexWeight.plus(tempRec.getComplexWeight())
//                    tempRec.setTotalComplexWeight();
//                }
//            }
        }


        return null;
    }
}
