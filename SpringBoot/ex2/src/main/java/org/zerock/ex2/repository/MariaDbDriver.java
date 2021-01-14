package org.zerock.ex2.repository;
import org.springframework.stereotype.Service;

// @Service 어노테이션은 구현체에다 쓸 것.
@Service
public class MariaDbDriver implements DbDriver {

  public MariaDbDriver() {
    System.out.println("==== MariaDbDriver ====");
  }

  @Override
  public String create() {
    return "MariaDbDriver Create";
  }

  @Override
  public String read() {
    return "MariaDbDriver Read";
  }

  @Override
  public String update() {
    return "MariaDbDriver Update";
  }

  @Override
  public String delete() {
    return "MariaDbDriver Delete";
  }
}