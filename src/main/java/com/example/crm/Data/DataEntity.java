package com.example.crm.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "crm_data")

public class DataEntity {
    @Id
    @NotNull
    @SequenceGenerator(name = "data_sequence", sequenceName = "data_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "data_sequence")
    private Long id;
    private String rmName;
    private String typeOfCustomer;
    private String pan;
    private String name;
    private String phoneNumber;
    private String boardcast;
    private String reference;
    private String address;
    private String reviewDate;
    private String folioCheck;
    private String folioComment;
    private String nomineeCheck;
    private String cgBooked;
    private String cgRemarks;
    private String remarks;
    private String rmName2;
    private String familyHeadPan;

    public DataEntity(String rmName, String typeOfCustomer, String pan, String name, String phoneNumber,
            String boardcast, String reference, String address, String reviewDate, String folioCheck,
            String folioComment, String nomineeCheck, String cgBooked, String cgRemarks, String remarks, String rmName2,
            String familyHeadPan) {
        this.rmName = rmName;
        this.typeOfCustomer = typeOfCustomer;
        this.pan = pan;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.boardcast = boardcast;
        this.reference = reference;
        this.address = address;
        this.reviewDate = reviewDate;
        this.folioCheck = folioCheck;
        this.folioComment = folioComment;
        this.nomineeCheck = nomineeCheck;
        this.cgBooked = cgBooked;
        this.cgRemarks = cgRemarks;
        this.remarks = remarks;
        this.rmName2 = rmName2;
        this.familyHeadPan = familyHeadPan;
    }

    public DataEntity(String rmName, String pan, String name, String phoneNumber) {
        this.rmName = rmName;
        this.pan = pan;
        this.name = name;
        this.phoneNumber = phoneNumber;

    }

}
