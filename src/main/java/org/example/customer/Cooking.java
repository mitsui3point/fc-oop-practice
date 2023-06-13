package org.example.customer;

import org.example.customer.domain.Cook;
import org.example.customer.domain.MenuItem;

public class Cooking {

    public Cook makeCook(MenuItem menuItem) {
        return new Cook(menuItem);
    }
}
