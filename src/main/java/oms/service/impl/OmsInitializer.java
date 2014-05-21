package oms.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.PostConstruct;

import oms.model.Address;
import oms.model.Customer;
import oms.model.Item;
import oms.model.Order;
import oms.model.Payment;
import oms.model.PaymentType;
import oms.model.Product;
import oms.repository.CustomerRepository;
import oms.repository.ItemRepository;
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

	@Autowired
	private ItemRepository itemRepository;

	@PostConstruct
	public void loadDataset() {
		loadCustomers();

		loadProducts();

		loadOrders();
	}

	private void loadProducts() {
		productRepository.save(new Product(1L, "Maquina de Lavar", BigDecimal.valueOf(1000D)));
		productRepository.save(new Product(2L, "TV LED 42", BigDecimal.valueOf(3500D)));
		productRepository.save(new Product(3L, "Fogão 4 Bocas", BigDecimal.valueOf(1500D)));
		productRepository.save(new Product(4L, "Notebook I3", BigDecimal.valueOf(3800D)));
		productRepository.save(new Product(5L, "Rádio AM/FM", BigDecimal.valueOf(32.50)));
		productRepository.save(new Product(6L, "Jogo de Xícaras", BigDecimal.valueOf(63D)));
}

	private void loadOrders() {
		Order order1 = new OrderBuilder()
				.withOrder(1L, BigDecimal.valueOf(116.2D))
				.setCustomer(customerRepository.find(1L))
				.addItem(
						itemRepository.save(new Item(1L, 1L, productRepository
								.find(1L), 1)))
				.addItem(
						itemRepository.save(new Item(2L, 1L, productRepository
								.find(3L), 2)))
				.addPayment(
						paymentRepository.save(new Payment(1L, 1L,
								PaymentType.CREDIT_CARD, BigDecimal
										.valueOf(35.5D))))
				.addPayment(
						paymentRepository.save(new Payment(2L, 1L,
								PaymentType.DEBIT_CARD, BigDecimal
										.valueOf(80.7D)))).getOrder();
		orderRepository.save(order1);

		Order order2 = new OrderBuilder()
				.withOrder(2L, BigDecimal.valueOf(175.0D))
				.setCustomer(customerRepository.find(2L))
				.addItem(
						itemRepository.save(new Item(3L, 2L, productRepository
								.find(3L), 2)))
				.addItem(
						itemRepository.save(new Item(4L, 2L, productRepository
								.find(4L), 2)))
				.addPayment(
						paymentRepository.save(new Payment(3L, 2L,
								PaymentType.GIFT_CARD, BigDecimal
										.valueOf(100.0D))))
				.addPayment(
						paymentRepository.save(new Payment(4L, 2L,
								PaymentType.CREDIT_CARD, BigDecimal
										.valueOf(75.0D)))).getOrder();
		orderRepository.save(order2);

		Order order1234 = new OrderBuilder()
				.withOrder(1234L, BigDecimal.valueOf(95.5D))
				.setCustomer(customerRepository.find(3L))
				.addItem(
						itemRepository.save(new Item(5L, 1234L, productRepository
								.find(5L), 1)))
				.addItem(
						itemRepository.save(new Item(6L, 1234L, productRepository
								.find(6L), 1)))
				.addPayment(
						paymentRepository.save(new Payment(5L, 1234L,
								PaymentType.CREDIT_CARD, BigDecimal
										.valueOf(95.5D)))).getOrder();
		orderRepository.save(order1234);
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
		
		Customer customer3 = new Customer();
		customer3.setId(3L);
		customer3.setName("Josefa Araújo");
		customer3.setDocument("0987654321");
		Address address3 = new Address("Av. Joana Angélica", "53", "01234908",
				"", "Acre");
		address3.setId(3L);
		customer3.setAddress(address3);
		customerRepository.save(customer3);
	}

	static class OrderBuilder {
		private Order order;

		public OrderBuilder withOrder(Long id, BigDecimal value) {
			this.order = new Order();
			this.order.setId(id);
			this.order.setValue(value);
			this.order.setCreatedAt(new Date());
			return this;
		}

		public OrderBuilder setCustomer(Customer customer) {
			this.order.setCustomer(customer);
			return this;
		}

		public OrderBuilder addPayment(Payment payment) {
			this.order.addPayments(payment);
			return this;
		}

		public OrderBuilder addItem(Item item) {
			this.order.addItem(item);
			return this;
		}

		public Order getOrder() {
			return this.order;
		}
	}
}
