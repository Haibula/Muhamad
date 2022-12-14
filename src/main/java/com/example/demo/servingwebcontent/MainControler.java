package com.example.demo.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainControler {
    static int count = 0;

    @GetMapping("/question")
    public String question(Model model) {
        return "question";
    }

    @PostMapping("/question")
    public String postQuestion(@RequestParam String question1, @RequestParam String question2, @RequestParam String question3, @RequestParam String question4, @RequestParam String question5, @RequestParam String question6, @RequestParam String question7, Model model) {

        String answer1 = "Это язык программирования с объектами, модулями, потоками, исключениями и автоматическим управлением памятью.";
        String answer2 = "Все три способа правильные";
        String answer3 = "объект, который можно назначить переменной или передать другой функции";
        String answer4 = "Все ответы правильные";
        String answer5 = "Это набор правил, которые определяют, как форматировать код для максимальной читабельности.";
        String answer6 = "Комментарии начинаются с символа #.";
        String answer7 = "Правильные ответы 1 и 2.";
        if (answer1.equals(question1)) {
            count++;
        }
        if (answer2.equals(question2)) {
            count++;
        }
        if (answer3.equals(question3)) {
            count++;
        }
        if (answer4.equals(question4)) {
            count++;
        }
        if (answer5.equals(question5)) {
            count++;
        }
        if (answer6.equals(question6)) {
            count++;
        }
        if (answer7.equals(question7)) {
            count++;
        }
        return "redirect:/answer";
    }

    @GetMapping("/answer")
    public String answer(Model model) {
        String right = "Правильных ответов " + count;
        List list = new ArrayList();
        list.add(right);
        if (count <= 2) {
            list.add("Этот результат меня огорчил. Попробуй еще раз");
        } else if (count == 4) {
            list.add("Этот результат меня не удовлетворил, продолжай попытки");
        } else if (count == 5) {
            list.add("У тебя средний результат. Молодец,но пробуй еще.");
        } else if (count == 6) {
            list.add("Уже отлично, не останавливайся осталось еще чуть чуть");
        } else if (count == 7) {
            list.add("Ты набрал максимальный балл.");
        }
        model.addAttribute("result", list);
        return "answer";
    }
}