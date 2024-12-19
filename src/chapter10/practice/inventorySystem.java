package chapter10.practice;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

// Inventory System: 재고 관리 시스템
public class inventorySystem {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("===== Inventory System =====");
            System.out.println("1. Add Book");
            System.out.println("2. List All Book");
            System.out.println("3. Search Book");
            System.out.println("4. Search by Category");
            System.out.println("5. Search by Price Range");
            System.out.println("6. Update Stock");
            System.out.println("7. Remove Book");
            System.out.println("8. Exit");
            System.out.print("Select an option: ");

            try {
                // scanner.nextLine();
                // : 입력값이 '문자열'로 인식 >> 참조형 데이터를 기본 데이터로 바꾸지는 못함

                // Integer.parseInt();
                // : 데이터를 분석하여 Int 형태로 변경
                // >> 숫자 형태로 변경할 수 없는 값이 입력되는 경우(1을 쳐야하는데 안녕을 쳤다거나) NumberFormatException 예외 발생
                // cf) parse: 분석하다
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter Book ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter Book Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter Book ISBN: ");
                        String isbn = scanner.nextLine();
                        System.out.print("Enter Book Author: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter Book Publisher: ");
                        String publisher = scanner.nextLine();

                        System.out.print("Enter Book Publish Year: ");
                        int year = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter Price: ");
                        int price = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter Stock Quantity: ");
                        int stock = Integer.parseInt(scanner.nextLine());

                        System.out.print("Enter Book Category: ");
                        String category = scanner.nextLine();

                        manager.add(new Book(id, title, isbn, author, publisher, year, price, stock, category)); // 업캐스팅
                        break;
                    case 2:
                        manager.listAll();
                        break;
                    case 3:
                        System.out.print("Enter search keyword: ");
                        String keyword = scanner.nextLine();
                        List<Item> searchResults = manager.search(keyword);
                        if (searchResults.isEmpty()) {
                            System.out.println("No items found in keyword: " + keyword);
                        } else {
                            for (Item item : searchResults) {
                                item.display();
                            }
                        }
                        break;
                    case 4:
                        System.out.print("Enter category: ");
                        String searchCategory = scanner.nextLine();
                        List<Item> categoryResults = manager.searchByCategory(searchCategory);
                        if (categoryResults.isEmpty()) {
                            System.out.println("No items found in category: " + searchCategory);
                        } else {
                            for (Item item : categoryResults) {
                                item.display();
                            }
                        }
                        break;
                    case 5:
                        System.out.print("Enter minimum price: ");
                        int minPrice = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter maximum price: ");
                        int maxPrice = Integer.parseInt(scanner.nextLine());

                        List<Item> priceResults = manager.searchByPriceRange(minPrice, maxPrice);
                        if (priceResults.isEmpty()) {
                            System.out.println("No items found in price range");
                        } else {
//                          for (Item item : priceResults) {
//                              item.display();
//                          }  - 이 세 문장을 아래 한 문장으로 축약할 수 있음
                            priceResults.forEach(Item::display);
                        }
                        break;
                    case 6:
                        System.out.print("Enter Book ID to update stock: ");
                        String updateId = scanner.nextLine();
                        System.out.print("Enter quantity to add/subtract: ");
                        int quantity = Integer.parseInt(scanner.nextLine());
                        manager.updateStock(updateId, quantity);
                        break;
                    case 7:
                        System.out.print("Enter Book ID to remove: ");
                        String removeId = scanner.nextLine();
                        manager.remove(removeId);
                        break; // case 종료 (반복문은 계속 실행) - while로 돌아감
                    case 8:
                        System.out.println(" == Exiting ==");
                        return; // 반복문 전체 종료 - while 종료
                    default:
                        System.out.println("Invalid option. Try again");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please Enter a valid number.");
            } catch (NoSuchElementException e) {
                // 검색된 내용이 없을 경우 실행될 블럭
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
