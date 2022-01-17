package by.tms.springapi.controller;

import by.tms.springapi.entity.Order;
import by.tms.springapi.exception.orderException.OrderAlreadyExistException;
import by.tms.springapi.exception.orderException.OrderNotExistException;
import by.tms.springapi.exception.petException.PetNotExistException;
import by.tms.springapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class ShopController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Order order){
        try {
            orderService.savePet(order);
            return ResponseEntity.ok("successful operation");
        } catch (OrderAlreadyExistException | PetNotExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());

        }
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> findById(@PathVariable Long orderId){
        try {
            return ResponseEntity.ok(orderService.findById(orderId));
        } catch (OrderNotExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<?> deleteById(@PathVariable Long orderId){
        try {
            orderService.delete(orderId);
            return ResponseEntity.ok("successful operation");
        } catch (OrderNotExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
