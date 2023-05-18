package com.example.springbooty.link;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Link {

    @Id
    @SequenceGenerator(
            name = "link_sequence",
            sequenceName = "link_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "link_sequence"
    )
    @Column
    private long linkId;

    @Column
    private String linkGiven;

    @Column
    private int linkShort;

    public Link() {
    }

    public Link(long linkId, String linkGiven, int linkShort) {
        this.linkId = linkId;
        this.linkGiven = linkGiven;
        this.linkShort = linkShort;
    }

    public void setLinkShort(int linkShort) {
        this.linkShort = linkShort;
    }

    public long getLinkId() {
        return linkId;
    }

    public void setLinkId(long linkId) {
        this.linkId = linkId;
    }

    public String getLinkGiven() {
        return linkGiven;
    }

    public void setLinkGiven(String linkGiven) {
        this.linkGiven = linkGiven;
    }

    public int getLinkShort() {
        return linkShort;
    }
}
