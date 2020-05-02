package unnModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class unnChair {

    @SerializedName("abbr")
    @Expose
    private String abbr;
    @SerializedName("chairGid")
    @Expose
    private Integer chairGid;
    @SerializedName("chairOid")
    @Expose
    private Integer chairOid;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("faculty")
    @Expose
    private String faculty;
    @SerializedName("facultyGid")
    @Expose
    private Integer facultyGid;
    @SerializedName("facultyOid")
    @Expose
    private Integer facultyOid;
    @SerializedName("name")
    @Expose
    private String name;

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Integer getFacultyGid() {
        return facultyGid;
    }

    public void setFacultyGid(Integer facultyGid) {
        this.facultyGid = facultyGid;
    }

    public Integer getFacultyOid() {
        return facultyOid;
    }

    public void setFacultyOid(Integer facultyOid) {
        this.facultyOid = facultyOid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}