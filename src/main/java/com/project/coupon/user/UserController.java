package com.project.coupon.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.jws.soap.SOAPBinding;
import javax.xml.ws.RequestWrapper;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@Slf4j
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/index")
    public String getIndexPage() {
        return "index";
    }

    @GetMapping("/")
    public String getDefaultPage() {
        return "manage";
    }

    @GetMapping("/manage")
    public ModelAndView getManagePage(ModelAndView modelAndView) {
        List<User> list = userRepository.findAll();
        modelAndView.setViewName("/manage");

        if(list.size() > 0) {
            modelAndView.addObject("list", list);
        }

        return modelAndView;
    }

    @PostMapping("/delete")
    public RedirectView deleteMember(@RequestParam(value = "checkBox[]") List<String> userList) {
        int user_id = 0;
        int result = -1;

        for(String i : userList) {
            user_id = Integer.parseInt(i);
            this.userRepository.deleteById(user_id);
        }

        this.userRepository.flush();
        return new RedirectView("/manage");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public RedirectView addMember(@RequestParam("username") String username,
                                  @RequestParam("dept") String dept,
                                  @RequestParam("degree") Integer degree,
                                  @RequestParam("student_id") String student_id,
                                  @RequestParam("address") String address,
                                  @RequestParam("phone") String phone) {

        LocalDate localDate = LocalDate.now();

        User user = new User(student_id, username, dept, degree, phone, address, localDate);
        userRepository.save(user);

        return new RedirectView("/manage");
    }
}
