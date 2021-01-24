package com.asr.restApi.Entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String emailId;

    @Column
    private String password;

    @OneToMany(mappedBy = "userId", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<PrivateMessage> privateMessages;

    public User(String emailId, String password){
        this.emailId = emailId;
        this.password = password;
    }
}
