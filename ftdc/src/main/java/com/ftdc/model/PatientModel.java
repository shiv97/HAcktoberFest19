package com.ftdc.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "patient_details")
public class PatientModel {
    private Long patientId;
    private String firstName;
    private String lastName;
    private String familyDoctor;
    private Long phoneNo;
    private int regionId;
    private int numPregnancies;
    private int firstPregnancyAge;
    private Boolean pregnancyStatusNow;
    private int numChildren;
    private Date lastMenstrualPeriod;
    private Boolean birthControlStatus;
    private Date birthControlTime;
    private String hormonesAndReplacement;
    private Boolean previousBreastSurgeryStatus;
    private Date previousBreastSurgeryDate;
    private String previousBreastSurgery;
    private Boolean previousBreastRadiationStatus;
    private Date previousBreastRadiationDate;
    private String previousBreastRadiation;
    private Boolean previousChemotherapyStatus;
    private String previousChemotherapyCondition;
    private Boolean routineCheckupStatus;
    private String presentBreastComplaint;
    private Boolean skinDimplingStatus;
    private Boolean nippleRetractionStatus;
    private Boolean dischargeStatus;
    private String dischargeColor;
    private Boolean familyBreastCancerHistoryStatus;
    private Boolean bcMotherStatus;
    private Boolean bcDaughterStatus;
    private Boolean bcSisterStatus;
    private Boolean bcMotherSideGrandMotherStatus;
    private Boolean bcMotherSideAuntStatus;
    private Boolean bcFatherSideAuntStatus;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_details_patient_id_seq")
    @SequenceGenerator(name = "patient_details_patient_id_seq",sequenceName = "patient_details_patient_id_seq", allocationSize = 1)
    @Column(name="patient_id")
    public Long getPatientId(){ return patientId;}
    public void setPatientId(Long patientId){this.patientId = patientId;}

    @Basic
    @Column(name="first_name")
    public String getFirstName(){ return firstName; }
    public void setFirstName(String firstName){ this.firstName = firstName;}

    @Basic
    @Column(name="last_name")
    public String getLastName(){ return lastName; }
    public void setLastName(String lastName){ this.lastName = lastName;}

    @Basic
    @Column(name = "family_doctor")
    public String getFamilyDoctor(){return familyDoctor;}
    public void setFamilyDoctor(String familyDoctor){this.familyDoctor=familyDoctor;}

    @Basic
    @Column(name="phone_number")
    public Long getPhoneNo(){return phoneNo;}
    public void setPhoneNo(Long phoneNo){this.phoneNo=phoneNo;}

    @Basic
    @Column(name = "region_id")
    public int getRegionId(){ return regionId; }
    public void setRegionId(int regionId){this.regionId=regionId;}

    @Basic
    @Column(name="num_of_pregnancies")
    public int getNumPregnancies(){return numPregnancies;}
    public void setNumPregnancies(int numPregnancies){this.numPregnancies=numPregnancies;}

    @Basic
    @Column(name = "first_pregnancy_age")
    public int getFirstPregnancyAge(){return firstPregnancyAge;}
    public void setFirstPregnancyAge(int firstPregnancyAge){this.firstPregnancyAge=firstPregnancyAge;}

    @Basic
    @Column(name="pregnancy_status_now")
    public Boolean getPregnancyStatusNow(){return pregnancyStatusNow;}
    public void setPregnancyStatusNow(Boolean pregnancyStatusNow){this.pregnancyStatusNow=pregnancyStatusNow;}

    @Basic
    @Column(name="num_of_children")
    public int getNumChildren(){return numChildren;}
    public void setNumChildren(int numChildren){this.numChildren=numChildren;}

    @Basic
    @Column(name="last_menstrual_period")
    public Date getLastMenstrualPeriod(){return lastMenstrualPeriod;}
    public void setLastMenstrualPeriod(Date lastMenstrualPeriod){this.lastMenstrualPeriod=lastMenstrualPeriod;}

    @Basic
    @Column(name="birth_control_status")
    public Boolean getBirthControlStatus(){return birthControlStatus;}
    public void setBirthControlStatus(Boolean birthControlStatus){this.birthControlStatus=birthControlStatus;}

    @Basic
    @Column(name="birth_control_time")
    public Date getBirthControlTime(){return birthControlTime;}
    public void setBirthControlTime(Date birthControlTime){this.birthControlTime = birthControlTime;}

    @Basic
    @Column(name="hormones_and_replacement")
    public String getHormonesAndReplacement(){return hormonesAndReplacement;}
    public void setHormonesAndReplacement(String hormonesAndReplacement){this.hormonesAndReplacement = hormonesAndReplacement;}

    @Basic
    @Column(name="previous_breast_surgery_status")
    public Boolean getPreviousBreastSurgeryStatus(){return previousBreastSurgeryStatus;}
    public void setPreviousBreastSurgeryStatus(Boolean previousBreastSurgeryStatus){this.previousBreastSurgeryStatus=previousBreastSurgeryStatus;}

    @Basic
    @Column(name="previous_breast_surgery_date")
    public Date getPreviousBreastSurgeryDate(){return previousBreastSurgeryDate;}
    public void setPreviousBreastSurgeryDate(Date previousBreastSurgeryDate){this.previousBreastSurgeryDate=previousBreastSurgeryDate;}

