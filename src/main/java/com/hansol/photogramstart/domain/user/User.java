package com.hansol.photogramstart.domain.user;

//JPA(Java Persistance API)를 이용해 데이터를 영구히 저장할 것

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data //Getter, Setter 생성
@Entity //DB에 TABLE을 생성
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY) //번호 증가 전략
    @Id
    private Long id;

    @Column(length = 20, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    private String website;

    private String bio;

    private String phone;

    private String gender;

    private String profileImgUrl;

    private String role;

    private LocalDateTime createDate;

    @PrePersist //DB에 INSERT되기 직전에 실행
    public void createDate(){
        this.createDate = LocalDateTime.now();
    }




}
