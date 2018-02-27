package data;

import java.io.Serializable;

public class BatchDTO implements Serializable {

    private static final long serialVersionUID = 4545864587995944261L;
    private int	batchID;
    private String batchName;
    private int weight;
    private int tolerance;
    //TODO add more relevant values

    public int getBatchID() {
        return batchID;
    }
    public void setBatchID(int batchID) {
        this.batchID = batchID;
    }
    public String getBatchName() {
        return batchName;
    }
    public void setBatchName(String batchName) { this.batchName = batchName; }

    @Override
    public String toString() {
        return "BatchDTO [batchId=" + batchID + ", batchName=" + batchName + "]";
    }

}
