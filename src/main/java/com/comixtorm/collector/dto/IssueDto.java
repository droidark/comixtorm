package com.comixtorm.collector.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.Map;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class IssueDto implements Comparable<IssueDto> {
    private Long id;
    private String name;
    private String vanity;
    private Integer number;
    private Float printPrice;
    private Float digitalPrice;
    private String currency;
    private Date publishedDate;
    private String shortReview;
    private TitleDto title;
    private Set<CoverDto> covers;
    private Map<String, String> staff;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVanity() {
        return vanity;
    }

    public void setVanity(String vanity) {
        this.vanity = vanity;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Float getPrintPrice() {
        return printPrice;
    }

    public void setPrintPrice(Float printPrice) {
        this.printPrice = printPrice;
    }

    public Float getDigitalPrice() {
        return digitalPrice;
    }

    public void setDigitalPrice(Float digitalPrice) {
        this.digitalPrice = digitalPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getShortReview() {
        return shortReview;
    }

    public void setShortReview(String shortReview) {
        this.shortReview = shortReview;
    }

    public TitleDto getTitle() {
        return title;
    }

    public void setTitle(TitleDto title) {
        this.title = title;
    }

    public Set<CoverDto> getCovers() {
        return covers;
    }

    public void setCovers(Set<CoverDto> covers) {
        this.covers = covers;
    }

    public Map<String, String> getStaff() {
        return staff;
    }

    public void setStaff(Map<String, String> staff) {
        this.staff = staff;
    }

    @Override
    public int compareTo(IssueDto o) {
        return (int) (id - o.getId());
    }
}
