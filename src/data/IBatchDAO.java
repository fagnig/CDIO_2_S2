package data;

public interface IBatchDAO {
    BatchDTO getBatch(int batchID) throws DALException;
    void createBatch(BatchDTO batch) throws DALException;
    void deleteBatch(int batchID) throws DALException;
}
