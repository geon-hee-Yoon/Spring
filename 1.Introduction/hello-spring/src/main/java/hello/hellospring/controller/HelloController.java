package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")    //웹 어플리케이션에서 슬롯?이 hello로 오면 이 메서드 홏ㄹ
    public String hello(Model model) {
        model.addAttribute("data", "h@ello !");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(name="name",required = false) String name,Model model){ //@RequestParam(value="",required=true(default 임)
      model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name")String name){
        return "hello "+name;    //"hello spring" 문자 반환
    }

    //데이터 내놔라 (json 방식)
    @GetMapping("hello-api")
    @ResponseBody   //35: 객체반환 하고 @ResponseBody 해놓으면 json 반환이 기본
    public Hello helloApi(@RequestParam("name")String name){
        Hello hello=new Hello();
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