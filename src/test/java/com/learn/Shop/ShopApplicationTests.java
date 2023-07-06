package com.learn.Shop;



import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;



@SpringBootTest
class ShopApplicationTests {

	@Test
	public void test(){
		int a =2;
		int b =3;
		Assert.assertEquals(a+b,5);
	}



}
