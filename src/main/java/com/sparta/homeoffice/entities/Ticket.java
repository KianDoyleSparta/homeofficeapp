package com.sparta.homeoffice.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tickets", schema = "home_office_db")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "category", length = 50)
    private String category;

    @NotNull
    @Lob
    @Column(name = "priority", nullable = false)
    private String priority;

    @NotNull
    @Lob
    @Column(name = "state", nullable = false)
    private String state;

    @Size(max = 50)
    @Column(name = "assigned", length = 50)
    private String assigned;

    @Size(max = 100)
    @NotNull
    @Column(name = "short_desc", nullable = false, length = 100)
    private String shortDesc;

    @Lob
    @Column(name = "`desc`")
    private String desc;

    @NotNull
    @Lob
    @Column(name = "type", nullable = false)
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAssigned() {
        return assigned;
    }

    public void setAssigned(String assigned) {
        this.assigned = assigned;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}