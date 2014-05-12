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

	private void loadOrders() {
		Order order1 = new Order();
		order1.setId(1L);
		order1.setValue(BigDecimal.valueOf(116.2D));
		order1.setCustomer(customerRepository.find(1L));
		
		itemRepository.save(new Item(1L, 1L, productRepository.find(1L), 1));
		itemRepository.save(new Item(2L, 1L, productRepository.find(3L), 2));
		
		order1.addItem(itemRepository.find(1L));
		order1.addItem(itemRepository.find(2L));
		
		Payment payment1 = new Payment(1L, 1L, PaymentType.CREDIT_CARD, BigDecimal.valueOf(35.5D));
		paymentRepository.save(payment1);
		order1.addPayments(paymentRepository.find(1L));

		
		Payment payment2 = new Payment(2L, 1L, PaymentType.DEBIT_CARD, BigDecimal.valueOf(80.7D));
		paymentRepository.save(payment2);
		order1.addPayments(paymentRepository.find(2L));
		

		orderRepository.save(order1);

		Order order2 = new Order();
		order2.setId(2L);
		order2.setValue(BigDecimal.valueOf(175.0D));
		order2.setCustomer(customerRepository.find(2L));
		
		Payment payment3 = new Payment(3L, 2L, PaymentType.GIFT_CARD, BigDecimal.valueOf(100.0D));
		paymentRepository.save(payment3);
		order2.addPayments(paymentRepository.find(3L));
		
		Payment payment4 = new Payment(4L, 2L, PaymentType.CREDIT_CARD, BigDecimal.valueOf(75.0D));
		paymentRepository.save(payment4);
		order2.addPayments(paymentRepository.find(4L));

		
		itemRepository.save(new Item(3L, 2L, productRepository.find(3L), 2));
		itemRepository.save(new Item(4L, 2L, productRepository.find(4L), 2));
		
		order2.addItem(itemRepository.find(3L));
		order2.addItem(itemRepository.find(4L));
		

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
