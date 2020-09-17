package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {  //스프링은 기본적으로 싱글톤으로 등록한다. 따라서 같은 스프링 빈이면 모두 같은 인스턴스이다.

    @GetMapping("hellok")
    public String hello(Model model){
        model.addAttribute("data", "hi");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String HelloMvc(@RequestParam(value = "name", required = true) String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //http에서 body 부분에 내가 데이터를 직접 넣어 주겠다
    public String helloString(@RequestParam("name") String name) {
        return "hello " +name; // -> hello spring
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
