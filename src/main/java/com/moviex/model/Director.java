package com.moviex.model;

import javax.persistence.*;

@Entity
@Table(name = "DIRECTOR", schema = "dbo")
public class Director extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "DIRECTOR_ID")
    private Long directorId;

    @Column(name = "DIRECTOR_NAME")
    private String directorName;

    @Column(name = "DIRECTOR_DESCRIPTION")
    private String directorDescription;

    @Column(name = "DIRECTOR_CONTENT")
    private String directorContent;

    @Column(name = "DIRECTOR_IMAGE")
    private String directorImage;

    @Column(name = "DIRECTOR_VIEW")
    private Long directorView;

    @Column(name = "DIRECTOR_SOURCE")
    private String directorSource;

    public Long getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Long directorId) {
        this.directorId = directorId;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getDirectorDescription() {
        return directorDescription;
    }

    public void setDirectorDescription(String directorDescription) {
        this.directorDescription = directorDescription;
    }

    public String getDirectorContent() {
        return directorContent;
    }

    public void setDirectorContent(String directorContent) {
        this.directorContent = directorContent;
    }

    public String getDirectorImage() {
        return directorImage;
    }

    public void setDirectorImage(String directorImage) {
        this.directorImage = directorImage;
    }

    public Long getDirectorView() {
        return directorView;
    }

    public void setDirectorView(Long directorView) {
        this.directorView = directorView;
    }

    public String getDirectorSource() {
        return directorSource;
    }

    public void setDirectorSource(String directorSource) {
        this.directorSource = directorSource;
    }
}
