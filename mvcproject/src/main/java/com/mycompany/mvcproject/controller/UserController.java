package com.mycompany.mvcproject.controller;

import com.mycompany.mvcproject.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("signup")
    public String signup(Model model){
        User user = new User();
        model.addAttribute("user", user);

        return "signup";
    }

    // @RequestMapping(value = "/signup", method = RequestMethod.POST) // 아랫줄과 같은 의미
    @PostMapping("/signup")
    //@ResponseBody // Body는 html의 body와 비슷한 의미. View 페이지가 아니라 data 그대로 String 응답.
    public String signup(
            //@ModelAttribute("user") User user // 아랫줄과 같은 의미. 이름이 다른 경우 value 넣으면 됨.
            @ModelAttribute User user,
            Model model
    )  {
        System.out.println(user);
        // return "success"; // 원래대로라면 views의 success.jsp를 찾아야 하지만, ResponseBody때문에 String Data 그대로 요청.
        // return "redirect:/hello"; // 가입 한 후 /hello // 내부 URL의 경우
        return "redirect:http://www.naver.com"; // 외부 URL
    }

    @GetMapping("/login")
    public String login(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

//    @PostMapping("/login")
//    public String login(@ModelAttribute User user, Model model){
//            System.out.println("user email = " + user.getEmail());
//            System.out.println("user email = " + user.getPassword());
//
//            if(User.DEFAULT_EMAIL.equals(user.getEmail()) && User.DEFAULT_PASSWORD.equals(user.getPassword())){
//                model.addAttribute("message", "You are now logged in.");
//                return "loginSuccess";
//            }
//            else {
//                return "redirect:/user/login";
//            }
//    }

    @PostMapping("/login")
    public String login(
            @RequestParam String email, @RequestParam String password, // HTTP 요청 매개 변수에서 자격 증명을 가져 옴
            Model model
    ){
        System.out.println("user email = " + email);
        System.out.println("user password = " + password);

        User user = new User();
        user.setEmail(email);
        user.setpassword(password);
        boolean result = user.login();
        if(result){
            model.addAttribute("message", "로그인 성공");
        }
        else model.addAttribute("message", "로그인 실패");
        return "login";
    }
}
