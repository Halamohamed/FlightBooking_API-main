package se.lexicon.flightbooking_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class FlightBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    
    @Column(nullable = false)
    private String flightNumber;
    
    private String passengerName;
    
    private String passengerEmail;
    
    @Column(nullable = false)
    private LocalDateTime departureTime;
    
    @Column(nullable = false)
    private LocalDateTime arrivalTime;
    
    @Enumerated(EnumType.STRING)
    private FlightStatus status;
    
    private String destination;
    
    private Double price;

    @Column(nullable = false)
    @Max(20)
    private Integer seats;

    @PrePersist
    public void prePersist() {
        this.seats = +1;
    }


}
