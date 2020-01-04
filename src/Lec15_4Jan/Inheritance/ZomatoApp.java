package Lec15_4Jan.Inheritance;

public class ZomatoApp {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		Menu();
	}

	public static void Menu() throws Exception{

		System.out.println("Welcome to BurgerKing");

//		try {
			addToCart();
//		} catch (Exception e) {

			System.out.println("Payment is Failed");
//			e.printStackTrace();
//		}
		
		
		System.out.println("Enter the order again!!!!");
	}

	public static void addToCart() throws Exception {

		System.out.println("Fiery chicken burger added");
		paymentGateway();
		
		System.out.println("Enter");
	}

	public static void paymentGateway() throws Exception {

		System.out.println("Paywith Google pay");

		throw new Exception("Payment Failed");

//		System.out.println("Transaction complete");
	}

}
