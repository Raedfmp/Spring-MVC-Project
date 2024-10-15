package de.fmp.spring.controller;


import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	
	@PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("role") String role, Model model) {
		model.addAttribute("user",username);
		model.addAttribute("password",password);
		model.addAttribute("role", role);
		int count = jdbcTemplate.queryForObject("SELECT count(*) FROM user WHERE name = ?", new Object[] {username}, Integer.class);
		
		if(count > 0) {
			return "welcome";
		}
        model.addAttribute("error", "Ungültiger Benutzername oder Passwort");
        return "login"; // Zeige die Login-Seite erneut
    }
	
	
	
	@RequestMapping("/createAccount")
	public String showCreateAccountPage() {
		return "createAccount"; // Zeigt die createAccount.jsp an
	}
	
	
	@RequestMapping("/createNewAccount")
	public String addNewUserAccount(@RequestParam("username") String username, @RequestParam("password") String password,	@RequestParam("role") String role, Model model) {

		if(username == null || password == null || role == null) {
			return "createAccount";
		}
		
		if(username.replace(" ", "").length() == 0 || password.replace(" ", "").length() == 0 || role.replace(" ", "").length() == 0) {
			return "createAccount";
		}
		
		
		String sql = "INSERT INTO user (name, password, role) VALUES(?,?,?)";
		int counter = jdbcTemplate.update(sql, username, password, role);
		if (counter > 0) {
			System.out.println("insert war OK");
		} else {
			System.out.println("insert war nicht OK");
		}

		System.out.println("addNewUserAccount()    user " + username);
		System.out.println("addNewUserAccount()    password " + password);
		System.out.println("addNewUserAccount()    role " + role);

		model.addAttribute("user", username);
		model.addAttribute("password", password);
		model.addAttribute("role", role);
		model.addAttribute("spring_message", "Try inserting user information into MariaDB.");
		return "login"; // Zeigt die createAccount.jsp an
	}

	/*
	 * die Methode super ging alles 
	@GetMapping("/to_login")
    public String redirectToLogin() {
		System.out.println("UserController.java redirectToLogin() ");
        
        return "login";
    }
    */
	
	/*
	 * die Methode wird ausgefuehrt mit dem <input
	 * <p>Already have an account? <a href="${pageContext.request.contextPath}/to_login">Login</a>
	@GetMapping("/to_login")
    public String redirectToLogin() {
		System.out.println("UserController.java redirectToLogin() ");
        // Redirect zur Login-Seite
        return "redirect:/login";
    }
    */
	
	/*from createNewAccount.jsp to login.jsp*/
	@RequestMapping("/to_login")
	public String toLogin() {
		System.out.println("UserController.java redirectToLogin() wieder OK ");
		return "login";
	}
	
	
	
    @GetMapping("/logout")
    public String handleLogout(HttpSession session) {
        session.invalidate(); // Beendet die Session
        return "login"; // Leitet zurück auf die Login-Seite
    }
    
    @GetMapping("/home")
    public String showHomePage(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login"; // Falls kein Benutzer eingeloggt ist, zurück zur Login-Seite
        }
        model.addAttribute("username", username);
        return "home"; // Zeigt home.jsp an
    }
    
    
}