    @Basic
    @Column(name="previous_breast_surgery")
    public String getPreviousBreastSurgery(){return previousBreastSurgery;}
    public void setPreviousBreastSurgery(String previousBreastSurgery){this.previousBreastSurgery=previousBreastSurgery;}

    @Basic
    @Column(name="previous_breast_radiation_status")
    public Boolean getPreviousBreastRadiationStatus(){return previousBreastRadiationStatus;}
    public void setPreviousBreastRadiationStatus(Boolean previousBreastRadiationStatus){this.previousBreastRadiationStatus=previousBreastRadiationStatus;}

    @Basic
    @Column(name="previous_breast_radiation_date")
    public Date getPreviousBreastRadiationDate(){return previousBreastRadiationDate;}
    public void setPreviousBreastRadiationDate(Date previousBreastRadiationDate){this.previousBreastRadiationDate=previousBreastRadiationDate;}

    @Basic
    @Column(name="previous_breast_radiation")
    public String getPreviousBreastRadiation(){return previousBreastRadiation;}
    public void setPreviousBreastRadiation(String previousBreastRadiation){this.previousBreastRadiation=previousBreastRadiation;}

    @Basic
    @Column(name="previous_chemotherapy_status")
    public Boolean getPreviousChemotherapyStatus(){return previousChemotherapyStatus;}
    public void setPreviousChemotherapyStatus(Boolean previousChemotherapyStatus){this.previousChemotherapyStatus=previousChemotherapyStatus;}

    @Basic
    @Column(name="previous_chemotherapy_condition")
    public String getPreviousChemotherapyCondition(){return previousChemotherapyCondition;}
    public void setPreviousChemotherapyCondition(String previousChemotherapyCondition){this.previousChemotherapyCondition=previousChemotherapyCondition;}

    @Basic
    @Column(name="routine_check_up_status")
    public Boolean getRoutineCheckupStatus(){return routineCheckupStatus;}
    public void setRoutineCheckupStatus(Boolean routineCheckupStatus){this.routineCheckupStatus=routineCheckupStatus;}

    @Basic
    @Column(name="present_breast_complaint")
    public String getPresentBreastComplaint(){return presentBreastComplaint;}
    public void setPresentBreastComplaint(String presentBreastComplaint){this.presentBreastComplaint=presentBreastComplaint;}

    @Basic
    @Column(name="skin_dimpling_status")
    public Boolean getSkinDimplingStatus(){return skinDimplingStatus;}
    public void setSkinDimplingStatus(Boolean skinDimplingStatus){this.skinDimplingStatus=skinDimplingStatus;}

    @Basic
    @Column(name="nipple_retraction_status")
    public Boolean getNippleRetractionStatus(){return nippleRetractionStatus;}
    public void setNippleRetractionStatus(Boolean nippleRetractionStatus){this.nippleRetractionStatus=nippleRetractionStatus;}

    @Basic
    @Column(name="discharge_status")
    public Boolean getDischargeStatus(){return dischargeStatus;}
    public void setDischargeStatus(Boolean dischargeStatus){this.dischargeStatus=dischargeStatus;}

    @Basic
    @Column(name="discharge_color")
    public String getDischargeColor(){return dischargeColor;}
    public void setDischargeColor(String dischargeColor){this.dischargeColor=dischargeColor;}

    @Basic
    @Column(name="family_breast_cancer_history_status")
    public Boolean getFamilyBreastCancerHistoryStatus(){return familyBreastCancerHistoryStatus;}
    public void setFamilyBreastCancerHistoryStatus(Boolean familyBreastCancerHistoryStatus){this.familyBreastCancerHistoryStatus=familyBreastCancerHistoryStatus;}

    @Basic
    @Column(name="bc_mother_status")
    public Boolean getBcMotherStatus(){return bcMotherStatus;}
    public void setBcMotherStatus(Boolean bcMotherStatus){this.bcMotherStatus=bcMotherStatus;}

    @Basic
    @Column(name="bc_daughter_status")
    public Boolean getBcDaughterStatus(){return bcDaughterStatus;}
    public void setBcDaughterStatus(Boolean bcDaughterStatus){this.bcDaughterStatus=bcDaughterStatus;}

    @Basic
    @Column(name="bc_sister_status")
    public Boolean getBcSisterStatus(){return bcSisterStatus;}
    public void setBcSisterStatus(Boolean bcSisterStatus){this.bcSisterStatus=bcSisterStatus;}

    @Basic
    @Column(name="bc_mother_side_grand_mother_status")
    public Boolean getBcMotherSideGrandMotherStatus(){return bcMotherSideGrandMotherStatus;}
    public void setBcMotherSideGrandMotherStatus(Boolean bcMotherSideGrandMotherStatus){this.bcMotherSideGrandMotherStatus=bcMotherSideGrandMotherStatus;}

    @Basic
    @Column(name="bc_mother_side_aunt_status")
    public Boolean getBcMotherSideAuntStatus(){return bcMotherSideAuntStatus;}
    public void setBcMotherSideAuntStatus(Boolean bcMotherSideAuntStatus){this.bcMotherSideAuntStatus=bcMotherSideAuntStatus;}

    @Basic
    @Column(name="bc_father_side_aunt_status")
    public Boolean getBcFatherSideAuntStatus(){return bcFatherSideAuntStatus;}
    public void setBcFatherSideAuntStatus(Boolean bcFatherSideAuntStatus){this.bcFatherSideAuntStatus=bcFatherSideAuntStatus;}

}
