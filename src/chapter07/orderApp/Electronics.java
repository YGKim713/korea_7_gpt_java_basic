package chapter07.orderApp;
/*
* Electronics 클래스 (자식 클래스)
*
* +) 전자 제품은 특별 세율 적용: 15%
* */
public class Electronics extends Product {
    Electronics (String name, int price) {
        super(name, price);
    }

    // int getPrice() { return price; }

    @Override
    double calculateTax() {
        return getPrice() * 0.15;  // Product 클래스에 있는 것을 가져오는게 아닌,
                                   // Electronics에 생략되어있는 getPrice를 가져오는 것이기 때문에
                                   // super이 생략된게 아닌, this가 생략된 것
    }
}
