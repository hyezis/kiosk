import Model.*;
import View.*;
import Controller.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 데이터베이스 초기화
        Database database = new Database();

        // 메뉴 항목 가져오기
        List<Menu> burgers = database.getBurgers();
        List<Menu> sides = database.getSides();
        List<Menu> drinks = database.getDrinks();

        // 모든 메뉴 항목 통합
        List<Menu> allItems = new ArrayList<>();
        allItems.addAll(burgers);
        allItems.addAll(sides);
        allItems.addAll(drinks);

        Cart cart = new Cart();

        // 뷰 초기화
        AdminView adminView = new AdminView();
        KioskView kioskView = new KioskView();

        // 컨트롤러 초기화
        AdminController adminController = new AdminController(adminView, allItems, database);
        KioskController kioskController = new KioskController(kioskView, cart, burgers, sides, drinks, adminController);


        kioskController.start();
    }
}
