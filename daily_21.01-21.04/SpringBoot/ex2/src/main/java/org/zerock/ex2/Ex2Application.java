package org.zerock.ex2;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.zerock.ex2.repository.DbDriver;
import org.zerock.ex2.repository.MariaDbDriver;

@SpringBootApplication
public class Ex2Application {

  public static void main(String[] args) {

    DbDriver dbDriver = new MariaDbDriver();


    // ================================================
    System.out.println(dbDriver.create());
    System.out.println(dbDriver.read());
    System.out.println(dbDriver.update());
    System.out.println(dbDriver.delete());
    // ================================================


//    SpringApplication.run(Ex2Application.class, args);
  }
}