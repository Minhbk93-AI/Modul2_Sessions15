package ra.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private float price;
    private String description;
    private Date created;
    private int catalogId;
    private int productStatus;

    public Product() {}

    public Product(String productId, String productName, float price, String description, Date created, int catalogId, int productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.created = created;
        this.catalogId = catalogId;
        this.productStatus = productStatus;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    public void inputData(Scanner scanner, Product[] arrProduct, int index, Categories[] arrCategories) {
        System.out.print("Enter product ID: ");
        this.productId = scanner.nextLine();

        System.out.print("Enter product name: ");
        this.productName = scanner.nextLine();

        while (true) {
            System.out.print("Enter price: ");
            try {
                this.price = Float.parseFloat(scanner.nextLine());
                if (price > 0) {
                    break;
                } else {
                    System.out.println("Price must be greater than 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        System.out.print("Enter description: ");
        this.description = scanner.nextLine();

        while (true) {
            System.out.print("Enter created date (dd/MM/yyyy): ");
            try {
                String dateStr = scanner.nextLine();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                this.created = sdf.parse(dateStr);
                break;
            } catch (Exception e) {
                System.out.println("Invalid date format. Please enter date as dd/MM/yyyy.");
            }
        }

        System.out.println("Select catalog ID:");
        for (Categories cat : arrCategories) {
            if (cat != null) {
                System.out.println(cat.getCatalogId() + ": " + cat.getCatalogName());
            }
        }
        this.catalogId = Integer.parseInt(scanner.nextLine());

        while (true) {
            System.out.print("Enter product status (0: Selling, 1: Out of Stock, 2: Not Selling): ");
            try {
                this.productStatus = Integer.parseInt(scanner.nextLine());
                if (productStatus >= 0 && productStatus <= 2) {
                    break;
                } else {
                    System.out.println("Please enter a valid status.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public void displayData() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Price: " + price);
        System.out.println("Description: " + description);
        System.out.println("Created Date: " + sdf.format(created));
        System.out.println("Catalog ID: " + catalogId);
        System.out.println("Product Status: " + (productStatus == 0 ? "Selling" : productStatus == 1 ? "Out of Stock" : "Not Selling"));
    }
}

