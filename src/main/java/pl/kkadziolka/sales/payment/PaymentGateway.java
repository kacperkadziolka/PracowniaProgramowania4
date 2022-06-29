package pl.kkadziolka.sales.payment;

public interface PaymentGateway {
    RegisterPaymentResponse register(RegisterPaymentRequest registerPaymentRequest);
}