package com.example.paymentservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Setter
@Getter
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String email;
    private String phoneNumber;
    private String mobile;
    private String address;

    /*@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Card> cards;*/

    private String password;
    private Boolean status;
    private Boolean confirmEmail;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public void setConfirmEmail(boolean confirmEmail) {
        this.confirmEmail = confirmEmail;
    }

    /*@JsonProperty
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT+7")
    public Timestamp getCreatedAt() {
        return createdAt;
    }*/
}
