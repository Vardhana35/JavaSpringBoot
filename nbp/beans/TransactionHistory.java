package com.tcs.nbp.beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transaction_history")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "accNum")
public class TransactionHistory {

    @Id
    private String transactionId;

    @Positive(message = "amount must be positive")
    private Double amount;

    @NotNull
    private String date;

    @Column
    private Integer accNum;
    
    @ManyToOne
    @JoinColumn(name="accNum", insertable=false, updatable=false)
    private Account account;

}
