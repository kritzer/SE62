package com.example.demo.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;


@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Librarian")
public class Librarian {

    @Id
    @SequenceGenerator(name="librarian_seq",sequenceName="librarian_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="librarian_seq")  
    @Column(name = "LIBRARIAN_ID", unique = true, nullable = true)
    @NonNull
    private Long librarianid;

    @NotNull(message = "LibrarianName Must Not Be Null")
    private String librarianName;

}