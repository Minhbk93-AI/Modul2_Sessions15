package ra.entity;

import java.util.Scanner;

    public class Categories {
        private int catalogId;
        private String catalogName;
        private String descriptions;
        private boolean catalogStatus;

        public Categories() {}

        public Categories(int catalogId, String catalogName, String descriptions, boolean catalogStatus) {
            this.catalogId = catalogId;
            this.catalogName = catalogName;
            this.descriptions = descriptions;
            this.catalogStatus = catalogStatus;
        }

        public int getCatalogId() {
            return catalogId;
        }

        public String getCatalogName() {
            return catalogName;
        }

        public void setCatalogName(String catalogName) {
            this.catalogName = catalogName;
        }

        public String getDescriptions() {
            return descriptions;
        }

        public void setDescriptions(String descriptions) {
            this.descriptions = descriptions;
        }

        public boolean isCatalogStatus() {
            return catalogStatus;
        }

        public void setCatalogStatus(boolean catalogStatus) {
            this.catalogStatus = catalogStatus;
        }

        public void inputData(Scanner scanner, Categories[] arrCategories, int index) {
            this.catalogId = index + 1; // Auto-increment based on the index
            System.out.print("Enter catalog name: ");
            this.catalogName = scanner.nextLine();

            System.out.print("Enter descriptions: ");
            this.descriptions = scanner.nextLine();

            while (true) {
                System.out.print("Enter catalog status (true/false): ");
                try {
                    this.catalogStatus = Boolean.parseBoolean(scanner.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter true or false.");
                }
            }
        }

        public void displayData() {
            System.out.println("Catalog ID: " + catalogId);
            System.out.println("Catalog Name: " + catalogName);
            System.out.println("Descriptions: " + descriptions);
            System.out.println("Catalog Status: " + (catalogStatus ? "Active" : "Inactive"));
        }
    }


