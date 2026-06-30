package streams;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlightStreamDemo {
	public static void main(String[] args) throws Exception {
		Stream<String> lines = Files.lines(Paths.get("src/Flights.txt"));
		List<Flight> flights = lines.map(line -> {
			String[] s = line.split(",");
			return new Flight(Integer.parseInt(s[0]),
				s[1], s[2], s[3]);
		}).collect(Collectors.toList());
		flights.forEach(System.out::println);

		System.out.println("-----print details of flight no 765");
		flights.stream().filter(f->f.getCode()==765).forEach(System.out::println);
		System.out.println("------print all flights by kingfisher");
		flights.stream().filter(f->f.getCarrier().equals(" kingfisher")).forEach(System.out::println);
		System.out.println("---------print flight going delhi to banglore");
		flights.stream().filter(f->f.getSource().equals(" Delhi")&&f.getDestination().equals(" Banglore")).forEach(System.out::println);
		System.out.println("---------remove flight no 123");
		flights.removeIf(f->f.getCode()==123);
	}
}
