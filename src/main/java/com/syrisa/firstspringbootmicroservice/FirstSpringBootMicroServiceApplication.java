package com.syrisa.firstspringbootmicroservice;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.syrisa.firstspringbootmicroservice.domain.Difficulty;
import com.syrisa.firstspringbootmicroservice.domain.Region;
import com.syrisa.firstspringbootmicroservice.service.TourPackageService;
import com.syrisa.firstspringbootmicroservice.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;


@SpringBootApplication
//@RequiredArgsConstructor
public class FirstSpringBootMicroServiceApplication /* implements CommandLineRunner */{
	/*private final TourPackageService tourPackageService;
	private final TourService tourService;
	@Value("${ec.importfile}")
    private String importfile;
	*/
	public static void main(String[] args) {
		SpringApplication.run(FirstSpringBootMicroServiceApplication.class, args);
	}
/*
	private void loadToursAtStartUp() throws IOException {
		createTourPackages();
		long numOfPackages = tourPackageService.total();
		createTours("ExploreCalifornia.json");
		long numOfTours = tourService.total();
	}

	@Override
	public void run(String... args) throws Exception {
		loadToursAtStartUp();
	}



	private void createTourPackages() {
		tourPackageService.createTourPackage("BC","Backpack Cal");
		tourPackageService.createTourPackage("CC","California Calm");
		tourPackageService.createTourPackage("CH","California Hot Springs");
		tourPackageService.createTourPackage("CY","Cycle California");
		tourPackageService.createTourPackage("DS","From Desert to Sea");
		tourPackageService.createTourPackage("KC","Kids California");
		tourPackageService.createTourPackage("NW","Nature Watch");
		tourPackageService.createTourPackage("SC","Snowboard Cali");
		tourPackageService.createTourPackage("TC","Taste of California");
	}

	private void createTours(String fileToImport) throws IOException {
		TourFromFile.read(fileToImport).forEach(importedTour ->
				tourService.createTour(importedTour.getTitle(),
						importedTour.getDescription(),
						importedTour.getBlurb(),
						importedTour.getPrice(),
						importedTour.getLength(),
						importedTour.getBullets(),
						importedTour.getKeywords(),
						importedTour.getPackageType(),
						importedTour.getDifficulty(),
						importedTour.getRegion()));
	}

	private static class TourFromFile {

		private String packageType, title, description, blurb, price, length,
				bullets, keywords, difficulty, region;
		static List<TourFromFile> read(String fileToImport) throws IOException {
			return new ObjectMapper().setVisibility(FIELD, ANY).
					readValue(new FileInputStream(fileToImport), new TypeReference<List<TourFromFile>>() {});
		}
		protected TourFromFile(){}

		String getPackageType() { return packageType; }

		String getTitle() { return title; }

		String getDescription() { return description; }

		String getBlurb() { return blurb; }

		Integer getPrice() { return Integer.parseInt(price); }

		String getLength() { return length; }

		String getBullets() { return bullets; }

		String getKeywords() { return keywords; }

		Difficulty getDifficulty() { return Difficulty.valueOf(difficulty); }

		Region getRegion() { return Region.findByLabel(region); }
	}*/
}
