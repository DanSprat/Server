package unnModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class unnStudent {

    @SerializedName("fio")
    @Expose
    private String fio;
    @SerializedName("shortFIO")
    @Expose
    private String shortFIO;
    @SerializedName("studentGid")
    @Expose
    private Integer studentGid;
    @SerializedName("studentOid")
    @Expose
    private Integer studentOid;

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getShortFIO() {
        return shortFIO;
    }

    public void setShortFIO(String shortFIO) {
        this.shortFIO = shortFIO;
    }

    public Integer getStudentGid() {
        return studentGid;
    }

    public void setStudentGid(Integer studentGid) {
        this.studentGid = studentGid;
    }

    public Integer getStudentOid() {
        return studentOid;
    }

    public void setStudentOid(Integer studentOid) {
        this.studentOid = studentOid;
    }
}