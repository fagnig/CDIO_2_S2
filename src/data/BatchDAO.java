package data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BatchDAO implements IBatchDAO {
    private List<BatchDTO> batchDTOList;

    public BatchDAO(){
        batchDTOList = new ArrayList<BatchDTO>();

        BatchDTO tempBatch = new BatchDTO(); //Hardcoded batch as given in the problem description
        tempBatch.setBatchID(1234);
        tempBatch.setBatchName("Salt");
        tempBatch.setBatchTolerance(150);
        tempBatch.setBatchWeight(750);

        try {
            createBatch(tempBatch);
        } catch(DALException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public BatchDTO getBatch(int batchID) throws DALException {
        Iterator iterator = batchDTOList.iterator();
        while (iterator.hasNext()) {
            BatchDTO tempBatch = (BatchDTO) iterator.next();
            if (tempBatch.getBatchID() == batchID) {
                return tempBatch;
            }
        }

        throw new DALException("Fejl: Batch ikke fundet!");
    }

    @Override
    public void createBatch(BatchDTO batch) throws DALException {
        Iterator iterator = batchDTOList.iterator();
        while (iterator.hasNext()) {
            if (((BatchDTO) iterator.next()).getBatchID() == batch.getBatchID()) {
                throw new DALException("Fejl: Bruger eksisterer allerede!");
            }
        }
        BatchDTO tempBatch = new BatchDTO();
        tempBatch.setBatchID(batch.getBatchID());
        tempBatch.setBatchName(batch.getBatchName());
        tempBatch.setBatchTolerance(batch.getTolerance());
        tempBatch.setBatchWeight(batch.getWeight());
        batchDTOList.add(tempBatch);
    }

    @Override
    public void deleteBatch(int batchID) throws DALException {
        Iterator iterator = batchDTOList.iterator();
        boolean j = false;
        while (iterator.hasNext()) {
            if (((BatchDTO) iterator.next()).getBatchID() == batchID) {
                iterator.remove();
                j = true;
            }
        }
        if (!j) {
            throw new DALException("Fejl: Bruger ikke fundet!");
        }
    }
}
