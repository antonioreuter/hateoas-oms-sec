package oms.service.impl;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;

import oms.model.Address;
import oms.model.Customer;
import oms.model.Item;
import oms.model.Order;
import oms.model.Payment;
import oms.model.PaymentType;
import oms.model.Product;
import oms.repository.CustomerRepository;
import oms.repository.OrderRepository;
import oms.repository.PaymentRepository;
import oms.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OmsInitializer {
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private ProductRepository productRepository;

	@PostConstruct
	public void loadDataset() {
		loadCustomers();

		loadPayments();

		loadProducts();

		loadOrders();
	}

	private void loadProducts() {
		Product product1 = new Product(1L, "Maquina de Lavar",
				BigDecimal.valueOf(1000D));
		productRepository.save(product1);

		Product product2 = new Product(2L, "TV LED 42",
				BigDecimal.valueOf(3500D));
		productRepository.save(product2);

		Product product3 = new Product(3L, "Fogão 4 Bocas",
				BigDecimal.valueOf(1500D));
		productRepository.save(product3);

		Product product4 = new Product(4L, "Notebook I3",
				BigDecimal.valueOf(3800D));
		productRepository.save(product4);
	}

	private void loadPayments() {
		Payment payment1 = new Payment(PaymentType.CREDIT_CARD,
				BigDecimal.valueOf(35.5D));
		payment1.setId(1L);
		paymentRepository.save(payment1);

		Payment payment2 = new Payment(PaymentType.DEBIT_CARD,
				BigDecimal.valueOf(80.7D));
		payment2.setId(2L);
		paymentRepository.save(payment2);

		Payment payment3 = new Payment(PaymentType.GIFT_CARD,
				BigDecimal.valueOf(100.0D));
		payment3.setId(3L);
		paymentRepository.save(payment3);

		Payment payment4 = new Payment(PaymentType.CREDIT_CARD,
				BigDecimal.valueOf(75.0D));
		payment4.setId(4L);
		paymentRepository.save(payment4);

	}

	private void loadOrders() {
		Order order1 = new Order();
		order1.setId(1L);
		order1.setValue(BigDecimal.valueOf(116.2D));
		order1.setCustomer(customerRepository.find(1L));
		order1.addPayments(paymentRepository.find(1L));
		order1.addPayments(paymentRepository.find(2L));
		order1.addItem(new Item(1L, productRepository.find(1L), 1));
		order1.addItem(new Item(2L, productRepository.find(3L), 2));

		orderRepository.save(order1);

		Order order2 = new Order();
		order2.setId(2L);
		order2.setValue(BigDecimal.valueOf(175.0D));
		order2.setCustomer(customerRepository.find(2L));
		order2.addPayments(paymentRepository.find(3L));
		order2.addPayments(paymentRepository.find(4L));
		order2.addItem(new Item(3L, productRepository.find(3L), 2));
		order2.addItem(new Item(4L, productRepository.find(4L), 2));

		orderRepository.save(order2);
	}

	private void loadCustomers() {
		Customer customer1 = new Customer();
		customer1.setId(1L);
		customer1.setName("John Doe");
		customer1.setDocument("084093284");
		Address address1 = new Address("Av. Paulista", "278", "04049993", "",
				"Sao Paulo");
		address1.setId(1L);
		customer1.setAddress(address1);
		customerRepository.save(customer1);

		Customer customer2 = new Customer();
		customer2.setId(2L);
		customer2.setName("Joseph Climber");
		customer2.setDocument("059384526");
		Address address2 = new Address("Av. Tancredo Neves", "574", "41984334",
				"", "Bahia");
		address2.setId(2L);
		customer2.setAddress(address2);
		customerRepository.save(customer2);
	}
}
