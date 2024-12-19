package chapter07.orderApp;

/*
* Order 클래스 - 실제 주문 로직이 구현
*
* 특정 제품(Product)과 수량(Quantity)을 기반으로 주문을 생성
* +) 총 가격(세금 포함)을 계산하는 역할
* */
public class Order {
    private Product product;  // Product라는 전체 타입을 사용해야 제품별로 따로 만들지 않아도 됨(?)
    private int quantity;

    Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // 총 가격 계산 메서드
    double calculateTotalPrice() {
        double tax = product.calculateTax();
        double totalPrice = (product.getPrice() + tax) * quantity;
        return totalPrice;
    }

    // 주문 정보를 반환하는 메서드
    @Override
    public String toString() { // toString은 Java에 내장된 함수이므로 재정의해야함 >> extends 없음(Java에 내장된 함수이기 때문)
        return "Order Detail[ " + product.getName() + " * "
            + "Quantity: " + quantity + " >> " + calculateTotalPrice() + " ]";
        // Order Detail[ snake * 2 >> 18000 ]
    }
}
