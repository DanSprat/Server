package unnModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class unnStream {

    @SerializedName("FormOfEducationGid")
    @Expose
    private Integer formOfEducationGid;
    @SerializedName("FormOfEducationOid")
    @Expose
    private Integer formOfEducationOid;
    @SerializedName("abbr")
    @Expose
    private String abbr;
    @SerializedName("course")
    @Expose
    private String course;
    @SerializedName("faculty")
    @Expose
    private String faculty;
    @SerializedName("facultyGid")
    @Expose
    private Integer facultyGid;
    @SerializedName("facultyOid")
    @Expose
    private Integer facultyOid;
    @SerializedName("formOfEducation")
    @Expose
    private String formOfEducation;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("streamGid")
    @Expose
    private Integer streamGid;
    @SerializedName("streamOid")
    @Expose
    private Integer streamOid;
    @SerializedName("yearOfEducation")
    @Expose
    private Integer yearOfEducation;

    public Integer getFormOfEducationGid() {
        return formOfEducationGid;
    }

    public void setFormOfEducationGid(Integer formOfEducationGid) {
        this.formOfEducationGid = formOfEducationGid;
    }

    public Integer getFormOfEducationOid() {
        return formOfEducationOid;
    }

    public void setFormOfEducationOid(Integer formOfEducationOid) {
        this.formOfEducationOid = formOfEducationOid;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
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

    public String getFormOfEducation() {
        return formOfEducation;
    }

    public void setFormOfEducation(String formOfEducation) {
        this.formOfEducation = formOfEducation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStreamGid() {
        return streamGid;
    }

    public void setStreamGid(Integer streamGid) {
        this.streamGid = streamGid;
    }

    public Integer getStreamOid() {
        return streamOid;
    }

    public void setStreamOid(Integer streamOid) {
        this.streamOid = streamOid;
    }

    public Integer getYearOfEducation() {
        return yearOfEducation;
    }

    public void setYearOfEducation(Integer yearOfEducation) {
        this.yearOfEducation = yearOfEducation;
    }
}
