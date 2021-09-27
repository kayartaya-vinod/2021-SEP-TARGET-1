package co.vinod.training.programs;

import co.vinod.training.dao.DaoException;
import co.vinod.training.dao.DaoFactory;
import co.vinod.training.dao.ProductDao;
import co.vinod.training.entity.Product;
import co.vinod.training.utils.KeyboardUtil;

import java.util.List;

public class Application {
    ProductDao dao;

    public static void main(String[] args) {

        new Application().start();
    }

    void start() {
        // dao = new ArrayListProductDao(); // new JdbcProductDao(); <--- tight coupling
        try {
            dao = DaoFactory.getProductDao(); // loose coupling
        } catch (DaoException e) {
            e.printStackTrace();
            return;
        }
        int choice;

        while ((choice = menu()) != 0) {
            switch (choice) {
                case 1:
                    acceptAndAddProductDetails();
                    break;
                case 2:
                    listProducts();
                    break;
                case 3:
                    System.out.println("Searching by id; TBD");
                    break;
                case 4:
                    System.out.println("Search by price range");
                    break;
                case 5:
                    searchAndUpdate();
            }
        }

        System.out.println("Bye!");
    }

    private void searchAndUpdate() {
        try {
            int id = KeyboardUtil.getInt("Enter id to search: ");
            Product p = dao.getById(id);
            if (p == null) {
                System.out.println("No product data found for id " + id);
                return;
            }

            String input;
            boolean changed = false;

            System.out.println("Enter product details. Hit ENTER to keep the old value.");
            input = KeyboardUtil.getString("Enter product name : (" + p.getName() + ") ");
            if (!input.trim().equals("")) {
                p.setName(input);
                changed = true;
            }

            input = KeyboardUtil.getString("Enter product price : (" + p.getPrice() + ") ");
            if (!input.trim().equals("")) {
                p.setPrice(Double.parseDouble(input));
                changed = true;
            }

            if (!changed) {
                System.out.println("You didn't make any changes. Not updating!");
                return;
            }

            dao.updateProduct(p);
            System.out.println("Product data updated successfully!");

        } catch (DaoException e) {
            System.out.println("There was an error while getting/updating data");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Only numbers are allowed for id or price.");
        }

    }

    void line(char pattern) {
        for (int i = 1; i <= 80; i++) {
            System.out.print(pattern);
        }
        System.out.println();
    }

    private void acceptAndAddProductDetails() {
        try {
            Integer id = KeyboardUtil.getInt("Enter id     : ");
            String name = KeyboardUtil.getString("Enter name   : ");
            Double price = KeyboardUtil.getDouble("Enter price  : ");
            Product p = new Product(id, name, price);
            dao.addProduct(p);
            System.out.println("New product added successfully!");
        } catch (Exception e) {
            System.out.println("There was a problem while adding the product details.");
            System.out.println(e.getMessage());
        }
    }

    private void listProducts() {
        try {
            List<Product> list = dao.getAll();
            line('=');
            System.out.printf("%-10s %-40s %10s\n", "ID", "Name", "Price");
            line('=');
            for (Product p : list) {
                System.out.printf("%-10d %-40s %10.2f\n", p.getId(), p.getName(), p.getPrice());
            }
            line('-');
        } catch (DaoException e) {
            System.out.println("There was a problem - " + e.getMessage());
        }

    }

    int menu() {
        line('.');
        int choice = -1;
        do {
            System.out.println("0. Exit");
            System.out.println("1. Add new product");
            System.out.println("2. List all products");
            System.out.println("3. Search by id");
            System.out.println("4. Search by price range");
            System.out.println("5. Update");
            try {
                choice = KeyboardUtil.getInt("Enter your choice: ");
                if (choice < 0 || choice > 5) {
                    System.out.println("Invalid choice, please retry!");
                }
            } catch (Exception e) {
                System.out.println("Invalid choice, please retry!");
            }


        } while (choice < 0 || choice > 5);

        return choice;
    }
}
