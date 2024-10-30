package com.carlosmolina.best_travel;

import com.carlosmolina.best_travel.domain.entities.ReservationEntity;
import com.carlosmolina.best_travel.domain.entities.TicketEntity;
import com.carlosmolina.best_travel.domain.entities.TourEntity;
import com.carlosmolina.best_travel.domain.repositories.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootApplication
@Slf4j
public class BestTravelApplication implements CommandLineRunner {

	private final HotelRepository hotelRepository;
	private final FlyRepository flyRepository;
	private final CustomerRepository customerRepository;
	private final ReservationRepository	reservationRepository;
	private final TicketRepository	ticketRepository;
	private final TourRepository tourRepository;

	public BestTravelApplication(HotelRepository hotelRepository,
								 FlyRepository flyRepository,
								 CustomerRepository customerRepository,
								 ReservationRepository reservationRepository,
								 TicketRepository ticketRepository,
								 TourRepository tourRepository) {
		this.hotelRepository = hotelRepository;
		this.flyRepository = flyRepository;
		this.customerRepository = customerRepository;
		this.reservationRepository = reservationRepository;
		this.ticketRepository = ticketRepository;
		this.tourRepository = tourRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BestTravelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*var fly= flyRepository.findById(15L).get();
		var hotel = hotelRepository.findById(4L).get();
		var ticket = ticketRepository.findById(UUID.fromString("22345678-1234-5678-3235-567812345678")).get();
		var reservation = reservationRepository.findById(UUID.fromString("32345678-1234-5678-1234-567812345678")).get();
		var customer = customerRepository.findById("BBMB771012HMCRR022").get();

		log.info(String.valueOf(fly));
		log.info(String.valueOf(hotel));
		log.info(String.valueOf(ticket));
		log.info(String.valueOf(reservation));
		log.info(String.valueOf(customer));*/

		//this.flyRepository.selectLessPrice(BigDecimal.valueOf(13)).forEach(f -> System.out.println(f));
		//this.flyRepository.selectBetweenPrice(BigDecimal.valueOf(10), BigDecimal.valueOf(15)).forEach(f -> System.out.println(f));
		//this.flyRepository.selectOrigingDestiny("Grecia", "Mexico").forEach(f -> System.out.println(f));

		//var fly= flyRepository.findByTicketId(UUID.fromString("12345678-1234-5678-2236-567812345678")).get();

		//System.out.println(fly);

		//hotelRepository.findByPriceLessThan(BigDecimal.valueOf(100)).forEach(System.out::println);

		//hotelRepository.findByPriceBetween(BigDecimal.valueOf(100), BigDecimal.valueOf(200)).forEach(System.out::println);

		//hotelRepository.findByRatingGreaterThan(3).forEach(System.out::println);

		var customer = customerRepository.findById("GOTW771012HMRGR087").orElseThrow();
		var tour = TourEntity.builder()
				.customer(customer)
				.build();

		var fly = flyRepository.findById(11L).orElseThrow();

		var hotel = hotelRepository.findById(3L).orElseThrow();

		var ticket = TicketEntity.builder()
				.id(UUID.randomUUID())
				.price(fly.getPrice().multiply(BigDecimal.TEN))
				.arrivalDate(LocalDate.now())
				.departureDate(LocalDate.now())
				.purchaseDate(LocalDate.now())
				.customer(customer)
				.tour(tour)
				.fly(fly)
				.build();

		var reservation = ReservationEntity.builder()
				.id(UUID.randomUUID())
				.dateTimeReservation(LocalDateTime.now())
				.dateEnd(LocalDate.now().plusDays(2))
				.dateStart(LocalDate.now().plusDays(1))
				.hotel(hotel)
                .customer(customer)
				.tour(tour)
				.totalDays(1)
				.price(hotel.getPrice().multiply(BigDecimal.TEN))
                .build();

        //ticketRepository.save(ticket);

		tour.addReservation(reservation);
		//tour.updateReservations();
		//tour.addTicket(ticket);
		//tour.updateTickets();

		this.tourRepository.save(tour);

		//reservationRepository.save(reservation);
	}
}
