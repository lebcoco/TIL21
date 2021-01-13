package org.zerock.ex2.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

  @Entity
  @Table(name= "tbl_memo")
  @ToString
  @Getter
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
    public class Memo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;
  }