import java.util.ArrayList;

public class Payment {
	private String method;
	private String CVV;

	public Payment(String method, String CVV) {
		this.method = method;
		this.CVV = CVV;
	}

	public String getMethod() {
		return method;
	}

	public String getCVV() {
		return CVV;
	}

	public static void addPayment(ArrayList<Payment> paymentList, Payment p1) {
		// TODO Auto-generated method stub
	}

	public static void viewPayment(ArrayList<Payment> paymentList, Payment p1) {
		// TODO Auto-generated method stub
	}

	public static void deletePayment(ArrayList<Payment> paymentList, Payment p1) {
		// TODO Auto-generated method stub
	}
}
