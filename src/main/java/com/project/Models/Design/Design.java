package com.project.Models.Design;

import com.project.Models.User.User;
import jakarta.persistence.*;


@Entity
@Table(name = "designs")
public class Design {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer design_id;

    @Column(name = "design")
    public String design;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    public Design(){}
}
