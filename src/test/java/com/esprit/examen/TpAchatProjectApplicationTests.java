package com.esprit.examen;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TpAchatProjectApplicationTests {

	@Test
	void contextLoads() {
		int k = 4;
		assertEquals(4, k);
	}

}
