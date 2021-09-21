package com.safetynet.server.mapping;

import com.safetynet.database.entities.AddressEntity;
import com.safetynet.database.entities.AllergeneEntity;
import com.safetynet.database.entities.MedicationEntity;
import com.safetynet.database.entities.PersonEntity;
import com.safetynet.models.FirestationJson;
import com.safetynet.models.MedicalRecordJson;
import com.safetynet.models.PersonJson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapstructMapper {

	AllergeneEntity allergeneEntity = new AllergeneEntity();
	AddressEntity addressEntity = new AddressEntity();
	PersonEntity personEntity = new PersonEntity();
	MedicationEntity MEDICINE_ENTITY = new MedicationEntity();


	MapstructMapper INSTANCE = Mappers.getMapper(MapstructMapper.class);

	@Mapping(source = "firstName", target = "firstName")
	@Mapping(source = "lastName", target = "lastName")
	@Mapping(source = "phone", target = "phone")
	@Mapping(source = "email", target = "email")
	@Mapping(source = "address", target = "address")
	@Mapping(source = "city", target = "city")
	@Mapping(source = "zip", target = "zip")
	PersonEntity personJsonToPersonEntity(PersonJson personJson);



	@Mapping(source = "station", target = "station", qualifiedByName = "toto")
	AddressEntity firestationsToAddressEntity(FirestationJson firestationJson);


	@Mapping(source = "allergies", target ="allergene", qualifiedByName = "enrichAllergenEntityWithAllergies")
	AllergeneEntity medicalRecordtoAllergeneEntity(MedicalRecordJson medicalRecordJson);

	@Mapping(source = "birthdate", target = "birthdate", qualifiedByName = "enrichPersonEntityWithBirthdate")
	PersonEntity medicalRecordToPersonEntity(MedicalRecordJson medicalRecordJson);


	//Récupere la birthdate à partir du firstName/lastName
	@Named("enrichPersonEntityWithBirthdate")
	default String getPersonEntity(String birthdate) {
		return null;
	}

	//Récupère la station à partir de l'adresse
	@Named(value = "toto")
	default int getAddressEntity(int station) {
		return 0;
	}


	//Récupère la liste d'allergies
	@Named("enrichAllergenEntityWithAllergies")
	default String getAllergeneEntity(String[] allergies) {
		return null;
	}


}
