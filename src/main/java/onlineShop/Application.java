package onlineShop;

import onlineShop.log.PaymentAction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import onlineShop.model.Cart;
import onlineShop.model.CartItem;
import onlineShop.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args){
        // container
        // ApplicationContext container = new ClassPathXmlApplicationContext("payment.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        //PaymentAction paymentAction = (PaymentAction) container.getBean("paymentAction");
        //paymentAction.pay(new BigDecimal(2));

        SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");

        Session session = sessionFactory.openSession();
        System.out.println("aawfewraer");
        session.beginTransaction();

        Customer customer = new Customer();
        customer.setFirstName("stefan");
        customer.setLastName("laioffer");

        CartItem cartItem1 = new CartItem();
        cartItem1.setQuantity(1);
        cartItem1.setPrice(1);

        CartItem cartItem2 = new CartItem();
        cartItem2.setQuantity(2);
        cartItem2.setPrice(2);

        Cart cart = new Cart();
        cart.setCartItem(new ArrayList<>());
        cart.getCartItem().add(cartItem1);
        cart.getCartItem().add(cartItem2);

        customer.setCart(cart);

        session.save(customer);

        session.getTransaction().commit();
        session.close();
    }
}
