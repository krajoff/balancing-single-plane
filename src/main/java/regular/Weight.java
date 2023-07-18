package regular;

import java.util.Set;

public class Weight {
    public static void total(Repository repository) {
        Set<String> modeSet = repository.uniqueMode();
        Complex totalWeight;
        Record tempRecord, phaseRecord;
        int BaseId;
        double pTotWgt;
        boolean initial;
        for (String mode : modeSet) {
            Repository uniqueModeRep = repository.getRepositoryUniqueMode(mode);
            for (Record value : uniqueModeRep.getRepository()) {
                tempRecord = value;
                phaseRecord = tempRecord;
                BaseId = tempRecord.getId();
                initial = true;
                pTotWgt = 0;
                while (initial) {
                    if (phaseRecord.getReference() == -1) {
                        initial = false;
                        pTotWgt = pTotWgt + phaseRecord.getComplexWeight().phase();
                        repository.getRecord(BaseId).
                                setPhaseReferenceWeight(Math.toDegrees(pTotWgt));
                    } else {
                        pTotWgt = pTotWgt + phaseRecord.getComplexWeight().phase();
                        phaseRecord = uniqueModeRep.getRecord(phaseRecord.getReference() - 1);
                    }
                }
                initial = true;
                totalWeight = Transform.toComplex(0, 0);
                while (initial) {
                    if (tempRecord.getReference() == -1) {
                        initial = false;
                        totalWeight = totalWeight.plus(Transform.toComplex(
                                tempRecord.getComplexWeight().abs(),
                                tempRecord.getPhaseReferenceWeight()));
                        repository.getRecord(BaseId).
                                setComplexTotalWeight(totalWeight);
                        repository.getRecord(BaseId).
                                setMagnitudeTotalWeight(totalWeight.abs());
                        repository.getRecord(BaseId).
                                setPhaseTotalWeight(Math.toDegrees(totalWeight.phase()));
                    } else {
                        totalWeight = totalWeight.plus(Transform.toComplex(
                                tempRecord.getComplexWeight().abs(),
                                tempRecord.getPhaseReferenceWeight()));
                        tempRecord = uniqueModeRep.getRecord(tempRecord.getReference() - 1);
                    }
                }

            }
        }
    }

    public static void target(Repository repository) {
        Set<String> modeSet = repository.uniqueMode();
        int BaseId;
        Complex tWeight;
        for (String mode : modeSet) {
            Repository uniqueModeRep = repository.getRepositoryUniqueMode(mode);
            for (Record record : uniqueModeRep.getRepository()) {
                BaseId = record.getId();
                if (record.getReference() != -1) {
                    tWeight = TargetWeight.calculation
                            (record, uniqueModeRep.getRecord(record.getReference() - 1));
                    repository.getRecord(BaseId).
                            setComplexTargetWeight(tWeight);
                    repository.getRecord(BaseId).
                            setMagnitudeTargetWeight(tWeight.abs());
                    repository.getRecord(BaseId).
                            setPhaseTargetWeight(Math.toDegrees(tWeight.phase()));
                }
            }
        }
    }
}