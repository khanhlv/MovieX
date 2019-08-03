package com.moviex.model;

import javax.persistence.*;

@Entity
@Table(name = "ACTOR", schema = "dbo")
public class Actor extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "ACTOR_ID")
    private Long actorId;

    @Column(name = "ACTOR_NAME")
    private String actorName;

    @Column(name = "ACTOR_DESCRIPTION")
    private String actorDescription;

    @Column(name = "ACTOR_CONTENT")
    private String actorContent;

    @Column(name = "ACTOR_IMAGE_THUMB")
    private String actorImageThumb;

    @Column(name = "ACTOR_IMAGE_MEDIUM")
    private String actorImageMedium;

    @Column(name = "ACTOR_VIEW")
    private Long actorView;

    @Column(name = "ACTOR_SOURCE")
    private String actorSource;

    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getActorDescription() {
        return actorDescription;
    }

    public void setActorDescription(String actorDescription) {
        this.actorDescription = actorDescription;
    }

    public String getActorContent() {
        return actorContent;
    }

    public void setActorContent(String actorContent) {
        this.actorContent = actorContent;
    }

    public String getActorImageThumb() {
        return actorImageThumb;
    }

    public void setActorImageThumb(String actorImageThumb) {
        this.actorImageThumb = actorImageThumb;
    }

    public String getActorImageMedium() {
        return actorImageMedium;
    }

    public void setActorImageMedium(String actorImageMedium) {
        this.actorImageMedium = actorImageMedium;
    }

    public Long getActorView() {
        return actorView;
    }

    public void setActorView(Long actorView) {
        this.actorView = actorView;
    }

    public String getActorSource() {
        return actorSource;
    }

    public void setActorSource(String actorSource) {
        this.actorSource = actorSource;
    }
}
