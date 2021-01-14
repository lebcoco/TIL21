package org.zerock.ex2.repository;
import org.springframework.stereotype.Service;

// @Service 어노테이션은 구현체에다 쓸 것.
@Service
public class OracleDbDriver implements DbDriver {

  public OracleDbDriver() {
    System.out.println("==== OracleDbDriver ====");
  }

  @Override
  public String create() {
    return "OracleDbDriver Create";
  }

  @Override
  public String read() {
    return "OracleDbDriver Read";
  }

  @Override
  public String update() {
    return "OracleDbDriver Update";
  }

  @Override
  public String delete() {
    return "OracleDbDriver Delete";
  }
}