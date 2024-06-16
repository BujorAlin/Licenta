package com.itfactory.project.user_service.console_ui;



import com.itfactory.project.user_service.dto.User;
import com.itfactory.project.user_service.service.UserDao;

import java.util.List;
import java.util.Optional;

public class MenuController {
    public static void showMenu (UserDao userDao){
        while(true){
           char c = MenuUtil.readChoice("A - Afisarea unui user dupa ID\n" +
                                     "B - Afisarea tuturor userilor\n" +
                                     "C - Introducerea unui user\n" +
                                     "D - Stergerea unui user\n" +
                                     "E - Modificarea unui user\n" +
                                     "Q - Incheiere", 'A', 'B', 'C', 'D','E', 'Q');

           switch (c){
               case 'A':
                   int id = MenuUtil.readInt("Introduceti ID asociat userului: ",false);
                   Optional<User> foundUser = userDao.getById(id);
                   if(foundUser.isPresent()){
                       System.out.println(foundUser);
                   }else{
                       System.out.println("Nu exista user cu ID: "+id);
                   }
                   break;

               case 'B':
                   List<User>  users = userDao.getAllUsers();
                   if(!users.isEmpty()){
                       users.forEach(System.out::println);
                   }else{
                       System.out.println("Nu exista nici un user de aratat!");
                   }
                   break;

               case 'C':
                   User newUser = EditUserController.readNewUser();
                   userDao.insert(newUser);
                   break;

               case 'D':
                   int idDelete = MenuUtil.readInt("Introduceti userul ce doriti sa il stergeti: ",false);
                   Optional<User> userToBeDeleted = userDao.getById(idDelete);
                   if(userToBeDeleted.isPresent()){
                       userDao.delete(idDelete);
                   }else{
                       System.out.println("Nu exista user cu ID : "+idDelete);
                   }
                   break;
               case 'E':
                   int idUpdate = MenuUtil.readInt("Introduceti ID userului pentru modificare: ",false);
                   Optional<User> userExist = userDao.getById(idUpdate);
                   if(userExist.isPresent()){
                       User userForUpdate = userExist.get();
                       User updatedUser = EditUserController.readUserForUpdate(userForUpdate,idUpdate);
                       userDao.getById(idUpdate).ifPresent(user -> userDao.update(updatedUser));
                   }else{
                       System.out.println("Nu exista user cu ID: "+idUpdate);
                   }
                   break;
               default:
                   System.out.println("La revedere!");
                   return;
           }
        }
    }
}
