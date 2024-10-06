package com.kamal.SpringBootWebApp;


import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "index.jsp"; //viewName
    }
//    @RequestMapping("/add")
//    public String add(HttpServletRequest req, HttpSession session){
//        Integer num1 = Integer.parseInt(req.getParameter("num1"));
//        Integer num2 = Integer.parseInt(req.getParameter("num2"));
//
//        int result = num1 + num2;
//        System.out.println(result);
//
//        session.setAttribute("num1", num1);
//        session.setAttribute("num2", num2);
//        session.setAttribute("result", result);
//        return "result.jsp";
//    }
@RequestMapping("/add")
public String add(@RequestParam("num1") int num1, @RequestParam("num2") int num2, Model model){
    int result = num1 + num2;

//    session.setAttribute("num1", num1);
//    session.setAttribute("num2", num2);
//    session.setAttribute("result", result);

    model.addAttribute("result", result);
    return "result.jsp";
}
}
