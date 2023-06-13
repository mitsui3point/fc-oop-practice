package org.example.customer;

import org.example.customer.domain.Cook;
import org.example.customer.domain.Menu;
import org.example.customer.domain.MenuItem;

public class Customer {
    public void order(String name, Menu menu, Cooking cooking) {
        MenuItem menuItem = menu.choose(name);
        Cook cook = cooking.makeCook(menuItem);
    }
}
