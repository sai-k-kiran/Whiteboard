package com.project.Models.Images;

import com.project.Models.User.User;
import jakarta.persistence.*;

@Entity
@Table(name = "images")
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer image_id;

    @Column(name = "image_url", columnDefinition="text", length=100)
    private String image_url;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    public Images() {
    }
    public Images(String imageUrl, User user_id) {
        this.image_url = imageUrl;
        this.user_id = user_id;
    }

    public Images(Integer image_id, String imageUrl, User user_id) {
        this.image_id = image_id;
        this.image_url = imageUrl;
        this.user_id = user_id;
    }

    public Integer getId() {
        return image_id;
    }

    public void setId(Integer id) {
        this.image_id = id;
    }

    public String getImageUrl() {
        return image_url;
    }

    public void setImageUrl(String imageUrl) {
        this.image_url = imageUrl;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }
}
