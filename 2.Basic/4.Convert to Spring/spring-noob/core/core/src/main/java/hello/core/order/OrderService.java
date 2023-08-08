package hello.core.order;

public interface OrderService {
    //주문 도메인 전체 그림의 4.주문결과반환(return)에 해당
    Order createOrder(Long memberId,String itemName,int itemPrice);
}
