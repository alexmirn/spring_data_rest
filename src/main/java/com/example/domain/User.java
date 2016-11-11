package com.example.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by yalex on 11.11.16.
 */
public class User {

    @Id
    @GeneratedValue
    @Getter @Setter private Long id;

    @Column(nullable = false)
    @Getter @Setter private String phoneNumber;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
