package com.xtravision.Application;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testHomeController(){
		WebController wc = new WebController();

		String result = wc.returnRentPage(new ExtendedModelMap());
		System.out.println(result);
		assertEquals(result,"rent");
	}

	@Test
	public void testIndexController(){
		WebController wc = new WebController();

		String result = wc.returnIndexPage();
		assertEquals(result,"index");
	}

	@Test
	public void testAddingPotentialRental(){
		WebController wc = new WebController();
		ArrayList standByList = new ArrayList();
		PotentialRentalService prs = new PotentialRentalService();

		String result  = wc.addPotentialRental(new PotentialRental("Xmem","image.jpg"));
		assertEquals(result,"success");
	}

	@Test
	public void testPaymanetPage(){
		WebController wc = new WebController();

		String result = wc.returnPaymentPage(new ExtendedModelMap());
		assertEquals(result,"payment");

	}
	
}
