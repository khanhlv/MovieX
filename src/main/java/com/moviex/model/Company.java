package com.moviex.model;

import javax.persistence.*;

@Entity
@Table(name = "COMPANY")
public class Company extends BaseModel {
    @Id
    @GeneratedValue
    @Column(nullable = false, name = "COMPANY_ID")
    private Long companyId;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    @Column(name = "COMPANY_DESCRIPTION")
    private String companyDescription;

    @Column(name = "COMPANY_CONTENT")
    private String companyContent;

    @Column(name = "COMPANY_IMAGE")
    private String companyImage;

    @Column(name = "COMPANY_VIEW")
    private Long companyView;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public String getCompanyContent() {
        return companyContent;
    }

    public void setCompanyContent(String companyContent) {
        this.companyContent = companyContent;
    }

    public String getCompanyImage() {
        return companyImage;
    }

    public void setCompanyImage(String companyImage) {
        this.companyImage = companyImage;
    }

    public Long getCompanyView() {
        return companyView;
    }

    public void setCompanyView(Long companyView) {
        this.companyView = companyView;
    }
}
