package com.project.coupon.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@Slf4j
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/index")
    @ResponseBody
    public String getIndexPage() {
        return "index";
    }

    @GetMapping("/")
    @ResponseBody
    public String getDefaultPage() {
        return "manage";
    }

    @GetMapping("/manage")
    @ResponseBody
    public ModelAndView getManagePage(ModelAndView modelAndView) {
        List<User> list = userRepository.findAll();
        modelAndView.setViewName("/manage");

        if(list.size() > 0) {
            modelAndView.addObject("list", list);
        }

        return modelAndView;
    }

    @PostMapping("/delete")
    @ResponseBody
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

//    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @PostMapping("/add")
    @ResponseBody
    public RedirectView addMember(@RequestParam("username") String username,
                                  @RequestParam("major") String major,
                                  @RequestParam("degree") Integer degree,
                                  @RequestParam("student_id") String student_id,
                                  @RequestParam("address") String address,
                                  @RequestParam("phone") String phone) {

        User user = User.builder()
                .username(username)
                .major(major)
                .degree(degree)
                .address(address)
                .student_id(student_id)
                .phoneNumber(phone)
                .build();

        userRepository.save(user);

        return new RedirectView("/manage");
    }
}
