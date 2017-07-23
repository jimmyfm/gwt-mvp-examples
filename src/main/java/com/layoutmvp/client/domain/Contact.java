package com.layoutmvp.client.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Contact {
  private final int id;
  private final String name;
  private final String address;

  public Contact(int id, String name, String address) {
    this.id = id;
    this.name = name;
    this.address = address;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  private static HashMap<Integer, Contact> bunchOfContacts = new HashMap<Integer, Contact>();

  static {
    bunchOfContacts.put(1, new Contact(1, "William Rice", "600-3977 Facilisis Street"));
    bunchOfContacts.put(2, new Contact(2, "Alan Martinez", "P.O. Box 683, 4555 Eu Avenue"));
    bunchOfContacts.put(3, new Contact(3, "John Carr", "5927 Magna, Ave"));
    bunchOfContacts.put(4, new Contact(4, "Kermit Duran", "515-6558 Vehicula. Rd."));
    bunchOfContacts.put(5, new Contact(5, "Matthew Hale", "8742 Mauris. St."));
  }

  public static class CONTACTS {
    private static List<Contact> list = new ArrayList<Contact>(bunchOfContacts.values());

    public static List<Contact> getContactList() {
      return list;
    }

    public static Contact getContact(int id) {
      return bunchOfContacts.get(id);
    }

  }

}
