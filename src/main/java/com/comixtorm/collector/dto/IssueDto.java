package com.comixtorm.collector.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class IssueDto implements Comparator<IssueDto> {
    private Long id;
    private String name;
    private String vanity;
    private Integer number;
    private Float printPrice;
    private Float digitalPrice;
    private String currency;
    private Date publishedDate;
    private String shortReview;
    private String event;
    private String storyArch;
    private String isbn;
    private boolean collected;
    private TitleDto title;
    private List<CoverDto> covers;
    private List<AuthorDto> authors;

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

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getStoryArch() {
        return storyArch;
    }

    public void setStoryArch(String storyArch) {
        this.storyArch = storyArch;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isCollected() {
        return collected;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }

    public TitleDto getTitle() {
        return title;
    }

    public void setTitle(TitleDto title) {
        this.title = title;
    }

    public List<CoverDto> getCovers() {
        return covers;
    }

    public void setCovers(List<CoverDto> covers) {
        this.covers = covers;
    }

    public List<AuthorDto> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorDto> authors) {
        this.authors = authors;
    }

    @Override
    public int compare(IssueDto o1, IssueDto o2) {
        return  o1.getId() < o2.getId() ? -1 : o1.getId() == o2.getId() ? 0 : 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IssueDto)) return false;
        IssueDto issueDto = (IssueDto) o;
        return Objects.equals(id, issueDto.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
