package com.example.app.controller;

import com.example.app.request.Request;
import com.example.app.request.Params;
import com.example.app.request.CreateAccountParams;
import com.example.app.request.PlaceOrderParams;
import com.example.app.request.SendEmailParams;
import com.example.app.repository.RequestRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/requests")
@Tag(name = "Request Management", description = "API for managing polymorphic request parameters")
public class RequestController {

    @Autowired
    private RequestRepository requestRepository;

    @PostMapping
    @Operation(summary = "Create a new request", description = "Create a new request with polymorphic parameters")
    @ApiResponse(responseCode = "200", description = "Request created successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Request.class)))
    public ResponseEntity<Request> createRequest(@RequestBody Request request) {
        Request savedRequest = requestRepository.save(request);
        return ResponseEntity.ok(savedRequest);
    }

    @GetMapping
    @Operation(summary = "Get all requests", description = "Retrieve all requests with their polymorphic parameters")
    public ResponseEntity<List<Request>> getAllRequests() {
        List<Request> requests = requestRepository.findAll();
        return ResponseEntity.ok(requests);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get request by ID", description = "Retrieve a specific request by its ID")
    public ResponseEntity<Request> getRequestById(@PathVariable Long id) {
        Optional<Request> request = requestRepository.findById(id);
        return request.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/examples")
    @Operation(summary = "Get example requests", description = "Get example request objects for each type")
    public ResponseEntity<Object> getExamples() {
        return ResponseEntity.ok(new Object() {
            public final CreateAccountParams createAccountExample = new CreateAccountParams() {{
                setEmail("user@example.com");
                setPlan("PREMIUM");
            }};
            
            public final PlaceOrderParams placeOrderExample = new PlaceOrderParams() {{
                PlaceOrderParams.Item item1 = new PlaceOrderParams.Item();
                item1.setSku("PROD-001");
                item1.setQty(2);
                PlaceOrderParams.Item item2 = new PlaceOrderParams.Item();
                item2.setSku("PROD-002");
                item2.setQty(1);
                setItems(List.of(item1, item2));
                setTotal(java.math.BigDecimal.valueOf(99.99));
            }};
            
            public final SendEmailParams sendEmailExample = new SendEmailParams() {{
                setTo("customer@example.com");
                setSubject("Order Confirmation");
                setRetries(3);
            }};
        });
    }
}
