package com.project.Models.Design;

import com.project.Models.User.User;
import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "designs")
public class Design {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer designId;

    @Column(name = "design", columnDefinition="text", length=10485760)
    private String design;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User userId;

    public Design(){}

    public Design(String design, User userId) {
        this.design = design;
        this.userId = userId;
    }

    public Design(Integer design_id, String design, User userId) {
        this.designId = design_id;
        this.design = design;
        this.userId = userId;
    }

    public Integer getDesignId() {
        return designId;
    }

    public void setDesign_id(Integer design_id) {
        this.designId = designId;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Design design1 = (Design) o;
        return Objects.equals(designId, design1.designId) && Objects.equals(design, design1.design) && Objects.equals(userId, design1.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(designId, design, userId);
    }
}
