package io.github.oliviercailloux.y2018.apartments.valuefunction;


import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.google.maps.model.LatLng;

import io.github.oliviercailloux.y2018.apartments.localize.Localizer;
import io.github.oliviercailloux.y2018.apartments.utils.KeyManager;

class ValueDistFunctionTest {

	private ValueDistFunction v;
	LatLng appart;
	LatLng interest1;
	LatLng interest2;
	LatLng interest3;
	String geocodeApiKey;
	
	void initializeValueDistFunction() throws Exception {
		geocodeApiKey = KeyManager.getGeocodeApiKey();
		appart = Localizer.getGeometryLocation("Ville d'Avray",geocodeApiKey);
		interest1 = Localizer.getGeometryLocation("Paris",geocodeApiKey);
		interest2 = Localizer.getGeometryLocation("Chaville",geocodeApiKey);
		interest3 = Localizer.getGeometryLocation("Roissy Charles de Gaulle",geocodeApiKey);
		v = new ValueDistFunction(appart,KeyManager.getApiKey());
		
		v.addInterestLocation(interest1);
		v.addInterestLocation(interest2);
		v.addInterestLocation(interest3);
	}
	
	@Test 
	void getSubjectiveValueTest() throws Exception{
		initializeValueDistFunction();
		Assert.assertEquals(0.90919444444, v.getSubjectiveValue(interest1), 0.1);
	}
	
	@Test
	void getMaxDurationTest() throws Exception {
		initializeValueDistFunction();
		Assert.assertEquals(5091.0, v.getMaxDuration(),0);
	}

}
