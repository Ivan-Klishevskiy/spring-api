package by.tms.springapi.service;

import by.tms.springapi.entity.Order;
import by.tms.springapi.exception.orderException.OrderAlreadyExistException;
import by.tms.springapi.exception.orderException.OrderNotExistException;
import by.tms.springapi.exception.petException.PetNotExistException;
import by.tms.springapi.repository.OrderRepository;
import by.tms.springapi.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PetRepository petRepository;

    public void savePet(Order order) throws OrderAlreadyExistException, PetNotExistException {
        if(orderRepository.existsByPetIdOrId(order.getPetId(),order.getId())){
            throw new OrderAlreadyExistException("Order already exist");
        }else {
            if(petRepository.existsById(order.getPetId())){
                orderRepository.save(order);
            }else{
                throw new PetNotExistException("petId not found");
            }
        }
    }

    public Order findById(Long id) throws OrderNotExistException {
        if(orderRepository.findById(id).isPresent()){
            return orderRepository.findById(id).get();
        }else{
            throw new OrderNotExistException("Order not exist");
        }
    }

    public void delete(Long id) throws OrderNotExistException {
        if(orderRepository.existsById(id)){
            orderRepository.deleteById(id);
        }else{
            throw new OrderNotExistException("Order not exist");
        }
    }
}
