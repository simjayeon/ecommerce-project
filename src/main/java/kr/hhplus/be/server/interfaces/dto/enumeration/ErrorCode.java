package kr.hhplus.be.server.interfaces.dto.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
@AllArgsConstructor
public enum ErrorCode {
    UNKNOWN(HttpStatus.BAD_REQUEST.value(), "G0001", "알 수 없는 오류가 발생했습니다."),
    INVALID_ACCESS(HttpStatus.BAD_REQUEST.value(), "G0002", "잘못된 접근입니다."),
    INVALID_REQUEST(HttpStatus.BAD_REQUEST.value(), "G0003", "잘못된 요청입니다."),

    PRODUCT_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "P0001", "상품을 찾을 수 없습니다."),
    PRODUCT_STOCK_NOT_ENOUGH(HttpStatus.CONFLICT.value(), "P0002", "상품 재고가 부족합니다."),

    DUPLICATED_COUPON(HttpStatus.CONFLICT.value(), "D0001", "이미 발급받은 쿠폰입니다."),
    COUPON_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "D0002", "쿠폰을 찾을 수 없습니다."),
    COUPON_EXPIRED(HttpStatus.CONFLICT.value(), "C0001", "쿠폰이 만료되었습니다."),

    ORDER_COUNT_ERROR(HttpStatus.CONFLICT.value(), "O0001", "주문 수량은 1개 이상이어야 합니다."),
    ORDER_NOT_FOUND(HttpStatus.BAD_REQUEST.value(), "O0002", "주문 정보를 찾을 수 없습니다."),
    ORDER_COUNT_EXCEED(HttpStatus.UNPROCESSABLE_ENTITY.value(), "O0003", "주문 수량이 재고 수량을 초과했습니다."),

    PAYMENT_ERROR(HttpStatus.CONFLICT.value(), "PAY0001", "결제 오류가 발생했습니다."),
    PAYMENT_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "PAY0002", "결제 정보를 찾을 수 없습니다."),
    PAYMENT_NOT_ENOUGH(HttpStatus.CONFLICT.value(), "PAY0003", "잔액이 부족합니다."),

    USER_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "U0001", "사용자를 찾을 수 없습니다."),

    CHARGE_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "C0001", "충전 정보를 찾을 수 없습니다."),
    CHARGE_ERROR(HttpStatus.CONFLICT.value(), "C0002", "충전 오류가 발생했습니다."),
    CHARGE_AMOUNT_ERROR(HttpStatus.BAD_REQUEST.value(), "C0003", "충전 금액은 1000원 이상이어야 합니다.");

    private Integer status;
    private String code;
    private String errorMessage;

}
