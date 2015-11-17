package mum.cs544.controller;

import java.io.InputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;

import com.paypal.api.payments.Address;
import com.paypal.api.payments.Amount;
import com.paypal.api.payments.AmountDetails;
import com.paypal.api.payments.FundingInstrument;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.Transaction;
import com.paypal.core.rest.APIContext;
import com.paypal.core.rest.OAuthTokenCredential;
import com.paypal.core.rest.PayPalRESTException;

import mum.cs544.domain.Attendance;
import mum.cs544.domain.Course;
import mum.cs544.domain.CreditCard;
import mum.cs544.domain.Student;
import mum.cs544.service.AttendanceService;
import mum.cs544.service.CourseService;
import mum.cs544.service.InstructorService;
import mum.cs544.service.StudentService;

@Controller
public class PaymentController implements ServletContextAware {
	@Autowired
	private InstructorService instructorService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private AttendanceService attendanceService;
	
	@Autowired
	ServletContext servletContext;
	
	public void setServletContext(ServletContext servletContext) {
	     this.servletContext = servletContext;
	}
	
	@RequestMapping(value = "/payCourse", method=RequestMethod.POST)
	public String payCourse(Model model, @RequestParam Integer id) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName(); //get logged in username
	    Student student = this.studentService.getStudent(username);
	    if (student != null) {
	    	Course course = this.courseService.getCourse(id);
	    	Attendance attendance = this.attendanceService.getAttendance(student, course);
	    	if (attendance!=null) {
	    		model.addAttribute("attendance", attendance);
	    		model.addAttribute("course", course);
	    		return "viewCourse";
	    	}
	    	mum.cs544.domain.Address address = student.getAddress();
	    	CreditCard cc = new CreditCard();
	    	model.addAttribute("creditCard", cc);
	    	model.addAttribute("course", course);
	    	model.addAttribute("address", address);
	    	model.addAttribute("student", student);
	    	return "payment";
	    } else {
	    	return "redirect:/login";
	    }
	}
	
	@RequestMapping(value = "/submitPayment", method=RequestMethod.POST)
	public String submitPayment(Model model, Course course, mum.cs544.domain.Address address, mum.cs544.domain.CreditCard cc) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName(); //get logged in username
	    Student student = this.studentService.getStudent(username);
	    if (student != null) {
	    	InputStream is = this.servletContext.getResourceAsStream("/resources/sdk_config.properties");
			try {
				Payment.initConfig(is);
				//OAuthTokenCredential tokenCredential = Payment.
				//createPayment();
				//Successful payment
				course = this.courseService.getCourse(course.getId());
				Attendance attendance = new Attendance();
				attendance.setCourse(course);
				attendance.setStudent(student);
				attendance.setDate(Date.valueOf(LocalDate.now()));
				attendanceService.save(attendance);
				model.addAttribute("course", course);
				return "paymentSuccess";
			} catch (PayPalRESTException e) {
				System.out.println(e.getMessage());
			}
	    } 
		//Error return back to payment page
		return "payment";
	}
	
	@RequestMapping(value = "/paymentSuccess", method=RequestMethod.GET)
	public String paymentSuccess(Model model, Course course) {
		return "paymentSuccess";
	}
	
	public Payment createPayment() {
		// ###Address
		// Base Address object used as shipping or billing
		// address in a payment. [Optional]
		Address billingAddress = new Address();
		billingAddress.setCity("Johnstown");
		billingAddress.setCountryCode("US");
		billingAddress.setLine1("52 N Main ST");
		billingAddress.setPostalCode("43210");
		billingAddress.setState("OH");

		// ###CreditCard
		// A resource representing a credit card that can be
		// used to fund a payment.
		com.paypal.api.payments.CreditCard creditCard = new com.paypal.api.payments.CreditCard();
		creditCard.setBillingAddress(billingAddress);
		creditCard.setCvv2("111");
		creditCard.setExpireMonth("11");
		creditCard.setExpireYear("2018");
		creditCard.setFirstName("Joe");
		creditCard.setLastName("Shopper");
		creditCard.setNumber("5500005555555559");
		creditCard.setType("mastercard");

		// ###Details
		// Let's you specify details of a payment amount.
		AmountDetails details = new AmountDetails();
		details.setShipping("1");
		details.setSubtotal("5");
		details.setTax("1");

		// ###Amount
		// Let's you specify a payment amount.
		Amount amount = new Amount();
		amount.setCurrency("USD");
		// Total must be equal to sum of shipping, tax and subtotal.
		amount.setTotal("7");
		amount.setDetails(details);

		// ###Transaction
		// A transaction defines the contract of a
		// payment - what is the payment for and who
		// is fulfilling it. Transaction is created with
		// a `Payee` and `Amount` types
		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		transaction
				.setDescription("This is the payment transaction description.");

		// The Payment creation API requires a list of
		// Transaction; add the created `Transaction`
		// to a List
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions.add(transaction);

		// ###FundingInstrument
		// A resource representing a Payeer's funding instrument.
		// Use a Payer ID (A unique identifier of the payer generated
		// and provided by the facilitator. This is required when
		// creating or using a tokenized funding instrument)
		// and the `CreditCardDetails`
		FundingInstrument fundingInstrument = new FundingInstrument();
		fundingInstrument.setCreditCard(creditCard);

		// The Payment creation API requires a list of
		// FundingInstrument; add the created `FundingInstrument`
		// to a List
		List<FundingInstrument> fundingInstrumentList = new ArrayList<FundingInstrument>();
		fundingInstrumentList.add(fundingInstrument);

		// ###Payer
		// A resource representing a Payer that funds a payment
		// Use the List of `FundingInstrument` and the Payment Method
		// as 'credit_card'
		Payer payer = new Payer();
		payer.setFundingInstruments(fundingInstrumentList);
		payer.setPaymentMethod("credit_card");

		// ###Payment
		// A Payment Resource; create one using
		// the above types and intent as 'sale'
		Payment payment = new Payment();
		payment.setIntent("sale");
		payment.setPayer(payer);
		payment.setTransactions(transactions);
		Payment createdPayment = null;
		try {
			// ###AccessToken
			// Retrieve the access token from
			// OAuthTokenCredential by passing in
			// ClientID and ClientSecret
			// It is not mandatory to generate Access Token on a per call basis.
			// Typically the access token can be generated once and
			// reused within the expiry window
			Map<String, String> sdkConfig = new HashMap<String, String>();
			sdkConfig.put("mode", "sandbox");
			String accessToken = new OAuthTokenCredential("AYSq3RDGsmBLJE-otTkBtM-jBRd1TCQwFf9RGfwddNXWz0uFU9ztymylOhRS",
					"EGnHDxD_qRPdaLdZz8iCr8N7_MzF-YHPTkjs6NKYQvQSBngp4PTTVWkPZRbL").getAccessToken();

			// ### Api Context
			// Pass in a `ApiContext` object to authenticate
			// the call and to send a unique request id
			// (that ensures idempotency). The SDK generates
			// a request id if you do not pass one explicitly.
			APIContext apiContext = new APIContext(accessToken);
			// Use this variant if you want to pass in a request id
			// that is meaningful in your application, ideally
			// a order id.
			/*
			 * String requestId = Long.toString(System.nanoTime(); APIContext
			 * apiContext = new APIContext(accessToken, requestId ));
			 */

			// Create a payment by posting to the APIService
			// using a valid AccessToken
			// The return object contains the status;
			createdPayment = payment.create(apiContext);

			System.out.println("Created payment with id = " + createdPayment.getId()
					+ " and status = " + createdPayment.getState());

		} catch (PayPalRESTException e) {
			System.out.println("Error creating payment");
		}
		return createdPayment;
		
	}
}