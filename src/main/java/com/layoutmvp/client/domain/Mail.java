package com.layoutmvp.client.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Mail {
  private final int id;
  private final String sender;
  private final String subject;
  private final String body;

  public Mail(int id, String sender, String subject, String body) {
    this.id = id;
    this.sender = sender;
    this.subject = subject;
    this.body = body;
  }

  public int getId() {
    return id;
  }

  public String getSender() {
    return sender;
  }

  public String getSubject() {
    return subject;
  }

  public String getBody() {
    return body;
  }

  private static HashMap<Integer, Mail> bunchOfMail = new HashMap<Integer, Mail>();

  static {
    String messageBody = "Lorem ipsum dolor sit amet, consectetur adipisicing elit..";
    bunchOfMail.put(1, new Mail(1, "vivamus@seddiamlorem.ca", "Job opening", messageBody));
    bunchOfMail.put(2, new Mail(2, "faucibus@sit.com", "REST security", messageBody));
    bunchOfMail.put(3, new Mail(3, "tellus.lorem.eu@sagittisNullam.org", "switching to mac", messageBody));
    bunchOfMail.put(4, new Mail(4, "luctus@sem.org", "problem with javac", messageBody));
    bunchOfMail.put(5, new Mail(5, "magnis@elitafeugiat.edu", "subversion", messageBody));
  }

  public static class MAILLIST {
    private static List<Mail> list = new ArrayList<Mail>(bunchOfMail.values());

    public static List<Mail> getMailList() {
      return list;
    }

    public static Mail getMail(int id) {
      return bunchOfMail.get(id);
    }

  }

}
