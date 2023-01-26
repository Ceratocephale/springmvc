package be.technifutur.java.demospringmvc;

import be.technifutur.java.demospringmvc.models.entity.Reservation;
import be.technifutur.java.demospringmvc.repository.ReservationRepository;
import be.technifutur.java.demospringmvc.utils.EMFSharer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class DemoSpringMvcApplication {

	public static void main(String[] args) {
		ApplicationContext ctxt = SpringApplication.run(DemoSpringMvcApplication.class, args);

		ReservationRepository repository = ctxt.getBean(ReservationRepository.class);

//		List<Reservation> reservationList = repository.getFromMonth(Month.OCTOBER, 2023);
//		reservationList.forEach(v -> System.out.println(v.getId()));

//		LocalDate date = LocalDate.of(2023,9,30);
//		int breakfast = repository.getBreakfastNeededForDay(date);
//		System.out.println(breakfast);

		List<Reservation> reservations = repository.getFutureShortReservation();
		reservations.forEach(v -> System.out.println(v.getId()));

		ctxt.getBean(EMFSharer.class).close();
	}

}
