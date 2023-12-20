package jpabook.jpashop.domain;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Member extends BaseEntity{


    @Id @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;
    private String name;
//Period 임베디드
    @Embedded
    private Period workPeriod;
    //Address 임베디드
    @Embedded
    private Address homeAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
