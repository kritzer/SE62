package com.example.demo.entity;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.*;

@Entity
@Setter@Getter
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
@Table(name="Borrow")
public class Borrow {

    @Id
    @GeneratedValue
    @Column(unique = true)
    private @NonNull Long borrowId;
    private @NonNull Long number;
    

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member.class)
    @JoinColumn(name = "Member_ID", insertable = true,nullable = false)
    //@JoinColumn(name = "Member_ID")
    private Member member;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = BookType.class)
    @JoinColumn(name = "booktype", insertable = true)
    //@JoinColumn(name = "booktype")
    private BookType bookType;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Document.class)
    @JoinColumn(name = "documentId", insertable = true)
    //@JoinColumn(name = "booktype")
    private Document document;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Memtype.class)
    @JoinColumn(name = "Memtype", insertable = true)
    //@JoinColumn(name = "Memtype")
    private Memtype memtype;

   
}