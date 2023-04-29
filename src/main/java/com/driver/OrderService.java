package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;


    public void addOrder(Order order){
        orderRepository.addOrder(order);
    }

    public void addPartner(String partnerId){
        orderRepository.addPartner(partnerId);
    }


    public void addOrderPartnerPair(String orderId, String partnerId){
        orderRepository.addOrderPartnerPair(orderId, partnerId);
    }

    public Order getOrderById(String orderId){
        Order order = orderRepository.getOrderById(orderId);
        return order;
    }

    public DeliveryPartner getPartnerById(String partnerId){
        DeliveryPartner partner = orderRepository.getPartnerById(partnerId);
        return partner;
    }

    public int getOrderCountByPartnerId(String partnerId){
        int orderCount = orderRepository.getOrderCountByPartnerId(partnerId);
        return orderCount;
    }

    public List<String> getOrdersByPartnerId(String partnerId){
        List<String> list = orderRepository.getOrdersByPartnerId(partnerId);
        return list;

    }

    public List<String> getAllOrders(){
        List<String> list = orderRepository.getAllOrders();
        return list;
    }

    public int getCountOfUnassignedOrders(){
        int count = orderRepository.getCountOfUnassignedOrders();
        return count;
    }

    public int getOrdersLeftAfterGivenTimeByPartnerId(String time, String partnerId){
        String s1 = String.valueOf(time.charAt(0) + time.charAt(1));
        String s2 = String.valueOf(time.charAt(3) + time.charAt(4));
        int hh = Integer.valueOf(s1);
        int mm = Integer.valueOf(s2);

        int timeInt = (hh*60)+mm;

        int count = orderRepository.getOrdersLeftAfterGivenTimeByPartnerId(timeInt, partnerId);

        return count;
    }

    public String getLastDeliveryTimeByPartnerId(String partnerId){

        String time = orderRepository.getLastDeliveryTimeByPartnerId(partnerId);
        return time;
    }


    public void deletePartnerById(String partnerId){

        orderRepository.deletePartnerById(partnerId);
    }

    public void deleteOrderById(String orderId){

        orderRepository.deleteOrderById(orderId);
    }
}
