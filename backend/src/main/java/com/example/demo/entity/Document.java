package com.example.demo.entity; //กำลังบอกว่า package นี้ เป็นของ Entity

import lombok.*;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Entity // ทำให้ class Document เป็น Entity
@Data // กำหนดให้เก็บข้อมูล และช่วยในการสร้าง get , set
@Table // บอกว่า Entity นี้ ทำหน้าที่ เก็บข้อมูล
@Getter // เรียกใช้ Getter เอาไว้จำกัดการเข้าถึง เพื่อ get ค่าให้กับแต่ละ attribute
@Setter // เรียกใช้ Setter เอาไว้จำกัดการเข้าถึง เพื่อ set ค่าให้กับแต่ละ attribute
@NoArgsConstructor
@Builder
@AllArgsConstructor //
public class Document { // บอกตำแหน่งปัจจุบัน

    @Id // คือ annotation ที่ไว้สร้าง Primary Key
    @SequenceGenerator(name = "document_seq", sequenceName = "document_seq") //
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_seq") //
    @Column(name = "documentId", unique = true, nullable = false) // ชื่อคอลัม documentId , ไม่ซ้ำ , ไม่ว่าง
    private Long id;
    // จำกัดการเข้าถึง documentId
    @Column(name = "bookName")
    @NotNull
    private String bookName;
    @Column(name = "writterName")
    @NotNull
    private String writterName;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = BookType.class)
    @JoinColumn(name = "booktypeID", insertable = true)
    @NotNull
    private BookType bookType;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Language.class)
    @JoinColumn(name = "languageID", insertable = true)
    @NotNull
    private Language language;  
   
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = BookCategory.class)   
    @JoinColumn(name = "bookcategoryID", insertable = true)
    @NotNull
    private BookCategory bookCategory;

}