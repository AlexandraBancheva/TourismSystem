package com.tourismSystem.ts.entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "offers")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name", nullable = false)
    private String fullName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    @Column(name = "start_date", nullable = false)
    private Date startDate;
    @Column(name = "end_date", nullable = false)
    private Date endDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transport_id", nullable = false)
    private Transport transport;
    @Column(name = "price_person", nullable = false)
    private Double pricePerPerson;
    @Column(name = "price_includes", nullable = false)
    private String priceIncludes;
    @Column(name = "price_not_includes", nullable = false)
    private String priceDoesNotInclude;
    @Column(name = "created_by", nullable = false)
    private String createdApplicationUser;
    @OneToMany(mappedBy = "offer")
    private List<Image> images;

    public Offer(){
    }

    public Offer(String fullName,
                 Category category,
                 Date startDate,
                 Date endDate,
                 Transport transport,
                 Double pricePerPerson,
                 String priceIncludes,
                 String priceDoesNotInclude,
                 String createdApplicationUser) {
        this.fullName = fullName;
        this.category = category;
        this.startDate = startDate;
        this.endDate = endDate;
        this.transport = transport;
        this.pricePerPerson = pricePerPerson;
        this.priceIncludes = priceIncludes;
        this.priceDoesNotInclude = priceDoesNotInclude;
        this.createdApplicationUser = createdApplicationUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public Double getPricePerPerson() {
        return pricePerPerson;
    }

    public void setPricePerPerson(Double pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    public String getPriceIncludes() {
        return priceIncludes;
    }

    public void setPriceIncludes(String priceIncludes) {
        this.priceIncludes = priceIncludes;
    }

    public String getPriceDoesNotInclude() {
        return priceDoesNotInclude;
    }

    public void setPriceDoesNotInclude(String priceDoesNotInclude) {
        this.priceDoesNotInclude = priceDoesNotInclude;
    }

    public String getCreatedApplicationUser() {
        return createdApplicationUser;
    }

    public void setCreatedApplicationUser(String createdApplicationUser) {
        this.createdApplicationUser = createdApplicationUser;
    }
}
