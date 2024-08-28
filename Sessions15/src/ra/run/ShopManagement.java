package ra.run;
import ra.entity.Categories;
import ra.entity.Product;

import java.util.Scanner;

    public class ShopManagement {
        private static final Categories[] categories = new Categories[100];
        private static final Product[] products = new Product[100];

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("-----------SHOP MENU-----------");
                System.out.println("1. Quản lý danh mục sản phẩm");
                System.out.println("2. Quản lý sản phẩm");
                System.out.println("3. Thoát");
                System.out.print("Chọn chức năng: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        manageCategories(scanner);
                        break;
                    case 2:
                        manageProducts(scanner);
                        break;
                    case 3:
                        System.out.println("Kết thúc chương trình.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Chức năng không hợp lệ. Vui lòng chọn lại.");
                }
            }
        }

        private static void manageCategories(Scanner scanner) {
            while (true) {
                System.out.println("----------------CATEGORIES MENU------------------");
                System.out.println("1. Nhập thông tin các danh mục");
                System.out.println("2. Hiển thị thông tin các danh mục");
                System.out.println("3. Cập nhật thông tin danh mục");
                System.out.println("4. Xóa danh mục");
                System.out.println("5. Cập nhật trạng thái danh mục");
                System.out.println("6. Thoát");
                System.out.print("Chọn chức năng: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        inputCategories(scanner);
                        break;
                    case 2:
                        displayCategories();
                        break;
                    case 3:
                        updateCategory(scanner);
                        break;
                    case 4:
                        deleteCategory(scanner);
                        break;
                    case 5:
                        updateCategoryStatus(scanner);
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Chức năng không hợp lệ. Vui lòng chọn lại.");
                }
            }
        }

        private static void manageProducts(Scanner scanner) {
            while (true) {
                System.out.println("---------------PRODUCT MANAGEMENT----------------");
                System.out.println("1. Nhập thông tin các sản phẩm");
                System.out.println("2. Hiển thị thông tin các sản phẩm");
                System.out.println("3. Sắp xếp các sản phẩm theo giá");
                System.out.println("4. Cập nhật thông tin sản phẩm theo mã sản phẩm");
                System.out.println("5. Xóa sản phẩm theo mã sản phẩm");
                System.out.println("6. Tìm kiếm các sản phẩm theo tên sản phẩm");
                System.out.println("7. Tìm kiếm sản phẩm trong khoảng giá a – b");
                System.out.println("8. Quay lại menu chính");
                System.out.print("Chọn chức năng: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        inputProducts(scanner);
                        break;
                    case 2:
                        displayProducts();
                        break;
                    case 3:
                        sortProductsByPrice();
                        break;
                    case 4:
                        updateProduct(scanner);
                        break;
                    case 5:
                        deleteProduct(scanner);
                        break;
                    case 6:
                        searchProductByName(scanner);
                        break;
                    case 7:
                        searchProductByPriceRange(scanner);
                        break;
                    case 8:
                        return;
                    default:
                        System.out.println("Chức năng không hợp lệ. Vui lòng chọn lại.");
                }
            }
        }

        // Implement the methods here...

        private static void inputCategories(Scanner scanner) {
            System.out.print("Enter number of categories: ");
            int number = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < number; i++) {
                categories[i] = new Categories();
                categories[i].inputData(scanner, categories, i);
            }
        }

        private static void displayCategories() {
            for (Categories category : categories) {
                if (category != null) {
                    category.displayData();
                }
            }
        }

        private static void updateCategory(Scanner scanner) {
            System.out.print("Enter catalog ID to update: ");
            int catalogId = Integer.parseInt(scanner.nextLine());
            for (Categories category : categories) {
                if (category != null && category.getCatalogId() == catalogId) {
                    category.inputData(scanner, categories, catalogId - 1);
                    break;
                }
            }
        }

        private static void deleteCategory(Scanner scanner) {
            System.out.print("Enter catalog ID to delete: ");
            int catalogId = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < categories.length; i++) {
                if (categories[i] != null && categories[i].getCatalogId() == catalogId) {
                    categories[i] = null;
                    System.out.println("Category deleted.");
                    break;
                }
            }
        }

        private static void updateCategoryStatus(Scanner scanner) {
            System.out.print("Enter catalog ID to update status: ");
            int catalogId = Integer.parseInt(scanner.nextLine());
            for (Categories category : categories) {
                if (category != null && category.getCatalogId() == catalogId) {
                    category.setCatalogStatus(!category.isCatalogStatus());
                    System.out.println("Catalog status updated.");
                    break;
                }
            }
        }

        private static void inputProducts(Scanner scanner) {
            System.out.print("Enter number of products: ");
            int number = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < number; i++) {
                products[i] = new Product();
                products[i].inputData(scanner, products, i, categories);
            }
        }

        private static void displayProducts() {
            for (Product product : products) {
                if (product != null) {
                    product.displayData();
                }
            }
        }

        private static void sortProductsByPrice() {
            // Implement sorting logic here...
        }

        private static void updateProduct(Scanner scanner) {
            System.out.print("Enter product ID to update: ");
            String productId = scanner.nextLine();
            for (Product product : products) {
                if (product != null && product.getProductId().equals(productId)) {
                    product.inputData(scanner, products, 0, categories);
                    break;
                }
            }
        }

        private static void deleteProduct(Scanner scanner) {
            System.out.print("Enter product ID to delete: ");
            String productId = scanner.nextLine();
            for (int i = 0; i < products.length; i++) {
                if (products[i] != null && products[i].getProductId().equals(productId)) {
                    products[i] = null;
                    System.out.println("Product deleted.");
                    break;
                }
            }
        }

        private static void searchProductByName(Scanner scanner) {
            System.out.print("Enter product name to search: ");
            String productName = scanner.nextLine();
            for (Product product : products) {
                if (product != null && product.getProductName().contains(productName)) {
                    product.displayData();
                }
            }
        }

        private static void searchProductByPriceRange(Scanner scanner) {
            System.out.print("Enter price range (a and b): ");
            float a = Float.parseFloat(scanner.nextLine());
            float b = Float.parseFloat(scanner.nextLine());
            for (Product product : products) {
                if (product != null && product.getPrice() >= a && product.getPrice() <= b) {
                    product.displayData();
                }
            }
        }
    }


