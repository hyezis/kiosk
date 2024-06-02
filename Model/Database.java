package Model;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Menu> burgers;
    private List<Menu> sides;
    private List<Menu> drinks;

    public Database() {
        initializeDatabase();
    }

    private void initializeDatabase() {
        burgers = new ArrayList<>();
        addBurger("불고기버거", 3000, 20);
        addBurger("치즈버거", 3500, 15);

        sides = new ArrayList<>();
        addSide("감자튀김", 2000, 45);
        addSide("치즈스틱", 2000, 20);

        drinks = new ArrayList<>();
        addDrink("콜라", 1500, 80);
        addDrink("사이다", 1500, 90);

    }

    public void addBurger(String name, double price, int stock) {
        burgers.add(new Burger(name, price, stock, false));
        burgers.add(new Burger(name, price + 2000, stock, true));
    }

    public void addSide(String name, double price, int stock) {
        sides.add(new Side(name, price, stock, "Regular"));
        sides.add(new Side(name, price + 1000, stock, "Large"));
    }

    public void addDrink(String name, double price, int stock) {
        drinks.add(new Drink(name, price, stock, "Regular"));
        drinks.add(new Drink(name, price + 500, stock, "Large"));
    }

    public List<Menu> getBurgers() {
        return burgers;
    }

    public List<Menu> getSides() {
        return sides;
    }

    public List<Menu> getDrinks() {
        return drinks;
    }
}
