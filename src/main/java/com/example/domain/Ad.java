package com.example.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.Identifiable;
import org.springframework.hateoas.alps.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

/**
 * Created by yalex on 11.11.16.
 */
@Entity
public class Ad implements Identifiable<Long> {

    @Id
    @GeneratedValue
    @Getter @Setter private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @Getter @Setter private Type type;

    public enum Type {BUY, SELL}

    @Column(nullable = false)
    private BigInteger amount;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @Getter @Setter private Currency currency;

    public enum Currency {USD, EUR}

    @Column(nullable = false)
    private BigDecimal rate;

    @ManyToOne
    @JoinColumn(nullable = false)
    @Getter @Setter User user;


    @Getter @Setter private Location location;

    @Embeddable
    public static class Location {
        @Column(nullable = false)
        @Getter @Setter private String city;

        @Getter @Setter private String area;

        public Location(){}

        public Location(String city, String area){}
    }

    @Getter @Setter private String comment;
    @Lob
    @Getter @Setter private LocalDateTime publishedAt;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.NEW;

    public enum Status{NEW, PUBLISHED, EXPIRED}

    public void publish() {
        if (status == Status.NEW) {
            publishedAt = LocalDateTime.now();
            status = Status.PUBLISHED;
        } else {
            throw new RuntimeException("ololo");
        }
    }

    public void expire() {
        if (status == Status.PUBLISHED) {
//            publishedAt = LocalDateTime.now();
            status = Status.EXPIRED;
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
