package com.example.jdbcproject.controllers;

import com.example.jdbcproject.models.Drink;
import com.example.jdbcproject.models.DrinkType;
import com.example.jdbcproject.models.Food;
import com.example.jdbcproject.models.FoodType;
import com.example.jdbcproject.repositories.DrinkRepository;
import com.example.jdbcproject.repositories.DrinkTypeRepository;
import com.example.jdbcproject.repositories.FoodRepository;
import com.example.jdbcproject.repositories.FoodTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MenuController {

    @Autowired
    DrinkRepository drinkRepository;

    @Autowired
    DrinkTypeRepository drinkTypeRepository;

    @Autowired
    FoodRepository foodRepository;

    @Autowired
    FoodTypeRepository foodTypeRepository;


    @GetMapping(value = "/")
    public String displayMenu(Model model){

        createFuckingEntriesCuzHibernate();

        List<Food> allFoods = (List<Food>) foodRepository.findAll();
        List<Drink> allDrinks = (List<Drink>) drinkRepository.findAll();
        List<FoodType> allFoodTypes = (List<FoodType>) foodTypeRepository.findAll();

        List<Food> starters = new ArrayList<>();
        List<Food> mainCourse = new ArrayList<>();
        List<Food> desserts = new ArrayList<>();


        for (Food food: allFoods) {
            if(food.getFoodTypesId().equals(allFoodTypes.get(0))){
                starters.add(food);
            } else if (food.getFoodTypesId().equals(allFoodTypes.get(1))){
                mainCourse.add(food);
            } else if (food.getFoodTypesId().equals(allFoodTypes.get(2))){
                desserts.add(food);
            }
        }

        model.addAttribute("formMenuBean", new FormMenuBean());
        model.addAttribute("starters", starters);
        model.addAttribute("mainCourse", mainCourse);
        model.addAttribute("desserts", desserts);
        model.addAttribute("beverages", allDrinks);

        return "menu.html";
    }

    @PostMapping(value = "/")
    public String displayMenu(@ModelAttribute FormMenuBean formMenuBean, Model model){

        int totalCalories = 0;

        Food starter = foodRepository.findFoodByName(formMenuBean.getStarter());
        Food mainDish = foodRepository.findFoodByName(formMenuBean.getDish());
        Food dessert = foodRepository.findFoodByName(formMenuBean.getDessert());

        Drink drink = drinkRepository.findDrinkByName(formMenuBean.getBeverage());

        totalCalories += starter.getCalories()*Integer.parseInt(formMenuBean.getStartersWeight())/100;
        totalCalories += mainDish.getCalories()*Integer.parseInt(formMenuBean.getMainCourseWeight())/100;
        totalCalories += dessert.getCalories()*Integer.parseInt(formMenuBean.getDessertWeight())/100;
        totalCalories += drink.getCalories()*Integer.parseInt(formMenuBean.getAmountDrank())/100;

        System.out.println(totalCalories);

        model.addAttribute("totalCalories", totalCalories);

//      int dishCalories = Integer.parseInt(formMenuBean.getMainCourseWeight());
//      int dessertCalories = Integer.parseInt(formMenuBean.getDessertWeight());
//      int beverageCalories = Integer.parseInt(formMenuBean.getAmountDrank());



        return "totalCalories.html";
    }


    public void createFuckingEntriesCuzHibernate(){
        FoodType foodType1 = new FoodType(1,"starter");
        FoodType foodType2 = new FoodType(2,"main");
        FoodType foodType3 = new FoodType(3,"dessert");

        foodTypeRepository.saveAll(Arrays.asList(foodType1,foodType2,foodType3));

        Food food1 = new Food(1,"biscuitcake",foodType3,346);
        Food food2 = new Food(2,"cheesecake",foodType3,321);
        Food food3 = new Food(3,"pie",foodType3,237);

        Food food4 = new Food(4,"banitsa",foodType2,320);
        Food food5 = new Food(5,"chicken",foodType2,165);
        Food food6 = new Food(6,"spaghetti",foodType2,158);

        Food food7 = new Food(7,"bruschetta",foodType1,70);
        Food food8 = new Food(8,"caesarsalad",foodType1,44);
        Food food9 = new Food(9,"chickensoup",foodType1,36);

        foodRepository.saveAll(Arrays.asList(food1,food2,food3,food4,food5,food6,food7,food7,food8,food9));

        DrinkType drinkType1 = new DrinkType(1, "soft");
        DrinkType drinkType2 = new DrinkType(2, "alcohol");
        DrinkType drinkType3 = new DrinkType(3, "water");
        DrinkType drinkType4 = new DrinkType(4, "juice");

        drinkTypeRepository.saveAll(Arrays.asList(drinkType1,drinkType2,drinkType3,drinkType4));

        Drink drink1 = new Drink(1,"coke",drinkType1,39);
        Drink drink2 = new Drink(2,"fanta",drinkType2,19);
        Drink drink3 = new Drink(3,"water",drinkType3,0);

        drinkRepository.saveAll(Arrays.asList(drink1,drink2,drink3));

    }

}
