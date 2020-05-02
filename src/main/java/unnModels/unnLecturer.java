package unnModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class unnLecturer {

    @SerializedName("chair")
    @Expose
    private String chair;
    @SerializedName("chairGid")
    @Expose
    private Integer chairGid;
    @SerializedName("chairOid")
    @Expose
    private Integer chairOid;
    @SerializedName("email")
    @Expose
    private Object email;
    @SerializedName("fio")
    @Expose
    private String fio;
    @SerializedName("lecturerGid")
    @Expose
    private Integer lecturerGid;
    @SerializedName("lecturerOid")
    @Expose
    private Integer lecturerOid;
    @SerializedName("lecturerUID")
    @Expose
    private String lecturerUID;
    @SerializedName("person")
    @Expose
    private Long person;
    @SerializedName("shortFIO")
    @Expose
    private String shortFIO;

    public String getChair() {
        return chair;
    }

    public void setChair(String chair) {
        this.chair = chair;
    }

    public Integer getChairGid() {
        return chairGid;
    }

    public void setChairGid(Integer chairGid) {
        this.chairGid = chairGid;
    }

    public Integer getChairOid() {
        return chairOid;
    }

    public void setChairOid(Integer chairOid) {
        this.chairOid = chairOid;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Integer getLecturerGid() {
        return lecturerGid;
    }

    public void setLecturerGid(Integer lecturerGid) {
        this.lecturerGid = lecturerGid;
    }

    public Integer getLecturerOid() {
        return lecturerOid;
    }

    public void setLecturerOid(Integer lecturerOid) {
        this.lecturerOid = lecturerOid;
    }

    public String getLecturerUID() {
        return lecturerUID;
    }

    public void setLecturerUID(String lecturerUID) {
        this.lecturerUID = lecturerUID;
    }

    public Long getPerson() {
        return person;
    }

    public void setPerson(Long person) {
        this.person = person;
    }

    public String getShortFIO() {
        return shortFIO;
    }

    public void setShortFIO(String shortFIO) {
        this.shortFIO = shortFIO;
    }
}
