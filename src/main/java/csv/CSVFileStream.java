package csv;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import jakarta.persistence.criteria.Predicate;

public class CSVFileStream {
	public static void main(String args[]) throws IOException {
		Path path = Path.of("src", "main", "resources", "Final_Dataset.csv");
		
		List<Car> carList = Files.lines(path).skip(1).map(CSVFileStream::getCarDetails).collect(Collectors.toList());
		// System.out.println(carList);
		Goal1(carList);
		Goal2(carList);
		Goal3(carList);
		Goal4(carList);
		Goal5(carList);
		Goal6(carList);
		Goal7(carList);
		Goal8(carList);
		Goal9(carList);
		Goal10(carList);
	}

	private static Car getCarDetails(String line) {
		String[] fields = line.split(",");
		if (fields.length != 11)
			throw new RuntimeException("Invalid CSV line - " + line);
		return new Car(Integer.parseInt(fields[0]), fields[1], fields[2], fields[3], Integer.parseInt(fields[4]),
				Long.parseLong(fields[5]), fields[6], fields[7], fields[8], fields[9], Long.parseLong(fields[10]));
	}

	private static void Goal1(List<Car> carsList) throws IOException {
		long startTime = System.nanoTime();
		PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Paths.get("src/main/resources/goal1.txt")));
		carsList.stream()
				.filter(car -> car.getBrand().equalsIgnoreCase("Maruti") && car.getModel().equalsIgnoreCase("Alto"))
				.map( Car :: toString1 )
				.forEach(pw::println);
		pw.close();
		long elapsedTime = System.nanoTime() - startTime;
		System.out.println("\n\nTotal execution time for Goal1 in milli_seconds: " + elapsedTime / 1000000);

	}

	private static void Goal2(List<Car> carsList) throws IOException {
		long startTime = System.nanoTime();
		PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Paths.get("src/main/resources/goal2.txt")));
		Map<String, Map<Integer, Long>> multipleFieldsMap = carsList.stream().filter(car -> car.getYear() >= 2011 && car.getYear() <= 2015)
		.collect(Collectors.groupingBy(Car::getBrand, 
						Collectors.groupingBy(Car::getYear, 
								Collectors.counting())));
		List<Car> Goal2List = new ArrayList<>();
		for (Map.Entry<String, Map<Integer, Long>> entry : multipleFieldsMap.entrySet()) {
			for(Map.Entry<Integer, Long> entry2 : entry.getValue().entrySet()) {
				Goal2List.add(new Car(entry.getKey(),entry2.getKey(),entry2.getValue()));
			}
		}
		Goal2List.stream().map(Car::Goal2String).forEach(pw::println);
		pw.close();
		long elapsedTime = System.nanoTime() - startTime;
		System.out.println("\n\nTotal execution time for Goal2 in milli_seconds: " + elapsedTime / 1000000);

	}

	private static void Goal3(List<Car> carsList) throws IOException {
		long startTime = System.nanoTime();
		PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Paths.get("src/main/resources/goal3.txt")));
		Map<String, Map<String, Long>> multipleFieldsMap = carsList.stream().filter(car -> car.getFuel().equalsIgnoreCase("diesel"))
		.collect(Collectors.groupingBy(Car::getBrand, 
				Collectors.groupingBy(Car::getModel, 
						Collectors.counting())));
		List<Car> Goal3List = new ArrayList<>();
		for (Map.Entry<String, Map<String, Long>> entry : multipleFieldsMap.entrySet()) {
			for(Map.Entry<String, Long> entry2 : entry.getValue().entrySet()) {
				Goal3List.add(new Car(entry.getKey(),entry2.getKey(),"diesel"));
			}
		}
		Goal3List.stream().map(Car::Goal3String).forEach(pw::println);
		pw.close();
		long elapsedTime = System.nanoTime() - startTime;
		System.out.println("\n\nTotal execution time for Goal3 in milli_seconds: " + elapsedTime / 1000000);

	}



	private static void Goal4(List<Car> carsList) throws IOException {
		long startTime = System.nanoTime();
		PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Paths.get("src/main/resources/goal4.txt")));
		carsList.stream().filter(car -> car.getPrice() > 300000 && car.getPrice() <= 600000)
		.map( Car :: Goal4String )
		.forEach(pw::println);
		pw.close();
		long elapsedTime = System.nanoTime() - startTime;
		System.out.println("\n\nTotal execution time for Goal4 in milli_seconds: " + elapsedTime / 1000000);

	}

	private static void Goal5(List<Car> carsList) throws IOException {
		long startTime = System.nanoTime();
		PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Paths.get("src/main/resources/goal5.txt")));
		carsList.stream().filter(car -> car.getLocation().equalsIgnoreCase("delhi"))
		.map( Car :: Goal5String ).forEach(pw::println);
		pw.close();
		long elapsedTime = System.nanoTime() - startTime;
		System.out.println("\n\nTotal execution time for Goal5 in milli_seconds: " + elapsedTime / 1000000);

	}

	private static void Goal6(List<Car> carsList) throws IOException {
		long startTime = System.nanoTime();
		Map<String, Map<String, Long>> multipleFieldsMap = carsList.stream().filter(car -> (car.getBrand().equalsIgnoreCase("BMW")))
		.collect(Collectors.groupingBy(Car::getBrand, 
				Collectors.groupingBy(Car::getModel, 
						Collectors.counting())));
		List<Car> Goal6List = new ArrayList<>();
		PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Paths.get("src/main/resources/goal6.txt")));
		for (Map.Entry<String, Map<String, Long>> entry : multipleFieldsMap.entrySet()) {
			for(Map.Entry<String, Long> entry2 : entry.getValue().entrySet()) {
				Goal6List.add(new Car(entry.getKey(),entry2.getKey(),entry2.getValue()));
			}
		}
		Goal6List.stream().map(Car::Goal6String).forEach(pw::println);
		pw.close();
		long elapsedTime = System.nanoTime() - startTime;
		System.out.println("\n\nTotal execution time for Goal6 in milli_seconds: " + elapsedTime / 1000000);

	}

	private static void Goal7(List<Car> carsList) throws IOException {
		long startTime = System.nanoTime();
		PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Paths.get("src/main/resources/goal7.txt")));
		Map<String, Map<String, Long>> multipleFieldsMap = carsList.stream().filter(car -> car.getBodyType().equalsIgnoreCase("SUV"))
		.collect(Collectors.groupingBy(Car::getBrand, 
				Collectors.groupingBy(Car::getModel, 
						Collectors.counting())));
		List<Car> Goal7List = new ArrayList<>();
		for (Map.Entry<String, Map<String, Long>> entry : multipleFieldsMap.entrySet()) {
			for(Map.Entry<String, Long> entry2 : entry.getValue().entrySet()) {
				Goal7List.add(new Car(entry.getKey(),entry2.getKey(),"SUV"));
			}
		}
		Goal7List.stream().map(Car::Goal7String).forEach(pw::println);
		pw.close();
		long elapsedTime = System.nanoTime() - startTime;
		System.out.println("\n\nTotal execution time for Goal7 in milli_seconds: " + elapsedTime / 1000000);

	}

	private static void Goal8(List<Car> carsList) throws IOException {
		long startTime = System.nanoTime();
		PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Paths.get("src/main/resources/goal8.txt")));
		carsList.stream().filter(car -> car.getOwnerType().equalsIgnoreCase("first owner")).forEach(pw::println);
		pw.close();
		long elapsedTime = System.nanoTime() - startTime;
		System.out.println("\n\nTotal execution time for Goal8 in milli_seconds: " + elapsedTime / 1000000);

	}
	

}

