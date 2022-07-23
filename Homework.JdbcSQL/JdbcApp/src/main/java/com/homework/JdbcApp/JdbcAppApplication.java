package com.homework.JdbcApp;


import com.homework.JdbcApp.model.Address;
import com.homework.JdbcApp.model.Person;
import com.homework.JdbcApp.model.PhoneNumber;
import com.homework.JdbcApp.repository.AddressRepository;
import com.homework.JdbcApp.repository.PersonRepository;
import com.homework.JdbcApp.repository.PhoneNumberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.List;

@Slf4j
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class JdbcAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcAppApplication.class, args);

		testTask1();

		testTask2();

		testTask3();

		testTask4();

		testTask5();


	}

	private static void testTask5() {
		long idPersonAddressToBeAdded = 6;
		Address address = new Address(-1,"Romania","Bucuresti","-",idPersonAddressToBeAdded);
		AddressRepository.saveAddress(address,idPersonAddressToBeAdded);
		log.info("Address added to "+PersonRepository.getPersonById(idPersonAddressToBeAdded)+": "+AddressRepository.getAddressByPersonId(idPersonAddressToBeAdded));

		long idPersonAddressToBeUpdated = 4;
		Address oldAddressBeforeUpdate = AddressRepository.getAddressByPersonId(idPersonAddressToBeUpdated);
		Address newAddressForUpdate = new Address(-1,"Romania","Bacau","-",idPersonAddressToBeUpdated);
		log.info("Address used by "+PersonRepository.getPersonById(idPersonAddressToBeUpdated)+" before update: "+AddressRepository.getAddressByPersonId(idPersonAddressToBeUpdated));
		AddressRepository.updateAddress(newAddressForUpdate,idPersonAddressToBeUpdated);
		log.info("Address used by "+PersonRepository.getPersonById(idPersonAddressToBeUpdated)+" after update: "+AddressRepository.getAddressByPersonId(idPersonAddressToBeUpdated));
		AddressRepository.updateAddress(oldAddressBeforeUpdate,idPersonAddressToBeUpdated);

		long idPersonPhoneNumberToBeAdded = 2;
		PhoneNumber phoneNumber = new PhoneNumber(-1,"0743375656","Digi",idPersonPhoneNumberToBeAdded);
		PhoneNumberRepository.savePhoneNumber(phoneNumber,idPersonPhoneNumberToBeAdded);

		long idPersonPhoneNumberToBeUpdated = 3;
		PhoneNumber oldPhoneNumberBeforeUpdate = PhoneNumberRepository.getPhoneNumberByPersonId(idPersonPhoneNumberToBeUpdated);
		PhoneNumber newPhoneNumberForUpdate = new PhoneNumber(-1,"0756880908",oldPhoneNumberBeforeUpdate.getService_provider(),idPersonPhoneNumberToBeUpdated);
		log.info("PhoneNumber used by "+PersonRepository.getPersonById(idPersonPhoneNumberToBeUpdated)+" before update: "+PhoneNumberRepository.getPhoneNumberByPersonId(idPersonPhoneNumberToBeUpdated));
		PhoneNumberRepository.updatePhoneNumber(newPhoneNumberForUpdate,idPersonPhoneNumberToBeUpdated);
		log.info("PhoneNumber used by "+PersonRepository.getPersonById(idPersonPhoneNumberToBeUpdated)+" after update: "+PhoneNumberRepository.getPhoneNumberByPersonId(idPersonPhoneNumberToBeUpdated));
		PhoneNumberRepository.updatePhoneNumber(oldPhoneNumberBeforeUpdate,idPersonPhoneNumberToBeUpdated);
	}

	private static void testTask4() {
		List<String> serviceProviders = PhoneNumberRepository.getServiceProviders();
		for (String serviceProvider:
				serviceProviders) {
			List<Person> persons = PersonRepository.getPersonsWhoUseTheSameServiceProvider(serviceProvider);

			if(persons.size()>1){
				log.info("All people who use "+serviceProvider+" as a service provider: ");
				persons.stream().forEach((p)->log.info("- "+p));
			}
		}
	}

	private static void testTask3() {
		List<String> countries = AddressRepository.getCountries();
		for (String country:
			 countries) {
			List<Person> persons = PersonRepository.getPersonsWhoLiveInTheSameCountry(country);

			if(persons.size()>1){
				log.info("All people who live in "+country+": ");
				persons.stream().forEach((p)->log.info("- "+p));
			}
		}

		List<String> cities = AddressRepository.getCities();
		for (String city:
				cities) {
			List<Person> persons = PersonRepository.getPersonsWhoLiveInTheSameCity(city);

			if(persons.size()>1) {
				log.info("All people who live in " + city + ": ");
				persons.stream().forEach((p) -> log.info("- " + p));
			}
		}

		List<String> streets = AddressRepository.getStreets();
		for (String street:
				streets) {
			List<Person> persons =PersonRepository.getPersonsWhoLiveInTheSameStreet(street);

			if(persons.size()>1) {
				log.info("All people who live on " + street + ": ");
				persons.stream().forEach((p) -> log.info("- " + p));
			}
		}
	}

	private static void testTask2() {
		log.info("All the persons that live in the same city they were born:");
		PersonRepository.getPersonsWhoLiveInTheCityTheyWereBorn().stream().forEach((p)->log.info("- "+p));
	}

	private static void testTask1() {
		log.info("All the persons that are born before 1990:");
		PersonRepository.getPersonsBornBefore1990().stream().forEach((p)->log.info("- "+p));
	}

}
