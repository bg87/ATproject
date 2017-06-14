package api.domain;


import com.fasterxml.jackson.annotation.JsonSubTypes;

import javax.persistence.*;

@Entity
public class Contribution {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @Version
    private Integer version;

    private int orderNumber;

    @Column(length = 5000)
    private String content;

    public Contribution() {}

    public Contribution(int orderNumber, String content) {
        this.orderNumber = orderNumber;
        this.content = content;
    }

    //region GETTERS SETTERS

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    //endregion

}
