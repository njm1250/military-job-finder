package com.military.jobfinder.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Api {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String welfare;                // 복리후생
    String firstOccurDate;         // 최초발생일
    String lastModDate;            // 최종변동일
    String finalEdu;               // 최종학력
    String recruitNum;             // 채용번호
    String recruitTitle;           // 채용제목
    String respPerson;             // 담당자
    String task;                   // 담당업무
    String contactNum;             // 담당자연락처
    String repContact;             // 대표연락처
    String companyName;            // 업체명
    String jobTypeCode;            // 업종구분코드
    String jobTypeName;            // 업종구분명
    String workLocCity;            // 근무지시도
    String workLocAddr;            // 근무지주소
    String workLocCode;            // 근무지법정동코드
    String careerYears;            // 경력년수
    String careerDiv;              // 경력구분
    String salaryCondCode;         // 급여조건코드
    String salaryCondName;         // 급여조건명
    String hpAddr;                 // 홈페이지주소
    String appMethod;              // 접수방법
    String majorCode;              // 전공계열코드
    String majorName;              // 전공계열명
    String deadline;               // 마감일자
    String foreignLangCode;        // 외국어코드
    String foreignLangName;        // 외국어명
    String foreignLangSkills;      // 외국어구사능력
    String isAlwaysRecruit;        // 상시채용여부
    String armyTypeCode;           // 역종분류코드
    String armyTypeName;           // 역종분류명
    String persDivCode;            // 요원구분코드
    String persDivName;            // 요원구분명     pers = personnel
    String isValid;                // 유효여부
    String businessNum;            // 사업자번호
    String recruitPersNum;         // 모집인원명
    String workCondition;          // 근무형태명
    String addrCode;               // 주소코드

/*
     bokrihs;                  // 복리후생
     ccdatabalsaengDtm;        // 최초발생일
     cjdatabyeongyeongDtm;     // 최종변동일
     Cjhakryeok;               // 최종학력
     cygonggoNo;               // 채용번호
     cyjemokNm;                // 채용제목
     damdangjaFnm;             // 담당자
     ddeopmuNm;                // 담당업무
     ddjyeonrakcheoNo;         // 담당자연락처
     dpyeonrakcheoNo;          // 대표연락처
     eopcheNm;                 // 업체명
     eopjongGbcd;              // 업종구분코드
     eopjongGbcdNm;            // 업종구분명
     Geunmujysido;             // 근무지시도
     Geunmujy;                 // 근무지주소
     gmjybjusoCd;              // 근무지법정동코드
     grNs;                     // 경력년수
     gyeongryeokGbcdNm;        // 경력구분
     gyjogeonCd;               // 급여조건코드
     gyjogeonCdNm;             // 급여조건명
     hmpgAddr;                 // 홈페이지주소
     Jeopsubb;                 // 접수방법
     jggyeyeolCd;              // 전공계열코드
     jggyeyeolCdNm;            // 전공계열명
     magamDt;                  // 마감일자
     oegukeoCd;                // 외국어코드
     Oegukeo;                  // 외국어명
     ogegsneungryeokCdNm;      // 외국어구사능력
     sschaeyongYn;             // 상시채용여부
     yeokjongBrcd;             // 역종분류코드
     yeokjongBrcdNm;           // 역종분류명
     yowonGbcd	               // 요원구분코드
	 yowonGbcdNm	           // 요원구분명
	 yuhyoYn	               // 유효여부
	 SAEOPJA_DRNO	           // 사업자번호
	 MJINWON_NM	               // 모집인원명
	 GMHYEONGTAE_NM	           // 근무형태명
	 JUSO_CD	               // 주소코드
 */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWelfare() {
        return welfare;
    }

    public void setWelfare(String welfare) {
        this.welfare = welfare;
    }

    public String getFirstOccurDate() {
        return firstOccurDate;
    }

    public void setFirstOccurDate(String firstOccurDate) {
        this.firstOccurDate = firstOccurDate;
    }

    public String getLastModDate() {
        return lastModDate;
    }

    public void setLastModDate(String lastModDate) {
        this.lastModDate = lastModDate;
    }

    public String getFinalEdu() {
        return finalEdu;
    }

    public void setFinalEdu(String finalEdu) {
        this.finalEdu = finalEdu;
    }

    public String getRecruitNum() {
        return recruitNum;
    }

    public void setRecruitNum(String recruitNum) {
        this.recruitNum = recruitNum;
    }

    public String getRecruitTitle() {
        return recruitTitle;
    }

    public void setRecruitTitle(String recruitTitle) {
        this.recruitTitle = recruitTitle;
    }

    public String getRespPerson() {
        return respPerson;
    }

    public void setRespPerson(String respPerson) {
        this.respPerson = respPerson;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public String getRepContact() {
        return repContact;
    }

    public void setRepContact(String repContact) {
        this.repContact = repContact;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobTypeCode() {
        return jobTypeCode;
    }

    public void setJobTypeCode(String jobTypeCode) {
        this.jobTypeCode = jobTypeCode;
    }

    public String getJobTypeName() {
        return jobTypeName;
    }

    public void setJobTypeName(String jobTypeName) {
        this.jobTypeName = jobTypeName;
    }

    public String getWorkLocCity() {
        return workLocCity;
    }

    public void setWorkLocCity(String workLocCity) {
        this.workLocCity = workLocCity;
    }

    public String getWorkLocAddr() {
        return workLocAddr;
    }

    public void setWorkLocAddr(String workLocAddr) {
        this.workLocAddr = workLocAddr;
    }

    public String getWorkLocCode() {
        return workLocCode;
    }

    public void setWorkLocCode(String workLocCode) {
        this.workLocCode = workLocCode;
    }

    public String getCareerYears() {
        return careerYears;
    }

    public void setCareerYears(String careerYears) {
        this.careerYears = careerYears;
    }

    public String getCareerDiv() {
        return careerDiv;
    }

    public void setCareerDiv(String careerDiv) {
        this.careerDiv = careerDiv;
    }

    public String getSalaryCondCode() {
        return salaryCondCode;
    }

    public void setSalaryCondCode(String salaryCondCode) {
        this.salaryCondCode = salaryCondCode;
    }

    public String getSalaryCondName() {
        return salaryCondName;
    }

    public void setSalaryCondName(String salaryCondName) {
        this.salaryCondName = salaryCondName;
    }

    public String getHpAddr() {
        return hpAddr;
    }

    public void setHpAddr(String hpAddr) {
        this.hpAddr = hpAddr;
    }

    public String getAppMethod() {
        return appMethod;
    }

    public void setAppMethod(String appMethod) {
        this.appMethod = appMethod;
    }

    public String getMajorCode() {
        return majorCode;
    }

    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getForeignLangCode() {
        return foreignLangCode;
    }

    public void setForeignLangCode(String foreignLangCode) {
        this.foreignLangCode = foreignLangCode;
    }

    public String getForeignLangName() {
        return foreignLangName;
    }

    public void setForeignLangName(String foreignLangName) {
        this.foreignLangName = foreignLangName;
    }

    public String getForeignLangSkills() {
        return foreignLangSkills;
    }

    public void setForeignLangSkills(String foreignLangSkills) {
        this.foreignLangSkills = foreignLangSkills;
    }

    public String getIsAlwaysRecruit() {
        return isAlwaysRecruit;
    }

    public void setIsAlwaysRecruit(String isAlwaysRecruit) {
        this.isAlwaysRecruit = isAlwaysRecruit;
    }

    public String getArmyTypeCode() {
        return armyTypeCode;
    }

    public void setArmyTypeCode(String armyTypeCode) {
        this.armyTypeCode = armyTypeCode;
    }

    public String getArmyTypeName() {
        return armyTypeName;
    }

    public void setArmyTypeName(String armyTypeName) {
        this.armyTypeName = armyTypeName;
    }

    public String getPersDivCode() {
        return persDivCode;
    }

    public void setPersDivCode(String persDivCode) {
        this.persDivCode = persDivCode;
    }

    public String getPersDivName() {
        return persDivName;
    }

    public void setPersDivName(String persDivName) {
        this.persDivName = persDivName;
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    public String getBusinessNum() {
        return businessNum;
    }

    public void setBusinessNum(String businessNum) {
        this.businessNum = businessNum;
    }

    public String getRecruitPersNum() {
        return recruitPersNum;
    }

    public void setRecruitPersNum(String recruitPersNum) {
        this.recruitPersNum = recruitPersNum;
    }

    public String getWorkCondition() {
        return workCondition;
    }

    public void setWorkCondition(String workCondition) {
        this.workCondition = workCondition;
    }

    public String getAddrCode() {
        return addrCode;
    }

    public void setAddrCode(String addrCode) {
        this.addrCode = addrCode;
    }

}
