package com.project.Models.Design;

import com.project.Models.User.User;
import jakarta.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "designs")
public class Design {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer design_id;

    @Column(name = "design", columnDefinition="text", length=10485760)
    private String design;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    public Design(){}

    public Design(String design, User user_id) {
        this.design = design;
        this.user_id = user_id;
    }

    public Design(Integer design_id, String design, User user_id) {
        this.design_id = design_id;
        this.design = design;
        this.user_id = user_id;
    }

    public Integer getDesign_Id() {
        return design_id;
    }

    public void setDesign_id(Integer design_id) {
        this.design_id = design_id;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Design design1 = (Design) o;
        return Objects.equals(design_id, design1.design_id) && Objects.equals(design, design1.design) && Objects.equals(user_id, design1.user_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(design_id, design, user_id);
    }
}
