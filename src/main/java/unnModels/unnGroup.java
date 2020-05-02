package unnModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class unnGroup {
    public Integer getFormOfEducationGid() {
        return formOfEducationGid;
    }

    public Integer getFormOfEducationOid() {
        return formOfEducationOid;
    }

    public Integer getSpecialityGid() {
        return specialityGid;
    }

    public Integer getSpecialityOid() {
        return specialityOid;
    }

    public Integer getChairGid() {
        return chairGid;
    }

    public Integer getChairOid() {
        return chairOid;
    }

    public Integer getCourse() {
        return course;
    }

    public String getFaculty() {
        return faculty;
    }

    public Integer getFacultyGid() {
        return facultyGid;
    }

    public Integer getFacultyOid() {
        return facultyOid;
    }

    public String getFormOfEducation() {
        return formOfEducation;
    }

    public Integer getGroupGid() {
        return groupGid;
    }

    public Integer getGroupOid() {
        return groupOid;
    }

    public Integer getKindEducation() {
        return kindEducation;
    }

    public String getNumber() {
        return number;
    }

    public String getSpeciality() {
        return speciality;
    }

    @SerializedName("FormOfEducationGid")
    @Expose
    private Integer formOfEducationGid;
    @SerializedName("FormOfEducationOid")
    @Expose
    private Integer formOfEducationOid;
    @SerializedName("SpecialityGid")
    @Expose
    private Integer specialityGid;
    @SerializedName("SpecialityOid")
    @Expose
    private Integer specialityOid;
    @SerializedName("chairGid")
    @Expose
    private Integer chairGid;
    @SerializedName("chairOid")
    @Expose
    private Integer chairOid;
    @SerializedName("course")
    @Expose
    private Integer course;
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
    @SerializedName("groupGid")
    @Expose
    private Integer groupGid;
    @SerializedName("groupOid")
    @Expose
    private Integer groupOid;
    @SerializedName("kindEducation")
    @Expose
    private Integer kindEducation;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("speciality")
    @Expose
    private String speciality;
}